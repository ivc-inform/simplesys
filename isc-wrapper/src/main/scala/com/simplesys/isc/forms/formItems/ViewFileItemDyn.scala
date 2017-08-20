package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object ViewFileItemDyn {
  implicit def ViewFileItemtoJsonObject(in: ViewFileItemDyn): JsonObject = in json
}

class ViewFileItemDyn extends CanvasItemDyn with ViewFileItemDynInit {
  private[this] var _showFileInline: Bool = showFileInline
  def ShowFileInline = _showFileInline
  def ShowFileInline_=(value: Bool) {
    if (_showFileInline == value) return
    json("showFileInline") = value
    _showFileInline = value
  }
}
