package com.simplesys.servlet

import java.io.{File, InputStream}
import java.net.MalformedURLException
import java.util.EventListener
import javax.servlet.{ServletException, SessionTrackingMode, FilterRegistration => JFilterRegistration, ServletContext => JServletContext, ServletRegistration => JServletRegistration, Servlet => JServlet}

import com.simplesys.common._
import com.simplesys.log.Logging

import scala.collection.JavaConversions._
import scala.collection.SortedMap
import scala.collection.immutable.SortedSet

object ServletContext {
    def apply(proxy: JServletContext) = new ServletContext(proxy)
    val tempDir = JServletContext.TEMPDIR
    val orderedLibs = JServletContext.ORDERED_LIBS
}

class ServletContext(protected[servlet] val proxy: JServletContext) extends Logging {

    def Attributes: SortedMap[String, Option[Any]] =
        (proxy.getAttributeNames map {
            case attr: String => attr -> Attribute(attr)
        } toMap) To

    def Attributes_=(attrs: Map[String, Option[Any]]) {
        attrs foreach {
            case (name, value) => Attribute(name, value)
        }
    }

    def RequestDispatcher(path: String) = new RequestDispatcher(proxy getRequestDispatcher path)

    def NamedDispatcher(name: String) = new RequestDispatcher(proxy getNamedDispatcher name)

    def LogAttributes {
        logger trace " ////////////////// Attributes ServletContext ////////////////////////"

        Attributes foreach {
            case (name, value) => {
                if (name.indexOf("MergedWebXml") >= 0) {
                    if (logger.isDebugEnabled)
                        logger trace (s"${name}: ${value getOrElse "null"}")
                    else
                        logger trace (s"${name}: ${"need Trace mode"}")
                }
                else
                    logger trace (s"${name}: ${value getOrElse "null"}")
            }
        }

        logger trace (s"Major version: ${proxy.getMajorVersion}")
        logger trace (s"Minor version: ${proxy.getMinorVersion}")
        logger trace (s"ServerInfo: ${proxy.getServerInfo}")
        logger trace " ////////////////// End Attributes ServletContext ////////////////////////"
    }

    def Attribute(name: String): Option[Any] = Option(proxy getAttribute name)

    def Attribute(name: String, obj: Option[Any]) {
        proxy setAttribute(name, obj getOrElse null)
    }

    def RemoveAttribute(name: String) {
        proxy removeAttribute name
    }

    def ResourcePaths(path: String): SortedSet[String] = ((proxy getResourcePaths path).toSet) To

    def LogResourcePaths(path: String) {
        (proxy getResourcePaths path) foreach (x => logger trace (s"path: ${x}"))
    }

    def ResourceAsStream(path: String): InputStream = proxy getResourceAsStream path

    @throws(classOf[MalformedURLException])
    def Resource(path: String): URLBox = {
        try {
            Option(proxy getResource path) match {
                case None =>
                    val msg = String format ("Path: '${path}' not found")
                    logger error msg
                    URLBox(None, msg)
                case Some(res) =>
                    URLBox(Some(res), "")
            }
        }
        catch {
            case ex: MalformedURLException =>
                logger error ex
                URLBox(None, ex toString)
        }
    }

    def ContextPath = proxy.getContextPath.replace("/", File.separator) + File.separator

    def JServletContext: JServletContext = proxy

    def Context(uripath: String) = ServletContext(proxy getContext uripath)
    def MajorVersion = proxy getMajorVersion()
    def MinorVersion = proxy getMinorVersion()
    def EffectiveMajorVersion = proxy getEffectiveMajorVersion()
    def EffectiveMinorVersion = proxy getEffectiveMinorVersion()
    def MimeType(file: String) = Option(proxy getMimeType file)
    def RealPath(path: String): Option[String] = Option(proxy getRealPath path)
    def ServerInfo = proxy getServerInfo()

    def InitParameters: SortedMap[String, Any] =
        (proxy.getInitParameterNames map {
            case parameter: String => parameter -> proxy.getInitParameter(parameter)
        } toMap) To

