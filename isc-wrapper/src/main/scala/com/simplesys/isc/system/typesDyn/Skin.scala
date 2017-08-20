package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait Skin

case object sknEnterprise extends Skin {
  override def toString = "Enterprise"
}

case object sknBlackOps extends Skin {
  override def toString = "BlackOps"
}

case object sknCupertino extends Skin {
  override def toString = "Cupertino"
}

case object sknEnterpriseBlue extends Skin {
  override def toString = "EnterpriseBlue"
}

case object sknFleet extends Skin {
  override def toString = "fleet"
}

case object sknGraphite extends Skin {
  override def toString = "Graphite"
}

case object sknMobile extends Skin {
  override def toString = "Mobile"
}

case object sknSilverWave extends Skin {
  override def toString = "SilverWave"
}

case object sknSimplicity extends Skin {
  override def toString = "Simplicity"
}

case object sknSmartClient extends Skin {
  override def toString = "SmartClient"
}

case object sknStandard extends Skin {
  override def toString = "standard"
}

case object sknToolSkin extends Skin {
  override def toString = "ToolSkin"
}

case object sknToolSkinNative extends Skin {
  override def toString = "ToolSkinNative"
}

case object sknTreeFrog extends Skin {
  override def toString = "TreeFrog"
}

object Skin {
    private val values = SealedEnumRuntime.values[Skin]
    private val mappedKeys: Map[String, Skin] = values.map(x => (x.toString, x))(collection.breakOut)
    def getObject(objName: String): Skin = mappedKeys(objName)
}