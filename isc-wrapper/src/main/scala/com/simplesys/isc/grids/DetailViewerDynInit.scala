package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import detailViewer.{DetailViewerRecordDyn, DetailViewerFieldDyn}
import com.simplesys.isc.foundation.CanvasDynInit
import com.simplesys.isc.system.ArrayDyn

trait DetailViewerDynInit extends CanvasDynInit {
  protected val blockSeparator: HTMLString = "<br/><br/>"
  protected val blockStyle: CSSStyleName = "detailBlock"
  protected val cellStyle: CSSStyleName = "detail"
  protected val data: ArrayDyn[DetailViewerRecordDyn] = null
  protected val dataFetchMode: FetchMode = ftchMdBasic
  protected val dateFormatter: DateDisplayFormat = ddfNull
  protected val datetimeFormatter: DateDisplayFormat = ddfNull
  protected val emptyCellValue: HTMLString = " "
  protected val emptyMessage: HTMLString = "No items to display."
  protected val emptyMessageStyle: CSSStyleName = "normal"
  protected val fieldIdProperty: String = "name"
  protected val fields: ArrayDyn[DetailViewerFieldDyn] = null
  protected val headerStyle: CSSStyleName = "detailHeader"
  protected val labelPrefix: HTMLString = ""
  protected val labelStyle: CSSStyleName = "detailLabel"
  protected val labelSuffix: HTMLString = ":"
  protected val loadingMessage: HTMLString = "&nbsp;${loadingImage}"
  protected val loadingMessageStyle: CSSStyleName = "normal"
  protected val printCellStyle: CSSStyleName = ""
  protected val printHeaderStyle: CSSStyleName = ""
  protected val printLabelStyle: CSSStyleName = ""
  protected val recordsPerBlock: Number = 1
  protected val separatorStyle: CSSStyleName = "detail"
  protected val showDetailFields: Bool = true
  protected val showEmptyField: Bool = true
  protected val showEmptyMessage: Bool = true
  override protected val styleName: CSSStyleName = "detailViewer"
  protected val timeFormatter: TimeDisplayFormat = tmDspFmtNull
  protected val wrapLabel: Bool = false
  protected val wrapValues: Bool = true
}