package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait SelectOtherItemDynInit {
  protected val dialogWidth: Number = 250
  protected val otherTitle: String = "Other..."
  protected val otherValue: String = "***other***"
  protected val selectOtherPrompt: HTMLString = "Other value for <br/>?"
  protected val separatorTitle: String = "--------------------"
  protected val separatorValue: String = "----"
}