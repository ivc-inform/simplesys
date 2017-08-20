import com.simplesys.config.Config
import com.simplesys.isc.control.IButtonDyn
import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn
import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn._
import com.simplesys.isc.dataBinging.dataSource.{CriteriaDyn, RecordDyn}
import com.simplesys.isc.dataBinging.{DSRequestDyn, DSResponseDyn, DataSourceFieldDyn, DataSourceListGridItemDyn}
import com.simplesys.isc.forms.formItems.TextItemDyn
import com.simplesys.isc.foundation.ViewLoaderDyn
import com.simplesys.isc.grids.ListGridDyn._
import com.simplesys.isc.grids.{ListGridDyn, RecordsDynList}
import com.simplesys.isc.layout.HLayoutDyn
import com.simplesys.isc.system.ClassDyn._
import com.simplesys.isc.system._
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.templates.{IscHtmlDyn, LogJavaScript}
import com.simplesys.json._
import com.simplesys.common.Strings._
import com.simplesys.log.Logging
import com.simplesys.script.{HTMLBeautifier, JsBeautifier}
import org.scalatest.FunSuite

import scala.io.Codec._
import scala.io.Source

class TestSuit extends FunSuite with Config with Logging {
    val skin = sknTreeFrog

    /*test(s"IscEmptyPage") {
        logger debug HTMLBeautifier(IscEmptyPage())
    }*/

    test(s"HelloWorld") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        _Isc componentEnqueue new PageDyn {
            setAppImgDir(s"imgs/")
        }

        val buttonWidth = 150

        // enqueue - помещать ли функцию в очередь комманд, если да то она объявляется как отдельная функция, если нет то прикрепляется к полю для непосредственного вызова
        // variableGlobal если true => varName = function ... если нет то var varName = function ...
        //def declareJSFunction(_class: AnyRef, variableName: String, variableGlobal: Boolean, funcName: String, funcBody: String, enqueue: Boolean, funcParams: String*)

        _Isc componentEnqueue new IButtonDyn {
            ID = "button1"
            Identifier = "button1"
            //Click = _Isc.declareJSFunction(this, "funcClick", "{" + ModeNames + "say(\"Hello Dolly\")" + "}")

            //Click = _Isc.declareJSFunction(this, "variable", true, "funcClick", "{}", true, "patam1", "param2") // Полный набор
            //Click = _Isc.declareJSFunction(this, "variable", false, "funcClick", "{}", true, "patam1", "param2")  //Не глобальная переменная
            //Click = _Isc.declareJSFunction(this, "variable", false, "funcClick", "{}", false, "patam1", "param2") //Не выражение
            //Click = "funcName".f // указатель на функцию
            //Click = "funcName (say(\"Hello\"))".strMt // Стринг метод
            Click = """function (){say(s"Hello")}""".f // Стринг метод
            Icon = "icons/16/world.png"
            Align = AlCenter
            IconOrientation = IoRight
            Title = ""
            //Width = buttonWidth
            Width = "100".%
        }

        _Isc componentEnqueue new IButtonDyn {
            ID = "button2"
            Click = _Isc.declareJSFunction(this, "funcClick", "{" + ModeNames + "say(\"Hello Dolly1\")" + "}", true)
            Icon = "icons/16/world.png"
            IconOrientation = IoRight
            Top = 30
            Title = "Hello Dolly1"
            Width = buttonWidth
        }

        _Isc componentEnqueue new IButtonDyn {
            ID = "button3"
            Click = _Isc.declareJSFunctionExpr(this, "clickDolly2", false, "{" + ModeNames + "say(\"Hello Dolly2\")" + "}", true)
            Icon = "icons/16/world.png"
            IconOrientation = IoRight
            Top = 60
            Title = "Hello Dolly2"
            Width = buttonWidth
        }

        _Isc componentEnqueue new IButtonDyn {
            ID = "button4"
            Click = (ModeNames + "say(\"Hello Dolly3\")").f
            Icon = "icons/16/world.png"
            IconOrientation = IoRight
            Top = 90
            Title = "Hello Dolly3"
            Width = buttonWidth
        }

