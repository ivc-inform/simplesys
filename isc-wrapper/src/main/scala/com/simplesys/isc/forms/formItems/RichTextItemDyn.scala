package com.simplesys.isc.forms.formItems

import com.simplesys.json.{JsonList, JsonObject}

object RichTextItemDyn {
  implicit def RichTextItemtoJsonObject(in: RichTextItemDyn): JsonObject = in json
}

class RichTextItemDyn extends CanvasItemDyn with RichTextItemDynInit {

  private[this] var _controlGroups: JsonList = controlGroups
  def ControlGroups = _controlGroups
  def ControlGroups_=(value: JsonList) {
    if (_controlGroups == value) return
    json("controlGroups") = value
    _controlGroups = value
  }
}
