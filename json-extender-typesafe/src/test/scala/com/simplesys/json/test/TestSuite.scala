package com.simplesys.json.test

import com.simplesys.common.Strings._
import com.simplesys.json._
import com.simplesys.log.Logging
import org.scalatest.FunSuite


class TestSuite extends FunSuite with Logging {
    test("delQuote") {
        logger debug (s"str: ${"\"qwqwqwqw\"".unQuoted}")
    }


    test("equals JsonObject") {
        val a = JsonObject() + ("a" -> 1) + ("b" -> 3)
        val b = JsonObject() + ("a" -> 1) + ("b" -> 3) + ("c" -> "3.2")

        logger debug (s"b: ${b.toPrettyString}")
        logger debug (s"eq JsonObjects: ${a == b}")
    }

    test("JsonList distinct") {

        val res = Json(
            """[{"DIPARENT": 67.1,
              |            "DI": 68.1,
              |            "SCAPTION": "Group1",
              |            "SDESCRIPTION": "Level 1"
              |        }, {
              |            "DI": 67.1,
              |            "SCAPTION": "Root",
              |            "SDESCRIPTION": "The Root main !!!"
              |        }, {
              |            "DIPARENT": 68.1,
              |            "DI": 69.1,
              |            "SCAPTION": "Group3",
              |            "SDESCRIPTION": "Level 2"
              |        }, {
              |            "DIPARENT": 67.1,
              |            "DI": 68.1,
              |            "SCAPTION": "Group1",
              |            "SDESCRIPTION": "Level 1"
              |        }, {
              |            "DI": 67.1,
              |            "SCAPTION": "Root",
              |            "SDESCRIPTION": "The Root main !!!"
              |        }, {
              |            "DIPARENT": 67.1,
              |            "DI": 68.1,
              |            "SCAPTION": "Group1",
              |            "SDESCRIPTION": "Level 1"
              |        }, {
              |            "DI": 67.1,
              |            "SCAPTION": "Root",
              |            "SDESCRIPTION": "The Root main !!!"
              |        }]""".stripMargin, null)

        logger debug (s"list : ${res.distinct.toPrettyString}")
    }

    test("merge json3") {
        val res = Json(
            """{
              |    "DIPARENT": 69.1,
              |    "isFolder": null,
              |    "SDESCRIPTION": null,
              |    "DI": 118.1,
              |    "DI1": 118,
              |    "SCAPTION": "Новая группа"
              |}""".stripMargin)

        val res1 = Json(
            """{
              |    "SCAPTION": "Новая группа 1111",
              |    "DI": 118.1,
              |    "DI1": null
              |}""".stripMargin)

        val result = res ++ res1

        logger debug (s"res after : ${res.toPrettyString}")
    }

    test("merge json") {
        val res = Json(
            """{
              |    "dataFormat": "json",
              |    "updateDataURL": "/enzo/logic/CmnContractorGroup/update",
              |    "jsonSuffix": "",
              |    "jsonPrefix": "",
              |    "fetchDataURL": "/enzo/logic/CmnContractorGroup/fetch",
              |    "fields": [{
              |        "required": true,
              |        "type": "float",
              |        "hidden": true,
              |        "name": "DI",
              |        "primaryKey": true
              |    }, {
              |        "type": "float",
              |        "hidden": true,
              |        "name": "DIPARENT",
              |        "detail": true,
              |        "foreignKey": "DI"
              |    }, {
              |        "required": true,
              |        "type": "text",
              |        "length": 255,
              |        "name": "SCAPTION",
              |        "title": "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435"
              |    }, {
              |        "type": "text",
              |        "length": 4000,
              |        "name": "SDESCRIPTION",
              |        "title": "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435"
              |    }],
              |    "removeDataURL": "/enzo/logic/CmnContractorGroup/remove",
              |    "operationBindings": [{
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "fetch"
              |    }, {
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "add"
              |    }, {
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "update"
              |    }, {
              |        "dataFormat": "json",
              |        "allowMultiUpdate": true,
              |        "dataProtocol": "postXML",
              |        "operationType": "remove"
              |    }],
              |    "addDataURL": "/enzo/logic/CmnContractorGroup/add"
              |}""".stripMargin)

        val res1 = Json(
            """{
          "addDataURL": ""
              |}""".stripMargin)

        logger debug (s"res before : ${res.toPrettyString}")
        //logger debug(s"res1 before  : ${res1.toPrettyString}")
        //val result = res ++= res1

        //logger debug(s"res after : ${res.toPrettyString}")
        //logger debug(s"result after ++= : ${result.toPrettyString}")
    }

