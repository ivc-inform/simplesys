package com.simplesys.components.Dyn

import com.simplesys.json.{JsonElement, JsonString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HLayoutDyn
import com.simplesys.isc.system.ClassDyn

object ListGridCellEditorDyn extends ListGridCellEditorDynInit {

  implicit def ListGridCellEditor2JsonObject(in: ListGridCellEditorDyn): JsonObject = in json
}

class ListGridCellEditorDyn(override val useSelfName: Boolean = false) extends HLayoutDyn with ListGridCellEditorDynInit {
  override val selfName = "ListGridCellEditor"

  def Title = json.getStringOpt("title").getOrElse(title)
  def Title_=(value: String) {
    if (Title == value) return
    json("title") = value
  }

  def CancelButtonClick = json.getFunctionExpressionOpt("cancelButtonClick").getOrElse(cancelButtonClick)
  def CancelButtonClick_=(value: FunctionExpression) {
    if (CancelButtonClick == value) return
    json("cancelButtonClick") = value
  }

  def OkButtonClick = json.getFunctionExpressionOpt("okButtonClick").getOrElse(okButtonClick)
  def OkButtonClick_=(value: FunctionExpression) {
    if (OkButtonClick == value) return
    json("okButtonClick") = value
  }

  def VisibilityFuncButton = json.getValue2[JsonString, Visibility]("visibilityFuncButton").getOrElse(visibilityFuncButton)
  def VisibilityFuncButton_=(value: Visibility) {
    if (VisibilityFuncButton == value) return
    json("visibilityFuncButton") = value
  }

  def Editor = json.getValue2[JsonObject, ClassDyn]("editor").getOrElse(editor)
  def Editor_=(value: ClassDyn) {
    if (Editor == value) return
    if (value.Enqueued)
      json("editor") = value.Identifier.toString.unq
    else
      json("editor") = value
  }

  def ImgPath = json.getSCImgURL("imgPath").getOrElse(imgPath)
  def ImgPath_=(value: SCImgURL) {
    if (ImgPath == value) return
    json("imgPath") = value
  }

  def KeyValue = json.getJsonElement("keyValue").getOrElse(keyValue)
  def KeyValue_=(value: JsonElement) {
    if (KeyValue == value) return
    json("keyValue") = value
  }
}