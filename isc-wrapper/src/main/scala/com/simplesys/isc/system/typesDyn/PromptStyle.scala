

package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime
import com.simplesys.common.Strings._

sealed abstract trait PromptStyle

case object psDialog extends PromptStyle {
  override def toString = "dialog"
}

case object psCursor extends PromptStyle {
  override def toString = "cursor"
}

object PromptStyle {
  private val values = SealedEnumRuntime.values[PromptStyle]
  private val mappedKeys: Map[String, PromptStyle] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): PromptStyle = mappedKeys(objName)
}

