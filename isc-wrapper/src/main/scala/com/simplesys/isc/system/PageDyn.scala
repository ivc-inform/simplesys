package com.simplesys.isc.system

import com.simplesys.isc.system.misc.{FunctionExpression, URL}
import com.simplesys.isc.system.typesDyn.{onceFireStyle, FireStyle, PageEvent}
import com.simplesys.common.Strings._


object PageDyn {
    def apply() = new PageDyn
}

class PageDyn extends ClassDyn with PageDynInit {
    override val selfName = "Page"
    override val fabriqueClass: Boolean = true

    def setAppImgDir(url: URL) = {
        setClassCommandEnqueue(s"setAppImgDir(${url.toStringWithLastSlash})")
        this
    }

    def setSkinDir(url: URL) = {
        setClassCommandEnqueue(s"setSkinDir(${url.toStringWithLastSlash})")
        this
    }


    def loadStyleSheet(url: URL) = {
        setClassCommandEnqueue(s"loadStyleSheet(${url.toStringWithLastSlash})")
        this
    }

    def setEvent(eventType: PageEvent, action: String, fireStyle: FireStyle = onceFireStyle): PageDyn = {
        setClassCommandEnqueue(s"setEvent(${eventType.toString.dblQuoted}, function(target){${action}}, ${fireStyle.toString})")
        this
    }
}
