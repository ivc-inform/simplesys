package com.simplesys.isc.dataBinging

import com.simplesys.isc.dataBinging.RPC.RPCResponseDynInit
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject

trait DSResponseDynInit extends RPCResponseDynInit {
    protected val endRow: Number = null
    protected val errors: JsonObject = JsonObject()
    protected val fromOfflineCache: Bool = false
    protected val invalidateCache: Bool = false
    protected val offlineTimestamp: Number = null
    protected val startRow: Number = null
    protected val queueStatus: Number = null
    protected val totalRows: Number = null
    protected val urlExportFile: Option[String] = None
}
