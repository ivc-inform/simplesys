package com.simplesys.isc.system.misc

class XPathExpressionString(value: String) {
  def XPath = XPathExpression(value)
}

case class XPathExpression(value: String) {
  override def toString = value
}