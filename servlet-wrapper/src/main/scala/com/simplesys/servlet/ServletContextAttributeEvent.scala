package com.simplesys.servlet

import javax.servlet.{ServletContextAttributeEvent => JServletContextAttributeEvent}

object ServletContextAttributeEvent {
  def apply(proxy: JServletContextAttributeEvent) = new ServletContextAttributeEvent(proxy)
}

class ServletContextAttributeEvent(protected val proxy: JServletContextAttributeEvent) {
  def getServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)
}