package com.simplesys.isc.layout

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.FunctionExpression

object NavigationBarDyn {

  implicit def NavigationBar2JsonObject(in: NavigationBarDyn): JsonObject = in json
}

class NavigationBarDyn(override val useSelfName: Boolean = false) extends HLayoutDyn with NavigationBarDynInit {
  override val selfName = "NavigationBar"

  private[this] var _leftButton: AutoChild = leftButton
  def LeftButton = _leftButton
  def LeftButton_=(value: AutoChild) {
    if (_leftButton == value) return
    json("leftButton") = value
    _leftButton = value
  }

  private[this] var _leftButtonIcon: SCImgURL = leftButtonIcon
  def LeftButtonIcon = _leftButtonIcon
  def LeftButtonIcon_=(value: SCImgURL) {
    if (_leftButtonIcon == value) return
    json("leftButtonIcon") = value
    _leftButtonIcon = value
  }

  private[this] var _leftButtonTitle: String = leftButtonTitle
  def LeftButtonTitle = _leftButtonTitle
  def LeftButtonTitle_=(value: String) {
    if (_leftButtonTitle == value) return
    json("leftButtonTitle") = value
    _leftButtonTitle = value
  }

  private[this] var _navigationClick: FunctionExpression = navigationClick
  def NavigationClick = _navigationClick
  def NavigationClick_=(value: FunctionExpression) {
    if (_navigationClick == value) return
    json("navigationClick") = value
    _navigationClick = value
  }

  private[this] var _rightButton: AutoChild = rightButton
  def RightButton = _rightButton
  def RightButton_=(value: AutoChild) {
    if (_rightButton == value) return
    json("rightButton") = value
    _rightButton = value
  }

  private[this] var _rightButtonIcon: SCImgURL = rightButtonIcon
  def RightButtonIcon = _rightButtonIcon
  def RightButtonIcon_=(value: SCImgURL) {
    if (_rightButtonIcon == value) return
    json("rightButtonIcon") = value
    _rightButtonIcon = value
  }

  private[this] var _rightButtonTitle: String = rightButtonTitle
  def RightButtonTitle = _rightButtonTitle
  def RightButtonTitle_=(value: String) {
    if (_rightButtonTitle == value) return
    json("rightButtonTitle") = value
    _rightButtonTitle = value
  }

  private[this] var _title: String = title
  def Title = _title
  def Title_=(value: String) {
    if (_title == value) return
    json("title") = value
    _title = value
  }

  private[this] var _titleLabel: AutoChild = titleLabel
  def TitleLabel = _titleLabel
  def TitleLabel_=(value: AutoChild) {
    if (_titleLabel == value) return
    json("titleLabel") = value
    _titleLabel = value
  }
}