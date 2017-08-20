package com.simplesys.isc.grids.detailViewer

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonObject

trait DetailViewerFieldDynInit {
  protected val canExport: Bool = false
  protected val cellStyle: CSSStyleName = ""
  protected val dataPath: XPathExpression = ""
  protected val dateFormatter: DateDisplayFormat = ddfNull
  protected val escapeHTML: HTMLString = ""
  protected val height: Number = null
  protected val imageHeight: Number = null
  protected val imageSize: Number = null
  protected val imageURLPrefix: String = ""
  protected val imageWidth: Number = null
  protected val includeFrom: String = ""
  protected val name: String = ""
  protected val printCellStyle: String = ""
  protected val showFileInline: Bool = false
  protected val timeFormatter: TimeDisplayFormat = tmDspFmtNull
  protected val title: HTMLString = ""
  protected val fieldType: String = ""
  protected val value: HTMLString = "undefined"
  protected val valueMap: JsonObject = JsonObject()
}