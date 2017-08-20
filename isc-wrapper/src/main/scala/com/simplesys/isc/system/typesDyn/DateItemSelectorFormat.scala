package com.simplesys.isc.system.typesDyn


sealed abstract trait DateItemSelectorFormat

case object dtSlFmtNull extends DateItemSelectorFormat {
  override def toString = ""
}

case object dtSlFmtDMY extends DateItemSelectorFormat {
  override def toString = "DMY"
}

case object dtSlFmtMDY extends DateItemSelectorFormat {
  override def toString = "MDY"
}

case object dtSlFmtYMD extends DateItemSelectorFormat {
  override def toString = "YMD"
}

case object dtSlFmtDM extends DateItemSelectorFormat {
  override def toString = "DM"
}

case object dtSlFmtMD extends DateItemSelectorFormat {
  override def toString = "MD"
}

case object dtSlFmtYM extends DateItemSelectorFormat {
  override def toString = "YM"
}

case object dtSlFmtMY extends DateItemSelectorFormat {
  override def toString = "MY"
}


