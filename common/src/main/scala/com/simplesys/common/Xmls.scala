package com.simplesys.common

import scala.xml.{Elem, Node, NodeSeq, PrettyPrinter}


object XMLs {
    implicit class NodeSeqWrapper(nodeSeq: NodeSeq) {
        def textOption: Option[String] = {
            val text = nodeSeq.text
            if (text == null || text.isEmpty) None else Some(text)
        }
    }

    @inline
    def p(width: Int = 250, step: Int = 4) = new PrettyPrinter(width, step)

    implicit class ElemOpt(elem: Elem) {
        def toPrettyString(width: Int = 250, step: Int = 4): String = p(width, step).format(elem)
    }

    implicit class NodeOpt(elem: Node) {
        def toPrettyString(width: Int = 250, step: Int = 4): String = p(width, step).format(elem)
    }
}


