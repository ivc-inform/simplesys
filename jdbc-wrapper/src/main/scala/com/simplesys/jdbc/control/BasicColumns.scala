package com.simplesys.jdbc.control

import java.sql.{PreparedStatement, ResultSet}
import ru.simplesys.meta.types.DBDataType
import com.simplesys.SQL.Gen.{SQLTable, SQLField}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.common.Strings._
import com.simplesys.SQL._
import com.simplesys.log.Logging

trait BasicTableColumn[T] extends Logging {
    var alias: String = strEmpty
    def isPrimaryKey: Boolean
    def default: T
    def name: String
    def get(resultSet: ResultSet): T
    def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: T): Unit
    def getDBDataType: DBDataType
    def entity: Entity[_]
    def getName = if (alias.isEmpty) name else alias
    def As(alias: String) = {
        this.alias = alias
        this
    }

    def getTableOwner = if (entity.alias.isEmpty) SQLTable(strEmpty) else SQLTable(name = entity.alias.name, quoted = false)
    def getColumn: SQLField = SQLField(name = name,  originalName = name, quoted = entity.quoted, alias = alias.als, tableOwner = getTableOwner)
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "BasicTableColumn")
        entity.log(indent + indentSize)
        logger trace spaces(indent) + s"alias: ${alias}, name: ${name}, getName: ${getName}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End BasicTableColumn")
    }

    def ===[PT /*<% T*/ ](value: PT) = Tuple3(this, opIdEquals, value)
    def !==[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdNotEqual, value)
    def >[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdGreaterThan, value)
    def >=[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdGreaterOrEqual, value)
    def <[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdLessThan, value)
    def <=[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdLessOrEqual, value)

    def In[PT <: Iterable[_]](value: PT) = Tuple3(this, opIdInSet, value)
    def NotIn[PT <: Iterable[_]](value: PT) = Tuple3(this, opIdNotInSet, value)
}

trait BasicClassBOColumn[T] extends Logging {
    var alias: String = ""
    def default: T
    def name: String
    def nameInBo: String
    def getName = if (alias.isEmpty) name else alias
    def tableColumn: BasicTableColumn[_]
    def entity: Entity[_]
    def get(resultSet: ResultSet): T
    def set(preparedStatement: PreparedStatement, parameterIndex: Int, value: T): Unit
    def getDBDataType: DBDataType
    def As(alias: String): BasicClassBOColumn[T] = {
        this.alias = alias
        this
    }

    def getTableOwner: SQLTable = if (tableColumn.entity.alias.isEmpty) SQLTable(strEmpty) else SQLTable(name = tableColumn.entity.alias.name, quoted = tableColumn.entity.alias.isEmpty)
    def getColumn: SQLField = SQLField(name = name,originalName = name, nameInBo = nameInBo, quoted = entity.quoted, alias = alias.als, tableOwner = getTableOwner)
    def getColumn1: SQLField = SQLField(name = getName,originalName = getName, nameInBo = nameInBo, quoted = alias.isEmpty, tableOwner = getTableOwner)
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "BasicClassBOColumn")
        tableColumn.log(indent + indentSize)
        entity.log(indent + indentSize)
        logger trace spaces(indent) + s"name: ${name}, nameInBo: ${nameInBo}, getName = ${getName}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End BasicClassBOColumn")
    }

    def ===[PT /*<% T*/ ](value: PT) = Tuple3(this, opIdEquals, value)
    def !==[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdNotEqual, value)
    def >[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdGreaterThan, value)
    def >=[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdGreaterOrEqual, value)
    def <[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdLessThan, value)
    def <=[PT /* <% T*/ ](value: PT) = Tuple3(this, opIdLessOrEqual, value)

    def In[PT <: Iterable[_]](value: PT) = Tuple3(this, opIdInSet, value)
    def NotIn[PT <: Iterable[_]](value: PT) = Tuple3(this, opIdNotInSet, value)
}

