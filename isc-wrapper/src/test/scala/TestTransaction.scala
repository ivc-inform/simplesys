import com.simplesys.isc.control.IButtonDyn
import com.simplesys.isc.dataBinging.{JSONEncoderDyn, JSONDyn, DSRequestDyn}
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.layout.window.HeaderIconDefaultsDyn
import com.simplesys.isc.layout.window.HeaderIconDefaultsDyn._
import com.simplesys.isc.layout.{LayoutSpacerDyn, HLayoutDyn, VLayoutDyn, WindowDyn}
import com.simplesys.isc.layout.HLayoutDyn._
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.{ClassDyn, ArrayDyn, IscDyn}
import com.simplesys.json.{JsonList, JsonObject, Json}
import com.simplesys.log.Logging
import com.simplesys.script.JsBeautifier
import org.scalatest.FunSuite
import com.simplesys.isc.system.typesDyn.{jsonInstSrlzSkip, AlCenter}
import com.simplesys.isc.system.misc._

class TestTransaction extends FunSuite with Logging {
    test(s"delete Trans") {
        val json = Json( """{
                           |    "transaction": {
                           |        "operations": [{
                           |            "componentId": "isc_ListGrid_1",
                           |            "data": {
                           |                "acn": "finbank",
                           |                "templStr": "$LOCALDATETIME_podtverdite_oplatu_zadolzennosti_$T{po}_karte_$T{$CARDNUMBER}_summa_$MONEY_odnorazoviy_parol_$T{$STRING}",
                           |                "mode": "trueFixed"
                           |            },
                           |            "textMatchStyle": "exact",
                           |            "dataSource": "TrueTemplateGridManagerOfFixedTemplates_DS",
                           |            "operationType": "remove",
                           |            "oldValues": {
                           |                "acn": "finbank",
                           |                "isAllExamplesApplicable": true,
                           |                "templStr": "$LOCALDATETIME_podtverdite_oplatu_zadolzennosti_$T{po}_karte_$T{$CARDNUMBER}_summa_$MONEY_odnorazoviy_parol_$T{$STRING}",
                           |                "isIgnoreData": false,
                           |                "isValidated": true,
                           |                "createDateTime": "2015-03-12T18:22:59.641",
                           |                "creatorUserName": "system"
                           |            }
                           |        }, {
                           |            "componentId": "isc_ListGrid_1",
                           |            "data": {
                           |                "acn": "finbank",
                           |                "templStr": "$LOCALDATETIME_podtverdite_oplatu_zadolzennosti_$T{po}_karte_$T{$CARDNUMBER}_summa_$MONEY_odnorazoviy_parol_$T{$STRING}",
                           |                "mode": "trueFixed"
                           |            },
                           |            "textMatchStyle": "exact",
                           |            "dataSource": "TrueTemplateGridManagerOfFixedTemplates_DS",
                           |            "operationType": "remove",
                           |            "oldValues": {
                           |                "acn": "finbank",
                           |                "isAllExamplesApplicable": true,
                           |                "templStr": "$LOCALDATETIME_podtverdite_otkritie_vklada_vid_vklada_$T{$VARSTRING}_summa_$MONEY_srok_$T{$LONG}_odnorazoviy_parol_$T{$STRING}",
                           |                "isIgnoreData": false,
                           |                "isValidated": true,
                           |                "createDateTime": "2015-03-12T18:22:59.941",
                           |                "creatorUserName": "system"
                           |            }
                           |        }, {
                           |            "componentId": "isc_ListGrid_1",
                           |            "data": {
                           |                "acn": "finbank",
                           |                "templStr": "$LOCALDATETIME_podtverdite_oplatu_zadolzennosti_$T{po}_karte_$T{$CARDNUMBER}_summa_$MONEY_odnorazoviy_parol_$T{$STRING}",
                           |                "mode": "trueFixed"
                           |            },
                           |            "textMatchStyle": "exact",
                           |            "dataSource": "TrueTemplateGridManagerOfFixedTemplates_DS",
                           |            "operationType": "remove",
                           |            "oldValues": {
                           |                "acn": "finbank",
                           |                "isAllExamplesApplicable": true,
                           |                "templStr": "$LOCALDATETIME_podtverdite_popolnenie_vklada_vid_vklada_$T{$VARSTRING}_summa_$MONEY_odnorazoviy_parol_$T{$STRING}",
                           |                "isIgnoreData": false,
                           |                "isValidated": true,
                           |                "createDateTime": "2015-03-12T18:22:59.374",
                           |                "creatorUserName": "system"
                           |            }
                           |        }],
                           |        "transactionNum": 16
                           |    }
                           |}""".stripMargin)

        //logger debug (s"json: ${json.toPrettyString}")
        val transaction = (new DSRequestDyn(json)).Transaction
        /*logger debug (s"transaction: ${transaction.toPrettyString}")
        logger debug (s"transactionNum: ${transaction.TransactionNum}")*/
        val operations = transaction.Operations

        operations foreach {
            _ match {
                case data: JsonObject =>

                    logger debug (s"data: ${data.toPrettyString}")
                    val _data = data.getJsonObject("data")

                    val acn = _data.getString("acn")
                    val mode = _data.getString("mode")
                    val templStr = _data.getString("templStr")

                    logger debug (s"acn: $acn")
                    logger debug (s"mode: $mode")
                    logger debug (s"templStr: $templStr")

                case _ =>
            }
        }
        //logger debug (s"operations: ${operations.toPrettyString}")
    }

