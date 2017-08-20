package com.simplesys.isc.system.typesDyn


sealed abstract trait ValidatorType

case object vldTpNull extends ValidatorType {
  override def toString = ""
}

case object vldTpIsBoolean extends ValidatorType {
  override def toString = "isBoolean"
}

case object vldTpIsString extends ValidatorType {
  override def toString = "isString"
}

case object vldTpIsInteger extends ValidatorType {
  override def toString = "isInteger"
}

case object vldTpIsFloat extends ValidatorType {
  override def toString = "isFloat"
}

case object vldTpIsFunction extends ValidatorType {
  override def toString = "isFunction"
}

case object vldRequiredIf extends ValidatorType {
  override def toString = "requiredIf"
}

case object vldTpMatchesField extends ValidatorType {
  override def toString = "matchesField"
}

case object vldTpIsOneOf extends ValidatorType {
  override def toString = "isOneOf"
}

case object vldTpIntegerRange extends ValidatorType {
  override def toString = "integerRange"
}

case object vldTpLengthRange extends ValidatorType {
  override def toString = "lengthRange"
}

case object vldTpContains extends ValidatorType {
  override def toString = "contains"
}

case object vldTpDoesntContain extends ValidatorType {
  override def toString = "doesntContain"
}

case object vldTpSubstringCount extends ValidatorType {
  override def toString = "substringCount"
}

case object vldTpRegexp extends ValidatorType {
  override def toString = "regexp"
}

case object vldTpMask extends ValidatorType {
  override def toString = "mask"
}

case object vldTpDateRange extends ValidatorType {
  override def toString = "dateRange"
}

case object vldTpFloatLimit extends ValidatorType {
  override def toString = "floatLimit"
}

case object vldTpFloatRange extends ValidatorType {
  override def toString = "floatRange"
}

case object vldTpFloatPrecision extends ValidatorType {
  override def toString = "floatPrecision"
}

case object vldTpRequired extends ValidatorType {
  override def toString = "required"
}

case object vldTpReadOnly extends ValidatorType {
  override def toString = "readOnly"
}

case object vldTpIsUnique extends ValidatorType {
  override def toString = "isUnique"
}

case object vldTpHasRelatedRecord extends ValidatorType {
  override def toString = "hasRelatedRecord"
}

case object vldTpServerCustom extends ValidatorType {
  override def toString = "serverCustom"
}

