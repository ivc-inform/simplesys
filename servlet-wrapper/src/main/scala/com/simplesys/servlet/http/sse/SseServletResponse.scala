package com.simplesys.servlet.http.sse

import javax.servlet.http.{HttpServletResponse ⇒ JHttpServletResponse}
import javax.servlet.{ServletResponse ⇒ JServletResponse}

import com.simplesys.common.Strings._
import com.simplesys.config.Config
import com.simplesys.servlet.ServletResponse._
import com.simplesys.servlet.http._
import com.simplesys.servlet.{EventStreamContent, ServletResponse}
import io.circe.Json.{JArray, JNull, JObject, JString}
import io.circe.{Json, JsonObject, SseServletResponseCirce}

import scala.io.Codec._

object SseServletResponse extends ConstantResponse {
    def apply(response: JHttpServletResponse): SseServletResponse = new SseServletResponse(response)

    def apply(response: JServletResponse): SseServletResponse = response match {
        case response: JHttpServletResponse => SseServletResponse(response)
        case _ => throw new RuntimeException("Ожидался HttpServletResponse.")
    }

    def apply(response: ServletResponse): SseServletResponse = apply(response.proxy)
}

class SseServletResponse(override protected[servlet] val proxy: JHttpServletResponse) extends HttpServletResponse(proxy) with SseServletResponseCirce with Config {

    //SendRetry(getInt("messaging.connectTimeout"))
    ContentType = EventStreamContent + UTF8
    this ++= (CacheControlNoCache, ConnectionClose, PragmaNoCache, HeaderLocalDateTime("Expires", System.currentTimeMillis()))

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
