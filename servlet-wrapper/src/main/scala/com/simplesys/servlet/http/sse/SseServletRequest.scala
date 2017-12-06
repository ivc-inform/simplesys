package com.simplesys.servlet.http.sse

import javax.servlet.http.{HttpServletRequest ⇒ JHttpServletRequest}
import javax.servlet.{ServletRequest ⇒ JServletRequest}

import com.simplesys.common.Strings._
import com.simplesys.servlet.ServletRequest
import com.simplesys.servlet.http.HttpServletRequest
import io.circe.Json

import scala.io.Codec
import io.circe.parser._

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
            Set.empty
        case Some(subscribedChannels) =>
            parse(subscribedChannels) match {
                case Right(json) ⇒
                    if (json.isObject)
                        json.asObject match {
                            case None ⇒
                                Set.empty
                            case Some(obj) ⇒
                                obj.toMap.map {
                                    case (key, _) => key
                                }.toSet
                        }
                    else if (json.isArray)
                        json.asArray match {
                            case None ⇒ Set.empty
                            case Some(array) ⇒ array.map {
                                item ⇒
                                    if (item.isString)
                                        item.asString
                                    else if (item.isNumber)
                                        item.asNumber.map(_.toString)
                                    else
                                        None
                            }.filter(_.isDefined).map(_.get).toSet
                        }
                    else
                        Set.empty
                case Left(_) ⇒ Set.empty
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
