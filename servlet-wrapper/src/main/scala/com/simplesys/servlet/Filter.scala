package com.simplesys.servlet

import com.simplesys.log.Logging
import java.io.IOException
import javax.servlet.{FilterConfig => JFilterConfig, FilterChain => JFilterChain, Filter => JFilter, ServletResponse => JServletResponse, ServletRequest => JServletRequest, ServletException}

import com.simplesys.servlet.http.{HttpServletResponse, HttpServletRequest}


trait Filter extends JFilter with Logging {
    private[this] var config: FilterConfig = _
    private[this] var context: ServletContext = _

    def FilterConfig = config
    def FilterContext = context

    final def init(filterConfig: JFilterConfig) {
        config = com.simplesys.servlet.FilterConfig(filterConfig)
        context = ServletContext(filterConfig.getServletContext)
        Init
        logger trace "The method init is executed."
    }

    override final def doFilter(request: JServletRequest, response: JServletResponse, chain: JFilterChain) {
        DoFilter(ServletRequest(request), ServletResponse(response), FilterChain(chain))
        logger trace "The method DoFilter is executed."
    }

    final def destroy() {
        config = null
        Destroy
        logger trace "The method destroy is executed."
    }


    def Init {}

    @throws(classOf[ServletException])
    @throws(classOf[IOException])
    protected def DoFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {}

    protected def Destroy {}
}