import com.simplesys.isc.control.IButtonDyn
import com.simplesys.isc.control.menu.MenuItemDyn
import com.simplesys.isc.dataBinging.dataSource.OperationBindingDyn
import com.simplesys.isc.dataBinging.{RestDataSourceDyn, DSRequestDyn, DataSourceFieldDyn, DataSourceDyn}
import com.simplesys.isc.forms.{DynamicFormDyn, ValidatorDyn}
import com.simplesys.isc.dataBinging.RestDataSourceDyn._
import com.simplesys.isc.grids.ListGridDyn
import com.simplesys.isc.layout.{HLayoutDyn, VLayoutDyn}
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.{QueuesDyn, PageDyn, ArrayDyn, IscDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonList
import com.simplesys.log.Logging
import org.scalatest.FunSuite
import com.simplesys.isc.system.misc._

class TestPaternReuse extends FunSuite with Logging {
  test("1") {
    val _Isc = IscDyn()
    ModeNames = PortalMode

    _Isc componentEnqueue new PageDyn {
      setAppImgDir("imgs/")
    }

    val countryDS = new RestDataSourceDyn(useSelfName = true) {
      AddDataURL = "/path/path1"
      ID = "countryDS"
      RecordName = "country"
      TestFileName = "/ds/country.data.xml"
      OperationBindings = ArrayDyn(
        new OperationBindingDyn {
          OperationType = dsOptTypeUpdate
          DataFormat = dtftJSON
          DataProtocol = dsprtPostMessage
          RequestProperties = new DSRequestDyn {
            HttpMethod = "PUT"
          }
        }
      )
      Fields = ArrayDyn(
        new DataSourceFieldDyn {
          Name = "pk"
          Type = ftInteger
          Hidden = true
          PrimaryKey = true
        },
        new DataSourceFieldDyn {
          Name = "countryCode"
          Type = ftText
          Title = "Code"
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "countryName"
          Type = ftText
          Title = "Country"
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "capital"
          Type = ftText
          Title = "Capital"
        },
        new DataSourceFieldDyn {
          Name = "government"
          Type = ftText
          Title = "Government"
          Length = 500
        },
        new DataSourceFieldDyn {
          Name = "continent"
          Type = ftText
          Title = "Continent"
          ValueMap = JsonList(
            "Europe",
            "Asia",
            "North America",
            "Australia/Oceania",
            "South America",
            "South America"
          )
        },
        new DataSourceFieldDyn {
          Name = "member_g8"
          Type = ftBoolean
          Title = "G8"
        },
        new DataSourceFieldDyn {
          Name = "independence"
          Type = ftDate
          Title = "Nationhood"
        },
        new DataSourceFieldDyn {
          Name = "area"
          Type = ftFloat
          Title = "Area (km&amp;sup2;)"
        },
        new DataSourceFieldDyn {
          Name = "population"
          Type = ftInteger
          Title = "Population"
        },
        new DataSourceFieldDyn {
          Name = "gdp"
          Type = ftFloat
          Title = "GDP ($M)"
        },
        new DataSourceFieldDyn {
          Name = "article"
          Type = ftLink
          Title = "Info"
          Detail = true
        }
      )
    }

    val supplyItem = new DataSourceDyn(useSelfName = true) {
      ID = "supplyItem"
      ServerType = srvtpSQL
      TableName = "supplyItem"
      TitleField = "itemName"
      TestFileName = "/ds/supplyItem.data.xml"
      DbImportFileName = "/ds/supplyItemLarge.data.xml"
      Fields = ArrayDyn(
        new DataSourceFieldDyn {
          Name = "itemID"
          Type = ftSequence
          Hidden = true
          PrimaryKey = true
        },
        new DataSourceFieldDyn {
          Name = "itemName"
          Type = ftText
          Title = "Item"
          Length = 128
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "SKU"
          Type = ftText
          Title = "SKU"
          Length = 10
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "description"
          Type = ftText
          Title = "Description"
          Length = 2000
        },
        new DataSourceFieldDyn {
          Name = "category"
          Type = ftText
          Title = "Category"
          Length = 128
          Required = true
          ForeignKey = "supplyCategory.categoryName"

        },
        new DataSourceFieldDyn {
          Name = "units"
          Type = ftEnum
          Title = "Continent"
          ValueMap = JsonList(
            "Roll",
            "Ea",
            "Pkt",
            "Set",
            "Tube",
            "Pad",
            "Ream",
            "Tin",
            "Bag",
            "Ctn",
            "Box")
        },
        new DataSourceFieldDyn {
          Name = "unitCost"
          Type = ftFloat
          Title = "Unit Cost"
          Required = true
          Validators = ArrayDyn(
            new ValidatorDyn {
              Type = vldTpFloatRange
              Min = 0
              ErrorMessage = "Please enter a valid (positive) cost"
            },
            new ValidatorDyn {
              Type = vldTpFloatPrecision
              Precision = 2
              ErrorMessage = "The maximum allowed precision is 2"
            }
          )
        },
        new DataSourceFieldDyn {
          Name = "inStock"
          Type = ftBoolean
          Title = "In Stock"
        },
        new DataSourceFieldDyn {
          Name = "nextShipment"
          Type = ftDate
          Title = "Next Shipment"
        }
      )
    }

    _Isc componentsEnqueue(countryDS, supplyItem)

    val dSource: DataSourceDyn = countryDS

    val form = new DynamicFormDyn(useSelfName = true) {
      ID = "formEdit"
      AutoDraw = false
      DataSource = dSource
      NumCols = 2
      ColWidths = JsonList(
        "20".%,
        "*"
      )
    }

    val saveButton = new IButtonDyn(useSelfName = true) {
      Disabled = true
      AutoDraw = false
      LayoutAlign = AlCenter
      Title = "Save"
      Click = "formEdit.saveData()".f
    }

    val editorLayout = new VLayoutDyn(useSelfName = true) {
      AutoDraw = false
      MembersMargin = 5
      Members = ArrayDyn(
        form,
        saveButton
      )
    }

    val grid = new ListGridDyn(useSelfName = true) {
      AutoDraw = false
      ShowResizeBar = true
      DataSource = dSource
      AutoFetchData = true
      RecordClick = _Isc.declareJSFunction(this, "recordClick", "{}", true, "viewer, record, rowNum, field, fieldNum, value, rawValue")
    }

    val base = new HLayoutDyn(useSelfName = true) {
      ID = "baseLayout"
      Width = "100".%
      Height = "100".%
      Members = ArrayDyn(
        grid,
        editorLayout
      )
    }

    _Isc componentEnqueue base

    _Isc logCommandLine()
  }

  test("2") {
    val _Isc = IscDyn()
    ModeNames = PortalMode

    val req = new DSRequestDyn(useSelfName = true) {
      ID = "req"
      HttpMethod = "PUT"
    }

    //_Isc componentEnqueue req

    val op = new OperationBindingDyn {
      ID = "op"
      OperationType = dsOptTypeUpdate
      DataFormat = dtftJSON
      DataProtocol = dsprtPostXML
      QualifyColumnNames = false
      RequestProperties = req
    }

    _Isc componentEnqueue op

    /*_Isc componentEnqueue new RestDataSourceDyn(useSelfName = true) {
      ID = "supplyItem"
      FetchDataURL = "/ds/supplyItemLarge.data1.xml"
      UpdateDataURL = "/PaternReUsedFetch"
      OperationBindings = ArrayDyn(
        op
      )
    }*/

    _Isc logCommandLine()
  }

  test("MenuItem") {
    val _Isc = IscDyn()
    ModeNames = PortalMode

    _Isc componentEnqueue(_class = new MenuItemDyn {
      Enabled = false
      Title = "Сохранить"
      KeyTitle = "Ctrl+S"
      Icon = "enzo/Save-icon.png"
      Click = _Isc.declareJSFunction(this, "SaveData", """{
                formEdit.saveData();
                changed = false;
              }""")
      new KeyIdentifier {
        KeyName = "S"
        CtrlKey = true
      }
    }, componentLine = QueuesDyn.getComponentLineOnlyJson)

    _Isc.logCommandLine()
  }

  test("3") {
    val _Isc = IscDyn()
    ModeNames = PortalMode

    _Isc componentEnqueue new PageDyn {
      setAppImgDir("imgs/")
    }

    val countryDS = new RestDataSourceDyn(useSelfName = true) {
      /*AddDataURL = "/path/path1"
      ID = "countryDS"
      RecordName = "country"
      TestFileName = "/ds/country.data.xml"
      OperationBindings = ArrayDyn(
        new OperationBindingDyn {
          OperationType = dsOptTypeUpdate
          DataFormat = dtftJSON
          DataProtocol = dsprtPostMessage
          RequestProperties = new DSRequestDyn {
            HttpMethod = "PUT"
          }
        }
      )*/
      Fields = ArrayDyn(
        new DataSourceFieldDyn {
          Name = "pk"
          Type = ftInteger
          Hidden = true
          PrimaryKey = true
          IdArrayItem = "itemID"
        },
        new DataSourceFieldDyn {
          Name = "countryCode"
          Type = ftText
          Title = "Code"
          Required = true
        }
      )
    }

    _Isc componentEnqueue countryDS
    //_Isc logCommandLine()

    val supplyItem = new RestDataSourceDyn(useSelfName = true) {
      /*ID = "supplyItem"
      ServerType = srvtpSQL
      TableName = "supplyItem"
      TitleField = "itemName"
      TestFileName = "/ds/supplyItem.data.xml"
      DbImportFileName = "/ds/supplyItemLarge.data.xml"*/
      Fields = ArrayDyn(
        new DataSourceFieldDyn {
          Name = "itemID"
          Type = ftSequence
          Hidden = true
          PrimaryKey = true
          IdArrayItem = "itemID"
        } /*,
        new DataSourceFieldDyn {
          Name = "itemName"
          Type = ftText
          Title = "Item"
          Length = 128
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "SKU"
          Type = ftText
          Title = "SKU"
          Length = 10
          Required = true
        },
        new DataSourceFieldDyn {
          Name = "description"
          Type = ftText
          Title = "Description"
          Length = 2000
        },
        new DataSourceFieldDyn {
          Name = "category"
          Type = ftText
          Title = "Category"
          Length = 128
          Required = true
          ForeignKey = "supplyCategory.categoryName"

        },
        new DataSourceFieldDyn {
          Name = "units"
          Type = ftEnum
          Title = "Continent"
          ValueMap = JsonList(
            "Roll",
            "Ea",
            "Pkt",
            "Set",
            "Tube",
            "Pad",
            "Ream",
            "Tin",
            "Bag",
            "Ctn",
            "Box")
        },
        new DataSourceFieldDyn {
          Name = "unitCost"
          Type = ftFloat
          Title = "Unit Cost"
          Required = true
          Validators = ArrayDyn(
            new ValidatorDyn {
              Type = vldTpFloatRange
              Min = 0
              ErrorMessage = "Please enter a valid (positive) cost"
            },
            new ValidatorDyn {
              Type = vldTpFloatPrecision
              Precision = 2
              ErrorMessage = "The maximum allowed precision is 2"
            }
          )
        },
        new DataSourceFieldDyn {
          Name = "inStock"
          Type = ftBoolean
          Title = "In Stock"
        },
        new DataSourceFieldDyn {
          Name = "nextShipment"
          Type = ftDate
          Title = "Next Shipment"
        }*/
      )
    }
    _Isc componentEnqueue supplyItem

    _Isc componentEnqueue (countryDS ++= supplyItem)

    _Isc logCommandLine()
  }
}
