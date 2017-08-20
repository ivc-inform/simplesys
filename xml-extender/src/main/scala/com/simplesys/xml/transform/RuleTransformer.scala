package com.simplesys.xml.transform

import xml.transform.BasicTransformer
import com.simplesys.log.Logging
import xml.{NodeSeq, Node}


class RuleTransformer(rules: RewriteRule*) extends BasicTransformer with Logging {
  override def transform(node: Node): NodeSeq = {
    rules.foldLeft(super.transform(node)) {
      (res, rule) => rule transform res
    }
  }
}

