package com.simplesys.scalaGen

import com.simplesys.common.Strings._

sealed abstract class AbstractScalaType extends ScalaElement

case class ScalaType(name: String) extends AbstractScalaType {
    def serrialize(indent: Int) = name
}

case class ScalaOption(`type`: AbstractScalaType) extends AbstractScalaType {
    def serrialize(indent: Int) = spaces(indent) + "Option[" + `type`.serrialize() + "]"
}

case class ScalaClassGenericType(`type`: ScalaBaseClassDeclare) extends AbstractScalaType {
    def serrialize(indent: Int) = `type` serrialize indent
}

case object ScalaImplicitType extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + ""
}

case object ScalaInt extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "Int"
}

case object ScalaDouble extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "Double"
}

case object ScalaBoolean extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "Boolean"
}

case object ScalaString extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "String"
}

case object ScalaActorRef extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "ActorRef"
}

case object ScalaActorSystem extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "ActorSystem"
}

case object ScalaEndpointsAgentPartial extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "EndpointsAgentPartial"
}

case object ScalaEndpointsAgentMap extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "EndpointsAgentMap"
}

case object ScalaHttpServletRequest extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "HttpServletRequest"
}

case object ScalaHttpServletResponse extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "HttpServletResponse"
}

case object ScalaDSResponseDyn extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "DSResponseDyn"
}

case object ScalaBigDecimal extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "BigDecimal"
}

case object ScalaFunctionExpression extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "FunctionExpression"
}

case object ScalaMenuDyn extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "MenuDyn"
}

case object ScalaUnit extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "Unit"
}

case object ScalaProduct extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "Product"
}

case object ScalaResultSet extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "ResultSet"
}

case object ScalaBoneCPDataSource extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "BoneCPDataSource"
}

case object ScalaPoolDataSource extends AbstractScalaType {
    def serrialize(indent: Int = 0) = spaces(indent) + "PoolDataSource"
}
