package com.simplesys.jdbc

import com.simplesys.common.Strings._
import com.simplesys.genSources._
import com.simplesys.io._
import com.simplesys.scalaGen._
import sbt.File

import scala.collection.mutable.ArrayBuffer

object GeneratorTuples {
    def genTuples(outputDir: File, maxArity:Int): Seq[File] = {
        val res = ArrayBuffer.empty[File]
        import scalax.file.ImplicitConversions._

        def genTuple(arr: Int): File = {
            val res = (outputDir.getAbsolutePath / s"TupleSS${arr}.scala").createFile(failIfExists = false).toFile

            val tTypes = ScalaGenerics()
            for (i <- 1 to arr)
                tTypes += (s"T$i")

            val tCovarianfTypes = ScalaGenerics()
            for (i <- 1 to arr)
                tCovarianfTypes += ScalaGeneric(NameGeneric(s"T$i", CovariantScalaVarianceGeneric))

            //<editor-fold desc="productObject">
            val productObject = new ScalaClassDeclare {
                scalaClassGen = s"ProductSS${arr}".cls
                typeScalaClass = TypeScalaObject
            }

            productObject.addMember(
                ScalaMethod(
                    name = "unapply",
                    body = "Some(x)".body,
                    generics = tTypes,
                    serrializeToOneString = true,
                    `type` = ScalaClassGenericType(ScalaBaseClassDeclare("Option".cls, ScalaGeneric(s"ProductSS${arr}", tTypes))),
                    parametrs = ScalaClassParametrs(ScalaClassParametr(name = "x", `type` = ScalaClassGenericType(ScalaBaseClassDeclare(s"ProductSS${arr}".cls, tTypes))))
                )
            )
            //</editor-fold>


            //<editor-fold desc="productTrait">
            val productTrait = new ScalaClassDeclare {
                scalaClassGen = s"ProductSS${arr}".cls
                typeScalaClass = TypeScalaTrait
                extensibleClass = "Any".ext
                withTraits = ScalaWithTraits(ScalaTraitProduct)
                generics = tCovarianfTypes
            }

            val caseTrait = ScalaCase(expression = "n".expr)
            for (i <- 1 to arr)
                caseTrait += ScalaCaseLine(
                    expression = s"$i".expr,
                    caseBody = s"_$i".body,
                    serrializeToOneString = true
                )

            caseTrait += ScalaCaseLine(
                expression = "_".expr,
                caseBody = "throw new IndexOutOfBoundsException(n.toString())".body,
                serrializeToOneString = true
            )

            productTrait.addMembers(
                ScalaMethod(
                    name = "productArity",
                    body = s"$arr".body,
                    serrializeToOneString = true,
                    `override` = OverrideMofificator
                ),
                newLine,
                ScalaMethod(
                    name = "productElement",
                    body = ScalaBody(caseTrait),
                    serrializeToOneString = true,
                    `override` = OverrideMofificator,
                    parametrs = ScalaClassParametrs(ScalaClassParametr(name = "n", `type` = ScalaInt))
                ),
                newLine
            )

            for (i <- 1 to arr) {
                productTrait addMember ScalaMethod(name = s"_$i", `type` = s"T$i".tp, body = ScalaNoBody)
            }
            //</editor-fold>

            //<editor-fold desc="tupleCaseClass">

            val _parametrs: ScalaClassParametrs = ScalaClassParametrs()
            for (i <- 1 to arr)
                _parametrs += ScalaClassParametr(name = s"_$i", `type` = s"T$i".tp)

            val tupleCaseClass = new ScalaClassDeclare {
                scalaClassGen = s"TupleSS${arr}".cls
                typeScalaClass = TypeScalaCaseClass
                extensibleClass = ScalaClassGenericExtensible(new ScalaBaseClassDeclare {
                    scalaClassGen = s"ProductSS$arr".cls
                    generics = tTypes
                })
                generics = tCovarianfTypes
                parametrs = _parametrs
            }

            val _body = new StringBuilder("(".dblQuoted.space)
            for (i <- 1 to arr) {
                _body append "+".space
                _body append s"_$i".space
                _body append "+".space
                if (i != arr)
                    _body append ",".space.dblQuoted.space
            }
            _body append ")".dblQuoted

            tupleCaseClass addMember ScalaMethod(
                name = "toString",
                body = _body.toString().body,
                serrializeToOneString = true,
                `override` = OverrideMofificator
            )
            //</editor-fold>

            val module = new ScalaModule(
                "com.simplesys.tuple".pkg,
                newLine,
                productObject,
                newLine,
                newLine,
                productTrait,
                newLine,
                newLine,
                tupleCaseClass
            )

            res <== {
                out =>
                    out(genMessageCreating("GeneratorTuples"))
                    out(newLine)
                    out(newLine)
                    out(module.serrialize())
            }

            res
        }

        for (arr <- 1 to maxArity) {
            res += genTuple(arr)
        }

        res
    }
}