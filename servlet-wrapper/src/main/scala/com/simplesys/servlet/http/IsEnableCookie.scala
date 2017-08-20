package com.simplesys.servlet.http

import java.io.IOException
import javax.servlet.ServletException
import com.simplesys.log.Logging

trait IsEnableCookie extends HttpServlet with Logging {

    private[this] var enabledCookies: Boolean = _

    @throws(classOf[ServletException])
    @throws(classOf[IOException])
    override def DoGet(request: HttpServletRequest, response: HttpServletResponse) {
        request.Parameter("flag") match {
            case None =>
                response.AddCookie(Cookie("browserSetting", "on")).
                  Print(<meta http-equiv="refresh" content={"0;url=" + request.RequestURI + "?flag=1)"}/>)
            case flag =>
                enabledCookies = (request.Cookies("browserSetting").Value == "on")
                logger trace (s"Cookie enabled is: ${IsEnabledCookies}")
        }
    }

    def IsEnabledCookies = enabledCookies
}