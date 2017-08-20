package com.simplesys.connectionStack

import com.simplesys.bonecp.BoneCPConfig
import com.simplesys.xml.Elem


object DerbyBCPConfig {
  def apply(xmlConfig: Elem) = new DerbyBCPConfig(xmlConfig)
}

class DerbyBCPConfig(xmlConfig: Elem) extends BoneCPConfig(xmlConfig) with ConnectionPool {
  System.getProperties.setProperty("derby.system.home", DerbySystemHome)
  logConfig
}