package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonNull, JsonElement, JsonObject, JsonList}
import com.simplesys.isc.grids.RecordsDynList
import com.simplesys.common.Strings._
import RPC.RPCRequestDynInit
import com.simplesys.isc.grids.treeGrid.TreeNodeDyn
import com.simplesys.isc.RPC.TransactionDyn

trait DSRequestDynInit extends RPCRequestDynInit {
    protected val additionalOutputs: String = ""
    override protected val callback: DSCallback = ""
    protected val componentId: String = ""
    private[dataBinging] val channelMessage4AddOperation: String = "ListElements_Add"
    private[dataBinging] val channelMessage4EndAddOperation: String = "ListElements_EndAdd"
    protected val dataSource: JsonElement = JsonNull
    protected val endRow: Number = 0
    protected val exportAs: ExportFormat = noneFmt
    protected val exportData: RecordsDynList = null
    protected val exportDatesAsFormattedString: Bool = false
    protected val exportDelimiter: String = ""
    protected val exportDisplay: ExportDisplay = expDispDownload
    protected val exportFields: JsonObject = JsonObject()
    protected val exportFilename: String = ""
    protected val exportFooter: String = ""
    protected val exportHeader: String = ""
    protected val exportPath: String = ""
    protected val exportResults: Bool = false
    protected val exportTitleSeparatorChar: String = ""
    protected val exportToClient: Bool = true
    protected val exportToFilesystem: Bool = false
    protected val exportValueFields: Bool = false
    protected val headerData: JsonObject = JsonObject()
    protected val lineBreakStyle: String = ""
    protected val oldValues: JsonObject = JsonObject()
    protected val operationId: String = ""
    protected val operationType: DSOperationType = dsOptTypeNull
    protected val parentNode: TreeNodeDyn = null
    protected val requestId: String = "varies"
    protected val resultSet: ResultSetDyn = null
    protected val resultTree: ResultTreeDyn = null
    protected val sortBy: JsonList = JsonList()
    protected val startRow: Number = 0
    protected val streamResults: String = ""
    protected val transaction: TransactionDyn = JsonObject()
    protected val textMatchStyle: TextMatchStyle = txtMchStyleExact
    protected val useFlatFields: Bool = false
    protected val useFlatHeaderFields: Bool = false
    protected val validationMode: ValidationMode = vldModeFull
    private[dataBinging] val subscribedChannels: JsonList = JsonList()
    private[dataBinging] val subscriberName: String = strEmpty
}
