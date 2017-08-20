package com.simplesys.scalaGen

import com.simplesys.common.Strings._

import scala.collection.mutable.ArrayBuffer

case class ScalaClassInitParametr(key: String, value: String) extends ScalaElement {
    override def serrialize(indent: Int = 0) = spaces(indent) + key.space + "=".space + value
}

class ScalaClassInitParametrs(parametrs: ScalaClassInitParametr*) extends ScalaElement {
    private val _params = ArrayBuffer(parametrs: _*)

    def +=(parametr: ScalaClassInitParametr) {
        _params += parametr
    }

    def ++=(parametrs: ScalaClassInitParametr*) {
        _params ++= parametrs
    }

    def serrialize(indent: Int = 0) = {
        val res = (_params map (_.serrialize(indent))).mkString(",")
        if (!res.isEmpty)
            "(" + res + ")"
        else
            ""
    }
}

object ScalaClassInitParametrs {
    def apply() = new ScalaClassInitParametrs()
    def apply(parametrs: ScalaClassInitParametr*) = new ScalaClassInitParametrs(parametrs: _*)
}

class ScalaClassJSON extends ScalaObjectElement {
    var wrappadOperator = ""
    var scalaClassGen: ScalaClassGen = ScalaClassUnknown
    var parametrs: ScalaClassInitParametrs = ScalaClassInitParametrs()
    var properties: ScalaClassJSONProperties = ScalaClassJSONProperties()

    def addParameters(_parametrs: ScalaClassInitParametr*): ScalaClassJSON = {
        parametrs ++= (_parametrs: _*)
        this
    }

    def addProperties(_properties: ScalaClassJSONProperty*): ScalaClassJSON = {
        properties ++= (_properties: _*)
        this
    }

    def addProperties(_properties: ScalaClassJSONProperties): ScalaClassJSON = {
        properties ++= (_properties.getItems: _*)
        this
    }

    override def serrialize1(indent: Int = 0) = {
        val res = new StringBuilder
        //res append spaces(indent)
        if (wrappadOperator != "")
            res append wrappadOperator + "(new".space
        else
            res append "new".space
        res append scalaClassGen.serrialize().space
        res append {
            val res = parametrs.serrialize()
            if (res.isEmpty)
                ""
            else
                res.space
        }
        res append "{".newLine
        res append {
            val res = properties.serrialize(indent + indentSize)
            if (res.isEmpty)
                ""
            else
                res.newLine
        }
        res append spaces(indent)
        if (wrappadOperator != "")
            res append "})"
        else
            res append "}"
        res.toString
    }

    def serrialize(indent: Int = 0) = spaces(indent) + serrialize1(indent)
}

object ScalaClassesJSON {
    def apply(classes: ScalaClassJSON*) = new ScalaClassesJSON(classes: _*)
    def apply() = new ScalaClassesJSON()
}

class ScalaClassesJSON(classes: ScalaClassJSON*) extends ScalaObjectElement {
    private val _classes = ArrayBuffer.empty[ScalaObjectElement] ++ classes

    def +=(`class`: ScalaClassJSON) {
        _classes += `class`
    }

    def +=(`class`: ScalaObjectElement) {
        _classes += `class`
    }

    def ++=(classes: ScalaClassJSON*) {
        _classes ++= classes
    }

//    def ++=(classes: Seq[ScalaObjectElement]) {
//        _classes ++= classes
//    }

    def getItems = _classes.toSeq

    def serrialize(indent: Int = 0) = {
        (_classes map (item => item.serrialize(indent))).mkString(",".newLine)
    }
}


object ScalaObjectsJSON {
    def apply(classes: ScalaObjectElement*) = new ScalaObjectsJSON(classes: _*)
    def apply() = new ScalaObjectsJSON()
}

class ScalaObjectsJSON(classes: ScalaObjectElement*) extends ScalaObjectElement {
    private val _classes = ArrayBuffer(classes: _*)

    def +=(`class`: ScalaObjectElement) {
        _classes += `class`
    }

    def ++=(classes: ScalaObjectElement*) {
        _classes ++= classes
    }

    def getItems = _classes.toSeq

    def serrialize(indent: Int = 0) = {
        (_classes map (item => item.serrialize(indent))).mkString(",".newLine)
    }
}
