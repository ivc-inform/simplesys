package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.misc.Bool


trait LinkItemDynInit extends TextItemDynInit {
  override protected val disableIconsOnReadOnly: Bool = false
  protected val linkTitle: String = ""
  protected val target: String = "_blank"
}