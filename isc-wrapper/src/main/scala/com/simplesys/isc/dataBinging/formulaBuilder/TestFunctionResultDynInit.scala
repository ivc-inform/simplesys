package com.simplesys.isc.dataBinging.formulaBuilder

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDynInit
import com.simplesys.isc.dataBinging.dataSource.RecordDyn

trait TestFunctionResultDynInit extends ClassDynInit {
  protected val emptyTestValue: Bool = false
  protected val errorText: String = ""
  protected val failedExecution: Bool = false
  protected val failedGeneration: Bool = false
  protected val record: RecordDyn = null
  protected val result: String = ""
}