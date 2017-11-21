package com.simplesys.servlet

import java.io.IOException
import java.util.Locale
import javax.servlet.http.{HttpServletResponse ⇒ JHttpServletResponse}
import javax.servlet.{ServletOutputStream, ServletResponse ⇒ JServletResponse}

import com.simplesys.circe.Circe._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.log.Logging
import com.simplesys.servlet.http.HttpServletResponse
import com.simplesys.servlet.http.sse.SseServletResponse
import com.simplesys.xml.Elem
import io.circe.Json

import scala.io.Codec

object ServletResponse {
    def apply(response: JServletResponse) = new ServletResponse(response)

    implicit def content2Opt(content: Content): Option[Content] = Some(content)

    implicit def jServletResponse2ServletResponse(response: ServletResponse): JServletResponse = response.proxy
    implicit def servletResponse2JServletResponse(response: JServletResponse): ServletResponse = new ServletResponse(response)
}

class ServletResponse(protected[servlet] val proxy: JServletResponse) extends Logging {

    def BufferSize = proxy getBufferSize
    def BufferSize_=(value: Int) {
        proxy setBufferSize value
    }

    def CharacterEncoding: Codec = proxy getCharacterEncoding
    def CharacterEncoding_=(charset: Codec) {
        proxy setCharacterEncoding charset.toString()
    }

    def ContentType: Option[Content] = Content.getObject(proxy getContentType)
    def ContentType_=(value: Option[Content]) {
        value match {
            case None =>
            case Some(value) =>
                if (proxy.getContentType !== value.toString)
                    proxy setContentType value.toString
        }
    }

    def Locale = proxy getLocale
    def Locale_=(value: Locale) {
        proxy setLocale value
    }

    def Print(elem: Elem) {
        Print(elem.toUnEscapeString)
    }

    def PrintAndClose(elem: Elem) {
        PrintAndClose(elem.toUnEscapeString)
    }

    def PrintAndFlush(elem: Elem) {
        PrintAndFlush(elem.toUnEscapeString)
    }
    
    def PrintAndFlush(json: Json, prettyString: Boolean = false) {
        if (prettyString)
            PrintAndFlush(json.spaces41)
        else
            PrintAndFlush(json.noSpaces1)

    }

    def Print(json: Json, prettyString: Boolean = false) {
        if (prettyString)
            Print(json.spaces41)
        else
            Print(json.noSpaces1)
    }

    def PrintAndClose(json: Json, prettyString: Boolean = false) {
        if (prettyString)
            PrintAndClose(json.spaces41)
        else
            PrintAndClose(json.noSpaces1)
    }

    def Print(str: String) {
        Writer write str
    }

    def Print(str: Json) {
        Writer write str.noSpaces
    }

    def PrintAndFlush(str: String) {
        Writer write str
        Writer.flush()
    }

    def PrintAndClose(str: String) {
        Writer write str
        Writer close()
    }

    @throws(classOf[IOException])
    def Writer = proxy getWriter

    proxy setCharacterEncoding "utf-8"
    proxy setContentType "text/html"

    def LogAll(addComment: String = "") {
        addComment match {
            case "" => logger trace (s" ////////////////// ServletResponse ////////////////////////////")
            case _ => logger trace (s" ////////////////// ServletResponse : (${addComment})////////////////////////////")
        }
        logger trace (s"BufferSize: ${BufferSize}")
        logger trace (s"CharacterEncoding: ${CharacterEncoding}")
        logger trace (s"ContentType: ${ContentType}")
        logger trace (s"Locale: ${Locale}")
        logger trace " ////////////////// End ServletResponse ////////////////////////"
    }

    @throws(classOf[IOException])
    def OutputStream: ServletOutputStream = proxy getOutputStream()

    def ContentLength: Int = ???
    def ContentLength_=(len: Int) {
        proxy setContentLength len
    }

    def ContentLengthLong: Long = ???
    def ContentLengthLong_=(len: Long) {
        proxy setContentLengthLong len
    }

    @throws(classOf[IOException])
    def FlushBuffer(): Unit = proxy flushBuffer()

    def ResetBuffer(): Unit = proxy resetBuffer()
    def IsCommitted: Boolean = proxy isCommitted

    def Reset(): Unit = proxy reset()

    def toHttp: HttpServletResponse = HttpServletResponse(this)
    def toSse: SseServletResponse = SseServletResponse(this)

}
