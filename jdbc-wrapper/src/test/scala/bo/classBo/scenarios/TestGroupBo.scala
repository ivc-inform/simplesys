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



 
object TestGroupBo {
     def apply(implicit dataSource: BoneCPDataSource) = new TestGroupBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new TestGroupBo(alias = alias)    
    
    val objectName = "TestGroup"    
    val groupName = "scenarios"
}


 
class TestGroupBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[TestGroupBo]  {
////////////////////////////////////////// Class: TestGroup, group: scenarios //////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): TestGroupBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val TestGroupTbl = new TestGroupTbl(alias = alias + "T0".als)    
    override val fromTable = TestGroupTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val active = BooleanColumn(name = "BACTIVE", nameInBo = "active", caption = "\u0410\u043A\u0442\u0438\u0432\u043D\u043E\u0441\u0442\u044C", tableColumn = TestGroupTbl.active)    
    val captionGroup = StringOptionColumn(name = "SCAPTIONGROUP", nameInBo = "captionGroup", caption = "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = TestGroupTbl.captionGroupOption)    
    val codeGroup = StringColumn(name = "SCODEGROUP", nameInBo = "codeGroup", caption = "\u041A\u043E\u0434 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = TestGroupTbl.codeGroup)    
    val descriptionGroup = StringOptionColumn(name = "SDESCRIPTIONGROUP", nameInBo = "descriptionGroup", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435 \u0433\u0440\u0443\u043F\u043F\u044B", tableColumn = TestGroupTbl.descriptionGroupOption)    
    val id = LongColumn(name = "ID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = TestGroupTbl.id)    
    val parent = LongOptionColumn(name = "IDPARENT", nameInBo = "parent", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = TestGroupTbl.parentOption)    
    val status = LongOptionColumn(name = "NSTATUS", nameInBo = "status", caption = "\u0421\u0442\u0430\u0442\u0443\u0441", tableColumn = TestGroupTbl.statusOption)    
    
    // For select tuple: (active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], id: Long, parent: Array[Long], status: Array[Long])    
    
    type ColumnTypes =     TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]    
    val allColumns = active ~ captionGroup ~ codeGroup ~ descriptionGroup ~ id ~ parent ~ status    
    val allColumns1 = Seq(active , captionGroup , codeGroup , descriptionGroup , id , parent , status)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id)),
            UniqueKey(name = "ucCodeGroup", constraintDate = KeyConstraintData(codeGroup)),
            ForignKey(name = "frParent", constraintDate = ForignKeyConstraintData(parent, ReferencedData("scenarios","TestGroup"), false)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: TestGroup //////////////////////////////////////////////    
    val activeTestGroupTbl = TestGroupTbl.active    
    val captionGroupTestGroupTbl = TestGroupTbl.captionGroupOption    
    val codeGroupTestGroupTbl = TestGroupTbl.codeGroup    
    val descriptionGroupTestGroupTbl = TestGroupTbl.descriptionGroupOption    
    val idTestGroupTbl = TestGroupTbl.id    
    val parentTestGroupTbl = TestGroupTbl.parentOption    
    val statusTestGroupTbl = TestGroupTbl.statusOption    
///////////////////////////////////////////// End Table: TestGroup /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(TestGroupTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(TestGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(TestGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(TestGroupTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[TestGroup]] = 
        selectPIteratorRoot(columns = columns, from = From(TestGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS7(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], id: Long, parent: Array[Long], status: Array[Long]) => 
        TestGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, id = id, parent = parent, status = status)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[TestGroup]] = 
                selectListRoot(columns = allColumns, from = From(TestGroupTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS7(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], id: Long, parent: Array[Long], status: Array[Long]) => 
                        TestGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, id = id, parent = parent, status = status)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[TestGroup] = 
                selectOneRoot(columns = allColumns, from = From(TestGroupTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS7(active: Boolean, captionGroup: Array[String], codeGroup: String, descriptionGroup: Array[String], id: Long, parent: Array[Long], status: Array[Long])) => 
                ValidationEx(Success(TestGroup(active = active, captionGroup = captionGroup, codeGroup = codeGroup, descriptionGroup = descriptionGroup, id = id, parent = parent, status = status)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                TestGroupTbl.insertWithoutCommit(connection = connection, columns = activeTestGroupTbl ~ captionGroupTestGroupTbl ~ codeGroupTestGroupTbl ~ descriptionGroupTestGroupTbl ~ idTestGroupTbl ~ parentTestGroupTbl ~ statusTestGroupTbl, 
                    values map
                        {
                        value =>
                            Insert(activeTestGroupTbl, value _1) Insert(captionGroupTestGroupTbl, value _2) Insert(codeGroupTestGroupTbl, value _3) Insert(descriptionGroupTestGroupTbl, value _4) Insert(idTestGroupTbl, value _5) Insert(parentTestGroupTbl, value _6) Insert(statusTestGroupTbl, value _7)
                    })
        }    
    
     def insertP(values: TestGroup*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                TestGroupTbl.insertWithoutCommit(connection = connection, columns = activeTestGroupTbl ~ captionGroupTestGroupTbl ~ codeGroupTestGroupTbl ~ descriptionGroupTestGroupTbl ~ idTestGroupTbl ~ parentTestGroupTbl ~ statusTestGroupTbl, 
                    values map
                        {
                        value =>
                            Insert(activeTestGroupTbl, value.active) Insert(captionGroupTestGroupTbl, value.captionGroup) Insert(codeGroupTestGroupTbl, value.codeGroup) Insert(descriptionGroupTestGroupTbl, value.descriptionGroup) Insert(idTestGroupTbl, value.id) Insert(parentTestGroupTbl, value.parent) Insert(statusTestGroupTbl, value.status)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]]*): List[Int] = {
        TestGroupTbl.insertWithoutCommit(connection = connection, columns = activeTestGroupTbl ~ captionGroupTestGroupTbl ~ codeGroupTestGroupTbl ~ descriptionGroupTestGroupTbl ~ idTestGroupTbl ~ parentTestGroupTbl ~ statusTestGroupTbl, 
            values map
                {
                value =>
                    Insert(activeTestGroupTbl, value _1) Insert(captionGroupTestGroupTbl, value _2) Insert(codeGroupTestGroupTbl, value _3) Insert(descriptionGroupTestGroupTbl, value _4) Insert(idTestGroupTbl, value _5) Insert(parentTestGroupTbl, value _6) Insert(statusTestGroupTbl, value _7)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: TestGroup*): List[Int] = {
        TestGroupTbl.insertWithoutCommit(connection = connection, columns = activeTestGroupTbl ~ captionGroupTestGroupTbl ~ codeGroupTestGroupTbl ~ descriptionGroupTestGroupTbl ~ idTestGroupTbl ~ parentTestGroupTbl ~ statusTestGroupTbl, 
            values map
                {
                value =>
                    Insert(activeTestGroupTbl, value.active) Insert(captionGroupTestGroupTbl, value.captionGroup) Insert(codeGroupTestGroupTbl, value.codeGroup) Insert(descriptionGroupTestGroupTbl, value.descriptionGroup) Insert(idTestGroupTbl, value.id) Insert(parentTestGroupTbl, value.parent) Insert(statusTestGroupTbl, value.status)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(captionGroup, value _2) Set(codeGroup, value _3) Set(descriptionGroup, value _4) Set(id, value _5) Set(parent, value _6) Set(status, value _7), where = where, table = SQLTable(TestGroupTbl.databaseTablename))
        }    
    
     def updateP(value: TestGroup, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(captionGroup, value.captionGroup) Set(codeGroup, value.codeGroup) Set(descriptionGroup, value.descriptionGroup) Set(id, value.id) Set(parent, value.parent) Set(status, value.status), where = where, table = SQLTable(TestGroupTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS7[Boolean, Array[String], String, Array[String], Long, Array[Long], Array[Long]], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value _1) Set(captionGroup, value _2) Set(codeGroup, value _3) Set(descriptionGroup, value _4) Set(id, value _5) Set(parent, value _6) Set(status, value _7), where = where, table = SQLTable(TestGroupTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: TestGroup, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(active, value.active) Set(captionGroup, value.captionGroup) Set(codeGroup, value.codeGroup) Set(descriptionGroup, value.descriptionGroup) Set(id, value.id) Set(parent, value.parent) Set(status, value.status), where = where, table = SQLTable(TestGroupTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = TestGroupTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = TestGroupTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}