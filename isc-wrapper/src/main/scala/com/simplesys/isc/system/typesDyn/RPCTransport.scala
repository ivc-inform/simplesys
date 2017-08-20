
package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait RPCTransport

case object rpctransportXmlHttpRequest extends RPCTransport {
  override def toString = "xmlHttpRequest"
}

case object rpctransportScriptInclude extends RPCTransport {
  override def toString = "scriptInclude"
}

case object rpctransportHiddenFrame extends RPCTransport {
  override def toString = "hiddenFrame"
}

object RPCTransport {
  private val values = SealedEnumRuntime.values[RPCTransport]
  private val mappedKeys: Map[String, RPCTransport] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): RPCTransport = mappedKeys(objName)
}
  
