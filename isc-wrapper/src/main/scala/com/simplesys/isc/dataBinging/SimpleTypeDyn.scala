package com.simplesys.isc.dataBinging

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.forms.ValidatorDyn

object SimpleTypeDyn {
    implicit def SimpleType2JsonObject(in: SimpleTypeDyn): JsonObject = in json
}

class SimpleTypeDyn(override val useSelfName: Boolean = false) extends ClassDyn with SimpleTypeDynInit {
    override val selfName = "SimpleType"

    def EditorType = json.getJsonElement("editorType").getOrElse(editorType)
    def EditorType_=(value: JsonElement) {
        if (EditorType == value) return
        json("editorType") = value
    }

    def ExportFormat = json.getStringOpt("exportFormat").getOrElse(exportFormat)
    def ExportFormat_=(value: String) {
        if (ExportFormat == value) return
        json("exportFormat") = value
    }

    def FieldProperties = json.getValue2[JsonObject, DataSourceFieldDyn]("fieldProperties").getOrElse(fieldProperties)
    def FieldProperties_=(value: DataSourceFieldDyn) {
        if (FieldProperties == value) return
        json("fieldProperties") = value
    }

    def Format = json.getStringOpt("format").getOrElse(format)
    def Format_=(value: String) {
        if (Format == value) return
        json("format") = value
    }

    def InheritsFrom = json.getJsonElement("inheritsFrom").getOrElse(inheritsFrom)
    def InheritsFrom_=(value: JsonElement) {
        if (InheritsFrom == value) return
        json("inheritsFrom") = value
    }

    def Name = json.getStringOpt("name").getOrElse(name)
    def Name_=(value: String) {
        if (Name == value) return
        json("name") = value
    }

    def ReadOnlyEditorType = json.getJsonElement("readOnlyEditorType").getOrElse(readOnlyEditorType)
    def ReadOnlyEditorType_=(value: JsonElement) {
        if (ReadOnlyEditorType == value) return
        json("readOnlyEditorType") = value
    }

    def Validators = json.getValue2[JsonList, ArrayDyn[ValidatorDyn]]("validators").getOrElse(validators)
    def Validators_=(value: ArrayDyn[ValidatorDyn]) {
        if (Validators == value) return
        json("validators") = value
    }

    def ValidOperators = json.getJsonListOpt("validOperators").getOrElse(validOperators)
    def ValidOperators_=(value: JsonList) {
        if (ValidOperators == value) return
        json("validOperators") = value
    }

    def ValueMap = json.getJsonObjectOpt("valueMap").getOrElse(valueMap)
    def ValueMap_=(value: JsonObject) {
        if (ValueMap == value) return
        json("valueMap") = value
    }
}