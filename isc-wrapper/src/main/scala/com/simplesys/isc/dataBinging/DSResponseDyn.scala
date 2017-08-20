package com.simplesys.isc.dataBinging

import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject

object DSResponseDyn {
    implicit def DSResponse1toJsonObject(in: DSResponseDyn): JsonObject = in json

    implicit class MultyResponse(array: ArrayDyn[DSResponseDyn]) {
        def toMultyResponse: ArrayDyn[DSResponseDyn] = {
            val res = new ArrayDyn[DSResponseDyn]()
            array foreach {
                case item: JsonObject => res += new DSResponseDyn(item).WrapResponseObject
                case _ =>
            }
            res
        }
    }
}

class DSResponseDyn(override val inJson: JsonObject = null,
                    override val useSelfName: Boolean = false) extends RPCResponseDyn with DSResponseDynInit {
    override val selfName = "DSResponse"

    private[this] var _endRow: Number = endRow
    def EndRow = _endRow
    def EndRow_=(value: Number) {
        if (_endRow == value) return
        json("endRow") = value
        _endRow = value
    }

    private[this] var _errors: JsonObject = errors
    def Errors = _errors
    def Errors_=(value: JsonObject) {
        json("errors") = value
        _errors = value
    }

    private[this] var _fromOfflineCache: Bool = fromOfflineCache
    def FromOfflineCache = _fromOfflineCache
    def FromOfflineCache_=(value: Bool) {
        if (_fromOfflineCache == value) return
        json("fromOfflineCache") = value
        _fromOfflineCache = value
    }

    private[this] var _invalidateCache: Bool = invalidateCache
    def InvalidateCache = _invalidateCache
    def InvalidateCache_=(value: Bool) {
        if (_invalidateCache == value) return
        json("invalidateCache") = value
        _invalidateCache = value
    }

    private[this] var _offlineTimestamp: Number = offlineTimestamp
    def OfflineTimestamp = _offlineTimestamp
    def OfflineTimestamp_=(value: Number) {
        if (_offlineTimestamp == value) return
        json("offlineTimestamp") = value
        _offlineTimestamp = value
    }

    private[this] var _startRow: Number = startRow
    def StartRow = _startRow
    def StartRow_=(value: Number) {
        if (_startRow == value) return
        json("startRow") = value
        _startRow = value
    }

    def QueueStatus = json.getNumberOpt("queueStatus").getOrElse(queueStatus)
    def QueueStatus_=(value: Number) {
        if (QueueStatus == value) return
        json("queueStatus") = value
    }

    private[this] var _totalRows: Number = totalRows
    def TotalRows = _totalRows
    def TotalRows_=(value: Number) {
        if (_totalRows == value) return
        json("totalRows") = value
        _totalRows = value
    }

    def UrlExportFile: Option[String] = urlExportFile
    def UrlExportFile_=(value: Option[String]) {
        if (urlExportFile == value) return
        value.foreach(json("urlExportFile") = _)
    }

    def WrapResponseObject: DSResponseDyn = new DSResponseDyn(JsonObject(("response" -> json)))
}

