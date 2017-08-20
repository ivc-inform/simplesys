package com.simplesys.xml

import com.simplesys.common.Strings._
import com.simplesys.common._
import com.simplesys.log.Logging
import com.simplesys.xml.transform.{RewriteRule, RuleTransformer}

import scala.xml.NodeSeq._
import scala.xml.{Elem => SElem, _}

object Elem {

    implicit def apply(elem: SElem): Elem = new Elem(elem.prefix, elem.label, elem.attributes, TypeNull, elem.scope, elem.minimizeEmpty, elem.child: _*)
    implicit def apply(elem: Elem): SElem = new SElem(elem.prefix, elem.label, elem.attributes, elem.scope, elem.minimizeEmpty, elem.child: _*)

    implicit def node2sElem(node: Node): SElem = SElem(node.prefix, node.label, node.attributes, node.scope, node.child.isEmpty, node.child: _*)
    implicit def node2Elem(node: Node): Elem = Elem(node.prefix, node.label, node.attributes, node.xmlType, node.scope, node.child.isEmpty, node.child: _*)

    implicit def nodeSeq2sElem(seq: NodeSeq): SElem = {
        if (seq.isEmpty)
            SElem(null, "None", Null, TopScope, true)
        else if (seq.length == 1)
            node2sElem(seq(0))
        else
            SElem(null, "Synthetic", Null, TopScope, true, seq: _*)
    }

    implicit def nodeSeq2Elem(seq: NodeSeq): Elem = {
        if (seq.isEmpty)
            Elem(null, "None", Null, TopScope, true)
        else if (seq.length == 1)
            node2Elem(seq(0))
        else
            Elem(null, "Synthetic", Null, TopScope, true, seq: _*)
    }

    implicit def seqNode2sElem(seq: Seq[Node]): SElem = nodeSeq2sElem(seqToNodeSeq(seq))

    implicit def seqNode2Elem(seq: Seq[Node]): Elem = nodeSeq2Elem(seqToNodeSeq(seq))

    implicit def str2TypeStr(str: String): TypeSymbol = TypeString(str)

    def apply(prefix: String, label: String, attributes: MetaData, `type`: TypeSymbol, scope: NamespaceBinding, minimizeEmpty: Boolean, child: Node*): Elem =
        new Elem(prefix, label, attributes, `type`, scope, minimizeEmpty, child: _*)

    def apply(prefix: String, label: String, attributes: MetaData, scope: NamespaceBinding, minimizeEmpty: Boolean, child: Node*): Elem =
        new Elem(prefix, label, attributes, TypeNull, scope, minimizeEmpty, child: _*)

    def unapplySeq(n: Node) = n match {
        case _: SpecialNode | _: Group => None
        case _ => Some((n.prefix, n.label, n.attributes, n.scope, n.child))
    }
}

case object TypeNull extends TypeSymbol {
    override def toString: String = ""
}

case class TypeString(value: String) extends TypeSymbol {
    override def toString: String = value
}

