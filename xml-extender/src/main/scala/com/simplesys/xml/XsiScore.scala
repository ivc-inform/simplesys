package com.simplesys.xml


import scala.xml.{TopScope, NamespaceBinding}
import XML.{xsi, xsiNamespace}

object XsiScore extends NamespaceBinding(xsi, xsiNamespace, TopScope)