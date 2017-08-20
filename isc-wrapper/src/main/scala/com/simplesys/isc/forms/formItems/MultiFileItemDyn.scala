package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonNull, JsonElement, UnquotedString, JsonObject}
import com.simplesys.isc.system.typesDyn._

object MultiFileItemDyn {
  implicit def MultiFileItemtoJsonObject(in: MultiFileItemDyn): JsonObject = in json
}

class MultiFileItemDyn extends RelationItemDyn with MultiFileItemDynInit {

  def DataSource = json.getJsonElement("dataSource").getOrElse(dataSource)
  def DataSource_=(value: JsonElement) {
    if (DataSource == value) return
    json("dataSource") = value
  }

  private[this] var _editButton: AutoChild = editButton
  def EditButton = _editButton
  def EditButton_=(value: AutoChild) {
    if (_editButton == value) return
    json("editButton") = value
    _editButton = value
  }

  private[this] var _emptyMessage: String = emptyMessage
  def EmptyMessage = _emptyMessage
  def EmptyMessage_=(value: String) {
    if (_emptyMessage == value) return
    json("emptyMessage") = value
    _emptyMessage = value
  }

  private[this] var _removeButton: AutoChild = removeButton
  def RemoveButton = _removeButton
  def RemoveButton_=(value: AutoChild) {
    if (_removeButton == value) return
    json("removeButton") = value
    _removeButton = value
  }
}

