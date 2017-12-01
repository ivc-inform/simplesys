package com.simplesys.SQL.Gen

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.SQL._
import com.simplesys.isc.system.typesDyn._
import scala.collection.mutable.ArrayBuffer
import com.simplesys.log.Logging
import scala.annotation.tailrec
import scala.reflect.ClassTag
import com.simplesys.common.array.NotValue

sealed abstract class SQLElement extends Logging {
    def toSQL(indent: Int = 0): String
    def toSQLWithOutLikeAttribute(indent: Int = 0): String = toSQL(indent).replace("'%'||", "").replace("||'%'", "").trim
    def toInsertSQL(indent: Int = 0): String
    def toUpdateSQL(indent: Int = 0): String
    def toDeleteSQL(indent: Int = 0): String
    def getBaseAliasTable = strEmpty
    def log = logger trace newLine + toSQL()
    def log(comment: SQLComment) = {
        if (comment.nonEmpty)
            logger trace newLine + fill(100, "-", comment.comment)
        logger trace newLine + toSQL()
        if (comment.nonEmpty)
            logger trace newLine + fill(100, "-", "End".space + comment.comment)
    }
}

case class SQLTable(name: String, quoted: Boolean = true) extends SQLAbsTable {

    override def toSQL(indent: Int): String = spaces(indent) + (if (quoted) {
        import com.simplesys.common.JVM.Strings._
        name.toHeightFont.dblQuoted
    } else name.toHeightFont)
    override def toInsertSQL(indent: Int): String = spaces(indent) + (if (quoted) {
        import com.simplesys.common.JVM.Strings._
        name.toHeightFont.dblQuoted
    } else name.toHeightFont)
    override def toUpdateSQL(indent: Int): String = spaces(indent) + (if (quoted) {
        import com.simplesys.common.JVM.Strings._
        name.toHeightFont.dblQuoted
    } else name.toHeightFont)
    override def toDeleteSQL(indent: Int): String = spaces(indent) + (if (quoted) {
        import com.simplesys.common.JVM.Strings._
        name.toHeightFont.dblQuoted
    } else name.toHeightFont)

    def isEmpty = name.isEmpty
    def nonEmpty = !isEmpty
}

case class SQLAlias(name: String) extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + name.toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + name.toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + name.toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + name.toHeightFont

    def isEmpty: Boolean = name.isEmpty
    def nonEmpty: Boolean = !name.isEmpty
    def +(ev: SQLAlias): SQLAlias = SQLAlias(if (name.nonEmpty) name + "_" + ev.name else ev.name)
    def +(ev: String): SQLAlias = SQLAlias(if (name.nonEmpty) name + "_" + ev else ev)
}

case object NullSQLElement extends SQLElement {
    override def toSQL(indent: Int): String = strEmpty
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case class SQLField(name: String,
                    originalName: String = strEmpty,
                    nameInBo: String = strEmpty,
                    quoted: Boolean = true,
                    comment: String = strEmpty,
                    alias: SQLAlias = SQLAlias(strEmpty),
                    isSystem: Boolean = false,
                    isMantadory: Boolean = false,
                    sqlDataType: Int = -1,
                    tableOwner: SQLTable = SQLTable(strEmpty)
                     ) extends SQLElement {

    def getAliasField: String = if (alias.isEmpty) strEmpty else space + SQLAsClause.toSQL() + space + alias.name
    def getName = name.replace("-", strEmpty)
    def getAliasedName = if (alias.nonEmpty) alias.toSQL() else getName

    def toSQL(indent: Int): String = {
        if (quoted)
            (if (isSystem) strEmpty else (if (tableOwner.name.isEmpty) getBaseAliasTable else tableOwner.toSQL() + ".")) + {
                import com.simplesys.common.JVM.Strings._
                getName.toHeightFont.dblQuoted
            } + getAliasField
        else
            (if (isSystem) strEmpty else (if (tableOwner.name.isEmpty) getBaseAliasTable else tableOwner.toSQL() + ".")) + getName.toHeightFont + getAliasField
    }

    override def toInsertSQL(indent: Int): String = {
        if (quoted)
            (if (isSystem) strEmpty else {
                import com.simplesys.common.JVM.Strings._
                name.toHeightFont.dblQuoted
            })
        else
            (if (isSystem) strEmpty else name.toHeightFont)
    }

    override def toUpdateSQL(indent: Int): String = {
        if (quoted)
            (if (isSystem) strEmpty else {
                import com.simplesys.common.JVM.Strings._
                name.toHeightFont.dblQuoted
            })
        else
            (if (isSystem) strEmpty else name)
    }

    override def toDeleteSQL(indent: Int): String = {
        if (quoted)
            (if (isSystem) strEmpty else {
                import com.simplesys.common.JVM.Strings._
                name.toHeightFont.dblQuoted
            })
        else
            (if (isSystem) strEmpty else name.toHeightFont)
    }
}

object SQLFields {
    def apply1(fields: SQLField*): SQLFields = new SQLFields(fields)

    def apply[T: ClassTag](fields: Seq[Array[SQLField]]): SQLFields = {
        val res = new SQLFields()
        fields foreach {
            _ match {
                case Array(field) =>
                    res += field
                case _ =>
            }
        }
        res
    }
}

case class SQLFields(fields: Seq[SQLField] = Seq.empty[SQLField]) extends SQLElement {
    def intersect(fields1: SQLFields): SQLFields =
        SQLFields((fields.toSet intersect fields1.getFields.toSet).toSeq)

    private val _fields = ArrayBuffer(fields.distinct: _*)

    def +=(field: SQLField) {
        _fields += field
    }

    def getFields = _fields.clone()

    def +(field: SQLField): SQLFields = SQLFields(_fields += field)

    def ++(fields: SQLField*): SQLFields = SQLFields(_fields ++= fields)

    def ++=(fields: SQLField*) {
        _fields ++= fields
    }

    def length = _fields.length

    def getField(index: Int): SQLField = _fields(index)

    def getIndexOfField(field: SQLField): Int = {
        val _field = _fields.filter(_.name == field.name).headOption

        _field match {
            case None => -1
            case Some(field) => _fields indexOf field
        }
    }

    def sqlFieldsWithoutTableOwner: SQLFields = SQLFields(_fields.map(_.copy(tableOwner = SQLTable(name = strEmpty))))

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Поправлено 03/07/2014 не учитывала алиасы колонок
    //def sqlFieldsWithTableOwner(tableOwner: SQLTable): SQLFields = SQLFields(_fields.map(_.copy(tableOwner = tableOwner.copy(quoted = false))))

    def sqlFieldsWithTableOwner(tableOwner: SQLTable): SQLFields = SQLFields(_fields.map(field => field.copy(tableOwner = tableOwner.copy(quoted = false), name = if (field.alias.nonEmpty) field.alias.name else field.name, alias = SQLAlias(strEmpty))))
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    def getFieldInBase(nameInBo: String): SQLField = _fields.filter(_.nameInBo === {
        import com.simplesys.common.JVM.Strings._
        nameInBo.unQuoted
    }).head

    override def toSQL(indent: Int): String = (_fields map (_ toSQL indent)).sortWith(_ < _).mkString(",".newLine + spaces(indent))
    override def toInsertSQL(indent: Int): String = (_fields map (_ toInsertSQL indent)).mkString(",".space)
    override def toUpdateSQL(indent: Int): String = (_fields.filter(!_.toUpdateSQL().isEmpty).map(_.toUpdateSQL(indent) + space + "= ?".space)).mkString(",".newLine + spaces(indent + indentSize))
    override def toDeleteSQL(indent: Int): String = (_fields.filter(!_.toUpdateSQL().isEmpty).map(_.toDeleteSQL(indent) + space + "= ?".space)).mkString(",".newLine + spaces(indent + indentSize))
    def insertValues(indent: Int = 0): String = (_fields map (_ => "?")).mkString("(", ",".space, ")")
}

case class SQLGroupBy(fields: SQLField*) extends SQLElement {
    private val _fields = ArrayBuffer[SQLField](fields: _*)

    def getFields = _fields

    def +=(field: SQLField) {
        _fields += field
    }

    def ++=(fields: Seq[SQLField]) {
        _fields ++= fields
    }

    override def toSQL(indent: Int): String = {
        val _indent = SQLGroupByClause.toSQL(indent).length + 1

        if (_fields.length === 0)
            strEmpty
        else
            SQLGroupByClause.toSQL(indent).space + (SQLFields(_fields).sqlFieldsWithoutTableOwner.getFields map (_ toSQL _indent)).mkString(",".newLine + spaces(_indent))
    }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case object SQLFromClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "FROM".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "FROM".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "FROM".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "FROM".toHeightFont
}

case object SQLGroupByClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "GROUP BY".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "GROUP BY".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "GROUP BY".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "GROUP BY".toHeightFont
}

