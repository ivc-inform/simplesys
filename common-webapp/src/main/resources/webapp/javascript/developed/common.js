var simpleSyS = window.simpleSyS ? window.simpleSyS : {
    util  : {
        logProps                   : function log(obj) {
            console.log("Logging : %s", obj)
            for (var prop in obj) {
                if (typeof obj[prop] === "function")
                    continue;
                if (Array.isArray(obj[prop]))
                    console.log("Prop: %s: %s", prop, obj[prop].toString())
                else
                    console.log("Prop: %s: %s", prop, obj[prop])
                if (typeof obj[prop] === "object")
                 log(obj[prop])
            }
        },
        getRowNumSelectedGridRecord: function (grid) {
            var rowNum, colNum;
            if (grid.canSelectCells && grid.editByCell) {
                var cell = grid.getFocusCell();
                if (cell[0] >= 0)
                    rowNum = cell[0];
                if (cell[1] >= 0)
                    colNum = cell[1];
            } else {
                rowNum = grid.getFocusRow();
                if (rowNum < 0)
                    rowNum = null;
            }
            //console.log("rowNum: %s, colNum: %s", rowNum, colNum);
            return {"rowNum": rowNum, "colNum": colNum};
        }
    },
    app   : {
        mainPage   : {},
        logining   : {
            URILOGIN : simpleSysContextPath + "logic/login",
            URILOGOUT: simpleSysContextPath + "logic/logout"
        },
        dataSources: {},
        funcMenus  : {}
    },
    config: {
        dataPageSize   : 50,
        drawAheadRatio : 1.3,
        confirmDeleting: "Вы уверенны в необходимости удаления ?"
    },
    objects:{}
};

var newLine = "\n";

var strEmpty = ""

var strict = (function () {
    return !this;
}());

isc.addProperties(
    isc,
    {
        "defineProperty": function (obj, prop, desc) {
            Object.defineProperty(obj, prop, desc)
        }
    }
);

isc.addProperties(
    isc,
    {
        "defineProperties": function (obj, props) {
            Object.defineProperties(obj, props)
        }
    }
)

simpleSyS.config.dataPageSize

isc.defineProperty(
    String.prototype, "bool", {
        get: function () {
            if (!this)
                return false
            else
                return (/^(true|1|"yes"|"да")$/i).test(this);
        }
    }
);

isc.defineProperty(
    String.prototype, "isUppercased", {
        get: function () {
            if (!this)
                return false
            else {
                var res = true
                for (var i = 0; i < this.length; i++) {
                    res = this.charAt(i) == "_" || (this.charCodeAt(i) >= "A".charCodeAt(0) && this.charCodeAt(i) <= "Z".charCodeAt(0))
                    if (!res) break
                }
                return !res
            }
        }
    }
)

isc.defineProperty(
    simpleSyS, "ExpertMode", {
        get: function () {
            return isc.OfflineSS.getBoolean("ExpertModeB626D412-8B9B-1DDC-7B49-FDFC42DB58CC")
        },
        set: function (value) {
            isc.OfflineSS.putBoolean("ExpertModeB626D412-8B9B-1DDC-7B49-FDFC42DB58CC", value)
            if (value)
                isc.Page.eventClickID = isc.Page.setEvent(
                    "click", function (target) {
                        if (EventHandler.shiftKeyDown() && !isc.isA.Structurer(target.getRootCanvas()) && !isc.isA.PropertiesEditor(target.getRootCanvas()) && isc.isA.Canvas(target))
                            simpleSyS.StructurerEditor = target.getRootCanvas()
                    }
                );
            else if (isc.Page.eventClickID)
                isc.Page.clearEvent("click", isc.Page.eventClickID)

        }
    }
)

simpleSyS.checkExpertMode = function () {
    simpleSyS.ExpertMode = simpleSyS.ExpertMode
}

isc.defineProperty(
    simpleSyS, "PropertiesEditor", {
        set: function (value) {
            if (value.owner.isSelected(value))
                isc.PropertiesEditor.create(
                    {
                        record: value
                    }
                )
            else
                isc.warn("Record not selected.")
        }
    }
);

