package com.simplesys.akka.http.sse

import java.nio.charset.Charset

import com.simplesys.control.ControlStructs._
import com.simplesys.servlet.http.HeaderString
import com.simplesys.servlet.http.sse.SseServletResponse

trait SseFutureResponse extends (SseServletResponse => Unit) {
    def apply(res: SseServletResponse)
    def onComplete: PartialFunction[Option[Throwable], Unit]
}

object SseFutureResponse {

    def apply(func: SseServletResponse => Unit): SseFutureResponse = new SseFutureResponse {
        def apply(res: SseServletResponse) {
            func(res)
        }
        def onComplete = {
            case _ =>
        }
    }

    def apply(statusCode: Int, msg: String, headers: (String, String)*): SseFutureResponse = apply {
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

    def error(statusCode: Int, headers: (String, String)*): SseFutureResponse = apply {
        res =>
            res.CharacterEncoding = Charset.defaultCharset()
            headers.foreach {
                case (name, value) => res += HeaderString(name, value)
            }
            res.SendError(statusCode)
    }
}