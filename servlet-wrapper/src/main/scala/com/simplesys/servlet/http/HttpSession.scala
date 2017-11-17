package com.simplesys.servlet.http

import java.time.LocalDateTime
import javax.servlet.http.{HttpSession ⇒ JHttpSession}

import com.simplesys.common._
import com.simplesys.common.Strings._
import com.simplesys.config.Config
import com.simplesys.log.Logging

import scala.collection.JavaConverters._
import scala.collection.immutable.SortedMap

object HttpSession {
    def apply(proxy: JHttpSession) = new HttpSession(proxy)
}

class HttpSession(protected val proxy: JHttpSession) extends Config with Logging {

    def CreationTime: LocalDateTime = proxy.getCreationTime.toLocalDateTime

    def Id = proxy getId

    def LastAccessedTime: LocalDateTime = proxy.getLastAccessedTime.toLocalDateTime

    def ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)

    def MaxInactiveInterval: Long = proxy.getMaxInactiveInterval * 1000
    def MaxInactiveInterval_=(interval: Long) = proxy setMaxInactiveInterval ((interval / 1000).toInt)

    def Attributes: SortedMap[String, Option[Any]] =
        (proxy.getAttributeNames.asScala map {
            case attr: String => attr -> Option(proxy.getAttribute(attr))
        } toMap) To

    def Attributes_=(attrs: Map[String, Option[Any]]) {
        attrs foreach {
            case (name, value) => Attribute(name, value)
        }
    }

    def LogAttributes {
        logger trace " ////////////////// Attributes HttpSession ////////////////////////////"
        Attributes foreach {
            case (name, value) =>
                logger trace (s"${name} : ${value.getOrElse("null")}")
        }
        logger trace " ////////////////// End Attributes HttpSession ////////////////////////"
    }

    def LogSession {
        logger trace " ////////////////// HttpSession ////////////////////////////"
        logger trace (s"CreationTime: ${CreationTime}")
        logger trace (s"Id : ${Id}")
        logger trace (s"LastAccessedTime: ${LastAccessedTime}")
        ServletContext.LogServletContext
        logger trace (s"MaxInactiveInterval: ${MaxInactiveInterval}")
        LogAttributes
        logger trace (s"IsNew: ${IsNew}")
        logger trace " ////////////////// End HttpSession ////////////////////////"
    }

    def Attribute(name: String): Option[Any] = Option(proxy getAttribute name)
    def Attribute(name: String, value: Option[Any]) {
        logger trace (s"setAttribute(${name}, ${value.getOrElse(null)})")
        proxy setAttribute(name, value.getOrElse(null))
    }

    def RemoveAttribute(name: String) {
        proxy removeAttribute name
    }

    def Invalidate() {
        proxy invalidate()
    }

    def IsNew: Boolean = proxy.isNew

}
