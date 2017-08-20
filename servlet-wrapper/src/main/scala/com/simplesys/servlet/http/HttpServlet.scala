package com.simplesys.servlet.http

import javax.servlet.http.{HttpServletResponse => JHttpServletResponse, HttpServletRequest => JHttpServletRequest, HttpServlet => JHttpServlet}
import com.simplesys.log.Logging
import com.simplesys.servlet.{ServletConfig, ServletContext}
import javax.servlet.{ServletConfig => JServletConfig, ServletException}
import java.io.IOException

class HttpServlet extends JHttpServlet {

  private[this] var config: ServletConfig = _
  private[this] var context: ServletContext = _

  override def doGet(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoGet(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoGet(request: HttpServletRequest, response: HttpServletResponse) {
    super.doGet(request proxy, response proxy)
  }

  override final def doDelete(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoDelete(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoDelete(request: HttpServletRequest, response: HttpServletResponse) {
    super.doDelete(request proxy, response proxy)
  }

  override def doPost(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoPost(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoPost(request: HttpServletRequest, response: HttpServletResponse) {
    super.doPost(request proxy, response proxy)
  }

  override final def doPut(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoPut(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoPut(request: HttpServletRequest, response: HttpServletResponse) {
    super.doPut(request proxy, response proxy)
  }

  override final def doHead(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoHead(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoHead(request: HttpServletRequest, response: HttpServletResponse) {
    super.doHead(request proxy, response proxy)
  }

  override final def doOptions(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoOptions(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoOptions(request: HttpServletRequest, response: HttpServletResponse) {
    super.doOptions(request proxy, response proxy)
  }

  override final def doTrace(request: JHttpServletRequest, response: JHttpServletResponse) {
    DoTrace(HttpServletRequest(request), HttpServletResponse(response))
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  protected def DoTrace(request: HttpServletRequest, response: HttpServletResponse) {
    super.doTrace(request proxy, response proxy)
  }

  override final def init(cfg: JServletConfig) {
    config = com.simplesys.servlet.ServletConfig(cfg)
    context = com.simplesys.servlet.ServletContext(cfg getServletContext)

    Init
  }

  @throws(classOf[ServletException])
  def Init {}

  def ServletConfig = config

  def ServletContext = context

  final override def destroy() {
    Destroy
  }

  protected def Destroy {}
}