package com.simplesys.scalaGen

import com.simplesys.common.Strings._
import scala.collection.mutable.ArrayBuffer
import com.simplesys.common.equality.SimpleEquality._

case class ScalaAnnotation(name: String, elements: (String, String)*) extends ScalaElement {
    def serrialize(indent: Int) = {
        val res = elements.map(element => element._1.space + "=".space + element._2).mkString(",".space)

        (if (!res.isEmpty)
            spaces(indent) + s"@${name}(" + res + ")"
        else if (!name.isEmpty)
            spaces(indent) + s"@${name}"
        else
            name) + space
    }
}

object ScalaBaseClassDeclare {
    def apply(_scalaClassGen: ScalaClassGen, _generics: AbstractScalaGeneric) = new ScalaBaseClassDeclare {
        scalaClassGen = _scalaClassGen
        generics = _generics
    }

    def apply(_scalaClassGen: ScalaClassGen) = new ScalaBaseClassDeclare {
        scalaClassGen = _scalaClassGen
    }
}

class ScalaBaseClassDeclare extends ScalaClassElement {
    var scalaClassGen: ScalaClassGen = ScalaClassUnknown
    var generics: AbstractScalaGeneric = NoneScalaGeneric
    var baseParametrs: ScalaClassParametrs = ScalaClassParametrs()

    def serrialize(indent: Int) = {
        generics match {
            case x: NameGeneric => scalaClassGen.serrialize() + "[" + delLastComma(generics.serrialize(indent)) + "]"
            case x: ScalaGeneric => scalaClassGen.serrialize() + "[" + delLastComma(generics.serrialize(indent)) + "]"
            case _ => scalaClassGen.serrialize() + generics.serrialize(indent) + baseParametrs.serrialize(indent)
        }
    }
}

object ScalaClassDeclare {
    def apply(_scalaClassGen: ScalaClassGen, _withTraits: ScalaWithTraits): ScalaClassDeclare =
        new ScalaClassDeclare {
            scalaClassGen = _scalaClassGen
            withTraits = _withTraits
        }
}

class ScalaClassDeclare extends ScalaBaseClassDeclare {
    var annotation = ScalaAnnotation("")
    var parametrs: ScalaClassParametrs = ScalaClassParametrs()
    var parametrsImplicit: ScalaClassParametrs = ScalaClassParametrs()
    var modificatorScalaClass: ModificatorScalaClass = NoneModificatorScalaClass
    var extensibleClass: ExtensibleClass = ScalaClassUndefigned
    var withTraits: ScalaWithTraits = ScalaWithTraits()
    var members = ArrayBuffer.empty[ScalaElement]
    var typeScalaClass: ScalaClassType = TypeScalaClass
    var mainConstructorBody = ScalaBody()
    var wrappadOperator = strEmpty

    override def serrialize(indent: Int = 0) = {
        val res = new StringBuilder
        res append {
            val res = annotation.serrialize(indent)
            if (res.isEmpty) "" else res.newLine
        }
        res append spaces(indent)
        res append modificatorScalaClass.serrialize()
        res append s"${
            typeScalaClass.serrialize().space
        }${
            super.serrialize(indent)
        }${
            typeScalaClass match {
                case TypeScalaClass => parametrs.serrialize()
                case TypeScalaCaseClass => parametrs.serrialize()
                case AnonimousScalaClass => parametrs.serrialize()
                case _ => ""
            }
        }${
            typeScalaClass match {
                case TypeScalaClass => parametrsImplicit.serrialize()
                case TypeScalaCaseClass => parametrsImplicit.serrialize()
                case AnonimousScalaClass => parametrsImplicit.serrialize()
                case _ => ""
            }
        }${
            if (!extensibleClass.serrialize().isEmpty) space + "extends".space + extensibleClass.serrialize().space else ""
        }${withTraits.serrialize()} {".newLine
        members foreach {
            member =>
                member match {
                    case x: ScalaNullPropertyElement.type =>
                    case _ =>
                        res append member.serrialize(indent + indentSize)
                }
        }
        if (mainConstructorBody.length > 0) {
            res append newLine
            res append mainConstructorBody.serrialize(indent)
        }
        res append newLine + spaces(indent)
        res append "}"

        val _res = res.toString()
        val __res = if (_res.last === newLine.last)
            _res.toString.substring(0, _res.toString().length - 1)
        else
            _res

        if (wrappadOperator == strEmpty)
            __res
        else
            s"${wrappadOperator}(${__res})"
    }

    def addMember(member: ScalaElement): ScalaClassDeclare = {
        if (members.size > 0 && members(members.length - 1).serrialize() != newLine) {
            members += newLine
        }
        members += member
        this
    }

    def addMembers(_members: ScalaElement*): ScalaClassDeclare = {
        _members foreach addMember
        this
    }

    def ++=(_members: Seq[ScalaElement]): ScalaClassDeclare = {
        addMembers(_members: _*)
    }

    def setParametrs(parametrs: ScalaClassParametrs) {
        this.parametrs = parametrs
    }

    def setTraits(traits: ScalaWithTraits) {
        this.withTraits = traits
    }

    def setExtensibleClass(extensibleClass: ExtensibleClass) {
        this.extensibleClass = extensibleClass
    }
}

