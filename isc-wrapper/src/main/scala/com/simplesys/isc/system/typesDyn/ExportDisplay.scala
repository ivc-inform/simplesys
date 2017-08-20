package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait ExportDisplay

case object expDispDownload extends ExportDisplay {
  override def toString = "download"
}

case object expDispWindow extends ExportDisplay {
  override def toString = "window"
}

object ExportDisplay {
  private val values = SealedEnumRuntime.values[ExportDisplay]
  private val mappedKeys: Map[String, ExportDisplay] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ExportDisplay = mappedKeys(objName)
}



