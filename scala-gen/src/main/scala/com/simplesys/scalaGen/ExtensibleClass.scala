package com.simplesys.scalaGen

import com.simplesys.common.Strings._

sealed abstract class ExtensibleClass extends ScalaElement

case class ScalaClassGenericExtensible(`type`: ScalaBaseClassDeclare) extends ExtensibleClass {
    def serrialize(indent: Int) = `type` serrialize indent
}

case class ScalaClassExtensible(className: String) extends ExtensibleClass {
    def serrialize(indent: Int) = spaces(indent) + className
}

case object ScalaClassUndefigned extends ExtensibleClass {
    def serrialize(indent: Int = 0) = ""
}

case object ScalaClassClass extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "Class"
}

case object ScalaClassOperationBindings extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "OperationBindings"
}

case object ScalaClassAkkaHttpPartialServlet extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "AkkaHttpPartialServlet"
}

case object ScalaClassAkkaHttpMapServlet extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "AkkaHttpMapServlet"
}

case object ScalaClassActor extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "Actor"
}

case object ScalaClassCommonSuite extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "CommonSuite"
}

case object ScalaClassIscHtmlDyn extends ExtensibleClass {
    def serrialize(indent: Int = 0) = spaces(indent) + "IscHtmlDyn"
}