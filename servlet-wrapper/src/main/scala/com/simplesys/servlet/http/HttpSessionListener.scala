package com.simplesys.servlet.http

import javax.servlet.http.{HttpSessionEvent => JHttpSessionEvent, HttpSessionListener => JHttpSessionListener}

import com.simplesys.log.Logging


trait HttpSessionListener extends JHttpSessionListener with Logging {
    final def sessionCreated(se: JHttpSessionEvent) {
        SessionCreated(HttpSessionEvent(se))
        logger trace "Session created."
    }


    final def sessionDestroyed(se: JHttpSessionEvent) {
        SessionDestroyed(HttpSessionEvent(se))
        logger trace "Session destroyed."
    }

    def SessionCreated(se: HttpSessionEvent)

    def SessionDestroyed(se: HttpSessionEvent)
}