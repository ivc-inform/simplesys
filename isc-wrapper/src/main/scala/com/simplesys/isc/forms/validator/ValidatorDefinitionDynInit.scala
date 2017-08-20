package com.simplesys.isc.forms.validator

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDynInit

trait ValidatorDefinitionDynInit extends ClassDynInit {
  protected val action: FunctionExpression = null
  protected val condition: FunctionExpression = null
  protected val defaultErrorMessage: String = ""
  protected val requiresServer: Bool = false
  protected val title: String = ""
  protected val __type: String = ""
}