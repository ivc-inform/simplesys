package com.simplesys.isc.dataBinging.formulaBuilder

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.dataBinging.dataSource.RecordDyn

object TestFunctionResultDyn {
  implicit def TestFunctionResult2JsonObject(in: TestFunctionResultDyn): JsonObject = in json
}

class TestFunctionResultDyn(override val useSelfName: Boolean = false) extends ClassDyn with TestFunctionResultDynInit {
  override val selfName = "TestFunctionResult"

  private[this] var _emptyTestValue: Bool = emptyTestValue
  def EmptyTestValue = _emptyTestValue
  def EmptyTestValue_=(value: Bool) {
    if (_emptyTestValue == value) return
    json("emptyTestValue") = value
    _emptyTestValue = value
  }

  private[this] var _errorText: String = errorText
  def ErrorText = _errorText
  def ErrorText_=(value: String) {
    if (_errorText == value) return
    json("errorText") = value
    _errorText = value
  }

  private[this] var _failedExecution: Bool = failedExecution
  def FailedExecution = _failedExecution
  def FailedExecution_=(value: Bool) {
    if (_failedExecution == value) return
    json("failedExecution") = value
    _failedExecution = value
  }

  private[this] var _failedGeneration: Bool = failedGeneration
  def FailedGeneration = _failedGeneration
  def FailedGeneration_=(value: Bool) {
    if (_failedGeneration == value) return
    json("failedGeneration") = value
    _failedGeneration = value
  }

  private[this] var _record: RecordDyn = record
  def Record = _record
  def Record_=(value: RecordDyn) {
    if (_record == value) return
    json("record") = value
    _record = value
  }

  private[this] var _result: String = result
  def Result = _result
  def Result_=(value: String) {
    if (_result == value) return
    json("result") = value
    _result = value
  }
}