package com.simplesys.javaScriptGen

import scala.collection.mutable.ArrayBuffer
import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._

abstract class JavaScriptElement {
    def serrialize(indent: Int = 0): String
    def serrializeSTriplesWrap(indent: Int = 0) = ""
}

class JavaScriptStringElement(string: String) extends JavaScriptElement {
    def serrialize(indent: Int = 0) = spaces(indent) + string
}

case class JavaScriptSwitchCaseItem(`case`: String, body: JavaScriptBody) extends JavaScriptElement {
    def serrialize(indent: Int): String = spaces(indent) + "case".space + `case`.dblQuoted + ":".newLine + body.serrialize(indent)
}

case class JavaScriptSwitch(switch: String, default: JavaScriptBody, caseItems: JavaScriptSwitchCaseItem*) extends JavaScriptElement {
    private val _caseItems = ArrayBuffer(caseItems: _*)

    def +=(caseItem: JavaScriptSwitchCaseItem) {
        _caseItems += caseItem
    }

    def +=:(caseItem: JavaScriptSwitchCaseItem) {
        _caseItems.+=:(caseItem)
    }

    def ++=(caseItems: JavaScriptSwitchCaseItem*) {
        _caseItems ++= caseItems
    }

    def ++=:(caseItems: JavaScriptSwitchCaseItem*) {
        _caseItems.++=:(caseItems)
    }

    private def ser(indent: Int) = "switch (" + switch + ")".space +
      "{" + newLine + _caseItems.map(_.serrialize(indent + indentSize)).mkString(newLine) + newLine + spaces(indent + indentSize) + "default:".newLine + default.serrialize(indent + indentSize) + {
        if (caseItems.isEmpty) "" else newLine
    } + spaces(indent) + "}"

    def serrialize(indent: Int): String = spaces(indent) + ser(indent)

    override def serrializeSTriplesWrap(indent: Int): String = spaces(indent) + ser(indent).strplQuotWrp
}

case class JavaScriptBody(elements: JavaScriptElement*) extends JavaScriptElement {
    private val _elements = ArrayBuffer(elements: _*)

    def +=(element: JavaScriptElement) {
        _elements += element
    }

    def +=:(element: JavaScriptElement) {
        _elements.+=:(element)
    }

    def ++=(elements: JavaScriptElement*) {
        _elements ++= elements
    }

    def ++=:(elements: JavaScriptElement*) {
        _elements.++=:(elements)
    }

    private def getCursesOpen = if (_elements.length > 1) "{" + newLine else ""
    private def getCursesClose = if (_elements.length > 1) "}" else ""

    def serrialize(indent: Int = 0): String = {
        getCursesOpen + {
            val res = new StringBuilder
            _elements foreach {
                element =>
                    res append element.serrialize(indent + indentSize)
                    if (element.serrialize() !== newLine)
                        res append newLine
            }
            if (!res.isEmpty && res.last === newLine.last)
                res.toString.substring(0, res.toString().length - 1)
            else
                res
        } + {
            if (getCursesClose != "")
                newLine + spaces(indent) + getCursesClose
            else
                ""
        }
    }
}