        _Isc logCommandLine()
    }

    test(s"DSResponse") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        val resp = new DSResponseDyn(useSelfName = true) {
            Status = statusSuccess
            StartRow = 0
            EndRow = 1
            TotalRows = 1
            Data = JsonObject(s"FIELD1" -> 1.23, s"FIELD2" -> "field2", s"FIELD3" -> 10)
        }

        logger trace (s"${resp.toPrettyString}")
    }

    test(s"RPCResponse") {
        val _Isc = IscDyn()
        ModeNames = PortalMode


        val _data = RecordsDynList()
        _data += RecordDyn(s"FIELD1" -> 1.23, "FIELD2" -> "field2", "FIELD3" -> 10)
        _data += RecordDyn(s"FIELD1" -> 1.23, "FIELD2" -> "field4", "FIELD3" -> 20)

        //_data += RecordDyn(s"FIELD1" -> 1.23, "FIELD2" -> "field2", "FIELD3" -> 10)

        val resp = new DSResponseDyn {
            Status = statusSuccess
            StartRow = 0
            EndRow = 3
            TotalRows = 3
            Data = _data
        }

        logger trace (s"${resp.WrapResponseObject.toPrettyString}")
    }

    test("ViewLoaderDyn") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        val res = new ViewLoaderDyn(useSelfName = true) {
            Identifier = "simpleSyS.enzo.ViewLoaderC"
            ViewURL = "/MainPage"
            AutoDraw = true
            LoadingMessage = "Зарузка формы".ellps
            Width = "100".%
            Height = "100".%
        }

        res.setViewURL()

        val fileLoader = new FileLoaderDyn
        fileLoader.loadSkin(skin = "anySkin".unq, onLoad = _Isc.declareJSFunction(this, "",
            s"""{
               |var localeFile = "../../locales/frameworkMessages.properties";
               |if (isc.params.locale) {
               |    if (isc.params.locale != "en")
               |        localeFile = "../../locales/frameworkMessages_" + isc.params.locale + ".properties";
               |    isc.FileLoader.loadJSFiles(localeFile, function(){${"simpleSyS.enzo.ViewLoaderC = " + res.toString}; simpleSyS.enzo.ViewLoaderC.setViewURL();});
                                                                                                                         |}
                                                                                                                         |}""".stripMargin
        ))

        //_Isc componentEnqueue(res, ("simpleSyS.enzo.ViewLoaderC" -> true))
        _Isc componentEnqueue fileLoader

        LogJavaScript(_Isc.getCommandLine())
    }

    test(s"datasource properties") {
        val req = new DSRequestDyn(Json( """{
                                           |    "data": {
                                           |        "SLASTNAME": "ASD",
                                           |        "SLOGIN": 1,
                                           |        "SPASSWORD": false,
                                           |        "SSECONDNAME": "ASD",
                                           |        "SFIRSTNAME": "AS"
                                           |    },
                                           |    "componentId": "formEdit",
                                           |    "dataSource": "AUserDS",
                                           |    "operationType": "add",
                                           |    "exportDatesAsFormattedString" : false,
                                           |    "oldValues": {}
                                           |}""".stripMargin))


        logger trace (s"req: ${req.toPrettyString}")
        logger trace (s"data: ${req.Data.toPrettyString}")
        logger trace (s"componentId: ${req.ComponentId}")
        logger trace (s"exportDatesAsFormattedString: ${req.ExportDatesAsFormattedString.asBoolean}")
        logger trace (s"dataSource: ${req.DataSource}")
        logger trace (s"operationType: ${req.OperationType.toString}")
        logger trace (s"oldValues: ${req.OldValues}")
    }

    test(s"recordDyn") {
        val responceData = RecordsDynList()
        val response = RecordDyn(s"DI" -> 1)
        response += (s"SLOGIN" -> "login")
        responceData += response
        responceData += "*"

        val resp = new DSResponseDyn {
            Status = RPCResponseDyn.statusSuccess
            Data = responceData
        }

        logger trace (s"resp: ${resp.toPrettyString}")
    }

    test(s"criteria") {
        val criteria = new CriteriaDyn
        criteria(s"criteria1") = 10
        criteria(s"criteria2") = "Это есть хорошо"

        logger trace (s"resp: ${criteria.toPrettyString}")
    }

    test(s"Fusion List") {
        val list1 = JsonList(
            new DataSourceFieldDyn {
                Name = "pk"
                Type = ftInteger
                Hidden = false
                PrimaryKey = true
                IdArrayItem = "item1"
                DecimalPad = 10
            },
            new DataSourceFieldDyn {
                Name = "countryCode"
                Type = ftText
                Title = "Code"
                Required = true
                IdArrayItem = "item2"
                DecimalPad = 102.22
            },
            1,
            "asdasd"
        )

        val list2 = JsonList(
            new DataSourceFieldDyn {
                Name = "pk"
                Type = ftInteger
                Hidden = true
                PrimaryKey = true
                IdArrayItem = "item4"
            },
            new DataSourceFieldDyn {
                Name = "countryCode"
                Type = ftText
                Title = "Code"
                Required = true
                IdArrayItem = "item1"
            }
        )

        logger trace (s"resp: ${JsBeautifier((list1 ++ list2).toString)}")
    }

    test(s"Fusion ArrayDyn") {
        val list1 = ArrayDyn(
            new DataSourceFieldDyn {
                Name = "pk"
                Type = ftInteger
                Hidden = false
                PrimaryKey = true
                IdArrayItem = "item1"
            },
            new DataSourceFieldDyn {
                Name = "countryCode"
                Type = ftText
                Title = "Code"
                Required = true
                IdArrayItem = "item2"
            }
        )

        /*val list2 = ArrayDyn(
          new DataSourceFieldDyn {
            Name = "pk"
            Type = ftInteger
            Hidden = true
            PrimaryKey = true
            IdArrayItem = "item4"
          },
          new DataSourceFieldDyn {
            Name = "countryCode"
            Type = ftText
            Title = "Code"
            Required = true
            IdArrayItem = "item3"
            DeleteItem = false
          }
        )*/

        val list2 = new DataSourceFieldDyn {
            Name = "pk"
            Type = ftInteger
            Hidden = true
            PrimaryKey = true
            IdArrayItem = "item4"
        }

        val c = list1 + list2
        logger trace (s"res ++ : ${JsBeautifier(c.toString)}")
        logger trace (s"res -- : ${JsBeautifier((c -- list2).toString)}")
    }

    test("TextItem") {
        val res = new HLayoutDyn(useSelfName = true) {
            Width = "100".%
            Height = "100".%
            Members = ArrayDyn(
                new TextItemDyn(useSelfName = true) {
                    Width = "*"
                }
            )
        }

        logger debug (s"resp: ${JsBeautifier(res.toPrettyString)}")
    }

    test(s"List Grid") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        val gridView = new ListGridDyn(useSelfName = true) {
            AutoDraw = false
            DataSource = "dataSource"
            AutoFetchData = true
            Height = "100".%
            Width = "100".%
            ShowRowNumbers = true
            CanEdit = true
            EditEvent = lstGrdEvntNone
            AlternateRecordStyles = true
            Identifier = "gridView"
        }

        var addingListGridProperties = new ListGridDyn {
            AutoDraw = true
        }

        val gridView1: ListGridDyn = gridView ++ addingListGridProperties

        _Isc componentEnqueue(gridView1, (s"gridView", false))

        /*val res = new HLayoutDyn(useSelfName = true) {
          Width = "100".%
          Height = "100".%
          Members = ArrayDyn(
            gridView1
          )
        }

        _Isc.componentEnqueue(res, (s"res", false))
        _Isc.commandEnqueue1(this, s"return " +
          (new ResultOfComponent {
            Component = "res"
            FuncMenu = "funcMenu"
          }).toString())*/

        _Isc logCommandLine()
    }

    test(s"ResultComponent") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        val res = new HLayoutDyn(useSelfName = true) {
            Width = "100".%
            Height = "100".%
            Members = ArrayDyn(
            )
        }
        _Isc componentEnqueue(res, (s"res", false))

        _Isc.commandEnqueue1(this, s"return " +
          (new ResultOfComponent {
              Component = res
              FuncMenu = "funcMenu".unq
          }).toString())

        _Isc.addProperties(s"RPCManager", JsonObject.apply1(s"maxErrorMessageLength" -> 10000))
        _Isc.addClassProperties(s"RPCManager", JsonObject.apply1(s"maxErrorMessageLength" -> 10000))

        val cls = ClassDyn()
        cls.addClassMethods(JsonObject())
        //cls.addProperties(JsonObject())
        _Isc addCommandQueue cls

        _Isc.defineClass(s"LoginWindow", "Window")
          .addProperties(JsonObject.apply1(s"autoDraw" -> false))
          .addProperties(JsonObject.apply1(s"maxErrorMessageLength" -> 10000))

        _Isc.logCommandLine()
    }

    test("DSRequest") {
        val dsRequest = new DSRequestDyn(Json( """{
                                                 |    "componentId": "isc_ListGridEditor_1",
                                                 |    "data": {},
                                                 |    "textMatchStyle": "substring",
                                                 |    "endRow": 100,
                                                 |    "sortBy": ["SDESCRIPTION", "SCAPTION"],
                                                 |    "dataSource": "isc_RestDataSource_8",
                                                 |    "startRow": 50,
                                                 |    "operationType": "fetch",
                                                 |    "oldValues": null
                                                 |}""".stripMargin))

        logger debug dsRequest.toPrettyString
        logger debug dsRequest.EndRow
        logger debug dsRequest.SortBy.toPrettyString
    }

    test("DSRequest with Filter") {
        val dsRequest = new DSRequestDyn(Json( """{
                                                 |    "componentId": "isc_ListGridEditor_0",
                                                 |    "data": {
                                                 |        "description": "BB",
                                                 |        "caption": "aa"
                                                 |    },
                                                 |    "textMatchStyle": "substring",
                                                 |    "endRow": 50,
                                                 |    "sortBy": ["caption", "-description"],
                                                 |    "dataSource": "isc_RestDataSource_1",
                                                 |    "startRow": 0,
                                                 |    "operationType": "fetch",
                                                 |    "oldValues": null
                                                 |}""".stripMargin))

        logger debug dsRequest.toPrettyString
        logger debug dsRequest.Data.toPrettyString
    }

    test("111") {
        val a = new DataSourceListGridItemDyn {
            Name = "Item"
        }

        logger debug a.toPrettyString
    }

    test("ListGrid") {
        val grid = new ListGridDyn(useSelfName = true) {
            //ExpansionDetailFieldProperties = JsonObject()
            CanSelectTextExpandedField = true
        }

        logger debug grid.toPrettyString
    }

    test("URL") {
        val grid = new ListGridDyn(useSelfName = true) {
            HeaderMenuButtonIcon = "aaaaa".url("variable")
            //HeaderMenuButtonIcon = "aaaaa".url
        }

        logger debug grid.toPrettyString
    }

    test("Read IncludeNodules") {
        Source.fromFile("/home/andrew/Job/simplesys/isc-wrapper/src/test/resources/IncludeModules")(UTF8).getLines() /*.filter(_.indexOf(".coffee") == -1)*/ .foreach(println)
    }

    test("Read ModulesLoadOrder") {
        val orderModules = Source.fromFile("src/test/resources/ModulesLoadOrder")(UTF8).getLines().toSeq.zipWithIndex
        val modules = Source.fromFile("src/test/resources/Modules")(UTF8).getLines().toSeq
        //modules foreach println

        def getOrder(path: String): Int = orderModules.filter { case (value, index) => value == path}.toList.headOption
        match {
            case None => Int.MaxValue
            case Some((_, index)) => index
        }

        val modules1: Seq[(String, Int)] = modules.map { x => (x, getOrder(x))}.toSeq.sortWith((x, y) => x._2 < y._2)

        modules1.foreach(x => println(s"${x._1}: ${x._2}"))
        //modules2.foreach (println)
    }


}