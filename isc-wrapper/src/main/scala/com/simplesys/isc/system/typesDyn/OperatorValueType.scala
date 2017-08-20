
package com.simplesys.isc.system.typesDyn


sealed abstract trait OperatorValueType

case object opVlTpFieldType extends OperatorValueType {
  override def toString = "fieldType"
}

case object opVlTpfieldName extends OperatorValueType {
  override def toString = "fieldName"
}

case object opVlTpNone extends OperatorValueType {
  override def toString = "none"
}

case object opVlTpCriteria extends OperatorValueType {
  override def toString = "criteria"
}

case object opVlTpValueRange extends OperatorValueType {
  override def toString = "valueRange"
}

case object opVlTpValueSet extends OperatorValueType {
  override def toString = "valueSet"
}

case object opVlTpCustom extends OperatorValueType {
  override def toString = "custom"
}