    test("headerIconDefaults") {
        val _Isc = IscDyn()
        ModeNames = PortalMode

        val windowEditor = new WindowDyn(useSelfName = true) {
            Identifier = "that.identifier".unq
            ID = "that.identifier"
            Title = "that.title".unq
            HeaderIconDefaults = new HeaderIconDefaultsDyn {
                Src = "that.imgPath + 'group.png'".unq
                Width = 16
                Height = 14
            }
            AutoDraw = false
            CanDragResize = true
            Width = 500
            Height = 600
            IsModal = true
            AnimateMinimize = true
            AnimateMembers = true
            ShowMinimizeButton = false
            ShowCloseButton = false
            KeepInParentRect = true
            Items = ArrayDyn(
                new VLayoutDyn(useSelfName = true) {
                    Members = JsonList(
                        "that.editor".unq,
                        new HLayoutDyn(useSelfName = true) {
                            Height = "35"
                            DefaultLayoutAlign = AlCenter
                            Members = ArrayDyn(
                                new LayoutSpacerDyn(useSelfName = true) {
                                    Width = "*"
                                },
                                new IButtonDyn(useSelfName = true) {
                                    Width = 100
                                    Title = "Выбрать".ellps
                                    Icon = "that.imgPath + 'ok.png'".unq
                                    Click = "that.okButtonClick".f
                                },
                                new LayoutSpacerDyn(useSelfName = true) {
                                    Width = "*"
                                },
                                new LayoutSpacerDyn(useSelfName = true) {
                                    Width = "*"
                                },
                                new IButtonDyn(useSelfName = true) {
                                    Width = 100
                                    Title = "Отменить".ellps
                                    Icon = "that.imgPath + 'cancel.png'".unq
                                    Click = "that.cancelButtonClick".f
                                },
                                new LayoutSpacerDyn(useSelfName = true) {
                                    Width = "*"
                                }
                            )
                        }
                    )
                }
            )
        }

        /*_Isc.componentEnqueue(windowEditor, (s"windowEditor", false))*/
        _Isc componentEnqueue windowEditor

        _Isc.logCommandLine()
    }

    test(s"Class") {
        val _Isc = IscDyn()
        ModeNames = PortalMode
        val cl = new ClassDyn(useSelfName = true)
        cl.addClassMethods(JsonObject())

        val cv = new CanvasDyn(fabriqueClass = true)
        cv.imgHTML(src = "item.icon", width = 16, height = 14)

        _Isc componentsEnqueue(cl, cv)
        _Isc logCommandLine()
    }

    test(s"JSONDyn") {
        val isc = IscDyn()
        val json = new JSONDyn()
        json.encode(
            "that.getTreeSelection()".unq,
            new JSONEncoderDyn {
                PrettyPrint = false
                SerializeInstances = jsonInstSrlzSkip
            })

        isc componentEnqueue json
        isc logCommandLine()
    }
}