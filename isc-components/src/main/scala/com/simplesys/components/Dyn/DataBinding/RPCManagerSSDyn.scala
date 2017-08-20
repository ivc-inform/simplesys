package com.simplesys.components.Dyn.DataBinding

import com.simplesys.isc.RPC.RPCManagerDyn
import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object RPCManagerSSDyn extends RPCManagerSSDynInit {
    implicit def RPCManagerSSDyn2JsonObject(in: RPCManagerSSDyn): JsonObject = in json
    def apply() = new RPCManagerSSDyn {}
}

class RPCManagerSSDyn(override val useSelfName: Boolean = false) extends RPCManagerDyn with RPCManagerSSDynInit {
    override val selfName = "RPCManagerSS"
}