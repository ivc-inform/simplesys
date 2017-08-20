/*

*/

package com.simplesys.isc.system

import com.simplesys.json.JsonObject

object SelectionDyn {
  implicit def SelectiontoJsonObject(in: SelectionDyn): JsonObject = in json
}

class SelectionDyn extends ClassDyn with SelectionDynInit {
  private[this] var _selectionRangeNotLoadedMessage: String = selectionRangeNotLoadedMessage
  def SelectionRangeNotLoadedMessage = _selectionRangeNotLoadedMessage
  def SelectionRangeNotLoadedMessage_=(value: String) {
    if (_selectionRangeNotLoadedMessage == value) return
    json("selectionRangeNotLoadedMessage") = value
    _selectionRangeNotLoadedMessage = value
  }
}