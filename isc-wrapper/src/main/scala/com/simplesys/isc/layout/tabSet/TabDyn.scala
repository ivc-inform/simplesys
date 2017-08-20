package com.simplesys.isc.layout.tabSet

import com.simplesys.json.{JsonElement, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc._

object TabDyn {

    implicit def TabtoJsonObject(in: TabDyn): JsonObject = in json
}

class TabDyn(override val useSelfName: Boolean = false) extends ClassDyn with TabDynInit {
    override val selfName = "Tab"

    private[this] var _canClose: Bool = canClose
    def CanClose = _canClose
    def CanClose_=(value: Bool) {
        if (_canClose == value) return
        json("canClose") = value
        _canClose = value
    }

    private[this] var _canEditTitle: Bool = canEditTitle
    def CanEditTitle = _canEditTitle
    def CanEditTitle_=(value: Bool) {
        if (_canEditTitle == value) return
        json("canEditTitle") = value
        _canEditTitle = value
    }

    private[this] var _closeIcon: SCImgURL = closeIcon
    def CloseIcon = _closeIcon
    def CloseIcon_=(value: SCImgURL) {
        if (_closeIcon == value) return
        json("closeIcon") = value
        _closeIcon = value
    }

    private[this] var _closeIconSize: Number = closeIconSize
    def CloseIconSize = _closeIconSize
    def CloseIconSize_=(value: Number) {
        if (_closeIconSize == value) return
        json("closeIconSize") = value
        _closeIconSize = value
    }

    private[this] var _disabled: Bool = disabled
    def Disabled = _disabled
    def Disabled_=(value: Bool) {
        if (_disabled == value) return
        json("disabled") = value
        _disabled = value
    }

    private[this] var _icon: SCImgURL = icon
    def Icon = _icon
    def Icon_=(value: SCImgURL) {
        if (_icon == value) return
        json("icon") = value
        _icon = value
    }

    private[this] var _iconHeight: Number = iconHeight
    def IconHeight = _iconHeight
    def IconHeight_=(value: Number) {
        if (_iconHeight == value) return
        json("iconHeight") = value
        _iconHeight = value
    }

    private[this] var _iconSize: Number = iconSize
    def IconSize = _iconSize
    def IconSize_=(value: Number) {
        if (_iconSize == value) return
        json("iconSize") = value
        _iconSize = value
    }

    private[this] var _iconWidth: Number = iconWidth
    def IconWidth = _iconWidth
    def IconWidth_=(value: Number) {
        if (_iconWidth == value) return
        json("iconWidth") = value
        _iconWidth = value
    }

    def Pane = json.getValue2[JsonObject, CanvasDyn]("pane").getOrElse(pane)
    def Pane_=(value: CanvasDyn) {
        if (Pane == value) return
        json("pane") = value
    }

    private[this] var _pickerTitle: HTMLString = pickerTitle
    def PickerTitle = _pickerTitle
    def PickerTitle_=(value: HTMLString) {
        if (_pickerTitle == value) return
        json("pickerTitle") = value
        _pickerTitle = value
    }

    private[this] var _prompt: String = prompt
    def Prompt = _prompt
    def Prompt_=(value: String) {
        if (_prompt == value) return
        json("prompt") = value
        _prompt = value
    }

    private[this] var _title: HTMLString = title
    def Title = _title
    def Title_=(value: HTMLString) {
        if (_title == value) return
        json("title") = value
        _title = value
    }

    private[this] var _width: Number = width
    def Width = _width
    def Width_=(value: Number) {
        if (_width == value) return
        json("width") = value
        _width = value
    }

}