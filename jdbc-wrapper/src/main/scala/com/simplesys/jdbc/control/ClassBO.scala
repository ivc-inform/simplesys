package com.simplesys.jdbc.control

import java.io.{InputStream, StringReader}
import java.sql.{Connection, PreparedStatement, ResultSet, SQLException, Timestamp}
import java.time.LocalDateTime

import com.simplesys.SQL.Gen._
import com.simplesys.SQL._
import com.simplesys.common.Strings._
import com.simplesys.common.array.{NotValue, asArray}
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.config.Config
import com.simplesys.db.pool.PoolDataSource
import com.simplesys.isc.system.typesDyn._
import com.simplesys.jdbc.control.table.{From, TableInnerJoinCaseClass, TableJoinCondition, TableJoinCondition1, TableLeftJoinCaseClass}
import com.simplesys.jdbc.JDBC._
import com.simplesys.jdbc.control.SessionStructures._
import com.simplesys.jdbc.control.SuperTuple1._
import com.simplesys.jdbc.control.classBO._
import com.simplesys.log.Logging
import com.simplesys.sql.OracleDialect
import com.simplesys.tuple.{TupleSS1, TupleSS2}
import io.circe.Json
import ru.simplesys.meta.types._

import scala.BigDecimal._
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag
import scalaz.{Failure, Success}

case class BindingColumn(column: BasicClassBOColumn[_], value: String)

trait ClassBO[T <: ClassBO[T]] extends Entity[T] with Config with Logging {
    top =>

    def dataSource: PoolDataSource

    protected var _columns: Product with FieldProduct = _
    protected val _where = WheresList()
    protected val _join = JoinsList()
    protected val _orderBy = OrderByList()
    val fromTable: Table[_] = null

    protected val tableCount = 0
    protected val boCount = 0
    protected val dsCount = 0

    protected val isDataSet = false

    protected def init[FT <: Product with FieldProduct](columns: FT, join: JoinParam, where: WhereParam, orderBy: OrderByParam): T

    type ColumnTypes <: Product

    def allColumns: ColumnTypes with FieldProduct

    def * = allColumns

    abstract class Column[T] extends BasicClassBOColumn[T] {
        logger trace (s"Registred column ${this}")

        val caption: String

        def ~[OT](column: Column[OT]): MyTuple2[T, OT] = {
            val _column = this

            new MyTuple2[T, OT](_column default, column default) {
                def fields = List(_column, column)

                def fieldProduct: TupleSS2[Column[T], Column[OT]] = TupleSS2(_column, column)
            }
        }

        def ~ : MyTuple1[T] = {
            val _column = this

            new MyTuple1[T](_column default) {
                def fields = List(_column)

                def fieldProduct: TupleSS1[Column[T]] = TupleSS1(_column)
            }
        }
    }

    abstract class OptionColumn[T: ClassTag] extends Column[Array[T]]

    abstract class EnumStringColumn[To](val name: String, val nameInBo: String, val caption: String = strEmpty, val tableColumn: BasicTableColumn[String])(implicit val converterEnum: String => To, val backConverterEnum: To => String) extends Column[To] {
        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default: To

        @throws(classOf[SQLException])
        override def get(resultSet: ResultSet): To = resultSet getString getName

