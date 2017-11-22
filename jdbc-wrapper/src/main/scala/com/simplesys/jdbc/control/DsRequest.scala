package com.simplesys.jdbc.control

import com.simplesys.SQL.Gen._
import com.simplesys.circe.Circe._
import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.typesDyn._
import com.simplesys.jdbc.control.DsRequest._
import com.simplesys.log.Logging
import com.simplesys.sql.{OracleDialect, SQLDialect}
import io.circe.{Json, JsonObject}

import scala.collection.mutable.ArrayBuffer

object DsRequest {
    def apply(sqlDialect: SQLDialect, data: Json) = new DsRequest(sqlDialect, 0, 0, Vector.empty, data, "exact")

    implicit class JsonObjectToSQL(jsonObject: JsonObject) extends Logging {
        def appendCriteria(sqlDialect: SQLDialect, getColumnInBase: String => SQLField, getColumn: String => BasicClassBOColumn[_])(implicit bindMap: ArrayBuffer[BindingColumn]): SQLAbsWhereItem = {
            sqlDialect match {
                case OracleDialect =>
                    jsonObject.getJsonListOpt("criteria") match {
                        case None =>
                            val operator = OperatorId.get(jsonObject.getString("operator"))
                            val fieldName = jsonObject.getString("fieldName")

                            operator.kind match {
                                case x: IsBetween.type =>
                                    bindMap += BindingColumn(getColumn(fieldName), jsonObject.getJsonElement("start").get.noSpaces1)
                                    bindMap += BindingColumn(getColumn(fieldName), jsonObject.getJsonElement("end").get.noSpaces1)
                                    SQLWhereBetweenItem(field = getColumnInBase(fieldName), operator = operator, start = SQLValue(operator.getBindPlaceholder), end = SQLValue(operator.getBindPlaceholder))

                                case x: IsNull.type =>
                                    SQLWhereItem(field = getColumnInBase(fieldName), operator = operator, value = SQLEmptyValue)

                                case x: IsInList.type =>
                                    jsonObject.getJsonListOpt("value") match {
                                        case None =>
                                            SQLNullWhereItem
                                        case Some(list) =>
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
                                    }

                                case _ =>
                                    bindMap += BindingColumn(getColumn(fieldName), jsonObject.getJsonElement("value").get.toString)
                                    SQLWhereItem(field = getColumnInBase(fieldName), operator = operator, value = SQLValue(operator.getBindPlaceholder))
                            }
                        case Some(list) =>
                            list.appendCriteria(sqlDialect = sqlDialect, getColumnNameInBase = getColumnInBase, getColumn, operator = OperatorId.get(jsonObject.getString("operator")))
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
                        case item if item.isObject =>
                            item.asObject.get.appendCriteria(sqlDialect, getColumnNameInBase, getColumn) match {
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
                                    throw new RuntimeException(s"Bad branch of $x")
                            }
                        case x =>
                            throw new RuntimeException(s"Bad branch of $x")
                    }

                    res
                case x =>
                    throw new RuntimeException(s"Bad branch of $x")
            }
        }
    }
}

case class DsRequest(sqlDialect: SQLDialect, startRow: Int, endRow: Int, sortBy: Vector[Json], data: Json, textMatchStyle: String = "exact") extends Logging {

    logger trace (newLine + s"sqlDialect: ${sqlDialect.toString}\n startRow: $startRow \nendRow: $endRow \nsortBy: ${sortBy.toPrettyString} \ntextMatchStyle: $textMatchStyle \ndata: ${data.toPrettyString}")

    def isAdvancedFilter: Boolean = data.getStringOpt("_constructor") match {
        case None => false
        case Some(x: String) if x == "AdvancedCriteria" => true
        case _ => false
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
            case item if item.isNull =>
                SQLWhereItem()
            case item if item.isObject =>
                if (isAdvancedFilter) {
                    data.asObject.get.appendCriteria(sqlDialect = sqlDialect, getColumnInBase = getColumnInBase, getColumn = getColumn) match {
                        case whereItem: SQLWhereItem =>
                            whereItem
                        case whereItems: SQLWhereItems =>
                            SQLWhereItem(whereItems)
                        case betweenItem: SQLWhereBetweenItem =>
                            SQLWhereItem(betweenItem)
                        case x =>
                            throw new RuntimeException(s"Bad branch of $x")
                        //SQLWhereItem()
                    }
                } else {
                    def checkExistsField(key: String): Unit = {
                        fields.filter(_.nameInBo === key).headOption match {
                            case None =>
                                throw new RuntimeException(s"Key $key not found")
                            case _ =>
                        }
                    }

                    val whereItems = SQLWhereItems()
                    val items = data.asObject.get.getProxyObject.filter(_._1 !== "ts")
                    items.foreach {
                        case (key, values: Json) if values.isArray =>
                            checkExistsField(key)

                            val _values: Vector[Json] = values.asArray.getOrElse(Vector.empty) /*.filter(_.noSpaces1 != "null")*/
                            _values foreach (value => bindMap += BindingColumn(fields.filter(_.nameInBo === key).head, value.toString))

                            val _textMachStyle = TextMatchStyle getObject textMatchStyle

                            val placeHolders: Vector[SQLValue] = _values.map(_ => SQLValue(_textMachStyle.getBindPlaceholder))

                            if (whereItems.length > 0)
                                whereItems += SQLWhereItemClause(opIdAnd)
                            whereItems += SQLWhereItem(field = columns.fields.filter(field => field.nameInBo === key).head, operator = opIdInSet, value = SQLValues(placeHolders: _*))

                            logger.trace(s"whereItems is: ${newLine + whereItems.toSQL()}")

                        case (key, value) /*if value.noSpaces1 != "null"*/ =>

                            checkExistsField(key)

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

                        case x =>
                            throw new RuntimeException(s"Bad branch: $x")
                    }
                    SQLWhereItem(whereItems = whereItems)
                }
        }
    }
}
