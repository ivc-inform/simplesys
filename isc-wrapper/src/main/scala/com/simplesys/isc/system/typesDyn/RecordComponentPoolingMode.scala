

package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait RecordComponentPoolingMode

case object rcCmpPlMdViewport extends RecordComponentPoolingMode {
  override def toString = "viewport"
}

case object rcCmpPlMdData extends RecordComponentPoolingMode {
  override def toString = "data"
}

case object rcCmpPlMdRecycle extends RecordComponentPoolingMode {
  override def toString = "recycle"
}

object RecordComponentPoolingMode {
  private val values = SealedEnumRuntime.values[RecordComponentPoolingMode]
  private val mappedKeys: Map[String, RecordComponentPoolingMode] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): RecordComponentPoolingMode = mappedKeys(objName)
}
