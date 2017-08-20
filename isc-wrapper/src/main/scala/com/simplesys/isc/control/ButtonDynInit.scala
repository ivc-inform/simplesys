package com.simplesys.isc.control

import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.StatefulCanvasDynInit

trait ButtonDynInit extends StatefulCanvasDynInit {
  protected val action: FunctionExpression = null
  override protected val baseStyle: CSSStyleName = "button"
  protected val hiliteAccessKey: Bool = false
  protected val iconAlign: String = ""
  protected val iconClick: FunctionExpression = null
  protected val message: String = ""
  protected val wrap: Bool = false
}