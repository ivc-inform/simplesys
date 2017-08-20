package com.simplesys.xml.transform

import xml.transform.BasicTransformer
import xml.{NodeSeq, Node}

abstract class RewriteRule extends BasicTransformer {
  val name = this.toString

  override def transform(nodeSeq: Seq[Node]): NodeSeq = super.transform(nodeSeq)

  override def transform(node: Node): NodeSeq = node
}