package com.simplesys.isc.system.misc

import java.io.File

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._

class URNString(path: String) {
    def urn = URN(path)
}

case class URN(path: String) {
    override def toString =  if (path.last === File.separatorChar) path.substring(0, path.length - 1) else path
}