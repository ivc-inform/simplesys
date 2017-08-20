
package com.simplesys.isc.system.typesDyn


sealed abstract trait HoverMode

case object hvrMdNull extends HoverMode {
  override def toString = ""
}

case object hvrMdDetailField extends HoverMode {
  override def toString = "detailField"
}

case object hvrMdDetails extends HoverMode {
  override def toString = "details"
}

case object hvrMdRelated extends HoverMode {
  override def toString = "related"
}

case object hvrMdDetailRelated extends HoverMode {
  override def toString = "detailRelated"
}


