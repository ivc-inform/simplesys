function canselEdited() {
    if (simpleSyS.checkOwner(this.owner))
       this.owner.discardAllEdits();
}

function canselListEdited() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.discardAllEdits();
}

function canselTreeEdited() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.discardAllEdits();
}

function deleteTab(target, item) {
    simpleSyS.deleteTab(target, item)
}

function editRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditing();
}

function editListRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditing();
}

function editTreeRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditing();
}

function newListGridEditorRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditingNew(this.owner.dataSource.wildRecordJS);
}

function enableOpenFolders() {
  if (simpleSyS.checkOwner(this.owner))
    return  this.owner.getSelectedRecords().length > 0
}

function newTreeGridEditorRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditingNew();
}

function newListRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditingNew();
}

function newTreeRow() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.startEditingNew();
}

function refresh() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.fullRefresh();
}

function refreshList() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.fullRefresh();
}

function refreshTree() {
    if (simpleSyS.checkOwner(this.owner))
      this.owner.fullRefresh();
}

function enableSaveOrCanceledEditing() {
    if (simpleSyS.checkOwner(this.owner))
        return this.owner.hasChanges();
}

function removeRow() {
    if (simpleSyS.checkOwner(this.owner)){
        var that = this
        isc.ask(
            simpleSyS.config.confirmDeleting, function (value) {
                if (value) that.owner.removeSelectedData();
            }
        )
    }
}

function removeListRow() {
    var that = this
    if (simpleSyS.checkOwner(this.owner))
        isc.ask(
            simpleSyS.config.confirmDeleting, function (value) {
                if (value) that.owner.removeSelectedData();
            }
        )
}

function removeTreeRow() {
    var that = this
    if (simpleSyS.checkOwner(this.owner))
        isc.ask(
            simpleSyS.config.confirmDeleting, function (value) {
                if (value) that.owner.removeSelectedData();
            }
        )
}

function saveRecords() {
    if (simpleSyS.checkOwner(this.owner))
        this.owner.saveAllEdits();
}

function saveListRecords() {
    if (simpleSyS.checkOwner(this.owner))
        this.owner.saveAllEdits();
}

function saveTreeRecords() {
    if (simpleSyS.checkOwner(this.owner))
        this.owner.saveAllEdits();
}

function enableEdit() {
    if (simpleSyS.checkOwner(this.owner))
        return this.owner.getSelectedRecords().length == 1
}

function enableDelete() {
    if (simpleSyS.checkOwner(this.owner))
        return this.owner.getSelectedRecords().length > 0
}

function enableDeleteFromTree() {
    return simpleSyS._enableDeleteFromTree(this)
}

function enableSave() {
    if (simpleSyS.checkOwner(this.owner))
        return this.owner.hasChanges() && !this.owner.hasErrors()
}

function enableDeleteTable() {
    if (simpleSyS.checkOwner(this.owner))
        return this.owner.tabsSet && (this.owner.tabsSet.tabs.length != 0)
}

function showMenu() {
    this.showMenu();
}

function onMainMenuItemClick() {
}

function login() {
    isc.RPCManagerSS.loginRequired();
}

function logout() {
    isc.RPCManagerSS.logoutRequired();
}

function getTab(target, item) {
    simpleSyS.getTab(target, item);
}

function getTabHand(target, item) {
    simpleSyS.getTabHand(target, item);
}

function canReparentNodes() {
    if (simpleSyS.checkOwner(this.owner)){
        var x = !this.owner.grid.canReparentNodes;
        this.owner.grid.canReparentNodes = x;
        this.checkIf = function () {
            return x;
        }
    }
}

function canReparentNodesTree() {
    if (simpleSyS.checkOwner(this.owner)){
        var x = !this.owner.grid.canReparentNodes;
        this.owner.grid.canReparentNodes = x;
        this.checkIf = function () {
            return x;
        }
    }
}

function underconstruction() {
    isc.info("Sorry, it's under construction.")
}

function consarvationDict() {
    simpleSyS._consarvationDict()
}

function deConsarvationDict() {
    simpleSyS._deConsarvationDict()
}

function consarvationDictDB() {
    simpleSyS._consarvationDictDB()
}

function deConsarvationDictDB() {
    simpleSyS._deConsarvationDictDB()
}

function downLoadDict() {
    simpleSyS._downloadDict()
}

function upLoadDict() {
    simpleSyS._uploadDict()
}

function getGuid() {
    isc.info(simpleSyS.guid())
}

function saveViewState() {
    this.owner.saveViewState()
}

function restoreViewState() {
    if (simpleSyS.checkOwner(this.owner))
        this.owner.restoreViewState()
}

function openFolders() {
    simpleSyS._openFolders(this);
}

function initListGridEditor() {
    simpleSyS._initMenus(this);
    /*simpleSyS._RecordComponent(this, "create");
          simpleSyS._RecordComponent(this, "update");*/
}

function initTreeGridEditor() {
    simpleSyS._initMenus(this);
    /*simpleSyS._RecordComponent(this, "create");
         simpleSyS._RecordComponent(this, "update");*/
}

function getSettings() {
    _getSettings() //Не менять
}

function visibilityAsRoot() {
    return simpleSyS.visibilityAsRoot()
}

function visibilityAsNotRoot() {
    return simpleSyS.visibilityAsNotRoot()
}

function notVisibility() {
    return false
}
