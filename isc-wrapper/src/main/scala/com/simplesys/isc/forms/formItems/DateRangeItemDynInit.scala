package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool
import com.simplesys.json.{JsonElement, JsonNull}

trait DateRangeItemDynInit extends CanvasItemDynInit {
  protected val allowRelativeDates: Bool = false
  protected val dateDisplayFormat: DateDisplayFormat = ddfNull
  protected val dateInputFormat: DateInputFormat = ""
  protected val dateRangeForm: AutoChild = null
  protected val fromDate: JsonElement = JsonNull
  protected val fromField: FormItemDyn = null
  protected val fromTitle: String = "From"
  protected val innerTitleOrientation: TitleOrientation = ttlOrntNull
  override protected val shouldSaveValue: Bool = true
  protected val toDate: JsonElement = "$today"
  protected val toField: FormItemDyn = null
  protected val toTitle: String = "To"
}