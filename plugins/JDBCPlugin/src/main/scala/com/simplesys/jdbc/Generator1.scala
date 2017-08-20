package com.simplesys.jdbc

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.genSources._
import com.simplesys.io._
import com.simplesys.scalaGen._
import sbt.File

import scala.collection.mutable.ArrayBuffer

object Generator1 {
    def genSuperTuple(outputDir: File, maxArity:Int): Seq[File] = {
        import scalax.file.ImplicitConversions._

        var res = ArrayBuffer.empty[File]
        //<editor-fold desc="FieldProduct">
        val fileFieldProduct = (outputDir.getAbsolutePath / "FieldProduct.scala").createFile(failIfExists = false).toFile

        val traitFieldProduct = new ScalaClassDeclare {
            scalaClassGen = "FieldProduct".cls
            //modificatorScalaClass = SealedModificatorScalaClass
            typeScalaClass = TypeScalaTrait
        }

        traitFieldProduct addMembers(
          ScalaAliasType(name = "ReturnType", body = ScalaNoBody, `type` = ScalaProduct, symbolType = UpperBoundTypeSymbol),
          ScalaMethod(name = "getTableOwner", `type` = "SQLTable".tp, parametrs = ScalaClassParametrs(("field", "BasicClassBOColumn[_]".tp).param), body = "field.getTableOwner".body, serrializeToOneString = true),
          newLine,
          ScalaMethod(name = "fields", body = ScalaNoBody, `type` = ScalaClassGenericType(ScalaBaseClassDeclare("List".cls, ScalaGeneric("BasicClassBOColumn", ScalaGenerics("_"))))),
          ScalaMethod(name = "fieldProduct", body = ScalaNoBody, `type` = ScalaProduct),
          ScalaMethod(name = "buildResult", body = ScalaNoBody, `type` = "ReturnType".tp, parametrs = ScalaClassParametrs(("resultSet", ScalaResultSet).param)),
          ScalaMethod(name = "getColumns", body = ScalaBody("SQLFields(fields.map(_.getColumn))"), `type` = "SQLFields".tp, serrializeToOneString = true), {
            val body = ScalaBody(
                ScalaVariable(name = "columnName", body = ScalaBody("columnInBo.name.unQuoted.replace(\"-\", \"\")"), serrializeToOneString = true, `type` = ScalaString),
                ScalaVariable(name = "field", body = ScalaBody("fields.filter(_.nameInBo === columnName).head"), serrializeToOneString = true, `type` = "BasicClassBOColumn[_]".tp),
                "columnInBo.copy(name = field.name, tableOwner = getTableOwner(field))"
            )
            ScalaMethod(name = "getColumnInBase", body = body, `type` = "SQLField".tp, serrializeToOneString = true, parametrs = ScalaClassParametrs(ScalaClassParametr(name = "columnInBo", `type` = "SQLField".tp)))
        }, {
            val body = ScalaBody(
                ScalaVariable(name = "columnName", body = ScalaBody("columnNameInBo.unQuoted.replace(\"-\", \"\")"), serrializeToOneString = true, `type` = ScalaString),
                ScalaVariable(name = "field", body = ScalaBody("fields.filter(_.nameInBo === columnName).head"), serrializeToOneString = true, `type` = "BasicClassBOColumn[_]".tp),
                "SQLField(name = field.name, originalName = field.name, tableOwner = getTableOwner(field))"
            )

            ScalaMethod(name = "getColumnInBase", body = body, `type` = "SQLField".tp, serrializeToOneString = true, parametrs = ScalaClassParametrs(ScalaClassParametr(name = "columnNameInBo", `type` = ScalaString)))
        },
          ScalaMethod(name = "getColumn", body = ScalaBody("fields.filter(_.nameInBo === columnNameInBo).head"), `type` = "BasicClassBOColumn[_]".tp, serrializeToOneString = true, parametrs = ScalaClassParametrs(ScalaClassParametr(name = "columnNameInBo", `type` = ScalaString))),
          ScalaMethod(name = "log", parametrs = ScalaClassParametrs(ScalaClassParametr(name = "indent", `type` = ScalaInt, defaultValue = "0")), body = "fields foreach (_.log(indent))".body, serrializeToOneString = true, `type` = ScalaUnit)
          )

        val module = new ScalaModule(
            "com.simplesys.jdbc.control.SuperTuple1".pkg,
            "java.sql.ResultSet".imp,
            newLine,
            "com.simplesys.SQL.Gen.{SQLField, SQLFields, SQLTable}".imp,
            "com.simplesys.common.Strings._".imp,
            "com.simplesys.common.equality.SimpleEquality._".imp,
            "com.simplesys.jdbc.control.BasicClassBOColumn".imp,
            newLine,
            traitFieldProduct
        )

        fileFieldProduct <== {
            out =>
                out(genMessageCreating("Generator1"))
                out(newLine)
                out(newLine)
                out(module.serrialize())
        }

        res += fileFieldProduct
        //</editor-fold>

        def getMyTuple(arr: Int): ScalaClassDeclare = {
            val aTypes = ScalaGenerics()
            for (i <- 1 to arr)
                aTypes += ("A" + i.toString)

            val _parametrs: ScalaClassParametrs = ScalaClassParametrs()
            for (i <- 1 to arr)
                _parametrs += ScalaClassParametr(name = "a" + i.toString, `type` = ("A" + i.toString).tp)

            val returnTypeBody = new ScalaBaseClassDeclare {
                scalaClassGen = s"TupleSS$arr".cls
                generics = aTypes
            }

            val _generics1 = ScalaGenerics()
            for (i <- 1 to arr)
                _generics1 += ScalaGeneric("BasicClassBOColumn", ScalaGenerics("A" + i.toString /*, "S"*/))

            val fieldProductType = new ScalaBaseClassDeclare {
                scalaClassGen = s"TupleSS$arr".cls
                generics = _generics1
            }

            val extensibleClassParams = ScalaClassParametrs()
            for (i <- 1 to arr)
                extensibleClassParams += ScalaClassParametr(name = s"a${i.toString}", `type` = ScalaImplicitType)

            val res = new ScalaClassDeclare {
                scalaClassGen = ("MyTuple" + arr.toString).cls
                modificatorScalaClass = AbstractModificatorScalaClass
                generics = aTypes
                parametrs = _parametrs
                extensibleClass = ScalaClassGenericExtensible(new ScalaBaseClassDeclare {
                    scalaClassGen = s"TupleSS$arr".cls
                    generics = aTypes
                    baseParametrs = extensibleClassParams
                })
                withTraits = ScalaWithTraits(ScalaTraitGeneric(new ScalaBaseClassDeclare {
                    scalaClassGen = "FieldProduct".cls
                    //generics = ScalaGeneric("S")
                }))
            }


            var buildResultTubleBody = ""
            for (i <- 1 to arr)
                buildResultTubleBody += s"fieldProduct._${i.toString} get resultSet, "

            //<editor-fold desc="type ReturnType">
            res addMember ScalaAliasType(name = "ReturnType", body = ScalaBody(returnTypeBody))
            //</editor-fold>

            //<editor-fold desc="fieldProduct">
            res addMember ScalaMethod(name = "fieldProduct", body = ScalaNoBody, `type` = ScalaClassGenericType(fieldProductType))
            //</editor-fold>

            //<editor-fold desc="buildResult">
            res addMember ScalaMethod(name = "buildResult", serrializeToOneString = true, body = ScalaBody(s"TupleSS${arr}(${delLastComma(buildResultTubleBody)})"), `type` = "ReturnType".tp, parametrs = ScalaClassParametrs(("resultSet", ScalaResultSet).param))
            //</editor-fold>

            //<editor-fold desc="def ~[OT]">
            if (arr !== maxArity) {
                val genericResType = ScalaGenerics(/*"TableType"*/)
                genericResType ++= aTypes
                genericResType += "OT"
                //genericResType += "S"

                val paramsRes = ScalaClassParametrs()
                for (i <- 1 to arr)
                    paramsRes += ScalaClassParametr(name = s"this._${i.toString}", `type` = ScalaImplicitType)
                paramsRes += ScalaClassParametr(name = "p default", `type` = ScalaImplicitType)

                var fieldProductStr = s"TupleSS${arr + 1}("
                for (i <- 1 to arr)
                    fieldProductStr += s"_fieldProduct._${i.toString}" + ", "
                fieldProductStr += "p)"

                res addMember ScalaMethod(
                    name = "~",
                    parametrs = ScalaClassParametrs(ScalaClassParametr(name = "p", `type` = ScalaClassGenericType(ScalaBaseClassDeclare("BasicClassBOColumn".cls, ScalaGenerics("OT" /*, "S"*/))))),
                    `type` = ScalaClassGenericType(ScalaBaseClassDeclare(("MyTuple" + (arr + 1).toString).cls, genericResType)),
                    body = ScalaBody(
                        ScalaVariable(name = "_fields", body = ScalaBody("fields"), serrializeToOneString = true),
                        newLine,
                        ScalaVariable(name = "_fieldProduct", body = ScalaBody("fieldProduct"), serrializeToOneString = true),
                        newLine,
                        new ScalaClassDeclare {
                            typeScalaClass = AnonimousScalaClass
                            scalaClassGen = ("MyTuple" + (arr + 1).toString).cls
                            generics = genericResType
                            members = ArrayBuffer(
                                ScalaVariable(name = "fields", body = ScalaBody("_fields ::: List(p)"), serrializeToOneString = true),
                                newLine,
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


        for (i <- 1 to maxArity) {
            val fileMyTuple = (outputDir.getAbsolutePath / s"MyTuple$i.scala").createFile(failIfExists = false).toFile

            val module = new ScalaModule(
                "com.simplesys.jdbc.control.SuperTuple1".pkg,
                "java.sql.ResultSet".imp,
                newLine,
                "com.simplesys.jdbc.control.BasicClassBOColumn".imp,
                "com.simplesys.tuple._".imp,
                newLine,
                getMyTuple(i)
            )

            fileMyTuple <== {
                out =>
                    out(genMessageCreating("Generator1"))
                    out(newLine)
                    out(newLine)
                    out(module.serrialize())
            }

            res += fileMyTuple
        }

        res
    }
}