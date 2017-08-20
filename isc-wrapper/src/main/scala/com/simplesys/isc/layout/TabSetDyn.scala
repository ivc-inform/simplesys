package com.simplesys.isc.layout

import com.simplesys.json.{JsonNull, JsonObject}
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.typesDyn._
import tabSet.TabDyn
import com.simplesys.isc.forms.formItems.TextItemDyn
import com.simplesys.isc.system.ArrayDyn

object TabSetDyn {

  implicit def TabSettoJsonObject(in: TabSetDyn): JsonObject = in json
}

class TabSetDyn(override val useSelfName: Boolean = false) extends CanvasDyn with TabSetDynInit {
  override val selfName = "TabSet"

  private[this] var _animateTabScrolling: Bool = animateTabScrolling
  def AnimateTabScrolling = _animateTabScrolling
  def AnimateTabScrolling_=(value: Bool) {
    if (_animateTabScrolling == value) return
    json("animateTabScrolling") = value
    _animateTabScrolling = value
  }

  private[this] var _bottomEdgeOffsets: EdgeSizes = bottomEdgeOffsets
  def BottomEdgeOffsets = _bottomEdgeOffsets
  def BottomEdgeOffsets_=(value: EdgeSizes) {
    if (_bottomEdgeOffsets == value) return
    json("bottomEdgeOffsets") = value
    _bottomEdgeOffsets = value
  }

  private[this] var _bottomEdgeSizes: EdgeSizes = bottomEdgeSizes
  def BottomEdgeSizes = _bottomEdgeSizes
  def BottomEdgeSizes_=(value: EdgeSizes) {
    if (_bottomEdgeSizes == value) return
    json("bottomEdgeSizes") = value
    _bottomEdgeSizes = value
  }

  private[this] var _canCloseTabs: Bool = canCloseTabs
  def CanCloseTabs = _canCloseTabs
  def CanCloseTabs_=(value: Bool) {
    if (_canCloseTabs == value) return
    json("canCloseTabs") = value
    _canCloseTabs = value
  }

  private[this] var _canEditTabTitles: Bool = canEditTabTitles
  def CanEditTabTitles = _canEditTabTitles
  def CanEditTabTitles_=(value: Bool) {
    if (_canEditTabTitles == value) return
    json("canEditTabTitles") = value
    _canEditTabTitles = value
  }

  def CloseClick = json.getFunctionExpressionOpt("closeClick").getOrElse(closeClick)
  def CloseClick_=(value: FunctionExpression) {
    if (CloseClick == value) return
    json("closeClick") = value
  }

  private[this] var _closeTabIcon: SCImgURL = closeTabIcon
  def CloseTabIcon = _closeTabIcon
  def CloseTabIcon_=(value: SCImgURL) {
    if (_closeTabIcon == value) return
    json("closeTabIcon") = value
    _closeTabIcon = value
  }

  private[this] var _closeTabIconSize: Number = closeTabIconSize
  def CloseTabIconSize = _closeTabIconSize
  def CloseTabIconSize_=(value: Number) {
    if (_closeTabIconSize == value) return
    json("closeTabIconSize") = value
    _closeTabIconSize = value
  }

  private[this] var _destroyPanes: Bool = destroyPanes
  def DestroyPanes = _destroyPanes
  def DestroyPanes_=(value: Bool) {
    if (_destroyPanes == value) return
    json("destroyPanes") = value
    _destroyPanes = value
  }

  private[this] var _leftEdgeOffsets: EdgeSizes = leftEdgeOffsets
  def LeftEdgeOffsets = _leftEdgeOffsets
  def LeftEdgeOffsets_=(value: EdgeSizes) {
    if (_leftEdgeOffsets == value) return
    json("leftEdgeOffsets") = value
    _leftEdgeOffsets = value
  }

