package com.simplesys.jdbc.control

import java.io.{ByteArrayInputStream, InputStream, StringReader}
import java.util.{Date => JDate}

import com.simplesys.log.Logging
import com.simplesys.common.Strings._
import com.simplesys.tuple.{TupleSS1, TupleSS2}
import org.joda.time._
import com.simplesys.bonecp.BoneCPDataSource

import scala.reflect.ClassTag
import scala.language.experimental.macros
import ru.simplesys.meta.types._

import scala.Some
import ru.simplesys.meta.types.VarcharDataType
import com.simplesys.jdbc.control.SessionStructures._
import com.simplesys.jdbc.control.table._
import java.sql.{Connection, Date, Timestamp, PreparedStatement, ResultSet, SQLException}

import com.simplesys.common.array.{NotValue, toArray}
import com.simplesys.SQL.Gen._
import com.simplesys.sql.{OracleDialect, SQLDialect}
import com.simplesys.isc.system.typesDyn.IsInList
import com.simplesys.jdbc.control.TableSuperTuple._

trait Table[T <: Table[T]] extends Entity[T] with Logging {
    top =>

    val className = getClass.getSimpleName

    def databaseTablename: String

    def getDatabaseTable: SQLTable = SQLTable(name = databaseTablename, quoted = quoted)

    def sqlDialect: SQLDialect

    val isDataSet = false

    val constraints = Seq.empty[Constraint]

    type ColumnTypes <: Product

    def allColumns: ColumnTypes with TableFieldProduct

    abstract class ColumnTable[T] extends BasicTableColumn[T] {
        logger trace (s"Registred column ${this}")

        val isPrimaryKey: Boolean

        def ~[OT](column: ColumnTable[OT]): MyTableTuple2[T, OT] = {
            val _column = this

            new MyTableTuple2[T, OT](_column default, column default) {
                def fields = List(_column, column)

                def fieldProduct: TupleSS2[ColumnTable[T], ColumnTable[OT]] = TupleSS2(_column, column)
            }
        }

        def ~ : MyTableTuple1[T] = {
            val _column = this

            new MyTableTuple1[T](_column default) {
                def fields = List(_column)

                def fieldProduct: TupleSS1[ColumnTable[T]] = TupleSS1(_column)
            }
        }
    }

    abstract class OptionColumnTable[T: ClassTag] extends ColumnTable[Array[T]]

