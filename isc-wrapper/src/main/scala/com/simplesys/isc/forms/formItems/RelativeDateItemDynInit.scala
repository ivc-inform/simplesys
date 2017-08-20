package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json._
import formItem.FormItemIconDyn
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc.Date
import com.simplesys.isc.system.misc.SCClassName
import com.simplesys.isc.system.misc.Bool
import com.simplesys.json.JsonString
import com.simplesys.isc.system.misc.Number
import DateDisplayFormat._

trait RelativeDateItemDynInit extends CanvasItemDynInit {
  protected val baseDate: Date = ""
  protected val calculatedDateField: BlurbItemDyn = null
  protected val centuryThreshold: Number = 25
  override protected val dateFormatter: DateDisplayFormat = ddfNull
  protected val daysAgoTitle: String = "N days ago"
  protected val daysFromNowTitle: String = "N days from now"
  protected val defaultQuantity: Number = 1
  override protected val defaultValue: JsonElement = JsonString("$today")
  protected val endDate: Date = "12/31/2015"
  protected val hoursAgoTitle: String = "N hours ago"
  protected val hoursFromNowTitle: String = "N hours from now"
  override protected val inputFormat: DateInputFormat = ""
  protected val millisecondsAgoTitle: String = "N milliseconds ago"
  protected val millisecondsFromNowTitle: String = "N milliseconds from now"
  protected val minutesAgoTitle: String = "N minutes ago"
  protected val minutesFromNowTitle: String = "N minutes from now"
  protected val monthsAgoTitle: String = "N months ago"
  protected val monthsFromNowTitle: String = "N months from now"
  override protected val operator: OperatorId = opIdGreaterThan
  override protected val pickerConstructor: SCClassName = "DateChooser"
  protected val pickerIcon: FormItemIconDyn = null
  override protected val pickerIconPrompt: String = "Show Date Chooser"
  protected val presetOptions: JsonObject = JsonObject()
  protected val quantityField: SpinnerItemDyn = null
  protected val rangePosition: RelativeDateRangePosition = rlDtRngPosNull
  protected val rangeRoundingGranularity: JsonObject = JsonObject()
  protected val secondsAgoTitle: String = "N seconds ago"
  protected val secondsFromNowTitle: String = "N seconds from now"
  protected val showCalculatedDateField: Bool = true
  protected val showChooserIcon: Bool = true
  protected val showFutureOptions: Bool = true
  protected val showPastOptions: Bool = true
  protected val startDate: Date = "1/1/1995"
  protected val timeUnitOptions: JsonList = null
  protected val useSharedPicker: Bool = true
  protected val weeksAgoTitle: String = "N weeks ago"
  protected val weeksFromNowTitle: String = "N weeks from now"
  protected val yearsAgoTitle: String = "N years ago"
}