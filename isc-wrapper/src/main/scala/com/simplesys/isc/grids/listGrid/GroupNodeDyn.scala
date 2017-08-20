package com.simplesys.isc.grids.listGrid

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.grids.ListGridRecordDyn
import com.simplesys.isc._

object GroupNodeDyn {

  implicit def GroupNodetoJsonObject(in: GroupNodeDyn): JsonObject = in json
}

class GroupNodeDyn extends ClassDyn with GroupNodeDynInit {
  private[this] var _groupMembers: ArrayDyn[ListGridRecordDyn] = groupMembers
  def GroupMembers = _groupMembers
  def GroupMembers_=(value: ArrayDyn[ListGridRecordDyn]) {
    if (_groupMembers == value) return
    json("groupMembers") = value
    _groupMembers = value
  }

  private[this] var _groupTitle: HTMLString = groupTitle
  def GroupTitle = _groupTitle
  def GroupTitle_=(value: HTMLString) {
    if (_groupTitle == value) return
    json("groupTitle") = value
    _groupTitle = value
  }

  def GroupValue = json.getStringOpt("groupValue").getOrElse(groupValue)
  def GroupValue_=(value: String) {
    if (GroupValue == value) return
    json("groupValue") = value
  }
}
