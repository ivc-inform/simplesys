package com.simplesys.isc.forms.formItems

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._

object CheckboxItemDyn {
  implicit def CheckboxItemtoJsonObject(in: CheckboxItemDyn): JsonObject = in json
}

class CheckboxItemDyn extends CycleItemDyn with CheckboxItemDynInit {

  private[this] var _allowEmptyValue: Bool = allowEmptyValue
  def AllowEmptyValue = _allowEmptyValue
  def AllowEmptyValue_=(value: Bool) {
    if (_allowEmptyValue == value) return
    json("allowEmptyValue") = value
    _allowEmptyValue = value
  }

  private[this] var _checkedImage: SCImgURL = checkedImage
  def CheckedImage = _checkedImage
  def CheckedImage_=(value: SCImgURL) {
    if (_checkedImage == value) return
    json("checkedImage") = value
    _checkedImage = value
  }

  private[this] var _labelAsTitle: Bool = labelAsTitle
  def LabelAsTitle = _labelAsTitle
  def LabelAsTitle_=(value: Bool) {
    if (_labelAsTitle == value) return
    json("labelAsTitle") = value
    _labelAsTitle = value
  }

  private[this] var _partialSelectedImage: SCImgURL = partialSelectedImage
  def PartialSelectedImage = _partialSelectedImage
  def PartialSelectedImage_=(value: SCImgURL) {
    if (_partialSelectedImage == value) return
    json("partialSelectedImage") = value
    _partialSelectedImage = value
  }

  private[this] var _showLabel: Bool = showLabel
  def ShowLabel = _showLabel
  def ShowLabel_=(value: Bool) {
    if (_showLabel == value) return
    json("showLabel") = value
    _showLabel = value
  }

  private[this] var _showUnsetImage: Bool = showUnsetImage
  def ShowUnsetImage = _showUnsetImage
  def ShowUnsetImage_=(value: Bool) {
    if (_showUnsetImage == value) return
    json("showUnsetImage") = value
    _showUnsetImage = value
  }

  private[this] var _uncheckedImage: SCImgURL = uncheckedImage
  def UncheckedImage = _uncheckedImage
  def UncheckedImage_=(value: SCImgURL) {
    if (_uncheckedImage == value) return
    json("uncheckedImage") = value
    _uncheckedImage = value
  }

  private[this] var _unsetImage: SCImgURL = unsetImage
  def UnsetImage = _unsetImage
  def UnsetImage_=(value: SCImgURL) {
    if (_unsetImage == value) return
    json("unsetImage") = value
    _unsetImage = value
  }
}

