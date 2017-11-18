package com.simplesys.akka.http

import akka.actor.ActorSystem
import com.simplesys.config.Config
import com.simplesys.servlet.{ServletContext, ServletContextEvent, ServletContextListener}

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe ⇒ ru}

trait ServletContextInit extends Config {
    self: ServletContextListener =>

    implicit protected[this] lazy val system = ActorSystem(getString("akka.http.system-name"))
    protected[this] lazy val scheduler = system.scheduler
    protected[this] lazy val classLoaderMirror = runtimeMirror(getClass.getClassLoader)

    private[this] var servletContext: ServletContext = _
    def ServletContext = servletContext

    override def ContextInitialized1(sce: ServletContextEvent) {


        sce.ServletContext.Attribute("actorSystem", Some(system))

        sce.ServletContext.Attribute("systemScheduler", Some(system.scheduler))

        servletContext = sce.ServletContext

        UserContextInitialized(sce)
    }

    def UserContextInitialized(sce: ServletContextEvent): Unit = {}

    override def ContextDestroyed1(sce: ServletContextEvent) {
        sce.ServletContext RemoveAttribute "dbConnectionStack"

        sce.ServletContext RemoveAttribute "actorSystem"

        system.terminate()
        //system.awaitTermination()
    }
}
