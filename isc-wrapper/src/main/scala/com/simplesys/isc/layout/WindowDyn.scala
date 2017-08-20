package com.simplesys.isc.layout

import com.simplesys.json._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc.SCClassName
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName

object WindowDyn {

  implicit def WindowtoJsonObject(in: WindowDyn): JsonObject = in json
}

class WindowDyn(override val useSelfName: Boolean = false) extends LayoutDyn with WindowDynInit {
  override val selfName = "Window"

  private[this] var _animateMinimize: Bool = animateMinimize
  def AnimateMinimize = _animateMinimize
  def AnimateMinimize_=(value: Bool) {
    if (_animateMinimize == value) return
    json("animateMinimize") = value
    _animateMinimize = value
  }

  private[this] var _autoCenter: Bool = autoCenter
  def AutoCenter = _autoCenter
  def AutoCenter_=(value: Bool) {
    if (_autoCenter == value) return
    json("autoCenter") = value
    _autoCenter = value
  }

  private[this] var _autoSize: Bool = autoSize
  def AutoSize = _autoSize
  def AutoSize_=(value: Bool) {
    if (_autoSize == value) return
    json("autoSize") = value
    _autoSize = value
  }

  private[this] var _body: AutoChild = body
  def Body = _body
  def Body_=(value: AutoChild) {
    if (_body == value) return
    json("body") = value
    _body = value
  }

  private[this] var _bodyColor: Color = bodyColor
  def BodyColor = _bodyColor
  def BodyColor_=(value: Color) {
    if (_bodyColor == value) return
    json("bodyColor") = value
    _bodyColor = value
  }

  private[this] var _bodyConstructor: SCClassName = bodyConstructor
  def BodyConstructor = _bodyConstructor
  def BodyConstructor_=(value: SCClassName) {
    if (_bodyConstructor == value) return
    json("bodyConstructor") = value
    _bodyConstructor = value
  }

  private[this] var _bodyDefaults: ClassDyn = bodyDefaults
  def BodyDefaults = _bodyDefaults
  def BodyDefaults_=(value: ClassDyn) {
    if (_bodyDefaults == value) return
    json("bodyDefaults") = value
    _bodyDefaults = value
  }

  private[this] var _bodyStyle: String = bodyStyle
  def BodyStyle = _bodyStyle
  def BodyStyle_=(value: String) {
    if (_bodyStyle == value) return
    json("bodyStyle") = value
    _bodyStyle = value
  }

  private[this] var _canDragReposition: Bool = canDragReposition
  override def CanDragReposition = _canDragReposition
  override def CanDragReposition_=(value: Bool) {
    if (_canDragReposition == value) return
    json("canDragReposition") = value
    _canDragReposition = value
  }

  private[this] var _canDragResize: Bool = canDragResize
  override def CanDragResize = _canDragResize
  override def CanDragResize_=(value: Bool) {
    if (_canDragResize == value) return
    json("canDragResize") = value
    _canDragResize = value
  }

  private[this] var _canFocusInHeaderButtons: Bool = canFocusInHeaderButtons
  def CanFocusInHeaderButtons = _canFocusInHeaderButtons
  def CanFocusInHeaderButtons_=(value: Bool) {
    if (_canFocusInHeaderButtons == value) return
    json("canFocusInHeaderButtons") = value
    _canFocusInHeaderButtons = value
  }

  private[this] var _closeButton: AutoChild = closeButton
  def CloseButton = _closeButton
  def CloseButton_=(value: AutoChild) {
    if (_closeButton == value) return
    json("closeButton") = value
    _closeButton = value
  }

  private[this] var _contentLayout: ContentLayout = contentLayout
  def ContentLayout = _contentLayout
  def ContentLayout_=(value: ContentLayout) {
    if (_contentLayout == value) return
    json("contentLayout") = value
    _contentLayout = value
  }

  private[this] var _contentsType: String = contentsType
  def ContentsType = _contentsType
  def ContentsType_=(value: String) {
    if (_contentsType == value) return
    json("contentsType") = value
    _contentsType = value
  }

  private[this] var _defaultMinimizeHeight: Number = defaultMinimizeHeight
  def DefaultMinimizeHeight = _defaultMinimizeHeight
  def DefaultMinimizeHeight_=(value: Number) {
    if (_defaultMinimizeHeight == value) return
    json("defaultMinimizeHeight") = value
    _defaultMinimizeHeight = value
  }

