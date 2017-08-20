package com.simplesys.isc.system.typesDyn

import com.simplesys.common.Strings._

sealed abstract trait FireStyle

case object onceFireStyle extends FireStyle {
    override def toString = "once".dblQuoted
}

case object nullFireStyle extends FireStyle {
    override def toString = "null"
}
