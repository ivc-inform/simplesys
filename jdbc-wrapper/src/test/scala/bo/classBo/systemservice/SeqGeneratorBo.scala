// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "GenBOs, stage: #819"

package ru.simplesys.defs.bo

package systemservice

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
import ru.simplesys.defs.bo.systemservice.table._
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



 
object SeqGeneratorBo {
     def apply(implicit dataSource: BoneCPDataSource) = new SeqGeneratorBo(alias = SQLAlias(strEmpty))    
     def apply(alias: SQLAlias)(implicit dataSource: BoneCPDataSource) = new SeqGeneratorBo(alias = alias)    
    
    val objectName = "SeqGenerator"    
    val groupName = "systemservice"
}


 
class SeqGeneratorBo(val alias: SQLAlias)(implicit val dataSource: BoneCPDataSource) extends ClassBO[SeqGeneratorBo]  {
//////////////////////////////////////// Class: SeqGenerator, group: systemservice ////////////////////////////////////////    
    
     def this()(implicit dataSource: BoneCPDataSource) = this(SQLAlias(strEmpty))(dataSource)    
    
     def init[FT <: Product with FieldProduct](columns: FT = null, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null): SeqGeneratorBo = {
        _columns = columns
        _join Join join
        _where Where where
        _orderBy OrderBy orderBy
        this
    }    
    
    val quoted = true    
///////////////////////////////////////////////// Tables /////////////////////////////////////////////////    
    override val tableCount = 1    
    val SeqGeneratorTbl = new SeqGeneratorTbl(alias = alias + "T0".als)    
    override val fromTable = SeqGeneratorTbl    
//////////////////////////////////////////////// End Tables ////////////////////////////////////////////////    
////////////////////////////////////////////// Columns for select //////////////////////////////////////////////    
    val maxValue = LongColumn(name = "NMAXVALUE", nameInBo = "maxValue", caption = "\u041F\u043E\u0441\u043B\u0435\u0434\u043D\u0435\u0435 \u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435", tableColumn = SeqGeneratorTbl.maxValue)    
    val nameSeq = StringColumn(name = "SNAMESEQ", nameInBo = "nameSeq", caption = "\u041A\u043E\u0434 \u043F\u043E\u0441\u043B\u0435\u0434\u043E\u0432\u0430\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u0438", tableColumn = SeqGeneratorTbl.nameSeq)    
    
    // For select tuple: (maxValue: Long, nameSeq: String)    
    
    type ColumnTypes =     TupleSS2[Long, String]    
    val allColumns = maxValue ~ nameSeq    
    val allColumns1 = Seq(maxValue , nameSeq)    
    val constraints = 
        Seq(PrimaryKey(name = "pk", constraintDate = KeyConstraintData(nameSeq)))    
///////////////////////////////////////////// End Columns for select /////////////////////////////////////////////    
    
////////////////////////////////////////// Columns for Insert/Update/Delete //////////////////////////////////////////    
////////////////////////////////////////////// Table: SeqGenerator //////////////////////////////////////////////    
    val maxValueSeqGeneratorTbl = SeqGeneratorTbl.maxValue    
    val nameSeqSeqGeneratorTbl = SeqGeneratorTbl.nameSeq    
///////////////////////////////////////////// End Table: SeqGenerator /////////////////////////////////////////////    
///////////////////////////////////////// End Columns for Insert/Update/Delete /////////////////////////////////////////    
    