    test("minus JsonList") {

        //val d = (JsonObject() + ("a" -> 1.0) + ("c" -> 1) + ("idArrayItem" -> "2"))
        //val a = (JsonList() + 1 + 2 + 2.3 + d)
        //val b = (JsonList() + 1 + 5 + (JsonObject() + ("a" -> 1) + ("c" -> 5) + ("idArrayItem" -> "2")))

        val a = JsonList() + 1 + 2 + 3
        val b = JsonList() + 1 + null

        val c = a ++ b

        logger debug (s"a + b JsonList: ${c.toPrettyString}")
        //logger debug(s"c -= b JsonList: ${(c -- (JsonList() + 1 + d)).toPrettyString}")
    }

    test("minus2 JsonList") {

        val a = JsonObject(("a" -> 1.0), ("c" -> 1), ("idArrayItem" -> "2"))
        logger debug (s"a: ${a.toPrettyString}")

        val b = JsonList() + 1 + 2 + 2.3 + a
        val c = JsonObject() + ("idArrayItem" -> "2")

        logger debug (s"a + b JsonList: ${b.toPrettyString}")
        logger debug (s"b -= c JsonList: ${(b -- c).toPrettyString}")
        //logger debug(s"a + b JsonList: ${c.toPrettyString}")
    }

    test("minus3 JsonList") {

        val a = Json(
            """{
              |    "dataFormat": "json",
              |    "jsonSuffix": "",
              |    "updateDataURL": "/enzo/logic/CmnContractorGroup/update",
              |    "jsonPrefix": "",
              |    "fields": [{
              |        "required": true,
              |        "type": "float",
              |        "hidden": true,
              |        "name": "DI",
              |        "primaryKey": true
              |    }, {
              |        "type": "float",
              |        "hidden": true,
              |        "name": "DIPARENT",
              |        "detail": true,
              |        "foreignKey": "DI"
              |    }, {
              |        "required": true,
              |        "type": "text",
              |        "length": 255,
              |        "name": "SCAPTION",
              |        "title": "\u041D\u0430\u0438\u043C\u0435\u043D\u043E\u0432\u0430\u043D\u0438\u0435"
              |    }, {
              |        "type": "text",
              |        "length": 4000,
              |        "name": "SDESCRIPTION",
              |        "title": "\u041E\u043F\u0438\u0441\u0430\u043D\u0438\u0435"
              |    }],
              |    "fetchDataURL": "/enzo/logic/CmnContractorGroup/Contragent/fetch",
              |    "removeDataURL": "/enzo/logic/CmnContractorGroup/remove",
              |    "addDataURL": "",
              |    "operationBindings": [{
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "fetch"
              |    }, {
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "add",
              |        "idArrayItem": "addItem"
              |    }, {
              |        "dataFormat": "json",
              |        "dataProtocol": "postXML",
              |        "operationType": "update"
              |    }, {
              |        "dataFormat": "json",
              |        "allowMultiUpdate": true,
              |        "dataProtocol": "postXML",
              |        "operationType": "remove"
              |    }]
              |}""".stripMargin)

        val b = Json(
            """{
              |    "addDataURL": "",
              |    "operationBindings": [ {
              |        "deleteItem": true,
              |        "idArrayItem": "addItem"
              |    }]
              |}""".stripMargin)

        val c = a ++ b
        logger debug (s"a -= b JsonList: ${c.toPrettyString}")
    }

