package com.simplesys.html

import com.simplesys.log.Logging
import com.simplesys.xml.Elem
import com.simplesys.common.Strings._

import scala.xml.{Null, TopScope, NodeSeq}
import scala.xml.NodeSeq._

abstract class HtmlAttribute[T](val name: String, val value: T)

case class id[T](override val value: T) extends HtmlAttribute(name = "id", value = value)
case class `class`[T](override val value: T) extends HtmlAttribute(name = "class", value = value)

sealed abstract class Html(val label: String, val elements: Option[NodeSeq], val text: String, val attributes: HtmlAttribute[_]*) extends Logging {
    if (elements != None && text.nonEmpty)
        throw new RuntimeException("The elements and the text can not be simultaneously present")

    def toXML: Elem = {
        var res: Elem =
            if (text.isEmpty)
                Elem(null, label, Null, TopScope, true)
            else
                Elem(null, label, Null, TopScope, true).setElementText(label, text)
        attributes foreach (attribute => res = res.setElementAttribute(attribute.name, attribute.value))

        if (elements != None)
            res = res appendElement elements.get

        res
    }

    def logPretty(debug: Boolean = false) =
        if (debug)
            logger debug newLine + toXML.toPrettyString
        else
            logger trace newLine + toXML.toPrettyString

    def log(debug: Boolean = false) =
        if (debug)
            logger debug newLine + toXML.toString
        else
            logger trace newLine + toXML.toString
}


object Span {
    def apply(attributes: HtmlAttribute[_]*): Span = new Span(None, strEmpty, attributes: _*)

    def apply(elements: Seq[Html], attributes: HtmlAttribute[_]*): Span = new Span(Some(elements.map(_.toXML)), strEmpty, attributes: _*)
    def apply(element: Html, attributes: HtmlAttribute[_]*): Span = new Span(Some(element.toXML), strEmpty, attributes: _*)

    def apply(text: String, attributes: HtmlAttribute[_]*): Span = new Span(None, text, attributes: _*)
    def apply(text: CharSequence, attributes: HtmlAttribute[_]*): Span = new Span(None, text.toString, attributes: _*)
}

case class Span(override val elements: Option[NodeSeq], override val text: String, override val attributes: HtmlAttribute[_]*) extends Html("span", elements, text, attributes: _*)

