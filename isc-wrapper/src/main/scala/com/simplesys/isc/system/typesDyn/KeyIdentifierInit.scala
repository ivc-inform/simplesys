package com.simplesys.isc.system.typesDyn

import com.simplesys.isc.system.misc.Bool


trait KeyIdentifierInit {
  protected val keyName: String = ""
  protected val ctrlKey: Bool = false
  protected val shiftKey: Bool = false
  protected val altKey: Bool = false
}