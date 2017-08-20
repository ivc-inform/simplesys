package com.simplesys.xml.transform

import scala.xml.{Atom, Text, Node, Comment}
import org.w3c.dom.{Node => JNode, Document => JDocument, Element => JElement}
import javax.xml.parsers.DocumentBuilderFactory
import XmlHelpers._
import com.simplesys.xml.Elem

object XmlHelpers {
  val docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()

  implicit def nodeExtras(n: Node) = new NodeExtras(n)
  implicit def elemExtras(e: Elem) = new ElemExtras(e)
}

class NodeExtras(n: Node) {
  def toJdkNode(doc: JDocument): JNode =
    n match {
      case Elem(prefix, label, attributes, scope, children@_*) =>
        // XXX: ns
        val r = doc.createElement(label)
        for (a <- attributes) {
          r.setAttribute(a.key, a.value.text)
        }
        for (c <- children) {
          r.appendChild(c.toJdkNode(doc))
        }
        r
      case Text(text) => doc.createTextNode(text)
      case Comment(comment) => doc.createComment(comment)
      // not sure
      case a: Atom[_] => doc.createTextNode(a.data.toString)
      // XXX: other types
      case x => throw new Exception(x.getClass.getName)
    }
}

class ElemExtras(e: Elem) extends NodeExtras(e) {
  override def toJdkNode(doc: JDocument) = super.toJdkNode(doc).asInstanceOf[JElement]

  def toJdkDoc: JDocument = {
    val doc = XmlHelpers.docBuilder.newDocument()
    doc.appendChild(toJdkNode(doc))
    doc
  }
}

