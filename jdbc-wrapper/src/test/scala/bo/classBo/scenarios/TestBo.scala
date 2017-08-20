// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenBOs, stage: #819"

package ru.simplesys.defs.bo

package scenarios

import com.simplesys.jdbc.control._
import com.simplesys.bonecp.BoneCPDataSource
import java.sql.Connection
import com.simplesys.jdbc.control.SessionStructures._
import com.simplesys.jdbc.control.ValidationEx
import com.simplesys.SQL.Gen.{SQLAlias, SQLAbsTable, SQLTable}
import com.simplesys.jdbc.control.classBO.{Where, Set}
import com.simplesys.jdbc.control.table.From
import org.joda.time.{LocalDateTime, DateTime}
import com.simplesys.jdbc.control.table.{Insert, InnerJoin}
import scalaz.{Failure, Success}
import ru.simplesys.defs.bo.scenarios.table._
import com.simplesys.common.array._
import com.simplesys.jdbc.control.SuperTuple1.FieldProduct
import com.simplesys.jdbc._
import com.simplesys.SQL._
import com.simplesys.common.Strings._
import collection.SeqView
import com.simplesys.json.JsonElement
import com.simplesys.jdbc.control.clob._
import com.simplesys.tuple._
import com.simplesys.jdbc.control.table.JoinsTable._



 
object TestBo {
     def apply(implicit dataSource: BoneCPDataSource) = new TestBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestBo(alias = alias)    
    
