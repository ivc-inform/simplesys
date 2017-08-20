package com.simplesys.servlet

import javax.servlet.{ServletContextEvent => JServletContextEvent}

object ServletContextEvent {
  def apply(proxy: JServletContextEvent) = new ServletContextEvent(proxy)
}

class ServletContextEvent(protected val proxy: JServletContextEvent) {
  def ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)
}