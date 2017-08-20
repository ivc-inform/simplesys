package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.misc.FunctionExpression
import com.simplesys.json.{JsonElement, JsonNull}

trait DataSourceListGridItemDynInit extends DataSourceFieldDymInit {
    private[dataBinging] val dataSource: JsonElement = JsonNull
    private[dataBinging] val startEditingNew: FunctionExpression = ""
    private[dataBinging] val fixedRecordHeights: Boolean = true
    private[dataBinging] val wrapCells: Boolean = false
}