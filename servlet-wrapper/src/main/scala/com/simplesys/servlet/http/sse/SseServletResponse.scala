package com.simplesys.servlet.http.sse

import javax.servlet.http.{HttpServletResponse ⇒ JHttpServletResponse}
import javax.servlet.{ServletResponse ⇒ JServletResponse}

import com.simplesys.common.Strings._
import com.simplesys.config.Config
import com.simplesys.servlet.ServletResponse._
import com.simplesys.servlet.http._
import com.simplesys.servlet.{EventStreamContent, ServletResponse}
import io.circe.Json.{JArray, JNull, JObject, JString}
import io.circe.{Json, JsonObject}

import scala.io.Codec._

object SseServletResponse extends ConstantResponse {
    def apply(response: JHttpServletResponse): SseServletResponse = new SseServletResponse(response)

    def apply(response: JServletResponse): SseServletResponse = response match {
        case response: JHttpServletResponse => SseServletResponse(response)
        case _ => throw new RuntimeException("Ожидался HttpServletResponse.")
    }

    def apply(response: ServletResponse): SseServletResponse = apply(response.proxy)
}

class SseServletResponse(override protected[servlet] val proxy: JHttpServletResponse) extends HttpServletResponse(proxy) with Config {

    //SendRetry(getInt("messaging.connectTimeout"))
    ContentType = EventStreamContent + UTF8
    this ++= (CacheControlNoCache, ConnectionClose, PragmaNoCache, HeaderLocalDateTime("Expires", System.currentTimeMillis()))

    def SendMessage(data: Json, event: Option[SseEvent], id: Option[SseID], channels: Vector[SseChannel]) {
        val out = Writer

        for (ev <- event)
            if (!out.checkError())
                out write s"event:${ev.serrialize}".newLine

        val _channels = JArray(channels.map(item => JString(item.serrialize)))

        val _data: Json = channels.length match {
            case 0 ⇒
                data
            case _ ⇒
                JObject(JsonObject.from("data" -> data, "channels" -> _channels))
        }

        _data match {
            case JString(string) =>
                val templ = """(.*)(\s*)""".r("line", "spacer")

                for (x <- templ findAllMatchIn string) {
                    if (!out.checkError())
                        out write s"data:${x.group("line")}".newLine
                }

            case JObject(obj) =>
                if (!out.checkError())
                    out write s"data:${obj.toString()}".newLine

            case JArray(list) =>
                if (!out.checkError())
                    out write s"data:${list.toString()}".newLine

            case x@Json.Null =>
                if (!out.checkError())
                    out write s"data:${x.toString()}".newLine

            case any =>
                throw new RuntimeException(s"Bad branch. ${any}")
        }

        for (_id <- id)
            if (!out.checkError())
                out write s"id:${_id.serrialize}".newLine

        if (!out.checkError())
            out write newLine // Чисто для красоты и удобочитаемости

        if (!out.checkError())
            out.flush()
    }

    def SendMessage(data: Json, event: Option[SseEvent], id: Option[String], channels: Json): Unit = {

        val _id: Option[SseID] = id match {
            case None => None
            case Some(string) => Some(SseStringID(string))
        }

        channels match {
            case JArray(channels) ⇒
                val _channels: Vector[SseChannel] = channels.length match {
                    case 0 => Vector.empty[SseChannel]
                    case _ =>
                        channels.map(
                            _ match {
                                case JString(string) => SseStringChannel(string)
                                case any => throw new RuntimeException(s"Bad branch. ${any}")
                            }
                        )
                }

                SendMessage(data = data, event = event, id = _id, channels = _channels)

            case _ ⇒
        }
    }

    //Задержка для повторного реконнекта, выполняющегося броузером автоматически при закрытии соединения. ms
    def SetConnectionTimeout(delay: Int) {
        val out = Writer

        if (!out.checkError())
            out write s"retry:${delay}".newLine

        if (!out.checkError())
            out.flush()
    }

    override def LogAll(addComment: String = "") {
        super.LogAll(addComment)
        addComment match {
            case "" => logger trace (s" ////////////////// SseServletResponse ////////////////////////////")
            case _ => logger trace (s" ////////////////// SseServletResponse : (${addComment})////////////////////////////")
        }
        logger trace (s"ContentType: ${ContentType}")
        logger trace " ////////////////// End SseServletResponse ////////////////////////"
    }
}
