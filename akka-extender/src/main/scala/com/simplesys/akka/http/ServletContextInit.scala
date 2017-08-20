package com.simplesys.akka.http

import akka.actor.{ActorSystem, Props}
import com.simplesys.config.Config
import com.simplesys.connectionStack.BoneCPStack
import com.simplesys.servlet.{ServletContext, ServletContextEvent, ServletContextListener}
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

trait ServletContextInit extends Config {
    self: ServletContextListener =>

    protected[this] lazy val cpStack = BoneCPStack()
    implicit protected[this] lazy val system = ActorSystem(getString("akka.http.system-name"))
    protected[this] lazy val scheduler = system.scheduler
    protected[this] lazy val classLoaderMirror = runtimeMirror(getClass.getClassLoader)

    private[this] var servletContext: ServletContext = _
    def ServletContext = servletContext

    override def ContextInitialized1(sce: ServletContextEvent) {

        sce.ServletContext.Attribute("dbConnectionStack", Some(cpStack))

        sce.ServletContext.Attribute("actorSystem", Some(system))

        sce.ServletContext.Attribute("systemScheduler", Some(system.scheduler))

        servletContext = sce.ServletContext

        UserContextInitialized(sce)
    }

    def UserContextInitialized(sce: ServletContextEvent): Unit = {}

    override def ContextDestroyed1(sce: ServletContextEvent) {
        sce.ServletContext RemoveAttribute "dbConnectionStack"
        cpStack.Close()

        sce.ServletContext RemoveAttribute "actorSystem"

        system.shutdown()
        system.awaitTermination();
    }
}
