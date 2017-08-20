package ru.simplesys
package meta
package types

import java.io.InputStream

import org.joda.time.{DateTime, LocalDate, LocalDateTime}
import com.simplesys.xml.{Elem, TypeNull, XsiScore}
import com.simplesys.xml.Elem._

import scala.xml._
import scala.xml.NamespaceBinding
import com.simplesys.isc.system.{typesDyn => iscTypes}
import com.simplesys.isc.system.typesDyn.OperatorId
import org.joda.time.format.DateTimeFormat

trait MetaType[T] {
    type A = T
    def guid: String = ""
}

import liquibase.database.Database
import liquibase.database.core._
import liquibase.datatype.LiquibaseDataType
import liquibase.datatype.core._
import com.simplesys.common.Strings._
import com.simplesys.json._

//---------------------------------------------------------------------------------

trait SchemaDefProto {
    def prefixPath: String
}

//---------------------------------------------------------------------------------
// Scala type representation trait

trait ScalaType[T] {
    def stringToSourceValue(s: String): String = s
    def stringToSourceValueWOption(s: String): String = s"Some(${stringToSourceValue(s)})"

    def stringToSourceValueConditional(isMandatory: Boolean, s: String): String = if (isMandatory) stringToSourceValue(s) else stringToSourceValueWOption(s)

    def toStringWOption: String = s"Option[${toString}]"

    def toStringConditional(isMandatory: Boolean): String = if (isMandatory) toString else toStringWOption
    def default: T
    def toXML: Elem
}

object ScalaTypeBigDecimal extends ScalaType[BigDecimal] {
    override def toString: String = "BigDecimal"
    def default: BigDecimal = 0
    def toXML: Elem = <common:double>{default.toString}</common:double>
}

object ScalaTypeLong extends ScalaType[Long] {
    override def toString: String = "Long"
    def default: Long = 0
    def toXML: Elem = <common:long>{default.toString}</common:long>
}

object ScalaTypeString extends ScalaType[String] {
    override def toString: String = "String"
    override def stringToSourceValue(s: String): String = "\"\"\"" + s + "\"\"\""
    def default: String = "введите данные"
    def toXML: Elem = <common:string>{default.toString}</common:string>
}

object ScalaTypeClob extends ScalaType[String] {
    override def toString: String = "Clob"
    override def stringToSourceValue(s: String): String = "\"\"\"" + s + "\"\"\""
    def default: String = "введите данные"
    def toXML: Elem = <common:clob>{default.toString}</common:clob>
}

object ScalaTypeJson extends ScalaType[String] {
    override def toString: String = "Json"
    override def stringToSourceValue(s: String): String = "\"\"\"" + s + "\"\"\""
    def default: String = "введите данные"
    def toXML: Elem = <common:json>{default.toString}</common:json>
}


object ScalaTypeBlob extends ScalaType[String] {
    override def toString: String = "Blob"
    override def stringToSourceValue(s: String): String = "\"\"\"" + s + "\"\"\""
    def default = "введите данные"
    def toXML: Elem = <common:blob>{default.toString}</common:blob>
}

object ScalaTypeBoolean extends ScalaType[Boolean] {
    override def toString: String = "Boolean"
    def default: Boolean = false
    override def toXML: Elem = <common:boolean>{default.toString}</common:boolean>
}

object ScalaTypeLocalDateTime extends ScalaType[LocalDateTime] {
    override def toString: String = "LocalDateTime"
    override def stringToSourceValue(str: String): String = {
        if (str.contains(":") && str.length > 10)
            "LocalDateTime.parse(\"" + str + "\", DateTimeFormat.forPattern(\"dd.MM.yyyy HH:mm:ss\"))"
        else
            "LocalDateTime.parse(\"" + str + "\", DateTimeFormat.forPattern(\"dd.MM.yyyy\"))"
    }
    override def default: LocalDateTime = new LocalDateTime(0)
    override def toXML: Elem = <common:localDateTime>{default.toString()}</common:localDateTime>
}