     def preparedBO4Wrap(columns: List[BasicClassBOColumn[_]]): PreparedResult = 
        prepareSelect(join = _join, where = _where, orderBy = _orderBy, discriminator = null, from = From(SeqGeneratorTbl), columns = 
    _columns match {
        case null => allColumns.fields.toSet intersect columns.toSet
        case _ => _columns.fields.toSet intersect columns.toSet
    })    
///////////////////////////////////////////////// Fetch /////////////////////////////////////////////////    
     def selectList[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[FT#ReturnType]] = 
        selectListRoot(columns = columns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[FT#ReturnType]] = 
        selectIteratorRoot(columns = columns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)    
    
     def selectOne[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null): ValidationEx[FT#ReturnType] = 
        selectOneRoot(columns = columns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null)    
//////////////////////////////////////////////// End Fetch ////////////////////////////////////////////////    
    
/////////////////////////////////////////////// Fetch Product ///////////////////////////////////////////////    
    
     def selectPIterator[FT <: Product with FieldProduct](columns: FT = allColumns, join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationExIterator[Iterator[SeqGenerator]] = 
        selectPIteratorRoot(columns = columns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest)        {
    case TupleSS2(maxValue: Long, nameSeq: String) => 
        SeqGenerator(maxValue = maxValue, nameSeq = nameSeq)
}    
    
     def selectPList(join: JoinParam = null, where: WhereParam = null, orderBy: OrderByParam = null, fetchSize: Int = dataSource.Config.FetchSize, dsRequest: DSRequest = null): ValidationEx[List[SeqGenerator]] = 
                selectListRoot(columns = allColumns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null, orderBy = orderBy, fetchSize = fetchSize, dsRequest = dsRequest).result match {
            case Success(list) => 
                ValidationEx(Success(list map {
                    case TupleSS2(maxValue: Long, nameSeq: String) => 
                        SeqGenerator(maxValue = maxValue, nameSeq = nameSeq)
                }))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
    
     def selectPOne(join: JoinParam = null, where: WhereParam = null): ValidationEx[SeqGenerator] = 
                selectOneRoot(columns = allColumns, from = From(SeqGeneratorTbl), join = join, where = where, discriminator = null).result match {
            case Success(TupleSS2(maxValue: Long, nameSeq: String)) => 
                ValidationEx(Success(SeqGenerator(maxValue = maxValue, nameSeq = nameSeq)))
            case Failure(x) => 
                ValidationEx(Failure(x))
            case x => 
                throw new RuntimeException(s"Bad branch. (${x})")
        }    
////////////////////////////////////////////// End Fetch Product //////////////////////////////////////////////    
    
///////////////////////////////////////////////// Insert /////////////////////////////////////////////////    
    
     def insert(values: TupleSS2[Long, String]*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                SeqGeneratorTbl.insertWithoutCommit(connection = connection, columns = maxValueSeqGeneratorTbl ~ nameSeqSeqGeneratorTbl, 
                    values map
                        {
                        value =>
                            Insert(maxValueSeqGeneratorTbl, value _1) Insert(nameSeqSeqGeneratorTbl, value _2)
                    })
        }    
    
     def insertP(values: SeqGenerator*): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                SeqGeneratorTbl.insertWithoutCommit(connection = connection, columns = maxValueSeqGeneratorTbl ~ nameSeqSeqGeneratorTbl, 
                    values map
                        {
                        value =>
                            Insert(maxValueSeqGeneratorTbl, value.maxValue) Insert(nameSeqSeqGeneratorTbl, value.nameSeq)
                    })
        }    
    
     def insertWithoutCommit(connection: Connection, values: TupleSS2[Long, String]*): List[Int] = {
        SeqGeneratorTbl.insertWithoutCommit(connection = connection, columns = maxValueSeqGeneratorTbl ~ nameSeqSeqGeneratorTbl, 
            values map
                {
                value =>
                    Insert(maxValueSeqGeneratorTbl, value _1) Insert(nameSeqSeqGeneratorTbl, value _2)
            })
    }    
    
     def insertPWithoutCommit(connection: Connection, values: SeqGenerator*): List[Int] = {
        SeqGeneratorTbl.insertWithoutCommit(connection = connection, columns = maxValueSeqGeneratorTbl ~ nameSeqSeqGeneratorTbl, 
            values map
                {
                value =>
                    Insert(maxValueSeqGeneratorTbl, value.maxValue) Insert(nameSeqSeqGeneratorTbl, value.nameSeq)
            })
    }    
//////////////////////////////////////////////// End Insert ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Update /////////////////////////////////////////////////    
     def update(value: TupleSS2[Long, String], where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(maxValue, value _1) Set(nameSeq, value _2), where = where, table = SQLTable(SeqGeneratorTbl.databaseTablename))
        }    
    
     def updateP(value: SeqGenerator, where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                updateWithoutCommit(connection = connection, setters = Set(maxValue, value.maxValue) Set(nameSeq, value.nameSeq), where = where, table = SQLTable(SeqGeneratorTbl.databaseTablename))
        }    
    
     def updateWithoutCommit(connection: Connection, value: TupleSS2[Long, String], where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(maxValue, value _1) Set(nameSeq, value _2), where = where, table = SQLTable(SeqGeneratorTbl.databaseTablename))
    }    
    
     def updatePWithoutCommit(connection: Connection, value: SeqGenerator, where: WhereParam): List[Int] = {
        updateWithoutCommit(connection = connection, setters = Set(maxValue, value.maxValue) Set(nameSeq, value.nameSeq), where = where, table = SQLTable(SeqGeneratorTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Update ////////////////////////////////////////////////    
    
///////////////////////////////////////////////// Delete /////////////////////////////////////////////////    
     def delete(where: WhereParam): ValidationEx[List[Int]] = 
        transaction(dataSource)
            {
            connection =>
                deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = SeqGeneratorTbl.databaseTablename))
        }    
    
     def deleteWithoutCommit(connection: Connection, where: WhereParam): List[Int] = {
        deleteWithoutCommit(connection = connection, where = where, table = SQLTable(name = SeqGeneratorTbl.databaseTablename))
    }    
//////////////////////////////////////////////// End Delete ////////////////////////////////////////////////
}