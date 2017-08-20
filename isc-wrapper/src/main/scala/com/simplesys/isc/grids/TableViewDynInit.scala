package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait TableViewDynInit extends ListGridDynInit {
  override protected val dataField: String = "data"
  override protected val descriptionField: String = "description"
  override protected val iconField: String = "icon"
  override protected val infoField: String = "info"
  protected val navIcon: SCImgURL = "[SKINIMG]/iOS/listArrow_button.png"
  protected val navigationMode: NavigationMode = nvMdWholeRecord
  protected val recordDataStyle: CSSStyleName = "recordData"
  protected val recordDescriptionStyle: CSSStyleName = "recordDescription"
  protected val recordInfoStyle: CSSStyleName = "recordInfo"
  protected val recordLayout: RecordLayout = rcLytTitleOnly
  protected val recordNavigationProperty: String = "_navigate"
  protected val recordTitleStyle: SCClassName = "recordTitle"
  protected val showIconField: Bool = true
  protected val showNavigation: Bool = false
  protected val tableMode: TableMode = tblMdPlane
  override protected val titleField: String = "title"
  protected val wholeRecordNavIcon: SCImgURL = "[SKINIMG]/iOS/listArrow.png"
}