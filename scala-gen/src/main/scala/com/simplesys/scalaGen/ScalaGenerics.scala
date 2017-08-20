package com.simplesys.scalaGen

import com.simplesys.common.Strings._
import scala.collection.mutable.ArrayBuffer
import com.simplesys.common.equality.SimpleEquality._

abstract class AbstractScalaGeneric extends ScalaElement

abstract class AbstractScalaVarianceGeneric extends AbstractScalaGeneric

abstract class AbstractScalaBoundGeneric(nameGeneric: String, classGeneric: ScalaClassElement) extends AbstractScalaGeneric {
    val symbol: String

    def serrialize(indent: Int) = {
        if (classGeneric === ScalaEmptyClassElement)
            space + symbol.space + nameGeneric
        else
            space + symbol.space + classGeneric.serrialize(indent)
    }
}

abstract class AbstractScalaUpperBoundGeneric(nameGeneric: String, classGeneric: ScalaClassElement) extends AbstractScalaBoundGeneric(nameGeneric, classGeneric)
abstract class AbstractScalaLowerBoundGeneric(nameGeneric: String, classGeneric: ScalaClassElement) extends AbstractScalaBoundGeneric(nameGeneric, classGeneric)
abstract class AbstractScalaViewBoundGeneric(nameGeneric: String, classGeneric: ScalaClassElement) extends AbstractScalaBoundGeneric(nameGeneric, classGeneric)
abstract class AbstractScalaContextBoundGeneric(nameGeneric: String, classGeneric: ScalaClassElement) extends AbstractScalaBoundGeneric(nameGeneric, classGeneric)


case object CovariantScalaVarianceGeneric extends AbstractScalaVarianceGeneric {
    def serrialize(indent: Int) = "+"
}

case object ContrvariantScalaVarianceGeneric extends AbstractScalaVarianceGeneric {
    def serrialize(indent: Int) = "-"
}

case object NonevariantScalaVarianceGeneric extends AbstractScalaVarianceGeneric {
    def serrialize(indent: Int) = ""
}

case object NoneScalaGeneric extends AbstractScalaGeneric {
    def serrialize(indent: Int) = ""
}

case object NoneScalaBoundGeneric extends AbstractScalaBoundGeneric("", ScalaEmptyClassElement) {
    override def serrialize(indent: Int) = ""
    val symbol = ""
}

case object NoneScalaUpperBoundGeneric extends AbstractScalaUpperBoundGeneric("", ScalaEmptyClassElement) {
    override def serrialize(indent: Int) = ""
    val symbol = ""
}

case object NoneScalaLowerBoundGeneric extends AbstractScalaLowerBoundGeneric("", ScalaEmptyClassElement) {
    override def serrialize(indent: Int) = ""
    val symbol = ""
}

case object NoneScalaViewBoundGeneric extends AbstractScalaViewBoundGeneric("", ScalaEmptyClassElement) {
    override def serrialize(indent: Int) = ""
    val symbol = ""
}

case object NoneScalaContextBoundGeneric extends AbstractScalaContextBoundGeneric("", ScalaEmptyClassElement) {
    override def serrialize(indent: Int) = ""
    val symbol = ""
}

object ScalaUpperBound {
    def apply(classGeneric: ScalaClassElement): ScalaUpperBound = ScalaUpperBound("", classGeneric)
}

case class ScalaUpperBound(nameGeneric: String, classGeneric: ScalaClassElement = ScalaEmptyClassElement) extends AbstractScalaUpperBoundGeneric(nameGeneric, classGeneric) {
    val symbol: String = "<:"
}

object ScalaLowerBound {
    def apply(classGeneric: ScalaClassElement): ScalaLowerBound = ScalaLowerBound("", classGeneric)
}

case class ScalaLowerBound(nameGeneric: String, classGeneric: ScalaClassElement = ScalaEmptyClassElement) extends AbstractScalaLowerBoundGeneric(nameGeneric, classGeneric) {
    val symbol: String = ">:"
}

object ScalaViewBound {
    def apply(classGeneric: ScalaClassElement): ScalaViewBound = ScalaViewBound("", classGeneric)
}

case class ScalaViewBound(nameGeneric: String, classGeneric: ScalaClassElement = ScalaEmptyClassElement) extends AbstractScalaViewBoundGeneric(nameGeneric, classGeneric) {
    val symbol: String = "<%"
}

object ScalaContextBound {
    def apply(classGeneric: ScalaClassElement): ScalaContextBound = ScalaContextBound("", classGeneric)
}

case class ScalaContextBound(nameGeneric: String, classGeneric: ScalaClassElement = ScalaEmptyClassElement) extends AbstractScalaContextBoundGeneric(nameGeneric, classGeneric) {
    val symbol: String = ":"
}

case class ScalaAnyInGeneric(any: String) extends AbstractScalaGeneric {
    def serrialize(indent: Int) = space + any
}