case object SQLSelectClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "SELECT".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "SELECT".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "SELECT".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "SELECT".toHeightFont
}

case object SQLInsertClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "INSERT INTO".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "INSERT INTO".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "INSERT INTO".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "INSERT INTO".toHeightFont
}

case object SQLUpdateClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "UPDATE".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "UPDATE".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "UPDATE".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "UPDATE".toHeightFont
}

case object SQLSetClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "SET".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "SET".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "SET".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "SET".toHeightFont
}

case object SQLDeleteClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "DELETE".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "DELETE".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "DELETE".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "DELETE".toHeightFont
}

case object SQLValuesClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "VALUES".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "VALUES".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "VALUES".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "VALUES".toHeightFont
}

case object SQLAsClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "AS".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "AS".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "AS".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "AS".toHeightFont
}

case object SQLAndClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "AND".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "AND".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "AND".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "AND".toHeightFont
}

case object SQLOrClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "OR".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "OR".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "OR".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "OR".toHeightFont
}

case object SQLOrderByClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "ORDER BY".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "ORDER BY".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "ORDER BY".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "ORDER BY".toHeightFont
}

case object SQLWhereClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "WHERE".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "WHERE".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "WHERE".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "WHERE".toHeightFont
}

case object SQLDescClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "DESC".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "DESC".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "DESC".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "DESC".toHeightFont
}

sealed abstract class DirOrderBy extends SQLElement

