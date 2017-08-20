package com.simplesys.json

import com.simplesys.common.Strings._
import com.simplesys.genSources._
import com.simplesys.io._
import com.simplesys.scalaGen._
import sbt.File

import scala.collection.mutable.ArrayBuffer

object GeneratorThisFunctions {
    def genThisFunctions(outputDir: File, maxArity: Int): Seq[File] = {
        val res = ArrayBuffer.empty[File]
        import scalax.file.ImplicitConversions._

        def genFunction(arr: Int): File = {
            val res = (outputDir.getAbsolutePath / s"ThisFunctionSS${arr}.scala").createFile(failIfExists = false).toFile

            val tTypes = ScalaGenerics()
            for (i <- 1 to arr)
                tTypes += (s"T$i")
            tTypes += NameGeneric("R")

            val tCovarianfTypes = ScalaGeneric(NameGeneric("R", CovariantScalaVarianceGeneric))

            val tContrvarianfTypes = ScalaGenerics()
            for (i <- 1 to arr)
                tContrvarianfTypes += ScalaGeneric(NameGeneric(s"T$i", ContrvariantScalaVarianceGeneric))

            tContrvarianfTypes += tCovarianfTypes

            val productTrait = new ScalaClassDeclare {
                scalaClassGen = s"ThisFunctionSS${arr}".cls
                typeScalaClass = TypeScalaTrait
                extensibleClass = s"Function${arr}${tTypes.serrialize(0)}".ext
                generics = tContrvarianfTypes
            }

            productTrait.addMember(
                ScalaMethod(
                    name = "toString",
                    body = s"<this_function$arr>".dblQuoted.body,
                    serrializeToOneString = true,
                    `type` = ScalaString,
                    `override` = OverrideMofificator
                )
            )

            val module = new ScalaModule(
                "com.simplesys.json".pkg,
                newLine,
                productTrait
            )

            res <== {
                out =>
                    out(genMessageCreating("GeneratorThisFunctions"))
                    out(newLine)
                    out(newLine)
                    out(module.serrialize())
            }
            res
        }

        /*for (arr <- 0 to maxArity) {
                res += genFunction(arr)
            }*/

        res
    }
}
