package com.simplesys.json

import java.io.{File, InputStream}

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.misc._
import com.simplesys.log.Logging
import com.simplesys.script.JsBeautifier
import org.joda.time.{DateTime, LocalDateTime}

import scala.collection.mutable.{ArrayBuffer, Map}
import scala.reflect.ClassTag
import scala.util.control.Breaks._


sealed abstract class JsonElement extends Logging {
    def toDblQuotedString = toString.dblQuoted
    def toPrettyString = toString
}

case class JsonString(value: String) extends JsonElement {
    override def toString: String = value
}

case class JsonUnquotedString(value: UnquotedString) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonStringMethod(value: StringMethod) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonBoolean(value: Boolean) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonBigDecimal(value: BigDecimal) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonBigInt(value: BigInt) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonLong(value: Long) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonDouble(value: Double) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonInt(value: Int) extends JsonElement {
    override def toString: String = value.toString
}

case class JsonDateTime(value: DateTime) extends JsonElement {
    override def toString: String = value.toString().dblQuoted
}

case class JsonLocalDateTime(value: LocalDateTime) extends JsonElement {
    override def toString: String = value.toString().dblQuoted
}

case class JsonURL(value: URL) extends JsonElement {
    override def toString: String = if (value.toString().last === File.separatorChar) value.toString().substring(0, value.toString().length - 1) else value.toString()
}

case class JsonURN(value: URN) extends JsonElement {
    override def toString: String = if (value.toString().last === File.separatorChar) value.toString().substring(0, value.toString().length - 1) else value.toString()
}

case object JsonNull extends JsonElement {
    override def toString: String = "null"
}

case object JsonUndefined extends JsonElement {
    override def toString: String = "undefined"
}

case object JsonEmpty extends JsonElement {
    override def toString: String = strEmpty
}

case object JsonRemove extends JsonElement {
    override def toString: String = "remove"
}

object JsonObject {
    def apply() = new JsonObject()

    implicit def apply(proxy: Map[String, JsonElement]): JsonObject = new JsonObject(proxy)
    implicit def apply(proxy: scala.collection.immutable.Map[String, JsonElement]): JsonObject = new JsonObject(Map(proxy.toSeq: _*))
    implicit def apply(jsonObject: JsonObject): JsonObject = new JsonObject(jsonObject)
    implicit def toMap(in: JsonObject): Map[String, JsonElement] = in proxy

    def apply(elements: (String, JsonElement)*): JsonObject = {
        val proxy = JsonObject()
        elements foreach (proxy += _)
        proxy
    }

    def apply1(element: (String, JsonElement)): JsonObject = {
        val proxy = JsonObject()
        proxy += element
        proxy
    }
}

