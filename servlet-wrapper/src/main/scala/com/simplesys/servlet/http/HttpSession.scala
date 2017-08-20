package com.simplesys.servlet.http

import javax.servlet.http.{HttpSession => JHttpSession}
import com.simplesys.config.Config
import org.joda

import collection.immutable.SortedMap
import com.simplesys.log.Logging
import collection.JavaConversions._
import com.simplesys.common._
import java.util.Date

object HttpSession {
    def apply(proxy: JHttpSession) = new HttpSession(proxy)
}

class HttpSession(protected val proxy: JHttpSession) extends Config with Logging {

    def CreationTime = new org.joda.time.DateTime(proxy getCreationTime)

    def Id = proxy getId

    def LastAccessedTime = new org.joda.time.DateTime(proxy getLastAccessedTime)

    def ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)

    def MaxInactiveInterval: Long = proxy.getMaxInactiveInterval * 1000
    def MaxInactiveInterval_=(interval: Long) = proxy setMaxInactiveInterval ((interval / 1000).toInt)

    def Attributes: SortedMap[String, Option[Any]] =
        (proxy.getAttributeNames map {
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