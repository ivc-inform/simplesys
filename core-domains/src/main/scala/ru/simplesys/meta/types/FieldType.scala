package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import ru.simplesys.meta.types.SCSimpleType

sealed abstract trait FieldType extends SCSimpleType {
    lazy val scalaClassName: String = this.getClass.getSimpleName.split("\\$").last
    override def scName: String = toString
}

case object ftNull extends FieldType {
    override def toString = ""
}

case object ftText extends FieldType {
    override def toString = "text"
}

case object ftTextArea extends FieldType {
    override def toString = "textArea"
}

case object ftBoolean extends FieldType {
    override def toString = "boolean"
}

case object ftInteger extends FieldType {
    override def toString = "integer"
}

case object ftFloat extends FieldType {
    override def toString = "float"
}

case object ftDate extends FieldType {
    override def toString = "date"
}

case object ftTime extends FieldType {
    override def toString = "time"
}

case object ftDateTime extends FieldType {
    override def toString = "datetime"
}

case object ftDateTimeSS extends FieldType {
    override def toString = "DateTimeItemSS"
}

case object ftEnum extends FieldType {
    override def toString = "enum"
}

case object ftIntEnum extends FieldType {
    override def toString = "intEnum"
}

case object ftSequence extends FieldType {
    override def toString = "sequence"
}

case object ftLink extends FieldType {
    override def toString = "link"
}

case object ftImage extends FieldType {
    override def toString = "image"
}

case object ftBinary extends FieldType {
    override def toString = "binary"
}

case object ftImageFile extends FieldType {
    override def toString = "imageFile"
}

case object ftAny extends FieldType {
    override def toString = "any"
}

case object ftModifier extends FieldType {
    override def toString = "modifier"
}

case object ftModifierTimestamp extends FieldType {
    override def toString = "modifierTimestamp"
}

case object ftCreator extends FieldType {
    override def toString = "creator"
}

case object ftCreatorTimestamp extends FieldType {
    override def toString = "creatorTimestamp"
}

case object ftPassword extends FieldType {
    override def toString = "password"
}

case object ftCustom extends FieldType {
    override def toString = "custom"
}

case object ftNtext extends FieldType {
    override def toString = "ntext"
}

object FieldType {
    private val values = SealedEnumRuntime.values[FieldType]
    private val mappedKeys: Map[String, FieldType] = values.map(x => (x.toString, x))(collection.breakOut)
    def getObject(objName: String): FieldType = mappedKeys(objName)
}
