package ru.simplesys.persistence.jooqwrapper

import scala.reflect.ClassTag
import org.jooq._
import org.jooq.{scala => scala_jooq}
import org.jooq.impl._
import org.joda.time.{LocalDate, LocalTime, DateTime}
import ru.simplesys.coreutil._


abstract class AbstractTableImplScala[T <: Record](name: String, schema: Schema, aliased: Table[T]) extends AbstractTableImplMod[T](name, schema, aliased) {
    def this(name: String, schema: Schema) = this(name: String, schema: Schema, null)

    def this(name: String) = this(name, null, null)
}

object AsBigDecimal extends Converter[java.math.BigDecimal, BigDecimal] {
    def from(databaseObject: java.math.BigDecimal): BigDecimal = BigDecimal(databaseObject)

    def to(userObject: BigDecimal): java.math.BigDecimal = if (userObject == null) null else userObject.bigDecimal

    def fromType(): Class[java.math.BigDecimal] = classOf[java.math.BigDecimal]

    def toType: Class[BigDecimal] = classOf[BigDecimal]
}

object AsLong extends Converter[java.lang.Long, Long] {
    def from(databaseObject: java.lang.Long): Long = databaseObject

    def to(userObject: Long): java.lang.Long = userObject

    def fromType(): Class[java.lang.Long] = classOf[java.lang.Long]

    def toType: Class[Long] = classOf[Long]
}

object AsDouble extends Converter[java.lang.Double, Double] {
    def from(databaseObject: java.lang.Double): Double = databaseObject

    def to(userObject: Double): java.lang.Double = userObject

    def fromType(): Class[java.lang.Double] = classOf[java.lang.Double]

    def toType: Class[Double] = classOf[Double]
}

object AsBoolean extends Converter[java.lang.Boolean, Boolean] {
    def from(databaseObject: java.lang.Boolean): Boolean = Boolean.unbox(databaseObject)

    def to(userObject: Boolean): java.lang.Boolean = Boolean.box(userObject)

    def fromType(): Class[java.lang.Boolean] = classOf[java.lang.Boolean]

    def toType: Class[Boolean] = classOf[Boolean]
}

object AsDateTime extends Converter[java.sql.Timestamp, DateTime] {
    def from(databaseObject: java.sql.Timestamp): DateTime = if (databaseObject == null) null else new DateTime(databaseObject.getTime)

    def to(userObject: DateTime): java.sql.Timestamp = if (userObject == null) null else new java.sql.Timestamp(userObject.getMillis)

    def fromType(): Class[java.sql.Timestamp] = classOf[java.sql.Timestamp]

    def toType: Class[DateTime] = classOf[DateTime]
}

object AsLocalTime extends Converter[java.sql.Time, LocalTime] {
    def from(databaseObject: java.sql.Time): LocalTime = if (databaseObject == null) null else new LocalTime(databaseObject.getTime)

    def to(userObject: LocalTime): java.sql.Time = if (userObject == null) null else new java.sql.Time(userObject.toDateTimeToday.getMillis)

    def fromType(): Class[java.sql.Time] = classOf[java.sql.Time]

    def toType: Class[LocalTime] = classOf[LocalTime]
}

object AsLocalDate extends Converter[java.sql.Date, LocalDate] {
    def millisToSqlType(d: java.util.Date /*{ def getTime(): Long }*/): java.sql.Date = {
        import java.util.Calendar
        val cal = Calendar.getInstance()
        cal.setTimeInMillis(d.getTime)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        new java.sql.Date(cal.getTimeInMillis)
    }

    def from(databaseObject: java.sql.Date): LocalDate = if (databaseObject == null) null else new LocalDate(databaseObject.getTime)

    def to(userObject: LocalDate): java.sql.Date = if (userObject == null) null else millisToSqlType(userObject.toDate)

    def fromType(): Class[java.sql.Date] = classOf[java.sql.Date]

    def toType: Class[LocalDate] = classOf[LocalDate]
}

object AsString extends Converter[String, String] {
    def from(databaseObject: String) = databaseObject

    def to(userObject: String) = userObject

    def fromType(): Class[String] = classOf[String]

    def toType: Class[String] = classOf[String]

}

