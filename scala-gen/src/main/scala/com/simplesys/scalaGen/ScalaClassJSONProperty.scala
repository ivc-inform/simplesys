package com.simplesys.scalaGen

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.io._
import com.simplesys.javascript.JavaScript
import com.simplesys.log.Logging

import scala.collection.mutable.ArrayBuffer
import scala.io.Codec._
import scala.io.Source

abstract class ScalaPropertyElement extends ScalaElement

case object ScalaNullPropertyElement extends ScalaPropertyElement {
    def serrialize(indent: Int) = "Null Property"
}

case class ScalaClassJSONPropertyString(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted
}

object ScalaClassJSONPropertyJSCode extends Logging {
    val res = new StringBuilder
    var step = 0

    def makeRes(iterator: Iterator[String], indent: Int) {
        res.clear()
        step = 0

        iterator foreach {
            line =>
                if (step === 0)
                    res append line + newLine
                else
                    res append spaces(indent + 3) + line + newLine
                step = step + 1
        }
    }

    def getAllJSCode(filePath: String): String = {
        val path = filePath.asPath
        if (path.exists)
            Source.fromFile(path.toFile)(UTF8).getLines.mkString(newLine)
        else {
            logger warn s"Path $filePath not exists."
            strEmpty
        }
    }

    def getFunctionBlock(content: String, _funcName: String, indent: Int): String = {
        val res = JavaScript(content).getFunction(_funcName).trplQuotWrp + ".f"
        (res.split(newLine) map (item => spaces(indent) + item)).mkString(newLine).trim
    }
}

import com.simplesys.scalaGen.ScalaClassJSONPropertyJSCode._

case class ScalaClassJSONPropertyJSCode(path: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0): String = {
        val pos = path lastIndexOf "/"
        val _path = if (pos === -1) strEmpty else path.substring(0, pos)
        val _funcName = path.substring((path lastIndexOf "/") + 1)

        if ((_funcName.indexOf("(") !== -1) && (_funcName.indexOf(")") !== -1))
            (_funcName.substring(0, _funcName.indexOf("(")) + _funcName.substring(_funcName.indexOf(")") + 1)).trplQuotWrp + ".f"
        else
            getFunctionBlock(content = getAllJSCode(_path), _funcName = _funcName, indent = indent)
    }
}

case class ScalaClassJSONPropertyInt(value: Int) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.toString
}

case class ScalaClassJSONPropertyDouble(value: Double) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.toString
}

case class ScalaClassJSONPropertyBoolean(value: Boolean) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.toString
}

case class ScalaClassJSONPropertyDate(value: LocalDateTime) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).dblQuoted
}

case class ScalaClassJSONPropertyDateTime(value: LocalDateTime) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")).dblQuoted
}

case class ScalaClassJSONPropertyDblQuotedValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted + ".dblQuoted"
}

case class ScalaClassJSONPropertyURLValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted + ".url"
}

case class ScalaClassJSONPropertyURLwithVarValue(value: String, variable: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted + s".url(${variable})"
}

case class ScalaClassJSONPropertyUnqValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted + ".unq"
}

case class ScalaClassJSONPropertyEllipsisValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.dblQuoted + ".ellps"
}

case class ScalaClassJSONPropertyApproxValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = "s" + value.dblQuoted
}

case class ScalaClassJSONPropertyUnQuotedValue(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value
}

case class ScalaClassJSONPropertyUnQuotedValue1(value: String) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value
}

case class ScalaClassJSONPropertyClassJSON(value: ScalaClassJSON) extends ScalaPropertyElement {
    def serrialize(indent: Int = 0) = value.serrialize(indent)
}

case class ScalaClassJSONProperty(key: String, value: ScalaPropertyElement) extends ScalaPropertyElement {
    def _value(indent: Int = 0) = value match {
        case x: ScalaClassJSONPropertyString => x.serrialize(indent)
        case x: ScalaClassJSONPropertyJSCode => x.serrialize(indent)
        case x: ScalaClassJSONPropertyInt => x.serrialize(indent)
        case x: ScalaClassJSONPropertyDouble => x.serrialize(indent)
        case x: ScalaClassJSONPropertyBoolean => x.serrialize(indent)
        case x: ScalaClassJSONPropertyDate => x.serrialize(indent)
        case x: ScalaClassJSONPropertyDateTime => x.serrialize(indent)
        case x: ScalaClassJSONPropertyDblQuotedValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyURLValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyURLwithVarValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyUnqValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyEllipsisValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyApproxValue => x.serrialize(indent)
        case x: ScalaClassJSONPropertyUnQuotedValue => x.serrialize(indent)
        //case ScalaClassJSONPropertyClassJSON(x) => if (key.isEmpty) x.serrialize1(indent) else x.serrialize1(indent) // Не менять !!!
        case ScalaClassJSONPropertyClassJSON(x) => x.serrialize1(indent) // Поменял 08/12/13 !!!
        case _ => value.serrialize(indent)
    }

    def serrialize(indent: Int = 0) = spaces(indent) + (if (key.isEmpty) _value(indent) else key.space + "=".space + _value(indent))

}

object ScalaClassJSONProperties {
    def apply() = new ScalaClassJSONProperties()
    def apply(properties: ScalaClassJSONProperty*) = new ScalaClassJSONProperties(properties: _*)
}

class ScalaClassJSONProperties(properties: ScalaClassJSONProperty*) extends ScalaElement {
    private val _properties = ArrayBuffer(properties: _*)

    def isEmpty = _properties.isEmpty

    def +=(property: ScalaClassJSONProperty) {
        _properties += property
    }

    def ++=(properties: ScalaClassJSONProperty*) {
        _properties ++= properties
    }

    def ++=(properties: ScalaClassJSONProperties) {
        _properties ++= properties.getItems
    }

    def firstItem: ScalaPropertyElement = if (_properties.isEmpty) ScalaNullPropertyElement else _properties(0).value

    def getItems: Seq[ScalaClassJSONProperty] = _properties.toSeq

    def serrialize(indent: Int = 0) = (_properties map {
        _.serrialize(indent)
    }).mkString(newLine.toString)
}
