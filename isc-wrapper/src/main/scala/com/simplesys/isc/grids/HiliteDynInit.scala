package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonElement, JsonNull}

trait HiliteDynInit {
  protected val backgroundColor: Color = ""
  protected val criteria: JsonElement = JsonNull
  protected val cssText: String = ""
  protected val disabled: Bool = false
  protected val fieldName: String = ""
  protected val htmlAfter: HTMLString = ""
  protected val htmlBefore: HTMLString = ""
  protected val htmlValue: HTMLString = ""
  protected val id: String = ""
  protected val textColor: Color = ""
  protected val title: String = ""
}