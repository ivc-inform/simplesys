package com.simplesys.servlet.http

import java.io.IOException
import javax.servlet.http.{HttpServletResponse => JHttpServletResponse}
import javax.servlet.{ServletResponse => JServletResponse}

import com.simplesys.servlet.ServletResponse

trait ConstantResponse {
    val ScContinue = JHttpServletResponse.SC_CONTINUE
    val ScSwitchingProtocols = JHttpServletResponse.SC_SWITCHING_PROTOCOLS
    val ScOk = JHttpServletResponse.SC_OK
    val ScCreated = JHttpServletResponse.SC_CREATED
    val ScAccepted = JHttpServletResponse.SC_ACCEPTED
    val ScNonAuthoritativeInformation = JHttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION
    val ScNoContent = JHttpServletResponse.SC_NO_CONTENT
    val ScResetContent = JHttpServletResponse.SC_RESET_CONTENT
    val ScPartialContent = JHttpServletResponse.SC_PARTIAL_CONTENT
    val ScMultipleChoices = JHttpServletResponse.SC_MULTIPLE_CHOICES
    val ScMovedPermanently = JHttpServletResponse.SC_MOVED_PERMANENTLY
    val ScMovedTemporarily = JHttpServletResponse.SC_MOVED_TEMPORARILY
    val ScFound = JHttpServletResponse.SC_FOUND
    val ScSeeOther = JHttpServletResponse.SC_SEE_OTHER
    val ScNotModified = JHttpServletResponse.SC_NOT_MODIFIED
    val ScUseProxy = JHttpServletResponse.SC_USE_PROXY
    val ScTemporarilyRedirect = JHttpServletResponse.SC_TEMPORARY_REDIRECT
    val ScBadRequest = JHttpServletResponse.SC_BAD_REQUEST
    val ScUnauthorized = JHttpServletResponse.SC_UNAUTHORIZED
    val ScPaymentRequired = JHttpServletResponse.SC_PAYMENT_REQUIRED
    val ScForbidden = JHttpServletResponse.SC_FORBIDDEN
    val ScNotFound = JHttpServletResponse.SC_NOT_FOUND
    val ScMethodNotAllowed = JHttpServletResponse.SC_METHOD_NOT_ALLOWED
    val ScNotAcceptable = JHttpServletResponse.SC_NOT_ACCEPTABLE
    val ScProxyAuthenticationRequired = JHttpServletResponse.SC_PROXY_AUTHENTICATION_REQUIRED
    val ScRequestTimeout = JHttpServletResponse.SC_REQUEST_TIMEOUT
    val ScConflict = JHttpServletResponse.SC_CONFLICT
    val ScGone = JHttpServletResponse.SC_GONE
    val ScLengthRequired = JHttpServletResponse.SC_LENGTH_REQUIRED
    val ScPreconditionFailed = JHttpServletResponse.SC_PRECONDITION_FAILED
    val ScRequestEntityToLarge = JHttpServletResponse.SC_REQUEST_ENTITY_TOO_LARGE
    val ScRequestUriTooLong = JHttpServletResponse.SC_REQUEST_URI_TOO_LONG
    val ScUnsupportedMediaType = JHttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE
    val ScRequestRangeNotSatisfiable = JHttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE
    val ScExpectationFailed = JHttpServletResponse.SC_EXPECTATION_FAILED
    val ScInternalServerError = JHttpServletResponse.SC_INTERNAL_SERVER_ERROR
    val ScNotImplemented = JHttpServletResponse.SC_NOT_IMPLEMENTED
    val ScBadGateway = JHttpServletResponse.SC_BAD_GATEWAY
    val ScServiceUnavailable = JHttpServletResponse.SC_SERVICE_UNAVAILABLE
    val ScGatewayTimeout = JHttpServletResponse.SC_GATEWAY_TIMEOUT
    val ScHttpVersionNotSupported = JHttpServletResponse.SC_HTTP_VERSION_NOT_SUPPORTED

    implicit def jHttpServletResponse2HttpServletResponse(response: HttpServletResponse): JHttpServletResponse = response.proxy
    implicit def HttpservletResponse2JHttpServletResponse(response: JHttpServletResponse): HttpServletResponse = new HttpServletResponse(response)
}

object HttpServletResponse extends ConstantResponse {
    def apply(response: JHttpServletResponse): HttpServletResponse = new HttpServletResponse(response)

    def apply(response: JServletResponse): HttpServletResponse = response match {
        case response: JHttpServletResponse => HttpServletResponse(response)
        case _ => throw new RuntimeException("Ожидался HttpServletResponse.")
    }

    /*def toJHttpServletResponse(response: JServletResponse): JHttpServletResponse = response match {
        case response: JHttpServletResponse => response
        case _ => throw new RuntimeException("Ожидался HttpServletResponse.")
    }*/

    def apply(response: ServletResponse): HttpServletResponse = apply(response.proxy)
}

class HttpServletResponse(override protected[servlet] val proxy: JHttpServletResponse) extends ServletResponse(proxy) with Headers {

    @throws(classOf[IOException])
    def SendError(sc: Int, msg: String) {
        proxy sendError(sc, msg)
    }

    @throws(classOf[IOException])
    def SendError(sc: Int) {
        proxy sendError sc
    }

    @throws(classOf[IOException])
    def SendRedirect(location: String) {
        proxy sendRedirect location
    }

    def AddCookie(cookie: Cookie): HttpServletResponse = {
        logger trace "Add Cookie"

        cookie loginCookie

        proxy addCookie (cookie proxy)

        this
    }

    def EncodeURL(url: String): String = proxy encodeURL (url)

    def EncodeRedirectURL(url: String) = proxy encodeRedirectURL url

    def LogHeader {
        logger trace " ////////////////// Headers HttpServletResponse ////////////////////////////"
        headersMap foreach {
            case (name, value) => logger trace (s"${name}: ${value.mkString(";")}")
        }
        logger trace " ////////////////// End Headers HttpServletResponse ////////////////////////////"
    }

    override def LogAll(addComment: String = "") {
        super.LogAll(addComment)

        LogHeader
        addComment match {
            case "" => logger trace (s" ////////////////// HttpServletResponse ////////////////////////////")
            case _ => logger trace (s" ////////////////// HttpServletResponse : (${addComment})////////////////////////////")
        }
        logger trace (s"Status: ${Status}")
        logger trace " ////////////////// End HttpServletResponse ////////////////////////"
    }

    def Status = proxy getStatus
    def Status_=(sc: Int) {
        proxy setStatus sc
    }
}
