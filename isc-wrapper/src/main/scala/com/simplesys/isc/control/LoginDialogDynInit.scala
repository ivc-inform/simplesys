package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDynInit
import com.simplesys.json.JsonList
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.forms.formItems.FormItemDyn

trait LoginDialogDynInit extends WindowDynInit {
  protected val allowBlankPassword: Bool = false
  protected val dismissable: Bool = false
  protected val errorMessage: String = "Invalid username or password"
  protected val errorStyle: CSSStyleName = "formCellError"
  protected val formFields: ArrayDyn[FormItemDyn] = null
  protected val loginButton: AutoChild = null
  protected val loginButtonTitle: String = "Log in"
  protected val loginFailureItem: AutoChild = null
  protected val loginForm: AutoChild = null
  protected val loginFunc: FunctionExpression = null
  protected val lostPassword: FunctionExpression = null
  protected val lostPasswordItem: AutoChild = null
  protected val lostPasswordItemTitle: HTMLString = ""
  protected val passwordItem: AutoChild = null
  protected val passwordItemTitle: HTMLString = "Password"
  protected val register: FunctionExpression = null
  protected val registrationItem: AutoChild = null
  protected val registrationItemTitle: HTMLString = ""
  protected val showLostPasswordLink: Bool = false
  protected val showRegistrationLink: Bool = false
  protected val usernameItem: AutoChild = null
  protected val usernameItemTitle: HTMLString = "Username"
}