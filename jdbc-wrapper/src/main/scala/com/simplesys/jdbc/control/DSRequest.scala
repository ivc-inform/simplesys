package com.simplesys.jdbc.control

import com.simplesys.SQL.Gen._
import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.typesDyn._
import com.simplesys.jdbc.control.DSRequest._
import com.simplesys.log.Logging
import com.simplesys.sql.{OracleDialect, SQLDialect}
import io.circe.Json._
import io.circe.{HCursor, Json}

import scala.collection.immutable
import scala.collection.mutable.ArrayBuffer

object DSRequest {
    def apply(sqlDialect: SQLDialect, data: Json) = new DSRequest(sqlDialect, 0, 0, arr(), data, "exact")

    implicit class JsonObjectToSQL(json: Json) extends Logging {
        val cursor: HCursor = json.hcursor

        def appendCriteria(sqlDialect: SQLDialect, getColumnInBase: String => SQLField, getColumn: String => BasicClassBOColumn[_])(implicit bindMap: ArrayBuffer[BindingColumn]): SQLAbsWhereItem = {
            sqlDialect match {
                case OracleDialect =>
                    cursor.get[Json]("criteria") match {
                        case Left(_) =>
                            cursor.get[String]("operator").map {
                                _operator ⇒
                                    val operator = OperatorId.get(_operator)
                                    cursor.get[String]("fieldName").map {
                                        fieldName ⇒
                                            operator.kind match {
                                                case x: IsBetween.type =>
                                                    cursor.get[String]("start").foreach(bindMap += BindingColumn(getColumn(fieldName), _))
                                                    cursor.get[String]("end").foreach(bindMap += BindingColumn(getColumn(fieldName), _))
                                                    SQLWhereBetweenItem(field = getColumnInBase(fieldName), operator = operator, start = SQLValue(operator.getBindPlaceholder), end = SQLValue(operator.getBindPlaceholder))

                                                case x: IsNull.type =>
                                                    SQLWhereItem(field = getColumnInBase(fieldName), operator = operator, value = SQLEmptyValue)

                                                case x: IsInList.type =>
                                                    cursor.get[Json]("value").map {
                                                        value ⇒
                                                            value.asArray.map {
                                                                list ⇒
                                                                    val placesHolder = ArrayBuffer.empty[SQLAbsValue]
                                                                    list foreach {
                                                                        item =>
                                                                            if (!item.toString.unQuoted.isEmpty) {
                                                                                placesHolder += SQLValue(operator.getBindPlaceholder)
                                                                                bindMap += BindingColumn(getColumn(fieldName), item.toString)
                                                                            }
                                                                    }
                                                                    if (placesHolder.length > 0)
                                                                        SQLWhereItem(field = getColumnInBase(fieldName), operator = operator, value = SQLValues(placesHolder: _*))
                                                                    else
                                                                        SQLNullWhereItem
                                                            }.getOrElse(SQLNullWhereItem)
                                                    }.getOrElse(SQLNullWhereItem)

                                                case _ =>
                                                    cursor.get[String]("value").foreach(bindMap += BindingColumn(getColumn(fieldName), _))
                                                    SQLWhereItem(field = getColumnInBase(fieldName), operator = operator, value = SQLValue(operator.getBindPlaceholder))
                                            }
                                    }.getOrElse(SQLNullWhereItem)
                            }.getOrElse(SQLNullWhereItem)
                        case Right(criteria) =>
                            criteria.asArray.map {
                                array ⇒
                                    cursor.get[String]("operator").map {
                                        operator ⇒
                                            array.appendCriteria(sqlDialect = sqlDialect, getColumnNameInBase = getColumnInBase, getColumn, operator = OperatorId.get(operator))
                                    }.getOrElse(SQLNullWhereItem)
                            }.getOrElse(SQLNullWhereItem)
                    }

                case x =>
                    throw new RuntimeException(s"Bad branch of ${x}")
            }
        }
    }

    implicit class JsonListToSQL(jsonList: Vector[Json]) {
        def appendCriteria(sqlDialect: SQLDialect, getColumnNameInBase: String => SQLField, getColumn: String => BasicClassBOColumn[_], operator: OperatorId)(implicit bindMap: ArrayBuffer[BindingColumn]): SQLWhereItems = {
            sqlDialect match {
                case OracleDialect =>
                    val res = SQLWhereItems()

                    jsonList foreach {
                        item ⇒
                            item.asObject.foreach {
                                item ⇒
                                    fromJsonObject(item) appendCriteria(sqlDialect, getColumnNameInBase, getColumn) match {
                                        case whereItem: SQLWhereItem =>
                                            if (res.length > 0)
                                                res += SQLWhereItemClause(operator)
                                            res += whereItem
                                        case whereItems: SQLWhereItems =>
                                            if (res.length > 0)
                                                res += SQLWhereItemClause(operator)
                                            res += whereItems
                                        case betweenItem: SQLWhereBetweenItem =>
                                            if (res.length > 0)
                                                res += SQLWhereItemClause(operator)
                                            res += betweenItem
                                        case SQLNullWhereItem =>
                                        case x =>
                                            throw new RuntimeException(s"Bad branch of ${x}")
                                    }
                            }
                    }

                    res
                case x =>
                    throw new RuntimeException(s"Bad branch of ${x}")
            }
        }
    }
}

