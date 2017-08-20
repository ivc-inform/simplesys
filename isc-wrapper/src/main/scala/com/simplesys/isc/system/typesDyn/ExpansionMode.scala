
package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait ExpansionMode

case object expnsModeNull extends ExpansionMode {
  override def toString = "null"
}

case object expnsModeDetailField extends ExpansionMode {
  override def toString = "detailField"
}

case object expnsModeDetails extends ExpansionMode {
  override def toString = "details"
}

case object expnsModeRelated extends ExpansionMode {
  override def toString = "related"
}

case object expnsModeEditor extends ExpansionMode {
  override def toString = "editor"
}

case object expnsModeDetailRelated extends ExpansionMode {
  override def toString = "detailRelated"
}

object ExpansionMode {
  private val values = SealedEnumRuntime.values[ExpansionMode]
  private val mappedKeys: Map[String, ExpansionMode] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ExpansionMode = mappedKeys(objName)
}

