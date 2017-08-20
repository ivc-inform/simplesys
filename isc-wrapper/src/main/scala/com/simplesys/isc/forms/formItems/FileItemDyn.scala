package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object FileItemDyn {
  implicit def FileItemtoJsonObject(in: FileItemDyn): JsonObject = in json
}

class FileItemDyn extends CanvasItemDyn with FileItemDynInit {
  private[this] var _showFileInline: Bool = showFileInline
  def ShowFileInline = _showFileInline
  def ShowFileInline_=(value: Bool) {
    if (_showFileInline == value) return
    json("showFileInline") = value
    _showFileInline = value
  }
}
