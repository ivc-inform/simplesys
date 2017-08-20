package com.simplesys.isc.system

import com.simplesys.log.Logging

package object global extends Logging {

  private[this] var modeNames: ModeNames = SimpleNames
  def ModeNames = modeNames
  def ModeNames_=(_modeNames: ModeNames) = modeNames = _modeNames

  def __ = "{}"
  def logModeNames {
      logger trace (s"ModeNames: ${ModeNames}")
  }

}