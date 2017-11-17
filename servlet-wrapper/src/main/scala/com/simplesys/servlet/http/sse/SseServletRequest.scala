package com.simplesys.servlet.http.sse

import javax.servlet.http.{HttpServletRequest ⇒ JHttpServletRequest}
import javax.servlet.{ServletRequest ⇒ JServletRequest}

import com.simplesys.common.Strings._
import com.simplesys.servlet.ServletRequest
import com.simplesys.servlet.http.HttpServletRequest
import io.circe.Json
import io.circe.Json.JArray
import io.circe.parser._

import scala.io.Codec

object SseServletRequest {
    def apply(request: JHttpServletRequest): SseServletRequest = new SseServletRequest(request)

    def apply(request: JServletRequest): SseServletRequest = request match {
        case request: JHttpServletRequest => SseServletRequest(request)
        case _ => throw new RuntimeException("Ожидался HttpServletRequest.")
    }

    def apply(request: ServletRequest): SseServletRequest = apply(request.proxy)
}

class SseServletRequest(override protected[servlet] val proxy: JHttpServletRequest) extends HttpServletRequest(proxy) {

    def SessionID: String = Session.get.Id

    def SubscribedChannels: Set[String] = Parameter("subscribedChannels") match {
        case None =>
            Set.empty[String]
        case Some(subscribedChannels) =>
            parse(subscribedChannels).getOrElse(Json.Null)
            match {
                case Json.Null ⇒
                    Set.empty[String]
                case JArray(array) ⇒
                    Set(array.toString())
                case _ ⇒
                    Set.empty[String]
            }
    }

    def EventStream: Boolean = Parameter("eventStream") match {
        case None => false
        case Some(value) => value.asBoolean
    }

    def Encoding: Codec = Parameter("encoding") match {
        case None => Codec.defaultCharsetCodec
        case Some(x) => x
    }

    def Log(label: String) {
        logger trace (s" //////////////////Sse Servlete Request (${label}) ////////////////////////")
        logger trace (s"SessionID: ${SessionID}")
        logger trace (s"EventStream: ${EventStream}")
        logger trace (s"SubscribedChannels: ${SubscribedChannels.mkString("[", ",", "]")}")
        logger trace (s"Encoding: ${Encoding}")
        logger trace (s" //////////////////End of Sse Servlete Request (${label}) ///////////////// /n")
    }

    override def LogAll {
        LogAll("unknown")
    }

    override def LogAll(label: String) {
        super.LogAll(label)
        Log(label)
    }
}
