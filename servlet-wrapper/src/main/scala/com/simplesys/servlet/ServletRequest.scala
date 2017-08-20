package com.simplesys.servlet

import java.io.{IOException, UnsupportedEncodingException}
import java.util.Locale
import javax.servlet.http.{HttpServletRequest => JHttpServletRequest}
import javax.servlet.{ServletRequest => JServletRequest}

import com.simplesys.common._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.json.{Json, JsonObject}
import com.simplesys.log.Logging
import com.simplesys.servlet.http.HttpServletRequest
import com.simplesys.servlet.http.sse.SseServletRequest
import com.simplesys.xml.Elem

import scala.collection.JavaConverters._
import scala.collection.immutable.SortedMap
import scala.io.Codec._
import scala.io.{Codec, Source}
import scala.xml.XML

object ServletRequest {
    def apply(request: JServletRequest) = new ServletRequest(request)

    implicit def jServletRequest2ServletRequest(request: ServletRequest): JServletRequest = request.proxy
    implicit def servletRequest2JServletRequest(request: JServletRequest): JServletRequest = new ServletRequest(request)
}

class ServletRequest(protected[servlet] val proxy: JServletRequest) extends Logging {
    def Parameter(name: String): Option[String] = Option(proxy getParameter name)

    def Attribute(name: String): Option[AnyRef] = Option(proxy getAttribute name)

    def Attribute(name: String, obj: Option[Any]): Unit = proxy setAttribute(name, obj getOrElse null)

    def RemoveAttribute(name: String) {
        proxy removeAttribute name
    }

    def RequestDispatcher(path: String) = new RequestDispatcher(proxy getRequestDispatcher (path))

    def Parameters: SortedMap[String, Option[String]] =
        (proxy.getParameterNames.asScala map {
            case param: String => param -> Parameter(param)
        } toMap) To

    def Attributes: SortedMap[String, Option[Any]] =
        (proxy.getAttributeNames.asScala map {
            case attr: String => attr -> Attribute(attr)
        } toMap) To

    def Attributes_=(attrs: Map[String, Option[Any]]) {
        attrs foreach {
            case (name, value) => Attribute(name, value)
        }
    }

    def LogAttributes {
        logger trace " ////////////////// Attributes ServletRequest ////////////////////////////"
        Attributes foreach {
            case (name, value) =>
                logger trace (s"${name} : ${value getOrElse "null"}")
        }
        logger trace " ////////////////// End Attributes ServletRequest ////////////////////////"
    }

    def LogParameters {
        logger trace " ////////////////// Parameters ServletRequest ////////////////////////////"
        Parameters foreach {
            case (name, value) =>
                logger trace (s"${name}: ${value getOrElse ""}")
        }
        logger trace " ////////////////// End Parameters ServletRequest ////////////////////////"
    }

    def LogInputStream(in: String) {
        logger trace " ////////////////// InputStream ////////////////////////"
        logger trace in
        logger trace " ////////////////// End InputStream ////////////////////"
    }

    def LogAll {
        LogAll("unknown")
    }

    def LogAll(label: String) {
        logger trace (s" //////////////////Servlete Request (${label}) ////////////////////////")

        LogAttributes
        LogParameters

        logger trace (s"CharacterEncoding: ${CharacterEncoding}")
        logger trace (s"ContentType: ${ContentType}")
        logger trace (s"ContentLength: ${ContentLength}")
        logger trace (s"LocalAddr: ${LocalAddr}")
        logger trace (s"Locale: ${Locale}")
        logger trace (s"LocalName: ${LocalName}")
        logger trace (s"LocalPort: ${LocalPort}")
        logger trace (s"Protocol: ${Protocol}")
        logger trace (s"RemoteAddr: ${RemoteAddr}")
        logger trace (s"RemoteHost: ${RemoteHost}")
        logger trace (s"RemotePort: ${RemotePort}")
        logger trace (s"Scheme: ${Scheme}")
        logger trace (s"ServerName: ${ServerName}")
        logger trace (s"ServerPort: ${ServerPort}")
        logger trace (s"IsSecure: ${IsSecure}")
        logger trace (s"IsAsyncStarted: ${IsAsyncStarted}")
        logger trace (s"IsAsyncSupported: ${IsAsyncSupported}")
        logger trace (s"StartRow: ${StartRow}")
        logger trace (s"EndRow: ${EndRow}")
        logger trace (s"OperationType: ${OperationType}")
        logger trace (s"ComponentId: ${ComponentId}")
        logger trace (s"ISC_dataFormat: ${ISC_dataFormat}")
        logger trace (s"DispatcherType: ${DispatcherType}")
        logger trace (s" //////////////////End of Servlete Request (${label}) //////////////////")
    }

