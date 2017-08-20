package com.simplesys.servlet

import com.simplesys.log.Logging
import java.io.IOException
import javax.servlet.{ServletException, ServletConfig => JServletConfig, ServletResponse => JServletResponse, ServletRequest => JServletRequest, Servlet => JServlet}

abstract class Servlet extends JServlet with Logging {

  private[this] var _config: ServletConfig = _
  private[this] var _context: ServletContext = _

  final def init(config: JServletConfig) {
    _config = com.simplesys.servlet.ServletConfig(config)
    _context = com.simplesys.servlet.ServletContext(config getServletContext)

    Init

      logger trace "The method init is executed."
  }

  final def service(request: JServletRequest, response: JServletResponse) {
    Service(ServletRequest(request), ServletResponse(response))
      logger trace "The method service is executed."
  }

  final def getServletConfig = null

  final def getServletInfo = ""

  final def destroy {
    Destroy
      logger trace "The method destroy is executed."
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def Service(request: ServletRequest, response: ServletResponse)

  @throws(classOf[ServletException])
  protected def Init {}

  protected def Destroy {}

  def ServletConfig = _config

  def ServletContext = _context

  def ServletInfo = "This is wrapper for javax.servlet"
}
