package com.simplesys.isc.dataBinging

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.grids.RecordsDynList
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

object ResultSetDyn {
  implicit def ResultSet1toJsonObject(in: ResultSetDyn): JsonObject = in json
}

class ResultSetDyn(override val inJson: JsonObject = null) extends ClassDyn with DataBoundComponentDyn with ResultSetDynInit {

  override val selfName = "ResultSet"

  private[this] var _allRows: RecordsDynList = allRows
  def AllRows = _allRows
  def AllRows_=(value: RecordsDynList) {
    if (_allRows == value) return
    json("allRows") = value
    _allRows = value
  }

  private[this] var _criteria: JsonObject = criteria
  def Criteria = _criteria
  def Criteria_=(value: JsonObject) {
    json("criteria") = value
    _criteria = value
  }

  private[this] var _criteriaPolicy: CriteriaPolicy = criteriaPolicy
  def CriteriaPolicy = _criteriaPolicy
  def CriteriaPolicy_=(value: CriteriaPolicy) {
    if (_criteriaPolicy == value) return
    json("criteriaPolicy") = value
    _criteriaPolicy = value
  }

  private[this] var _disableCacheSync: Bool = disableCacheSync
  def DisableCacheSync = _disableCacheSync
  def DisableCacheSync_=(value: Bool) {
    if (_disableCacheSync == value) return
    json("disableCacheSync") = value
    _disableCacheSync = value
  }

  private[this] var _dropCacheOnUpdate: Bool = dropCacheOnUpdate
  def DropCacheOnUpdate = _dropCacheOnUpdate
  def DropCacheOnUpdate_=(value: Bool) {
    if (_dropCacheOnUpdate == value) return
    json("dropCacheOnUpdate") = value
    _dropCacheOnUpdate = value
  }

  private[this] var _fetchDelay: Int = fetchDelay
  def FetchDelay = _fetchDelay
  def FetchDelay_=(value: Int) {
    if (_fetchDelay == value) return
    json("fetchDelay") = value
    _fetchDelay = value
  }

  private[this] var _fetchMode: FetchMode = fetchMode
  def FetchMode = _fetchMode
  def FetchMode_=(value: FetchMode) {
    if (_fetchMode == value) return
    json("fetchMode") = value
    _fetchMode = value
  }

  private[this] var _initialData: RecordsDynList = initialData
  def InitialData = _initialData
  def InitialData_=(value: RecordsDynList) {
    if (_initialData == value) return
    json("initialData") = value
    _initialData = value
  }

  private[this] var _initialLength: Int = initialLength
  def InitialLength = _initialLength
  def InitialLength_=(value: Int) {
    if (_initialLength == value) return
    json("initialLength") = value
    _initialLength = value
  }

  private[this] var _neverDropUpdatedRows: Bool = neverDropUpdatedRows
  def NeverDropUpdatedRows = _neverDropUpdatedRows
  def NeverDropUpdatedRows_=(value: Bool) {
    if (_neverDropUpdatedRows == value) return
    json("neverDropUpdatedRows") = value
    _neverDropUpdatedRows = value
  }

  private[this] var _resultSize: Int = resultSize
  def ResultSize = _resultSize
  def ResultSize_=(value: Int) {
    if (_resultSize == value) return
    json("resultSize") = value
    _resultSize = value
  }

  private[this] var _updateCacheFromRequest: Bool = updateCacheFromRequest
  def UpdateCacheFromRequest = _updateCacheFromRequest
  def UpdateCacheFromRequest_=(value: Bool) {
    if (_updateCacheFromRequest == value) return
    json("updateCacheFromRequest") = value
    _updateCacheFromRequest = value
  }

  private[this] var _updatePartialCache: Bool = updatePartialCache
  def UpdatePartialCache = _updatePartialCache
  def UpdatePartialCache_=(value: Bool) {
    if (_updatePartialCache == value) return
    json("updatePartialCache") = value
    _updatePartialCache = value
  }

  private[this] var _useClientFiltering: Bool = useClientFiltering
  def UseClientFiltering = _useClientFiltering
  def UseClientFiltering_=(value: Bool) {
    if (_useClientFiltering == value) return
    json("useClientFiltering") = value
    _useClientFiltering = value
  }

  private[this] var _useClientSorting: Bool = useClientSorting
  def UseClientSorting = _useClientSorting
  def UseClientSorting_=(value: Bool) {
    if (_useClientSorting == value) return
    json("useClientSorting") = value
    _useClientSorting = value
  }

  private[this] var _sortSpecifiers: ArrayDyn[SortSpecifierDyn] = sortSpecifiers
  def SortSpecifiers = _sortSpecifiers
  def SortSpecifiers_=(value: ArrayDyn[SortSpecifierDyn]) {
    if (_sortSpecifiers == value) return
    json("sortSpecifiers") = value
    _sortSpecifiers = value
  }
}