  private[this] var _dismissOnEscape: Bool = dismissOnEscape
  def DismissOnEscape = _dismissOnEscape
  def DismissOnEscape_=(value: Bool) {
    if (_dismissOnEscape == value) return
    json("dismissOnEscape") = value
    _dismissOnEscape = value
  }

  private[this] var _dismissOnOutsideClick: Bool = dismissOnOutsideClick
  def DismissOnOutsideClick = _dismissOnOutsideClick
  def DismissOnOutsideClick_=(value: Bool) {
    if (_dismissOnOutsideClick == value) return
    json("dismissOnOutsideClick") = value
    _dismissOnOutsideClick = value
  }

  private[this] var _footer: AutoChild = footer
  def Footer = _footer
  def Footer_=(value: AutoChild) {
    if (_footer == value) return
    json("footer") = value
    _footer = value
  }

  private[this] var _footerControls: JsonList = footerControls
  def FooterControls = _footerControls
  def FooterControls_=(value: JsonList) {
    if (_footerControls == value) return
    json("footerControls") = value
    _footerControls = value
  }

  private[this] var _footerHeight: Number = footerHeight
  def FooterHeight = _footerHeight
  def FooterHeight_=(value: Number) {
    if (_footerHeight == value) return
    json("footerHeight") = value
    _footerHeight = value
  }

  private[this] var _header: AutoChild = header
  def Header = _header
  def Header_=(value: AutoChild) {
    if (_header == value) return
    json("header") = value
    _header = value
  }

  private[this] var _headerBackground: AutoChild = headerBackground
  def HeaderBackground = _headerBackground
  def HeaderBackground_=(value: AutoChild) {
    if (_headerBackground == value) return
    json("headerBackground") = value
    _headerBackground = value
  }

  private[this] var _headerControls: JsonList = headerControls
  def HeaderControls = _headerControls
  def HeaderControls_=(value: JsonList) {
    if (_headerControls == value) return
    json("headerControls") = value
    _headerControls = value
  }

  def HeaderIcon = json.getJsonElement("headerIcon").getOrElse(headerIcon)
  def HeaderIcon_=(value: JsonElement) {
    if (HeaderIcon == value) return
    json("headerIcon") = value
  }

  def HeaderIconDefaults = json.getJsonElement("headerIconDefaults").getOrElse(headerIconDefaults)
  def HeaderIconDefaults_=(value: JsonElement) {
    if (HeaderIconDefaults == value) return
    json("headerIconDefaults") = value
  }

  private[this] var _headerLabel: AutoChild = headerLabel
  def HeaderLabel = _headerLabel
  def HeaderLabel_=(value: AutoChild) {
    if (_headerLabel == value) return
    json("headerLabel") = value
    _headerLabel = value
  }

  private[this] var _headerLabelDefaults: JsonList = headerLabelDefaults
  def HeaderLabelDefaults = _headerLabelDefaults
  def HeaderLabelDefaults_=(value: JsonList) {
    json("headerLabelDefaults") = value
    _headerLabelDefaults = value
  }

  private[this] var _headerSrc: SCImgURL = headerSrc
  def HeaderSrc = _headerSrc
  def HeaderSrc_=(value: SCImgURL) {
    if (_headerSrc == value) return
    json("headerSrc") = value
    _headerSrc = value
  }

  private[this] var _headerStyle: CSSStyleName = headerStyle
  def HeaderStyle = _headerStyle
  def HeaderStyle_=(value: CSSStyleName) {
    if (_headerStyle == value) return
    json("headerStyle") = value
    _headerStyle = value
  }

  private[this] var _hiliteBodyColor: Color = hiliteBodyColor
  def HiliteBodyColor = _hiliteBodyColor
  def HiliteBodyColor_=(value: Color) {
    if (_hiliteBodyColor == value) return
    json("hiliteBodyColor") = value
    _hiliteBodyColor = value
  }

  private[this] var _hiliteHeaderSrc: SCImgURL = hiliteHeaderSrc
  def HiliteHeaderSrc = _hiliteHeaderSrc
  def HiliteHeaderSrc_=(value: SCImgURL) {
    if (_hiliteHeaderSrc == value) return
    json("hiliteHeaderSrc") = value
    _hiliteHeaderSrc = value
  }

  private[this] var _hiliteHeaderStyle: CSSStyleName = hiliteHeaderStyle
  def HiliteHeaderStyle = _hiliteHeaderStyle
  def HiliteHeaderStyle_=(value: CSSStyleName) {
    if (_hiliteHeaderStyle == value) return
    json("hiliteHeaderStyle") = value
    _hiliteHeaderStyle = value
  }

