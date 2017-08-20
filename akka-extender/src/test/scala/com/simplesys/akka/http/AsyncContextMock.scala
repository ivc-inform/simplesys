package com.simplesys.akka.http

import java.io.{ByteArrayOutputStream, OutputStreamWriter, PrintWriter}
import org.specs2.mock.Mockito
import com.simplesys.servlet.{ServletResponse, ServletRequest, AsyncContext}
import com.simplesys.servlet.http.{HttpServletResponse, HttpServletRequest}

object AsyncContextMock extends Mockito {

    def apply(): AsyncContext = {

        val request = mock[HttpServletRequest]
        val response = mock[HttpServletResponse]

        request.Method returns "GET"
        request.PathInfo returns "/test"

        val asyncContext = mock[AsyncContext]

        asyncContext.Timeout returns 1000

        request.AsyncContext returns asyncContext

        response.Writer returns new PrintWriter(new OutputStreamWriter(new ByteArrayOutputStream()))

        request.StartAsync returns asyncContext
        request.StartAsync(request, response) returns asyncContext

        asyncContext.Request returns request
        asyncContext.Response returns response
    }
}