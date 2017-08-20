package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonString, JsonElement, JsonList, JsonObject}
import RPC.RPCRequestDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.grids.RecordsDynList
import com.simplesys.isc.grids.treeGrid.TreeNodeDyn
import com.simplesys.servlet.http.HttpServletRequest
import com.simplesys.isc.RPC.TransactionDyn

object DSRequestDyn {
    implicit def DSRequest1toJsonObject(in: DSRequestDyn): JsonObject = in json

    implicit class DSRequestDynOpts(request: HttpServletRequest) {
        def toDSRequest: DSRequestDyn = new DSRequestDyn(request.JSONData)
        def toDSRequest(useSelfName: Boolean): DSRequestDyn = new DSRequestDyn(request.JSONData, useSelfName)
    }
}

class DSRequestDyn(override val inJson: JsonObject = null,
                   override val useSelfName: Boolean = false) extends RPCRequestDyn with DSRequestDynInit {

    def this(request: HttpServletRequest) = this(request.JSONData/*.trim*/) //Не убирать !!!!!!!!

    override val selfName = "DSRequest"

    def AdditionalOutputs = json.getStringOpt("additionalOutputs").getOrElse(additionalOutputs)
    def AdditionalOutputs_=(value: String) {
        if (AdditionalOutputs == value) return
        json("additionalOutputs") = value
    }

    override def Callback = json.getValue2[JsonString, DSCallback]("callback").getOrElse(callback)
    override def Callback_=(value: DSCallback) {
        if (Callback == value) return
        json("callback") = value
    }


    def ComponentId = json.getStringOpt("componentId").getOrElse(componentId)
    def ComponentId_=(value: String) {
        if (ComponentId == value) return
        json("componentId") = value
    }

    def ChannelMessage4AddOperation = json.getStringOpt("channelMessage4AddOperation").getOrElse(channelMessage4AddOperation)
    def ChannelMessage4AddOperationOpt = json.getStringOpt("channelMessage4AddOperation")
    def ChannelMessage4AddOperation_=(value: String) {
        if (ChannelMessage4AddOperation == value) return
        json("channelMessage4AddOperation") = value
    }

    def ChannelMessage4EndAddOperation = json.getStringOpt("channelMessage4EndAddOperation").getOrElse(channelMessage4EndAddOperation)
    def ChannelMessage4EndAddOperationOpt = json.getStringOpt("channelMessage4EndAddOperation")
    def ChannelMessage4EndAddOperation_= (value: String) {
        if (ChannelMessage4EndAddOperation == value) return
        json("channelMessage4EndAddOperation") = value
    }

    def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
    def DataSource_=(value: JsonElement) {
        if (DataSource == value) return
        json("dataSource") = value
    }

    def EndRow = json.getNumberOpt("endRow").getOrElse(endRow)
    def EndRow_=(value: Number) {
        if (EndRow == value) return
        json("endRow") = value
    }

    private[this] var _exportAs: ExportFormat = exportAs
    def ExportAs = json.getValue2[JsonString, ExportFormat]("exportAs").getOrElse(exportAs)
    def ExportAs_=(value: ExportFormat) {
        if (_exportAs == value) return
        json("exportAs") = value
    }


    def ExportData = json.getValue2[JsonList, RecordsDynList]("exportData").getOrElse(exportData)
    def ExportData_=(value: RecordsDynList) {
        if (ExportData == value) return
        json("exportData") = value
    }

    def ExportDatesAsFormattedString = json.getBoolOpt("exportDatesAsFormattedString").getOrElse(exportDatesAsFormattedString)
    def ExportDatesAsFormattedString_=(value: Bool) {
        if (ExportDatesAsFormattedString == value) return
        json("exportDatesAsFormattedString") = value
    }

    def ExportDelimiter = json.getStringOpt("exportDelimiter").getOrElse(exportDelimiter)
    def ExportDelimiter_=(value: String) {
        if (ExportDelimiter == value) return
        json("exportDelimiter") = value
    }

    def ExportDisplay = json.getValue2[JsonString, ExportDisplay]("exportDisplay").getOrElse(exportDisplay)
    def ExportDisplay_=(value: ExportDisplay) {
        if (ExportDisplay == value) return
        json("exportDisplay") = value
    }

    def ExportFields = json.getJsonObjectOpt("exportFields").getOrElse(exportFields)
    def ExportFields_=(value: JsonObject) {
        if (ExportFields == value) return
        json("exportFields") = value
    }

    def ExportFilename = json.getStringOpt("exportFilename").getOrElse(exportFilename)
    def ExportFilename_=(value: String) {
        if (ExportFilename == value) return
        json("exportFilename") = value
    }

    def ExportFooter = json.getStringOpt("exportFooter").getOrElse(exportFooter)
    def ExportFooter_=(value: String) {
        if (ExportFooter == value) return
        json("exportFooter") = value
    }

    def ExportHeader = json.getStringOpt("exportHeader").getOrElse(exportHeader)
    def ExportHeader_=(value: String) {
        if (ExportHeader == value) return
        json("exportHeader") = value
    }

    def ExportPath = json.getStringOpt("exportPath").getOrElse(exportPath)
    def ExportPath_=(value: String) {
        if (ExportPath == value) return
        json("exportPath") = value
    }

    def ExportResults = json.getBoolOpt("exportResults").getOrElse(exportResults)
    def ExportResults_=(value: Bool) {
        if (ExportResults == value) return
        json("exportResults") = value
    }

    def ExportTitleSeparatorChar = json.getStringOpt("exportTitleSeparatorChar").getOrElse(exportTitleSeparatorChar)
    def ExportTitleSeparatorChar_=(value: String) {
        if (ExportTitleSeparatorChar == value) return
        json("exportTitleSeparatorChar") = value
    }

    def ExportToClient = json.getBoolOpt("exportToClient").getOrElse(exportToClient)
    def ExportToClient_=(value: Bool) {
        if (ExportToClient == value) return
        json("exportToClient") = value
    }

    def ExportToFilesystem = json.getBoolOpt("exportToFilesystem").getOrElse(exportToFilesystem)
    def ExportToFilesystem_=(value: Bool) {
        if (ExportToFilesystem == value) return
        json("exportToFilesystem") = value
    }

    def ExportValueFields = json.getBoolOpt("exportValueFields").getOrElse(exportValueFields)
    def ExportValueFields_=(value: Bool) {
        if (ExportValueFields == value) return
        json("exportValueFields") = value
    }

    def HeaderData = json.getJsonObjectOpt("headerData").getOrElse(headerData)
    def HeaderData_=(value: JsonObject) {
        if (HeaderData == value) return
        json("headerData") = value
    }

    def LineBreakStyle = json.getStringOpt(" lineBreakStyle").getOrElse(lineBreakStyle)
    def LineBreakStyle_=(value: String) {
        if (LineBreakStyle == value) return
        json("lineBreakStyle") = value
    }

    def OldValues = json.getJsonObjectOpt("oldValues").getOrElse(oldValues)
    def OldValues_=(value: JsonObject) {
        if (OldValues == value) return
        json("oldValues") = value
    }

    def OperationId = json.getStringOpt("operationId").getOrElse(operationId)
    def OperationId_=(value: String) {
        if (OperationId == value) return
        json("operationId") = value
    }

    def OperationType = json.getValue2[JsonString, DSOperationType]("operationType").getOrElse(operationType)
    def OperationType_=(value: DSOperationType) {
        if (OperationType == value) return
        json("operationType") = value
    }

    def ParentNode = json.getValue2[JsonObject, TreeNodeDyn]("parentNode").getOrElse(parentNode)
    def ParentNode_=(value: TreeNodeDyn) {
        if (ParentNode == value) return
        json("parentNode") = value
    }

    def RequestId = json.getStringOpt("requestId").getOrElse(requestId)
    def RequestId_=(value: String) {
        if (RequestId == value) return
        json("requestId") = value
    }

    def ResultSet = json.getValue2[JsonObject, ResultSetDyn]("resultSet").getOrElse(resultSet)
    def ResultSet_=(value: ResultSetDyn) {
        if (ResultSet == value) return
        json("resultSet") = value
    }

    def ResultTree = json.getValue2[JsonObject, ResultTreeDyn]("resultTree").getOrElse(resultTree)
    def ResultTree_=(value: ResultTreeDyn) {
        if (ResultTree == value) return
        json("resultTree") = value
    }

    def SortBy:JsonList = json.getJsonListOpt("sortBy").getOrElse(sortBy)
    def SortBy_=(value: JsonList) {
        if (SortBy == value) return
        json(" sortBy") = value
    }

    def StartRow = json.getNumberOpt("startRow").getOrElse(startRow)
    def StartRow_=(value: Number) {
        if (StartRow == value) return
        json("startRow") = value
    }

    def StreamResults = json.getStringOpt("streamResults").getOrElse(streamResults)
    def StreamResults_=(value: String) {
        if (StreamResults == value) return
        json("streamResults") = value
    }

    def TextMatchStyle = json.getValue2[JsonString, TextMatchStyle]("textMatchStyle").getOrElse(textMatchStyle)
    def TextMatchStyle_=(value: TextMatchStyle) {
        if (TextMatchStyle == value) return
        json("textMatchStyle") = value
    }

    def Transaction = json.getValue2[JsonObject, TransactionDyn]("transaction").getOrElse(transaction)
    def Transaction_=(value: TransactionDyn) {
        if (Transaction == value) return
        json("transaction") = value
    }

    def UseFlatFields = json.getBoolOpt("useFlatFields").getOrElse(useFlatFields)
    def UseFlatFields_=(value: Bool) {
        if (UseFlatFields == value) return
        json("useFlatFields") = value
    }

    def UseFlatHeaderFields = json.getBoolOpt("useFlatHeaderFields").getOrElse(useFlatHeaderFields)
    def UseFlatHeaderFields_=(value: Bool) {
        if (UseFlatHeaderFields == value) return
        json("useFlatHeaderFields") = value
    }

    def ValidationMode = json.getValue2[JsonString, ValidationMode]("validationMode").getOrElse(validationMode)
    def ValidationMode_=(value: ValidationMode) {
        if (ValidationMode == value) return
        json("validationMode") = value
    }

    def SubscribedChannels = json.getJsonListOpt("subscribedChannels").getOrElse(subscribedChannels)
    def SubscribedChannels_=(value: JsonList) {
        if (SubscribedChannels == value) return
        json("subscribedChannels") = value
    }

    def SubscriberName = json.getStringOpt("subscriberName").getOrElse(subscriberName)
    def SubscriberName_=(value: String) {
        if (SubscriberName == value) return
        json("subscriberName") = value
    }
}

