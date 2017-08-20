package com.simplesys.servlet

import javax.servlet.{AsyncContext => JAsyncContext}
import javax.servlet.http.{HttpServletRequest => JHttpServletRequest, HttpServletResponse => JHttpServletResponse}

object AsyncContext {
    def AsyncRequestUri = JAsyncContext.ASYNC_REQUEST_URI
    def AsyncContextPath = JAsyncContext.ASYNC_CONTEXT_PATH
    def AsyncPathInfo = JAsyncContext.ASYNC_PATH_INFO
    def AsyncServletPath = JAsyncContext.ASYNC_SERVLET_PATH
    def AsyncQueryString = JAsyncContext.ASYNC_QUERY_STRING

    def apply(proxy: JAsyncContext) = new AsyncContext(ServletRequest(proxy.getRequest), ServletResponse(proxy.getResponse), proxy)
}

class AsyncContext(protected[servlet] val request: ServletRequest, protected[servlet] val response: ServletResponse, protected[servlet] val proxy: JAsyncContext) {

    def Request = request
    def Response = response

    def HasOriginalRequestAndResponse: Boolean = proxy hasOriginalRequestAndResponse

    @throws(classOf[IllegalStateException])
    def Dispatch {
        proxy dispatch()
    }

    @throws(classOf[IllegalStateException])
    def Dispatch(path: String) {
        proxy dispatch path
    }

    @throws(classOf[IllegalStateException])
    def Dispatch(context: ServletContext, path: String) {
        proxy dispatch(context proxy, path)
    }

    def Complete() {
        proxy complete()
    }

    def Start(run: Runnable) {
        proxy start run
    }

    def AddListener(listener: AsyncListener) {
        proxy addListener listener
    }

    def AddListener(listener: AsyncListener, request: ServletRequest, response: ServletResponse) {
        proxy addListener(listener, request proxy, response proxy)
    }

    def Timeout = proxy getTimeout()

    def Timeout_=(timeout: Long) {
        proxy setTimeout (timeout)
    }

    def createListener[T <: AsyncListener](clazz: Class[T]): T = proxy.createListener(clazz)

    def getProxy = proxy
}