    test("minus4 JsonList") {

        val a = Json(
            """{
              |    "autoDraw": false,
              |    "shadowDepth": 10,
              |    "items": [{
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "N"
              |        }],
              |        "title": "\u041D\u043E\u0432\u044B\u0439 ...",
              |        "icon": "enzo/Actions-insert-link-icon.png",
              |        "idArrayItem": "newItem",
              |        "keyTitle": "Ctrl+N"
              |    }, {
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "E"
              |        }],
              |        "title": "\u0418\u0437\u043C\u0435\u043D\u0438\u0442\u044C ...",
              |        "icon": "enzo/Actions-document-edit-icon.png",
              |        "keyTitle": "Ctrl+E"
              |    }, {
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "D"
              |        }],
              |        "title": "\u0423\u0434\u0430\u043B\u0438\u0442\u044C",
              |        "icon": "enzo/Delete-icon.png",
              |        "keyTitle": "Ctrl+D"
              |    }, {
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "R",
              |            "idArrayItem": "refreshKeys"
              |        }],
              |        "title": "\u041E\u0431\u043D\u043E\u0432\u0438\u0442\u044C",
              |        "icon": "enzo/Refresh.png",
              |        "idArrayItem": "refresh",
              |        "keyTitle": "Ctrl+R"
              |    }, {
              |        "isSeparator": true
              |    }, {
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "S"
              |        }],
              |        "title": "\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C",
              |        "icon": "enzo/Save-icon.png",
              |        "keyTitle": "Ctrl+S",
              |        "enabled": false
              |    }, {
              |        "keys": [{
              |            "shiftKey": true,
              |            "ctrlKey": true,
              |            "keyName": "R"
              |        }],
              |        "title": "\u041E\u0442\u043C\u0435\u043D\u0438\u0442\u044C \u0438\u0437\u043C\u0435\u043D\u0435\u043D\u0438\u044F",
              |        "icon": "enzo/cancel-icon.png",
              |        "keyTitle": "Ctrl+Shift+R"
              |    }, {
              |        "isSeparator": true
              |    }, {
              |        "keys": [{
              |            "ctrlKey": true,
              |            "keyName": "T"
              |        }],
              |        "name": "delete",
              |        "click": "simpleSyS.deleteTab(target, item)",
              |        "title": "\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0432\u043A\u043B\u0430\u0434\u043A\u0443",
              |        "icon": "enzo/Windows-Close-Program-icon.png",
              |        "idArrayItem": "deleteItem",
              |        "enableIf": "simpleSyS.enzo.mainPage.tabsSet.tabs.length != 0",
              |        "keyTitle": "Ctrl+T"
              |    }],
              |    "showShadow": true
              |}""".stripMargin)

        val b = Json(
            """{
              |    "items": [{
              |        "deleteItem": true,
              |        "idArrayItem": "newItem"
              |    }]
              |}""".stripMargin)

        val c = a ++ b
        logger debug (s"a ++ b : ${c.toPrettyString}")
        logger debug (s"a : ${b.toPrettyString}")
    }

    test("Minus key") {
        val b = Json(
            """{
              |    "addDataURL": "",
              |    "operationBindings": [ {
              |        "deleteItem": true,
              |        "idArrayItem": "addItem"
              |    }]
              |}""".stripMargin)
        logger debug (s"a -= b JsonList: ${b.toPrettyString}")
        b remove "operationBindings"
        logger debug (s"a -= b JsonList: ${b.toPrettyString}")
    }

    test("merge jsonobjetc") {
        val a = Json(
            """{
              |    "items": [{
              |        "keys": [{
              |            "ctrlKey": true,
              |            "identifier": "editKeys",
              |            "keyName": "N"
              |
              |        }],
              |        "idArrayItem": "edit",
              |        "keyTitle": ""
              |    }
              |  ]
              |}""".stripMargin)

        val b = Json(
            """{
              |    "items": [{
              |        "keys": [{
              |            "identifier": "editKeys",
              |            "deleteItem": true
              |        }],
              |        "idArrayItem": "edit",
              |        "keyTitle": ""
              |    }
              |  ]
              |}""".stripMargin)

        a ++ b
        logger debug (s"a ++ b JsonList: ${(a ++ b).toPrettyString}")
    }