class Elem(override val prefix: String,
           override val label: String,
           attributes1: MetaData,
           `type`: TypeSymbol,
           override val scope: NamespaceBinding,
           override val minimizeEmpty: Boolean,
           override val child: Node*) extends SElem(prefix, label, attributes1, scope, minimizeEmpty, child: _*) with Logging {

    private def unEscape: String = super.toString.unEscape.normalizedSpaces

    /*override def toString: String = {
      logger warn "Execute toString()"
      super.toString
    }*/

    def toUnEscapeString: String = unEscape

    override val xmlType: TypeSymbol = `type`

    def toPrettyString(width: Int, indent: Int): String = (new PrettyPrinter(width, indent)).format(this)
    def toPrettyString(indent: Int): String = toPrettyString(200, indent)
    def toPrettyString: String = toPrettyString(200, 4)

    private def setAttribute(name: String, value: Option[String]): Elem = {
        value match {
            case Some(x) => this % Attribute("", name, x, Null)
            case None => new SElem(prefix, label, attributes.remove(name), scope, child.isEmpty, child: _*)
        }
    }

    def setElementAttribute[T](name: String, value: T): Elem = setAttribute(name, Option(value.toString))

    def removeElementAttribute(name: String): Elem = setAttribute(name, None)

    private def setElementAttribute(elemName: String, attrName: String, attrValue: String, editAttrName: String, newAttrValue: Option[String]): Elem = {
        val rule = new RewriteRule {
            override def transform(node: Node): NodeSeq = {
                node match {
                    case e: SElem if (e.label == elemName) =>
                        attrName.isEmpty match {
                            case true => e
                            case false =>
                                if ((node \ ("@" + attrName)).text == attrValue)
                                    Elem(e) setAttribute(editAttrName, newAttrValue)
                                else
                                    e
                        }
                    case n => n
                }
            }
        }

        new RuleTransformer(rule).transform(this)
    }

    def setElementAttribute(elemName: String, attrName: String, attrValue: String, editAttrName: String, newAttrValue: String): Elem =
        setElementAttribute(elemName, attrName, attrValue, editAttrName, Option(newAttrValue))

    def removeElementAttribute(elemName: String, attrName: String, attrValue: String, editAttrName: String): Elem =
        setElementAttribute(elemName, attrName, attrValue, editAttrName, None)

    def setElementAttribute(elemName: String, attrName: String, attrValue: String, newAttrValue: String): Elem = setElementAttribute(elemName, attrName, attrValue, attrName, newAttrValue)

    def setElement(parElementName: String, attrName: String, attrValue: String, elem: NodeSeq, append: Boolean = false): Elem = {
        val rule = new RewriteRule {
            override def transform(node: Node): NodeSeq = {
                node match {
                    case e: SElem if (e.label == parElementName) =>
                        attrName.isEmpty match {
                            case true =>
                                if (append)
                                    new SElem(e.prefix, e.label, e.attributes, e.scope, e.child.isEmpty, e.child ++ elem: _*)
                                else
                                    new SElem(e.prefix, e.label, e.attributes, e.scope, e.child.isEmpty, elem: _*)
                            case false =>
                                if ((node \ ("@" + attrName)).text == attrValue) {
                                    if (append)
                                        new SElem(e.prefix, e.label, e.attributes, e.scope, e.child.isEmpty, e.child ++ elem: _*)
                                    else
                                        new SElem(e.prefix, e.label, e.attributes, e.scope, e.child.isEmpty, elem: _*)
                                }
                                else
                                    e
                        }
                    case n => n
                }
            }
        }
        new RuleTransformer(rule).transform(this)
    }


    def removeElement(delElementName: String, attrName: String, attrValue: String): Elem = {
        val rule = new RewriteRule {
            override def transform(node: Node): NodeSeq = {
                node match {
                    case e: SElem if (e.label == delElementName) =>
                        attrName.isEmpty match {
                            case true => NodeSeq Empty
                            case false =>
                                if ((node \ ("@" + attrName)).text == attrValue)
                                    NodeSeq Empty
                                else
                                    e
                        }
                    case n => n
                }
            }
        }

        new RuleTransformer(rule).transform(this)
    }

    def removeElement(delElemName: String): Elem = removeElement(delElemName, "", "")

    def setElement(parElementName: String, elem: NodeSeq): Elem = setElement(parElementName, "", "", elem)

    def setElementText(parElementName: String, attrName: String, attrValue: String, text: String): Elem = setElement(parElementName, attrName, attrValue, Text(text))

    def setElementText(parElementName: String, text: String): NodeSeq = setElementText(parElementName, "", "", text)

    def appendElement(parElementName: String, attrName: String, attrValue: String, elem: NodeSeq): Elem = setElement(parElementName, attrName, attrValue, elem, true)

    def appendElement(parElementName: String, elem: NodeSeq): Elem = appendElement(parElementName, "", "", elem)

    def appendElement(elem: NodeSeq): Elem = appendElement(label, "", "", elem)


    val indentOffset = 4

    private def logging(debug: Boolean, value: String): Unit = {
        if (debug)
            logger debug value
        else
            logger trace value
    }

    def log {
        log()
    }

    def log(debug: Boolean = false) {
        logging(debug, s"label: ${label}, type: ${xmlType}, text: ${selfText} (${selfText.toHex})")
        val ml = maxLength(this)
        attributes foreach {
            attribute => logging(debug, spaces(indentOffset / 2) + s"attribute: ${attribute.key}${if (ml == 0) strEmpty else spaces(ml - attribute.key.length)}=${attribute.value}")
        }
        log(debug = debug, node = this, indent = 0)
        logging(debug, fill(length = 150, str = "="))
    }

    private def maxLength(node: Node) = if (node.attributes.isEmpty) 0 else node.attributes.reduceLeft((a, b) => if (a.key.length > b.key.length) a else b).key.length

    private def log(debug: Boolean, node: Node, indent: Int) {
        for (node <- node.child) {
            if (node.label != "#PCDATA") {
                logging(debug, spaces(indent + indentOffset) + s"label: ${node.label}, type: ${node.xmlType}, text: ${(node: Elem).selfText} (${(node: Elem).selfText.toHex})")

                val ml = maxLength(node)
                node.attributes foreach {
                    attribute => logging(debug, spaces(indent + indentOffset + indentOffset / 2) + s"attribute: ${attribute.key}${if (ml == 0) "" else spaces(ml - attribute.key.length)}=${attribute.value}")
                }
                log(debug = debug, node = node, indent = indent + indentOffset)
            }
        }
    }

    def logElement(debug: Boolean = false) {
        //logger trace (s"prefix: ${prefix}, label: ${label}, attributes1: ${attributes1}, scope: ${scope}, minimizeEmpty: ${minimizeEmpty}, type: ${`type`}")
        logging(debug, s"label: ${label}, type: ${xmlType.toString}")
    }

    def selfText: String = {
        var res = ""
        import scala.util.control.Breaks._
        breakable {
            for (item <- this.child.filter(item => (item.label == "#PCDATA" && item.text.trim != ""))) {
                res = item.text
                break
            }
        }

        res.trim
    }
}
