package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonNull

trait StatefulCanvasDynInit extends CanvasDynInit {
  protected val actionType: SelectionType = slTpButton
  protected val align: AlignmentDyn = AlCenter
  protected val autoFit: Bool = false
  protected val baseStyle: CSSStyleName = ""
  protected val icon: SCImgURL = JsonNull
  protected val iconHeight: Number = null
  protected val iconOrientation: IconOrientation = IoLeft
  protected val iconSize: Number = 16
  protected val iconSpacing: Number = 6
  protected val iconWidth: Number = null
  protected val overCanvas: AutoChild = null
  protected val overCanvasConstructor: SCClassName = "Canvas"
  protected val overCanvasDefaults: CanvasDyn = null
  protected val radioGroup: String = ""
  protected val redrawOnStateChange: Bool = false
  protected val selected: Bool = false
  protected val showDisabled: Bool = true
  protected val showDisabledIcon: Bool = true
  protected val showDown: Bool = false
  protected val showDownIcon: Bool = false
  protected val showFocus: Bool = false
  protected val showFocused: Bool = false
  protected val showFocusedAsOver: Bool = true
  protected val showFocusedIcon: Bool = false
  protected val showOverCanvas: Bool = false
  protected val showRollOver: Bool = false
  protected val showRollOverIcon: Bool = false
  protected val showSelectedIcon: Bool = false
  protected val state: State = stDown
  protected val title: HTMLString = null
  protected val valign: AlignmentDyn = AlCenter
}