        @throws(classOf[SQLException])
        override def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: To) {
            preparedStatement setString(parameterIndex, value)
        }
    }

    abstract class EnumStringOptionColumn[To: ClassTag](val name: String, val nameInBo: String, val caption: String = strEmpty, val tableColumn: BasicTableColumn[Array[String]])(implicit val converterEnum: String => To, val backConverterEnum: To => String) extends Column[Array[To]] {
        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        override def get(resultSet: ResultSet): Array[To] = asArray(resultSet getString getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[To]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setString(parameterIndex, value)
            }
        }
    }

    case class BlobColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[InputStream]) extends Column[InputStream] {

        def entity = top

        def getDBDataType: DBDataType = BlobDataType

        def default = new EmptyInputStream()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getBinaryStream getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: InputStream) {
            preparedStatement.setBinaryStream(parameterIndex, value)
            logger trace s"BlobColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class BlobOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[InputStream]]) extends OptionColumn[InputStream] {

        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = asArray(resultSet getBinaryStream getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[InputStream]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setBinaryStream(parameterIndex, value)
            }
            logger trace s"BlobOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class ClobColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[String]) extends Column[String] {

        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = ""

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getClob getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement.setClob(parameterIndex, new StringReader(value))
            logger trace s"ClobColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class ClobOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[String]]) extends OptionColumn[String] {

        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = asArray(resultSet getClob getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setClob(parameterIndex, new StringReader(value))
            }
            logger trace s"ClobOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class JsonColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[String]) extends Column[String] {

        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = ""

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getClob getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement.setClob(parameterIndex, new StringReader(value))
            logger trace s"JsonColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class JsonOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[String]]) extends OptionColumn[String] {

        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = asArray(resultSet getClob getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setClob(parameterIndex, new StringReader(value))
            }
            logger trace s"JsonOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class IntColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Int]) extends Column[Int] {

        def entity = top

        def default = 0

        def getDBDataType = IntegerDataType

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getInt getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Int) {
            preparedStatement setInt(parameterIndex, value)
            logger trace s"IntColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class IntOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[Int]]) extends OptionColumn[Int] {
        def entity = top

        def default = NotValue

        def getDBDataType = IntegerDataType

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = {
            val res = resultSet getInt getName

            if (resultSet.wasNull())
                Array.empty
            else
                asArray(res)
        }

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Int]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setInt(parameterIndex, value)
            }

            logger trace s"IntOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class DoubleColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Double]) extends Column[Double] {
        def entity = top

        def getDBDataType = DoubleDataType

        def default = 0

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getDouble getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Double) {
            preparedStatement setDouble(parameterIndex, value)
            logger trace s"DoubleColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class DoubleOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[Double]]) extends OptionColumn[Double] {
        def entity = top

        def getDBDataType = DoubleDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = {
            val res = resultSet getDouble getName

            if (resultSet.wasNull())
                Array.empty
            else
                asArray(res)
        }

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Double]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setDouble(parameterIndex, value)
            }
            logger trace s"DoubleOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class LongColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Long]) extends Column[Long] {
        def entity = top

        def getDBDataType = LongDataType

        def default = 0L

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getLong getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Long) {
            preparedStatement setLong(parameterIndex, value)
            logger trace s"LongColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class LongOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[Long]]) extends OptionColumn[Long] {
        def entity = top

        def getDBDataType = LongDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = {
            val res = resultSet getLong getName

            if (resultSet.wasNull())
                Array.empty[Long]
            else
                asArray(res)
        }

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Long]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setLong(parameterIndex, value)
            }
            logger trace s"LongOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class BigDecimalColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[BigDecimal]) extends Column[BigDecimal] {
        def entity = top

        def getDBDataType = BigDecimalDataType

        def default: BigDecimal = BigDecimal(0)

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet): BigDecimal = resultSet getBigDecimal getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: BigDecimal) {
            preparedStatement setBigDecimal(parameterIndex, value.bigDecimal)
            logger trace s"bigDecimalColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class BigDecimalOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[BigDecimal]]) extends OptionColumn[BigDecimal] {
        def entity = top

        def getDBDataType = BigDecimalDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet): Array[BigDecimal] = asArray(resultSet getBigDecimal getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[BigDecimal]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setBigDecimal(parameterIndex, value.bigDecimal)
            }
            logger trace s"bigDecimalOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class BooleanColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Boolean]) extends Column[Boolean] {
        def entity = top

        def getDBDataType = BooleanDataType

        def default = false

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getBoolean getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Boolean) {
            preparedStatement setBoolean(parameterIndex, value)
            logger trace s"BooleanColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class BooleanOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[Boolean]]) extends OptionColumn[Boolean] {
        def entity = top

        def getDBDataType = BooleanDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = {
            val res = resultSet getBoolean getName

            if (resultSet.wasNull())
                Array.empty[Boolean]
            else
                asArray(res)
        }

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Boolean]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setBoolean(parameterIndex, value)
            }
            logger trace s"BooleanOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class StringColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[String]) extends Column[String] {
        def entity = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = ""

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getString getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement setString(parameterIndex, value)
            logger trace s"StringColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class StringOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[String]]) extends OptionColumn[String] {
        def entity = top

        def getDBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = asArray(resultSet getString getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setString(parameterIndex, value)
            }
            logger trace s"StringOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class LocalDateTimeColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[LocalDateTime]) extends Column[LocalDateTime] {
        def entity = top

        def getDBDataType = DateTimeDataType

        def default = LocalDateTime.now()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet): LocalDateTime = (resultSet getTimestamp getName).toLocalDateTime


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: LocalDateTime) {
            preparedStatement setTimestamp(parameterIndex, Timestamp.valueOf(value))
            logger trace s"LocalDateTimeColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    case class LocalDateTimeOptionColumn(name: String, nameInBo: String, caption: String = strEmpty, tableColumn: BasicTableColumn[Array[LocalDateTime]]) extends OptionColumn[LocalDateTime] {
        def entity = top

        def getDBDataType = DateTimeDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = {
            val res = resultSet getTimestamp getName

            if (resultSet.wasNull())
                Array.empty[LocalDateTime]
            else
                asArray(res.toLocalDateTime)
        }

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[LocalDateTime]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setTimestamp(parameterIndex, Timestamp.valueOf(value))
            }
            logger trace s"LocalDateTimeOptionColumn Set (parameterIndex: ${parameterIndex}, value: ${value})"
        }
    }

    def entity2SQLAbsTable[T](entity: Entity[T], columns: List[BasicClassBOColumn[_]]): SQLAbsFrom = {
        entity match {
            case x: Table[_] =>
                SQLJoinFrom(table = SQLTable(name = x.databaseTablename, quoted = x.quoted), alias = x.alias, comment = SQLComment("From:".space + x.getClass.getSimpleName))
            case x: ClassBO[_] =>
                SQLJoinFrom(table = x.preparedBO4Wrap(columns).sql, alias = x.alias, comment = SQLComment("From:".space + x.getClass.getSimpleName))
        }
    }

    def binding(offset: Int, preparedStatement: PreparedStatement, wheres: List[WhereParam], discriptors: List[WhereParam], joinsDs: List[JoinParam], joinsBo: List[JoinParam], joinsTable: List[JoinParam], bindMap: Seq[BindingColumn] = Seq.empty, dsRequest: DsRequest = null): Int = {
        var _offset = offset

        joinsTable foreach {
            case join: TableInnerJoinCaseClass[_] =>
                join.joinConditions foreach {
                    case b: TableJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }

            case join: TableLeftJoinCaseClass[_] =>
                join.joinConditions foreach {
                    case b: TableJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }
        }

        discriptors foreach {
            case b: WhereBoCaseClass[_, _] =>
                _offset = b.bind(preparedStatement, _offset)
            case b: WhereBoClause =>
            //case _ =>
        }

        (joinsBo ++ joinsDs) foreach {
            case join: DsInnerJoinCaseClass[_] =>
                _offset = join.dataSet.binding(offset = _offset, preparedStatement = preparedStatement, wheres = WheresList(join.dataSet._where).toList, joinsDs = JoinsList(join.dataSet._join).toList, joinsBo = List.empty[JoinParam], joinsTable = List.empty[JoinParam], discriptors = List.empty[WhereParam])
                join.joinConditions foreach {
                    case b: BoJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }

            case join: DsLeftJoinCaseClass[_] =>
                _offset = join.dataSet.binding(offset = _offset, preparedStatement = preparedStatement, wheres = WheresList(join.dataSet._where).toList, joinsDs = JoinsList(join.dataSet._join).toList, joinsBo = List.empty[JoinParam], joinsTable = List.empty[JoinParam], discriptors = List.empty[WhereParam])
                join.joinConditions foreach {
                    case b: BoJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }

            case join: BoInnerJoinCaseClass[_] =>
                _offset = join.bo.binding(offset = _offset, preparedStatement = preparedStatement, wheres = WheresList(join.bo._where).toList, joinsDs = List.empty[JoinParam], joinsBo = JoinsList(join.bo._join).toList, joinsTable = List.empty[JoinParam], discriptors = List.empty[WhereParam])
                join.joinConditions foreach {
                    case b: BoJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }

            case join: BoLeftJoinCaseClass[_] =>
                _offset = join.bo.binding(offset = _offset, preparedStatement = preparedStatement, wheres = WheresList(join.bo._where).toList, joinsDs = List.empty[JoinParam], joinsBo = JoinsList(join.bo._join).toList, joinsTable = List.empty[JoinParam], discriptors = List.empty[WhereParam])
                join.joinConditions foreach {
                    case b: BoJoinCondition1[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                    case _ =>
                }
        }

        wheres foreach {
            case b: WhereBoCaseClass[_, _] =>
                _offset = b.bind(preparedStatement, _offset)
            case b: WhereBoClause =>
            case list: WheresList =>
                list.toList.foreach {
                    case b: WhereBoCaseClass[_, _] =>
                        _offset = b.bind(preparedStatement, _offset)
                }
        }

        bindMap.foreach {
            case BindingColumn(column: BasicClassBOColumn[_], value) =>
                if (column.isInstanceOf[IntColumn]) {
                    column.asInstanceOf[IntColumn].set(preparedStatement, _offset, value.toInt)
                    logger trace (s"Binding IntColumn index: ${_offset}, value: ${value.toInt}")
                    _offset += 1
                } else if (column.isInstanceOf[IntOptionColumn]) {
                    column.asInstanceOf[IntOptionColumn].set(preparedStatement, _offset, Array(value.toInt))
                    logger trace (s"Binding IntOptionColumn index: ${_offset}, value: Array(${value.toInt})")
                    _offset += 1
                } else if (column.isInstanceOf[DoubleColumn]) {
                    column.asInstanceOf[DoubleColumn].set(preparedStatement, _offset, value.toDouble)
                    logger trace (s"Binding DoubleColumn index: ${_offset}, value: ${value.toDouble}")
                    _offset += 1
                } else if (column.isInstanceOf[DoubleOptionColumn]) {
                    column.asInstanceOf[DoubleOptionColumn].set(preparedStatement, _offset, Array(value.toDouble))
                    logger trace (s"Binding DoubleOptionColumn index: ${_offset}, value: Array(${value.toDouble})")
                    _offset += 1
                } else if (column.isInstanceOf[LongColumn]) {
                    column.asInstanceOf[LongColumn].set(preparedStatement, _offset, value.toLong)
                    logger trace (s"Binding LongColumn index: ${_offset}, value: ${value.toLong}")
                    _offset += 1
                } else if (column.isInstanceOf[LongOptionColumn]) {
                    column.asInstanceOf[LongOptionColumn].set(preparedStatement, _offset, Array(value.toLong))
                    logger trace (s"Binding LongOptionColumn index: ${_offset}, value: Array(${value.toLong})")
                    _offset += 1
                } else if (column.isInstanceOf[BigDecimalColumn]) {
                    column.asInstanceOf[BigDecimalColumn].set(preparedStatement, _offset, value.toBigDecimal)
                    logger trace (s"Binding BigDecimalColumn index: ${_offset}, value: ${value.toBigDecimal}")
                    _offset += 1
                } else if (column.isInstanceOf[BigDecimalOptionColumn]) {
                    column.asInstanceOf[BigDecimalOptionColumn].set(preparedStatement, _offset, Array(value.toBigDecimal))
                    logger trace (s"Binding BigDecimalOptionColumn index: ${_offset}, value: Array(${value.toBigDecimal})")
                    _offset += 1
                } else if (column.isInstanceOf[BooleanColumn]) {
                    column.asInstanceOf[BooleanColumn].set(preparedStatement, _offset, value.toBoolean)
                    logger trace (s"Binding BooleanColumn index: ${_offset}, value: ${value.toBoolean}")
                    _offset += 1
                } else if (column.isInstanceOf[BooleanOptionColumn]) {
                    column.asInstanceOf[BooleanOptionColumn].set(preparedStatement, _offset, Array(value.toBoolean))
                    logger trace (s"Binding BooleanOptionColumn index: ${_offset}, value: Array(${value.toBoolean})")
                    _offset += 1
                } else if (column.isInstanceOf[StringColumn]) {
                    column.asInstanceOf[StringColumn].set(preparedStatement, _offset, value)
                    logger trace (s"Binding StringColumn index: ${_offset}, value: $value")
                    _offset += 1
                } else if (column.isInstanceOf[StringOptionColumn]) {
                    column.asInstanceOf[StringOptionColumn].set(preparedStatement, _offset, Array(value))
                    logger trace (s"Binding StringOptionColumn index: ${_offset}, value: Array($value)")
                    _offset += 1
                } else if (column.isInstanceOf[LocalDateTimeColumn]) {
                    column.asInstanceOf[LocalDateTimeColumn].set(preparedStatement, _offset, value.toLocalDateTime())
                    logger trace (s"Binding LocalDateTimeColumn index: ${_offset}, value: ${value.toLocalDateTime()}")
                    _offset += 1
                } else if (column.isInstanceOf[LocalDateTimeOptionColumn]) {
                    column.asInstanceOf[LocalDateTimeOptionColumn].set(preparedStatement, _offset, Array(value.toLocalDateTime()))
                    logger trace (s"Binding LocalDateTimeOptionColumn index: ${_offset}, value: Array(${value.toLocalDateTime()})")
                    _offset += 1
                } else
                    throw new RuntimeException(s"Bad branch of $column")

            case x =>
                throw new RuntimeException(s"Bad branch of ${x}")
        }

        dsRequest match {
            case null =>
            case _ =>
                if ((dsRequest.endRow !== 0) || (dsRequest.startRow !== 0))
                    dataSource.sqlDialect match {
                        case OracleDialect =>
                            val endRow = dsRequest.endRow.toLong + getInt("config.tailToEndRow")
                            preparedStatement.setLong(_offset, endRow)
                            logger trace (s"Binding index: ${_offset}, value: ${endRow}")

                            _offset += 1
                            val startRow = dsRequest.startRow.toLong
                            preparedStatement.setLong(_offset, startRow)

                            logger trace (s"Binding index: ${_offset}, value: ${startRow}")
                        case _ =>
                            throw new RuntimeException("Not implementation for :" + dataSource.sqlDialect)
                    }
        }
        _offset
    }

    def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam, where: WhereParam, orderBy: OrderByParam, fetchSize: Int = dataSource.settings.fetchSize, dsRequest: DsRequest): ValidationEx[List[FT#ReturnType]]
    def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam, where: WhereParam, orderBy: OrderByParam, fetchSize: Int = dataSource.settings.fetchSize, dsRequest: DsRequest): ValidationExIterator[Iterator[FT#ReturnType]]

    def selectListRoot[FT <: Product with FieldProduct](columns: FT = allColumns, from: FromParam, join: JoinParam, where: WhereParam, discriminator: WhereParam, orderBy: OrderByParam, fetchSize: Int, dsRequest: DsRequest): ValidationEx[List[FT#ReturnType]] = {
        prepareSelect(from = from, columns = columns.fields, join = join, where = where, discriminator = discriminator, orderBy = orderBy, dsRequest = dsRequest) match {
            case PreparedResult(sql, joinsDs, joinsBo, joinsTable, wheres, discriptors, bindMap) =>
                session(dataSource) {
                    connection =>
                        val _sql = sql.toSQL()
                        logger.trace(s"Constructed sql is: ${newLine + _sql}")
                        prepareStatement(connection, _sql, fetchSize) {
                            preparedStatement =>
                                binding(offset = 1, preparedStatement = preparedStatement, discriptors = discriptors, wheres = wheres, joinsDs = joinsDs, joinsBo = joinsBo, joinsTable = joinsTable, bindMap = bindMap, dsRequest = dsRequest)

                                executeQuery(preparedStatement) {
                                    resultSet =>
                                        columns buildResult resultSet
                                }
                        }
                }
        }
    }

    def selectIteratorRoot[FT <: Product with FieldProduct](columns: FT = allColumns, from: FromParam, join: JoinParam, where: WhereParam, discriminator: WhereParam, orderBy: OrderByParam, fetchSize: Int, dsRequest: DsRequest): ValidationExIterator[Iterator[FT#ReturnType]] = {
        prepareSelect(from = from, columns = columns.fields, join = join, where = where, discriminator = discriminator, orderBy = orderBy, dsRequest = dsRequest) match {
            case PreparedResult(sql, joinsDs, joinsBo, joinsTable, wheres, discriptors, bindMap) => {
                val _sql = sql.toSQL()
                logger.trace(s"Constructed sql is: ${newLine + _sql}")

                val connection = dataSource.getConnection
                val preparedStatement = connection prepareStatement _sql

                try {

                    preparedStatement setFetchSize fetchSize

                    binding(offset = 1, preparedStatement = preparedStatement, discriptors = discriptors, wheres = wheres, joinsDs = joinsDs, joinsBo = joinsBo, joinsTable = joinsTable, bindMap = bindMap, dsRequest = dsRequest)

                    val iterator: Iterator[FT#ReturnType] = executeQuery4Iterator(preparedStatement) {
                        resultSet =>
                            columns buildResult resultSet
                    }

                    ValidationExIterator(connection, preparedStatement, ValidationEx(Success(iterator)))
                } catch {
                    case e: Throwable =>
                        preparedStatement.close()
                        connection.close()
                        ValidationExIterator(connection, preparedStatement, ValidationEx(Failure(e)))
                }
            }
        }
    }

    import com.simplesys.jdbc.control.classBO.WheresList._

    def selectPIteratorRoot[R, FT <: Product with FieldProduct](columns: FT /*= allColumns*/ , from: FromParam, join: JoinParam, where: Json, discriminator: WhereParam, orderBy: OrderByParam, fetchSize: Int, dsRequest: DsRequest)(f: FT#ReturnType => R): ValidationExIterator[Iterator[R]] =
        selectPIteratorRoot(columns, from, join, json2WhereParam(where), discriminator, orderBy, fetchSize, dsRequest)(f)

    def selectPIteratorRoot[R, FT <: Product with FieldProduct](columns: FT /*= allColumns*/ , from: FromParam, join: JoinParam, where: WhereParam, discriminator: WhereParam, orderBy: OrderByParam, fetchSize: Int, dsRequest: DsRequest)(f: FT#ReturnType => R): ValidationExIterator[Iterator[R]] = {
        prepareSelect(from = from, columns = columns.fields, join = join, where = where, discriminator = discriminator, orderBy = orderBy, dsRequest = dsRequest) match {
            case PreparedResult(sql, joinsDs, joinsBo, joinsTable, wheres, discriptors, bindMap) => {
                val _sql = sql.toSQL()
                logger.trace(s"Constructed sql is: ${newLine + _sql}")

                val connection = dataSource.getConnection
                val preparedStatement = connection prepareStatement _sql

                try {

                    preparedStatement setFetchSize fetchSize

                    binding(offset = 1, preparedStatement = preparedStatement, discriptors = discriptors, wheres = wheres, joinsDs = joinsDs, joinsBo = joinsBo, joinsTable = joinsTable, bindMap = bindMap, dsRequest = dsRequest)

                    val iterator: Iterator[R] = iterrator2Iterator(executeQuery4Iterator(preparedStatement) {
                        resultSet =>
                            columns buildResult resultSet
                    })(f)

                    ValidationExIterator(connection, preparedStatement, ValidationEx(Success(iterator)))
                } catch {
                    case e: Throwable =>
                        preparedStatement.close()
                        connection.close()
                        ValidationExIterator(connection, preparedStatement, ValidationEx(Failure(e)))
                }
            }
        }
    }

    type RT = (Product with FieldProduct)#ReturnType

    private def getFetchColumns = if (_columns == null) allColumns else _columns

    def Fetch(): ValidationEx[List[RT]] = selectList(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = dataSource.settings.fetchSize, dsRequest = null)
    def Fetch(fetchSize: Int): ValidationEx[List[RT]] = selectList(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = fetchSize, dsRequest = null)
    def Fetch(fetchSize: Int, dsRequest: DsRequest): ValidationEx[List[RT]] = selectList(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = fetchSize, dsRequest = dsRequest)
    def Fetch(dsRequest: DsRequest): ValidationEx[List[RT]] = selectList(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = dataSource.settings.fetchSize, dsRequest = dsRequest)

    def FetchIterator(): ValidationExIterator[Iterator[RT]] = selectIterator(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = dataSource.settings.fetchSize, dsRequest = null)
    def FetchIterator(fetchSize: Int): ValidationExIterator[Iterator[RT]] = selectIterator(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = fetchSize, dsRequest = null)
    def FetchIterator(dsRequest: DsRequest): ValidationExIterator[Iterator[RT]] = selectIterator(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = dataSource.settings.fetchSize, dsRequest = dsRequest)
    def FetchIterator(fetchSize: Int, dsRequest: DsRequest): ValidationExIterator[Iterator[RT]] = selectIterator(columns = getFetchColumns, join = _join, where = _where, orderBy = _orderBy, fetchSize = fetchSize, dsRequest = dsRequest)

    def FetchOne(): ValidationEx[(Product with FieldProduct)#ReturnType] = selectOne(getFetchColumns, _join, _where)

    def selectSQL[FT <: Product with FieldProduct](columns: FT = allColumns, sql: SQLParam): ValidationEx[List[FT#ReturnType]] = {
        val sql_str: String = sql match {
            case SQL(sql) => sql
            case _ => throw new RuntimeException("Not SQL")
        }

        session(dataSource) {
            connection =>
                prepareStatement(connection, sql_str, dataSource.settings.fetchSize) {
                    preparedStatement =>
                        executeQuery(preparedStatement) {
                            resultSet => columns buildResult resultSet
                        }
                }
        }
    }

    def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam, where: WhereParam): ValidationEx[FT#ReturnType]
    def selectOneRoot[FT <: Product with FieldProduct](columns: FT = allColumns, from: FromParam, join: JoinParam, where: WhereParam, discriminator: WhereParam): ValidationEx[FT#ReturnType] = {

        prepareSelect(from = from, columns = columns.fields, join = join, where = where, discriminator = discriminator, orderBy = null) match {
            case PreparedResult(sql, joinsDs, joinsBo, joinsTable, wheres, discriptors, bindMap) =>
                session(dataSource) {
                    connection =>
                        logger.trace(s"Constructed sql is: ${newLine + sql.toSQL()}")
                        prepareStatement(connection, sql.toSQL(), dataSource.settings.fetchSize) {
                            preparedStatement =>
                                binding(offset = 1, preparedStatement = preparedStatement, discriptors = discriptors, wheres = wheres, joinsDs = joinsDs, joinsBo = joinsBo, joinsTable = joinsTable, bindMap = bindMap)
                                executeOne(preparedStatement) {
                                    resultSet => columns buildResult resultSet
                                }
                        }
                }
        }
    }

    case class PreparedResult(sql: SQLAbsTable, joinsDs: List[JoinParam], joinsBo: List[JoinParam], joinsTable: List[JoinParam], wheres: List[WhereParam], discriminators: List[WhereParam], bindMap: Seq[BindingColumn])

    def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult

    def prepareSelect(columns: List[BasicClassBOColumn[_]], from: FromParam, join: JoinParam, where: WhereParam, discriminator: WhereParam, orderBy: OrderByParam, dsRequest: DsRequest = null): PreparedResult = {
        //log()

        implicit class impl1(columns: List[BasicClassBOColumn[_]]) {
            def getColumns: SQLFields = SQLFields(columns.map(_.getColumn))
        }

        def joins: List[JoinParam] = (join match {
            case join: JoinsList => join.toList
            case _ => Nil
        }) ++ JoinsList(_join).toList

        def joinsDs: List[JoinParam] = joins.filter(
            _ match {
                case x: DsInnerJoinCaseClass[_] => true
                case x: DsLeftJoinCaseClass[_] => true
                case _ => false
            }
        ).distinct

        def joinsBo: List[JoinParam] = joins.filter(
            _ match {
                case x: BoInnerJoinCaseClass[_] => true
                case x: BoLeftJoinCaseClass[_] => true
                case _ => false
            }
        ).distinct

        def joinsTable: List[JoinParam] = joins.filter(
            _ match {
                case x: TableInnerJoinCaseClass[_] => true
                case x: TableLeftJoinCaseClass[_] => true
                case _ => false
            }
        ).distinct

        def getSQLColumns: SQLFields = {
            _columns match {
                case null =>
                    columns.getColumns
                case _ =>
                    _columns.getColumns
            }
        }

        def getJoinsBoColumns: List[BasicClassBOColumn[_]] = joinsBo.map {
            case BoInnerJoinCaseClass(_, joinConditions) =>
                fieldFromJoins(joinConditions)
            case BoLeftJoinCaseClass(_, joinConditions) =>
                fieldFromJoins(joinConditions)
        }.flatten

        def getJoinsDsColumns: List[BasicClassBOColumn[_]] = joinsDs.map {
            case DsInnerJoinCaseClass(_, joinConditions) =>
                fieldFromJoins(joinConditions)
            case DsLeftJoinCaseClass(_, joinConditions) =>
                fieldFromJoins(joinConditions)
        }.flatten

        lazy val compoundAllColumns: List[BasicClassBOColumn[_]] = ((_columns match {
            case null =>
                columns
            case _ =>
                _columns.fields
        }) ++ getJoinsBoColumns ++ getJoinsDsColumns ++ getOrderByColumns).distinct

        def wheres: List[WhereParam] = (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }) ++ WheresList(_where).toList

        def discriminators: List[WhereParam] = discriminator match {
            case discriminator: WheresList => discriminator.toList
            case _ => Nil
        }

        def orderBies: List[OrderByParam] = (orderBy match {
            case orderBy: OrderByList => orderBy.toList
            case _ => Nil
        }) ++ OrderByList(_orderBy).toList

        def getOrderByColumns: List[BasicClassBOColumn[_]] = orderBies map {
            _ match {
                case OrderByCaseClass(column, _) => column
            }
        }

        def getColumnInBase(columnInBo: SQLField): Option[SQLField] = {
            val columnName: String = columnInBo.name.unQuoted.replace("-", "");
            val field = compoundAllColumns.filter(_.nameInBo === columnName).headOption
            field match {
                case Some(field) => Some(columnInBo.copy(name = field.name, tableOwner = field.getTableOwner))
                case _ =>
                    logger warn s"Field: ${columnName} не найден в compoundAllColumns."
                    None
            }
        }

        val bindMap = ArrayBuffer.empty[BindingColumn]

        def sqlJoins(_joins: List[JoinParam]): SQLJoins = {
            def getJoin(joinType: SQLAbsJoinClause, entity: Entity[_], joinConditions: Seq[JoinConditionParam]): SQLJoin = {
                SQLJoin(joinType = joinType, joinFrom = entity2SQLAbsTable(entity, compoundAllColumns), conditions =
                  SQLJoinConditions(joinConditions map {
                      case BoJoinCondition(column1, operator, column2) =>
                          SQLJoinCondition(field = column1.getColumn1, operator = operator, fieldJoin = column2.getColumn1)
                      case BoJoinCondition1(column, operator, value) =>
                          SQLJoinCondition(field = column.getColumn1, operator = operator, valueJoin = SQLValuePlaceHolder)
                      case TableJoinCondition(column1, operator, column2) =>
                          SQLJoinCondition(field = column1.getColumn, operator = operator, fieldJoin = column2.getColumn)
                      case TableJoinCondition1(column, operator, value) =>
                          SQLJoinCondition(field = column.getColumn, operator = operator, valueJoin = SQLValuePlaceHolder)
                      case JoinClause(operator) => SQLJoinClause(operator)
                  }: _*))
            }

            _joins match {
                case Nil =>
                    SQLJoins()
                case xs =>
                    SQLJoins(xs.map {
                        case DsInnerJoinCaseClass(dataSet, joinConditions) =>
                            getJoin(joinType = SQLInnerJoinClause, entity = dataSet, joinConditions = joinConditions)
                        case DsLeftJoinCaseClass(dataSet, joinConditions) =>
                            getJoin(joinType = SQLLeftJoinClause, entity = dataSet, joinConditions = joinConditions)
                        case BoInnerJoinCaseClass(bo, joinConditions) =>
                            getJoin(joinType = SQLInnerJoinClause, entity = bo, joinConditions = joinConditions)
                        case BoLeftJoinCaseClass(bo, joinConditions) =>
                            getJoin(joinType = SQLLeftJoinClause, entity = bo, joinConditions = joinConditions)
                        case TableInnerJoinCaseClass(table, joinConditions) =>
                            getJoin(joinType = SQLInnerJoinClause, entity = table, joinConditions = joinConditions)
                        case TableLeftJoinCaseClass(table, joinConditions) =>
                            getJoin(joinType = SQLLeftJoinClause, entity = table, joinConditions = joinConditions)
                        case JoinClause(operator) =>
                            SQLJoinClause(operator)
                    }: _*)
            }
        }
        //logger.trace(s"Constructed sqlJoins is: ${newLine + sqlJoins.toSQL(4)}")

        def getSQLWhereItem(f: WhereBoCaseClass[_, _]): SQLWhereItem = {
            f.operator.kind match {
                case op: IsInList.type =>
                    SQLWhereItem(field = f.column.getColumn1, operator = f.operator, SQLValues((f.value match {
                        case x: List[_] =>
                            x.map(_ => SQLValuePlaceHolder)
                    }): _*))
                case _ =>
                    SQLWhereItem(field = f.column.getColumn1, operator = f.operator, value = SQLValuePlaceHolder)
            }
        }

        def sqlWhere(_wheres: List[WhereParam], includeDsRequest: Boolean, innerSelect: Boolean = false): SQLWhere = {
            /* 'innerSelect' Необходим для исключения в подзапросах фильтров предназначенных для всего объекта*/

            val res = SQLWhere()

            if (!innerSelect) {
                _wheres match {
                    case Nil =>
                    case xs =>
                        xs.foreach {
                            case f: WhereBoCaseClass[_, _] =>
                                res += getSQLWhereItem(f)
                            case f: WhereBoCaseClasses =>
                                res ++= getSQLWhereItems(f).toSeq
                            case f: WhereBoClause =>
                                res += SQLWhereItemClause(f.operator)
                            case list: WheresList =>
                                list.toList.foreach {
                                    case f: WhereBoCaseClass[_, _] =>
                                        res += getSQLWhereItem(f)
                                }
                        }
                }

                if (includeDsRequest) {
                    val _wheres1 = SQLWhereItems(
                        dsRequest match {
                            case null => SQLWhereItem()
                            case request =>
                                request.appendCriteria(fields = columns, columns = columns.getColumns, bindMap = bindMap)
                        }
                    )

                    //logger.trace(s"_wheres1 is: ${newLine + _wheres1.toSQL()}")

                    if (res.length > 0 && _wheres1.length > 0)
                        res += SQLWhereItemClause(opIdAnd)
                    res += _wheres1
                }

            }
            //logger.trace(s"res is: ${newLine + res.toSQL()}")
            res
        }
        //logger.trace(s"Constructed Where is: ${newLine + sqlWhere.toSQL()}")

        def getOrderBy(f: OrderByCaseClass): SQLOrderBy = SQLOrderBy(field = f.column.getColumn1, dir = f.order)

        def sqlOrdersBy: SQLOrdersBy = {
            val res = SQLOrdersBy()
            val obs = orderBies
            obs match {
                case Nil =>
                case xs => xs.foreach {
                    case f: OrderByCaseClass =>
                        res += getOrderBy(f)
                    case list: OrderByList =>
                        list.toList.map {
                            case f: OrderByCaseClass =>
                                res += getOrderBy(f)
                        }
                }
            }

            dsRequest match {
                case null =>
                case _ =>
                    dataSource.sqlDialect match {
                        case OracleDialect =>
                            val sb = dsRequest.sortBy
                            sb match {
                                case null =>
                                case sortBy =>
                                    sortBy.foreach(
                                        _.asString match {
                                            case None ⇒
                                            case Some(f) ⇒
                                                getColumnInBase(SQLField(name = f)) match {
                                                    case Some(field) =>
                                                        res += SQLOrderBy(field = field, dir = if (f.toString.indexOf("-") > -1) DescOrderBy else AscOrderBy)
                                                    case _ =>
                                                }
                                        }
                                    )
                            }
                        case _ =>
                    }
            }
            res
        }
        //logger.trace(s"Constructed sqlOrdersBy is: ${newLine + sqlOrdersBy.toSQL()}")

        def getFrom: SQLFrom = {
            val res = from match {

                case from: From[_] if joinsBo.length === 0 =>
                    SQLFrom(table = SQLTable(name = from.table.databaseTablename, quoted = quoted), alias = from.table.alias, comment = SQLComment("From:".space + from.table.getClass.getSimpleName))

                case from: From[_] =>
                    SQLFrom(table = SQLCompoundTable(
                        fields = from.table.allColumns.getColumns,
                        from = SQLFrom(table = SQLTable(name = from.table.databaseTablename, quoted = quoted), alias = from.table.alias, comment = SQLComment("From:".space + from.table.getClass.getSimpleName)),
                        where = sqlWhere(_wheres = discriminators, includeDsRequest = false), joins = sqlJoins(_joins = joinsTable)), alias = alias, comment = SQLComment("From:".space + getClass.getSimpleName)
                    )

                case from: FromBo[_] if from.clazz.tableCount === 1 =>

                    def getSQLFrom(count: Int): SQLFrom = {
                        if (count > 1)
                            SQLFrom(table = SQLCompoundTable(
                                fields = from.clazz.allColumns.getColumns intersect compoundAllColumns.getColumns,
                                from = SQLFrom(table = SQLTable(name = from.clazz.fromTable.databaseTablename, quoted = quoted), alias = from.clazz.fromTable.alias, comment = SQLComment("From:".space + from.clazz.getClass.getSimpleName)),
                                where = sqlWhere(_wheres = wheres, includeDsRequest = false, innerSelect = true)), alias = from.clazz.alias, comment = SQLComment("From:".space + getClass.getSimpleName)
                            )
                        else
                            SQLFrom(table = SQLTable(
                                name = from.clazz.fromTable.databaseTablename, quoted = quoted),
                                alias = from.clazz.fromTable.alias,
                                comment = SQLComment("From:".space + from.clazz.getClass.getSimpleName)
                            )
                    }

                    if (isDataSet)
                        getSQLFrom(boCount)
                    else
                        getSQLFrom(tableCount)

                case from: FromBo[_] if joinsDs.length > 0 =>
                    val preparedResult = from.clazz.preparedBO4Wrap(columns = compoundAllColumns)

                    SQLFrom(table = SQLCompoundTable(
                        fields = from.clazz.allColumns.getColumns intersect compoundAllColumns.getColumns,
                        from = SQLFrom(table = preparedResult.sql, alias = from.clazz.alias, comment = SQLComment("From:".space + from.clazz.getClass.getSimpleName)),
                        where = sqlWhere(_wheres = wheres, includeDsRequest = false)), alias = from.clazz.alias, comment = SQLComment("From:".space + getClass.getSimpleName)
                    )

                case from: FromBo[_] =>
                    val preparedResult = from.clazz.preparedBO4Wrap(columns = compoundAllColumns)

                    SQLFrom(table = SQLCompoundTable(
                        fields = from.clazz.allColumns.getColumns intersect compoundAllColumns.getColumns,
                        from = SQLFrom(table = preparedResult.sql, alias = from.clazz.alias, comment = SQLComment("From:".space + from.clazz.getClass.getSimpleName)),
                        where = sqlWhere(_wheres = wheres, includeDsRequest = false)), alias = from.clazz.alias /*, comment = SQLComment("From:".space + getClass.getSimpleName)*/
                    )

                case from: FromDS[_] =>

                    val preparedResult = from.dataSet.preparedBO4Wrap(columns = compoundAllColumns)

                    SQLFrom(table = SQLCompoundTable(
                        fields = compoundAllColumns.getColumns,
                        from = SQLFrom(table = preparedResult.sql, alias = from.dataSet.alias, comment = SQLComment("From:".space + from.dataSet.getClass.getSimpleName)),
                        where = sqlWhere(_wheres = wheres, includeDsRequest = false), joins = sqlJoins(_joins = joinsDs)), alias = from.dataSet.alias, comment = SQLComment("From:".space + getClass.getSimpleName)
                    )

                case _ =>
                    throw new RuntimeException("Not selecte from clause.")
            }

            res
        }

        //Трансформируем цепочку OrderBy согласно полям которые имеем в результирующем селекте
        def topLevelOrderBy(fields: SQLFields, orderBy: SQLOrdersBy): SQLOrdersBy = SQLOrdersBy(orderBy.getFields.map {
            case x@SQLOrderBy(field, dir) =>
                val _field = fields.getFields.filter { f =>
                    f.name == field.name && f.tableOwner == field.tableOwner
                }.headOption
                _field match {
                    case None =>
                        x
                    case Some(y) =>
                        SQLOrderBy(field.copy(name = y.name, alias = y.alias, tableOwner = y.tableOwner), dir)
                }
            case x => x
        }: _*)

        def preSQL(topLevel: Boolean): SQLAbsTable = dataSource.sqlDialect match {
            case OracleDialect =>
                val fields = getSQLColumns
                //logger trace s"columns: ${newLine + fields.toSQL()}"

                SQLCompoundTable(
                    fields = fields,
                    from = getFrom,
                    where = sqlWhere(_wheres = (if (joinsBo.length === 0) wheres ++ discriminators else wheres), includeDsRequest = true),
                    joins = sqlJoins(_joins = (if (joinsBo.length != 0) joinsBo else joinsTable)),
                    ordersBy = if (topLevel)
                        topLevelOrderBy(fields, sqlOrdersBy)
                    else
                        SQLOrdersBy()
                )
            case _ =>
                throw new RuntimeException("Bad branch 'PreSQL'.")
        }

        def sql: SQLAbsTable = dsRequest match {
            case null =>
                preSQL(true)
            case _ =>
                if (dsRequest.endRow != 0 || dsRequest.startRow != 0)
                    dataSource.sqlDialect match {
                        case OracleDialect =>
                            val _fields: SQLFields = getSQLColumns.sqlFieldsWithTableOwner(SQLTable("T1")) + SQLField(name = "ROWNUM", isSystem = true, quoted = false, alias = "sys$$simplesys$$rownum".als)

                            val table1: SQLCompoundTable = SQLCompoundTable(
                                fields = _fields,
                                from = SQLFrom(table = preSQL(false), alias = "T1".als, comment = SQLComment("From:".space + getClass.getSimpleName + " + system column ROWNUM and upper bound for this")),
                                optimizeField = false,
                                where = SQLWhere(SQLWhereItem(field = SQLField(name = "ROWNUM", quoted = false, isSystem = true), operator = opIdLessThan, value = SQLValuePlaceHolder))
                            )

                            val fields: SQLFields = getSQLColumns.sqlFieldsWithTableOwner(SQLTable("T2"))
                            SQLCompoundTable(
                                fields = fields,
                                from = SQLFrom(table1, alias = "T2".als, comment = SQLComment("From:".space + getClass.getSimpleName + " + wrapper for lower bound")),
                                optimizeField = false,
                                where = SQLWhere(SQLWhereItem(field = SQLField(name = "sys$$simplesys$$rownum", quoted = false), operator = opIdGreaterThan, value = SQLValuePlaceHolder)),
                                ordersBy = topLevelOrderBy(fields, sqlOrdersBy)
                            )
                        case _ =>
                            logger warn ("Not implementation for :" + dataSource.sqlDialect.toString)
                            preSQL(true)
                    }
                else
                    preSQL(true)
        }

        PreparedResult(sql = sql, joinsDs = joinsDs, joinsBo = joinsBo, joinsTable = joinsTable, wheres = wheres, discriminators = discriminators, bindMap = bindMap /*.toSet*/)
    }


    def fieldFromJoins(joinConditions: List[JoinConditionParam]): List[BasicClassBOColumn[_]] =
        joinConditions.map {
            case BoJoinCondition(column1, _, column2) => Seq(column1, column2)
            case BoJoinCondition1(column, _, _) => Seq(column)
        }.flatten

    def getSQLWhereItems(f: WhereBoCaseClasses): SQLWhereItems = {
        SQLWhereItems(f.classes map {
            case clazz: WhereBoCaseClass[_, _] =>
                SQLWhereItem(field = clazz.column.getColumn1, operator = clazz.operator, value = SQLValuePlaceHolder)
            case x: WhereBoClause =>
                SQLWhereItemClause(x.operator)
            case x: WhereBoCaseClasses =>
                getSQLWhereItems(x)

        }: _*)
    }

    def getWheres(where: WhereParam): SQLWhere = {
        def wheres: List[WhereParam] = (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }) ++ WheresList(_where).toList

        def sqlWhere: SQLWhere = SQLWhere((wheres match {
            case Nil => Seq(SQLWhereItem())
            case xs =>
                xs.map {
                    case f: WhereBoCaseClass[_, _] =>
                        f.operator.kind match {
                            case op: IsInList.type =>
                                SQLWhereItem(field = f.column.getColumn1, operator = f.operator, SQLValues((f.value match {
                                    case x: List[_] =>
                                        x.map(_ => SQLValuePlaceHolder)
                                }): _*))
                            case _ =>
                                SQLWhereItem(field = f.column.getColumn1, operator = f.operator, value = SQLValuePlaceHolder)
                        }
                    case f: WhereBoCaseClasses =>
                        getSQLWhereItems(f)
                    case f: WhereBoClause =>
                        SQLWhereItemClause(f.operator)
                }
        }): _*)

        logger.trace(s"Constructed Where is: ${newLine + sqlWhere.toDeleteSQL()}")
        logger.trace(s"Constructed Where is: ${newLine + sqlWhere.toUpdateSQL()}")
        logger.trace(s"Constructed Where is: ${newLine + sqlWhere.toSQL()}")
        sqlWhere
    }

    def MakeUpdateSQL(setters: SetParam, where: WhereParam, table: SQLTable): String = {
        def setFields: SQLFields = (setters match {
            case sets: SetsList => sets.toList
            case _ => Nil
        }) match {
            case Nil => new SQLFields()
            case xs => SQLFields(xs.map(_.column.getColumn1))
        }
        //logger.trace(s"Constructed setFields is: ${newLine + setFields.toUpdateSQL().replace("$AliasTable$.", "")}")

        def sqlUpdate: SQLAbsTable = dataSource.sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(fields = setFields, from = SQLFrom(table), where = getWheres(where))
            case _ =>
                throw new RuntimeException("Bad branch 'MakeUpdateSQL'.")
        }

        val res = sqlUpdate.toUpdateSQL()
        logger.trace(s"Constructed sqlUpdate is: ${newLine + res}")

        res
    }

    def batch4Update(preparedStatement: PreparedStatement, setters: SetParam, where: WhereParam = null) {

        var all_idx = 0

        (setters match {
            case sets: SetsList => sets.toList
            case _ => Nil
        }).foreach {
            case s =>
                all_idx += 1
                s.bind(preparedStatement, all_idx)
        }

        (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }).foreach {
            case b: WhereBoCaseClass[_, _] =>
                all_idx += 1
                b.bind(preparedStatement, all_idx)
            case _ =>
        }

        preparedStatement.addBatch()
    }

    def updateWithoutCommit(connection: Connection, setters: SetParam, where: WhereParam, table: SQLTable): Array[Int] = {
        val updateStr = MakeUpdateSQL(setters, where, table = table)

        prepareStatement(connection, updateStr, dataSource.settings.fetchSize) {
            preparedStatement =>
                batch4Update(preparedStatement = preparedStatement, setters = setters, where = where)
                preparedStatement.executeBatch()
        }
    }

    def makeDeleteSQL(where: WhereParam, table: SQLTable): String = {
        val sqlDelete: SQLAbsTable = dataSource.sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(from = SQLFrom(table), where = getWheres(where))
            case _ =>
                throw new RuntimeException("Bad branch 'MakeUpdateSQL'.")
        }

        val res = sqlDelete.toDeleteSQL()
        logger.trace(s"Constructed sqlDelete is: ${newLine + res}")
        res
    }

    def batch4Delete(statement: PreparedStatement, where: WhereParam = null) {
        var idx = 1
        (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }).foreach {
            case b: WhereBoCaseClass[_, _] =>
                b.bind(statement, idx)
                idx += 1
            case _ =>
        }

        statement.addBatch()
        statement.executeBatch()
    }

    def deleteWithoutCommit(connection: Connection, where: WhereParam, table: SQLTable): Array[Int] = {
        prepareStatement(connection, makeDeleteSQL(where, table), dataSource.settings.fetchSize) {
            statement =>
                batch4Delete(statement = statement, where = where)
                statement.executeBatch()
        }
    }
}