  private[this] var _isModal: Bool = isModal
  def IsModal = _isModal
  def IsModal_=(value: Bool) {
    if (_isModal == value) return
    json("isModal") = value
    _isModal = value
  }

  def Items = json.getValue2[JsonList, ArrayDyn[CanvasDyn]]("items").getOrElse(items)
  def Items_=(value: ArrayDyn[CanvasDyn]) {
    if (Items == value) return
    json("items") = value
  }

  private[this] var _maximizeButton: AutoChild = maximizeButton
  def MaximizeButton = _maximizeButton
  def MaximizeButton_=(value: AutoChild) {
    if (_maximizeButton == value) return
    json("maximizeButton") = value
    _maximizeButton = value
  }

  private[this] var _maximized: Bool = maximized
  def Maximized = _maximized
  def Maximized_=(value: Bool) {
    if (_maximized == value) return
    json("maximized") = value
    _maximized = value
  }

  private[this] var _minimizeAcceleration: AnimationAcceleration = minimizeAcceleration
  def MinimizeAcceleration = _minimizeAcceleration
  def MinimizeAcceleration_=(value: AnimationAcceleration) {
    if (_minimizeAcceleration == value) return
    json("minimizeAcceleration") = value
    _minimizeAcceleration = value
  }

  private[this] var _minimizeButton: AutoChild = minimizeButton
  def MinimizeButton = _minimizeButton
  def MinimizeButton_=(value: AutoChild) {
    if (_minimizeButton == value) return
    json("minimizeButton") = value
    _minimizeButton = value
  }

  private[this] var _minimized: Bool = minimized
  def Minimized = _minimized
  def Minimized_=(value: Bool) {
    if (_minimized == value) return
    json("minimized") = value
    _minimized = value
  }

  private[this] var _minimizeHeight: Number = minimizeHeight
  def MinimizeHeight = _minimizeHeight
  def MinimizeHeight_=(value: Number) {
    if (_minimizeHeight == value) return
    json("minimizeHeight") = value
    _minimizeHeight = value
  }

  private[this] var _minimizeTime: Number = minimizeTime
  def MinimizeTime = _minimizeTime
  def MinimizeTime_=(value: Number) {
    if (_minimizeTime == value) return
    json("minimizeTime") = value
    _minimizeTime = value
  }

  private[this] var _modalMask: AutoChild = modalMask
  def ModalMask = _modalMask
  def ModalMask_=(value: AutoChild) {
    if (_modalMask == value) return
    json("modalMask") = value
    _modalMask = value
  }

  private[this] var _modalMaskOpacity: Number = modalMaskOpacity
  def ModalMaskOpacity = _modalMaskOpacity
  def ModalMaskOpacity_=(value: Number) {
    if (_modalMaskOpacity == value) return
    json("modalMaskOpacity") = value
    _modalMaskOpacity = value
  }

  private[this] var _modalMaskStyle: String = modalMaskStyle
  def ModalMaskStyle = _modalMaskStyle
  def ModalMaskStyle_=(value: String) {
    if (_modalMaskStyle == value) return
    json("modalMaskStyle") = value
    _modalMaskStyle = value
  }

  private[this] var _resizer: AutoChild = resizer
  def Resizer = _resizer
  def Resizer_=(value: AutoChild) {
    if (_resizer == value) return
    json("resizer") = value
    _resizer = value
  }

  private[this] var _restoreButton: AutoChild = restoreButton
  def RestoreButton = _restoreButton
  def RestoreButton_=(value: AutoChild) {
    if (_restoreButton == value) return
    json("restoreButton") = value
    _restoreButton = value
  }

  private[this] var _showBody: Bool = showBody
  def ShowBody = _showBody
  def ShowBody_=(value: Bool) {
    if (_showBody == value) return
    json("showBody") = value
    _showBody = value
  }

  private[this] var _showCloseButton: Bool = showCloseButton
  def ShowCloseButton = _showCloseButton
  def ShowCloseButton_=(value: Bool) {
    if (_showCloseButton == value) return
    json("showCloseButton") = value
    _showCloseButton = value
  }

  private[this] var _showFooter: Bool = showFooter
  def ShowFooter = _showFooter
  def ShowFooter_=(value: Bool) {
    if (_showFooter == value) return
    json("showFooter") = value
    _showFooter = value
  }

  private[this] var _showHeader: Bool = showHeader
  def ShowHeader = _showHeader
  def ShowHeader_=(value: Bool) {
    if (_showHeader == value) return
    json("showHeader") = value
    _showHeader = value
  }