    val objectName = "Test"    
    val groupName = "scenarios"
}


 
class TestBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[TestBo]  {
/////////////////////////////////////////// Class: Test, group: scenarios ///////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): TestBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val TestTbl = new TestTbl(alias = alias + "T0".als)    
    override val fromTable = TestTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val active = BooleanColumn(name = "BACTIVE", nameInBo = "active", caption = "\u0410\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u044C", tableColumn = TestTbl.active)    
    val address = StringColumn(name = "SADDRESS", nameInBo = "address", caption = "\u0422\u0435\u043B\u0435\u0444\u043E\u043D", tableColumn = TestTbl.address)    
    val captionTest = StringOptionColumn(name = "SCAPTIONTEST", nameInBo = "captionTest", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u044D\u043B\u0435\u043C\u0435\u043D\u0442\u0430", tableColumn = TestTbl.captionTestOption)    
    val codeTest = StringOptionColumn(name = "SCODETEST", nameInBo = "codeTest", caption = "\u041A\u043E\u0434 \u044D\u043B\u0435\u043C\u0435\u043D\u0442\u0430", tableColumn = TestTbl.codeTestOption)    
    val createDate = LocalDateTimeOptionColumn(name = "DTCREATEDATE", nameInBo = "createDate", caption = "\u0412\u0440\u0435\u043C\u044F \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u044F", tableColumn = TestTbl.createDateOption)    
    val descriptionTest = StringOptionColumn(name = "SDESCRIPTIONTEST", nameInBo = "descriptionTest", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u044D\u043B\u0435\u043C\u0435\u043D\u0442\u0430", tableColumn = TestTbl.descriptionTestOption)    
    val group = LongColumn(name = "IDGROUP", nameInBo = "group", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = TestTbl.group)    
    val id = LongColumn(name = "ID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = TestTbl.id)    
    val text = StringColumn(name = "STEXT", nameInBo = "text", caption = "\u0422\u0435\u043A\u0441\u0442 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u044F", tableColumn = TestTbl.text)    
    val timestamp = LocalDateTimeColumn(name = "DTTIMESTAMP", nameInBo = "timestamp", caption = "\u0412\u0440\u0435\u043C\u044F", tableColumn = TestTbl.timestamp)    
    
    // For select tuple: (active: Boolean, address: String, captionTest: Array[String], codeTest: Array[String], createDate: Array[LocalDateTime], descriptionTest: Array[String], group: Long, id: Long, text: String, timestamp: LocalDateTime)    
    
    type ColumnTypes =     TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]    
    val allColumns = active ~ address ~ captionTest ~ codeTest ~ createDate ~ descriptionTest ~ group ~ id ~ text ~ timestamp    
    val allColumns1 = Seq(active , address , captionTest , codeTest , createDate , descriptionTest , group , id , text , timestamp)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id)),
            UniqueKey(name = "ucCodeTest", constraintDate = KeyConstraintData(codeTest)),
            ForignKey(name = "frGroup", constraintDate = ForignKeyConstraintData(group, ReferencedData("scenarios","TestGroup"), true)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
//////////////////////////////////////////////// Table: Test ////////////////////////////////////////////////    
    val activeTestTbl = TestTbl.active    
    val addressTestTbl = TestTbl.address    
    val captionTestTestTbl = TestTbl.captionTestOption    
    val codeTestTestTbl = TestTbl.codeTestOption    
    val createDateTestTbl = TestTbl.createDateOption    
    val descriptionTestTestTbl = TestTbl.descriptionTestOption    
    val groupTestTbl = TestTbl.group    
    val idTestTbl = TestTbl.id    
    val textTestTbl = TestTbl.text    
    val timestampTestTbl = TestTbl.timestamp    
/////////////////////////////////////////////// End Table: Test ///////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(TestTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(TestTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(TestTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(TestTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Test]] = 
        selectPIteratorRoot(columns = columns, from = From(TestTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS10(active: Boolean, address: String, captionTest: Array[String], codeTest: Array[String], createDate: Array[LocalDateTime], descriptionTest: Array[String], group: Long, id: Long, text: String, timestamp: LocalDateTime) => 
        Test(active = active, address = address, captionTest = captionTest, codeTest = codeTest, createDate = createDate, descriptionTest = descriptionTest, group = group, id = id, text = text, timestamp = timestamp)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Test]] = 
                selectListRoot(columns = allColumns, from = From(TestTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS10(active: Boolean, address: String, captionTest: Array[String], codeTest: Array[String], createDate: Array[LocalDateTime], descriptionTest: Array[String], group: Long, id: Long, text: String, timestamp: LocalDateTime) => 
                        Test(active = active, address = address, captionTest = captionTest, codeTest = codeTest, createDate = createDate, descriptionTest = descriptionTest, group = group, id = id, text = text, timestamp = timestamp)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Test] = 
                selectOneRoot(columns = allColumns, from = From(TestTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS10(active: Boolean, address: String, captionTest: Array[String], codeTest: Array[String], createDate: Array[LocalDateTime], descriptionTest: Array[String], group: Long, id: Long, text: String, timestamp: LocalDateTime)) => 
                ValidationEx(Success(Test(active = active, address = address, captionTest = captionTest, codeTest = codeTest, createDate = createDate, descriptionTest = descriptionTest, group = group, id = id, text = text, timestamp = timestamp)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                TestTbl.insertWithoutCommit(connection = connection, columns = activeTestTbl ~ addressTestTbl ~ captionTestTestTbl ~ codeTestTestTbl ~ createDateTestTbl ~ descriptionTestTestTbl ~ groupTestTbl ~ idTestTbl ~ textTestTbl ~ timestampTestTbl, 
                    values map
                        {
                        value =>
                            Insert(activeTestTbl, value _1) Insert(addressTestTbl, value _2) Insert(captionTestTestTbl, value _3) Insert(codeTestTestTbl, value _4) Insert(createDateTestTbl, value _5) Insert(descriptionTestTestTbl, value _6) Insert(groupTestTbl, value _7) Insert(idTestTbl, value _8) Insert(textTestTbl, value _9) Insert(timestampTestTbl, value _10)
                    })
        }    
    
     def insertP(values: Test*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                TestTbl.insertWithoutCommit(connection = connection, columns = activeTestTbl ~ addressTestTbl ~ captionTestTestTbl ~ codeTestTestTbl ~ createDateTestTbl ~ descriptionTestTestTbl ~ groupTestTbl ~ idTestTbl ~ textTestTbl ~ timestampTestTbl, 
                    values map
                        {
                        value =>
                            Insert(activeTestTbl, value.active) Insert(addressTestTbl, value.address) Insert(captionTestTestTbl, value.captionTest) Insert(codeTestTestTbl, value.codeTest) Insert(createDateTestTbl, value.createDate) Insert(descriptionTestTestTbl, value.descriptionTest) Insert(groupTestTbl, value.group) Insert(idTestTbl, value.id) Insert(textTestTbl, value.text) Insert(timestampTestTbl, value.timestamp)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime]*): List[Int] = {
        TestTbl.insertWithoutCommit(connection = connection, columns = activeTestTbl ~ addressTestTbl ~ captionTestTestTbl ~ codeTestTestTbl ~ createDateTestTbl ~ descriptionTestTestTbl ~ groupTestTbl ~ idTestTbl ~ textTestTbl ~ timestampTestTbl, 
            values map
                {
                value =>
                    Insert(activeTestTbl, value _1) Insert(addressTestTbl, value _2) Insert(captionTestTestTbl, value _3) Insert(codeTestTestTbl, value _4) Insert(createDateTestTbl, value _5) Insert(descriptionTestTestTbl, value _6) Insert(groupTestTbl, value _7) Insert(idTestTbl, value _8) Insert(textTestTbl, value _9) Insert(timestampTestTbl, value _10)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Test*): List[Int] = {
        TestTbl.insertWithoutCommit(connection = connection, columns = activeTestTbl ~ addressTestTbl ~ captionTestTestTbl ~ codeTestTestTbl ~ createDateTestTbl ~ descriptionTestTestTbl ~ groupTestTbl ~ idTestTbl ~ textTestTbl ~ timestampTestTbl, 
            values map
                {
                value =>
                    Insert(activeTestTbl, value.active) Insert(addressTestTbl, value.address) Insert(captionTestTestTbl, value.captionTest) Insert(codeTestTestTbl, value.codeTest) Insert(createDateTestTbl, value.createDate) Insert(descriptionTestTestTbl, value.descriptionTest) Insert(groupTestTbl, value.group) Insert(idTestTbl, value.id) Insert(textTestTbl, value.text) Insert(timestampTestTbl, value.timestamp)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(address, value _2) Set(captionTest, value _3) Set(codeTest, value _4) Set(createDate, value _5) Set(descriptionTest, value _6) Set(group, value _7) Set(id, value _8) Set(text, value _9) Set(timestamp, value _10), where = where, table = SQLTable(TestTbl.databaseTablename))
        }    
    
     def updateP(value: Test, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(address, value.address) Set(captionTest, value.captionTest) Set(codeTest, value.codeTest) Set(createDate, value.createDate) Set(descriptionTest, value.descriptionTest) Set(group, value.group) Set(id, value.id) Set(text, value.text) Set(timestamp, value.timestamp), where = where, table = SQLTable(TestTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS10[Boolean, String, Array[String], Array[String], Array[LocalDateTime], Array[String], Long, Long, String, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(address, value _2) Set(captionTest, value _3) Set(codeTest, value _4) Set(createDate, value _5) Set(descriptionTest, value _6) Set(group, value _7) Set(id, value _8) Set(text, value _9) Set(timestamp, value _10), where = where, table = SQLTable(TestTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Test, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(address, value.address) Set(captionTest, value.captionTest) Set(codeTest, value.codeTest) Set(createDate, value.createDate) Set(descriptionTest, value.descriptionTest) Set(group, value.group) Set(id, value.id) Set(text, value.text) Set(timestamp, value.timestamp), where = where, table = SQLTable(TestTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = TestTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = TestTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}