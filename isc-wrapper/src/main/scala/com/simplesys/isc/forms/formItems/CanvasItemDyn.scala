package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

object CanvasItemDyn {
  implicit def CanvasItemtoJsonObject(in: CanvasItemDyn): JsonObject = in json
}

class CanvasItemDyn extends FormItemDyn with CanvasItemDynInit {

  private[this] var _applyPromptToCanvas: Bool = applyPromptToCanvas
  def ApplyPromptToCanvas = _applyPromptToCanvas
  def ApplyPromptToCanvas_=(value: Bool) {
    if (_applyPromptToCanvas == value) return
    json("applyPromptToCanvas") = value
    _applyPromptToCanvas = value
  }

  private[this] var _canvas: CanvasDyn = canvas
  def Canvas = _canvas
  def Canvas_=(value: CanvasDyn) {
    if (_canvas == value) return
    json("canvas") = value
    _canvas = value
  }

  private[this] var _canvasConstructor: String = canvasConstructor
  def CanvasConstructor = _canvasConstructor
  def CanvasConstructor_=(value: String) {
    if (_canvasConstructor == value) return
    json("canvasConstructor") = value
    _canvasConstructor = value
  }

  private[this] var _canvasDefaults: JsonObject = canvasDefaults
  def CanvasDefaults = _canvasDefaults
  def CanvasDefaults_=(value: JsonObject) {
    if (_canvasDefaults == value) return
    json("canvasDefaults") = value
    _canvasDefaults = value
  }

  private[this] var _canvasProperties: JsonObject = canvasProperties
  def CanvasProperties = _canvasProperties
  def CanvasProperties_=(value: JsonObject) {
    if (_canvasProperties == value) return
    json("canvasProperties") = value
    _canvasProperties = value
  }

  private[this] var _editCriteriaInInnerForm: Bool = editCriteriaInInnerForm
  def EditCriteriaInInnerForm = _editCriteriaInInnerForm
  def EditCriteriaInInnerForm_=(value: Bool) {
    if (_editCriteriaInInnerForm == value) return
    json("editCriteriaInInnerForm") = value
    _editCriteriaInInnerForm = value
  }

  private[this] var _overflow: Overflow = overflow
  def Overflow = _overflow
  def Overflow_=(value: Overflow) {
    if (_overflow == value) return
    json("overflow") = value
    _overflow = value
  }

  private[this] var _formItem: FormItemDyn = formItem
  def FormItem = _formItem
  def FormItem_=(value: FormItemDyn) {
    if (_formItem == value) return
    json("formItem") = value
    _formItem = value
  }
}


