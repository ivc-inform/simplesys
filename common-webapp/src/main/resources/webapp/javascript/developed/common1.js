function _initMenus(that) {
    that.Super("initWidget", arguments);

    that.grid.canReparentNodes = false //Не убирать, необходима для TreeGridEditor

    that.funcMenu && that.funcMenu.items.forEach(
        function (item) {
            item.owner = that
        }
    )

    that.contextMenu && that.contextMenu.items.forEach(
        function (item) {
            item.owner = that
        }
    )
}

function _RecordComponent(that, mode) {
    var funcName = "_" + mode + "RecordComponent"
    if (isFunction(funcName)) {
        try {
            that.evaluate(funcName + "(that)", {"that": that})
        } catch (e) {
            that.logError(e)
        }
    }
}

function _enableDeleteFromTree(that) {
    var owner = that.owner
    var records = owner.getSelectedRecords()
    var res = owner.getSelectedRecords().length > 0
    var dataSource = owner.dataSource
    var pkFields = dataSource.getPrimaryKeyFieldNames()

    if (records.length > 0) {

        for (var i = 0; i < records.length; i++) {
            var pk = pkFields.map(
                function (field) {
                    return (records[i])[field]
                }
            )

            var tree = owner.grid.data
            var node = tree.findById(pk)
            if (tree.isFolder(node)) {
                res = false
                break
            }
        }
    }
    return res
}

function _openFolders(that) {
    var owner = that.owner
    var records = owner.getSelectedRecords()
    var dataSource = owner.dataSource
    var pkFields = dataSource.getPrimaryKeyFieldNames()
    var nodes = []

    function _openFolders1(nodes) {
        nodes.forEach(
            function (node) {
                var nodes1 = tree.getChildren(node)
                nodes1 && _openFolders1(nodes1)
                tree.openFolder(node)
            }
        )
    }

    if (records.length > 0) {
        for (var i = 0; i < records.length; i++) {
            var pk = pkFields.map(
                function (field) {
                    return (records[i])[field]
                }
            )

            var tree = owner.grid.data
            var node = tree.findById(pk)
            if (tree.isFolder(node))
                nodes.add(node)
        }
        _openFolders1(nodes)
    }
}

