package com.simplesys.isc.dataBinging.RPC

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonList

trait ServerObjectDynInit {
  protected val attributeName: String = ""
  protected val attributeScope: AttributeScope = attrNull
  protected val bean: String = ""
  protected val className: String = ""
  protected val crudOnly: Bool = false
  protected val dropExtraFields: Bool = false
  protected val id: String = ""
  protected val lookupStyle: LookupStyle = lkstlNew
  protected val methodName: String = ""
  protected val targetXPath: XPathExpression = ""
  protected val visibleMethods: JsonList = JsonList()
}