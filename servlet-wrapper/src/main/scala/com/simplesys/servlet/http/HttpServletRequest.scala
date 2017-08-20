package com.simplesys.servlet.http

import java.io.{File, IOException}
import javax.servlet.http.{Part, HttpServletRequest ⇒ JHttpServletRequest}
import javax.servlet.{ServletException, ServletRequest ⇒ JServletRequest}

import com.simplesys.common.Strings._
import com.simplesys.common._
import com.simplesys.servlet._

import scala.collection.JavaConverters._
import scala.collection.SortedMap

object HttpServletRequest {
    def apply(request: JHttpServletRequest): HttpServletRequest = new HttpServletRequest(request)

    def apply(request: JServletRequest): HttpServletRequest = request match {
        case request: JHttpServletRequest => HttpServletRequest(request)
        case _ => throw new RuntimeException("Ожидался JHttpServletRequest.")
    }

    /*def toJHttpServletRequest(request: JServletRequest): JHttpServletRequest = request match {
        case request: JHttpServletRequest => request
        case _ => throw new RuntimeException("Ожидался JHttpServletRequest.")
    }*/

    def apply(request: ServletRequest): HttpServletRequest = apply(request.proxy)

    val BasicAuth = JHttpServletRequest.BASIC_AUTH
    val FormAuth = JHttpServletRequest.FORM_AUTH
    val ClientSertAuth = JHttpServletRequest.CLIENT_CERT_AUTH
    val DigestAuth = JHttpServletRequest.DIGEST_AUTH

    implicit def jHttpServletRequest2HttpServletRequest(request: HttpServletRequest): JHttpServletRequest = request.proxy
    implicit def HttpServletRequest2JHttpServletRequest(request: JHttpServletRequest): HttpServletRequest = new HttpServletRequest(request)
}


class HttpServletRequest(override protected[servlet] val proxy: JHttpServletRequest) extends ServletRequest(proxy) {

    def AuthType = proxy getAuthType
    def DateHeader(name: String) = proxy getDateHeader name

    def Headers(name: String): List[String] = proxy.getHeaders(name).asScala.toList
    def HeadersMap: SortedMap[String, String] = (proxy.getHeaderNames.asScala map {
        case header: String => header -> proxy.getHeader(header)
    } toMap).To

    def Header(name: String) = proxy getHeader name
    def IntHeader(name: String) = proxy getIntHeader name
    def PathInfo = proxy getPathInfo
    def PathTranslated = proxy getPathTranslated

    def LogHeaders {
        logger trace " ////////////////// Headers HttpServletRequest ////////////////////////"
        HeadersMap foreach {
            case (name, header) => logger trace (s"${name}: ${header}")
        }
        logger trace " ////////////////// End Headers HttpServletRequest ////////////////////////"
    }

    def QueryString = proxy getQueryString
    def RemoteUser = proxy getRemoteUser
    def UserPrincipal = proxy getUserPrincipal
    def RequestedSessionId = proxy getRequestedSessionId
    def ServletPath = proxy getServletPath
    def ContextPath = proxy.getContextPath.asString.replace("/", File.separator) + File.separator
    def ShortContextPath = RequestURI.replace(ContextPath, strEmpty)
    def RequestURI = proxy getRequestURI
    def RequestURL = proxy getRequestURL
    def IsUserInRole(role: String) = proxy isUserInRole role

    def Cookies: SortedMap[String, Cookie] = (proxy.getCookies map {
        cookie => Cookie(cookie).Name -> Cookie(cookie)
    } toMap) To

    def LogCookies {
        logger trace " ////////////////// Cookies ////////////////////////"

        Cookies foreach {
            case (name, cookie) => cookie.loginCookie
        }

        logger trace " ////////////////// End Cookies ////////////////////////"
    }

    def Session(): Option[HttpSession] = Some(HttpSession(proxy getSession))
    def Session(create: Boolean): Option[HttpSession] = (proxy getSession create) match {
        case null => None
        case x => Some(HttpSession(x))
    }

    def SessionOption = Session
    def SessionOption(create: Boolean) = Session(create)
    def Method = proxy getMethod

    override def LogAll {
        LogAll("unknown")
    }

    override def LogAll(label: String) {
        super.LogAll(label)
        LogHeaders
        logger trace (s" //////////////////Http Servlete Request (${label}) ////////////////////////")
        logger trace (s"Method: ${Method}")
        logger trace (s"RequestURI: ${RequestURI}")
        logger trace (s"RequestURL: ${RequestURL}")

        logger trace (s"QueryString: ${QueryString}")
        logger trace (s"RemoteUser: ${RemoteUser}")
        logger trace (s"UserPrincipal: ${UserPrincipal}")
        logger trace (s"RequestedSessionId: ${RequestedSessionId}")
        logger trace (s"ServletPath: ${ServletPath}")
        logger trace (s"ContextPath: ${ContextPath}")
        logger trace (s"IsRequestedSessionIdValid: ${IsRequestedSessionIdValid}")
        logger trace (s"IsRequestedSessionIdFromCookie: ${IsRequestedSessionIdFromCookie}")
        logger trace (s"IsRequestedSessionIdFromURL: ${IsRequestedSessionIdFromURL}")
        logger trace (s" //////////////////End of Http Servlete Request (${label}) ///////////////// /n")
    }

    def IsRequestedSessionIdValid = proxy isRequestedSessionIdValid
    def IsRequestedSessionIdFromCookie = proxy isRequestedSessionIdFromCookie
    def IsRequestedSessionIdFromURL = proxy isRequestedSessionIdFromURL

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    def Authenticate(response: HttpServletResponse) = proxy authenticate response.proxy

    @throws(classOf[ServletException])
    def Login(username: String, password: String) = proxy login(username, password)

    @throws(classOf[ServletException])
    def Logout = proxy logout()

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    @throws(classOf[IllegalStateException])
    def Parts: List[Part] = proxy.getParts.asScala.toList

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    @throws(classOf[IllegalStateException])
    def Part(name: String) = proxy getPart name

}

