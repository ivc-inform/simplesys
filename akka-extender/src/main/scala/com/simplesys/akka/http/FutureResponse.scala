package com.simplesys.akka.http

import java.nio.charset.Charset

import com.simplesys.control.ControlStructs._
import com.simplesys.servlet.http.{HeaderString, HttpServletResponse}

trait FutureResponse extends (HttpServletResponse => Unit) {
    def apply(res: HttpServletResponse)
    def onComplete: PartialFunction[Option[Throwable], Unit]
}

object FutureResponse {

    def apply(func: HttpServletResponse => Unit): FutureResponse = new FutureResponse {
        def apply(res: HttpServletResponse) {
            func(res)
        }
        def onComplete = {
            case _ =>
        }
    }

    def apply(statusCode: Int, msg: String, headers: (String, String)*): FutureResponse = apply {
        res =>
            res.CharacterEncoding = Charset.defaultCharset()
            headers.foreach {
                case (name, value) => res += HeaderString(name, value)
            }
            res Status = statusCode
            using(res Writer) {
                writer => writer write msg
            }
            res.FlushBuffer
    }

    def error(statusCode: Int, headers: (String, String)*): FutureResponse = apply {
        res =>
            res.CharacterEncoding = Charset.defaultCharset()
            headers.foreach {
                case (name, value) => res += HeaderString(name, value)
            }
            res.SendError(statusCode)
    }
}

