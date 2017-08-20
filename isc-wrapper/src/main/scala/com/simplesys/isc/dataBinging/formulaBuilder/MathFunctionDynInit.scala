package com.simplesys.isc.dataBinging.formulaBuilder

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDynInit

trait MathFunctionDynInit extends ClassDynInit {
  protected val defaultSortPosition: Number = -1
  protected val description: String = ""
  protected val jsFunction: FunctionExpression = null
  protected val name: String = ""
}