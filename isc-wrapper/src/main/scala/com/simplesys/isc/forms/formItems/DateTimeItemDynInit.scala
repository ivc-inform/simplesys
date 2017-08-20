package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool
import DateDisplayFormat._

trait DateTimeItemDynInit extends DateItemDynInit {
  override protected val inputFormat: DateInputFormat = ""
  override protected val useTextField: Bool = true
}