class AsOption[T: ClassTag] extends Converter[T, Option[T]] {
    def from(databaseObject: T): Option[T] = Option(databaseObject)

    def to(userObject: Option[T]): T = userObject.getOrElse(null.asInstanceOf[T])

    def fromType(): Class[T] = implicitly[ClassTag[T]].runtimeClass.asInstanceOf[Class[T]]

    def toType: Class[Option[T]] = classOf[Option[T]]
}

object AsOption {
    def apply[T: ClassTag]() = new AsOption[T]()
}

class AsOptionWMapping[DT, UT](mapping: Converter[DT, UT])(implicit dt: ClassTag[DT]) extends Converter[DT, Option[UT]] {
    def from(databaseObject: DT): Option[UT] = Option(databaseObject).map(mapping.from(_))

    def to(userObject: Option[UT]): DT = userObject.map(mapping.to(_)).getOrElse(null.asInstanceOf[DT])

    def fromType(): Class[DT] = dt.runtimeClass.asInstanceOf[Class[DT]]

    def toType: Class[Option[UT]] = classOf[Option[UT]]
}

object AsOptionWMapping {
    def apply[DT, UT](mapping: Converter[DT, UT])(implicit dt: ClassTag[DT]) = new AsOptionWMapping(mapping)
}


abstract class BaseConverterSealedTrait[A, T <: SealedCaseClassEnum[A]](implicit tc: ClassTag[T], ac: ClassTag[A]) extends Converter[A, T] {
    def mappedKeys: Map[A, T] //= SealedEnum.values[T].map(x => (x.key, x))(collection.breakOut)

    def from(databaseObject: A): T = mappedKeys(databaseObject)

    def to(userObject: T): A = userObject.key

    def fromType(): Class[A] = ac.runtimeClass.asInstanceOf[Class[A]]//classOf[A]

    def toType: Class[T] = tc.runtimeClass.asInstanceOf[Class[T]]
}

abstract class SimpleView(alias: Option[String])(implicit val dsl: DSLContext) {
    implicit val qry: () => Table[_ <: Record] = query _

    val internalQuery: Select[_ <: Record]

    lazy val query = alias match {
        case Some(x) => internalQuery.asTable(x)
        case None => internalQuery.asTable()
    }
}

class ViewQueryField[T](val f: Field[T], qry: () => Table[_ <: Record]) {
    def ext: Field[T] = qry().field(f)
}

object ImplicitConversions {

    implicit class ToOptionType[T: ClassTag](dt: DataType[T]) {
        def asOption = dt.asConvertedDataType(AsOption())
    }

    implicit class ToOptionWMappingType[DT](dt: DataType[DT])(implicit dtc: ClassTag[DT]) {
        def asOptionMapped[UT](mapping: Converter[DT, UT]) = dt.asConvertedDataType(AsOptionWMapping(mapping))
    }

    implicit class ToBigDecimalType(dt: DataType[java.math.BigDecimal]) {
        def asBigDecimal = dt.asConvertedDataType(AsBigDecimal)
    }

    implicit class ToLongType(dt: DataType[java.lang.Long]) {
        def asLong = dt.asConvertedDataType(AsLong)
    }

    implicit class ToDoubleType(dt: DataType[java.lang.Double]) {
        def asDouble = dt.asConvertedDataType(AsDouble)
    }

    implicit class ToBooleanType(dt: DataType[java.lang.Boolean]) {
        def asBoolean = dt.asConvertedDataType(AsBoolean)
    }

    implicit class ToLocalDateType(dt: DataType[java.sql.Date]) {
        def asLocalDate = dt.asConvertedDataType(AsLocalDate)
    }

    implicit class ToLocalTimeType(dt: DataType[java.sql.Time]) {
        def asLocalTime = dt.asConvertedDataType(AsLocalTime)
    }

    implicit class ToDateTimeType(dt: DataType[java.sql.Timestamp]) {
        def asDateTime = dt.asConvertedDataType(AsDateTime)
    }

    implicit class ToViewQueryField[T](f: Field[T]) {
        def viewAs(alias: String)(implicit qry: () => Table[_ <: Record]) = new ViewQueryField(f.as(alias), qry)
    }

