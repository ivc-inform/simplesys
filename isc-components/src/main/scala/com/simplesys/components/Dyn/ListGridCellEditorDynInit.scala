package com.simplesys.components.Dyn

import com.simplesys.json.{JsonElement, JsonNull}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.layout.HLayoutDynInit
import com.simplesys.isc.system.ClassDyn

trait ListGridCellEditorDynInit extends HLayoutDynInit {
  override protected val width: Number = "100".%
  override protected val height: Number = "100".%
  override protected val autoDraw: Bool = false
  private[Dyn] val title: String = "Группы".ellps
  private[Dyn] val cancelButtonClick: FunctionExpression = null
  private[Dyn] val okButtonClick: FunctionExpression = null
  private[Dyn] val visibilityFuncButton: Visibility = vsVisible
  private[Dyn] val editor: ClassDyn = null
  private[Dyn] val imgPath: SCImgURL = ""
  private[Dyn] val keyValue: JsonElement = JsonNull
}   