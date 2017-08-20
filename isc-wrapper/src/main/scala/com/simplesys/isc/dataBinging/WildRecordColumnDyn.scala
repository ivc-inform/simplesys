package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonElement, JsonObject}
import com.simplesys.isc.system.ClassDyn


object WildRecordColumnDyn {
    implicit def WildRecordColumnDyn2JsonObject(in: WildRecordColumnDyn): JsonObject = in json
}

class WildRecordColumnDyn(override val inJson: JsonObject = null, override val useSelfName: Boolean = false) extends ClassDyn with WildRecordColumnDynInit {

    override val selfName = "WildRecordColumn"

    def Name = json.getStringOpt("name").getOrElse(name)
    def Name_=(value: String) {
        if (Name == value) return
        json("name") = value
    }

    def Value = json.getJsonElement("value").getOrElse(value)
    def Value_=(value: JsonElement) {
        if (Value == value) return
        json("value") = value
    }
}