    test("request") {
        val request = Json(
            """{
              |    "componentId": "isc_ListGridEditor_0",
              |    "data": {},
              |    "textMatchStyle": "substring",
              |    "endRow": 75,
              |    "dataSource": "isc_RestDataSource_0",
              |    "startRow": 0,
              |    "operationType": "fetch",
              |    "oldValues": null
              |}""".stripMargin)

        logger debug (s"Request: ${newLine + request.toPrettyString}")

        val endRow = request.getNumber("endRow") //.getOrElse(0)
        //getValue2[JsonString, BigDecimal]("startRow").getOrElse(0)

        logger debug (s"endRow: ${endRow}")
    }

    test("123") {
        val a = Json(
            """
              |{"fieldName":"caption","operator":"equals","value":123456}
            """.stripMargin)

        logger debug (a.getJsonElement("value") match {
            case None => "None"
            case Some(x) => x.toString
        })
    }

    test("SerrializedJsonObject") {
        val a = Json("{\"data\":{\"state\":1,\"criteria\":\"{\\\"_constructor\\\":\\\"AdvancedCriteria\\\",\\\"operator\\\":\\\"and\\\",\\\"criteria\\\":[{\\\"operator\\\":\\\"betweenInclusive\\\",\\\"fieldName\\\":\\\"dlv_status_at\\\",\\\"start\\\":{\\\"_constructor\\\":\\\"RelativeDate\\\",\\\"value\\\":\\\"$today\\\",\\\"rangePosition\\\":\\\"start\\\"},\\\"end\\\":{\\\"_constructor\\\":\\\"RelativeDate\\\",\\\"value\\\":\\\"$today\\\",\\\"rangePosition\\\":\\\"end\\\"}}]}\",\"conditional\":\"Время модификации статуса между (включительно) [object Object] and [object Object]\",\"nameOfTask\":\"CC3C2A46-0B56-FCA5-74EB-CEFDDB13FF90\"},\"textMatchStyle\":\"exact\",\"dataSource\":\"ControlOfRead_DS\",\"operationType\":\"update\",\"oldValues\":null}".unQuoted)
        logger debug a.toPrettyString
    }

    test("JsonElements") {
        import com.simplesys.isc.system.misc._

        val a = plus
        val json = JsonObject("e" -> JsonElements(JsonUnquotedString("bb".unq), JsonUnquotedString(plus.unq), JsonUnquotedString("cc".unq), JsonUnquotedString(plus.unq), "aa"))
        logger debug json.toPrettyString
    }

    test("for null") {
        val a = Json(
            """{
              |    "componentId": "isc_TreeGrid_0",
              |    "data": {
              |        "ts": 1423424290903,
              |        "parent": null
              |    },
              |    "textMatchStyle": "exact",
              |    "operationId": "admin_UserGroup_DS_fetch",
              |    "dataSource": "admin_UserGroup_DS",
              |    "operationType": "fetch",
              |    "oldValues": null,
              |    "oldValues1": undefined
              |}""".stripMargin)

        logger debug a.trim.toString()
    }

    test("for local date") {
        val a: JsonObject = Json(
            """{
              |    "id_cmpgn": 2,
              |    "children": [{
              |        "id_cmpgn": 3,
              |        "caption_cmpgn": "Ресторан - \nUBER",
              |        "code_cmpgn": "restoran-uber",
              |        "jsonStorage": "",
              |        "parent_cmpgn": 2,
              |        "isParalel": 0
              |    }, {
              |        "id_cmpgn": 3,
              |        "caption_cmpgn": "Ресторан - UBER",
              |        "code_cmpgn": "restoran-uber",
              |        "jsonStorage": "",
              |        "parent_cmpgn": 2,
              |        "isParalel": 0
              |    }],
              |    "isFolder": true,
              |    "description_cmpgn": "qqqq",
              |    "caption_cmpgn": "\u041A\u0430\u043C\u043F\u0430\u043D\u0438\u044F Retail",
              |    "code_cmpgn": "retail",
              |    "jsonStorage": "",
              |    "parent_cmpgn": null,
              |    "begin_cmpgn": "2016-08-15T11:23:12.000"
              |}
              | """.stripMargin)

        //a.getLocalDateTime("begin_cmpgn").foreach(item => println(item.toString))
        println(a.toPrettyString)
    }

