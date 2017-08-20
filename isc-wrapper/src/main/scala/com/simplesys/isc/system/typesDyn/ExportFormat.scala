package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait ExportFormat

case object noneFmt extends ExportFormat {
  override def toString = ""
}

case object expFmtXml extends ExportFormat {
  override def toString = "xml"
}

case object expFmtJson extends ExportFormat {
  override def toString = "json"
}

case object expFmtCsv extends ExportFormat {
  override def toString = "csv"
}

case object expFmtXls extends ExportFormat {
  override def toString = "xls"
}

case object expFmtOoxml extends ExportFormat {
  override def toString = "ooxml"
}

object ExportFormat {
  private val values = SealedEnumRuntime.values[ExportFormat]
  private val mappedKeys: Map[String, ExportFormat] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ExportFormat = mappedKeys(objName)
}
  