  private[this] var _showHeaderBackground: Bool = showHeaderBackground
  def ShowHeaderBackground = _showHeaderBackground
  def ShowHeaderBackground_=(value: Bool) {
    if (_showHeaderBackground == value) return
    json("showHeaderBackground") = value
    _showHeaderBackground = value
  }

  private[this] var _showHeaderIcon: Bool = showHeaderIcon
  def ShowHeaderIcon = _showHeaderIcon
  def ShowHeaderIcon_=(value: Bool) {
    if (_showHeaderIcon == value) return
    json("showHeaderIcon") = value
    _showHeaderIcon = value
  }

  private[this] var _showMaximizeButton: Bool = showMaximizeButton
  def ShowMaximizeButton = _showMaximizeButton
  def ShowMaximizeButton_=(value: Bool) {
    if (_showMaximizeButton == value) return
    json("showMaximizeButton") = value
    _showMaximizeButton = value
  }

  private[this] var _showMinimizeButton: Bool = showMinimizeButton
  def ShowMinimizeButton = _showMinimizeButton
  def ShowMinimizeButton_=(value: Bool) {
    if (_showMinimizeButton == value) return
    json("showMinimizeButton") = value
    _showMinimizeButton = value
  }

  private[this] var _showModalMask: Bool = showModalMask
  def ShowModalMask = _showModalMask
  def ShowModalMask_=(value: Bool) {
    if (_showModalMask == value) return
    json("showModalMask") = value
    _showModalMask = value
  }

  private[this] var _showResizer: Bool = showResizer
  def ShowResizer = _showResizer
  def ShowResizer_=(value: Bool) {
    if (_showResizer == value) return
    json("showResizer") = value
    _showResizer = value
  }

  private[this] var _showStatusBar: Bool = showStatusBar
  def ShowStatusBar = _showStatusBar
  def ShowStatusBar_=(value: Bool) {
    if (_showStatusBar == value) return
    json("showStatusBar") = value
    _showStatusBar = value
  }

  private[this] var _showTitle: Bool = showTitle
  def ShowTitle = _showTitle
  def ShowTitle_=(value: Bool) {
    if (_showTitle == value) return
    json("showTitle") = value
    _showTitle = value
  }

  private[this] var _src: String = src
  def Src = _src
  def Src_=(value: String) {
    if (_src == value) return
    json("src") = value
    _src = value
  }

  private[this] var _status: String = status
  def Status = _status
  def Status_=(value: String) {
    if (_status == value) return
    json("status") = value
    _status = value
  }

  private[this] var _statusBar: AutoChild = statusBar
  def StatusBar = _statusBar
  def StatusBar_=(value: AutoChild) {
    if (_statusBar == value) return
    json("statusBar") = value
    _statusBar = value
  }

  def Title = json.getJsonElement("title").getOrElse(title)
  def Title_=(value: JsonElement) {
    if (Title == value) return
    json("title") = value
  }

  private[this] var _closeClick: FunctionExpression = closeClick
  def CloseClick = _closeClick
  def CloseClick_=(value: FunctionExpression) {
    if (_closeClick == value) return
    json("closeClick") = value
    _closeClick = value
  }

  private[this] var _onCloseClick: FunctionExpression = onCloseClick
  def OnCloseClick = _onCloseClick
  def OnCloseClick_=(value: FunctionExpression) {
    if (_onCloseClick == value) return
    json("onCloseClick") = value
    _onCloseClick = value
  }

  private[this] var _onMaximizeClick: FunctionExpression = onMaximizeClick
  def OnMaximizeClick = _onMaximizeClick
  def OnMaximizeClick_=(value: FunctionExpression) {
    if (_onMaximizeClick == value) return
    json("onMaximizeClick") = value
    _onMaximizeClick = value
  }

  private[this] var _onMinimizeClick: FunctionExpression = onMinimizeClick
  def OnMinimizeClick = _onMinimizeClick
  def OnMinimizeClick_=(value: FunctionExpression) {
    if (_onMinimizeClick == value) return
    json("onMinimizeClick") = value
    _onMinimizeClick = value
  }

  private[this] var _onRestoreClick: FunctionExpression = onRestoreClick
  def OnRestoreClick = _onRestoreClick
  def OnRestoreClick_=(value: FunctionExpression) {
    if (_onRestoreClick == value) return
    json("onRestoreClick") = value
    _onRestoreClick = value
  }

}

