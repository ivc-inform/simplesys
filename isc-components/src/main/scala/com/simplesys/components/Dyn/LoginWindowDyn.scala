package com.simplesys.components.Dyn

import com.simplesys.json.JsonObject
import com.simplesys.components.Dyn.Layout.WindowSSDyn

object LoginWindowDyn {
  implicit def LoginWindowDyn2JsonObject(in: LoginWindowDyn): JsonObject = in json
}

class LoginWindowDyn(override val useSelfName: Boolean = false) extends WindowSSDyn with LoginWindowDynInit {
  override val selfName = "LoginWindow"

  def Login = json.getStringOpt("login").getOrElse(login)
  def Login_=(value: String) {
    if (Login == value) return
    json("login") = value
  }

  def Password = json.getStringOpt("password").getOrElse(password)
  def Password_=(value: String) {
    if (Password == value) return
    json("password") = value
  }
}