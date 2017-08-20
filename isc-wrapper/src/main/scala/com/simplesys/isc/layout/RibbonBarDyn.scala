package com.simplesys.isc.layout

import com.simplesys.json.{JsonString, JsonElement, JsonObject}
import com.simplesys.common.Strings._
import com.simplesys.isc.system.ClassDyn


object RibbonBarDyn {

  implicit def RibbonBartoJsonObject(in: RibbonBarDyn): JsonObject = in json
}

class RibbonBarDyn(override val useSelfName: Boolean = false) extends ToolStripDyn with RibbonBarDynInit {
  override val selfName = "RibbonBar"

  def addGroup(group: RibbonGroupDyn, position: Number = null) {
    position match {
      case null =>
        if (!group.Identifier.isEmpty && group.Enqueued)
          setInstanceCommandEnqueue("addGroup(%s)" format group.Identifier.toString.unQuoted)
        else
          setInstanceCommandEnqueue("addGroup(%s)" format group)
      case _ =>
        if (!group.Identifier.isEmpty && group.Enqueued)
          setInstanceCommandEnqueue("addGroup(%s, %s)" format(group.Identifier.toString.unQuoted, position))
        else
          setInstanceCommandEnqueue("addGroup(%s, %s)" format(group, position))
    }
  }

  def addMember(newMember: ClassDyn, position: Number = null) {
    position match {
      case null =>
        if (!newMember.Identifier.isEmpty && newMember.Enqueued)
          setInstanceCommandEnqueue("addMember(%s)" format newMember.Identifier.toString.unQuoted)
        else
          setInstanceCommandEnqueue("addMember(%s)" format newMember)
      case _ =>
        if (!newMember.Identifier.isEmpty && newMember.Enqueued)
          setInstanceCommandEnqueue("addMember(%s, %s)" format(newMember.Identifier.toString.unQuoted, position))
        else
          setInstanceCommandEnqueue("addMember(%s, %s)" format(newMember, position))
    }
  }
}
