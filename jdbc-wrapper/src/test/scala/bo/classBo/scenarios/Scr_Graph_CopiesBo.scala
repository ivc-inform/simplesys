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



 
object Scr_Graph_CopiesBo {
     def apply(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new Scr_Graph_CopiesBo(alias = alias)    
    
    val objectName = "Scr_Graph_Copies"    
    val groupName = "scenarios"
}


 
class Scr_Graph_CopiesBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[Scr_Graph_CopiesBo]  {
//////////////////////////////////////// Class: Scr_Graph_Copies, group: scenarios ////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): Scr_Graph_CopiesBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val Scr_Graph_CopiesTbl = new Scr_Graph_CopiesTbl(alias = alias + "T0".als)    
    override val fromTable = Scr_Graph_CopiesTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val description_copy = StringOptionColumn(name = "SDESCRIPTION_COPY", nameInBo = "description_copy", caption = "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435", tableColumn = Scr_Graph_CopiesTbl.description_copyOption)    
    val id = LongColumn(name = "ID", nameInBo = "id", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440", tableColumn = Scr_Graph_CopiesTbl.id)    
    val id_scenario_ref = LongColumn(name = "IDID_SCENARIO_REF", nameInBo = "id_scenario_ref", caption = "\u0418\u0434\u0435\u043D\u0442\u0438\u0444\u0438\u043A\u0430\u0442\u043E\u0440 \u0441\u0446\u0435\u043D\u0430\u0440\u0438\u044F", tableColumn = Scr_Graph_CopiesTbl.id_scenario_ref)    
    val version = LocalDateTimeColumn(name = "DTVERSION", nameInBo = "version", caption = "\u0412\u0435\u0440\u0441\u0438\u044F", tableColumn = Scr_Graph_CopiesTbl.version)    
    
    // For select tuple: (description_copy: Array[String], id: Long, id_scenario_ref: Long, version: LocalDateTime)    
    
    type ColumnTypes =     TupleSS4[Array[String], Long, Long, LocalDateTime]    
    val allColumns = description_copy ~ id ~ id_scenario_ref ~ version    
    val allColumns1 = Seq(description_copy , id , id_scenario_ref , version)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(id),KeyConstraintData(id_scenario_ref)),
            ForignKey(name = "frId_scenario_ref", constraintDate = ForignKeyConstraintData(id_scenario_ref, ReferencedData("scenarios","Scr_Scenario"), true)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
///////////////////////////////////////////// Table: Scr_Graph_Copies /////////////////////////////////////////////    
    val description_copyScr_Graph_CopiesTbl = Scr_Graph_CopiesTbl.description_copyOption    
    val idScr_Graph_CopiesTbl = Scr_Graph_CopiesTbl.id    
    val id_scenario_refScr_Graph_CopiesTbl = Scr_Graph_CopiesTbl.id_scenario_ref    
    val versionScr_Graph_CopiesTbl = Scr_Graph_CopiesTbl.version    
//////////////////////////////////////////// End Table: Scr_Graph_Copies ////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(Scr_Graph_CopiesTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[Scr_Graph_Copies]] = 
        selectPIteratorRoot(columns = columns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS4(description_copy: Array[String], id: Long, id_scenario_ref: Long, version: LocalDateTime) => 
        Scr_Graph_Copies(description_copy = description_copy, id = id, id_scenario_ref = id_scenario_ref, version = version)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[Scr_Graph_Copies]] = 
                selectListRoot(columns = allColumns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS4(description_copy: Array[String], id: Long, id_scenario_ref: Long, version: LocalDateTime) => 
                        Scr_Graph_Copies(description_copy = description_copy, id = id, id_scenario_ref = id_scenario_ref, version = version)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[Scr_Graph_Copies] = 
                selectOneRoot(columns = allColumns, from = From(Scr_Graph_CopiesTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS4(description_copy: Array[String], id: Long, id_scenario_ref: Long, version: LocalDateTime)) => 
                ValidationEx(Success(Scr_Graph_Copies(description_copy = description_copy, id = id, id_scenario_ref = id_scenario_ref, version = version)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_Graph_CopiesTbl.insertWithoutCommit(connection = connection, columns = description_copyScr_Graph_CopiesTbl ~ idScr_Graph_CopiesTbl ~ id_scenario_refScr_Graph_CopiesTbl ~ versionScr_Graph_CopiesTbl, 
                    values map
                        {
                        value =>
                            Insert(description_copyScr_Graph_CopiesTbl, value _1) Insert(idScr_Graph_CopiesTbl, value _2) Insert(id_scenario_refScr_Graph_CopiesTbl, value _3) Insert(versionScr_Graph_CopiesTbl, value _4)
                    })
        }    
    
     def insertP(values: Scr_Graph_Copies*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                Scr_Graph_CopiesTbl.insertWithoutCommit(connection = connection, columns = description_copyScr_Graph_CopiesTbl ~ idScr_Graph_CopiesTbl ~ id_scenario_refScr_Graph_CopiesTbl ~ versionScr_Graph_CopiesTbl, 
                    values map
                        {
                        value =>
                            Insert(description_copyScr_Graph_CopiesTbl, value.description_copy) Insert(idScr_Graph_CopiesTbl, value.id) Insert(id_scenario_refScr_Graph_CopiesTbl, value.id_scenario_ref) Insert(versionScr_Graph_CopiesTbl, value.version)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS4[Array[String], Long, Long, LocalDateTime]*): List[Int] = {
        Scr_Graph_CopiesTbl.insertWithoutCommit(connection = connection, columns = description_copyScr_Graph_CopiesTbl ~ idScr_Graph_CopiesTbl ~ id_scenario_refScr_Graph_CopiesTbl ~ versionScr_Graph_CopiesTbl, 
            values map
                {
                value =>
                    Insert(description_copyScr_Graph_CopiesTbl, value _1) Insert(idScr_Graph_CopiesTbl, value _2) Insert(id_scenario_refScr_Graph_CopiesTbl, value _3) Insert(versionScr_Graph_CopiesTbl, value _4)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: Scr_Graph_Copies*): List[Int] = {
        Scr_Graph_CopiesTbl.insertWithoutCommit(connection = connection, columns = description_copyScr_Graph_CopiesTbl ~ idScr_Graph_CopiesTbl ~ id_scenario_refScr_Graph_CopiesTbl ~ versionScr_Graph_CopiesTbl, 
            values map
                {
                value =>
                    Insert(description_copyScr_Graph_CopiesTbl, value.description_copy) Insert(idScr_Graph_CopiesTbl, value.id) Insert(id_scenario_refScr_Graph_CopiesTbl, value.id_scenario_ref) Insert(versionScr_Graph_CopiesTbl, value.version)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS4[Array[String], Long, Long, LocalDateTime], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(description_copy, value _1) Set(id, value _2) Set(id_scenario_ref, value _3) Set(version, value _4), where = where, table = SQLTable(Scr_Graph_CopiesTbl.databaseTablename))
        }    
    
     def updateP(value: Scr_Graph_Copies, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(description_copy, value.description_copy) Set(id, value.id) Set(id_scenario_ref, value.id_scenario_ref) Set(version, value.version), where = where, table = SQLTable(Scr_Graph_CopiesTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS4[Array[String], Long, Long, LocalDateTime], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(description_copy, value _1) Set(id, value _2) Set(id_scenario_ref, value _3) Set(version, value _4), where = where, table = SQLTable(Scr_Graph_CopiesTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: Scr_Graph_Copies, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(description_copy, value.description_copy) Set(id, value.id) Set(id_scenario_ref, value.id_scenario_ref) Set(version, value.version), where = where, table = SQLTable(Scr_Graph_CopiesTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_Graph_CopiesTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = Scr_Graph_CopiesTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}