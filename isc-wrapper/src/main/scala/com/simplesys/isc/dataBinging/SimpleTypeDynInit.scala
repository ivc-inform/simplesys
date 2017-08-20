package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.{ArrayDyn, ClassDynInit}
import com.simplesys.isc.forms.ValidatorDyn
import com.simplesys.common.Strings._
import com.simplesys.json.{JsonObject, JsonNull, JsonElement, JsonList}

trait SimpleTypeDynInit extends ClassDynInit {
    private[dataBinging] val editorType: JsonElement = JsonNull
    private[dataBinging] val exportFormat: String = strEmpty
    private[dataBinging] val fieldProperties: DataSourceFieldDyn = null
    private[dataBinging] val format: String = strEmpty
    private[dataBinging] val inheritsFrom: JsonElement = JsonNull
    private[dataBinging] val name: String = strEmpty
    private[dataBinging] val readOnlyEditorType: JsonElement = JsonNull
    private[dataBinging] val valueMap: JsonObject = JsonObject()
    private[dataBinging] val validators: ArrayDyn[ValidatorDyn] = ArrayDyn.empty[ValidatorDyn]
    private[dataBinging] val validOperators: JsonList = JsonList()
}