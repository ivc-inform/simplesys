package com.simplesys.servlet

import javax.servlet.{ServletContextListener => JServletContextListener, ServletContextEvent => JServletContextEvent}
import com.simplesys.log.Logging
import collection.JavaConverters._

trait ServletContextListener extends JServletContextListener with Logging {

    final def contextInitialized(sce: JServletContextEvent) {
        ContextInitialized1(ServletContextEvent(sce))
        logger trace "ContextInitialized ."

        sce.getServletContext.getServletRegistrations.asScala.toMap.foreach {
            case (key, _) => logger trace (s"Registered Servlet: $key");
        }

    }

    final def contextDestroyed(sce: JServletContextEvent) {
        ContextDestroyed1(ServletContextEvent(sce))
        logger trace "ContextDestroyed ."
    }

    def ContextInitialized1(sce: ServletContextEvent) {
        logger trace "Context initialized."
    }

    def ContextDestroyed1(sce: ServletContextEvent) {
        logger trace "Context destroyed."
    }
}
