package com.simplesys.scalaGen

import java.io.File

import org.scalatest.FunSuite
import com.simplesys.common.Strings._
import com.simplesys.log.Logging

import scala.collection.mutable.ArrayBuffer

class TestSuit1 extends FunSuite with Logging{
    test("MainConstructorClass") {
        def genThisFunctions(outputDir: File, maxArity: Int): Seq[File] = {
            val res = ArrayBuffer.empty[File]

            def genFunction(arr: Int): File = {
                val res = new File(outputDir.getAbsolutePath + s"ThisFunctionSS${arr}.scala")

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
                    scalaClassGen = s"ThisFunction${arr}SS".cls
                    typeScalaClass = TypeScalaTrait
                    extensibleClass = s"Function${arr}${tTypes.serrialize(0)}".ext
                    generics = tContrvarianfTypes
                }

                productTrait.addMember(
                    ScalaMethod(
                        name = "toString",
                        body = s"<this_function$arr>".dblQuoted.body,
                        serrializeToOneString = true,
                        `type` = ScalaString
                    )
                )


                println(productTrait.serrialize(10))
                /*res <== {
                    out =>
                        out(genMessageCreating("GeneratorThisFunctions"))
                        out(newLine)
                        out(newLine)
                        out(module.serrialize())
                }*/
                res
            }

            for (arr <- 0 to maxArity) {
                res += genFunction(arr)
            }

            res
        }

        genThisFunctions(outputDir = new File("/home/andrew/JOB/simplesys/scala-gen/src/test/scala/com/simplesys/scalaGen/res"), maxArity = 2)
    }
}
