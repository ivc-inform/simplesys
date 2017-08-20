package com.simplesys.connectionStack

import com.simplesys.log.Logging
import com.simplesys.bonecp.BoneCPConfig

trait ConnectionPool extends Logging {
  boneCPConfig: BoneCPConfig =>

  Class forName boneCPConfig.DriverClass
}