    def CharacterEncoding: Codec = proxy getCharacterEncoding match {
        case null => Codec.defaultCharsetCodec
        case x => x
    }

    @throws(classOf[UnsupportedEncodingException])
    def CharacterEncoding_=(charset: Codec) = {
        if (proxy.getCharacterEncoding == null)
            Codec.defaultCharsetCodec
        else if (charset !== (proxy.getCharacterEncoding))
            proxy setCharacterEncoding charset.toString()
    }

    def ContentType: Option[Content] = Content.getObject(proxy getContentType)
    def ContentLength = proxy getContentLength
    def LocalAddr = proxy getLocalAddr
    def Locale = proxy getLocale
    def LocalName = proxy getLocalName
    def Locales: List[Locale] = proxy.getLocales.asScala.toList
    def LocalPort = proxy getLocalPort
    def Protocol = proxy getProtocol
    def RemoteAddr = proxy getRemoteAddr
    def RemoteHost = proxy getRemoteHost
    def RemotePort = proxy getRemotePort
    def Scheme = proxy getScheme
    def ServerName = proxy getServerName
    def ServerPort = proxy getServerPort
    def IsSecure = proxy isSecure

    lazy val InputStream: String = Source.fromInputStream(proxy.getInputStream)(UTF8).getLines() mkString

    def ParameterMap: Map[String, Array[String]] = proxy.getParameterMap.asScala.toMap
    @throws(classOf[IOException])
    def Reader = proxy getReader

    def XMLData: Elem = {
        ISC_dataFormat match {
            case "XML" =>
                try {
                    val res = XML.load(InputStream)
                    logger trace (s"InputSream XmlData: ${res}")
                    res
                }
                catch {
                    case e: IllegalStateException =>
                        logger.warn(s"${e.getMessage}")
                            <request/>
                    case e: IOException =>
                        logger.warn(s"${e.getMessage}")
                            <request/>
                }

            case _ => <request/>
        }
    }

    def JSONData: JsonObject = {
        ISC_dataFormat match {
            case "JSON" =>
                try {
                    val res = Json(InputStream)
                    logger trace (s"InputStream JsonData: ${res.toPrettyString}")
                    res
                }
                catch {
                    case e: IllegalStateException =>
                        logger.warn(s"${e.getMessage}")
                        Json()
                    case e: IOException =>
                        logger.warn(s"${e.getMessage}")
                        Json()
                }
            case _ => Json()
        }
    }

    def StartRow = Parameter(ISC_metaDataPrefix + "startRow") getOrElse ("")
    def EndRow = Parameter(ISC_metaDataPrefix + "endRow") getOrElse ("")
    def OperationType = Parameter(ISC_metaDataPrefix + "operationType") getOrElse ("")
    def ComponentId = Parameter(ISC_metaDataPrefix + "componentId") getOrElse ("")
    def ISC_dataFormat = (Parameter("isc_dataFormat") getOrElse ("")) toUpperCase
    def ISC_metaDataPrefix: String = Parameter("isc_metaDataPrefix") getOrElse ("")

    def AsyncContext: AsyncContext = com.simplesys.servlet.AsyncContext(proxy getAsyncContext)
    def ServletContext: ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)

    def StartAsync[SRQ <: ServletRequest, SRS <: ServletResponse](request: SRQ, response: SRS) = new AsyncContext(request, response, proxy.startAsync(request proxy, response proxy))
    def StartAsync() = com.simplesys.servlet.AsyncContext(proxy.startAsync())
    def IsAsyncStarted = proxy isAsyncStarted
    def IsAsyncSupported = proxy isAsyncSupported
    def DispatcherType = proxy getDispatcherType

    def toHttp: HttpServletRequest = HttpServletRequest(this)
    def toSse: SseServletRequest = SseServletRequest(this)
}