object NameGeneric {
    implicit def strToNameGeneric(str: String): NameGeneric = NameGeneric(str, NonevariantScalaVarianceGeneric)
}

case class NameGeneric(name: String, variance: AbstractScalaVarianceGeneric = NonevariantScalaVarianceGeneric) extends AbstractScalaGeneric {
    def serrialize(indent: Int) = variance.serrialize(indent) + name
}

object ScalaNullGeneric extends AbstractScalaGeneric {
    def serrialize(indent: Int) = ""
}

object ScalaGeneric {
    def apply(name: NameGeneric,
              viewGeneric: AbstractScalaViewBoundGenerics): ScalaGeneric =
        new ScalaGeneric(
            name,
            ScalaNullGeneric,
            NoneScalaUpperBoundGeneric,
            NoneScalaLowerBoundGeneric,
            viewGeneric,
            Seq.empty[AbstractScalaContextBoundGeneric])

    def apply(name: NameGeneric,
              upperGeneric: AbstractScalaUpperBoundGeneric = NoneScalaUpperBoundGeneric,
              lowerGeneric: AbstractScalaLowerBoundGeneric = NoneScalaLowerBoundGeneric): ScalaGeneric =
        new ScalaGeneric(
            name,
            ScalaNullGeneric,
            upperGeneric,
            lowerGeneric,
            Seq.empty[AbstractScalaViewBoundGeneric],
            Seq.empty[AbstractScalaContextBoundGeneric])

    def apply(name: NameGeneric, generic: ScalaGeneric): ScalaGeneric =
        new ScalaGeneric(
            name,
            generic,
            NoneScalaUpperBoundGeneric,
            NoneScalaLowerBoundGeneric,
            Seq.empty[AbstractScalaViewBoundGeneric],
            Seq.empty[AbstractScalaContextBoundGeneric])

    def apply(name: NameGeneric, generic: ScalaGenerics): ScalaGeneric =
        new ScalaGeneric(
            name,
            generic,
            NoneScalaUpperBoundGeneric,
            NoneScalaLowerBoundGeneric,
            Seq.empty[AbstractScalaViewBoundGeneric],
            Seq.empty[AbstractScalaContextBoundGeneric])


    implicit def strToScalaGeneric(str: String): ScalaGeneric = ScalaGeneric(NameGeneric(str, NonevariantScalaVarianceGeneric))
    implicit def nameGenericToScalaGeneric(nameGeneric: NameGeneric): ScalaGeneric = ScalaGeneric(nameGeneric)
}

case class ScalaGeneric(name: NameGeneric,
                        generic: AbstractScalaGeneric,
                        upperGeneric: AbstractScalaUpperBoundGeneric,
                        lowerGeneric: AbstractScalaLowerBoundGeneric,
                        viewGeneric: AbstractScalaViewBoundGenerics,
                        contextGeneric: AbstractScalaViewBoundGenerics) extends AbstractScalaGeneric {
    def serrialize(indent: Int) = {
        var complex = false

        var gen = name.serrialize(indent)

        if (upperGeneric != NoneScalaUpperBoundGeneric) {
            gen += upperGeneric.serrialize(indent) + ", "
            complex = true
        }

        if (lowerGeneric != NoneScalaLowerBoundGeneric) {
            gen += lowerGeneric.serrialize(indent) + ", "
            complex = true
        }

        if (viewGeneric != NoneScalaViewBoundGeneric) {
            val res = new StringBuilder
            viewGeneric foreach (res append _.serrialize(indent))

            if (res.size > 0) {
                gen += res.toString
                complex = true
            }

        }

        if (contextGeneric != NoneScalaContextBoundGeneric) {

            val res = new StringBuilder
            contextGeneric foreach (res append _.serrialize(indent))

            if (res.size > 0) {
                gen += res.toString
                complex = true
            }
        }

        def get: String = {
            generic match {
                case x: ScalaGeneric => gen + "[" + delLastComma(generic.serrialize()) + "]"
                case x: ScalaGenerics => gen + delLastComma(generic.serrialize())
            }
        }
        if (!complex) {
            if (generic === ScalaNullGeneric)
                gen + ", "
            else
                get + ", "
        }
        else if (generic === ScalaNullGeneric)
            gen
        else
            get
    }
}

case class ScalaGenerics(generics: ScalaGeneric*) extends AbstractScalaGeneric {
    private val _generics = ArrayBuffer(generics: _*)

    def getSeq = _generics

    def +=(generic: ScalaGeneric) {
        _generics += generic
    }

    def ++=(generics: ScalaGeneric*) {
        _generics ++= generics
    }

    def ++=(generics: ScalaGenerics) {
        _generics ++= generics.getSeq
    }

    def serrialize(indent: Int) = {
        val res = new StringBuilder
        _generics foreach (res append _.serrialize(indent))

        if (res.length > 0)
            "[" + delLastComma(res.toString) + "]"
        else
            ""
    }
}

