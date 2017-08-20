function canselEdited() {
    that.discardAllEdits();
}

function canselListEdited() {
    that.discardListAllEdits();
}

function canselTreeEdited() {
    that.discardTreeAllEdits();
}

function deleteTab(target, item) {
    simpleSyS.deleteTab(target, item)
}

function editRow() {
    that.startEditing();
}

function editListRow() {
    that.startListEditing();
}

function editTreeRow() {
    that.startTreeEditing();
}

function newRow() {
    that.startEditingNew();
}

function newListRow() {
    that.startListEditingNew();
}

function newTreeRow() {
    that.startTreeEditingNew();
}

function refresh() {
    that.fullRefresh();
}

function refreshList() {
    that.fullListRefresh();
}

function refreshTree() {
    that.fullTreeRefresh();
}

function removeRow() {
    isc.ask(simpleSyS.config.confirmDeleting, function (value) {
        if (value) that.removeSelectedData();
    })
}

function removeListRow() {
    isc.ask(simpleSyS.config.confirmDeleting, function (value) {
        if (value) that.removeListSelectedData();
    })
}

function removeTreeRow() {
    isc.ask(simpleSyS.config.confirmDeleting, function (value) {
        if (value) that.removeTreeSelectedData();
    })
}

function saveRecords() {
    that.saveAllEdits();
}

function saveListRecords() {
    that.saveListAllEdits();
}

function saveTreeRecords() {
    that.saveTreeAllEdits();
}

function enableDeleteTable() {
    return simpleSyS.enzo.mainPage.tabsSet.tabs.length != 0;
}

function showMenu() {
    this.showMenu();
}

function showAllChild() {
    return this.showAllChild;
}

function onMainMenuItemClick() {
}

function login() {
    isc.RPCManager.loginRequired();
}

function logout() {
    isc.RPCManager.logoutRequired();
}

function getTab(target, item) {
    simpleSyS.getTab(target, item);
}

function canReparentNodes() {

    var x = !that.canReparentNodes;
    that.canReparentNodes = x;
    that.canAcceptDroppedRecords = x;
    this.checkIf = function () {
        return x;
    }
}

function canReparentNodesTree() {
    var x = !that.canReparentNodesTree;
    that.canReparentNodesTree = x;
    that.canAcceptDroppedRecordsTree = x;
    this.checkIf = function () {
        return x;
    }
}