class JsonObject(protected val proxy: Map[String, JsonElement],
                 override val selfName: String = "undefigned",
                 override val useSelfName: Boolean = false) extends JsonElement with JsonAbs with Misc {

    def this() = this(Map.empty[String, JsonElement])

    def this(selfName: String, useSelfName: Boolean) = this(Map.empty[String, JsonElement], selfName, useSelfName)

    def +(xs: (String, JsonElement)): JsonObject = clone += xs

    def +=(xs: (String, JsonElement)): JsonObject = {
        update(xs._1, xs._2)
        proxy
    }

    def update(key: String, value: JsonElement) {
        value match {
            case JsonString(string) =>
                val str = string.unQuoted.dblQuoted
                proxy update(key, JsonString(str))
            case JsonRemove =>
                proxy remove key
            case _ =>
                proxy update(key, value)
        }
    }

    def -(key: String): JsonObject = proxy - key
    def -=(key: String): JsonObject = proxy -= key
    def remove(key: String): Option[JsonObject] = proxy.remove(key) match {
        case Some(jsonObject: JsonObject) => Some(jsonObject)
        case _ => None
    }

    final def removeRecurcive(key: String) {
        proxy -= key
        proxy.foreach {
            _._2 match {
                case (obj: JsonObject) =>
                    obj -= key
                    obj removeRecurcive key
                case _ =>
            }
        }
    }

    def --=(xs: JsonObject): JsonObject = {
        proxy foreach {
            case (key, value) => if (value == xs) proxy remove key
        }
        proxy
    }

    def --(xs: JsonObject): JsonObject = clone --= xs

    def ++=(xs: JsonObject): JsonObject = {
        if (xs != null) {
            // logger trace (s"local value for ++= : ${JsBeautifier(JsonObject(proxy).toString())}")
            // logger trace (s"input value for ++= : ${JsBeautifier(xs.toString())}")

            xs foreach {
                case (key, value) => proxy.get(key) match {
                    case None => update(key, value)
                    case Some(jsonObject: JsonObject) => value match {
                        case mapValue: JsonObject => jsonObject ++= mapValue
                        case _ =>
                    }
                    case Some(jsonList: JsonList) => value match {
                        case mapValue: JsonList =>
                            // logger trace (s"jsonList: ${JsBeautifier(jsonList.toString())}")
                            // logger trace (s"mapValue: ${JsBeautifier(mapValue.toString())}")
                            jsonList ++= mapValue
                        case _ =>
                    }
                    case _ => update(key, value)
                }
            }
            // logger trace (s"output value for ++= : ${JsBeautifier(JsonObject(proxy).toString())}")
        }
        proxy
    }

    def ++(xs: JsonObject): JsonObject = {
        val res = clone()
        if (xs != null) {
            // logger trace (s"local value for ++= : ${JsBeautifier(res.toString)}")
            // logger trace (s"input value for ++= : ${JsBeautifier(xs.toString)}")

            xs foreach {
                case (key, value) => res.get(key) match {
                    case None => res.update(key, value)
                    case Some(jsonObject: JsonObject) => value match {
                        case mapValue: JsonObject => res.update(key, jsonObject.clone ++ mapValue)
                        case _ =>
                    }
                    case Some(jsonList: JsonList) => value match {
                        case mapValue: JsonList => res.update(key, jsonList.clone ++ mapValue)
                        case _ =>
                    }
                    case _ => res.update(key, value)
                }
            }
            // logger trace (s"output value for ++= : ${JsBeautifier(res.toString)}")
        }
        res
    }

    override def clone(): JsonObject = {
        new JsonObject(proxy.clone(), selfName, useSelfName)
    }

    def toString(formatter: JsonFormatter.funcFormatter) =
        useSelfName match {
            case false => "{" + proxy.map {
                case (key, value) =>
                    key.dblQuoted + ":" + formatter(value)
            }.mkString(",") + "}"

            case true => ModeNames + selfName + ".create({" + proxy.map {
                case (key, value) =>
                    key.dblQuoted + ":" + formatter(value)
            }.mkString(",") + "})"
        }

    def toString1(formatter: JsonFormatter.funcFormatter) =
        "{" + proxy.map {
            case (key, value) =>
                key.dblQuoted + ":" + formatter(value)
        }.mkString(s",") + "}"

    def toString2() =
        "{" + proxy.map {
            case (key, value) => JsonFormatter.defaultFormatter(key) + ":" + JsonFormatter.defaultFormatter(value)
        }.mkString(s",") + "}"

    override def toPrettyString = JsBeautifier(toString())

    def log(text: String = strEmpty, debug: Boolean = false) {
        val str = (newLine + s"${text}".space + toPrettyString)

        if (debug)
            logger debug str
        else
            logger trace str
    }

    override def equals(obj: Any): Boolean = {
        def check(jsonObject: JsonObject, jsonObject2: JsonObject, _res: Boolean): Boolean = {
            if (!_res) return _res
            var res = _res
            breakable {
                jsonObject foreach {
                    case (key, value) =>
                        jsonObject2.get(key) match {
                            case None =>
                                res = false
                                // logger trace (s"JsonObject equals: item with key '${key}' not found.")
                                break
                            case (Some(item)) =>
                                item match {
                                    case jo: JsonObject =>
                                        value match {
                                            case jov: JsonObject =>
                                                res = jov equals jo
                                                if (!res) {
                                                    // logger trace (s"JsonObject equals: items \n '${JsBeautifier(jov.toString)}' \n and \n '${JsBeautifier(jo.toString)}' \n not equal.")
                                                    break
                                                }
                                            case _ =>
                                                res = false
                                                // logger trace (s"JsonObject equals: items '${value}' end '${item}' different types can not be compared.")
                                                break
                                        }
                                    case jl: JsonList =>
                                        value match {
                                            case jlv: JsonList =>
                                                res = jlv equals jl
                                                if (!res) {
                                                    // logger trace (s"JsonObject equals: items \n '${JsBeautifier(jlv.toString)}' \n and \n '${JsBeautifier(jl.toString)}' \n not equal.")
                                                    break
                                                }
                                            case _ =>
                                                res = false
                                                // logger trace (s"JsonObject equals: items '${value}' end '${item}' different types can not be compared.")
                                                break
                                        }
                                    case _ =>
                                        res = ((value == null) && (item == null)) || (value equals item)
                                        if (!res) {
                                            // logger trace (s"JsonObject equals: items \n '${value}' \n and \n '${item}' \n not equal.")
                                            break
                                        }
                                }
                        }
                }
            }
            res
        }
        obj match {
            case jsonObject: JsonObject =>
                var res = canEqual(obj)
                res = check(proxy, jsonObject, res)
                res = check(jsonObject, proxy, res)
                res
            case _ =>
                false
        }
    }

    override def hashCode: Int = proxy.hashCode()

    def canEqual(obj: Any) = obj.isInstanceOf[JsonObject]

    def getValue2[T <: JsonElement, R](key: String)(implicit conv: JsonConverter2[T, R], ct: ClassTag[T], ct1: ClassTag[R]): Option[R] = {
        val res = proxy.get(key)
        // logger trace (s" getValue2 res: ${res} (${ct.toString})")
        res match {
            case Some(x: T) =>
                // logger trace (s"x: ${x}")
                // logger trace (s"x type: ${x.getClass.getSimpleName}")
                Some(conv.getValue(x))
            case y =>
                // logger trace (s"y type: ${y.getClass.getSimpleName}")
                None
        }
    }

    def getJsonElement(key: String): Option[JsonElement] = proxy.get(key)

    def getSCImgURL(key: String): Option[JsonElement] = proxy.get(key)

    def getString(key: String): String =
        proxy.get(key) match {
            case Some(JsonString(string)) => string.unQuoted
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getStringOpt(key: String): Option[String] =
        proxy.get(key) match {
            case Some(JsonString(string)) => Some(string.unQuoted)
            case _ => None
        }


    def getBlob(key: String): InputStream =
        proxy.get(key) match {
            case Some(JsonString(string)) => string.toInputStream
            case Some(x) => x.toString.toInputStream
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getBlobOpt(key: String): Option[InputStream] =
        proxy.get(key) match {
            case Some(JsonString(string)) => Some(string.toInputStream)
            case Some(x) => Some(x.toString.toInputStream)
            case _ => None
        }

    def getClob(key: String): String =
        proxy.get(key) match {
            case Some(JsonString(string)) => string
            case Some(x) => x.toString
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getClobOpt(key: String): Option[String] =
        proxy.get(key) match {
            case Some(JsonString(string)) => Some(string)
            case Some(x) => Some(x.toString)
            case _ => None
        }

    def getJson(key: String): String =
        proxy.get(key) match {
            case Some(JsonString(string)) => string//.unescapeJson
            case Some(x) => x.toString
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getJsonOpt(key: String): Option[String] =
        proxy.get(key) match {
            case Some(JsonString(string)) => Some(string/*.unescapeJson*/)
            case Some(x) => Some(x.toString)
            case _ => None
        }

    def getUnquotedString(key: String): UnquotedString =
        proxy.get(key) match {
            case Some(JsonUnquotedString(string)) => string
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getUnquotedStringOpt(key: String): Option[UnquotedString] =
        proxy.get(key) match {
            case Some(JsonUnquotedString(string)) => Some(string)
            case _ => None
        }

    def getBooleanOpt(key: String): Option[Boolean] =
        proxy.get(key) match {
            case Some(JsonBoolean(boolean)) => Some(boolean)
            case _ => None
        }

    def getBoolean(key: String): Boolean =
        proxy.get(key) match {
            case Some(JsonBoolean(boolean)) => boolean
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getLongOpt(key: String): Option[Long] =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => Some(bigDecimal.toLong)
            case Some(JsonLong(bigDecimal)) => Some(bigDecimal)
            case _ => None
        }

    def getLong(key: String): Long =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => bigDecimal.toLong
            case Some(JsonLong(bigDecimal)) => bigDecimal
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }


    def getIntOpt(key: String): Option[Int] =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => Some(bigDecimal.toInt)
            case Some(JsonInt(bigDecimal)) => Some(bigDecimal)
            case _ => None
        }

    def getInt(key: String): Int =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => bigDecimal.toInt
            case Some(JsonInt(bigDecimal)) => bigDecimal
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }


    def getDoubleOpt(key: String): Option[Double] =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => Some(bigDecimal.toDouble)
            case Some(JsonDouble(bigDecimal)) => Some(bigDecimal)
            case _ => None
        }

    def getDouble(key: String): Double =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => bigDecimal.toDouble
            case Some(JsonDouble(bigDecimal)) => bigDecimal
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getBigDecimalOpt(key: String): Option[BigDecimal] =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => Some(bigDecimal)
            case _ => None
        }

    def getBigDecimal(key: String): BigDecimal =
        proxy.get(key) match {
            case Some(JsonBigDecimal(bigDecimal)) => bigDecimal
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getDateTimeOpt(key: String): Option[DateTime] =
        proxy.get(key) match {
            case Some(JsonDateTime(dateTime)) => Some(dateTime)
            case Some(JsonString(string)) => Some(string.toDateTime())
            case _ => None
        }

    def getDateTime(key: String): DateTime =
        proxy.get(key) match {
            case Some(JsonDateTime(dateTime)) => dateTime
            case Some(JsonString(string)) => string.toDateTime()
            case x => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getLocalDateTimeOpt(key: String): Option[LocalDateTime] =
        proxy.get(key) match {
            case Some(JsonLocalDateTime(dateTime)) => Some(dateTime)
            case Some(JsonString(string)) => Some(string.replace("Z", "").toLocalDateTime())
            case _ => None
        }

    def getLocalDateTime(key: String): LocalDateTime =
        proxy.get(key) match {
            case Some(JsonLocalDateTime(dateTime)) => dateTime
            case Some(JsonString(string)) => string.replace("Z", "").toLocalDateTime()
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getJsonListOpt(key: String): Option[JsonList] =
        proxy.get(key) match {
            case Some(jsonList: JsonList) => Some(jsonList)
            case _ => None
        }

    def getJsonList(key: String): JsonList =
        proxy.get(key) match {
            case Some(jsonList: JsonList) => jsonList
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getJsonObjectOpt(key: String): Option[JsonObject] =
        proxy.get(key) match {
            case Some(jsonObject: JsonObject) => Some(jsonObject)
            case _ => None
        }

    def getJsonObject(key: String): JsonObject =
        proxy.get(key) match {
            case Some(jsonObject: JsonObject) => jsonObject
            case _ => throw new RuntimeException(s"Value with key: ${key} not found.")
        }

    def getBool(key: String): Bool = getValue2[JsonBoolean, Bool](key).get
    def getBoolOpt(key: String): Option[Bool] = getValue2[JsonBoolean, Bool](key)

    def getNumber(key: String): Number = getValue2[JsonBigDecimal, Number](key).get
    def getNumberOpt(key: String): Option[Number] = getValue2[JsonBigDecimal, Number](key)

    def getFunctionExpression(key: String): FunctionExpression = getValue2[JsonString, FunctionExpression](key)
    def getFunctionExpressionOpt(key: String): Option[FunctionExpression] = getValue2[JsonString, FunctionExpression](key)
    def getSerializedJsonList(key: String): JsonList = getValue2[JsonString, JsonList](key)
    def getSerializedJsonListOpt(key: String): Option[JsonList] = getValue2[JsonString, JsonList](key)
    def getSerializedJsonObject(key: String): JsonObject = getValue2[JsonString, JsonObject](key)
    def getSerializedJsonObjectOpt(key: String): Option[JsonObject] = getValue2[JsonString, JsonObject](key)

    def isEmpty = proxy isEmpty

    def getProxyObject = proxy.clone()
}

object JsonList {
    def apply(): JsonList = new JsonList()
    def apply(seq: JsonElement*): JsonList = {
        val res = JsonList()
        seq foreach (res += _)
        res
    }

    implicit def apply(proxy: ArrayBuffer[JsonElement]) = new JsonList(proxy)
    implicit def jsonList2Proxy(in: JsonList): ArrayBuffer[JsonElement] = in proxy
}

class JsonList(protected val proxy: ArrayBuffer[JsonElement]) extends JsonElement with JsonAbs {

    def this() = this(ArrayBuffer.empty[JsonElement])

    def apply(idx: Int) = proxy(idx)

    def getProxyList = proxy.clone()

    def exists(p: JsonElement => Boolean): Boolean = proxy exists p

    def toString(formatter: JsonFormatter.funcFormatter) =
        "[" + proxy.map(formatter).mkString(s",") + "]"

    def toString1(formatter: JsonFormatter.funcFormatter) =
        "[" + proxy.map(formatter).mkString(s",") + "]"


    def ++=(json: JsonList): JsonList = {
        json foreach (+= _)
        proxy
    }

    def +++=(json: JsonList): JsonList = {
        proxy += json
        proxy
    }

    def ++(json: JsonList): JsonList = clone ++= json

    override def clone: JsonList = proxy clone()

    override def toPrettyString = JsBeautifier(toString())

    def log {
        logger debug (newLine + toPrettyString)
    }

    def append(item: JsonElement) {
        proxy += item
    }

    def +=(item: JsonElement): JsonList = {
        var exists = false;
        var step = 0;
        breakable {
            this foreach {
                proxyItem =>
                    proxyItem match {
                        case pI: JsonObject =>
                            item match {
                                case pI1: JsonObject =>
                                    // logger trace (s"pI: ${JsBeautifier(pI.toString())}")
                                    // logger trace (s"pI1: ${JsBeautifier(pI1.toString())}")

                                    val id = pI.getStringOpt(s"idArrayItem").getOrElse(s"")
                                    val id1 = pI1.getStringOpt(s"idArrayItem").getOrElse(s"")
                                    val deleting = pI1.getBooleanOpt(s"deleteItem").getOrElse(false)

                                    // logger trace (s"id: ${id}")
                                    // logger trace (s"id1: ${id1}")
                                    // logger trace (s"deleting: ${deleting}")

                                    if ((id != "") && (id1 != ""))
                                        if (id == id1) {
                                            if (!deleting)
                                                pI ++= pI1
                                            else
                                                proxy remove step
                                            exists = true
                                            break
                                        }
                                case _ =>
                            }
                        case pI: JsonList =>
                            item match {
                                case pI1: JsonList =>
                                    pI ++= pI1
                                case _ =>
                            }
                        case _ =>
                    }
                    step += 1
            }
        }

        if (!exists)
            item match {
                case JsonString(str) => proxy += str.unQuoted.dblQuoted
                case _ => proxy += item
            }
        proxy
    }

    def +(item: JsonElement): JsonList = clone += item

    def distinct: JsonList = proxy.distinct

    override def equals(obj: Any): Boolean = {
        def check(jsonList: JsonList, jsonList2: JsonList, _res: Boolean): Boolean = {
            if (!_res) return _res
            var res = _res
            breakable {
                for (idx <- 0 to jsonList.length - 1) {
                    val item = jsonList(idx)
                    item match {
                        case jo: JsonObject =>
                            val value = jsonList2(idx)
                            value match {
                                case jov: JsonObject =>
                                    res = jo equals jov
                                    if (!res) {
                                        // logger trace (s"JsonObject equals: items \n ${JsBeautifier(jov.toString())} \n and \n ${JsBeautifier(jo.toString())} \n not equal.")
                                        break
                                    }
                                case _ =>
                                    res = false
                                    // logger trace (s"JsonObject equals: items ${value} end ${item} different types can not be compared.")
                                    break
                            }
                        case jl: JsonList =>
                            val value = jsonList2(idx)
                            value match {
                                case jlv: JsonObject =>
                                    res = jl equals jlv
                                    if (!res) {
                                        // logger trace (s"JsonObject equals: items \n ${JsBeautifier(jlv.toString())} \n and \n ${JsBeautifier(jl.toString())} \n not equal.")
                                        break
                                    }
                                case _ =>
                                    res = false
                                    // logger trace (s"JsonObject equals: items ${value} end ${item} different types can not be compared.")
                                    break
                            }
                        case _ =>
                            val a = jsonList2(idx)
                            res = item equals a
                            if (!res) {
                                // logger trace (s"JsonObject equals: items \n ${item} \n and \n ${a} \n not equal.")
                                break
                            }
                    }
                }
            }
            res
        }

        obj match {
            case jsonList: JsonList =>
                var res = canEqual(obj) && jsonList.length == length
                res = check(jsonList, proxy, res)
                res = check(proxy, jsonList, res)
                res
            case _ =>
                false
        }
    }

    def length = proxy length

    override def hashCode: Int = proxy.hashCode()
    def canEqual(obj: Any) = obj.isInstanceOf[JsonList]

    def -=(xs: JsonElement): JsonList = {
        xs match {
            case jsonObject: JsonObject =>
                // logger trace (s"xs: ${xs}")
                var i = 0
                breakable {
                    while (true) {
                        // logger trace (s"length: ${length}")
                        // logger trace (s"i: ${i}")

                        if (i == length)
                            break

                        var item = this (i)
                        // logger trace (s"item: ${item}")

                        item match {
                            case jsonObject1: JsonObject =>
                                val idArrayItem = jsonObject.getStringOpt(s"idArrayItem")
                                // logger trace (s"idArrayItem: ${idArrayItem.toString}")
                                val idArrayItem1 = jsonObject1.getStringOpt(s"idArrayItem")
                                // logger trace (s"idArrayItem1: ${idArrayItem1.toString}")

                                if (((idArrayItem != None && idArrayItem1 != None) && (idArrayItem.toString == idArrayItem1.toString)) || (jsonObject == jsonObject1))
                                    proxy remove i
                                else
                                    i += 1
                            case _ => i += 1
                        }
                    }
                }
            case jsonList: JsonList =>
                // logger trace (s"jsonList.length: ${jsonList.length}")
                for (i <- 0 until jsonList.length) {
                    this -= jsonList(i)
                }
            case _ =>
                var j = 0
                breakable {
                    while (true) {
                        // logger trace (s"length: ${length}")
                        if (j == length)
                            break

                        var item = this (j)

                        // logger trace (s"item: ${item}")
                        // logger trace (s"xs: ${xs}")
                        item match {
                            case jsonObject: JsonObject => j += 1
                            case jsonList: JsonList => j += 1
                            case x =>
                                if (x == xs) {
                                    // logger trace (s"j: ${j}")
                                    this remove j
                                } else
                                    j += 1
                        }
                    }
                }
        }
        this
    }

    def --(xs: JsonElement): JsonList = clone -= xs
}

case class JsonElements(elements: JsonElement*) extends JsonElement {
    override def toString: String = elements.map {
        _ match {
            case JsonString(str) => str.unQuoted.dblQuoted
            case any => any.toString
        }
    }.mkString(strEmpty)
}
