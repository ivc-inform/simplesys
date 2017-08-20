package com.simplesys.servlet.http.sse

import java.io.IOException
import javax.servlet.ServletException

import com.simplesys.servlet.{Servlet, ServletRequest, ServletResponse}

abstract class SseServlet extends Servlet {

    @throws(classOf[ServletException])
    @throws(classOf[IOException]) override protected
    final def Service(request: ServletRequest, response: ServletResponse): Unit = {
        SseService(SseServletRequest(request), SseServletResponse(response))
    }

    protected def SseService(request: SseServletRequest, response: SseServletResponse): Unit
}
