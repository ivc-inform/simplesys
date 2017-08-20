package com.simplesys.isc.layout

import com.simplesys.isc.system.misc._

trait SnapbarDynInit extends SplitbarDynInit {
  override protected val gripImgSuffix: String = "snap"
  override protected val showClosedGrip: Bool = true
  override protected val showDown: Bool = true
  override protected val showDownGrip: Bool = true
  override protected val showGrip: Bool = true
  override protected val showRollOver: Bool = true
  override protected val showRollOverGrip: Bool = true
}