package com.simplesys.isc.foundation

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.UnquotedString


trait ScrollbarDynInit extends StretchImgDynInit {
  protected val allowThumbDownState: Bool = false
  protected val allowThumbOverState: Bool = false
  protected val autoEnable: Bool = true
  protected val btnSize: Number = 16
  protected val cornerSize: Number = null
  protected val cornerSrc: SCImgURL = "[SKIN]corner.gif"
  protected val endThumbOverlap: Number = null
  override protected val hSrc: SCImgURL = "[SKIN]hscroll.gif"
  protected val scrollTarget: CanvasDyn = null
  protected val showCorner: Bool = false
  protected val showTrackEnds: Bool = false
  override protected val skinImgDir: URL = "images/Scrollbar/".url
  protected val startThumbOverlap: Number = null
  protected val thumbInset: Number = null
  protected val thumbMinSize: Number = 12
  protected val thumbOverlap: Number = 1
  protected val trackEndHeight: Number = 12
  protected val trackEndWidth: Number = 12
  override protected val vSrc: SCImgURL = "[SKIN]vscroll.gif"
}