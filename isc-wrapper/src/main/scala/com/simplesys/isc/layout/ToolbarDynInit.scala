package com.simplesys.isc.layout

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.foundation.CanvasDyn


trait ToolbarDynInit extends LayoutDynInit {
  protected val buttonConstructor: SCClassName = "Button"
  protected val buttonDefaults: ClassDyn = null
  protected val buttons: ArrayDyn[CanvasDyn] = null
  protected val canReorderItems: Bool = false
  protected val canResizeItems: Bool = false
  protected val itemClick: FunctionExpression = null
  protected val itemDoubleClick: FunctionExpression = null
  protected val itemDragResized: FunctionExpression = null
}