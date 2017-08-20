package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StretchImgDyn

trait ProgressbarDynInit extends StretchImgDyn {
  protected val breadth: Number = 20
  protected val length: Number = 100
  protected val percentChanged: FunctionExpression = null
  protected val percentDone: Number = 0
  override protected val src: SCImgURL = "[SKIN]progressbar.gif"
  override protected val vertical: Bool = false
}