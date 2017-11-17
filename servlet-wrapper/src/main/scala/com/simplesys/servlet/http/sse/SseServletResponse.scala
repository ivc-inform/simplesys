package com.simplesys.servlet.http.sse

import javax.servlet.http.{HttpServletResponse ⇒ JHttpServletResponse}
import javax.servlet.{ServletResponse ⇒ JServletResponse}

import com.simplesys.common.Strings._
import com.simplesys.config.Config
import com.simplesys.json._
import com.simplesys.servlet.ServletResponse._
import com.simplesys.servlet.http._
import com.simplesys.servlet.{EventStreamContent, ServletResponse}

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

    def SendMessage(data: JsonElement, event: Option[SseEvent], id: Option[SseID], channels: List[SseChannel]) {
        val out = Writer

        for (ev <- event)
            if (!out.checkError())
                out write s"event:${ev.serrialize}".newLine

        val _channels: JsonList = JsonList(channels.map(item => JsonString(item.serrialize)): _*)

        val _data: JsonElement = channels.length match {
            case 0 => data
            case _ => JsonObject("data" -> data, "channels" -> _channels)
        }

        _data match {
            case JsonString(string) =>
                val templ = """(.*)(\s*)""".r("line", "spacer")

                for (x <- templ findAllMatchIn string) {
                    if (!out.checkError())
                        out write s"data:${x.group("line")}".newLine
                }

            case obj: JsonObject =>
                if (!out.checkError())
                    out write s"data:${obj.toString()}".newLine

            case list: JsonList =>
                if (!out.checkError())
                    out write s"data:${list.toString()}".newLine

            case x: JsonEmpty.type =>
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

    def SendMessage(data: JsonElement, event: Option[SseEvent], id: Option[String], channels: JsonList): Unit = {

        val _id: Option[SseID] = id match {
            case None => None
            case Some(string) => Some(SseStringID(string))
        }

        val _channels: List[SseChannel] = channels.length match {
            case 0 => List.empty[SseChannel]
            case _ =>
                channels.map(
                    _ match {
                        case JsonString(string) => SseStringChannel(string)
                        case any => throw new RuntimeException(s"Bad branch. ${any}")
                    }
                ).toList
        }

        SendMessage(data = data, event = event, id = _id, channels = _channels)
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
