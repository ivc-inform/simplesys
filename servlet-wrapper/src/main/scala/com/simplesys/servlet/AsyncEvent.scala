package com.simplesys.servlet

import javax.servlet.{AsyncEvent => JAsyncEvent}

object AsyncEvent {
  def apply(proxy: JAsyncEvent) = new AsyncEvent(proxy)
}

class AsyncEvent(protected[servlet] val proxy: JAsyncEvent) {
  def this(context: AsyncContext, request: ServletRequest, response: ServletResponse) = this(new JAsyncEvent(context proxy, request proxy, response proxy))
  def this(context: AsyncContext, request: ServletRequest, response: ServletResponse, throwable: Throwable) = this(new JAsyncEvent(context proxy, request proxy, response proxy, throwable))
  def this(context: AsyncContext, throwable: Throwable) = this(new JAsyncEvent(context proxy, throwable))

  def AsyncContext: AsyncContext = com.simplesys.servlet.AsyncContext(proxy getAsyncContext)

  def SuppliedRequest: ServletRequest = ServletRequest(proxy getSuppliedRequest)

  def SuppliedResponse: ServletResponse = ServletResponse(proxy getSuppliedResponse)

  def getProxy = proxy

  def Throwable: scala.Throwable = proxy getThrowable
}