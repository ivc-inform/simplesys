@simpleSyS = {} unless @simpleSyS

@simpleSyS.util =
	logProps: (obj) ->
		console.error "Not implementation."
		obj

	getRowNumSelectedGridRecord: (grid) ->
		if grid.canSelectCells and grid.editByCell
			cell = grid.getFocusCell()
			res =
				rowNum: if cell[0] >= 0 then cell[0] else null
				colNum: if cell[1] >= 0 then cell[1] else null
		else
			res =
				rowNum: grid.getFocusRow()
				colNum: null
		res

@simpleSyS.app =
	mainPage   : {}
	logining   :
		URILOGIN : "logic/login",
		URILOGOUT: "logic/logout"
	dataSources: {}
	funcMenus  : {}

@simpleSyS.config = {} unless @simpleSyS.config

@simpleSyS.objects = {} unless @simpleSyS.objects

@simpleSyS.config.confirmDeleting = 	"Вы уверенны в необходимости удаления ?"

@newLine = "\n"

@strEmpty = ""

@simpleSyS.Log = isc.Log

@simpleSyS.LogoutRequiredChannel = "LogoutRequired"

@simpleSyS.LoginRequiredChannel = "LoginRequired"

@simpleSyS.skinsMap =
	"BlackOps"      : "Black"
	"Cupertino"     : "Cupertino"
	"Enterprise"    : "Enterprise"
	"EnterpriseBlue": "Enterprise blue"
	"fleet"         : "Fleet"
	"Graphite"      : "Graphite"
	"SilverWave"    : "Silver wave"
	"Simplicity"    : "Simplicity"
	"SmartClient"   : "SmartClient"
	"standard"      : "Standard"
	"TreeFrog"      : "TreeFrog"

isc.addProperties isc,
                  defineProperty: (obj, prop, desc) ->
	                  Object.defineProperty(obj, prop, desc)
	                  return

isc.addProperties isc,
                  defineProperties: (obj, props) ->
	                  Object.defineProperties(obj, props)
	                  return


isc.defineProperty String.prototype,
                   "bool",
                   get: ->
	                   if not @
		                   false
	                   else
		                   (new RegExp("^(true|1)$", "i")).test(@)

isc.defineProperty String.prototype,
                   "isUppercased",
                   get: ->
	                   if not @
		                   false
	                   else
		                   res = true
		                   for char in @
			                   res = char is "_" or (char.charCodeAt(0) >= "A".charCodeAt(0) and char.charCodeAt(0) <= "A".charCodeAt(0))
			                   break if res is false
		                   return not res

setExpertMode = (value)->
	                   isc.OfflineSS.putBoolean("ExpertModeB626D412-8B9B-1DDC-7B49-FDFC42DB58CC", value)
	                   if value is true
		                   isc.Page.eventClickID = isc.Page.setEvent "click",
			                                                             (target) ->
				                                                             if isc.EventHandler.shiftKeyDown() is true and not isc.isA.Structurer(target.getRootCanvas()) and not isc.isA.PropertiesEditor(target.getRootCanvas()) and isc.isA.Canvas(target)
					                                                             @simpleSyS.StructurerEditor = target.getRootCanvas()
				                                                             return
		                   return
	                   else
		                   if isc.Page.eventClickID?
			                   isc.Page.clearEvent("click", isc.Page.eventClickID)
		                   return

@simpleSyS.checkExpertMode = (mode=false)->
	setExpertMode mode
	return

isc.defineProperty @simpleSyS,
                   "ExpertMode",
                   get: ->
	                   isc.OfflineSS.getBoolean "ExpertModeB626D412-8B9B-1DDC-7B49-FDFC42DB58CC"

                   set: (value)->
	                   setExpertMode value
	                   return

isc.defineProperty @simpleSyS,
                   "PropertiesEditor",
                   set: (value)->
	                   if value.owner.isSelected(value)
		                   isc.PropertiesEditor.create
			                   record: value
	                   else
		                   isc.warn "Record not selected."
	                   return

