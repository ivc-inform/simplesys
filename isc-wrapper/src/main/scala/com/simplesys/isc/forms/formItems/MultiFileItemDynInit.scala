package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{JsonElement, JsonNull}

trait MultiFileItemDynInit extends RelationItemDynInit {
  protected val dataSource: JsonElement = JsonNull
  protected val editButton: AutoChild = null
  protected val emptyMessage: String = "Click icon to add..."
  protected val removeButton: AutoChild = null
}