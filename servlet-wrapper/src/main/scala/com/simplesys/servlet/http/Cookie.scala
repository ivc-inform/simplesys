package com.simplesys.servlet.http

import com.simplesys.log.Logging
import javax.servlet.http.{Cookie => JCookie}

object Cookie {
    def apply(proxy: JCookie) = new Cookie(proxy)

    def apply(name: String, value: String) = new Cookie(name, value)
}

class Cookie(val proxy: JCookie) extends Logging {
    def this(name: String, value: String) = this(new JCookie(name, value))

    def Name = proxy getName

    def Value = proxy getValue
    def Value_=(value: String) {
        proxy setValue value
    }

    def MaxAge = proxy getMaxAge
    def MaxAge_=(value: Int) {
        proxy setMaxAge value
    }

    def loginCookie {
        logger trace (s"The Cookie: {name: '${Name}'} {value: '${Value}'} {MaxAge: '${MaxAge}'}")
    }
}

