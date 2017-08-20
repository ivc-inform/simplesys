package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.misc.Bool

trait CanvasItemDynInit extends FormItemDynInit {
  protected val formItem: FormItemDyn = null
  protected val applyPromptToCanvas: Bool = true
  protected val canvas: CanvasDyn = null
  protected val canvasConstructor: String = "Canvas"
  protected val canvasDefaults: JsonObject = JsonObject()
  protected val canvasProperties: JsonObject = JsonObject()
  protected val editCriteriaInInnerForm: Bool = true
  protected val overflow: Overflow = ovNull
  override protected val shouldSaveValue: Bool = false
}