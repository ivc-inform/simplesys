package com.simplesys.scalaGen

import com.simplesys.common.Strings._
import com.simplesys.javaScriptGen.{JavaScriptBody, JavaScriptSwitch, JavaScriptSwitchCaseItem}
import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class TestSuit extends FunSuite {
    val _indent = 0

    val parametrs = ScalaClassParametrs(("a", ScalaString).param, ("b", ScalaInt).param)
    val method = ScalaMethod(
        serrializeToOneString = true,
        name = "Method1",
        parametrs = parametrs,
        body = ScalaBody("a + b"))

    val method2 = ScalaMethod(
        name = "Method2",
        parametrs = parametrs,
        `type` = ScalaString,
        body = ScalaBody(
            """val res = (parametrs map (item => item.serrialize)).mkString(",")
              if (!res.isEmpty)
                "(" + res + ")"
              else strEmpty"""))


    val valVal = ("variable1", """JsonObject() + ("a" -> 1) + ("b" -> 3)""".body).`val`
    val valVar = ("variable2", ScalaInt, """JsonObject() + ("a" -> 1) + ("b" -> 3)""".body).`var`

    test("ScalaBaseClassSerrialization") {
        val _generics = ScalaGenerics()
        for (i <- 1 to 3)
            _generics += ScalaGeneric("BasicColumn", ScalaGenerics("TableType", "A" + i.toString))

        val classX = new ScalaBaseClassDeclare {
            scalaClassGen = "ClassX".cls
            //generics = ScalaGenerics(ScalaGeneric("S", ScalaUpperBound(ScalaBaseClassDeclare("Ordered".cls, ScalaGeneric("T")))), ScalaGeneric("S1", ScalaUpperBound("T1")), ScalaGeneric(name = "S2", lowerGeneric = ScalaLowerBound("T2")), "T3", "T4")
            //generics = ScalaGenerics(ScalaGeneric("S", ScalaUpperBound(ScalaBaseClassDeclare("Ordered".cls, ScalaGeneric("T")))),"T3", "T4")
            //generics = ScalaGeneric("T5", ScalaGenerics("T6","_"))
            //generics = _generics
            generics = ScalaGenerics(ScalaGeneric("BasicColumn", ScalaGenerics("TableType", "A1")), ScalaGeneric("BasicColumn", ScalaGenerics("TableType", "A2")))
        }

        println(classX.serrialize())
    }

    test("ScalaViewBound") {
        import ScalaGeneric._
        val v = Seq(ScalaViewBound(ScalaBaseClassDeclare("Ordered".cls, "T")), ScalaViewBound(ScalaBaseClassDeclare("Ordered".cls, "K")))

        val classX = new ScalaBaseClassDeclare {
            scalaClassGen = "ClassX".cls
            generics = ScalaGenerics(ScalaGeneric(name = "S", viewGeneric = v))
        }

        println(classX.serrialize())
    }

    test("ScalaVariance") {
        val classX = new ScalaBaseClassDeclare {
            scalaClassGen = "ClassX".cls
            generics = NameGeneric("S", CovariantScalaVarianceGeneric)
        }

        println(classX.serrialize())
    }

    test("ScalaClassSerrialization") {

        val params = ScalaClassParametrs(("a", ScalaString).param, ("b", ScalaInt, ParametrVal).param)
        val traits = ScalaWithTraits(ScalaTraitX, ScalaTraitY)

        val classX = new ScalaClassDeclare {
            scalaClassGen = "ClassX".cls
            generics = ScalaGenerics(ScalaGeneric(NameGeneric("S"), ScalaUpperBound("T")), ScalaGeneric(NameGeneric("S1"), ScalaUpperBound("T1")), "T3")
            parametrs = params
            extensibleClass = ScalaClassClass
            withTraits = traits
            members = ArrayBuffer(method, method2, valVal, valVar)
        }

        val classY = new ScalaClassDeclare {
            extensibleClass = ScalaClassClass
            scalaClassGen = "ClassY".cls
            parametrs = params
            withTraits = traits
            members = ArrayBuffer(method, method2, valVal, valVar)
        }

        val module = new ScalaModule(
            "ru.simplesys.sourcegen.app".pkg,
            "org.scalatest.FunSuite".imp,
            "com.simplesys.log.Logging".imp,
            newLine,
            classX,
            newLine,
            "org.scalatest.FunSuite\", \"com.simplesys.log.Logging".comment,
            classY,
            newLine,
            "org.scalatest.FunSuite\", \"com.simplesys.log.Logging".comment
        )

        println(module.serrialize())
    }

    test("ScalaMethod") {
        val _body = ScalaBody(
            "super.onSystemInit(system, endpoints)",
            newLine,
            "actorFetch = system.actorOf(Props[AUserFetchActor])",
            "actorAdd = system.actorOf(Props[AUserAddActor])")

        val _method = ScalaMethod(name = "onSystemInit", generics = ScalaGenerics("T", "S"), `override` = OverrideMofificator, parametrs = ScalaClassParametrs(("system", ScalaActorSystem).param, ("endpoints", ScalaEndpointsAgentPartial).param), body = _body)
        //val _method = ScalaMethod(name = "onSystemInit", `override` = OverrideMofificator, parametrs = ScalaClassParametrs(("system", ScalaActorSystem).param, ("endpoints", ScalaEndpointsAgent).param), body = ScalaNoBody)
        println(newLine + _method.serrialize(indentSize))
    }

    test("ScalaGetObject") {

        val obj = ScalaApplyObject(name = "SystemInit", parametrs = ScalaClassParametrs(
            ScalaClassParametr(name = "system", `type` = ScalaImplicitType, defaultValue = "1", sign = ScalaSignArrowRight),
            ScalaClassParametr(name = "endpoints", `type` = ScalaImplicitType, defaultValue = "1"),
            ScalaClassParametr(name = "", `type` = ScalaImplicitType, defaultValue = "2")
        ))

        val a = ScalaEquality(left = ScalaBody(obj), signEquality = ScalaSignTwoEquality, right = ScalaBody(obj), serrializeToOneString = true)
        println(newLine + obj.serrialize(indentSize))
        println(newLine + a.serrialize(indentSize))
    }

    /*insertBody = ScalaBody(ScalaApplyObject(name = s"${tableVal.unCapitalize}.insertWithoutCommit", parametrs = ScalaClassParametrs(
                        ScalaClassParametr(name = "", `type` = ScalaImplicitType, defaultValue = "allColumns"),
                        ScalaClassParametr(name = "", `type` = ScalaImplicitType, defaultValue = ScalaBody(ScalaControlStruct(name = "values map", body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", seqValues))))
                    )))*/

    test("ScalaControlStruct") {
        val struct = ScalaControlStruct(
            name = "transaction(dataSource)",
            body = ScalaControlBody(
                expression = "connection".expr,
                ScalaInfixSymbol(left = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                    ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                    ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                    ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                        name = "values map",
                        body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                    )))
                ),
                    symbol = ScalaPlusPlusSymbol,
                    right = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                        ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                        ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                        ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                            name = "values map",
                            body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                        )))
                    ))
            )
        )

        println(s"\n${struct.serrialize(indentSize)}")
    }

    test("ScalaControlStruct1") {
        val struct = ScalaInfixSymbol(left = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
            ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
            ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
            ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                name = "values map",
                body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
            )))
        ),
            symbol = ScalaPlusPlusSymbol,
            right = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                    name = "values map",
                    body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                )))
            ))

        println(s"\n${struct.serrialize(indentSize)}")
    }

    test("ScalaControlStruct2") {
        val body = ScalaControlBody(
            expression = "connection".expr,
            ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                    name = "values map",
                    body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                )))
            )
        )

        body ++= (
          ScalaPlusPlusSymbol,
          ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
              ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
              ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
              ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                  name = "values map",
                  body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
              ))))
          )

        val struct = ScalaControlStruct(
            name = "transaction(dataSource)",
            body = body
        )

        println(s"\n${struct.serrialize(indentSize)}")
    }

    test("ScalaControlStruct3") {
        val body = ScalaControlBody(expression = "control".expr, "")

        body +=
          ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
              ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
              ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
              ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                  name = "values map",
                  body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
              ))))


        body ++= (
          ScalaPlusPlusSymbol,
          ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
              ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
              ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
              ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                  name = "values map",
                  body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
              ))))
          )

        val struct = ScalaControlStruct(
            name = "transaction(dataSource)",
            //name = "",
            body = body
        )

        println(s"\n${struct.serrialize(indentSize)}")
    }

    test("ScalaControlStruct4") {
        val struct = ScalaControlStruct(
            name = "transaction(dataSource)",
            body = ScalaComplexBody(
                ScalaInfixSymbol(left = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                    ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                    ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                    ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                        name = "values map",
                        body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                    )))
                ),
                    symbol = ScalaPlusPlusSymbol,
                    right = ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", parametrs = ScalaClassParametrs(
                        ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                        ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName"),
                        ScalaClassParametr(name = "", `type` = ScalaImplicitType, onNewLine = true, defaultValue = ScalaControlStruct(
                            name = "values map",
                            body = ScalaControlBodyWithSuffix(expression = "value".expr, suffix = " :_*", "Seq(InsertValue(contractorTbl.isJur, value._5))")
                        )))
                    ))
            )
        )

        println(s"\n${struct.serrialize(indentSize)}")
    }

    test("Scala Case") {
        val cs = ScalaBody(
            ScalaCase(
                expression = ScalaExpressionBody(
                    ScalaBody(
                        ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", suffix = ".result",
                            parametrs = ScalaClassParametrs(
                                ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                                ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName")
                            )
                        )
                    ),
                    serrializeToOneString = true),
                ScalaCaseLine(expression = "Success(list)".expr,
                    caseBody = ScalaBody(
                        ScalaApplyObject(name = "ValidationEx",
                            parametrs = ScalaClassParametrs(
                                ScalaClassParametr(name = "", `type` = ScalaImplicitType,
                                    defaultValue = ScalaApplyObject(name = "success",
                                        parametrs = ScalaClassParametrs(
                                            ScalaClassParametr(name = "", `type` = ScalaImplicitType,
                                                defaultValue = ScalaBody(
                                                    ScalaApplyPartialObject(name = "list map",
                                                        body = ScalaCase(
                                                            ScalaCaseLine(expression =
                                                              ScalaExpressionBody(
                                                                  ScalaBody(
                                                                      ScalaApplyObject(name = "UserProduct",
                                                                          parametrs =
                                                                            ScalaClassParametrs(
                                                                                ScalaClassParametr(name = "caption", `type` = ScalaImplicitType),
                                                                                ScalaClassParametr(name = "di", `type` = ScalaImplicitType)
                                                                            )
                                                                      )
                                                                  ),
                                                                  serrializeToOneString = true
                                                              ),
                                                                caseBody = ScalaBody(
                                                                    ScalaApplyObject(name = "UserProduct",
                                                                        parametrs = ScalaClassParametrs(
                                                                            ScalaClassParametr(name = "caption", `type` = ScalaImplicitType),
                                                                            ScalaClassParametr(name = "di", `type` = ScalaImplicitType)
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                ), onNewLine = true
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
                ScalaCaseLine(expression = WildCarsScalaExpression, caseBody = ScalaBody("2"), serrializeToOneString = true)
            ))

        println(newLine + cs.serrialize(indentSize))
    }

    test("Scala Case1") {
        val cs = ScalaBody(
            ScalaCase(
                expression = ScalaExpressionBody(
                    ScalaBody(
                        ScalaApplyObject(name = "contractorTbl.insertWithoutCommit", suffix = ".result",
                            parametrs = ScalaClassParametrs(
                                ScalaClassParametr(name = "connection", `type` = ScalaImplicitType, defaultValue = "connection"),
                                ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue = "jurContractor.di ~ jurContractor.jurName")
                            )
                        )
                    ),
                    serrializeToOneString = true),
                ScalaCaseLine(expression = ScalaExpressionBody(
                    ScalaBody(
                        ScalaApplyObject(name = "Success",
                            parametrs = ScalaClassParametrs(
                                ScalaClassParametr(name = "", `type` = ScalaImplicitType,
                                    defaultValue = ScalaBody(
                                        ScalaApplyObject(name = "Tuple7",
                                            parametrs = ScalaClassParametrs(
                                                ScalaClassParametr(name = "caption", `type` = ScalaString)
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    ),
                    serrializeToOneString = true),
                    caseBody = ScalaBody(
                        ScalaApplyObject(name = "ValidationEx",
                            parametrs = ScalaClassParametrs(
                                ScalaClassParametr(name = "", `type` = ScalaImplicitType,
                                    defaultValue = ScalaApplyObject(name = "success",
                                        parametrs = ScalaClassParametrs(
                                            ScalaClassParametr(name = "", `type` = ScalaImplicitType,
                                                defaultValue = ScalaBody(
                                                    ScalaApplyObject(name = "UserProduct",
                                                        parametrs =
                                                          ScalaClassParametrs(
                                                              ScalaClassParametr(name = "caption", `type` = ScalaImplicitType),
                                                              ScalaClassParametr(name = "di", `type` = ScalaImplicitType)
                                                          )
                                                    )
                                                ), onNewLine = true
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                ),
                ScalaCaseLine(expression = WildCarsScalaExpression, caseBody = ScalaBody("2"))
            ))

        println(newLine + cs.serrialize(indentSize))
    }

    test("AnonimousClass") {
        val className = "DocState"
        val isComplexDataType = true
        val typeColumn = "EnumStringColumn"
        val columnVal = "ss"
        val columnDbName = "SS"
        val tblColumn = "docStateTbl.ss"

        val boClass = new ScalaClassDeclare {
            scalaClassGen = className.cls
            parametrsImplicit = ScalaClassParametrs(
                ScalaClassParametr(name = "dataSource", `type` = ScalaBoneCPDataSource, parametrType = ParametrImplicitVal)
            )
            extensibleClass = ScalaClassGenericExtensible(new ScalaBaseClassDeclare {
                scalaClassGen = "ClassBO".cls
                generics = ScalaGeneric(className)
            })
        }

        boClass addMember
          ScalaVariable(
              name = columnVal,
              body = ScalaBody(
                  new ScalaClassDeclare {
                      scalaClassGen = typeColumn.cls
                      typeScalaClass = AnonimousScalaClass
                      generics = ScalaGenerics("DocState")
                      parametrs = ScalaClassParametrs(
                          ScalaClassParametr(name = "name", `type` = ScalaImplicitType, defaultValue = columnDbName),
                          ScalaClassParametr(name = "tableColumn", `type` = ScalaImplicitType, defaultValue = tblColumn)
                      )
                      members = ArrayBuffer(
                          ScalaMethod(name = "default", body = ScalaBody(s"${"DocState"}.default"), serrializeToOneString = true)
                      )
                  }
              ),
              serrializeToOneString = false)

        println(newLine + boClass.serrialize(indentSize))
    }

    test("If") {
        val res = ScalaBody(
            ScalaIf(
                "sessionContext.getLoged".expr,
                ScalaBody("response PrintAndFlush LogJS(_Isc2.getCommandLine)", newLine, "1=1"),
                //ScalaBody("response PrintAndFlush LogJS(_Isc.getCommandLine)", "2=2"),
                serrializeToOneString = false)
        )
        println(newLine + res.serrialize(indentSize))
    }

    test("Editors") {

        val caze = JavaScriptSwitch(
            switch = "itemName",
            default = JavaScriptBody("return undefined;"),
            JavaScriptSwitchCaseItem(`case` = "users", body = JavaScriptBody("return (function (){var that = ${editorUsers.toString()}; return that;}());")),
            JavaScriptSwitchCaseItem(`case` = "users54545", body = JavaScriptBody("return (function (){var that = ${editorUsers.toString()}; return that;}());"))
        )

        val editors = new ScalaClassDeclare {
            scalaClassGen = "Editors".cls
            extensibleClass = "User".ext
            typeScalaClass = TypeScalaTrait
        }
        val traits = ScalaWithTraits()

        editors addMembers("this: MainTabs =>", newLine, newLine)
        editors addMember ScalaVariable(name = "getEditor", `lazy` = true, body = ScalaBody("_Isc.declareJSFunction(this, \"getEditor\", templ, false, \"itemName\")"), serrializeToOneString = true)
        editors addMember ScalaVariable(name = "templ", modificator = PrivateMofificator, `lazy` = true, body = ScalaBody(caze.serrializeSTriplesWrap(4)), serrializeToOneString = false)

        traits ++= ("Trait1".trt, "Trait2".trt)
        editors setTraits traits

        println(newLine + editors.serrialize())
    }

    test("JavaScript Switch") {
        val caze = JavaScriptSwitch(
            switch = "itemName",
            default = JavaScriptBody("return undefined;"),
            JavaScriptSwitchCaseItem(`case` = "users", body = JavaScriptBody("return (function (){var that = ${editorUsers.toString()}; return that;}());")),
            JavaScriptSwitchCaseItem(`case` = "users54545", body = JavaScriptBody("return (function (){var that = ${editorUsers.toString()}; return that;}());"))
        )

        println(newLine + caze.serrializeSTriplesWrap(10))
        println(newLine + caze.serrialize(10))
    }

    test("getFunction") {
        def log(path: String) {
            val _path = path.substring(0, (path lastIndexOf "/"))
            val _funcName = path.substring((path lastIndexOf "/") + 1)

            import ScalaClassJSONPropertyJSCode._
            val indent = 20
            println(newLine + getFunctionBlock(content = getAllJSCode(_path), _funcName = _funcName, indent = indent))
        }

        log("/home/andrew/JOB/enzo/src/main/resources/defs/app/js/MenuItemsFunctions.js/editRow")
        log("/home/andrew/JOB/enzo/src/main/resources/defs/app/js/MenuItemsFunctions.js/canReparentNodes")
    }

    test("imports") {
        val module = ScalaImports("com.simplesys.servlet.http.{HttpServletResponse, HttpServletRequest}".imp,
            "com.simplesys.isc.dataBinging.{DSResponseFailureExDyn, DSResponseFailureDyn, DSRequestDyn, DSResponseDyn}".imp,
            "com.simplesys.isc.dataBinging.RPC.RPCResponseDyn".imp,
            "com.simplesys.isc.dataBinging.dataSource.RecordDyn".imp,
            "com.simplesys.enzo.SessionContext".imp,
            "javax.servlet.annotation.WebServlet".imp,
            "com.simplesys.isc.templates.LogJS".imp,
            "com.simplesys.script.JsBeautifier".imp,
            "com.simplesys.akka.http._".imp,
            "akka.actor.{Props, ActorRef, Actor, ActorSystem}".imp,
            "com.simplesys.enzo.seq.Seqences".imp,
            "com.simplesys.config.Config".imp,
            "com.simplesys.log.Logging".imp,
            "com.simplesys.isc.system.misc._".imp,
            "com.simplesys.akka.http.Async.Complete".imp,
            "com.simplesys.isc.grids.RecordsDynList".imp,
            "collection.JavaConversions._".imp,
            "scalaz.{Failure, Success}".imp,
            "com.simplesys.jdbc.control.classBO.Where".imp,
            "com.simplesys.enzo.servlet.CommonSuite".imp,
            "com.simplesys.jdbc._".imp,
            "com.simplesys.json._".imp,
            "org.joda.time.LocalDateTime".imp,
            "com.simplesys.common.Strings._".imp
        )

        println(newLine + module.serrialize(4))
    }

    /*
   * def preparedBO4Wrap: Tuple5[SQLAbsTable, List[JoinParam], List[WhereParam], List[DescriminatorCaseClass[_, _]], Set[Tuple2[BasicClassBOColumn[_], String]]] = prepareSelect(columns = _columns match {
           case null => allColumns
           case _ => _columns
       }, join = null, where = _where, orderBy = _orderBy, descriminator = null, from = From(contractorGroupTbl))*/

    test("preparedBO4Wrap") {
        val preparedBO4Wrap = ScalaVariable(name = "preparedBO4Wrap",
            `lazy` = true,
            `type` = ScalaClassGenericType(
                ScalaBaseClassDeclare("Tuple5".cls,
                    ScalaGenerics("SQLAbsTable",
                        ScalaGeneric("List", "JoinParam"),
                        ScalaGeneric("List", "WhereParam"),
                        ScalaGeneric("List",
                            ScalaGeneric("DescriminatorCaseClass",
                                ScalaGenerics("_", "_")
                            )
                        ),
                        ScalaGeneric("Set",
                            ScalaGeneric("Tuple2",
                                ScalaGenerics(ScalaGeneric("BasicClassBOColumn", "_"), "String")))
                    )
                )
            ),
            body = ScalaBody(
                ScalaApplyObject(
                    name = "prepareSelect",
                    parametrs = ScalaClassParametrs(
                        ScalaClassParametr(name = "join", `type` = ScalaImplicitType, defaultValue = "_join"),
                        ScalaClassParametr(name = "where", `type` = ScalaImplicitType, defaultValue = "_where"),
                        ScalaClassParametr(name = "orderBy", `type` = ScalaImplicitType, defaultValue = "_orderBy"),
                        ScalaClassParametr(name = "descriminator", `type` = ScalaImplicitType, defaultValue = "null"),
                        ScalaClassParametr(name = "from", `type` = ScalaImplicitType, defaultValue = "From(contractorGroupTbl)"),
                        ScalaClassParametr(name = "columns", `type` = ScalaImplicitType, defaultValue =
                          ScalaCase(
                              expression = "_columns".expr,
                              ScalaCaseLine(expression = "null".expr, caseBody = "allColumns".body, serrializeToOneString = true),
                              ScalaCaseLine(expression = "_".expr, caseBody = "_columns".body, serrializeToOneString = true)
                          )
                        )
                    )
                )
            )
        )
        println(newLine + preparedBO4Wrap.serrialize(0))
    }

    test("Seq") {
        val seq = ScalaSequense(seqName = "Seq", "1", "2", "3")
        println(newLine + seq.serrialize(4))
        println(newLine + seq.serrializeToOneString(4))

        val seq1 = ScalaSequense(seqName = "Seq", /*printNumberElement = true,*/ "1", "2", "3")
        println(newLine + seq1.serrialize(4))
        println(newLine + seq1.serrializeToOneString(4))
    }

    test("ScalaTest") {
        val res = ScalaTestMethod(name = "test1",
            testKind = ScalaTestKind("in"),
            body = ScalaBody(
                //strEmpty,
                /*ScalaVariable(name = "a", body = "1".body, serrializeToOneString = true),
                ScalaVariable(name = "a", body = "1".body, serrializeToOneString = true),
                ScalaSequense(seqName = "Seq", "1", "2", "3"),*/
                /*new ScalaSequense(seqName = "Seq", serrializeToOneString = true, printNumberElement = false, "1", "2", "3")*/
            ))

        println(newLine + res.serrialize(4))
    }

    test("MainConstructorClass") {
        val createScriptsBody = ScalaBody(
            "new SimpleTypes",
            "new MainTabs",
            "new DefaultDataSources"
        )

        val createStatics = new ScalaClassDeclare {
            scalaClassGen = "CreateStatics".cls
            parametrs = ScalaClassParametrs(
                ScalaClassParametr(name = "path", `type` = "File".tp, parametrType = ParametrVal),
                ScalaClassParametr(name = "withBeautifiler", `type` = ScalaBoolean, parametrType = ParametrVal)
            )
            extensibleClass = "PublicStatic".ext
            members = ArrayBuffer(
                ScalaMethod(name = "createScripts", `type` = ScalaUnit, body = createScriptsBody)
            )
            mainConstructorBody = ScalaBody("CreateStatics")
        }

        val moduleCreateStatics = new ScalaModule(
            "java.io.File".pkg,
            newLine,
            "com.simplesys.app.jsGen.MainTabs".imp,
            "com.simplesys.components.Gen.PublicStatic".imp,
            "com.simplesys.isc.system.IscDyn".imp,
            "com.simplesys.isc.system.global._".imp,
            "com.simplesys.mfms.jsGen.DefaultDataSources".imp,
            "ru.simplesys.defs.app.gen.scala.jsGen._".imp,
            "ru.simplesys.defs.app.scala.jsGen.SimpleTypes".imp,
            newLine,
            createStatics
        )

        println(moduleCreateStatics.serrialize(10))
    }

    test("variable") {
        val bb = ScalaVariable(
            name = "bb",
            serrializeToOneString = true,
            body = "0".body)

        val cc = ScalaVariable(
            name = "cc",
            serrializeToOneString = true,
            body = "1".body)

        println(ScalaBody(
            bb,
            cc
        ).serrialize())

        println(ScalaVariable(
            name = "aa",
            body = ScalaComplexBody(
                bb,
                cc
            ),
            serrializeToOneString = false).serrialize()
        )

        println(ScalaVariable(
            name = "dd",
            body = ScalaComplexBody(
                bb
            ),
            serrializeToOneString = false).serrialize()
        )
    }

    test("LogedVariable") {
        val bodyStr = "5 + 5"
        val varName = "anyVariable"

        println(ScalaVariable(
            name = "anyVariable",
            `type` = ScalaString,
            body = bodyStr.body,
            loggedVariable = true,
            serrializeToOneString = true
        ))
    }

    test("LogedMethod") {
        val bodyStr = "5 + 5"
        val varName = "anyVariable"

        println(ScalaMethod(
            name = "anyVariable",
            `type` = ScalaString,
            body = bodyStr.body,
            loggedVariable = true,
            serrializeToOneString = true
        ))
    }

    test("Scala Package") {
        println(ScalaPackageBody("bb",  ScalaPackageBody("aaa",  "123456")).serrialize(4))
    }

}
