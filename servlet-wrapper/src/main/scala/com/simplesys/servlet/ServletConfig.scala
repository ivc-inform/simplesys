package com.simplesys.servlet

import javax.servlet.{ServletConfig => JServletConfig}
import collection.JavaConversions._
import com.simplesys.log.Logging

object ServletConfig {
    def apply(proxy: JServletConfig) = new ServletConfig(proxy)
}

class ServletConfig(protected[servlet] val proxy: JServletConfig) extends Logging {

    def LogParameters {
        logger trace " ////////////////// Parameters ServletConfig ////////////////////////////"
        InitParameters foreach {
            case (name, value) => logger trace (s"${name}: ${value}")
        }
        logger trace " ////////////////// End Parameters ServletConfig ////////////////////////"
    }

    def InitParameter(name: String) = proxy getInitParameter (name)

    def InitParameters: Map[String, String] = proxy.getInitParameterNames map {
        case param: String => param -> proxy.getInitParameter(param)
    } toMap


    def ServletName = proxy getServletName

    def ServletContext: ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)
}