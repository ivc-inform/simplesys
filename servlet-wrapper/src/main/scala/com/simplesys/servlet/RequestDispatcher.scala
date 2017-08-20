package com.simplesys.servlet

import java.io.IOException
import javax.servlet.{ServletException, RequestDispatcher => JRequestDispatcher}

object RequestDispatcher {
  def apply(proxy: JRequestDispatcher) = new RequestDispatcher(proxy)
}

class RequestDispatcher(protected[servlet] val proxy: JRequestDispatcher) {

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  final def Forward(request: ServletRequest, response: ServletResponse) {
    proxy forward(request proxy, response proxy)
  }

  @throws(classOf[ServletException])
  @throws(classOf[IOException])
  final def Include(request: ServletRequest, response: ServletResponse) {
    proxy include(request proxy, response proxy)
  }
}