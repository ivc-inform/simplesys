package com.simplesys.isc.system

import com.simplesys.json.{JsonNull, JsonElement}
import com.simplesys.isc.system.misc._


trait ClassDynInit {
    protected val deleteItem: Bool = false
    protected val identifier: JsonElement = JsonNull
    protected val __operation: String = ""
    private[system] val iD: JsonElement = ""
    protected val group: String = ""
    protected val tag: String = ""
}