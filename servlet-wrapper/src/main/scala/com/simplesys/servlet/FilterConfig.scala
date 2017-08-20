package com.simplesys.servlet


import javax.servlet.{FilterConfig => JFilterConfig}
import collection.JavaConversions._
import com.simplesys.log.Logging

object FilterConfig {
    def apply(proxy: JFilterConfig) = new FilterConfig(proxy)
}

class FilterConfig(protected val proxy: JFilterConfig) extends Logging {

    def FilterName = proxy getFilterName

    def ServletContext = com.simplesys.servlet.ServletContext(proxy getServletContext)

    def InitParameter(name: String) = proxy getInitParameter name

    def InitParameters: Map[String, String] = {
        proxy.getInitParameterNames map {
            case param: String => param -> proxy.getInitParameter(param)
        } toMap
    }

    def LogParameters {
        logger trace " ////////////////// Parameters FilterConfig ////////////////////////"
        InitParameters foreach {
            case (key, value) => {
                logger trace (s"${key}: ${value}")
            }
        }
        logger trace " ////////////////// End Parameters FilterConfig ////////////////////////"
    }
}