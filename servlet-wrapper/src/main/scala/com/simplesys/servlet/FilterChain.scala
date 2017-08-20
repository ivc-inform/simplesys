package com.simplesys.servlet

import java.io.IOException
import javax.servlet.{ServletException, FilterChain => JFilterChain}
import com.simplesys.log.Logger

object FilterChain {
    def apply(proxy: JFilterChain) = new FilterChain(proxy)
}

class FilterChain(protected val proxy: JFilterChain) {
    private[this] val logger = Logger(this getClass)

    @throws(classOf[ServletException])
    @throws(classOf[IOException])
    def DoFilter(request: ServletRequest, response: ServletResponse) {
        proxy doFilter(request proxy, response proxy)
        logger trace "The method doFilter is executed."
    }
}