    implicit def viewQueryFieldToIntField[T](vf: ViewQueryField[T]) = vf.f

    implicit def fromSimpleQueryToSelect(x: SimpleView): Table[_ <: Record] = x.query

    ///////////////////////////////////////// To Tuple ////////////////////////////////////////////////////////////////////////////
    implicit class ToTuple1[T1](r: Record1[T1]) {
        def toTuple = Tuple1(r.value1)
    }

    implicit class ToTuple2[T1, T2](r: Record2[T1, T2]) {
        def toTuple = Tuple2(r.value1, r.value2)
    }

    implicit class ToTuple3[T1, T2, T3](r: Record3[T1, T2, T3]) {
        def toTuple = Tuple3(r.value1, r.value2, r.value3)
    }

    implicit class ToTuple4[T1, T2, T3, T4](r: Record4[T1, T2, T3, T4]) {
        def toTuple = Tuple4(r.value1, r.value2, r.value3, r.value4)
    }

    implicit class ToTuple5[T1, T2, T3, T4, T5](r: Record5[T1, T2, T3, T4, T5]) {
        def toTuple = Tuple5(r.value1, r.value2, r.value3, r.value4, r.value5)
    }

    implicit class ToTuple6[T1, T2, T3, T4, T5, T6](r: Record6[T1, T2, T3, T4, T5, T6]) {
        def toTuple = Tuple6(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6)
    }

    implicit class ToTuple7[T1, T2, T3, T4, T5, T6, T7](r: Record7[T1, T2, T3, T4, T5, T6, T7]) {
        def toTuple = Tuple7(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7)
    }

    implicit class ToTuple8[T1, T2, T3, T4, T5, T6, T7, T8](r: Record8[T1, T2, T3, T4, T5, T6, T7, T8]) {
        def toTuple = Tuple8(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8)
    }

    implicit class ToTuple9[T1, T2, T3, T4, T5, T6, T7, T8, T9](r: Record9[T1, T2, T3, T4, T5, T6, T7, T8, T9]) {
        def toTuple = Tuple9(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9)
    }

    implicit class ToTuple10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](r: Record10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10]) {
        def toTuple = Tuple10(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10)
    }

    implicit class ToTuple11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](r: Record11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11]) {
        def toTuple = Tuple11(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11)
    }

    implicit class ToTuple12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](r: Record12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12]) {
        def toTuple = Tuple12(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12)
    }

    implicit class ToTuple13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](r: Record13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13]) {
        def toTuple = Tuple13(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13)
    }

    implicit class ToTuple14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](r: Record14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14]) {
        def toTuple = Tuple14(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14)
    }

    implicit class ToTuple15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](r: Record15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15]) {
        def toTuple = Tuple15(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15)
    }

    implicit class ToTuple16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](r: Record16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16]) {
        def toTuple = Tuple16(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16)
    }

    implicit class ToTuple17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](r: Record17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17]) {
        def toTuple = Tuple17(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17)
    }

    implicit class ToTuple18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](r: Record18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18]) {
        def toTuple = Tuple18(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17, r.field18)
    }

    implicit class ToTuple19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](r: Record19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19]) {
        def toTuple = Tuple19(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17, r.field18, r.field19)
    }

    implicit class ToTuple20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](r: Record20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20]) {
        def toTuple = Tuple20(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17, r.field18, r.field19, r.field20)
    }

    implicit class ToTuple21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](r: Record21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21]) {
        def toTuple = Tuple21(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17, r.field18, r.field19, r.field20, r.field21)
    }

    implicit class ToTuple22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](r: Record22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]) {
        def toTuple = Tuple22(r.value1, r.value2, r.value3, r.value4, r.value5, r.value6, r.value7, r.value8, r.value9, r.value10, r.value11, r.value12, r.value13, r.value14, r.value15, r.field16, r.field17, r.field18, r.field19, r.field20, r.field21, r.field22)
    }
    ///////////////////////////////////////// End To Tuple ////////////////////////////////////////////////////////////////////////////

    implicit def t2Field[T](x: T): Field[T] = DSL.value(x)
    implicit def t2Param[T](x: T): Param[T] = DSL.value(x)
}
