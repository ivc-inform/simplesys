package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.typesDyn.frmitmtpBlurb

object BlurbItemDyn {
  implicit def BlurbItemtoJsonObject(in: BlurbItemDyn): JsonObject = in json
}

class BlurbItemDyn(override val useSelfName: Boolean = false) extends FormItemDyn with BlurbItemDynInit {
  EditorType = frmitmtpBlurb

  override val selfName: String = "BlurbItem"

  private[this] var _clipValue: Bool = clipValue
  def ClipValue = _clipValue
  def ClipValue_=(value: Bool) {
    if (_clipValue == value) return
    json("clipValue") = value
    _clipValue = value
  }

  private[this] var _wrap: Bool = wrap
  def Wrap = _wrap
  def Wrap_=(value: Bool) {
    if (_wrap == value) return
    json("wrap") = value
    _wrap = value
  }
}