isc.defineProperty(
    simpleSyS, "StructurerEditor", {
        set: function (value) {
            isc.OfflineSS.getFromBase(
                value.getIdentifier(), strEmpty, function (result) {
                    if (!isc.isA.Array(result)) result = [result]

                    isc.Structurer.create(
                        {
                            dataSource: isc.DataSourceStructurer.create(),
                            result    : result,
                            view      : value
                        }
                    )
                }
            )

        }
    }
);

isc.defineProperty(
    simpleSyS, "Skin", {
        get: function () {
            return isc.OfflineSS.get("Skin5814FE1C-252A-01C4-11A1-557FA3095D3F") || "Enterprise"
        },
        set: function (value) {
            isc.OfflineSS.put("Skin5814FE1C-252A-01C4-11A1-557FA3095D3F", value)
        }
    }
);

simpleSyS.Log = isc.Log;

simpleSyS.refreshDocumentDomain = function () {
    if (!window.isc && document.domain && document.domain.indexOf(".") != -1
        && !(new RegExp("^(\\d{1,3}\\.){3}\\d{1,3}$").test(document.domain))) {

        var set = false;
        while (document.domain.indexOf(".") != -1) {
            try {
                if (window.opener && window.opener.isc) break;
                if (window.top.isc) break;

                if (!set) {
                    document.domain = document.domain;
                    set = true;
                }
                else {
                    document.domain = document.domain.replace(/.*?\./, '');
                }
            } catch (e) {
                try {
                    if (!set) {
                        document.domain = document.domain;
                        set = true
                    }
                    else {
                        document.domain = document.domain.replace(/.*?\./, '');
                    }
                } catch (ee) {
                    break;
                }
            }
        }
    }
}

simpleSyS.deleteTab = function (tab) {
    simpleSyS.app.mainPage.tabsSet.removeTab(simpleSyS.app.mainPage.tabsSet.selectedTab)
    tab.pane && tab.pane.subscribedChannels && isc.MessagingSS.unsubscribe(tab.pane.subscribedChannels)
    if (simpleSyS.app.mainPage.tabsSet.tabs.length == 0)
        simpleSyS.app.mainPage.functionGroup.hide();
}

simpleSyS.getWidthMessageWindow = function (str) {

    var width = 200 + (100 * (str.length / 200).toFixed(0));
    var maxWidth = (isc.Page.getScreenWidth() / 3 * 2).toFixed(0);

    if (width > maxWidth)
        width = maxWidth;

    return width;
}

simpleSyS.guid = function () {
    function s4() {
        return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
    };

    return (s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4()).toUpperCase();
}

simpleSyS.timeStamp = function () {
    return new Date().getTime();
}

simpleSyS.date = function () {
    return new Date();
}

if (isc.params) isc.params.locale = "ru_RU"
//if (isc.params) isc.params.locale = "en"


simpleSyS.calcXY_Window = function (window) {
    if (isc.isA.Window(window))
        window.calcXY_Window()
}

simpleSyS.setFuncMenu = function (component) {
    if (simpleSyS.app.mainPage.funcMenuButton) {
        if (!component.funcMenu)
            simpleSyS.app.mainPage.funcMenuButton.menu = undefined
        else {
            var menuItems = component.funcMenu.getItems()

            function existsItem(title) {
                return (menuItems.filter(
                    function (item) {
                        return item.title == title
                    }
                ).length > 0)
            }

            component.funcMenu.setItems(menuItems)

            simpleSyS.app.mainPage.funcMenuButton.menu = component.funcMenu
        }
    }
}

simpleSyS.strToHex = function (str) {
    var hex = '';
    for (var i = 0; i < str.length; i++) {
        hex += '/' + str.charCodeAt(i).toString(16);
    }
    return hex;
}

simpleSyS.sleep = function (value) {
    var start = new Date().getTime();
    for (var i = 0; i < 1e7; i++) {
        if ((new Date().getTime() - start) > value) {
            break;
        }
    }
}

function stringToBool(val) {
    if (isc.isA.String(val))
        return val.bool
    else
        return false
}

function isFunction(funcName) {
    return (isc.Class.evaluate("typeof " + funcName) === "function")
}