object ScalaTypeDateTime extends ScalaType[DateTime] {
    override def toString: String = "DateTime"
    override def stringToSourceValue(str: String): String = {
        if (str.contains(":") && str.length > 10)
            "DateTime.parse(\"" + str + "\", DateTimeFormat.forPattern(\"dd.MM.yyyy HH:mm:ss\"))"
        else
            "DateTime.parse(\"" + str + "\", DateTimeFormat.forPattern(\"dd.MM.yyyy\"))"
    }
    override def default: DateTime = new DateTime(0)
    override def toXML: Elem = <common:dateTime>{default.toString()}</common:dateTime>
}

object ScalaTypeDouble extends ScalaType[Double] {
    override def toString: String = "Double"
    override def default: Double = 0
    override def toXML: Elem = <common:double>{default.toString}</common:double>
}


//---------------------------------------------------------------------------------
// DB type representation trait

trait DBDataType {
    def dbDataType: LiquibaseDataType
    def getDBString(implicit db: Database): String = dbDataType.toDatabaseDataType(db).toString
    def sqlDataType: Int
    def allowedOperations: Option[Set[iscTypes.OperatorId]]
}

trait DBDataTypeExt[T] extends DBDataType {
    type SimpeType = T
    def bind(value: T): Unit
}

case object BigDecimalDataType extends DBDataTypeExt[BigDecimal] {
    override val dbDataType = new NumberType
    def sqlDataType: Int = java.sql.Types.NUMERIC
    override def bind(value: BigDecimal): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}

case object IntegerDataType extends DBDataTypeExt[Int] {
    override val dbDataType = new BigIntType
    def sqlDataType: Int = java.sql.Types.BIGINT
    override def bind(value: Int): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}

case class VarcharDataType(length: Int) extends DBDataTypeExt[String] {
    override val dbDataType = {
        val dbType = (new VarcharType())
        dbType.addParameter(length)
        dbType
    }
    def sqlDataType: Int = java.sql.Types.VARCHAR
    override def bind(value: String): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            opIdIContains, opIdContains,
            opIdEquals, opIdIEquals,
            opIdNotEqual, opIdINotEqual,
            opIdStartsWith, opIdIStartsWith,
            opIdEndsWith, opIdIEndsWith,
            opIdIsNull, opIdNotNull,
            opIdInSet, opIdNotInSet
        ))
    }

}

case object LongDataType extends DBDataTypeExt[Long] {
    override val dbDataType = new IntType
    def sqlDataType: Int = java.sql.Types.BIGINT
    override def bind(value: Long): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}

case object DoubleDataType extends DBDataTypeExt[Double] {
    override val dbDataType = new DoubleType
    def sqlDataType: Int = java.sql.Types.DOUBLE
    override def bind(value: Double): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}

case object BooleanDataType extends DBDataTypeExt[Boolean] {
    override val dbDataType = new BooleanType
    def sqlDataType: Int = java.sql.Types.BOOLEAN
    override def bind(value: Boolean): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = None
}

case object BlobDataType extends DBDataTypeExt[String] {
    override val dbDataType = new BlobType
    def sqlDataType: Int = java.sql.Types.BLOB
    override def bind(value: String): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = None
}

case object DateTimeDataType extends DBDataTypeExt[LocalDateTime] {
    override val dbDataType = new DateTimeType
    def sqlDataType: Int = java.sql.Types.TIMESTAMP
    override def bind(value: LocalDateTime): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}

case object TimestampDataType extends DBDataTypeExt[LocalDateTime] {
    override val dbDataType = new TimestampType
    def sqlDataType: Int = java.sql.Types.TIMESTAMP
    override def bind(value: LocalDateTime): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}


