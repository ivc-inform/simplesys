package com.simplesys.akka.http

import java.io.IOException
import javax.servlet.ServletException

import akka.actor.ActorSystem
import com.simplesys.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

class AkkaHttpMapServlet extends HttpServlet with AkkaMap {

    protected lazy val servletContext = ServletContext
    protected lazy val servletConfig = ServletConfig

    override def Init() {
        initAkkaSystem(servletContext.Attribute("actorSystem").get.asInstanceOf[ActorSystem])
    }

    override def Destroy() {
        destroyAkkaSystem()
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoGet(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoDelete(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoPost(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoPut(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoHead(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoOptions(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }

    @throws(classOf[IOException])
    @throws(classOf[ServletException])
    override def DoTrace(request: HttpServletRequest, response: HttpServletResponse) {
        doActor(request, response)
    }
}