package com.simplesys.connectionStack

import com.simplesys.xml.Elem
import com.simplesys.bonecp.BoneCPConfig

object H2BCPConfig {
  def apply(xmlConfig: Elem) = new H2BCPConfig(xmlConfig)
}

class H2BCPConfig(xmlConfig: Elem) extends BoneCPConfig(xmlConfig) with ConnectionPool {
  logConfig
}