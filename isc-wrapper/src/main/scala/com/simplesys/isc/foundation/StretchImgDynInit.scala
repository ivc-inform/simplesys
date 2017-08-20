package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonNull, JsonList}

trait StretchImgDynInit extends StatefulCanvasDynInit {
  protected val capSize: Number = 2
  protected val gripImgSuffix: String = "grip"
  protected val hSrc: SCImgURL = JsonNull
  protected val imageType: ImageStyle = imgStStretch
  protected val itemBaseStyle: CSSStyleName = ""
  protected val items: JsonList = JsonList()
  protected val showDownGrip: Bool = null
  protected val showGrip: Bool = null
  protected val showRollOverGrip: Bool = null
  protected val showTitle: Bool = false
  protected val src: SCImgURL = JsonNull
  protected val vertical: Bool = true
  protected val vSrc: SCImgURL = JsonNull
}