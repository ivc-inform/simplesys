package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject

object LinkItemDyn {
  implicit def LinkItemtoJsonObject(in: LinkItemDyn): JsonObject = in json
}

class LinkItemDyn extends TextItemDyn with LinkItemDynInit {

  private[this] var _linkTitle: String = linkTitle
  def LinkTitle = _linkTitle
  def LinkTitle_=(value: String) {
    if (_linkTitle == value) return
    json("linkTitle") = value
    _linkTitle = value
  }

  private[this] var _target: String = target
  def Target = _target
  def Target_=(value: String) {
    if (_target == value) return
    json("target") = value
    _target = value
  }
}