  private[this] var _leftEdgeSizes: EdgeSizes = leftEdgeSizes
  def LeftEdgeSizes = _leftEdgeSizes
  def LeftEdgeSizes_=(value: EdgeSizes) {
    if (_leftEdgeSizes == value) return
    json("leftEdgeSizes") = value
    _leftEdgeSizes = value
  }

  private[this] var _locateTabsBy: String = locateTabsBy
  def LocateTabsBy = _locateTabsBy
  def LocateTabsBy_=(value: String) {
    if (_locateTabsBy == value) return
    json("locateTabsBy") = value
    _locateTabsBy = value
  }

  private[this] var _moreTab: AutoChild = moreTab
  def MoreTab = _moreTab
  def MoreTab_=(value: AutoChild) {
    if (_moreTab == value) return
    json("moreTab") = value
    _moreTab = value
  }

  private[this] var _moreTabCount: Number = moreTabCount
  def MoreTabCount = _moreTabCount
  def MoreTabCount_=(value: Number) {
    if (_moreTabCount == value) return
    json("moreTabCount") = value
    _moreTabCount = value
  }

  private[this] var _moreTabImage: SCImgURL = moreTabImage
  def MoreTabImage = _moreTabImage
  def MoreTabImage_=(value: SCImgURL) {
    if (_moreTabImage == value) return
    json("moreTabImage") = value
    _moreTabImage = value
  }

  private[this] var _moreTabPane: AutoChild = moreTabPane
  def MoreTabPane = _moreTabPane
  def MoreTabPane_=(value: AutoChild) {
    if (_moreTabPane == value) return
    json("moreTabPane") = value
    _moreTabPane = value
  }

  private[this] var _moreTabPaneDefaults: CanvasDyn = moreTabPaneDefaults
  def MoreTabPaneDefaults = _moreTabPaneDefaults
  def MoreTabPaneDefaults_=(value: CanvasDyn) {
    if (_moreTabPaneDefaults == value) return
    json("moreTabPaneDefaults") = value
    _moreTabPaneDefaults = value
  }

  private[this] var _moreTabPaneProperties: CanvasDyn = moreTabPaneProperties
  def MoreTabPaneProperties = _moreTabPaneProperties
  def MoreTabPaneProperties_=(value: CanvasDyn) {
    if (_moreTabPaneProperties == value) return
    json("moreTabPaneProperties") = value
    _moreTabPaneProperties = value
  }

  private[this] var _moreTabProperties: TabDyn = moreTabProperties
  def MoreTabProperties = _moreTabProperties
  def MoreTabProperties_=(value: TabDyn) {
    if (_moreTabProperties == value) return
    json("moreTabProperties") = value
    _moreTabProperties = value
  }

  private[this] var _moreTabTitle: String = moreTabTitle
  def MoreTabTitle = _moreTabTitle
  def MoreTabTitle_=(value: String) {
    if (_moreTabTitle == value) return
    json("moreTabTitle") = value
    _moreTabTitle = value
  }

  private[this] var _paneContainer: AutoChild = paneContainer
  def PaneContainer = _paneContainer
  def PaneContainer_=(value: AutoChild) {
    if (_paneContainer == value) return
    json("paneContainer") = value
    _paneContainer = value
  }

  private[this] var _paneContainerClassName: CSSStyleName = paneContainerClassName
  def PaneContainerClassName = _paneContainerClassName
  def PaneContainerClassName_=(value: CSSStyleName) {
    if (_paneContainerClassName == value) return
    json("paneContainerClassName") = value
    _paneContainerClassName = value
  }

  private[this] var _paneContainerOverflow: Overflow = paneContainerOverflow
  def PaneContainerOverflow = _paneContainerOverflow
  def PaneContainerOverflow_=(value: Overflow) {
    if (_paneContainerOverflow == value) return
    json("paneContainerOverflow") = value
    _paneContainerOverflow = value
  }

  private[this] var _paneMargin: Number = paneMargin
  def PaneMargin = _paneMargin
  def PaneMargin_=(value: Number) {
    if (_paneMargin == value) return
    json("paneMargin") = value
    _paneMargin = value
  }

