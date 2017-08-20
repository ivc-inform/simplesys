package com.simplesys.isc.control

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.WindowDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.forms.formItems.FormItemDyn

object LoginDialogDyn {
  implicit def LoginDialog2JsonObject(in: LoginDialogDyn): JsonObject = in json
}

class LoginDialogDyn(override val useSelfName: Boolean = false) extends WindowDyn with LoginDialogDynInit {
  override val selfName = "LoginDialog"

  private[this] var _allowBlankPassword: Bool = allowBlankPassword
  def AllowBlankPassword = _allowBlankPassword
  def AllowBlankPassword_=(value: Bool) {
    if (_allowBlankPassword == value) return
    json("allowBlankPassword") = value
    _allowBlankPassword = value
  }

  private[this] var _dismissable: Bool = dismissable
  def Dismissable = _dismissable
  def Dismissable_=(value: Bool) {
    if (_dismissable == value) return
    json("dismissable") = value
    _dismissable = value
  }

  private[this] var _errorMessage: String = errorMessage
  def ErrorMessage = _errorMessage
  def ErrorMessage_=(value: String) {
    if (_errorMessage == value) return
    json("errorMessage") = value
    _errorMessage = value
  }

  private[this] var _errorStyle: CSSStyleName = errorStyle
  def ErrorStyle = _errorStyle
  def ErrorStyle_=(value: CSSStyleName) {
    if (_errorStyle == value) return
    json("errorStyle") = value
    _errorStyle = value
  }

  private[this] var _formFields: ArrayDyn[FormItemDyn] = formFields
  def FormFields = _formFields
  def FormFields_=(value: ArrayDyn[FormItemDyn]) {
    if (_formFields == value) return
    json("formFields") = value
    _formFields = value
  }

  private[this] var _loginButton: AutoChild = loginButton
  def LoginButton = _loginButton
  def LoginButton_=(value: AutoChild) {
    if (_loginButton == value) return
    json("loginButton") = value
    _loginButton = value
  }

  private[this] var _loginButtonTitle: String = loginButtonTitle
  def LoginButtonTitle = _loginButtonTitle
  def LoginButtonTitle_=(value: String) {
    if (_loginButtonTitle == value) return
    json("loginButtonTitle") = value
    _loginButtonTitle = value
  }

  private[this] var _loginFailureItem: AutoChild = loginFailureItem
  def LoginFailureItem = _loginFailureItem
  def LoginFailureItem_=(value: AutoChild) {
    if (_loginFailureItem == value) return
    json("loginFailureItem") = value
    _loginFailureItem = value
  }

  private[this] var _loginForm: AutoChild = loginForm
  def LoginForm = _loginForm
  def LoginForm_=(value: AutoChild) {
    if (_loginForm == value) return
    json("loginForm") = value
    _loginForm = value
  }

  private[this] var _loginFunc: FunctionExpression = loginFunc
  def LoginFunc = _loginFunc
  def LoginFunc_=(value: FunctionExpression) {
    if (_loginFunc == value) return
    json("loginFunc") = value
    _loginFunc = value
  }

  private[this] var _lostPassword: FunctionExpression = lostPassword
  def LostPassword = _lostPassword
  def LostPassword_=(value: FunctionExpression) {
    if (_lostPassword == value) return
    json("lostPassword") = value
    _lostPassword = value
  }

  private[this] var _lostPasswordItem: AutoChild = lostPasswordItem
  def LostPasswordItem = _lostPasswordItem
  def LostPasswordItem_=(value: AutoChild) {
    if (_lostPasswordItem == value) return
    json("lostPasswordItem") = value
    _lostPasswordItem = value
  }

  private[this] var _lostPasswordItemTitle: HTMLString = lostPasswordItemTitle
  def LostPasswordItemTitle = _lostPasswordItemTitle
  def LostPasswordItemTitle_=(value: HTMLString) {
    if (_lostPasswordItemTitle == value) return
    json("lostPasswordItemTitle") = value
    _lostPasswordItemTitle = value
  }

  private[this] var _passwordItem: AutoChild = passwordItem
  def PasswordItem = _passwordItem
  def PasswordItem_=(value: AutoChild) {
    if (_passwordItem == value) return
    json("passwordItem") = value
    _passwordItem = value
  }

  private[this] var _passwordItemTitle: HTMLString = passwordItemTitle
  def PasswordItemTitle = _passwordItemTitle
  def PasswordItemTitle_=(value: HTMLString) {
    if (_passwordItemTitle == value) return
    json("passwordItemTitle") = value
    _passwordItemTitle = value
  }

  private[this] var _register: FunctionExpression = register
  def Register = _register
  def Register_=(value: FunctionExpression) {
    if (_register == value) return
    json("register") = value
    _register = value
  }

  private[this] var _registrationItem: AutoChild = registrationItem
  def RegistrationItem = _registrationItem
  def RegistrationItem_=(value: AutoChild) {
    if (_registrationItem == value) return
    json("registrationItem") = value
    _registrationItem = value
  }

  private[this] var _registrationItemTitle: HTMLString = registrationItemTitle
  def RegistrationItemTitle = _registrationItemTitle
  def RegistrationItemTitle_=(value: HTMLString) {
    if (_registrationItemTitle == value) return
    json("registrationItemTitle") = value
    _registrationItemTitle = value
  }

  private[this] var _showLostPasswordLink: Bool = showLostPasswordLink
  def ShowLostPasswordLink = _showLostPasswordLink
  def ShowLostPasswordLink_=(value: Bool) {
    if (_showLostPasswordLink == value) return
    json("showLostPasswordLink") = value
    _showLostPasswordLink = value
  }

  private[this] var _showRegistrationLink: Bool = showRegistrationLink
  def ShowRegistrationLink = _showRegistrationLink
  def ShowRegistrationLink_=(value: Bool) {
    if (_showRegistrationLink == value) return
    json("showRegistrationLink") = value
    _showRegistrationLink = value
  }

  private[this] var _usernameItem: AutoChild = usernameItem
  def UsernameItem = _usernameItem
  def UsernameItem_=(value: AutoChild) {
    if (_usernameItem == value) return
    json("usernameItem") = value
    _usernameItem = value
  }

  private[this] var _usernameItemTitle: HTMLString = usernameItemTitle
  def UsernameItemTitle = _usernameItemTitle
  def UsernameItemTitle_=(value: HTMLString) {
    if (_usernameItemTitle == value) return
    json("usernameItemTitle") = value
    _usernameItemTitle = value
  }
}