case class DSRequest(sqlDialect: SQLDialect, startRow: Number, endRow: Number, sortBy: Json, data: Json, textMatchStyle: String = "exact") extends Logging {
    val cursor: HCursor = data.hcursor

    logger trace (newLine + s"sqlDialect: ${sqlDialect.toString} startRow: ${startRow.toString()} endRow: ${endRow.toString()} sortBy: ${sortBy.spaces4} textMatchStyle: ${textMatchStyle} data: ${data.spaces4}")

    def isAdvancedFilter: Boolean = cursor.get[String]("_constructor") match {
        case Left(_) ⇒ false
        case Right(x) if x == "AdvancedCriteria" => true
        case _ ⇒ false
    }

    def appendCriteria(fields: List[BasicClassBOColumn[_]], columns: SQLFields, bindMap: ArrayBuffer[BindingColumn]): SQLWhereItem = {
        implicit val _bindMap = bindMap

        def getColumnInBase(columnNameInBo: String): SQLField = {
            val a: String = columnNameInBo.unQuoted.replace("-", "")
            val _b: List[BasicClassBOColumn[_]] = fields.filter(_.nameInBo === a)
            if (_b.length != 1) {
                _b.foreach(_.log(0))
                throw new RuntimeException(s"Not unambiguously field '${columnNameInBo}'.")
            }
            else {
                val b: BasicClassBOColumn[_] = _b.head
                SQLField(name = b.getName, tableOwner = b.getTableOwner)
            }
        }

        def getColumn(nameInBo: String): BasicClassBOColumn[_] = {
            fields.filter(_.nameInBo === nameInBo).headOption match {
                case None => throw new RuntimeException(s"Field: ${nameInBo} not found.")
                case Some(column) => column
            }
        }

        data match {
            case null =>
                SQLWhereItem()
            case _ =>
                if (isAdvancedFilter) {
                    data.appendCriteria(sqlDialect = sqlDialect, getColumnInBase = getColumnInBase, getColumn = getColumn) match {
                        case whereItem: SQLWhereItem =>
                            whereItem
                        case whereItems: SQLWhereItems =>
                            SQLWhereItem(whereItems)
                        case betweenItem: SQLWhereBetweenItem =>
                            SQLWhereItem(betweenItem)
                        case x =>
                            throw new RuntimeException(s"Bad branch of ${x}")
                        //SQLWhereItem()
                    }
                } else {
                    val whereItems = SQLWhereItems()
                    data.asObject.foreach {
                        obj ⇒
                            val items = obj.toMap.filter(_._1 !== "ts")
                            items.foreach {
                                case (key, _list) if _list.isArray =>
                                    val list = _list.asArray.get
                                    fields.filter(_.nameInBo === key).headOption match {
                                        case None =>
                                            throw new RuntimeException(s"Key ${key} not found")
                                        case _ =>
                                    }

                                    val _values = list.filter(_ != Json.Null)
                                    _values foreach (value => bindMap += BindingColumn(fields.filter(_.nameInBo === key).head, value.toString))

                                    val _textMachStyle = TextMatchStyle getObject textMatchStyle

                                    val placeHolders: Vector[SQLValue] = _values.map(item => SQLValue(_textMachStyle.getBindPlaceholder))

                                    if (whereItems.length > 0)
                                        whereItems += SQLWhereItemClause(opIdAnd)
                                    whereItems += SQLWhereItem(field = columns.fields.filter(field => field.nameInBo === key).head, operator = opIdInSet, value = SQLValues(placeHolders: _*))

                                    logger.trace(s"whereItems is: ${newLine + whereItems.toSQL()}")

                                case (key, value) if !value.isNull =>

                                    fields.filter(_.nameInBo === key).headOption match {
                                        case None =>
                                            throw new RuntimeException(s"Key ${key} not found")
                                        case _ =>
                                    }

                                    bindMap += BindingColumn(fields.filter(_.nameInBo === key).head, value.toString)

                                    val _textMachStyle = TextMatchStyle getObject textMatchStyle

                                    def getOperator: OperatorId = _textMachStyle.toSQL match {
                                        case "=" => opIdEquals
                                        case "LIKE" => opIdContains
                                        case _ => throw new RuntimeException("Bad branch of textMuchStyle")
                                    }

                                    if (whereItems.length > 0)
                                        whereItems += SQLWhereItemClause(opIdAnd)

                                    whereItems += SQLWhereItem(field = columns.fields.filter(field => field.nameInBo === key).head, operator = getOperator, value = SQLValue(_textMachStyle.getBindPlaceholder))
                                    logger.trace(s"whereItems is: ${newLine + whereItems.toSQL()}")

                                case (key, value) if value.isNull =>
                                    logger warn s"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Key : $key = null !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"

                                case x =>
                                    throw new RuntimeException(s"Bad branch: $x")
                            }
                    }

                    SQLWhereItem(whereItems = whereItems)
                }
        }
    }
}