    def InitParameter(name: String) = proxy getInitParameter name
    def InitParameter(name: String, value: String) {
        proxy setInitParameter(name, value)
    }

    def ServletContextName = proxy getServletContextName

    def AddServlet(servletName: String, className: String): JServletRegistration.Dynamic = proxy addServlet(servletName, className)
    def AddServlet(servletName: String, className: String, asynSupport: Boolean, urlPatterns: String*): JServletRegistration.Dynamic = {
        val res = proxy addServlet(servletName, className)
        res setAsyncSupported asynSupport
        urlPatterns foreach (res.addMapping(_))
        res
    }

    def AddServlet[T <: Class[_ <: JServlet]](servletName: String, clazz: T): JServletRegistration.Dynamic = proxy addServlet(servletName, clazz)
    def AddServlet[T <: Class[_ <: JServlet]](servletName: String, clazz: T, asynSupport: Boolean, urlPatterns: String*): JServletRegistration.Dynamic = {
        val res = proxy addServlet(servletName, clazz)
        res setAsyncSupported asynSupport
        urlPatterns foreach (res.addMapping(_))
        res
    }

    @throws(classOf[ServletException])
    def CreateServlet[T <: JServlet](c: Class[T]) = proxy createServlet c

    def ServletRegistration(servletName: String): JServletRegistration = proxy getServletRegistration servletName
    def ServletRegistrations: Map[String, _ <: JServletRegistration] = proxy.getServletRegistrations.toMap

    def AddFilter(filterName: String, className: String): JFilterRegistration.Dynamic = proxy addFilter(filterName, className)
    def AddFilter(filterName: String, filter: Filter): JFilterRegistration.Dynamic = proxy addFilter(filterName, filter)
    def AddFilter[T <: Class[Filter]](filterName: String, clazz: T): JFilterRegistration.Dynamic = proxy addFilter(filterName, clazz)

    @throws(classOf[ServletException])
    def CreateFilter[T <: Filter](c: Class[T]) = proxy createFilter (c)

    def FilterRegistration(filterName: String): JFilterRegistration = proxy getFilterRegistration filterName
    def FilterRegistrations: Map[String, _ <: JFilterRegistration] = proxy.getFilterRegistrations.toMap

    def SessionCookieConfig = proxy getSessionCookieConfig()

    @throws(classOf[IllegalStateException])
    @throws(classOf[IllegalArgumentException])
    def SessionTrackingModes(sessionTrackingModes: Set[SessionTrackingMode]) {
        proxy setSessionTrackingModes sessionTrackingModes
    }

    def DefaultSessionTrackingModes: SortedSet[SessionTrackingMode] = proxy.getDefaultSessionTrackingModes.toSet.To
    def EffectiveSessionTrackingModes: SortedSet[SessionTrackingMode] = proxy.getEffectiveSessionTrackingModes.toSet.To
    def AddListener(className: String) {
        proxy addListener className
    }

    def AddListener[T <: Class[EventListener]](listenerClass: T) {
        proxy addListener listenerClass
    }

    @throws(classOf[ServletException])
    def CreateListener[T <: EventListener](listenerClass: Class[T]): T = proxy createListener listenerClass
    def DeclareRoles(roleNames: String*) {
        proxy declareRoles (roleNames: _*)
    }

    def ClassLoader = proxy getClassLoader

    def LogServletContext {
        logger trace " ////////////////// ServletContext ////////////////////////////"
        LogAttributes
        logger trace " ////////////////// End ServletContext ////////////////////////"
    }

    def WebInfPath: Option[String] = {
        val res = RealPath("/WEB-INF")
        res match {
            case None =>
                logger trace s"Read WebInfPath: Unknown"
            case Some(path) =>
                logger trace s"Read WebInfPath: $path"
        }

        res
    }

    def UserDir: String = {
        val res = System.getProperty("user.dir")
        logger trace s"Read user-dir: $res"
        res
    }

    def UserHome: String = {
        val res = System.getProperty("user.home")
        logger trace s"Read user-home: $res"
        res
    }
}