  private[this] var _pickerButtonHSrc: SCImgURL = pickerButtonHSrc
  def PickerButtonHSrc = _pickerButtonHSrc
  def PickerButtonHSrc_=(value: SCImgURL) {
    if (_pickerButtonHSrc == value) return
    json("pickerButtonHSrc") = value
    _pickerButtonHSrc = value
  }

  private[this] var _pickerButtonSize: Number = pickerButtonSize
  def PickerButtonSize = _pickerButtonSize
  def PickerButtonSize_=(value: Number) {
    if (_pickerButtonSize == value) return
    json("pickerButtonSize") = value
    _pickerButtonSize = value
  }

  private[this] var _pickerButtonSrc: SCImgURL = pickerButtonSrc
  def PickerButtonSrc = _pickerButtonSrc
  def PickerButtonSrc_=(value: SCImgURL) {
    if (_pickerButtonSrc == value) return
    json("pickerButtonSrc") = value
    _pickerButtonSrc = value
  }

  private[this] var _pickerButtonVSrc: SCImgURL = pickerButtonVSrc
  def PickerButtonVSrc = _pickerButtonVSrc
  def PickerButtonVSrc_=(value: SCImgURL) {
    if (_pickerButtonVSrc == value) return
    json("pickerButtonVSrc") = value
    _pickerButtonVSrc = value
  }

  private[this] var _rightEdgeOffsets: EdgeSizes = rightEdgeOffsets
  def RightEdgeOffsets = _rightEdgeOffsets
  def RightEdgeOffsets_=(value: EdgeSizes) {
    if (_rightEdgeOffsets == value) return
    json("rightEdgeOffsets") = value
    _rightEdgeOffsets = value
  }

  private[this] var _rightEdgeSizes: EdgeSizes = rightEdgeSizes
  def RightEdgeSizes = _rightEdgeSizes
  def RightEdgeSizes_=(value: EdgeSizes) {
    if (_rightEdgeSizes == value) return
    json("rightEdgeSizes") = value
    _rightEdgeSizes = value
  }

  private[this] var _scrollerButtonSize: Number = scrollerButtonSize
  def ScrollerButtonSize = _scrollerButtonSize
  def ScrollerButtonSize_=(value: Number) {
    if (_scrollerButtonSize == value) return
    json("scrollerButtonSize") = value
    _scrollerButtonSize = value
  }

  private[this] var _scrollerHSrc: SCImgURL = scrollerHSrc
  def ScrollerHSrc = _scrollerHSrc
  def ScrollerHSrc_=(value: SCImgURL) {
    if (_scrollerHSrc == value) return
    json("scrollerHSrc") = value
    _scrollerHSrc = value
  }

  private[this] var _scrollerSrc: SCImgURL = scrollerSrc
  def ScrollerSrc = _scrollerSrc
  def ScrollerSrc_=(value: SCImgURL) {
    if (_scrollerSrc == value) return
    json("scrollerSrc") = value
    _scrollerSrc = value
  }

  private[this] var _scrollerVSrc: SCImgURL = scrollerVSrc
  def ScrollerVSrc = _scrollerVSrc
  def ScrollerVSrc_=(value: SCImgURL) {
    if (_scrollerVSrc == value) return
    json("scrollerVSrc") = value
    _scrollerVSrc = value
  }

  private[this] var _selectedTab: Number = selectedTab
  def SelectedTab = _selectedTab
  def SelectedTab_=(value: Number) {
    if (_selectedTab == value) return
    json("selectedTab") = value
    _selectedTab = value
  }

  private[this] var _showMoreTab: Bool = showMoreTab
  def ShowMoreTab = _showMoreTab
  def ShowMoreTab_=(value: Bool) {
    if (_showMoreTab == value) return
    json("showMoreTab") = value
    _showMoreTab = value
  }

