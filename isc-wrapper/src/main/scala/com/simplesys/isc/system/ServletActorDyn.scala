package com.simplesys.isc.system

import java.io.{File, FileInputStream}
import javax.servlet.ServletOutputStream

import akka.actor.ActorSystem
import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn
import com.simplesys.isc.dataBinging.{DSResponseDyn, DSResponseFailureDyn}
import com.simplesys.isc.system.global.RuntimeIscException
import com.simplesys.isc.system.typesDyn.PageHtml
import com.simplesys.isc.templates.logJSActor
import com.simplesys.jdbc.control.{ValidationEx, ValidationResult}
import com.simplesys.json.JsonObject
import com.simplesys.servlet.http.HeaderString
import com.simplesys.servlet.{OctetStreamContent, ServletActor, SomeContent}
import com.simplesys.common.Strings._

import scala.util.Try

trait ServletActorDyn extends ServletActor {

    def Out(classDyn: ClassDyn)(implicit system: ActorSystem): Unit = {
        classDyn match {
            case dsResponse: DSResponseDyn =>
                super.Out(logJSActor(dsResponse.WrapResponseObject))
            case js =>
                super.Out(logJSActor(js))
        }
    }

    def Out[T <: ClassDyn](array: ArrayDyn[T])(implicit system: ActorSystem): Unit = super.Out(logJSActor(array))

    def Out(page: PageHtml)(implicit system: ActorSystem): Unit = super.Out(page)

    def OutStatus(status: Int)(implicit system: ActorSystem) = Out(new DSResponseDyn {
        Status = status
        TotalRows = 0
    })

    def OutOk(implicit system: ActorSystem) = OutStatus(RPCResponseDyn.statusSuccess)

    def OutFailure(text: String)(implicit system: ActorSystem) = super.Out(new DSResponseFailureDyn(throw new RuntimeException(text)))

    def OutFailure(result: ValidationEx[_])(implicit system: ActorSystem) = super.Out(
        result printException match {
            case None =>
                throw RuntimeIscException("Invalid branch")
            case Some(ValidationResult(message, stackTrace)) =>
                new DSResponseDyn {
                    Status = RPCResponseDyn.statusFailure
                    Data = JsonObject(
                        "error" ->
                          JsonObject(
                              ("message" -> message),
                              ("stackTrace" -> stackTrace)))
                }

        }
    )

    def OutFailure(e: Throwable)(implicit system: ActorSystem) = {
        val validationResult = ValidationEx getValidationException e
        Out(
            new DSResponseDyn {
                Status = RPCResponseDyn.statusFailure
                Data = JsonObject(
                    "error" ->
                      JsonObject(
                          "message" -> validationResult.message,
                          "stackTrace" -> validationResult.stackTrace))
            })
    }

    def OutFromIsc(isc: QueuesDyn) = Out(isc.getCommandLine)

    def OutFile(file: File): Try[Boolean] =
        Try {
            val fileName = file.getName

            (servletContext MimeType fileName) match {
                case None ⇒
                    response.ContentType = Some(OctetStreamContent)
                case Some(contentType) ⇒
                    response.ContentType = Some(SomeContent(contentType))

            }

            val inStream = new FileInputStream(file)
            response.ContentLengthLong = file.length()
            response += HeaderString("Content-Disposition", s"attachment; filename=${fileName.dblQuoted}")

            val outStream: ServletOutputStream = response.OutputStream
            val buffer = new Array[Byte](4096)
            var bytesRead = -1

            while ( {
                bytesRead = inStream read buffer
                bytesRead
            } != -1) {
                outStream.write(buffer, 0, bytesRead)
            }

            inStream.close()
            outStream.close

            true
        }
}
