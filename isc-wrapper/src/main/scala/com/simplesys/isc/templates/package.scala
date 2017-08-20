package com.simplesys.isc

import java.io.File

import com.simplesys.isc.system.typesDyn.PageHtml
import com.simplesys.json.JsonElement
import com.simplesys.log.Logging
import com.simplesys.common.Strings._
import com.simplesys.script.HTMLBeautifier
import com.simplesys.servlet.ServletContext
import com.simplesys.xml.Elem._
import com.simplesys.common._

package object templates extends Logging {
    sealed abstract trait _JSVariable {
        val name: String
        val value: JsonElement
    }

    case class JSVariable(val name: String, value: JsonElement) extends _JSVariable {
        override def toString: String = s"var $name=${value.toString()};"
    }

    case class JSGlobalVariable(name: String, value: JsonElement) extends _JSVariable {
        override def toString: String = s"$name=${value.toString()};"
    }

    implicit class PageHtmlOpts(val pageHtml: PageHtml) {
        def addHeadScript(scriptPath: String, order: Int = 0): PageHtml = pageHtml.appendElement("head", <script></script>.setElementAttribute("src", scriptPath).setElementAttribute("order", order))
        def addHeadVariable(variable: _JSVariable): PageHtml = pageHtml.appendElement("head", <script></script>.setElementText("script", variable.toString))
        def addHeadVariables(variables: _JSVariable*): PageHtml = {
            if (variables.size > 0)
                pageHtml.appendElement("head", <script></script>.setElementText("script", variables.map(_.toString).mkString(strEmpty)))
            else
                pageHtml
        }
        def addHeadStyle(ccsPath: String): PageHtml = pageHtml.appendElement("head", <link rel="stylesheet" type="text/css"></link> setElementAttribute("href", ccsPath))
        def addHeadStyles(ccsPaths: String*): PageHtml = {
            var _pageHtml = pageHtml
            ccsPaths foreach (ccsPath => _pageHtml = _pageHtml.appendElement("head", <link rel="stylesheet" type="text/css"></link> setElementAttribute("href", ccsPath)))
            _pageHtml
        }

        def addHeadScripts(path: String, classes: String*): PageHtml = {
            var _pageHtml = pageHtml
            classes foreach {
                _class =>
                    val s = path + _class.shortClassName + ".js"
                    logger trace (s"addHeadScript: ${s}")
                    _pageHtml = _pageHtml addHeadScript s
            }
            logger trace (s"html: ${HTMLBeautifier(_pageHtml)}")
            _pageHtml
        }

        def addHeadScripts1(scripts: String*): PageHtml = addHeadScripts("", scripts: _*)

        def addHeadScripts(context: ServletContext, classes: (String, Int)*): PageHtml = addHeadScripts2(context.ContextPath, classes: _*)

        def addHeadScripts2(contextPath: String, classes: (String, Int)*): PageHtml = {
            var _pageHtml = pageHtml
            classes foreach {
                _class =>
                    val s = (new File(_class._1.replaceFirst("webapp/", contextPath))).getAbsolutePath
                    logger trace (s"addHeadScript: ${s}")
                    _pageHtml = _pageHtml addHeadScript (s, _class._2)
            }
            logger trace (s"html: ${_pageHtml.toPrettyString}")
            _pageHtml
        }

        def addHeadStyles(context: ServletContext, css: String*): PageHtml = {
            var _pageHtml = pageHtml
            css foreach {
                _class =>
                    val s = (new File(_class.replaceFirst("webapp/", context.ContextPath))).getAbsolutePath
                    logger trace (s"addHeadStyle: ${s}")
                    _pageHtml = _pageHtml addHeadStyle s
            }
            logger trace (s"html: ${_pageHtml.toPrettyString}")
            _pageHtml
        }
    }
}