case object TimestampWTZDataType extends DBDataTypeExt[DateTime] {
    override val dbDataType = new TimestampType
    def sqlDataType: Int = java.sql.Types.TIMESTAMP
    override def bind(value: DateTime): Unit = {}
    override def allowedOperations: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdGreaterThan, opIdLessThan, opIdGreaterOrEqual, opIdLessOrEqual, opIdBetweenInclusive, opIdBetween, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //строковые
            opIdContains, opIdStartsWith, opIdEndsWith, opIdNotContains, opIdNotStartsWith, opIdNotEndsWith, opIdMatchesPattern, opIdContainsPattern, opIdRegexp,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField, opIdGreaterThanField, opIdLessThanField, opIdGreaterOrEqualField, opIdLessOrEqualField
        ))
    }
}


//---------------------------------------------------------------------------------
//SmartClient SimpleType

trait SCSimpleType {
    def scInheritsFrom: Option[SCSimpleType] = None
    def scName: String
    def scLength: Option[Int] = None
    def scEditorType: Option[String] = None
    def scReadOnlyEditorType: Option[String] = None
    def scValidOperators: Option[Set[iscTypes.OperatorId]] = None
    // should be String, JsonObject or smth more clever?
    def scValidators: Option[Seq[String]] = None
    def scFieldProperties: Option[JsonObject] = None
    //  def normalDisplayFormatter
    //  def shortDisplayFormatter
    //  def editFormatter

    def toXML: Elem = {
    <SimpleType>
      <name>{scName}</name>
      {scLength.map(sc => <length>{sc.toString}</length>).orNull}
      {scInheritsFrom.map(sc => <inheritsFrom>{sc.toString}</inheritsFrom>).orNull}
      {scEditorType.map(et => <editorType>{et}</editorType>).orNull}
      {scReadOnlyEditorType.map(et => <readOnlyEditorType>{et}</readOnlyEditorType>).orNull}
      {scValidOperators.map(x => <validOperators>{x.map(y => {<validOperator>{y.toString}</validOperator>})}</validOperators>).orNull}
      {scValidators.map(x => <validators>{x.map(y => {<validator>{y}</validator>})}</validators>).orNull}
      <!--      {scFieldProperties.map(fp => <fieldProperties>{fp}</fieldProperties>).orNull}-->
    </SimpleType>
  }
}


//---------------------------------------------------------------------------------
//Mixed all representations (domain supertype)

