package com.simplesys.servlet.http

import javax.servlet.http.{HttpSessionBindingEvent => JHttpSessionBindingEvent}

object HttpSessionBindingEvent {
  def apply(proxy: JHttpSessionBindingEvent) = new HttpSessionBindingEvent(proxy)
}

class HttpSessionBindingEvent(protected val proxy: JHttpSessionBindingEvent) {
  def Session = HttpSession(proxy getSession)
}