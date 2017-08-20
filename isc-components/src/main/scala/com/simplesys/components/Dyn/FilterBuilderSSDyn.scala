package com.simplesys.components.Dyn

import com.simplesys.isc.forms.FilterBuilderDyn
import com.simplesys.json.{JsonObject, Json}
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.isc.system.ClassDyn

object FilterBuilderSSDyn extends FilterBuilderSSDynInit {
    implicit def FilterBuilderSSDyn2JsonObject(in: FilterBuilderSSDyn): JsonObject = in json
}

class FilterBuilderSSDyn(override val useSelfName: Boolean = false) extends FilterBuilderDyn with FilterBuilderSSDynInit {
    override val selfName = "FilterBuilderSS"
}