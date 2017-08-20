
package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait TimeDisplayFormat

case object tmDspFmtNull extends TimeDisplayFormat {
  override def toString = "null"
}

case object tmDspFmtToTime extends TimeDisplayFormat {
  override def toString = "toTime"
}

case object tmDspFmtTo24HourTime extends TimeDisplayFormat {
  override def toString = "to24HourTime"
}

case object tmDspFmtToPaddedTime extends TimeDisplayFormat {
  override def toString = "toPaddedTime"
}

case object tmDspFmtToPadded24HourTime extends TimeDisplayFormat {
  override def toString = "toPadded24HourTime"
}

case object tmDspFmtToShortTime extends TimeDisplayFormat {
  override def toString = "toShortTime"
}

case object tmDspFmtToShort24HourTime extends TimeDisplayFormat {
  override def toString = "toShort24HourTime"
}

case object tmDspFmtToShortPaddedTime extends TimeDisplayFormat {
  override def toString = "toShortPaddedTime"
}

case object tmDspFmtToShortPadded24HourTime extends TimeDisplayFormat {
  override def toString = "toShortPadded24HourTime"
}

object TimeDisplayFormat {
  private val values = SealedEnumRuntime.values[TimeDisplayFormat]
  private val mappedKeys: Map[String, TimeDisplayFormat] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): TimeDisplayFormat = mappedKeys(objName)
}
  


