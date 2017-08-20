package com.simplesys.jdbc.control

import org.scalatest.FunSuite
import com.simplesys.log.Logging
import com.simplesys.scalaGen._
import com.simplesys.common.Strings._
import scala.collection.mutable.ArrayBuffer
import java.io.File
import com.simplesys.common.equality.SimpleEquality._

class TestSuperTupleGen extends FunSuite with Logging {

    test("genSuperTuple") {
        /*val maxArity = 22

        val traitFieldProduct = new ScalaClassDeclare {
            scalaClassGen = "FieldProduct".cls
            modificatorScalaClass = SealedModificatorScalaClass
            typeScalaClass = TypeScalaTrait
            generics = ScalaGenerics(ScalaGeneric("TableType", ScalaUpperBound(ScalaBaseClassDeclare("Table".cls, ScalaGeneric("TableType")))))
        }

        traitFieldProduct addMembers(
          ScalaAliasType(name = "ReturnType", body = ScalaNoBody, `type` = ScalaProduct, symbolType = UpperBoundTypeSymbol),
          ScalaMethod(name = "fields", body = ScalaNoBody, `type` = ScalaClassGenericType(ScalaBaseClassDeclare("List".cls, ScalaGeneric("BasicColumn", ScalaGenerics("TableType", "_"))))),
          ScalaMethod(name = "fieldProduct", body = ScalaNoBody, `type` = ScalaProduct),
          ScalaMethod(name = "buildResult", body = ScalaNoBody, `type` = "ReturnType".tp, parametrs = ScalaClassParametrs(("rs", ScalaResultSet).param))
          )

        def getMyTupe(arr: Int): ScalaClassDeclare = {
            val aTypes = ScalaGenerics()
            for (i <- 1 to arr)
                aTypes += ("A" + i.toString)

            val _generics = ScalaGenerics(ScalaGeneric("TableType", ScalaUpperBound(ScalaBaseClassDeclare("Table".cls, ScalaGeneric("TableType")))))
            _generics ++= aTypes

            val _parametrs: ScalaClassParametrs = ScalaClassParametrs()
            for (i <- 1 to arr)
                _parametrs += ScalaClassParametr(name = "a" + i.toString, `type` = ("A" + i.toString).tp)

            val returnTypeBody = new ScalaBaseClassDeclare {
                scalaClassGen = ("Tuple" + arr.toString).cls
                generics = aTypes
            }

            val _generics1 = ScalaGenerics()
            for (i <- 1 to arr)
                _generics1 += ScalaGeneric("BasicColumn", ScalaGenerics("TableType", "A" + i.toString))

            val fieldProductType = new ScalaBaseClassDeclare {
                scalaClassGen = ("Tuple" + arr.toString).cls
                generics = _generics1
            }

            val extensibleClassParams = ScalaClassParametrs()
            for (i <- 1 to arr)
                extensibleClassParams += ScalaClassParametr(name = s"a${i.toString}", `type` = ScalaImplicitType)

            val res = new ScalaClassDeclare {
                scalaClassGen = ("MyTuple" + arr.toString).cls
                modificatorScalaClass = AbstractModificatorScalaClass
                generics = _generics
                parametrs = _parametrs
                extensibleClass = ScalaClassGenericExtensible(new ScalaBaseClassDeclare {
                    scalaClassGen = ("Tuple" + arr.toString).cls
                    generics = aTypes
                    baseParametrs = extensibleClassParams
                })
                withTraits = ScalaWithTraits(ScalaTraitGeneric(new ScalaBaseClassDeclare {
                    scalaClassGen = "FieldProduct".cls
                    generics = ScalaGeneric("TableType")
                }))
            }


            var buildResultTubleBody = ""
            for (i <- 1 to arr)
                buildResultTubleBody += s"fieldProduct._${i.toString} get rs, "

            //<editor-fold desc="type ReturnType">
            res addMember ScalaAliasType(name = "ReturnType", body = ScalaBody(returnTypeBody))
            //</editor-fold>

            //<editor-fold desc="fieldProduct">
            res addMember ScalaMethod(name = "fieldProduct", body = ScalaNoBody, `type` = ScalaClassGenericType(fieldProductType))
            //</editor-fold>

            //<editor-fold desc="buildResult">
            res addMember ScalaMethod(name = "buildResult", serrializeToOneString = true, body = ScalaBody(s"Tuple${arr}(${delLastComma(buildResultTubleBody)})"), `type` = "ReturnType".tp, parametrs = ScalaClassParametrs(("rs", ScalaResultSet).param))
            //</editor-fold>

            //<editor-fold desc="def ~[OT]">
            if (arr !== maxArity) {
                val genericResType = ScalaGenerics("TableType")
                genericResType ++= aTypes
                genericResType += "OT"

                val paramsRes = ScalaClassParametrs()
                for (i <- 1 to arr)
                    paramsRes += ScalaClassParametr(name = s"this._${i.toString}", `type` = ScalaImplicitType)
                paramsRes += ScalaClassParametr(name = "p default", `type` = ScalaImplicitType)

                var fieldProductStr = "("
                for (i <- 1 to arr)
                    fieldProductStr += s"_fieldProduct._${i.toString}" + ", "
                fieldProductStr += "p)"

                res addMember ScalaMethod(
                    name = "~",
                    parametrs = ScalaClassParametrs(ScalaClassParametr(name = "p", `type` = ScalaClassGenericType(ScalaBaseClassDeclare("BasicColumn".cls, ScalaGenerics("TableType", "OT"))))),
                    `type` = ScalaClassGenericType(ScalaBaseClassDeclare(("MyTuple" + (arr + 1).toString).cls, genericResType)),
                    body = ScalaBody(
                        ScalaVariable(name = "_fields", body = ScalaBody("fields"), serrializeToOneString = true),
                        ScalaVariable(name = "_fieldProduct", body = ScalaBody("fieldProduct"), serrializeToOneString = true),
                        new ScalaClassDeclare {
                            typeScalaClass = AnonimousScalaClass
                            scalaClassGen = ("MyTuple" + (arr + 1).toString).cls
                            generics = genericResType
                            members = Seq(
                                ScalaVariable(name = "fields", body = ScalaBody("_fields ::: List(p)"), serrializeToOneString = true),
                                ScalaVariable(name = "fieldProduct", body = ScalaBody(fieldProductStr), serrializeToOneString = true)
                            )
                            parametrs = paramsRes
                        }
                    ),
                    generics = ScalaGenerics("OT"))
            }
            //</editor-fold>

            res
        }

        val myTuples = ArrayBuffer.empty[ScalaClassDeclare]
        for (i <- 1 to maxArity)
            myTuples ++= Seq(
                getMyTupe(i)
            )

        val traitSuperTuple = new ScalaClassDeclare {
            scalaClassGen = "SuperTuple".cls
            typeScalaClass = TypeScalaTrait
            members = Seq(traitFieldProduct)
        }

        traitSuperTuple ++= myTuples

        val module = new ScalaModule(
            "com.simplesys.jdbc.control".pkg,
            "java.sql.ResultSet".imp,
            newLine,
            traitSuperTuple
        )

        logger debug("Class: \n%s", module.serrialize())*/
    }
}