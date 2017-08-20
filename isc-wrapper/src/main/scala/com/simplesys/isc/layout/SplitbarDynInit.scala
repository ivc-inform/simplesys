package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.{CanvasDyn, StretchImgDynInit}
import com.simplesys.json.UnquotedString

trait SplitbarDynInit extends StretchImgDynInit {
  protected val canCollapse: Bool = true
  override protected val canDrag: Bool = true
  override protected val capSize: Number = null
  override protected val cursor: Cursor = crHand
  protected val hResizeCursor: Cursor = crColResize
  protected val showClosedGrip: Bool = null
  override protected val skinImgDir: URL = null
  protected val target: CanvasDyn = null
  override protected val vertical: Bool = null
  protected val vResizeCursor: Cursor = crRowResize
}