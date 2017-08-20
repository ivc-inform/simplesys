package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.TreeDynInit
import com.simplesys.json.{JsonObject, JsonList}
import com.simplesys.isc.system.misc.Bool

trait ResultTreeDynInit extends TreeDynInit with DataBoundComponentDynInit {
  override protected val defaultIsFolder: Bool = false
  protected val defaultNewNodesToRoot: Bool = false
  protected val disableCacheSync: Bool = false
  override protected val discardParentlessNodes: Bool = false
  protected val fetchMode: FetchMode = ftchMdBasic
  protected val keepParentsOnFilter: Bool = false
  protected val loadDataOnDemand: Bool = true
  protected val rootNode: JsonObject = JsonObject()
  protected val serverFilterFields: JsonList = JsonList()
  protected val updateCacheFromRequest: Bool = true
}