package com.simplesys.isc.layout.sectionStack

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.CanvasDyn

object SectionStackSectionDyn {

  implicit def SectionStackSection2JsonObject(in: SectionStackSectionDyn): JsonObject = in json
}

class SectionStackSectionDyn(override val useSelfName: Boolean = false) extends ClassDyn with SectionStackSectionDynInit {
  override val selfName = "SectionStackSection"

  private[this] var _canCollapse: Bool = canCollapse
  def CanCollapse = _canCollapse
  def CanCollapse_=(value: Bool) {
    if (_canCollapse == value) return
    json("canCollapse") = value
    _canCollapse = value
  }

  private[this] var _canDropBefore: Bool = canDropBefore
  def CanDropBefore = _canDropBefore
  def CanDropBefore_=(value: Bool) {
    if (_canDropBefore == value) return
    json("canDropBefore") = value
    _canDropBefore = value
  }

  private[this] var _canReorder: Bool = canReorder
  def CanReorder = _canReorder
  def CanReorder_=(value: Bool) {
    if (_canReorder == value) return
    json("canReorder") = value
    _canReorder = value
  }

  private[this] var _canTabToHeader: Bool = canTabToHeader
  def CanTabToHeader = _canTabToHeader
  def CanTabToHeader_=(value: Bool) {
    if (_canTabToHeader == value) return
    json("canTabToHeader") = value
    _canTabToHeader = value
  }

  private[this] var _expanded: Bool = expanded
  def Expanded = _expanded
  def Expanded_=(value: Bool) {
    if (_expanded == value) return
    json("expanded") = value
    _expanded = value
  }

  private[this] var _hidden: Bool = hidden
  def Hidden = _hidden
  def Hidden_=(value: Bool) {
    if (_hidden == value) return
    json("hidden") = value
    _hidden = value
  }

  private[this] var _items: ArrayDyn[CanvasDyn] = items
  def Items = _items
  def Items_=(value: ArrayDyn[CanvasDyn]) {
    if (_items == value) return
    json("items") = value
    _items = value
  }

  private[this] var _name: String = name
  def Name = _name
  def Name_=(value: String) {
    if (_name == value) return
    json("name") = value
    _name = value
  }

  private[this] var _resizeable: Bool = resizeable
  def Resizeable = _resizeable
  def Resizeable_=(value: Bool) {
    if (_resizeable == value) return
    json("resizeable") = value
    _resizeable = value
  }

  private[this] var _showHeader: Bool = showHeader
  def ShowHeader = _showHeader
  def ShowHeader_=(value: Bool) {
    if (_showHeader == value) return
    json("showHeader") = value
    _showHeader = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

}