case object AscOrderBy extends DirOrderBy {
    override def toSQL(indent: Int): String = strEmpty
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case object DescOrderBy extends DirOrderBy {
    override def toSQL(indent: Int): String = space + SQLDescClause.toSQL()
    override def toInsertSQL(indent: Int): String = space + SQLDescClause.toSQL()
    override def toUpdateSQL(indent: Int): String = space + SQLDescClause.toSQL()
    override def toDeleteSQL(indent: Int): String = space + SQLDescClause.toSQL()
}

sealed abstract class SQLAbsOrderBy extends SQLElement

case object SQLNullOrderBy extends SQLAbsOrderBy {
    override def toSQL(indent: Int): String = strEmpty
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case class SQLOrderBy(field: SQLField, dir: DirOrderBy = AscOrderBy) extends SQLAbsOrderBy {
    override def toSQL(indent: Int): String = field.toSQL(indent) + dir.toSQL()
    override def toInsertSQL(indent: Int): String = field.toSQL(indent) + dir.toSQL()
    override def toUpdateSQL(indent: Int): String = field.toSQL(indent) + dir.toSQL()
    override def toDeleteSQL(indent: Int): String = field.toSQL(indent) + dir.toSQL()
}

case class SQLOrdersBy(fields: SQLAbsOrderBy*) extends SQLElement {
    private val _fields = ArrayBuffer[SQLAbsOrderBy](fields: _*)

    def +=(field: SQLAbsOrderBy) {
        _fields += field
    }

    def getFields = _fields.filter(_ !== SQLNullOrderBy)

    /*def ++=(fields: SQLAbsOrderBy*) {
        _fields ++= fields
    }*/

    def ++=(fields: Seq[SQLAbsOrderBy]) {
        _fields ++= fields
    }

    override def toSQL(indent: Int): String = {
        val _indent = indent + SQLOrderByClause.toSQL().length + 1
        val res = (_fields.toSet.filter(_ !== SQLNullOrderBy).map(_ toSQL indent)).mkString(",".newLine + spaces(_indent))

        if (_fields.filter(_ !== SQLNullOrderBy).length === 0)
            strEmpty
        else
            newLine + SQLOrderByClause.toSQL(indent).space + /*newLine + spaces(_indent) +*/ res
    }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

sealed abstract class SQLAbsValue extends SQLElement

case object SQLEmptyValue extends SQLAbsValue {
    override def toSQL(indent: Int): String = strEmpty
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

object SQLValue {
    def apply(value: Int) = new SQLValue(value.toString)
    def apply(value: Double) = new SQLValue(value.toString)
    def apply(value: BigDecimal) = new SQLValue(value.toString)
}

case class SQLValue(value: String) extends SQLAbsValue {
    override def toSQL(indent: Int): String = value
    override def toInsertSQL(indent: Int): String = value
    override def toUpdateSQL(indent: Int): String = value
    override def toDeleteSQL(indent: Int): String = value
}

/*object SQLValues {
    def apply(values: Seq[SQLAbsValue]) = new SQLValues(values:_*)
}*/

case class SQLValues(values: SQLAbsValue*) extends SQLAbsValue {
    override def toSQL(indent: Int): String = {
        if (values.length === 1)
            spaces(indent) + values.map(_.toSQLWithOutLikeAttribute()).mkString(space)
        else
            spaces(indent) + values.map(_.toSQLWithOutLikeAttribute()).mkString("(", ",".space, ")")
    }

    def lenght = values.length

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case object SQLValuePlaceHolder extends SQLAbsValue {
    override def toSQL(indent: Int): String = "?"
    override def toInsertSQL(indent: Int): String = "?"
    override def toUpdateSQL(indent: Int): String = "?"
    override def toDeleteSQL(indent: Int): String = "?"
}

sealed abstract class SQLAbsWhereItem extends SQLElement {
    def length: Int
}

case object SQLNullWhereItem extends SQLAbsWhereItem {
    override def toSQL(indent: Int): String = strEmpty
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
    override def length: Int = 0
}

case class SQLWhereItemClause(operator: OperatorId) extends SQLAbsWhereItem {
    override def toSQL(indent: Int): String = spaces(indent) + operator.toSQL
    override def toInsertSQL(indent: Int): String = spaces(indent) + operator.toSQL
    override def toUpdateSQL(indent: Int): String = spaces(indent) + operator.toSQL
    override def toDeleteSQL(indent: Int): String = spaces(indent) + operator.toSQL
    override def length: Int = 1
}

case class SQLWhereItems(whereItems: SQLAbsWhereItem*) extends SQLAbsWhereItem {
    private val _whereItems = ArrayBuffer(whereItems.filter(_.length > 0): _*)

    //def lengthDeep: Int = _whereItems.filter(_.length > 0).map(_.length).foldLeft(0)(_ + _)
    override def length: Int = _whereItems.filter(_.length > 0).length

    override def toSQL(indent: Int): String =
        if (length === 0)
            strEmpty
        else {
            val leftBrace: String = if (length > 1) spaces(indent) + "(" + newLine else strEmpty
            val rightBrace: String = if (length > 1) newLine + spaces(indent) + ")" else strEmpty

            leftBrace + (_whereItems map {
                case x: SQLWhereItem => x.toSQL(if (x.length === 1) indent /*+ indentSize*/ else indent + indentSize)
                case x: SQLWhereItems => x.toSQL(if (x.length === 1) indent else indent + indentSize * 2)
                case x => x.toSQL(indent + indentSize)
            }).mkString(newLine) + rightBrace
        }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty

    def +=(whereItem: SQLAbsWhereItem) {
        if (whereItem.length > 0)
            _whereItems += whereItem
    }

    def ++=(whereItems: Seq[SQLAbsWhereItem]) {
        _whereItems ++= whereItems.filter(_.length > 0)
    }

    def toSeq = _whereItems.toSeq
}

object SQLWhereItem {
    def apply(whereItems: SQLWhereItems) = new SQLWhereItem(SQLField(strEmpty), opIdNull, SQLEmptyValue, SQLField(strEmpty), whereItems)
    def apply(whereItem: SQLAbsWhereItem) = new SQLWhereItem(SQLField(strEmpty), opIdNull, SQLEmptyValue, SQLField(strEmpty), SQLWhereItems(whereItem))

    def apply() = new SQLWhereItem(SQLField(strEmpty), opIdNull, SQLEmptyValue, SQLField(strEmpty))
    def apply(field: SQLField, operator: OperatorId, value: SQLAbsValue) = new SQLWhereItem(field, operator, value, SQLField(strEmpty))
    def apply(fieldLeft: SQLField, operator: OperatorId, fieldRight: SQLField) = new SQLWhereItem(fieldLeft, operator, SQLEmptyValue, fieldRight)
}

case class SQLWhereItem(fieldLeft: SQLField, operator: OperatorId, value: SQLAbsValue, fieldRight: SQLField, whereItems: SQLWhereItems = SQLWhereItems()) extends SQLAbsWhereItem {
    private def selfLength: Int = (if (fieldLeft.name.isEmpty) 0 else 1)
    override def length: Int = (if (fieldLeft.name.isEmpty) 0 else 1) + whereItems.length

    override def toSQL(indent: Int): String =
        (if (selfLength === 0)
            strEmpty
        else
            spaces(indent + indentSize) + "(" + operator.getColumn(fieldLeft.toSQL()) + space + operator.toSQL + {
                val res = value.toSQL()
                if (res.isEmpty)
                    strEmpty
                else
                    space + res
            } + ")") + whereItems.toSQL(indent)

    override def toInsertSQL(indent: Int): String = strEmpty

    override def toUpdateSQL(indent: Int): String = (if (selfLength === 0)
        strEmpty
    else
        spaces(indent + indentSize) + "(" + operator.getColumn(fieldLeft.toUpdateSQL()) + space + operator.toSQL + {
            val res = value.toUpdateSQL()
            if (res.isEmpty)
                strEmpty
            else
                space + res
        } + ")") + whereItems.toUpdateSQL(indent)

    override def toDeleteSQL(indent: Int): String = (if (selfLength === 0)
        strEmpty
    else
        spaces(indent + indentSize) + "(" + operator.getColumn(fieldLeft.toDeleteSQL()) + space + operator.toSQL + {
            val res = value.toDeleteSQL()
            if (res.isEmpty)
                strEmpty
            else
                space + res
        } + ")") + whereItems.toDeleteSQL(indent)
}

case class SQLWhereBetweenItem(field: SQLField, operator: OperatorId, start: SQLAbsValue, end: SQLAbsValue) extends SQLAbsWhereItem {
    override def length: Int = 1
    override def toSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + start.toSQL() + space + SQLAndClause.toSQL().space + end.toSQL() + ")"
    override def toInsertSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + start.toSQL() + space + SQLAndClause.toSQL().space + end.toSQL() + ")"
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + start.toSQL() + space + SQLAndClause.toSQL().space + end.toSQL() + ")"
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + start.toSQL() + space + SQLAndClause.toSQL().space + end.toSQL() + ")"
}

case class SQLWhereInItem(field: SQLField, operator: OperatorId, values: SQLValues) extends SQLAbsWhereItem {
    override def length: Int = values.lenght
    override def toSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + values.toSQL() + ")"
    override def toInsertSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + values.toSQL() + ")"
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + values.toSQL() + ")"
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "(" + operator.getColumn(field.toSQL()) + space + operator.toSQL + space + values.toSQL() + ")"
}

case class SQLWhere(whereItems: SQLAbsWhereItem*) extends SQLAbsWhereItem {
    private val _whereItems = ArrayBuffer(whereItems.filter(_.length > 0): _*)

    def +=(whereItem: SQLAbsWhereItem) {
        if (whereItem.length > 0)
            _whereItems += whereItem
    }

    def getWhereItems = _whereItems.filter(_.length > 0)

    def ++=(whereItems: Seq[SQLAbsWhereItem]) {
        _whereItems ++= whereItems.filter(_.length > 0)
    }

    override def length = _whereItems. /*filter(_.length > 0).*/ map(_.length).foldLeft(0)(_ + _)

    override def toSQL(indent: Int): String = {
        if (length === 0)
            strEmpty
        else {
            val _indent = SQLWhereClause.toSQL().length + 1 //- indentSize
            if (_whereItems.filter({
                case x: SQLWhereItems => true
                case x => false
            }).length > 0 || _whereItems.length > 1)
                newLine + spaces(indent) + SQLWhereClause.toSQL() + space + "(" + newLine + _whereItems.map(_.toSQL(indent + _indent)).mkString(newLine) + newLine + spaces(indent + SQLWhereClause.toSQL().length + 1) + ")"
            else
                newLine + spaces(indent) + SQLWhereClause.toSQL() + space + _whereItems.map(_.toSQL()).mkString(newLine).trim

        }
    }


    override def toInsertSQL(indent: Int): String = strEmpty

    override def toUpdateSQL(indent: Int): String = {
        if (length === 0)
            strEmpty
        else {
            val _indent = SQLWhereClause.toUpdateSQL().length + 1 //- indentSize
            if (_whereItems.filter({
                case x: SQLWhereItems => true
                case x => false
            }).length > 0 || _whereItems.length > 1)
                newLine + spaces(indent) + SQLWhereClause.toUpdateSQL() + space + "(" + newLine + _whereItems.map(_.toDeleteSQL(indent + _indent)).mkString(newLine) + newLine + spaces(indent + SQLWhereClause.toUpdateSQL().length + 1) + ")"
            else
                newLine + spaces(indent) + SQLWhereClause.toUpdateSQL() + space + _whereItems.map(_.toDeleteSQL()).mkString(newLine).trim

        }
    }

    override def toDeleteSQL(indent: Int): String = {
        if (length === 0)
            strEmpty
        else {
            val _indent = SQLWhereClause.toDeleteSQL().length + 1 //- indentSize
            if (_whereItems.filter({
                case x: SQLWhereItems => true
                case x => false
            }).length > 0 || _whereItems.length > 1)
                newLine + spaces(indent) + SQLWhereClause.toDeleteSQL() + space + "(" + newLine + _whereItems.map(_.toDeleteSQL(indent + _indent)).mkString(newLine) + newLine + spaces(indent + SQLWhereClause.toDeleteSQL().length + 1) + ")"
            else
                newLine + spaces(indent) + SQLWhereClause.toDeleteSQL() + space + _whereItems.map(_.toDeleteSQL()).mkString(newLine).trim

        }
    }
}

sealed abstract class SQLAbsJoin extends SQLElement
sealed abstract class SQLAbsJoinClause extends SQLAbsJoin

case class SQLJoinClause(operator: OperatorId) extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = /*spaces(indent) +*/ operator.toSQL
    override def toInsertSQL(indent: Int): String = /*spaces(indent) +*/ operator.toSQL
    override def toUpdateSQL(indent: Int): String = /*spaces(indent) +*/ operator.toSQL
    override def toDeleteSQL(indent: Int): String = /*spaces(indent) +*/ operator.toSQL
}

case object SQLInnerJoinClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = spaces(indent) + "INNER JOIN".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "INNER JOIN".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "INNER JOIN".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "INNER JOIN".toHeightFont
}

case object SQLLeftJoinClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = spaces(indent) + "LEFT JOIN".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "LEFT JOIN".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "LEFT JOIN".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "LEFT JOIN".toHeightFont
}

case object SQLRightJoinClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = spaces(indent) + "RIGHT JOIN".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "RIGHT JOIN".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "RIGHT JOIN".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "RIGHT JOIN".toHeightFont
}

case object SQLOnClause extends SQLElement {
    override def toSQL(indent: Int): String = spaces(indent) + "ON".toHeightFont
    override def toInsertSQL(indent: Int): String = spaces(indent) + "ON".toHeightFont
    override def toUpdateSQL(indent: Int): String = spaces(indent) + "ON".toHeightFont
    override def toDeleteSQL(indent: Int): String = spaces(indent) + "ON".toHeightFont
}

case object SQLJoinAndClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = "AND".toHeightFont
    override def toInsertSQL(indent: Int): String = "AND".toHeightFont
    override def toUpdateSQL(indent: Int): String = "AND".toHeightFont
    override def toDeleteSQL(indent: Int): String = "AND".toHeightFont
}

