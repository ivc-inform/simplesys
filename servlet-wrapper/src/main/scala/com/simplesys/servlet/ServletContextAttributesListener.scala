package com.simplesys.servlet

import javax.servlet.{ServletContextAttributeEvent => JServletContextAttributeEvent, ServletContextAttributeListener => JServletContextAttributeListener}
import com.simplesys.log.Logging


trait ServletContextAttributesListener extends JServletContextAttributeListener with Logging {

    override final def attributeAdded(scab: JServletContextAttributeEvent) {
        AttributeAdded1(ServletContextAttributeEvent(scab))
        logger.trace("Attribute added.")
    }

    override final def attributeRemoved(scab: JServletContextAttributeEvent) {
        AttributeRemoved1(ServletContextAttributeEvent(scab))
        logger trace ("Attribute removed.")
    }

    override final def attributeReplaced(scab: JServletContextAttributeEvent) {
        AttributeReplaced1(ServletContextAttributeEvent(scab))
        logger.trace("Attribute replaced.")
    }

    def AttributeAdded1(scae: ServletContextAttributeEvent) {
        logger.trace("Attribute added.")
    }

    def AttributeRemoved1(scae: ServletContextAttributeEvent) {
        logger.trace("Attribute removed.")
    }

    def AttributeReplaced1(scae: ServletContextAttributeEvent) {
        logger.trace("Attribute replaced.")
    }
}
