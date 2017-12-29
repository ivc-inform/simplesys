package com.simplesys.servlet.http

import javax.servlet.http.{HttpSessionBindingEvent => JHttpSessionBindingEvent, HttpSessionAttributeListener => JHttpSessionAttributeListener}
import com.simplesys.log.Logging


trait HttpSessionAttributeListener extends JHttpSessionAttributeListener with Logging {
    override final def attributeAdded(se: JHttpSessionBindingEvent) {
        AttributeAdded(HttpSessionBindingEvent(se))
        logger trace "Attribute added."
    }

    override final def attributeRemoved(se: JHttpSessionBindingEvent) {
        AttributeRemoved(HttpSessionBindingEvent(se))
        logger trace "Attribute removed."
    }

    override final def attributeReplaced(se: JHttpSessionBindingEvent) {
        AttributeReplaced(HttpSessionBindingEvent(se))
        logger trace "Attribute replaced."
    }

    def AttributeAdded(se: HttpSessionBindingEvent)

    def AttributeRemoved(se: HttpSessionBindingEvent)

    def AttributeReplaced(se: HttpSessionBindingEvent)
}