case object SQLJoinOrClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = "OR".toHeightFont
    override def toInsertSQL(indent: Int): String = "OR".toHeightFont
    override def toUpdateSQL(indent: Int): String = "OR".toHeightFont
    override def toDeleteSQL(indent: Int): String = "OR".toHeightFont
}

case object SQLJoinNotClause extends SQLAbsJoinClause {
    override def toSQL(indent: Int): String = "NOT".toHeightFont
    override def toInsertSQL(indent: Int): String = "NOT".toHeightFont
    override def toUpdateSQL(indent: Int): String = "NOT".toHeightFont
    override def toDeleteSQL(indent: Int): String = "NOT".toHeightFont
}

object SQLJoinCondition {
    def apply(field: SQLField, operator: OperatorId, fieldJoin: SQLField) =
        new SQLJoinCondition(field = field, operator = operator, fieldJoin = fieldJoin, valuesJoin = SQLValues())

    def apply(field: SQLField, operator: OperatorId, valuesJoin: SQLValues) =
        new SQLJoinCondition(field = field, operator = operator, fieldJoin = SQLField(name = strEmpty), valuesJoin = valuesJoin)

    def apply(field: SQLField, operator: OperatorId, valueJoin: SQLAbsValue) =
        new SQLJoinCondition(field = field, operator = operator, fieldJoin = SQLField(name = strEmpty), valuesJoin = SQLValues(valueJoin))
}

