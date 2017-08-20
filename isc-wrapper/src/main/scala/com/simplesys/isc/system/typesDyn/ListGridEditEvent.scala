package com.simplesys.isc.system.typesDyn


sealed abstract trait ListGridEditEvent

case object lstGrdEvntClick extends ListGridEditEvent {
  override def toString = "click"
}

case object lstGrdEvntDoubleClick extends ListGridEditEvent {
  override def toString = "doubleClick"
}

case object lstGrdEvntNone extends ListGridEditEvent {
  override def toString = "none"
}

import ru.simplesys.coreutil.SealedEnumRuntime

object ListGridEditEvent {
  private val values = SealedEnumRuntime.values[ListGridEditEvent]
  private val mappedKeys: Map[String, ListGridEditEvent] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): ListGridEditEvent = mappedKeys(objName)
}