    test("excape") {
        val a = Json(
            """[{
              |    "title": "Начало\n\"Начал\"",
              |    "ID": "StartState3",
              |    "shadow": {
              |        "offset": [1, 1],
              |        "color": "#333333",
              |        "blur": 2
              |    },
              |    "fillGradient": {
              |        "direction": 90,
              |        "startColor": "red",
              |        "endColor": "#99ccff"
              |    },
              |    "height": 190,
              |    "width": 268,
              |    "left": 96,
              |    "top": 83,
              |    "enable4Glue": true,
              |    "enable2Glue": false,
              |    "enable4Connect": true,
              |    "titleLabelProperties": {
              |        "type": "DrawLabel",
              |        "lineColor": "#000000"
              |    },
              |    "lineWidth": 1,
              |    "keepInParentRect": false,
              |    "canDrop": false,
              |    "_constructor": "StartState",
              |    "shapeData": {
              |        "m00": 1.00005996366422,
              |        "m01": 0,
              |        "m02": -0.4232995968956432,
              |        "m10": 0,
              |        "m11": 1.0145775587722003,
              |        "m12": -3.016374088902467
              |    },
              |    "canDrag": true
              |}, {
              |    "autoDraw": false,
              |    "ID": "isc_DrawPane_0",
              |    "height": "100%",
              |    "width": "100%",
              |    "canFocus": true,
              |    "_constructor": "DrawPane",
              |    "editProxyProperties": {},
              |    "left": 0,
              |    "top": 0,
              |    "drawItems": ["ref:StartState3"]
              |}]""".stripMargin, 0)

        println(a.toPrettyString)
    }

    test("excape1") {
        //new com.simplesys.isc.dataBinging.DSRequestDyn(request)
        val request = Json(
            """{
              |    "data": {
              |        "id_scenario": 1,
              |        "jsonStorage_scenario": "[{\"title\":\"Начало\\n\\\"РРР\\\"\",\"ID\":\"StartState3\",\"shadow\":{\"offset\":[1,1],\"color\":\"#333333\",\"blur\":2},\"fillGradient\":{\"direction\":90,\"startColor\":\"red\",\"endColor\":\"#99ccff\"},\"height\":296,\"width\":317,\"left\":293,\"top\":66,\"enable4Glue\":true,\"enable2Glue\":false,\"enable4Connect\":true,\"titleLabelProperties\":{\"type\":\"DrawLabel\",\"lineColor\":\"#000000\"},\"lineWidth\":1,\"keepInParentRect\":false,\"canDrop\":false,\"_constructor\":\"StartState\",\"shapeData\":{\"m00\":1.0000000044743902,\"m01\":0,\"m02\":0.47415211733754015,\"m10\":0,\"m11\":1,\"m12\":0.3399353725198724},\"editProxyProperties\":{\"inlineEditEvent\":\"dblOrKeypress\"},\"canDrag\":true},{\"autoDraw\":false,\"ID\":\"isc_DrawPane_0\",\"height\":\"100%\",\"width\":\"100%\",\"canFocus\":true,\"_constructor\":\"DrawPane\",\"editProxyProperties\":{},\"left\":0,\"top\":0,\"drawItems\":[\"ref:StartState3\"]}]"
              |    },
              |    "textMatchStyle": "exact",
              |    "dataSource": "scenarios_Scr_ScenarioJsonStorage_scenario_DS",
              |    "operationType": "update"
              |}""".stripMargin)

        println("request.toPrettyString")
        println(request.toPrettyString)

        val data = request.getJsonObjectOpt("data")
        val oldData = Json("{}")
        val pp = oldData ++ data

        println("data.toPrettyString")
        println(data.toPrettyString)

        println("pp.toPrettyString")
        println(pp.toPrettyString)

        val jsonStorage_scenario = data.getJsonOpt("jsonStorage_scenario")

        println("jsonStorage_scenario.toPrettyString")
        println(jsonStorage_scenario.toPrettyString)

    }

    test("aaa") {
        val oldData = Json("""{"s": "12356\""}""")
        println(oldData.getString("s"))
    }
}
