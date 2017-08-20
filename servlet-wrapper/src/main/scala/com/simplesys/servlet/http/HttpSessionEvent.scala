package com.simplesys.servlet.http

import javax.servlet.http.{HttpSessionEvent => JHttpSessionEvent}

object HttpSessionEvent {
  def apply(proxy: JHttpSessionEvent) = new HttpSessionEvent(proxy)
}

class HttpSessionEvent(protected val proxy: JHttpSessionEvent) {
  def Session = HttpSession(proxy.getSession)
}