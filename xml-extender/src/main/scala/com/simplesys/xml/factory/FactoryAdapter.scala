package com.simplesys.xml.factory

import org.xml.sax.helpers.DefaultHandler
import scala.xml.{TypeSymbol, Attribute, Null, TopScope, ProcInstr, Text, NamespaceBinding, MetaData, Node}
import scala.collection.mutable
import org.xml.sax.Attributes
import com.simplesys.xml.Elem
import javax.xml.validation.TypeInfoProvider
import com.simplesys.xml.Elem._

abstract class FactoryAdapter(val provider: TypeInfoProvider = null) extends DefaultHandler {
    var rootElem: Elem = null
    var types = collection.mutable.Map.empty[String, TypeSymbol]

    val buffer = new StringBuilder()
    val attribStack = new mutable.Stack[MetaData]
    val hStack = new mutable.Stack[Node]
    // [ element ] contains siblings
    val tagStack = new mutable.Stack[String]
    var scopeStack = new mutable.Stack[NamespaceBinding]

    var curTag: String = null
    var capture: Boolean = false

    def nodeContainsText(localName: String): Boolean // abstract

    def createNode(pre: String, elemName: String, attribs: MetaData, scope: NamespaceBinding, chIter: List[Node]): Elem
    def createNode(pre: String, elemName: String, attribs: MetaData, `type`: TypeSymbol, scope: NamespaceBinding, chIter: List[Node]): Elem

    def createText(text: String): Text // abstract

    /** creates a new processing instruction node.
      */
    def createProcInstr(target: String, data: String): Seq[ProcInstr]

    val normalizeWhitespace = false

    override def characters(ch: Array[Char], offset: Int, length: Int): Unit = {
        if (!capture)
            return
        else if (!normalizeWhitespace)
            buffer.appendAll(ch, offset, length)
        else {
            var it = ch.slice(offset, offset + length).iterator
            while (it.hasNext) {
                val c = it.next
                val isSpace = c.isWhitespace
                buffer append (if (isSpace) ' ' else c)
                if (isSpace)
                    it = it dropWhile (_.isWhitespace)
            }
        }
    }

    private def splitName(s: String) = {
        val idx = s indexOf ':'
        if (idx < 0) (null, s)
        else (s take idx, s drop (idx + 1))
    }

    override def startElement(uri: String,
                              _localName: String,
                              qname: String,
                              attributes: Attributes): Unit = {
        captureText()
        tagStack push curTag
        curTag = qname

        val localName = splitName(qname)._2
        capture = nodeContainsText(localName)

        hStack push null
        var m: MetaData = Null
        var scpe: NamespaceBinding =
            if (scopeStack.isEmpty)
                TopScope
            else scopeStack.top

        for (i <- 0 until attributes.getLength()) {
            val qname = attributes getQName i
            val value = attributes getValue i
            val (pre, key) = splitName(qname)
            def nullIfEmpty(s: String) = if (s == "") null else s

            if (pre == "xmlns" || (pre == null && qname == "xmlns")) {
                val arg = if (pre == null) null else key
                scpe = new NamespaceBinding(arg, nullIfEmpty(value), scpe)
            }
            else
                m = Attribute(Option(pre), key, Text(value), m)
        }

        provider match {
            case null =>
                types.clear()
            case p: TypeInfoProvider =>
                types(qname) = p.getElementTypeInfo.getTypeName
        }

        scopeStack push scpe
        attribStack push m
    }

    def captureText(): Unit = {
        if (capture && buffer.length > 0)
            hStack push createText(buffer.toString)

        buffer.clear()
    }

    override def endElement(uri: String, _localName: String, qname: String): Unit = {
        captureText()
        val metaData = attribStack.pop

        val v = (Iterator continually hStack.pop takeWhile (_ != null)).toList.reverse
        val (pre, localName) = splitName(qname)
        val scp = scopeStack.pop

        provider match {
            case null =>
                rootElem = createNode(pre, localName, metaData, scp, v)
            case p: TypeInfoProvider =>
                rootElem = createNode(pre, localName, metaData, types(qname), scp, v)
        }


        hStack push rootElem

        curTag = tagStack.pop
        capture = curTag != null && nodeContainsText(curTag)
    }

    override def processingInstruction(target: String, data: String) {
        hStack pushAll createProcInstr(target, data)
    }
}