case class SQLJoinCondition(field: SQLField, operator: OperatorId, fieldJoin: SQLField, valuesJoin: SQLValues) extends SQLAbsJoin {
    def getTableOwner: SQLTable = if (field.tableOwner.name.isEmpty) throw new RuntimeException(s"Field '${field.name}' haven't an owner") else field.tableOwner

    def getTableOwnerJoin: SQLTable = if (fieldJoin.tableOwner.name.isEmpty) throw new RuntimeException(s"Field '${fieldJoin.name}' haven't an owner") else fieldJoin.tableOwner

    override def toSQL(indent: Int): String = {
        def getField(field: SQLField, indent: Int = 0): String = {
            if (field.quoted)
                (if (field.isSystem) strEmpty else (if (field.tableOwner.name.isEmpty) getBaseAliasTable else field.tableOwner.toSQL() + ".")) + (if (field.alias.isEmpty) {
                    import com.simplesys.common.JVM.Strings._
                    field.getName.toHeightFont.dblQuoted
                } else field.alias.name)
            else
                (if (field.isSystem) strEmpty else (if (field.tableOwner.name.isEmpty) getBaseAliasTable else field.tableOwner.toSQL() + ".")) + (if (field.alias.isEmpty) field.getName else field.alias.name)
        }


        "(" + (if (field.tableOwner.name.isEmpty) getTableOwner.toSQL() + "." else strEmpty) + getField(field) + space + operator.toSQL + space + {
            if (valuesJoin.lenght === 0)
                (if (fieldJoin.tableOwner.name.isEmpty) getTableOwnerJoin.toSQL() + "." else strEmpty) + getField(fieldJoin)
            else
                valuesJoin.toSQL()
        } + ")"
    }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case class SQLJoinConditions(conditions: SQLAbsJoin*) extends SQLAbsJoin {
    def getJoinConditions = conditions

    override def toSQL(indent: Int): String = {
        if (conditions.length === 0)
            strEmpty
        else if (conditions.length === 1)
            spaces(indent) + conditions.head.toSQL(indent)
        else
            (conditions map (_.toSQL(indent + indentSize))).mkString(spaces(indent) + "(", space, ")")
    }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case class SQLJoinFrom(table: SQLAbsTable, alias: SQLAlias = SQLAlias(strEmpty), comment: SQLComment = SQLComment(strEmpty)) extends SQLAbsFrom {
    private def getTableSQL(indent: Int): String = {
        table match {
            case subSQL: SQLCompoundTable =>
                newLine + spaces(indent + indentSize) + "(" + newLine + subSQL.toSQL(indent + indentSize * 2) + newLine + spaces(indent + indentSize) + ")"
            case table: SQLTable =>
                space + table.toSQL()
        }
    }

    override def toSQL(indent: Int): String = getTableSQL(indent) + (if (alias.isEmpty) strEmpty else alias.toSQL(1)) + comment.toSQL(1)
    override def toInsertSQL(indent: Int): String = getTableSQL(indent) + (if (alias.isEmpty) strEmpty else alias.toSQL(1)) + comment.toSQL(1)
    override def toUpdateSQL(indent: Int): String = getTableSQL(indent) + (if (alias.isEmpty) strEmpty else alias.toSQL(1)) + comment.toSQL(1)
    override def toDeleteSQL(indent: Int): String = getTableSQL(indent) + (if (alias.isEmpty) strEmpty else alias.toSQL(1)) + comment.toSQL(1)
}

case class SQLJoin(joinType: SQLAbsJoinClause = SQLInnerJoinClause, joinFrom: SQLAbsFrom, conditions: SQLJoinConditions) extends SQLAbsJoin {

    override def toSQL(indent: Int): String = {
        joinType.toSQL(indent) + joinFrom.toSQL(indent) + (joinFrom match {
            case x: SQLJoinFrom if x.comment.nonEmpty =>
                newLine + SQLOnClause.toSQL(indent + joinType.toSQL().length + 1).space
            case _ =>
                SQLOnClause.toSQL(1).space

        }) + conditions.toSQL()
    }

    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

case class SQLJoins(joins: SQLAbsJoin*) extends SQLAbsJoin {
    private val _joins = ArrayBuffer[SQLAbsJoin](joins: _*)

    def +=(join: SQLJoin) {
        _joins += join
    }

    def ++=(joins: SQLJoin*) {
        _joins ++= joins
    }

    def getJoins = _joins

    def length = _joins.length

    override def toSQL(indent: Int): String = {
        if (_joins.length === 0)
            strEmpty
        else
            newLine + _joins.map(_.toSQL(indent)).mkString(newLine)
    }
    override def toInsertSQL(indent: Int): String = strEmpty
    override def toUpdateSQL(indent: Int): String = strEmpty
    override def toDeleteSQL(indent: Int): String = strEmpty
}

sealed abstract class SQLAbsTable extends SQLElement

case class SQLComment(comment: String) extends SQLElement {
    def nonEmpty = comment.nonEmpty
    def isEmpty = comment.isEmpty

    override def toSQL(indent: Int): String = spaces(indent) + (if (comment.nonEmpty) "----".space + comment else strEmpty)
    override def toInsertSQL(indent: Int): String = spaces(indent) + (if (comment.nonEmpty) "----".space + comment else strEmpty)
    override def toUpdateSQL(indent: Int): String = spaces(indent) + (if (comment.nonEmpty) "----".space + comment else strEmpty)
    override def toDeleteSQL(indent: Int): String = spaces(indent) + (if (comment.nonEmpty) "----".space + comment else strEmpty)
}

sealed abstract class SQLAbsFrom extends SQLElement

case class SQLFrom(table: SQLAbsTable, alias: SQLAlias = SQLAlias(strEmpty), comment: SQLComment = SQLComment(strEmpty)) extends SQLAbsFrom {
    private def getTableSQL(indent: Int): String = {
        table match {
            case subSQL: SQLCompoundTable =>
                newLine + spaces(indent + indentSize) + "(" + newLine + subSQL.toSQL(indent + indentSize * 2) + newLine + spaces(indent + indentSize) + ")"
            case table: SQLTable =>
                space + table.toSQL()
        }
    }

    override def toSQL(indent: Int): String = SQLFromClause.toSQL() + getTableSQL(indent) + alias.toSQL(1) + comment.toSQL(1)
    override def toInsertSQL(indent: Int): String = SQLFromClause.toInsertSQL() + getTableSQL(indent) + alias.toInsertSQL(1) + comment.toInsertSQL(1)
    override def toUpdateSQL(indent: Int): String = SQLFromClause.toUpdateSQL() + getTableSQL(indent) + alias.toUpdateSQL(1) + comment.toUpdateSQL(1)
    override def toDeleteSQL(indent: Int): String = SQLFromClause.toDeleteSQL() + getTableSQL(indent) + alias.toDeleteSQL(1) + comment.toDeleteSQL(1)
}

object SQLCompoundTable {

}

case class SQLCompoundTable(fields: SQLFields = new SQLFields(),
                            from: SQLFrom = SQLFrom(SQLTable(strEmpty)),
                            where: SQLWhere = SQLWhere(),
                            joins: SQLJoins = SQLJoins(),
                            groupsBy: SQLGroupBy = SQLGroupBy(),
                            ordersBy: SQLOrdersBy = SQLOrdersBy(),
                            optimizeField: Boolean = true) extends SQLAbsTable {

    if (from.alias.isEmpty && joins.length > 0)
        throw new RuntimeException("The joined request must have an alias in from clause.")

    override def toSQL(indent: Int): String = {

        //Модификация tableOwner (т.е.алиасов) у филдов в соответствии со вложенностью
        //Необходимо
        //Из
        /**
         * SELECT DD_DS0_B0_T0."BISJUR",
                DD_DS0_B0_T0."SCAPTION",
                DD_DS1_B0_T0."DI" AS DI_DS1,
                DD_DS1_B0_T0."SCAPTION" AS SCAPTION_DS1
         FROM
             (
                 SELECT DD_DS0_B0_T0."BISJUR",
                        DD_DS0_B0_T0."SCAPTION",
                        DD_DS0_B0_T1."DI"
                 FROM
                     (
                         SELECT DD_DS0_B0_T0."BISJUR",
                                DD_DS0_B0_T0."SCAPTION"
                         FROM
                             (
                                 SELECT DD_DS0_B0_T0."BISJUR",
                                        DD_DS0_B0_T0."DIGROUP",
                                        DD_DS0_B0_T0."SCAPTION"
                                 FROM
                                     (
                                         SELECT DD_DS0_B0_T0."BISJUR",
                                                DD_DS0_B0_T0."DIGROUP",
                                                DD_DS0_B0_T0."SCAPTION"
                                         FROM "CMN_CONTRACTOR" DD_DS0_B0_T0
                                         INNER JOIN "CMN_JURCONTRACTOR" DD_DS0_B0_T1 ON (DD_DS0_B0_T1."DI" = DD_DS0_B0_T0."DI")
                                     ) DD_DS0_B0
                             ) DD_DS0_B0
                         INNER JOIN
                             (
                                 SELECT DD_DS0_B1_T0."DI" AS DI_B1
                                 FROM "CMN_CONTRACTORGROUP" DD_DS0_B1_T0
                             ) DD_DS0_B1 ON (DD_DS0_B0_T0."DIGROUP" = DD_DS0_B1_T0.DI_B1)
                     ) DD_DS0
                 INNER JOIN
                     (
                         SELECT DD_DS1_B0_T0."DI" AS DI_DS1,
                                DD_DS1_B0_T0."SCAPTION" AS SCAPTION_DS1
                         FROM
                             (
                                 SELECT DD_DS1_B0_T0."DI" AS DI_DS1,
                                        DD_DS1_B0_T0."DIGROUP",
                                        DD_DS1_B0_T0."SCAPTION" AS SCAPTION_DS1
                                 FROM "CMN_CONTRACTOR" DD_DS1_B0_T0
                             ) DD_DS1_B0
                         INNER JOIN
                             (
                                 SELECT DD_DS1_B1_T0."DI" AS DI_B1
                                 FROM "CMN_CONTRACTORGROUP" DD_DS1_B1_T0
                             ) DD_DS1_B1 ON (DD_DS1_B0_T0."DIGROUP" = DD_DS1_B1_T0.DI_B1)
                     ) DD_DS1 ON (DD_DS0_B0_T1."DI" = DD_DS1_B0_T0.DI_DS1)
             ) DD_DS0
         */

        //Получить
        /**
         * SELECT DD_DS0."SCAPTION",
                DD_DS0."BISJUR",
                DD_DS0.DI_DS1,
                DD_DS0.SCAPTION_DS1
         FROM
             (SELECT DD_DS0."BISJUR",
                     DD_DS0."SCAPTION",
                     DD_DS0."DI",
                     DD_DS1.DI_DS1,
                     DD_DS1.SCAPTION_DS1
                 FROM
                     (
                         SELECT DD_DS0_B0."BISJUR",
                                DD_DS0_B0."SCAPTION",
                                DD_DS0_B0."DI"
                         FROM
                             (
                                 SELECT DD_DS0_B0."BISJUR",
                                        DD_DS0_B0."SCAPTION",
                                        DD_DS0_B0."DIGROUP",
                                        DD_DS0_B0."DI"
                                 FROM
                                     (
                                         SELECT DD_DS0_B0_T0."BISJUR",
                                                DD_DS0_B0_T0."SCAPTION",
                                                DD_DS0_B0_T0."DIGROUP",
                                                DD_DS0_B0_T1."DI"
                                         FROM "CMN_CONTRACTOR" DD_DS0_B0_T0
                                         INNER JOIN "CMN_JURCONTRACTOR" DD_DS0_B0_T1 ON (DD_DS0_B0_T1."DI" = DD_DS0_B0_T0."DI")
                                     ) DD_DS0_B0
                             ) DD_DS0_B0
                         INNER JOIN
                             (
                                 SELECT DD_DS0_B1_T0."DI" AS DI_B1
                                 FROM "CMN_CONTRACTORGROUP" DD_DS0_B1_T0
                             ) DD_DS0_B1 ON (DD_DS0_B0."DIGROUP" = DD_DS0_B1.DI_B1)
                     ) DD_DS0
                 INNER JOIN
                     (
                         SELECT DD_DS1_B0.SCAPTION_DS1,
                                DD_DS1_B0.DI_DS1
                         FROM
                             (
                                 SELECT DD_DS1_B0_T0."SCAPTION" AS SCAPTION_DS1,
                                        DD_DS1_B0_T0."DI" AS DI_DS1,
                                        DD_DS1_B0_T0."DIGROUP"
                                 FROM "CMN_CONTRACTOR" DD_DS1_B0_T0
                             ) DD_DS1_B0
                         INNER JOIN
                             (
                                 SELECT DD_DS1_B1_T0."DI" AS DI_B1
                                 FROM "CMN_CONTRACTORGROUP" DD_DS1_B1_T0
                             ) DD_DS1_B1 ON (DD_DS1_B0."DIGROUP" = DD_DS1_B1.DI_B1)
                     ) DD_DS1 ON (DD_DS0."DI" = DD_DS1.DI_DS1)
           ) DD_DS0
         */

        //Как видно необходимо преобразовать алиасы

        def topFrom = from
        def findFieldInFrom(field: SQLField, from: SQLFrom, fields: SQLFields, joins: SQLJoins): Array[SQLField] = {

            var _field: Array[SQLField] = from.table match {
                case SQLTable(_, _) =>
                    if (fields.getFields.exists(_ === field))
                        Array(field)
                    else
                        NotValue
                case SQLCompoundTable(fields, from, _, joins, _, _, _) =>
                    if (fields.getFields.exists(_ === field))
                        topFrom.table match {
                            case x: SQLTable =>
                                Array(field.copy(tableOwner = SQLTable(name = topFrom.alias.name, quoted = false)))
                            case x: SQLCompoundTable =>
                                val _field = field.copy(tableOwner = SQLTable(name = topFrom.alias.name, quoted = false))

                                if (_field.alias.nonEmpty && !_field.isSystem)
                                    Array(_field.copy(name = _field.alias.name, alias = SQLAlias(strEmpty), quoted = false))
                                else
                                    Array(_field)
                        }
                    else
                        findFieldInFrom(field = field, from = from, fields = fields, joins = joins)
            }

            _field match {
                case Array(_) =>
                case _ =>
                    joins.getJoins foreach {
                        join =>
                            _field match {
                                case Array(_) =>
                                case _ =>
                                    _field = findFieldInJoin(field = field, join = join, fields = fields)
                            }
                    }
            }

            _field
        }

        def findFieldInJoin(field: SQLField, join: SQLAbsJoin, fields: SQLFields): Array[SQLField] = {
            join match {
                case SQLJoin(_, joinFrom: SQLJoinFrom, _) =>
                    joinFrom match {
                        case SQLJoinFrom(table: SQLTable, _, _) =>
                            if (fields.getFields.exists(_ === field))
                                Array(field.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false)))
                            else
                                NotValue
                        case SQLJoinFrom(SQLCompoundTable(fields, from, _, joins, _, _, _), _, _) =>
                            if (fields.getFields.exists(_ === field))
                                from.table match {
                                    case x: SQLTable =>
                                        Array(field.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false)))
                                    case x: SQLCompoundTable =>
                                        val _field = field.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false))

                                        if (_field.alias.nonEmpty && !_field.isSystem)
                                            Array(_field.copy(name = _field.alias.name, alias = SQLAlias(strEmpty), quoted = false))
                                        else
                                            Array(_field)
                                }
                            else
                                findFieldInFrom(field = field, from = from, fields = fields, joins = joins)
                    }
                case x =>
                    throw new RuntimeException(s"Bad branch ${x}")
            }
        }

        //fields.log
        def _fields: SQLFields = if (optimizeField) SQLFields(fields.getFields.map {
            field =>
                findFieldInFrom(field = field, from = from, fields = fields, joins = joins) match {
                    case Array(_field) =>
                        from.table match {
                            case y: SQLTable =>
                                Array(_field)
                            case y: SQLCompoundTable =>
                                if (_field.alias.nonEmpty && !_field.isSystem)
                                    Array(_field.copy(name = _field.alias.name, alias = SQLAlias(strEmpty), quoted = false))
                                else
                                    Array(_field)
                        }
                    case x => x
                }
        })
        else fields

        //Модифицируем tableOwner (т.е.алиасов) у джоинов
        def _joins: SQLJoins = {
            @tailrec
            def existsField(table: SQLCompoundTable, condition: SQLJoinCondition): Boolean = {
                table.from match {
                    case SQLFrom(table: SQLCompoundTable, _, _) =>
                        existsField(table, condition)
                    case _ =>
                        table.fields.getFields.exists(f => f.tableOwner.name === condition.field.tableOwner.name && (f.getName === condition.field.name || f.alias.name === condition.field.name))
                }
            }

            @tailrec
            def existsFieldJoin(table: SQLCompoundTable, condition: SQLJoinCondition): Boolean = {
                table.from match {
                    case SQLFrom(table: SQLCompoundTable, _, _) =>
                        existsFieldJoin(table, condition)
                    case _ =>
                        table.fields.getFields.exists(f => f.tableOwner.name === condition.fieldJoin.tableOwner.name && (f.getName === condition.fieldJoin.name || f.alias.name === condition.fieldJoin.name))
                }
            }

            SQLJoins(joins.getJoins.map {
                case join: SQLJoin =>
                    join.joinFrom match {
                        case SQLJoinFrom(table: SQLTable, alias, _) =>
                            val _conditions: SQLJoinConditions = SQLJoinConditions(join.conditions.getJoinConditions.map {
                                case condition: SQLJoinCondition if alias.nonEmpty && condition.getTableOwner.name === table.name =>
                                    val _flds: Seq[SQLField] = _fields.getFields.filter(field => field.name === condition.fieldJoin.name).distinct
                                    if (_flds.length === 1)
                                        condition.copy(field = condition.field.copy(tableOwner = SQLTable(name = alias.name, quoted = false)), fieldJoin = _flds.head)
                                    else
                                        condition.copy(field = condition.field.copy(tableOwner = SQLTable(name = alias.name, quoted = false)))

                                case condition: SQLJoinCondition if alias.nonEmpty && condition.getTableOwnerJoin.name === table.name =>
                                    val _flds: Seq[SQLField] = _fields.getFields.filter(field => field.name === condition.field.name).distinct
                                    if (_flds.length === 1)
                                        condition.copy(field = _flds.head, fieldJoin = condition.fieldJoin.copy(tableOwner = SQLTable(name = alias.name, quoted = false)))
                                    else
                                        condition.copy(fieldJoin = condition.fieldJoin.copy(tableOwner = SQLTable(name = alias.name, quoted = false)))


                                case condition: SQLJoinCondition =>
                                    condition
                            }: _*)
                            join.copy(conditions = _conditions)

                        case SQLJoinFrom(table: SQLCompoundTable, alias, _) =>
                            val _conditions: SQLJoinConditions = SQLJoinConditions(
                                join.conditions.getJoinConditions.map {
                                    case condition: SQLJoinCondition if existsField(table, condition) =>
                                        condition.copy(field = condition.field.copy(tableOwner = SQLTable(name = alias.name, quoted = false)))

                                    case condition: SQLJoinCondition if existsFieldJoin(table, condition) =>
                                        condition.copy(fieldJoin = condition.fieldJoin.copy(tableOwner = SQLTable(name = alias.name, quoted = false)))

                                    case condition: SQLJoinCondition =>
                                        condition
                                }.map {
                                    case condition: SQLJoinCondition if existsField(fromCompoundTableSQL, condition) =>
                                        condition.copy(field = condition.field.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                                    case condition: SQLJoinCondition if existsFieldJoin(fromCompoundTableSQL, condition) =>
                                        condition.copy(fieldJoin = condition.fieldJoin.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                                    case condition: SQLJoinCondition =>
                                        condition
                                }: _*)


                            join.copy(conditions = _conditions)

                        case x =>
                            throw new RuntimeException(s"Bad branch ${x}")
                    }
                case x =>
                    throw new RuntimeException(s"Bad branch ${x}")
            }: _*)
        }


        def _where: SQLWhere = {

            def getWhereItem(whereItem: SQLAbsWhereItem): SQLAbsWhereItem =
                whereItem match {
                    case whereItem: SQLWhereItem if fromCompoundTableSQL.fields.getFields.exists(f => f.getName == whereItem.fieldLeft.name && f.alias.name == whereItem.fieldLeft.alias.name) =>
                        whereItem.copy(fieldLeft = whereItem.fieldLeft.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                    case whereItem: SQLWhereItem if fromCompoundTableSQL.fields.getFields.exists(f => f.getName == whereItem.fieldRight.name && f.alias.name == whereItem.fieldRight.alias.name) =>
                        whereItem.copy(fieldRight = whereItem.fieldRight.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                    case whereInItem: SQLWhereInItem if fromCompoundTableSQL.fields.getFields.exists(f => f.getName == whereInItem.field.name && f.alias.name == whereInItem.field.alias.name) =>
                        whereInItem.copy(field = whereInItem.field.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                    case whereBetweenItem: SQLWhereBetweenItem if fromCompoundTableSQL.fields.getFields.exists(f => f.getName == whereBetweenItem.field.name && f.alias.name == whereBetweenItem.field.alias.name) =>
                        whereBetweenItem.copy(field = whereBetweenItem.field.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

                    case whereItem: SQLWhereItem if whereItem.whereItems.length > 0 =>
                        whereItem.copy(whereItems = SQLWhereItems(getWhereItems(whereItem.whereItems)))

                    case whereInItems: SQLWhereItems =>
                        getWhereItems(whereInItems)

                    case whereItemClause: SQLWhereItemClause =>
                        whereItemClause

                    case whereItem: SQLWhereItem =>
                        whereItem

                    case whereBetweenItem: SQLWhereBetweenItem =>
                        whereBetweenItem

                    case x =>
                        throw new RuntimeException(s"Bad branch ${x}")
                }

            def getWhereItems(whereItems: SQLWhereItems): SQLAbsWhereItem = SQLWhereItems(whereItems.toSeq.map(getWhereItem _): _*)

            case class ResFindingInJoins(item: SQLWhereItem, finded: Boolean)

            def getWhereItemInJoin(whereItem: SQLAbsWhereItem): SQLAbsWhereItem =
                whereItem match {
                    case whereItem: SQLWhereItem if whereItem.whereItems.length > 0 =>
                        getWhereItemsInJoin(whereItem.whereItems)

                    case whereItem: SQLWhereItem =>
                        joins.getJoins.map {
                            case SQLJoin(_, joinFrom: SQLJoinFrom, _) =>
                                joinFrom.table match {
                                    case table: SQLTable =>
                                        ResFindingInJoins(whereItem, true)
                                    case table: SQLCompoundTable if table.fields.getFields.exists(f => (f.alias.isEmpty && f.name == whereItem.fieldLeft.name) || (f.alias.nonEmpty && f.alias.name == whereItem.fieldLeft.name)) =>
                                        ResFindingInJoins(whereItem.copy(fieldLeft = whereItem.fieldLeft.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false))), true)
                                    case table: SQLCompoundTable if table.fields.getFields.exists(f => (f.alias.isEmpty && f.name == whereItem.fieldRight.name) || (f.alias.nonEmpty && f.alias.name == whereItem.fieldRight.name)) =>
                                        ResFindingInJoins(whereItem.copy(fieldRight = whereItem.fieldRight.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false))), true)
                                    case table: SQLCompoundTable =>
                                        ResFindingInJoins(whereItem, false)
                                }
                            case x =>
                                throw new RuntimeException(s"Bad branch ${x}")
                        }.toList match {
                            case Nil => whereItem
                            case xs =>
                                val res = xs.filter(_.finded == true)
                                if (res.length > 1)
                                    throw new RuntimeException(s"Неоднозначный выбор.")
                                else if (res.length == 1)
                                    res.map(_.item).head
                                else
                                    xs.map(_.item).head
                        }

                    case whereInItem: SQLWhereInItem =>
                        joins.getJoins.map {
                            case SQLJoin(_, joinFrom: SQLJoinFrom, _) =>
                                joinFrom.table match {
                                    case table: SQLTable =>
                                        whereInItem
                                    case table: SQLCompoundTable if table.fields.getFields.exists(f => (f.alias.isEmpty && f.name == whereInItem.field.name) || (f.alias.nonEmpty && f.alias.name == whereInItem.field.name)) =>
                                        whereInItem.copy(field = whereInItem.field.copy(tableOwner = SQLTable(name = joinFrom.alias.name, quoted = false)))
                                    case table: SQLCompoundTable =>
                                        whereInItem
                                }
                            case x =>
                                throw new RuntimeException(s"Bad branch ${x}")
                        }.toList match {
                            case Nil => whereInItem
                            case xs => xs.head
                        }

                    case whereInItems: SQLWhereItems =>
                        getWhereItemsInJoin(whereInItems)

                    case whereItemClause: SQLWhereItemClause =>
                        whereItemClause

                    case whereBetweenItem: SQLWhereBetweenItem =>
                        whereBetweenItem

                    case x =>
                        throw new RuntimeException(s"Bad branch ${x}")
                }

            def getWhereItemsInJoin(whereItems: SQLWhereItems): SQLAbsWhereItem = SQLWhereItems(whereItems.toSeq.map(getWhereItemInJoin _): _*)

            val res = SQLWhere(where.getWhereItems.map(getWhereItem _).map(getWhereItemInJoin _): _*)
            //logger.trace(s"SQLWhere: ${res.toSQL()}")
            res
        }

        //todo недоделано, нет примеров использования (реализация похоже как для OrderBy)
        def _groupsBy: SQLGroupBy = SQLGroupBy(groupsBy.getFields: _*)

        def fromCompoundTableSQL = from.table match {
            case x: SQLTable => SQLCompoundTable()
            case x: SQLCompoundTable => x
        }

        val _ordersBy = SQLOrdersBy() //Не убирать

        ordersBy.getFields foreach {
            case orderByItem: SQLOrderBy if fromCompoundTableSQL.fields.getFields.exists(f => f.getName == orderByItem.field.name && f.alias.name == orderByItem.field.alias.name) =>
                _ordersBy += orderByItem.copy(field = orderByItem.field.copy(tableOwner = SQLTable(name = from.alias.name, quoted = false)))

            case orderByItem: SQLOrderBy if fromCompoundTableSQL.fields.getFields.exists(f => f.originalName == orderByItem.field.getName) =>
                val field = fromCompoundTableSQL.fields.getFields.filter(f => f.originalName == orderByItem.field.getName).head
                _ordersBy += orderByItem.copy(field = orderByItem.field.copy(name = field.getAliasedName, tableOwner = SQLTable(name = from.alias.name, quoted = false)))

            case orderByItem: SQLOrderBy =>
                _ordersBy += orderByItem // Новое добавил 12,09,2014
        }

        spaces(indent) + SQLSelectClause.toSQL() + space + _fields.toSQL(indent + SQLSelectClause.toSQL().length + 1) + newLine + spaces(indent) + from.toSQL(indent) + space + _joins.toSQL(indent) + _where.toSQL(indent) + _groupsBy.toSQL(indent) + _ordersBy.toSQL(indent)
    }

    private def getTableNameWithOutAlias = {
        from.table match {
            case SQLTable(name: String, quoted) =>
                space + (if (quoted) {
                    import com.simplesys.common.JVM.Strings._
                    name.toHeightFont.dblQuoted
                } else name.toHeightFont)
            case _ =>
                strEmpty
        }
    }

    override def toInsertSQL(indent: Int): String = {
        spaces(indent) + SQLInsertClause.toInsertSQL() + getTableNameWithOutAlias + "(" + fields.toInsertSQL() + ")".newLine + spaces(indent + indentSize) + SQLValuesClause.toInsertSQL() + fields.insertValues()
    }

    override def toUpdateSQL(indent: Int): String = {
        val _indent = indent + SQLUpdateClause.toUpdateSQL().length + 1
        val _indent1 = _indent + SQLSetClause.toUpdateSQL().length + 1
        spaces(indent) + SQLUpdateClause.toUpdateSQL() + getTableNameWithOutAlias + newLine + spaces(_indent) + SQLSetClause.toUpdateSQL() + newLine + spaces(_indent1) + fields.toUpdateSQL(_indent) + where.toUpdateSQL(indent)
    }

    override def toDeleteSQL(indent: Int): String = spaces(indent) + SQLDeleteClause.toDeleteSQL().space + SQLFromClause.toDeleteSQL() + getTableNameWithOutAlias + where.toDeleteSQL(indent)
}

