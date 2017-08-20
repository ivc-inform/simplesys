package com.simplesys.servlet

import javax.servlet.{AsyncListener => JAsyncListener, AsyncEvent => JAsyncEvent}
import com.simplesys.log.{Logger, Logging}
import java.io.IOException

trait AsyncListener extends JAsyncListener {
  private[this] val logger = Logger(this getClass)

  final def onComplete(event: JAsyncEvent) {
    OnComplete(AsyncEvent(event))
      logger trace "Event OnComplete."
  }

  final def onTimeout(event: JAsyncEvent) {
    OnTimeout(AsyncEvent(event))
      logger trace "Event OnTimeout."
  }

  final def onError(event: JAsyncEvent) {
    OnError(AsyncEvent(event))
      logger trace "Event OnError."
  }

  final def onStartAsync(event: JAsyncEvent) {
    OnStartAsync(AsyncEvent(event))
      logger trace "Event OnStartAsync."
  }

  @throws(classOf[IOException])
  def OnComplete(event: AsyncEvent) {}

  @throws(classOf[IOException])
  def OnTimeout(event: AsyncEvent) {}

  @throws(classOf[IOException])
  def OnError(event: AsyncEvent) {}

  @throws(classOf[IOException])
  def OnStartAsync(event: AsyncEvent) {}
}