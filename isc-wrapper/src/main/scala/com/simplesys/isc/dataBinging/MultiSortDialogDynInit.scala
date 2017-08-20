package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.layout.WindowDynInit
import com.simplesys.isc.system.ArrayDyn

trait MultiSortDialogDynInit extends WindowDynInit {
  protected val addLevelButton: AutoChild = null
  protected val addLevelButtonTitle: String = "Add Level"
  protected val applyButton: AutoChild = null
  protected val applyButtonTitle: String = "Apply"
  protected val cancelButton: AutoChild = null
  protected val cancelButtonTitle: String = "Cancel"
  protected val copyLevelButton: AutoChild = null
  protected val copyLevelButtonTitle: String = "Copy Level"
  protected val deleteLevelButton: AutoChild = null
  protected val deleteLevelButtonTitle: String = "Delete Level"
  protected val descendingTitle: String = "Descending"
  protected val directionFieldTitle: String = "Order"
  protected val fields: ArrayDyn[DataSourceFieldDyn] = null
  protected val firstSortLevelTitle: String = "Sort by"
  protected val initialSort: ArrayDyn[SortSpecifierDyn] = null
  protected val invalidListPrompt: String = "Columns may only be used once: '${title}' is used multiple times."
  protected val levelDownButton: AutoChild = null
  protected val levelDownButtonTitle: String = "Move Level Down"
  protected val levelUpButton: AutoChild = null
  protected val levelUpButtonTitle: String = "Move Level Up"
  protected val maxLevels: Number = null
  protected val optionsGrid: AutoChild = null
  protected val otherSortLevelTitle: String = "Then by"
  protected val propertyFieldTitle: String = "Column"
}