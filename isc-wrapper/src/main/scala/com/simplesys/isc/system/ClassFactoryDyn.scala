package com.simplesys.isc.system

import com.simplesys.isc.system.global._
import com.simplesys.common.Strings._


object ClassFactoryDyn {

  @deprecated("Use isc.defineClass instead", "")
  def defineClass(className: String, parentClassName: String): ClassDyn = {
    new ClassDyn(selfName = "defineClass(" + className.quoted + "," + ModeNames + parentClassName + ")")
  }
}