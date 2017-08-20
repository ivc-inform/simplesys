package com.simplesys.isc.dataBinging

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.LayoutDyn
import com.simplesys.isc.system.ArrayDyn

object MultiSortPanelDyn {
  implicit def MultiSortPanel2JsonObject(in: MultiSortPanelDyn): JsonObject = in json
}

class MultiSortPanelDyn(override val useSelfName: Boolean = false) extends LayoutDyn with MultiSortPaneDynlInit {
  override val selfName = "MultiSortPanel"

  private[this] var _addLevelButton: AutoChild = addLevelButton
  def AddLevelButton = _addLevelButton
  def AddLevelButton_=(value: AutoChild) {
    if (_addLevelButton == value) return
    json("addLevelButton") = value
    _addLevelButton = value
  }

  private[this] var _addLevelButtonTitle: String = addLevelButtonTitle
  def AddLevelButtonTitle = _addLevelButtonTitle
  def AddLevelButtonTitle_=(value: String) {
    if (_addLevelButtonTitle == value) return
    json("addLevelButtonTitle") = value
    _addLevelButtonTitle = value
  }

  private[this] var _ascendingTitle: String = ascendingTitle
  def AscendingTitle = _ascendingTitle
  def AscendingTitle_=(value: String) {
    if (_ascendingTitle == value) return
    json("ascendingTitle") = value
    _ascendingTitle = value
  }

  private[this] var _copyLevelButton: AutoChild = copyLevelButton
  def CopyLevelButton = _copyLevelButton
  def CopyLevelButton_=(value: AutoChild) {
    if (_copyLevelButton == value) return
    json("copyLevelButton") = value
    _copyLevelButton = value
  }

  private[this] var _copyLevelButtonTitle: String = copyLevelButtonTitle
  def CopyLevelButtonTitle = _copyLevelButtonTitle
  def CopyLevelButtonTitle_=(value: String) {
    if (_copyLevelButtonTitle == value) return
    json("copyLevelButtonTitle") = value
    _copyLevelButtonTitle = value
  }

  private[this] var _deleteLevelButton: AutoChild = deleteLevelButton
  def DeleteLevelButton = _deleteLevelButton
  def DeleteLevelButton_=(value: AutoChild) {
    if (_deleteLevelButton == value) return
    json("deleteLevelButton") = value
    _deleteLevelButton = value
  }

  private[this] var _deleteLevelButtonTitle: String = deleteLevelButtonTitle
  def DeleteLevelButtonTitle = _deleteLevelButtonTitle
  def DeleteLevelButtonTitle_=(value: String) {
    if (_deleteLevelButtonTitle == value) return
    json("deleteLevelButtonTitle") = value
    _deleteLevelButtonTitle = value
  }

  private[this] var _descendingTitle: String = descendingTitle
  def DescendingTitle = _descendingTitle
  def DescendingTitle_=(value: String) {
    if (_descendingTitle == value) return
    json("descendingTitle") = value
    _descendingTitle = value
  }

  private[this] var _directionFieldTitle: String = directionFieldTitle
  def DirectionFieldTitle = _directionFieldTitle
  def DirectionFieldTitle_=(value: String) {
    if (_directionFieldTitle == value) return
    json("directionFieldTitle") = value
    _directionFieldTitle = value
  }

  private[this] var _fields: ArrayDyn[DataSourceFieldDyn] = fields
  def Fields = _fields
  def Fields_=(value: ArrayDyn[DataSourceFieldDyn]) {
    if (_fields == value) return
    json("fields") = value
    _fields = value
  }

  private[this] var _firstSortLevelTitle: String = firstSortLevelTitle
  def FirstSortLevelTitle = _firstSortLevelTitle
  def FirstSortLevelTitle_=(value: String) {
    if (_firstSortLevelTitle == value) return
    json("firstSortLevelTitle") = value
    _firstSortLevelTitle = value
  }

  private[this] var _initialSort: ArrayDyn[SortSpecifierDyn] = initialSort
  def InitialSort = _initialSort
  def InitialSort_=(value: ArrayDyn[SortSpecifierDyn]) {
    if (_initialSort == value) return
    json("initialSort") = value
    _initialSort = value
  }

  private[this] var _invalidListPrompt: String = invalidListPrompt
  def InvalidListPrompt = _invalidListPrompt
  def InvalidListPrompt_=(value: String) {
    if (_invalidListPrompt == value) return
    json("invalidListPrompt") = value
    _invalidListPrompt = value
  }

  private[this] var _levelDownButton: AutoChild = levelDownButton
  def LevelDownButton = _levelDownButton
  def LevelDownButton_=(value: AutoChild) {
    if (_levelDownButton == value) return
    json("levelDownButton") = value
    _levelDownButton = value
  }

  private[this] var _levelDownButtonTitle: String = levelDownButtonTitle
  def LevelDownButtonTitle = _levelDownButtonTitle
  def LevelDownButtonTitle_=(value: String) {
    if (_levelDownButtonTitle == value) return
    json("levelDownButtonTitle") = value
    _levelDownButtonTitle = value
  }

  private[this] var _levelUpButton: AutoChild = levelUpButton
  def LevelUpButton = _levelUpButton
  def LevelUpButton_=(value: AutoChild) {
    if (_levelUpButton == value) return
    json("levelUpButton") = value
    _levelUpButton = value
  }

  private[this] var _levelUpButtonTitle: String = levelUpButtonTitle
  def LevelUpButtonTitle = _levelUpButtonTitle
  def LevelUpButtonTitle_=(value: String) {
    if (_levelUpButtonTitle == value) return
    json("levelUpButtonTitle") = value
    _levelUpButtonTitle = value
  }

  private[this] var _maxLevels: Number = maxLevels
  def MaxLevels = _maxLevels
  def MaxLevels_=(value: Number) {
    if (_maxLevels == value) return
    json("maxLevels") = value
    _maxLevels = value
  }

  private[this] var _optionsGrid: AutoChild = optionsGrid
  def OptionsGrid = _optionsGrid
  def OptionsGrid_=(value: AutoChild) {
    if (_optionsGrid == value) return
    json("optionsGrid") = value
    _optionsGrid = value
  }

  private[this] var _otherSortLevelTitle: String = otherSortLevelTitle
  def OtherSortLevelTitle = _otherSortLevelTitle
  def OtherSortLevelTitle_=(value: String) {
    if (_otherSortLevelTitle == value) return
    json("otherSortLevelTitle") = value
    _otherSortLevelTitle = value
  }

  private[this] var _propertyFieldTitle: String = propertyFieldTitle
  def PropertyFieldTitle = _propertyFieldTitle
  def PropertyFieldTitle_=(value: String) {
    if (_propertyFieldTitle == value) return
    json("propertyFieldTitle") = value
    _propertyFieldTitle = value
  }

  private[this] var _sortChanged: FunctionExpression = sortChanged
  def SortChanged = _sortChanged
  def SortChanged_=(value: FunctionExpression) {
    if (_sortChanged == value) return
    json("sortChanged") = value
    _sortChanged = value
  }
}