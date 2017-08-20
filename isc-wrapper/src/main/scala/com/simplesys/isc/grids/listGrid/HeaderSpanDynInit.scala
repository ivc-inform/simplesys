package com.simplesys.isc.grids.listGrid

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonList

trait HeaderSpanDynInit {
  protected val align: AlignmentDyn = AlCenter
  protected val fields: JsonList = JsonList()
  protected val height: Number = null
  protected val name: String = ""
  protected val title: String = ""
  protected val valign: AlignmentDyn = ValAll
}