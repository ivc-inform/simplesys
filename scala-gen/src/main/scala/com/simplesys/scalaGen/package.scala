package com.simplesys

import java.time.LocalDateTime

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._

import scala.xml.TypeSymbol

package object scalaGen {
    type AbstractScalaViewBoundGenerics = Seq[AbstractScalaBoundGeneric]

    val indentSize = 4
    val commentLength = 200

    implicit def str2ScalaStringElement(str: String): ScalaStringElement = new ScalaStringElement(str)
    implicit def str2ScalaStringElement(line: NewLine.type): ScalaStringElement = new ScalaStringElement(line.toString())
    /*implicit def scalaClassJSON2ScalaClassJSONPropertyClassJSON(x: ScalaClassJSON) = ScalaClassJSONPropertyClassJSON(x)*/

    implicit class OptsString(value: String) {
        def pkg = new ScalaPackage(value)
        def imp = new ScalaImport(value)
        def comment = new ScalaComment(value)
        def endComment = new ScalaEndComment(value)
        def str = new ScalaClassJSONPropertyString(value)
        def dblQuotedValue = new ScalaClassJSONPropertyDblQuotedValue(value)
        def JSCodeValue = new ScalaClassJSONPropertyJSCode(value)
        def URLValue = new ScalaClassJSONPropertyURLValue(value)
        def URLwithVarValue(variable: String) = new ScalaClassJSONPropertyURLwithVarValue(value, variable)
        def UnqValue = new ScalaClassJSONPropertyUnqValue(value)
        def EllipsisValue = new ScalaClassJSONPropertyEllipsisValue(value)
        def ApproxValue = new ScalaClassJSONPropertyApproxValue(value)
        def unQuotedValue = new ScalaClassJSONPropertyUnQuotedValue(value)
        def unQuotedValue1 = new ScalaClassJSONPropertyUnQuotedValue1(value)
        def body = new ScalaBody(value)
        def expr = new ScalaExpression(value)
        def ext = new ScalaClassExtensible(value)
        def tp = new ScalaType(value)
        def cls = new ScalaClassGen {
            def serrialize(indent: Int = 0) = spaces(indent) + value
        }
        def trt = new ScalaWithTrait {
            def serrialize(indent: Int = 0) = spaces(indent) + value
        }
    }

    implicit class OptsStringSeq(value: Seq[String]) {
        def body = new ScalaBody(value map (x => new ScalaStringElement(x)): _*)
    }

    implicit class OptsInt(value: Int) {
        def int = new ScalaClassJSONPropertyInt(value)
    }

    implicit class OptsDouble(value: Double) {
        def dbl = new ScalaClassJSONPropertyDouble(value)
    }

    implicit class OptsBoolean(value: Boolean) {
        def bln = new ScalaClassJSONPropertyBoolean(value)
    }

    implicit class OptsDateTime(value: LocalDateTime) {
        def dt = new ScalaClassJSONPropertyDate(value)
        def dtTm = new ScalaClassJSONPropertyDateTime(value)
    }

    implicit class Params2Opts(tuple: (String, AbstractScalaType)) {
        def param = new ScalaClassParametr(name = tuple._1, `type` = tuple._2)
    }

    implicit class Params21Opts(tuple: (String, String)) {
        def param = new ScalaClassInitParametr(key = tuple._1, value = tuple._2)
        def dblQuotedParam = new ScalaClassInitParametr(key = tuple._1, value = tuple._2.dblQuoted + ".dblQuoted")

        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.str)
        def dblQuotedProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.dblQuotedValue)
        def URLProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.URLValue)
        def URLwithVarProperty(variable: String) = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.URLwithVarValue(variable))
        def UnqProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.UnqValue)
        def EllipsisProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.EllipsisValue)
        def ApproximateProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.ApproxValue)
        def UnQuotedProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.unQuotedValue)
        def JSCodeProperty = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.JSCodeValue)
    }

    implicit class Params210Opts(tuple: (TypeSymbol, String)) {
        def param = new ScalaClassInitParametr(key = tuple._1.toString, value = tuple._2)
        def dblQuotedParam = new ScalaClassInitParametr(key = tuple._1.toString, value = tuple._2.dblQuoted + ".dblQuoted")
    }

    implicit class Params22Opts(tuple: (String, ScalaPropertyElement)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2)
    }

    implicit class Params28Opts(tuple: (String, ScalaClassJSON)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = ScalaClassJSONPropertyClassJSON(tuple._2))
    }

    implicit class Params24Opts(tuple: (String, Boolean)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.bln)
    }

    implicit class Params25Opts(tuple: (String, Int)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.int)
    }

    implicit class Params26Opts(tuple: (String, Double)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.dbl)
    }

    implicit class Params27Opts(tuple: (String, LocalDateTime)) {
        def property = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.dt)
        def propertyWithTm = ScalaClassJSONProperty(key = tuple._1, value = tuple._2.dtTm)
    }

    implicit class Params3Opts(tuple: (String, AbstractScalaType, ScalaParametr)) {
        def param = ScalaClassParametr(name = tuple._1, `type` = tuple._2, parametrType = tuple._3)
    }

    implicit class Params31Opts(tuple: (String, ScalaClassJSON)) {
        def `val` = ScalaVariable(name = tuple._1, body = ScalaBody(tuple._2))
    }

    implicit class VarOpts3(tuple: (String, AbstractScalaType)) {
        def `val` = ScalaVariable(name = tuple._1, `type` = tuple._2)
        def `var` = ScalaVariable(name = tuple._1, `type` = tuple._2)
    }

    implicit class VarOpts32(tuple: (String, ScalaBody)) {
        def `val` = ScalaVariable(name = tuple._1, body = tuple._2)
        def `var` = ScalaVariable(name = tuple._1, body = tuple._2)

        def protectedVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = ProtectedMofificator)
        def lazyProtectedVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = ProtectedMofificator, `lazy` = true)

        def privateVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = PrivateMofificator)
        def lazyPrivateVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = PrivateMofificator, `lazy` = true)

        def publicVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = PublicMofificator)
        def lazyPublicVal = ScalaVariable(name = tuple._1, body = tuple._2, modificator = PublicMofificator, `lazy` = true)
    }

    implicit class VarOpts4(tuple: (String, AbstractScalaType, ScalaBody)) {
        def `val` = ScalaVariable(name = tuple._1, `type` = tuple._2, body = tuple._3)
        def `var` = ScalaVariable(name = tuple._1, `type` = tuple._2, body = tuple._3)
    }

    implicit def scalaJSONProperies2ScalaJSONClasses(arr: ScalaClassJSONProperties): ScalaClassesJSON = {
        val res = ScalaClassesJSON()
        arr.getItems foreach {
            case ScalaClassJSONProperty(key, value) => value match {
                case ScalaClassJSONPropertyClassJSON(_class) =>
                    res += _class

                case ScalaClassJSONPropertyUnQuotedValue1(string) if string.contains("opId") =>
                    res += ScalaUnquotedStringElement1(s"OperatorId.${string.replace("opId", "").unCapitalize}")

                case _ =>
                    throw new RuntimeException(s"Не понятно что это за value : ${value}")
            }
            case any =>
                throw new RuntimeException(s"Не понятно что это за Item: ${any}")
        }
        res
    }

    implicit def scalaJSONProperies2ScalaJSONObjects(arr: ScalaClassJSONProperties): ScalaObjectsJSON = {
        val res = ScalaObjectsJSON()
        arr.getItems foreach {
            case ScalaClassJSONProperty(key, value) => value match {
                case ScalaClassJSONPropertyClassJSON(_class) =>
                    res += _class
                case ScalaClassJSONPropertyUnQuotedValue(string) =>
                    res += ScalaUnquotedStringElement(string)
                case ScalaClassJSONPropertyUnQuotedValue1(string) =>
                    res += ScalaUnquotedStringElement1(string)
                case _ =>
                    throw new RuntimeException(s"Не понятно что это за value: ${value}")
            }
            case any =>
                throw new RuntimeException(s"Не понятно что это за Item: ${any}")
        }
        res
    }

    def delLastComma(inPut: String): String = {
        val x = inPut.toString.trim
        if (x.lastIndexOf(",") === x.length - 1) x.substring(0, x.length - 1) else x
    }
}
