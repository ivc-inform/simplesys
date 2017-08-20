package com.simplesys.isc.system

import misc.{Bool, Number}
import virtualization.lms.common.Base
import com.simplesys.meta.HtgLists.HtgList

trait LiftBool extends Base {
  implicit def boolToRep(b: Bool): Rep[Bool] = unit(b)
}

trait LiftBoolBolean extends Base {
  implicit def boolToRep1(b: Boolean): Rep[Bool] = unit(Bool(b))
}

trait LiftNumber extends Base {
  implicit def numberToRep(n: Number): Rep[Number] = unit(n)
  //implicit def intToNumberRep[T: Numeric : Manifest](n: T): Rep[Number] = unit(Number(n.toString))
}


trait LiftHtg extends Base {
  implicit def htgToRep(htg: HtgList): Rep[HtgList] = unit(htg)
}

trait LiftNull extends Base {
  implicit def nullToRep(htg: Null): Rep[Null] = unit(null)
}

