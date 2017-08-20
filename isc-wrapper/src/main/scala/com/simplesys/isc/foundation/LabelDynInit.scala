package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.control.ButtonDynInit
import com.simplesys.isc.system.misc.Bool

trait LabelDynInit extends ButtonDynInit {
  override protected val align: AlignmentDyn = AlLeft
  override protected val wrap: Bool = true
}