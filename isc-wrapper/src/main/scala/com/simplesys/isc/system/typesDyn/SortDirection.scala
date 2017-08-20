

package com.simplesys.isc.system.typesDyn


sealed abstract trait SortDirection

case object srtDirNull extends SortDirection {
  override def toString = ""
}

case object srtDirAscending extends SortDirection {
  override def toString = "ascending"
}

case object srtDirDescending extends SortDirection {
  override def toString = "descending"
}