  private[this] var _showPaneContainerEdges: Bool = showPaneContainerEdges
  def ShowPaneContainerEdges = _showPaneContainerEdges
  def ShowPaneContainerEdges_=(value: Bool) {
    if (_showPaneContainerEdges == value) return
    json("showPaneContainerEdges") = value
    _showPaneContainerEdges = value
  }

  private[this] var _showPartialEdges: Bool = showPartialEdges
  def ShowPartialEdges = _showPartialEdges
  def ShowPartialEdges_=(value: Bool) {
    if (_showPartialEdges == value) return
    json("showPartialEdges") = value
    _showPartialEdges = value
  }

  private[this] var _showTabPicker: Bool = showTabPicker
  def ShowTabPicker = _showTabPicker
  def ShowTabPicker_=(value: Bool) {
    if (_showTabPicker == value) return
    json("showTabPicker") = value
    _showTabPicker = value
  }

  private[this] var _showTabScroller: Bool = showTabScroller
  def ShowTabScroller = _showTabScroller
  def ShowTabScroller_=(value: Bool) {
    if (_showTabScroller == value) return
    json("showTabScroller") = value
    _showTabScroller = value
  }

  private[this] var _simpleTabBaseStyle: CSSStyleName = simpleTabBaseStyle
  def SimpleTabBaseStyle = _simpleTabBaseStyle
  def SimpleTabBaseStyle_=(value: CSSStyleName) {
    if (_simpleTabBaseStyle == value) return
    json("simpleTabBaseStyle") = value
    _simpleTabBaseStyle = value
  }

  private[this] var _simpleTabButtonConstructor: SCClassName = simpleTabButtonConstructor
  def SimpleTabButtonConstructor = _simpleTabButtonConstructor
  def SimpleTabButtonConstructor_=(value: SCClassName) {
    if (_simpleTabButtonConstructor == value) return
    json("simpleTabButtonConstructor") = value
    _simpleTabButtonConstructor = value
  }

  private[this] var _symmetricEdges: Bool = symmetricEdges
  def SymmetricEdges = _symmetricEdges
  def SymmetricEdges_=(value: Bool) {
    if (_symmetricEdges == value) return
    json("symmetricEdges") = value
    _symmetricEdges = value
  }

  private[this] var _symmetricPickerButton: Bool = symmetricPickerButton
  def SymmetricPickerButton = _symmetricPickerButton
  def SymmetricPickerButton_=(value: Bool) {
    if (_symmetricPickerButton == value) return
    json("symmetricPickerButton") = value
    _symmetricPickerButton = value
  }

  private[this] var _symmetricScroller: Bool = symmetricScroller
  def SymmetricScroller = _symmetricScroller
  def SymmetricScroller_=(value: Bool) {
    if (_symmetricScroller == value) return
    json("symmetricScroller") = value
    _symmetricScroller = value
  }

  private[this] var _tabBar: AutoChild = tabBar
  def TabBar = _tabBar
  def TabBar_=(value: AutoChild) {
    if (_tabBar == value) return
    json("tabBar") = value
    _tabBar = value
  }

  private[this] var _tabBarAlign: Side = tabBarAlign
  def TabBarAlign = _tabBarAlign
  def TabBarAlign_=(value: Side) {
    if (_tabBarAlign == value) return
    json("tabBarAlign") = value
    _tabBarAlign = value
  }

  private[this] var _tabBarControlLayout: AutoChild = tabBarControlLayout
  def TabBarControlLayout = _tabBarControlLayout
  def TabBarControlLayout_=(value: AutoChild) {
    if (_tabBarControlLayout == value) return
    json("tabBarControlLayout") = value
    _tabBarControlLayout = value
  }

  private[this] var _tabBarControls: ArrayDyn[ClassDyn] = tabBarControls
  def TabBarControls = _tabBarControls
  def TabBarControls_=(value: ArrayDyn[ClassDyn]) {
    if (_tabBarControls == value) return
    json("tabBarControls") = value
    _tabBarControls = value
  }