trait DataType[T] {
    //  def name: String
    def scalaTypeAsString(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String
    def scalaTypeAsStringConditional(isMandatory: Boolean)(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = if (isMandatory) scalaTypeAsString(currentGroupName, protoResolver) else s"Option[${scalaTypeAsString(currentGroupName, protoResolver)}]"
    def simpleDataType: SimpleDataType[T]
    def simpleScalaType: ScalaType[T]
    //def stringToSourceValue(s: String): String
    def dbPrefix: String
    def dbDataType: DBDataTypeExt[T]
    def jooqDataType: String
    def converterName(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): Option[String]
    def metaType(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String

    def jooqTypeDefMandatory(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String
    def jooqTypeDefOptional(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String

    def isComplexDataType: Boolean
}

class ComplexDataType[T](val groupName: Locator, val containterType: Option[String], val scalaComplexType: String, val simpleDataType: SimpleDataType[T]) extends DataType[T] {
    def scalaTypeAsString(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = {
        if (groupName == currentGroupName) "" else s"${protoResolver.prefixPath}.${groupName}."
    } + containterType.map(_ + ".").getOrElse("") + scalaComplexType
    def simpleScalaType: ScalaType[T] = simpleDataType.simpleScalaType
    def dbPrefix: String = simpleDataType.dbPrefix
    def dbDataType: DBDataTypeExt[T] = simpleDataType.dbDataType
    def jooqDataType: String = simpleDataType.jooqDataType

    def metaType(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = {
        if (groupName == currentGroupName) "" else groupName + "."
    } + containterType.map(_ + ".").getOrElse("") + s"Domain${scalaTypeAsString}"
    def converterName(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): Option[String] = Some(metaType)

    def jooqTypeDefMandatory(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = jooqDataType + s".asConvertedDataType(${scalaTypeAsString})"
    def jooqTypeDefOptional(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = jooqDataType + s".asOptionMapped(${scalaTypeAsString})"

    override def isComplexDataType: Boolean = true
}

class SimpleDataType[T](val name: String, val simpleScalaType: ScalaType[T], val dbPrefix: String, val dbDataType: DBDataTypeExt[T], val jooqDataType: String, val builtinConverterName: Option[String]) extends DataType[T] with SCSimpleType {
    def simpleDataType: SimpleDataType[T] = this

    def scalaTypeAsString(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = simpleScalaType.toString
    def stringToSourceValue(s: String): String = simpleScalaType.stringToSourceValue(s)
    def metaType(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = "Domain" + simpleScalaType
    def converterName(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): Option[String] = builtinConverterName

    def jooqTypeDefMandatory(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = jooqDataType + converterName.map("." + _.unCapitalize).getOrElse("")
    def jooqTypeDefOptional(implicit currentGroupName: Locator, protoResolver: SchemaDefProto): String = jooqDataType + converterName.map(x => s".asOptionMapped(${x})").getOrElse(".asOption")

    def autoIncGeneratorFunctionName: Option[String] = None

    override def isComplexDataType: Boolean = false
    override def scName = name

    override def scLength: Option[Int] = if (jooqDataType.indexOf("VARCHAR") == -1) None else Some(jooqDataType.substring(jooqDataType.indexOf("(") + 1, jooqDataType.indexOf(")")).toInt)
    override def toString = scName
    override def scValidOperators = dbDataType.allowedOperations

    //Не должно быть лишних пробелов от форматировщика !!!!
    override def toXML: Elem = {
        (<SimpleDataType>
            <simpleScalaType>
                <default>{simpleScalaType.toXML}</default>
                <typeName>{simpleScalaType}</typeName>
            </simpleScalaType>
            <dbPrefix>{dbPrefix}</dbPrefix>
            <jooqDataType>
                <type>{if (jooqDataType.indexOf("VARCHAR") == -1) jooqDataType else "VARCHAR"}</type>{if (jooqDataType.indexOf("VARCHAR") == -1) NodeSeq.Empty
            else <length>{jooqDataType.substring(jooqDataType.indexOf("(") + 1, jooqDataType.indexOf(")"))}</length>}
            </jooqDataType>
            <isc>
              {super[SCSimpleType].toXML}
            </isc>
        </SimpleDataType>: Elem).setElementAttribute(elemName = "SimpleDataType", attrName = "name", attrValue = "", newAttrValue = scName)
    }
}


//---------------------------------------------------------------------------------
//Concrete domain types

case object DomainDI extends SimpleDataType("di", ScalaTypeBigDecimal, "di", BigDecimalDataType, "NUMERIC", Some("AsBigDecimal")) with MetaType[BigDecimal] {
    override def autoIncGeneratorFunctionName = Some("nextBigDecimal()")

    override val scInheritsFrom = Some(iscTypes.ftFloat)

    override def scValidOperators: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField
        ))
    }
}

case object DomainID extends SimpleDataType("id", ScalaTypeLong, "id", LongDataType, "BIGINT", Some("AsLong")) with MetaType[Long] {
    override def autoIncGeneratorFunctionName = Some("nextDouble()")

    override val scInheritsFrom = Some(iscTypes.ftInteger)

    override def scValidOperators: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField
        ))
    }
}

case object DomainSS extends SimpleDataType("ss", ScalaTypeString, "ss", VarcharDataType(3), "VARCHAR.length(3)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)

    override def scValidOperators: Option[Set[iscTypes.OperatorId]] = {
        import iscTypes._
        Some(Set(
            //числовые
            opIdEquals, opIdNotEqual, opIdInSet, opIdNotInSet, opIdIsNull, opIdNotNull,
            //с полями по возможности без приведения типов:
            opIdEqualsField, opIdNotEqualField
        ))
    }
}

case object DomainBoolean extends SimpleDataType("bBoolean", ScalaTypeBoolean, "b", BooleanDataType, "BOOLEAN", Some("AsBoolean")) with MetaType[Boolean] {
    override val scInheritsFrom = Some(iscTypes.ftBoolean)
}

case object DomainDate extends SimpleDataType("dDate", ScalaTypeLocalDateTime, "d", DateTimeDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[LocalDateTime] {
    override val scInheritsFrom = Some(iscTypes.ftDate)
}

case object DomainTime extends SimpleDataType("dTime", ScalaTypeLocalDateTime, "tm", DateTimeDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[LocalDateTime] {
    override val scInheritsFrom = Some(iscTypes.ftTime)
}

case object DomainDateOptTime extends SimpleDataType("dDateOptTime", ScalaTypeLocalDateTime, "dt", DateTimeDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[LocalDateTime] {
    override val scInheritsFrom = Some(iscTypes.ftDateTime)
}

case object DomainDateTime extends SimpleDataType("dDateTime", ScalaTypeLocalDateTime, "dt", DateTimeDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[LocalDateTime] {
    override val scInheritsFrom = Some(iscTypes.ftDateTime)
}

case object DomainTimestamp extends SimpleDataType("dTimestamp", ScalaTypeLocalDateTime, "t", TimestampDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[LocalDateTime] {
    override val scInheritsFrom = Some(iscTypes.ftDateTime)
}

case object DomainTimestampWTZ extends SimpleDataType("dTimestampWithTZ", ScalaTypeDateTime, "tz", TimestampWTZDataType, "TIMESTAMP", Some("AsDateTime")) with MetaType[DateTime] {
    override val scInheritsFrom = Some(iscTypes.ftDateTime)
}

case object DomainCode extends SimpleDataType("sCode", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainCaption extends SimpleDataType("sCaption", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainDescription extends SimpleDataType("sDescription", ScalaTypeString, "s", VarcharDataType(4000), "VARCHAR.length(4000)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftTextArea)
}

case object DomainPasswordPlain extends SimpleDataType("sPasswordPlain", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftPassword)
}

case object DomainPasswordHashSHA extends SimpleDataType("sPasswordHashSHA", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftPassword)
}

case object DomainBarCode extends SimpleDataType("sBarCode", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}


case object DomainPostalIndex extends SimpleDataType("sPostalIndex", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainAddress extends SimpleDataType("sAddress", ScalaTypeString, "s", VarcharDataType(4000), "VARCHAR.length(4000)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainPhone extends SimpleDataType("sPhone", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainEMail extends SimpleDataType("sEMail", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}

case object DomainURL extends SimpleDataType("sURL", ScalaTypeString, "s", VarcharDataType(4000), "VARCHAR.length(4000)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftLink)
}

case object DomainURLImage extends SimpleDataType("sURLImage", ScalaTypeString, "s", VarcharDataType(4000), "VARCHAR.length(4000)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftImage)
}

case object DomainURLDocument extends SimpleDataType("sURLDocument", ScalaTypeString, "s", VarcharDataType(4000), "VARCHAR.length(4000)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftBinary)
}

case object DomainURLDomain extends SimpleDataType("sURLDomain", ScalaTypeString, "s", VarcharDataType(255), "VARCHAR.length(255)", None) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftText)
}


case object DomainInt extends SimpleDataType("nInt", ScalaTypeLong, "n", LongDataType, "BIGINT", Some("AsLong")) with MetaType[Long] {
    override val scInheritsFrom = Some(iscTypes.ftInteger)
}

case object DomainDouble extends SimpleDataType("fDouble", ScalaTypeDouble, "f", DoubleDataType, "DOUBLE", Some("AsDouble")) with MetaType[Double] {
    override val scInheritsFrom = Some(iscTypes.ftFloat)
}

case object DomainSum extends SimpleDataType("fSum", ScalaTypeDouble, "f", DoubleDataType, "DOUBLE", Some("AsDouble")) with MetaType[Double] {
    override val scInheritsFrom = Some(iscTypes.ftFloat)
}

case object DomainPrice extends SimpleDataType("fPrice", ScalaTypeDouble, "f", DoubleDataType, "DOUBLE", Some("AsDouble")) with MetaType[Double] {
    override val scInheritsFrom = Some(iscTypes.ftFloat)
}

case object DomainClob extends SimpleDataType("clob", ScalaTypeClob, "clb", VarcharDataType(-1), "CLOB", Some("CLOB")) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftTextArea)
}

case object DomainJson extends SimpleDataType("json", ScalaTypeJson, "jsn", VarcharDataType(-1), "CLOB", Some("CLOB")) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftTextArea)
}

case object DomainBlob extends SimpleDataType("blob", ScalaTypeBlob, "blb", BlobDataType, "BLOB", Some("BLOB")) with MetaType[String] {
    override val scInheritsFrom = Some(iscTypes.ftBinary)
}

object Domain {
    val di = DomainDI
    val id = DomainID
    val ss = DomainSS

    val bBoolean = DomainBoolean

    val dDate = DomainDate
    val dTime = DomainTime
    val dDateOptTime = DomainDateOptTime
    val dDateTime = DomainDateTime
    val dTimestamp = DomainTimestamp
    val dTimestampWithTZ = DomainTimestampWTZ

    val sCode = DomainCode
    val sCaption = DomainCaption
    val sDescription = DomainDescription

    val sPasswordPlain = DomainPasswordPlain
    val sPasswordHashSHA = DomainPasswordHashSHA

    val sBarCode = DomainBarCode

    val sPostalIndex = DomainPostalIndex
    val sAddress = DomainAddress
    val sPhone = DomainPhone
    val sEMail = DomainEMail

    val sURL = DomainURL
    val sURLImage = DomainURLImage
    val sURLDocument = DomainURLDocument
    val sURLDomain = DomainURLDomain

    val nInt = DomainInt

    val fDouble = DomainDouble
    val fSum = DomainSum
    val fPrice = DomainPrice

    val clb = DomainClob
    val blb = DomainBlob
    val jsn = DomainJson
}

object DataTypes {
    implicit val db: Database = new H2Database

    val types: Set[SimpleDataType[_]] = Set(
        Domain.di,
        Domain.id,
        Domain.ss,

        Domain.bBoolean,

        Domain.dDate,
        Domain.dTime,
        Domain.dDateOptTime,
        Domain.dDateTime,
        Domain.dTimestamp,
        Domain.dTimestampWithTZ,

        Domain.sCode,
        Domain.sCaption,
        Domain.sDescription,

        Domain.sPasswordPlain,
        Domain.sPasswordHashSHA,

        Domain.sBarCode,

        Domain.sPostalIndex,
        Domain.sAddress,
        Domain.sPhone,
        Domain.sEMail,

        Domain.sURL,
        Domain.sURLImage,
        Domain.sURLDomain,

        Domain.nInt,

        Domain.fDouble,
        Domain.fSum,
        Domain.fPrice,

        Domain.clb,
        Domain.blb,
        Domain.jsn
    )

    val typesMap: Map[String, SimpleDataType[_]] = types.map(x => (x.scName, x)).toMap

    def toXML(xsdLocation: String = ""): Elem = {

        val scope = NamespaceBinding(null, "http://simpleSys.ru/xml/library/domains", NamespaceBinding("common", "http://simpleSys.ru/xml/library/common", XsiScore))
        val attr = Attribute("xsi", "schemaLocation", s"http://simpleSys.ru/xml/library/domains ${xsdLocation}/domains.xsd", Null)
        var res = Elem(null, "DataTypes", attr, TypeNull, scope, true)

        types foreach {
            item => res = res.appendElement(item.toXML)
        }
        res
    }
}

//---------------------------------------------------------------------------------
