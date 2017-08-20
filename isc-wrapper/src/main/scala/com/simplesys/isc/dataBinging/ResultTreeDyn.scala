package com.simplesys.isc.dataBinging

import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.isc.system.TreeDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc.Bool

object ResultTreeDyn {
  implicit def ResultTree1toJsonObject(in: ResultTreeDyn): JsonObject = in json
}

class ResultTreeDyn(override val inJson: JsonObject = null) extends TreeDyn with DataBoundComponentDyn with ResultTreeDynInit {
  override val selfName = "ResultTree"

  private[this] var _defaultNewNodesToRoot: Bool = defaultNewNodesToRoot
  def DefaultNewNodesToRoot = _defaultNewNodesToRoot
  def DefaultNewNodesToRoot_=(value: Bool) {
    if (_defaultNewNodesToRoot == value) return
    json("defaultNewNodesToRoot") = value
    _defaultNewNodesToRoot = value
  }

  private[this] var _disableCacheSync: Bool = disableCacheSync
  def DisableCacheSync = _disableCacheSync
  def DisableCacheSync_=(value: Bool) {
    if (_disableCacheSync == value) return
    json("disableCacheSync") = value
    _disableCacheSync = value
  }

  private[this] var _fetchMode: FetchMode = fetchMode
  def FetchMode = _fetchMode
  def FetchMode_=(value: FetchMode) {
    if (_fetchMode == value) return
    json("fetchMode") = value
    _fetchMode = value
  }

  private[this] var _keepParentsOnFilter: Bool = keepParentsOnFilter
  def KeepParentsOnFilter = _keepParentsOnFilter
  def KeepParentsOnFilter_=(value: Bool) {
    if (_keepParentsOnFilter == value) return
    json("keepParentsOnFilter") = value
    _keepParentsOnFilter = value
  }

  private[this] var _loadDataOnDemand: Bool = loadDataOnDemand
  def LoadDataOnDemand = _loadDataOnDemand
  def LoadDataOnDemand_=(value: Bool) {
    if (_loadDataOnDemand == value) return
    json("loadDataOnDemand") = value
    _loadDataOnDemand = value
  }

  private[this] var _rootNode: JsonObject = rootNode
  def RootNode = _rootNode
  def RootNode_=(value: JsonObject) {
    json("rootNode") = value
    _rootNode = value
  }

  private[this] var _serverFilterFields: JsonList = serverFilterFields
  def ServerFilterFields = _serverFilterFields
  def ServerFilterFields_=(value: JsonList) {
    if (_serverFilterFields == value) return
    json("serverFilterFields") = value
    _serverFilterFields = value
  }

  private[this] var _updateCacheFromRequest: Bool = updateCacheFromRequest
  def UpdateCacheFromRequest = _updateCacheFromRequest
  def UpdateCacheFromRequest_=(value: Bool) {
    if (_updateCacheFromRequest == value) return
    json("updateCacheFromRequest") = value
    _updateCacheFromRequest = value
  }
}