  private[this] var _tabBarPosition: Side = tabBarPosition
  def TabBarPosition = _tabBarPosition
  def TabBarPosition_=(value: Side) {
    if (_tabBarPosition == value) return
    json("tabBarPosition") = value
    _tabBarPosition = value
  }

  private[this] var _tabBarThickness: Number = tabBarThickness
  def TabBarThickness = _tabBarThickness
  def TabBarThickness_=(value: Number) {
    if (_tabBarThickness == value) return
    json("tabBarThickness") = value
    _tabBarThickness = value
  }

  private[this] var _tabProperties: TabDyn = tabProperties
  def TabProperties = _tabProperties
  def TabProperties_=(value: TabDyn) {
    if (_tabProperties == value) return
    json("tabProperties") = value
    _tabProperties = value
  }

  private[this] var _tabs: ArrayDyn[TabDyn] = tabs
  def Tabs = _tabs
  def Tabs_=(value: ArrayDyn[TabDyn]) {
    if (_tabs == value) return
    json("tabs") = value
    _tabs = value
  }

  private[this] var _titleEditEvent: TabTitleEditEvent = titleEditEvent
  def TitleEditEvent = _titleEditEvent
  def TitleEditEvent_=(value: TabTitleEditEvent) {
    if (_titleEditEvent == value) return
    json("titleEditEvent") = value
    _titleEditEvent = value
  }

  private[this] var _titleEditor: AutoChild = titleEditor
  def TitleEditor = _titleEditor
  def TitleEditor_=(value: AutoChild) {
    if (_titleEditor == value) return
    json("titleEditor") = value
    _titleEditor = value
  }

  private[this] var _titleEditorLeftOffset: Number = titleEditorLeftOffset
  def TitleEditorLeftOffset = _titleEditorLeftOffset
  def TitleEditorLeftOffset_=(value: Number) {
    if (_titleEditorLeftOffset == value) return
    json("titleEditorLeftOffset") = value
    _titleEditorLeftOffset = value
  }

  private[this] var _titleEditorProperties: TextItemDyn = titleEditorProperties
  def TitleEditorProperties = _titleEditorProperties
  def TitleEditorProperties_=(value: TextItemDyn) {
    if (_titleEditorProperties == value) return
    json("titleEditorProperties") = value
    _titleEditorProperties = value
  }

  private[this] var _titleEditorRightOffset: Number = titleEditorRightOffset
  def TitleEditorRightOffset = _titleEditorRightOffset
  def TitleEditorRightOffset_=(value: Number) {
    if (_titleEditorRightOffset == value) return
    json("titleEditorRightOffset") = value
    _titleEditorRightOffset = value
  }

  private[this] var _titleEditorTopOffset: Number = titleEditorTopOffset
  def TitleEditorTopOffset = _titleEditorTopOffset
  def TitleEditorTopOffset_=(value: Number) {
    if (_titleEditorTopOffset == value) return
    json("titleEditorTopOffset") = value
    _titleEditorTopOffset = value
  }

  private[this] var _topEdgeOffsets: EdgeSizes = topEdgeOffsets
  def TopEdgeOffsets = _topEdgeOffsets
  def TopEdgeOffsets_=(value: EdgeSizes) {
    if (_topEdgeOffsets == value) return
    json("topEdgeOffsets") = value
    _topEdgeOffsets = value
  }

  private[this] var _topEdgeSizes: EdgeSizes = topEdgeSizes
  def TopEdgeSizes = _topEdgeSizes
  def TopEdgeSizes_=(value: EdgeSizes) {
    if (_topEdgeSizes == value) return
    json("topEdgeSizes") = value
    _topEdgeSizes = value
  }

  private[this] var _useSimpleTabs: Bool = useSimpleTabs
  def UseSimpleTabs = _useSimpleTabs
  def UseSimpleTabs_=(value: Bool) {
    if (_useSimpleTabs == value) return
    json("useSimpleTabs") = value
    _useSimpleTabs = value
  }
}