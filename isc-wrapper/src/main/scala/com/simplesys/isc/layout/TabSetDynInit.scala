package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.{CanvasDyn, CanvasDynInit}
import tabSet.TabDyn
import com.simplesys.isc.forms.formItems.TextItemDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.json.UnquotedString

trait TabSetDynInit extends CanvasDynInit {
  protected val animateTabScrolling: Bool = true
  protected val bottomEdgeOffsets: EdgeSizes = null
  protected val bottomEdgeSizes: EdgeSizes = null
  protected val canCloseTabs: Bool = null
  protected val canEditTabTitles: Bool = false
  private[layout] val closeClick: FunctionExpression = null
  protected val closeTabIcon: SCImgURL = "[SKIN]/TabSet/close.png"
  protected val closeTabIconSize: Number = 16
  protected val destroyPanes: Bool = null
  protected val leftEdgeOffsets: EdgeSizes = null
  protected val leftEdgeSizes: EdgeSizes = null
  protected val locateTabsBy: String = ""
  protected val moreTab: AutoChild = null
  protected val moreTabCount: Number = 5
  protected val moreTabImage: SCImgURL = "[SKINIMG]/iOS/more.png"
  protected val moreTabPane: AutoChild = null
  protected val moreTabPaneDefaults: CanvasDyn = null
  protected val moreTabPaneProperties: CanvasDyn = null
  protected val moreTabProperties: TabDyn = null
  protected val moreTabTitle: String = "More"
  protected val paneContainer: AutoChild = null
  protected val paneContainerClassName: CSSStyleName = ""
  protected val paneContainerOverflow: Overflow = ovAuto
  protected val paneMargin: Number = 0
  protected val pickerButtonHSrc: SCImgURL = "[SKIN]hpicker.gif"
  protected val pickerButtonSize: Number = 16
  protected val pickerButtonSrc: SCImgURL = "[SKIN]/picker.gif"
  protected val pickerButtonVSrc: SCImgURL = "[SKIN]vpicker.gif"
  protected val rightEdgeOffsets: EdgeSizes = null
  protected val rightEdgeSizes: EdgeSizes = null
  protected val scrollerButtonSize: Number = 16
  protected val scrollerHSrc: SCImgURL = "[SKIN]hscroll.gif"
  protected val scrollerSrc: SCImgURL = "[SKIN]/scroll.gif"
  protected val scrollerVSrc: SCImgURL = "[SKIN]vscroll.gif"
  protected val selectedTab: Number = 0
  protected val showMoreTab: Bool = null
  protected val showPaneContainerEdges: Bool = null
  protected val showPartialEdges: Bool = false
  protected val showTabPicker: Bool = true
  protected val showTabScroller: Bool = true
  protected val simpleTabBaseStyle: CSSStyleName = "tabButton"
  protected val simpleTabButtonConstructor: SCClassName = "SimpleTabButton"
  override protected val skinImgDir: URL = "images/TabSet/".url
  protected val symmetricEdges: Bool = true
  protected val symmetricPickerButton: Bool = true
  protected val symmetricScroller: Bool = true
  protected val tabBar: AutoChild = null
  protected val tabBarAlign: Side = sdNull
  protected val tabBarControlLayout: AutoChild = null
  protected val tabBarControls: ArrayDyn[ClassDyn] = null
  protected val tabBarPosition: Side = sdTop
  protected val tabBarThickness: Number = 21
  protected val tabProperties: TabDyn = null
  protected val tabs: ArrayDyn[TabDyn] = null
  protected val titleEditEvent: TabTitleEditEvent = tbttlEdEvtNull
  protected val titleEditor: AutoChild = null
  protected val titleEditorLeftOffset: Number = null
  protected val titleEditorProperties: TextItemDyn = null
  protected val titleEditorRightOffset: Number = null
  protected val titleEditorTopOffset: Number = null
  protected val topEdgeOffsets: EdgeSizes = null
  protected val topEdgeSizes: EdgeSizes = null
  protected val useSimpleTabs: Bool = false
}