isc.defineProperty @simpleSyS,
                   "StructurerEditor",
                   set: (value)->
	                   isc.OfflineSS.getFromBase(
	                        value.getIdentifier(),
                             @strEmpty,
                                 (result)->
                                     if not isc.isA.Array(result)
                                         result = [result]

                                     isc.Structurer.create
                                         dataSource: isc.DataSourceStructurer.create()
                                         result    : result
                                         view      : value
                                     return
                            )
	                   return

isc.defineProperty @simpleSyS, "Skin",
                   get: =>
	                   skin = isc.OfflineSS.get("Skin5814FE1C-252A-01C4-11A1-557FA3095D3F")
	                   if @simpleSyS.skinsMap[skin]? then skin else "Enterprise"

                   set: (value)->
	                   if value?
	                       isc.OfflineSS.put("Skin5814FE1C-252A-01C4-11A1-557FA3095D3F", value)
	                   return

@simpleSyS.deleteTab = (tab)=>
	@simpleSyS.app.mainPage?.tabsSet?.removeTab? @simpleSyS.app.mainPage.tabsSet.selectedTab
	if @simpleSyS.app.mainPage?.tabsSet?.isEmpty?()
		@simpleSyS.app.mainPage?.functionGroup?.hide()
	isc.MessagingSS.unsubscribe (tab.pane?.subscribedChannels)
	return

@simpleSyS.getWidthMessageWindow = (str) ->
	width = 200 + (100 * (str.length / 200).toFixed(0))
	maxWidth = (isc.Page.getScreenWidth() / 3 * 2).toFixed(0)

	if width > maxWidth then maxWidth else width

@simpleSyS.guid = ->
	s4 = ->
		Math.floor((1 + Math.random()) * 0x10000)
		.toString(16)
		.substring(1)
	(s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4()).toUpperCase()

@simpleSyS.timeStamp = -> (new Date()).getTime()

@simpleSyS.date = -> new Date()

isc.params.locale = "ru_RU" if isc.params?

@simpleSyS.calcXY_Window = (window) -> if isc.isA.Window(window) is true then window.calcXY_Window();return

@simpleSyS.setFuncMenu = (component) =>
	if @simpleSyS.app.mainPage.funcMenuButton?
		if component?.funcMenu? and (isc.isA.Menu(component.funcMenu) is true or component.funcMenu._constructor is "Menu")
			@simpleSyS.app.mainPage.funcMenuButton.menu = component.funcMenu
		else
			delete @simpleSyS.app.mainPage.funcMenuButton.menu
		return

@simpleSyS.strToHex = (str) ->
	hex = ""
	for char in str
		hex += "/#{char.charCodeAt(0).toString(16)}"
	hex

@simpleSyS.visibilityAsRoot = =>
	if @simpleSyS.app?.login?.toLowerCase() is "root"
		"visible"
	else
		"hidden"

@simpleSyS.visibilityAsNotRoot = =>
	if @simpleSyS.app?.login?.toLowerCase() is "root"
		"hidden"
	else
		"visible"

@simpleSyS.safeException = (message) ->
		try
          throw new Error(message)
		catch e
			if e.track?
				console.error e.track.toString()
			else
				console.error e.toString()
		return

@simpleSyS.checkOwner = (owner, ownerClass) ->

	if not owner?
		simpleSyS.safeException "No pointer to owner."
	else if ownerClass?
		if not isc.isA[ownerClass](owner)
			simpleSyS.safeException "Expected owner be #{ownerClass}, but exesit #{if owner.getClassName then owner.getClassName() else owner}"
	owner



@stringToBool = (val) ->
	if isc.isA.String(val) then val.bool else false

@isFunction = (funcName)-> isc.Class.evaluate("typeof #{funcName}" ) is "function"

