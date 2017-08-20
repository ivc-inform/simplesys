package com.simplesys.isc.templates

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging._
import com.simplesys.akka.event.Logging
import com.simplesys.config.Config
import com.simplesys.common.Strings._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn, PageDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonList
import com.simplesys.script.{HTMLBeautifier, JsBeautifier}

sealed trait Log
case class LogHtmlAndJS(page: PageHtml, script: String)
case class LogJavaScript(script: String)
case class LogHtml(page: PageHtml)

object LogActor {
    def props: Props = Props(new LogActor)
}

class LogActor extends Actor with Logging with Config {
    override def receive = {
        case LogHtmlAndJS(page, script) =>
            if (getString("LogActor.LogHtmlAndJS").toLogLevel == DebugLevel) {
                logger debug (s"Html: ${HTMLBeautifier(page)}")
                logger debug (s"JavaScript: ${JsBeautifier(script)}")
            }

        case LogHtml(page) =>
            if (getString("LogActor.LogHtml").toLogLevel == DebugLevel)
                logger debug (s"Html: ${HTMLBeautifier(page)}")

        case LogJavaScript(script) =>
            if (getString("LogActor.LogJavaScript").toLogLevel == DebugLevel)
                logger debug (s"JavaScript: ${JsBeautifier(script)}")
    }
}

object logHtmlPageActor {
    def apply(page: PageHtml)(implicit system: ActorSystem): PageHtml = apply(page, "")

    def apply(page: PageHtml, script: String)(implicit system: ActorSystem): PageHtml = {

        val _script = PageDyn().setEvent(loadPageEvent, script).getCommandLine
        system.actorOf(LogActor.props) ! LogHtmlAndJS(page, _script)

        page.setElementText("script", "id", "body_script", _script)
    }
}

object logHtmlPageD extends com.simplesys.log.Logging {
    def apply(page: PageHtml): PageHtml = apply(page, "")

    def apply(page: PageHtml, script: String): PageHtml = {

        logger trace (s"Html: ${HTMLBeautifier(page)}")

        val _script = PageDyn().setEvent(loadPageEvent, script).getCommandLine
        logger trace (s"JavaScript: ${JsBeautifier(_script)}")
        page.setElementText("script", "id", "body_script", _script)
    }
}

object logJSActor {

    def apply(script: String)(implicit system: ActorSystem): String = {

        system.actorOf(LogActor.props) ! LogJavaScript(script)
        script
    }

    def apply(_class: ClassDyn)(implicit system: ActorSystem): String = apply(_class.toString())
    def apply[T <: ClassDyn](array: ArrayDyn[T])(implicit system: ActorSystem): String = apply(array.toString())
}

object logJSD extends com.simplesys.log.Logging {

    def apply(script: String): String = {

        if (logger.isTraceEnabled) {
            logger trace (s"JavaScript: ${JsBeautifier(script)}")
        }
        script
    }

    def apply(_class: ClassDyn): String = apply(_class.toString)
}
