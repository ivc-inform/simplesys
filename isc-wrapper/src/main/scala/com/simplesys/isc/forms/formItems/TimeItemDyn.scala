package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool

object TimeItemDyn {
  implicit def TimeItemtoJsonObject(in: TimeItemDyn): JsonObject = in json
}

class TimeItemDyn extends TextItemDyn with TimeItemDynInit {
  private[this] var _useMask: Bool = useMask
  def UseMask = _useMask
  def UseMask_=(value: Bool) {
    if (_useMask == value) return
    json("useMask") = value
    _useMask = value
  }
}
