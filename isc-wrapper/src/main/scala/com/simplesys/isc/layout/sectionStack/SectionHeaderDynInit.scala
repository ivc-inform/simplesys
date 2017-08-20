package com.simplesys.isc.layout.sectionStack

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.{CanvasDyn, LabelDynInit}
import com.simplesys.isc.system.ArrayDyn

trait SectionHeaderDynInit extends LabelDynInit {
  override protected val baseStyle: CSSStyleName = "sectionHeader"
  protected val controls: ArrayDyn[CanvasDyn] = null
  protected val controlsLayout: AutoChild = null
  override protected val icon: SCImgURL = "[SKIN]SectionHeader/opener.gif"
}