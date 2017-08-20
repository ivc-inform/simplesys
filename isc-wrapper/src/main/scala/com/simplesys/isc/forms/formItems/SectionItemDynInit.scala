package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonString, JsonList}

trait SectionItemDynInit extends CanvasItemDynInit {
  protected val canCollapse: Bool = true
  protected val canTabToHeader: Bool = false
  override protected val defaultValue: JsonString = JsonString("Section Header")
  protected val itemIds: JsonList = JsonList()
  protected val sectionExpanded: Bool = true
  protected val sectionHeaderClass: SCClassName = "SectionHeader"
  protected val sectionVisible: Bool = true
}