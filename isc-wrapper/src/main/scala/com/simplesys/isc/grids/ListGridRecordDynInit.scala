package com.simplesys.isc.grids

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.dataBinging.DataSourceDyn
import com.simplesys.isc.foundation.CanvasDyn

trait ListGridRecordDynInit extends {
  private[grids] val baseStyle: CSSStyleName = ""
  private[grids] val backgroundComponent: CanvasDyn = null
  private[grids] val canAcceptDrop: Bool = null
  private[grids] val canDrag: Bool = null
  private[grids] val canEdit: Bool = null
  private[grids] val canExpand: Bool = null
  private[grids] val canSelect: Bool = null
  private[grids] val canRemove: Bool = null
  private[grids] val customStyle: CSSStyleName = ""
  private[grids] val detailDS: DataSourceDyn = null
  protected val enabled: Bool = false
  private[grids] val includeInSummary: Bool = false
  private[grids] val isGridSummary: Bool = false
  private[grids] val isGroupSummary: Bool = false
  protected val isSeparator: Bool = false
  private[grids] val linkText: String = ""
  private[grids] val singleCellValue: HTMLString = ""
}