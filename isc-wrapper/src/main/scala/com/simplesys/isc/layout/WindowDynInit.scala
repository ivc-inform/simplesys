package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.json.{JsonElement, JsonNull, JsonObject, JsonList}
import com.simplesys.isc.foundation.CanvasDyn

trait WindowDynInit extends LayoutDynInit {
  protected val animateMinimize: Bool = null
  protected val autoCenter: Bool = null
  protected val autoSize: Bool = false
  protected val body: AutoChild = null
  protected val bodyColor: Color = "#FFFFFF"
  protected val bodyConstructor: SCClassName = ""
  protected val bodyDefaults: ClassDyn = null
  protected val bodyStyle: String = "windowBody"
  override protected val canDragReposition: Bool = true
  override protected val canDragResize: Bool = false
  protected val canFocusInHeaderButtons: Bool = false
  protected val closeButton: AutoChild = null
  protected val closeClick: FunctionExpression = null
  protected val contentLayout: ContentLayout = cntlytVertical
  protected val contentsType: String = "page"
  protected val defaultMinimizeHeight: Number = 16
  protected val dismissOnEscape: Bool = null
  protected val dismissOnOutsideClick: Bool = false
  protected val footer: AutoChild = null
  protected val footerControls: JsonList = JsonList()
  protected val footerHeight: Number = 18
  protected val header: AutoChild = null
  protected val headerBackground: AutoChild = null
  protected val headerControls: JsonList = JsonList()
  private[layout] val headerIcon: JsonElement = JsonNull
  protected val headerIconDefaults: JsonElement = JsonNull
  protected val headerLabel: AutoChild = null
  protected val headerLabelDefaults: JsonList = null
  protected val headerSrc: SCImgURL = "[SKIN]Window/headerGradient.gif"
  protected val headerStyle: CSSStyleName = "WindowHeader"
  protected val hiliteBodyColor: Color = "#EEEEEE"
  protected val hiliteHeaderSrc: SCImgURL = "[SKIN]Window/headerGradient_hilite.gif"
  protected val hiliteHeaderStyle: CSSStyleName = "WindowHeader"
  protected val isModal: Bool = false
  protected val items: ArrayDyn[CanvasDyn] = null
  protected val maximizeButton: AutoChild = null
  protected val maximized: Bool = false
  protected val minimizeAcceleration: AnimationAcceleration = anAcsNull
  protected val minimizeButton: AutoChild = null
  protected val minimized: Bool = false
  protected val minimizeHeight: Number = null
  protected val minimizeTime: Number = null
  protected val modalMask: AutoChild = null
  protected val modalMaskOpacity: Number = 50
  protected val modalMaskStyle: String = "modalMask"
  protected val onCloseClick: FunctionExpression = null
  protected val onMaximizeClick: FunctionExpression = null
  protected val onMinimizeClick: FunctionExpression = null
  protected val onRestoreClick: FunctionExpression = null
  protected val resizer: AutoChild = null
  protected val restoreButton: AutoChild = null
  protected val showBody: Bool = true
  protected val showCloseButton: Bool = true
  protected val showFooter: Bool = true
  protected val showHeader: Bool = true
  protected val showHeaderBackground: Bool = false
  protected val showHeaderIcon: Bool = true
  protected val showMaximizeButton: Bool = false
  protected val showMinimizeButton: Bool = true
  protected val showModalMask: Bool = false
  protected val showResizer: Bool = true
  protected val showStatusBar: Bool = true
  protected val showTitle: Bool = true
  protected val src: String = ""
  protected val status: String = ""
  protected val statusBar: AutoChild = null
  protected val title: JsonElement = "Untitled Window"
}