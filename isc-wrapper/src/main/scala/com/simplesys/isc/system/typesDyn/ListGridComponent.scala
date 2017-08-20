
package com.simplesys.isc.system.typesDyn


sealed abstract trait ListGridComponent

case object lstGrdCompNull extends ListGridComponent {
  override def toString = ""
}

case object lstGrdCompFilterEditor extends ListGridComponent {
  override def toString = "filterEditor"
}

case object lstGrdCompHeader extends ListGridComponent {
  override def toString = "header"
}

case object lstGrdCompBody extends ListGridComponent {
  override def toString = "body"
}

case object lstGrdCompSummaryRow extends ListGridComponent {
  override def toString = "summaryRow"
}

import com.simplesys.common.Strings._
import ru.simplesys.coreutil.SealedEnumRuntime

object ListGridComponent {
  private val values = SealedEnumRuntime.values[ListGridComponent]
  private val mappedKeys: Map[String, ListGridComponent] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ListGridComponent = mappedKeys(objName)
}




