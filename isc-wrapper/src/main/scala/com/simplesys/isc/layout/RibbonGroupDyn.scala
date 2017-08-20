package com.simplesys.isc.layout

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc._

object RibbonGroupDyn {
  implicit def RibbonGrouptoJsonObject(in: RibbonGroupDyn): JsonObject = in json
}

class RibbonGroupDyn(override val useSelfName: Boolean = false) extends ToolStripGroupDyn with RibbonGroupDynInit {
  override val selfName = "RibbonGroup"

  private[this] var _newControlConstructor: String = newControlConstructor
  def NewControlConstructor = _newControlConstructor
  def NewControlConstructor_=(value: String) {
    if (_newControlConstructor == value) return
    json("newControlConstructor") = value
    _newControlConstructor = value
  }

  private[this] var _newControlDefaults: AutoChild = newControlDefaults
  def NewControlDefaults = _newControlDefaults
  def NewControlDefaults_=(value: AutoChild) {
    if (_newControlDefaults == value) return
    json("newControlDefaults") = value
    _newControlDefaults = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _colWidths: JsonList = colWidths
  def ColWidths = _colWidths
  def ColWidths_=(value: JsonList) {
    if (_colWidths == value) return
    json("colWidths") = value
    _colWidths = value
  }
}
