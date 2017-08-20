package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.misc.FunctionExpression
import com.simplesys.json.{JsonElement, JsonObject}

object DataSourceListGridItemDyn {
    implicit def DataSourceListGridFieldDyn2JsonObject(in: DataSourceListGridItemDyn): JsonObject = in json
}

class DataSourceListGridItemDyn(override val useSelfName: Boolean = false) extends DataSourceFieldDyn with DataSourceListGridItemDynInit {
    override val selfName = "ListGridItem"

    json("editorType") = selfName // Don`t move !!!!

    def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
    def DataSource_=(value: JsonElement) {
        if (DataSource == value) return
        json("dataSource") = value
    }

    def StartEditingNew = json.getFunctionExpressionOpt("startEditingNew").getOrElse(startEditingNew)
    def StartEditingNew_=(value: FunctionExpression) {
        if (StartEditingNew == value) return
        json("startEditingNew") = value
    }

    def FixedRecordHeights = json.getBooleanOpt("fixedRecordHeights").getOrElse(fixedRecordHeights)
    def FixedRecordHeights_=(value: Boolean) {
        if (FixedRecordHeights == value) return
        json("fixedRecordHeights") = value
    }

    def WrapCells = json.getBooleanOpt("wrapCells").getOrElse(wrapCells)
    def WrapCells_=(value: Boolean) {
        if (WrapCells == value) return
        json("wrapCells") = value
    }
}