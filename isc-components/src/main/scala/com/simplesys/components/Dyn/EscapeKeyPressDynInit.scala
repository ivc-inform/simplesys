package com.simplesys.components.Dyn

import com.simplesys.isc.system.misc._

trait EscapeKeyPressDynInit {
  private[Dyn] val focused: Bool = false
  private[Dyn] val escapeKeyPress: FunctionExpression = null
  private[Dyn] val canEdit: Bool = true
}