package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait DSProtocol

case object dsprtNull extends DSProtocol {
  override def toString = ""
}

case object dsprtGetParams extends DSProtocol {
  override def toString = "getParams"
}

case object dsprtPostParams extends DSProtocol {
  override def toString = "postParams"
}

case object dsprtPostXML extends DSProtocol {
  override def toString = "postXML"
}

case object dsprtSoap extends DSProtocol {
  override def toString = "soap"
}

case object dsprtPostMessage extends DSProtocol {
  override def toString = "postMessage"
}

case object dsprtClientCustom extends DSProtocol {
  override def toString = "clientCustom"
}

object DSProtocol {
  private val values = SealedEnumRuntime.values[DSProtocol]
  private val mappedKeys: Map[String, DSProtocol] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): DSProtocol = mappedKeys(objName)
  def getObjectOpt(objName: String): Option[DSProtocol] = mappedKeys get objName
}


