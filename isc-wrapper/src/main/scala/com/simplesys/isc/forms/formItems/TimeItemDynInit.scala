package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

trait TimeItemDynInit extends TextItemDynInit {
  override protected val timeFormatter: TimeDisplayFormat = tmDspFmtToShort24HourTime
  protected val useMask: Bool = false
}