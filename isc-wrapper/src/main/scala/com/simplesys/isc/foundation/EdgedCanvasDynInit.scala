package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.UnquotedString

trait EdgedCanvasDynInit extends CanvasDynInit {
  protected val addEdgeStyleSuffix: Bool = false
  protected val centerBackgroundColor: Color = ""
  protected val edgeBottom: Number = null
  protected val edgeColor: Color = ""
  override protected val edgeImage: SCImgURL = "[SKIN]/rounded/frame/FFFFFF/6.png"
  protected val edgeLeft: Number = null
  protected val edgeOffsetBottom: Number = null
  protected val edgeOffsetLeft: Number = null
  protected val edgeOffsetRight: Number = null
  protected val edgeOffsetTop: Number = null
  protected val edgeRight: Number = null
  override protected val edgeSize: Number = 6
  protected val edgeStyleName: CSSStyleName = ""
  protected val edgeTop: Number = null
  protected val showCenter: Bool = false
  override protected val skinImgDir: URL = "images/edges/".url
}