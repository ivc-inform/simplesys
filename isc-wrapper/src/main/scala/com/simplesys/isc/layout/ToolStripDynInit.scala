package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject

trait ToolStripDynInit extends LayoutDynInit {
  protected val formWrapper: AutoChild = null
  protected val formWrapperConstructor: String = "DynamicForm"
  protected val formWrapperDefaults: JsonObject = JsonObject()
  protected val formWrapperProperties: JsonObject = JsonObject()
  protected val groupTitleAlign: AlignmentDyn = AlCenter
  protected val groupTitleOrientation: AlignmentDyn = ValTop
  override protected val height: Number = 20
  override protected val resizeBarClass: String = "ToolStripResizer"
  override protected val resizeBarSize: Number = 14
  protected val separatorClass: String = "ToolStripSeparator"
  protected val separatorSize: Number = 8
  protected val showGroupTitle: Bool = true
  override protected val vertical: Bool = false
  protected val verticalStyleName: CSSStyleName = ""
}