    case class BlobColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[InputStream] {

        def entity: Entity[_] = top

        def getDBDataType = BlobDataType

        def default = new EmptyInputStream()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getBinaryStream getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: InputStream) {
            preparedStatement.setBinaryStream(parameterIndex, value)
        }
    }

    case class BlobOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[InputStream] {

        def entity: Entity[_] = top

        def getDBDataType = BlobDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getBinaryStream getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[InputStream]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setBinaryStream(parameterIndex, value)
            }
        }
    }

    case class ClobColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[String] {

        import com.simplesys.jdbc._

        def entity: Entity[_] = top

        def getDBDataType = VarcharDataType(-1)

        def default = strEmpty

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getClob getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement.setClob(parameterIndex, new StringReader(value))
        }
    }

    case class ClobOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[String] {

        import com.simplesys.jdbc._

        def entity: Entity[_] = top

        def getDBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getClob getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setClob(parameterIndex, new StringReader(value))
            }
        }
    }

    case class JsonColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[String] {

        import com.simplesys.jdbc._

        def entity: Entity[_] = top

        def getDBDataType = VarcharDataType(-1)

        def default = strEmpty

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getClob getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement.setClob(parameterIndex, new StringReader(value))
        }
    }

    case class JsonOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[String] {

        import com.simplesys.jdbc._

        def entity: Entity[_] = top

        def getDBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getClob getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement.setClob(parameterIndex, new StringReader(value))
            }
        }
    }

    case class IntColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[Int] {

        def entity: Entity[_] = top

        def getDBDataType = IntegerDataType

        def default = 0

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getInt getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Int) {
            preparedStatement setInt(parameterIndex, value)
        }
    }

    case class IntOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[Int] {
        def entity: Entity[_] = top

        def getDBDataType = IntegerDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getInt getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Int]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setInt(parameterIndex, value)
            }
        }
    }

    case class DoubleColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[Double] {
        def entity: Entity[_] = top

        def getDBDataType = DoubleDataType

        def default = 0

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getDouble getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Double) {
            preparedStatement setDouble(parameterIndex, value)
        }
    }

    case class DoubleOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[Double] {
        def entity: Entity[_] = top

        def getDBDataType = DoubleDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getDouble getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Double]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setDouble(parameterIndex, value)
            }
        }
    }

    case class LongColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[Long] {
        def entity: Entity[_] = top

        def getDBDataType = LongDataType

        def default = 0L

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getLong getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Long) {
            preparedStatement setDouble(parameterIndex, value)
        }
    }

    case class LongOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[Long] {
        def entity: Entity[_] = top

        def getDBDataType = LongDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getLong getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Long]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setDouble(parameterIndex, value)
            }
        }
    }

    case class BigDecimalColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[BigDecimal] {
        def entity: Entity[_] = top

        def getDBDataType = BigDecimalDataType

        def default: BigDecimal = BigDecimal(0)

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet): BigDecimal = resultSet getBigDecimal getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: BigDecimal) {
            preparedStatement setBigDecimal(parameterIndex, value.bigDecimal)
        }
    }

    case class BigDecimalOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[BigDecimal] {
        def entity: Entity[_] = top

        def getDBDataType = BigDecimalDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getBigDecimal getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[BigDecimal]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setBigDecimal(parameterIndex, value.bigDecimal)
            }
        }
    }

    case class BooleanColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[Boolean] {
        def entity: Entity[_] = top

        def getDBDataType = BooleanDataType

        def default = false

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getBoolean getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Boolean) {
            preparedStatement setBoolean(parameterIndex, value)
        }
    }

    case class BooleanOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[Boolean] {
        def entity: Entity[_] = top

        def getDBDataType = BooleanDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getBoolean getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[Boolean]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setBoolean(parameterIndex, value)
            }
        }
    }

    case class StringColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[String] {
        def entity: Entity[_] = top

        def getDBDataType: DBDataType = VarcharDataType(-1)

        def default = ""

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = resultSet getString getName

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: String) {
            preparedStatement setString(parameterIndex, value)
        }
    }

    case class StringOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[String] {
        def entity: Entity[_] = top

        def getDBDataType = VarcharDataType(-1)

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(resultSet getString getName)

        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[String]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setString(parameterIndex, value)
            }
        }
    }

    implicit def StringOption2String(column: StringOptionColumnTable): StringColumnTable = StringColumnTable(name = column.name, isPrimaryKey = column.isPrimaryKey)

    case class DateColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[DateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = new DateTime()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = new DateTime(resultSet getDate getName)


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: DateTime) {
            preparedStatement setDate(parameterIndex, new Date(value.getMillis))
        }
    }

    case class DateOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[DateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(new DateTime(resultSet getDate getName))


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[DateTime]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setDate(parameterIndex, new Date(value.getMillis))
            }
        }
    }

    case class DateTimeColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[DateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = new DateTime()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = new DateTime(resultSet getDate getName)


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: DateTime) {
            preparedStatement setTimestamp(parameterIndex, new Timestamp(value.getMillis))
        }
    }

    case class DateTimeOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[DateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(new DateTime(resultSet getDate getName))


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[DateTime]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setTimestamp(parameterIndex, new Timestamp(value.getMillis))
            }
        }
    }

    case class LocalDateTimeColumnTable(name: String, isPrimaryKey: Boolean = false) extends ColumnTable[LocalDateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = new LocalDateTime()

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = new LocalDateTime(resultSet getDate getName)


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: LocalDateTime) {
            preparedStatement setTimestamp(parameterIndex, new Timestamp(value.toDateTime.getMillis))
        }
    }

    case class LocalDateTimeOptionColumnTable(name: String, isPrimaryKey: Boolean = false) extends OptionColumnTable[LocalDateTime] {
        def entity: Entity[_] = top

        def getDBDataType = DateTimeDataType

        def default = NotValue

        @throws(classOf[SQLException])
        def get(resultSet: ResultSet) = toArray(new LocalDateTime(resultSet getDate getName))


        @throws(classOf[SQLException])
        def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: Array[LocalDateTime]) {
            value.headOption match {
                case None => preparedStatement setNull(parameterIndex, getDBDataType.sqlDataType)
                case Some(value) => preparedStatement setTimestamp(parameterIndex, new Timestamp(value.toDateTime.getMillis))
            }
        }
    }

    def selectList[FT <: Product with TableFieldProduct](columns: FT = allColumns, where: WhereParam = null, orderBy: OrderByParam = null): ValidationEx[List[FT#ReturnType]] = {

        val ps = PrepareSelect(columns, where, orderBy)

        session(dataSource) {
            connection => prepareStatement(connection, ps._1.toSQL(), dataSource.Config.FetchSize) {
                preparedStatement =>
                    var idx = 1
                    ps._2.foreach {
                        case b: WhereTableCaseClass[_, _] =>
                            b.bind(preparedStatement, idx)
                            idx += 1
                        case _ =>
                    }
                    executeQuery(preparedStatement) {
                        resultSet => columns buildResult resultSet
                    }
            }
        }
    }

    def selectOne[FT <: Product with TableFieldProduct](columns: FT = allColumns, where: WhereParam = null, orderBy: OrderByParam = null): ValidationEx[FT#ReturnType] = {

        val ps = PrepareSelect(columns, where, orderBy)

        session(dataSource) {
            connection => prepareStatement(connection, ps._1.toSQL(), dataSource.Config.FetchSize) {
                preparedStatement =>
                    var idx = 1
                    ps._2.foreach {
                        case b: WhereTableCaseClass[_, _] =>
                            b.bind(preparedStatement, idx)
                            idx += 1
                        case _ =>
                    }
                    executeOne(preparedStatement) {
                        resultSet => columns buildResult resultSet
                    }
            }
        }
    }


    def PrepareSelect[FT <: Product with TableFieldProduct](columns: FT, where: WhereParam, orderBy: OrderByParam): (SQLAbsTable, List[WhereParam]) = {

        val fields: SQLFields = columns.getColumns
        //logger.trace(s"Constructed fields is: ${newLine + fields.toSQL().replace("$AliasTable$.", "")}")

        val wheres = where match {
            case where: WheresList => where.toList
            case _ => Nil
        }

        val sqlWhere = SQLWhere((wheres match {
            case Nil => Seq(SQLWhereItem())
            case xs =>
                xs.map {
                    case f: WhereTableCaseClass[_, _] =>
                        f.operator.kind match {
                            case op: IsInList.type =>
                                SQLWhereItem(field = f.column.getColumn, operator = f.operator, SQLValues((f.value match {
                                    case x: List[_] =>
                                        x.map(_ => SQLValuePlaceHolder)
                                }): _*))
                            case _ =>
                                SQLWhereItem(field = f.column.getColumn, operator = f.operator, value = SQLValuePlaceHolder)
                        }
                    case f: WhereTableClause =>
                        SQLWhereItemClause(f.operator)
                }
        }): _*)
        //logger.trace(s"Constructed sqlWhere is: ${newLine + sqlWhere.toSQL()}")

        val order: List[OrderByCaseClass] = orderBy match {
            case orderBy: OrderByList => orderBy.toList
            case _ => Nil
        }

        def sqlOrdersBy: SQLOrdersBy = {
            val res = SQLOrdersBy(
                (order match {
                    case Nil => Seq(SQLNullOrderBy)
                    case xs => xs.map(
                        f => SQLOrderBy(field = f.column.getColumn, dir = f.order)
                    )
                }): _*)
            res
        }
        //logger.trace(s"Constructed sqlOrdersBy is: ${newLine + sqlOrdersBy.toSQL()}")

        def sql: SQLAbsTable = sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(fields = fields, from = SQLFrom(table = getDatabaseTable, alias = alias), where = sqlWhere, ordersBy = sqlOrdersBy)
            case _ =>
                throw new RuntimeException("Bad branch 'PreSQL'.")
        }
        logger.trace(newLine + s"Constructed SQLFetch is: ${newLine + sql.toSQL()}")

        (sql, wheres)
    }

    def insertRoot[FT <: Product with TableFieldProduct](columns: FT, values: Seq[InsertParam]): ValidationEx[List[Int]] = {

        def sqlInsert: SQLAbsTable = sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(fields = columns.getColumns, from = SQLFrom(table = getDatabaseTable))
            case _ =>
                throw new RuntimeException("Bad branch 'PreSQL'.")
        }
        logger.trace(newLine + s"Constructed sqlInsert is: ${newLine + sqlInsert.toInsertSQL()}")

        transaction(dataSource) {
            connection => prepareStatement(connection, sqlInsert.toInsertSQL(), dataSource.Config.FetchSize) {
                statement =>
                    batch4Insert(statement = statement, values)
                    statement.executeBatch().toList
            }
        }
    }

    def batch4Insert[T: ClassTag](statement: PreparedStatement, values: Seq[InsertParam]) {
        PrepareInsert(values = values, statement = statement)
    }


    def PrepareInsert[T: ClassTag](values: Seq[InsertParam], statement: PreparedStatement) {
        values foreach {
            value =>
                (value match {
                    case inserts: InsertsList => inserts.toList
                    case _ => Nil
                }).zipWithIndex.foreach {
                    case (b, idx) => b.bind(statement, idx + 1)
                }
                statement.addBatch()
        }
    }

    def insertWithoutCommit[FT <: Product with TableFieldProduct](connection: Connection, columns: FT, values: Seq[InsertParam]): List[Int] = {
        def sqlInsert: SQLAbsTable = sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(fields = columns.getColumns, from = SQLFrom(table = getDatabaseTable))
            case _ =>
                throw new RuntimeException("Bad branch 'sqlInsert'.")
        }
        logger.trace(newLine + s"Constructed sqlInsert is: ${newLine + sqlInsert.toInsertSQL()}")

        if (!connection.isValid(0))
            throw new SQLException("Connection is not valid.")


        prepareStatement(connection, sqlInsert.toInsertSQL(), dataSource.Config.FetchSize) {
            statement =>
                PrepareInsert(values = values, statement = statement)
                statement.executeBatch().toList
        }
    }

    def MakeUpdateSQL(setters: SetParam, where: WhereParam): String = {
        val setFields: SQLFields = (setters match {
            case sets: SetsList => sets.toList
            case _ => Nil
        }) match {
            case Nil => new SQLFields()
            case xs => SQLFields(xs.map(_.column.getColumn))
        }

        val whereSQL: SQLWhere = (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }) match {
            case Nil => SQLWhere()
            case xs =>
                SQLWhere(xs.map {
                    case f: WhereTableCaseClass[_, _] => SQLWhereItem(field = f.column.getColumn, operator = f.operator, value = SQLValuePlaceHolder)
                    case f: WhereTableClause => SQLWhereItemClause(f.operator)
                }: _*)
        }

        def sqlUpdate: SQLAbsTable = sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(fields = setFields, from = SQLFrom(table = getDatabaseTable), where = whereSQL)
            case _ =>
                throw new RuntimeException("Bad branch 'MakeUpdateSQL'.")
        }
        logger.trace(newLine + s"Constructed sqlUpdate is: ${newLine + sqlUpdate.toUpdateSQL()}")

        val res = sqlUpdate.toUpdateSQL()
        res
    }

    def update(setters: SetParam, where: WhereParam = null): ValidationEx[List[Int]] = {
        transaction(dataSource) {
            connection => prepareStatement(connection, MakeUpdateSQL(setters, where), dataSource.Config.FetchSize) {
                preparedStatement =>
                    batch4Update(preparedStatement = preparedStatement, setters = setters, where = where)
                    preparedStatement.executeBatch().toList
            }
        }
    }

    def updateWithoutCommit(connection: Connection, setters: SetParam, where: WhereParam = null): List[Int] = {
        val updateStr = MakeUpdateSQL(setters, where)

        prepareStatement(connection, updateStr, dataSource.Config.FetchSize) {
            preparedStatement =>
                batch4Update(preparedStatement = preparedStatement, setters = setters, where = where)
                preparedStatement.executeBatch().toList
        }
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
            case b: WhereTableCaseClass[_, _] =>
                all_idx += 1
                b.bind(preparedStatement, all_idx)
            case _ =>
        }

        preparedStatement.addBatch()
    }

    def delete(where: WhereParam = null): ValidationEx[List[Int]] = {
        transaction(dataSource) {
            connection => prepareStatement(connection, MakeDeleteSQL(where), dataSource.Config.FetchSize) {
                statement =>
                    batch4Delete(statement = statement, where = where)
                    statement.executeBatch().toList
            }
        }
    }

    def MakeDeleteSQL(where: WhereParam): String = {
        def whereSQL: SQLWhere = (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }) match {
            case Nil => SQLWhere()
            case xs =>
                SQLWhere(xs.map {
                    case f: WhereTableCaseClass[_, _] => SQLWhereItem(field = f.column.getColumn, operator = f.operator, value = SQLValuePlaceHolder)
                    case f: WhereTableClause => SQLWhereItemClause(f.operator)
                }: _*)
        }

        def sqlDelete: SQLAbsTable = sqlDialect match {
            case OracleDialect =>
                SQLCompoundTable(from = SQLFrom(table = getDatabaseTable), where = whereSQL)
            case _ =>
                throw new RuntimeException("Bad branch 'MakeUpdateSQL'.")
        }
        logger.trace(newLine + s"Constructed sqlDelete is: ${newLine + sqlDelete.toDeleteSQL()}")

        sqlDelete.toDeleteSQL()
    }

    def deleteWithoutCommit(connection: Connection, where: WhereParam = null): List[Int] = {
        prepareStatement(connection, MakeDeleteSQL(where), dataSource.Config.FetchSize) {
            statement =>
                batch4Delete(statement = statement, where = where)
                statement.executeBatch().toList
        }
    }

    def batch4Delete(statement: PreparedStatement, where: WhereParam = null) {

        var idx = 1
        (where match {
            case where: WheresList => where.toList
            case _ => Nil
        }).foreach {
            case b: WhereTableCaseClass[_, _] =>
                b.bind(statement, idx)
                idx += 1
            case _ =>
        }

        statement.addBatch()
        statement.executeBatch().toList
    }

    protected def dataSource: BoneCPDataSource
}

