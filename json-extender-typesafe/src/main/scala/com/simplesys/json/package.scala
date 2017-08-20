package com.simplesys

import java.io.InputStream
import java.math.{BigDecimal ⇒ JBigDecimal}

import com.simplesys.common.Strings._
import com.simplesys.isc.system.misc._
import com.simplesys.log.Logging
import org.joda.time.{DateTime, LocalDateTime}

import scala.util.{Failure, Success}

package object json extends Logging {

    implicit def stringToJsonBigDecimal(string: String) = new {
        val toJsonBigDecimal = JsonBigDecimal(new java.math.BigDecimal(string))
    }

    implicit def stringToJsonBoolean(string: String) = new {
        val toJsonBoolean = JsonBoolean(string.toBoolean)
    }

    implicit def stringToJsonString(string: String) = new {
        val toJsonString = JsonString(string)
    }

    implicit def jsonElement2String(value: JsonElement): String = {
        value match {
            case JsonString(str) => str.unQuoted
            case JsonUnquotedString(str) => str.toString()
            case _ => strEmpty
        }
    }
    implicit def string2JsonElement(value: String): JsonElement = JsonString(value)
    implicit def string2JsonElement1(value: String): Option[JsonElement] = Some(JsonString(value))
    implicit def string2JsonElement2(value: Option[String]): Option[JsonElement] = value match {
        case Some(x: String) => Some(JsonString(x))
        case _ => None
    }
    implicit def boolean2JsonElement(value: Boolean): JsonElement = JsonBoolean(value)
    implicit def boolean2JsonElement1(value: Boolean): Option[JsonElement] = Some(JsonBoolean(value))
    implicit def boolean2JsonElement2(value: Option[Boolean]): Option[JsonElement] = value match {
        case Some(x: Boolean) => Some(JsonBoolean(x))
        case _ => None
    }
    //implicit def boolean2JsonElement3(value: Array[Boolean]): Option[JsonElement] = if (value.length == 0) None else Some(JsonBoolean(value.head))

    implicit def xPathExpression2JsonElement(value: XPathExpression): JsonElement = JsonString(value.toString)
    implicit def urn2JsonElement(value: URN): JsonElement = JsonURN(value)
    implicit def url2JsonElement(value: URL): JsonElement = JsonURL(value)
    implicit def date2JsonElement(value: Date): JsonElement = JsonString(value.toString)
    implicit def date2JsonElement(value: Time): JsonElement = JsonString(value.toString)
    implicit def relativeData2JsonElement(value: RelativeDate): JsonElement = JsonString(value.toString)
    implicit def sCClassNameJsonElement(value: SCClassName): JsonElement = JsonString(value.toString)
    implicit def colorJsonElement(value: Color): JsonElement = JsonString(value.toString)

    implicit def int2JsonElement(value: Int): JsonElement = JsonInt(value)
    implicit def int2JsonElement1(value: Int): Option[JsonElement] = Some(JsonInt(value))
    implicit def int2JsonElement2(value: Option[Int]): Option[JsonElement] = value.map(JsonInt(_))
    //implicit def int2JsonElement3(value: Array[Int]): Option[JsonElement] = if (value.length == 0) None else Some(JsonInt(value.head))

    implicit def double2JsonElement(value: Double): JsonElement = JsonDouble(value)
    implicit def double2JsonElement1(value: Double): Option[JsonElement] = Some(JsonDouble(value))
    implicit def double2JsonElement2(value: Option[Double]): Option[JsonElement] = value.map(JsonDouble(_))
    //implicit def double2JsonElement3(value: Array[Double]): Option[JsonElement] = if (value.length == 0) None else Some(JsonDouble(value.head))

    implicit def long2JsonElement(value: Long): JsonElement = JsonLong(value)
    implicit def long2JsonElement1(value: Long): Option[JsonElement] = Some(JsonLong(value))
    implicit def long2JsonElement2(value: Option[Long]): Option[JsonElement] = value.map(JsonLong(_))
    //implicit def long2JsonElement3(value: Array[Long]): Option[JsonElement] = if (value.length == 0) None else Some(JsonLong(value.head))

    implicit def bigDecimal2JsonElement(value: BigDecimal): JsonElement = JsonBigDecimal(value)
    implicit def bigDecimal2JsonElement1(value: BigDecimal): Option[JsonElement] = Some(JsonBigDecimal(value))
    implicit def bigDecimal2JsonElement2(value: Option[BigDecimal]): Option[JsonElement] = value match {
        case Some(x: BigDecimal) =>
            logger trace (s"value: ${value}")
            Some(JsonBigDecimal(x))
        case _ => None
    }

    implicit def bigInt2JsonElement(value: BigInt): JsonElement = JsonBigInt(value)
    implicit def bigInt2JsonElement1(value: BigInt): Option[JsonElement] = Some(JsonBigInt(value))
    implicit def bigInt2JsonElement2(value: Option[BigInt]): Option[JsonElement] = value match {
        case Some(x: BigInt) =>
            logger trace (s"value: ${value}")
            Some(JsonBigInt(x))
        case _ => None
    }

    implicit def jsonObjOpt2JsonObject(value: Option[JsonObject]): JsonObject = value match {
        case Some(x) => x
        case None => JsonObject()
    }

    implicit def jsonListOpt2JsonList(value: Option[JsonList]): JsonList = value match {
        case Some(x) => x
        case None => JsonList()
    }

    implicit def jsonFuncExprOpt2JsonFuncExpr(value: Option[FunctionExpression]): FunctionExpression = value match {
        case Some(x) => x
        case None => FunctionExpression(StrMethodExp(strEmpty))
    }

    implicit def jsonElemOpt2JsonElem(value: Option[JsonElement]): JsonElement = value match {
        case Some(x: JsonElement) => x
        case None => JsonEmpty
    }

    implicit def jBigDecimal2JsonElement(value: JBigDecimal): JsonElement = JsonBigDecimal(value)
    implicit def jBigDecimal2JsonElement1(value: JBigDecimal): Option[JsonElement] = Some(JsonBigDecimal(value))
    implicit def jBigDecimal2JsonElement2(value: Option[JBigDecimal]): Option[JsonElement] = value match {
        case Some(x: JBigDecimal) =>
            logger trace (s"value: ${value}")
            Some(JsonBigDecimal(x))
        case _ => None
    }

    implicit def unquotedString2JsonElement(value: UnquotedString): JsonElement = JsonUnquotedString(value)
    implicit def unquotedString2JsonElement1(value: UnquotedString): Option[JsonElement] = Some(JsonUnquotedString(value))
    implicit def stringMethod2JsonElement(value: StringMethod): JsonElement = JsonStringMethod(value)
    implicit def stringOpt2JsonString(value: Option[String]): JsonString = value match {
        case Some(x: String) => JsonString(x)
        case None => JsonString(strEmpty)
    }

    implicit def bool2JsonElement(bool: Bool): JsonElement = {
        logger trace (s"update String data {${bool}}")
        bool match {
            case Bool(t) => t match {
                case null =>
                    JsonNull
                case boolean: Boolean =>
                    JsonBoolean(boolean)
                case boolean: java.lang.Boolean =>
                    JsonBoolean(boolean)
            }
        }
    }

    implicit def boolToBoolean(value: Bool) = new {
        val asBoolean: Boolean = value match {
            case Bool(t) => t match {
                case null =>
                    false
                case boolean: Boolean =>
                    boolean
                case _ =>
                    false
            }
        }
    }

    implicit def number2JsonElement(number: Number): JsonElement = {
        logger trace (s"update Number data {${number}}")
        try {
            if (number.toString.contains(s"fnk")) //Не убирать !!!!!!
                JsonUnquotedString(number.toString.dropRight(3).unq)
            if (number.toString.contains(s"_unq")) //Не убирать !!!!!!
                JsonUnquotedString(number.toString.dropRight(4).unq)
            else if (number.toString.last == '%')
                JsonString(number.toString)
            else if (number.toString.indexOf(s".") != -1)
                JsonBigDecimal(number.toBigDecimal)
            else
                JsonBigDecimal(number.toBigDecimal)
        }
        catch {
            case ex: NumberFormatException =>
                JsonString(number.toString)
        }
    }

    implicit def functionExpression2JsonElement(functionExpression: FunctionExpression): JsonElement = {
        logger trace (s"update FunctionExpression data {${functionExpression}}")
        JsonUnquotedString(functionExpression.getExpr)
    }

    implicit def StringFunctionExpression2StringJsonElement(element: (String, FunctionExpression)): (String, JsonElement) = {
        element match {
            case (str, func) => (str, func)
        }
    }

    implicit def StringString2StringJsonElement(element: (String, String)): (String, JsonElement) = {
        element match {
            case (str1, str2) => (str1, str2)
        }
    }

    implicit def StringUnquotedString2StringJsonElement(element: (String, UnquotedString)): (String, JsonElement) = {
        element match {
            case (str, unq) => (str, unq)
        }
    }

    implicit def dateTime2JsonElement(value: DateTime): JsonElement = JsonDateTime(value)
    implicit def dateTime2JsonElement1(value: DateTime): Option[JsonElement] = Some(JsonDateTime(value))
    implicit def dateTime2JsonElement2(value: Option[DateTime]): Option[JsonElement] = value match {
        case Some(x: DateTime) =>
            logger trace (s"value: ${value}")
            Some(JsonDateTime(x))
        case _ => None
    }

    implicit def localDateTime2JsonElement(value: LocalDateTime): JsonElement = JsonLocalDateTime(value)
    implicit def localDateTime2JsonElement1(value: LocalDateTime): Option[JsonElement] = Some(JsonLocalDateTime(value))
    implicit def localDateTime2JsonElement2(value: Option[LocalDateTime]): Option[JsonElement] = value match {
        case Some(x: LocalDateTime) =>
            logger trace (s"value: ${value}")
            Some(JsonLocalDateTime(x))
        case _ => None
    }

    implicit def inputStream2JsonString(value: InputStream): JsonElement = JsonString(value.asString)
    implicit def inputStream2OptJsonString(value: InputStream): Option[JsonElement] = Some(JsonString(value.asString))
    implicit def inputStream2OptJsonString(value: Option[InputStream]): Option[JsonElement] = value.map(item => JsonString(item.asString))

    implicit class JsonListOpts(jsonList: JsonList) {
        def toListString: List[String] = jsonList.getProxyList.map {
            case item: JsonString => item.value.unQuoted
            case _ => strEmpty
        }.filter(_ != "").toList
    }

    implicit class JsonListOptOpts(jsonList: Option[JsonList]) {
        def toOptListString: Option[List[String]] = jsonList match {
            case None => None
            case Some(list) => Some(list.toListString)
        }
    }

    implicit class JsonStringOpts(str: String) {
        def toJson: JsonElement = {
            str.asLongTry match {
                case Success(long) =>
                    JsonLong(long)
                case Failure(_) =>
                    str.asNumberTry match {
                        case Success(number) =>
                            JsonBigDecimal(number)
                        case Failure(_) => str.asBooleanTry match {
                            case Success(boolean) => JsonBoolean(boolean)
                            case Failure(_) if str == "null" =>
                                JsonNull
                            case Failure(_) =>
                                JsonString(str.unQuoted.dblQuoted)
                        }
                    }
            }
        }
    }
}
