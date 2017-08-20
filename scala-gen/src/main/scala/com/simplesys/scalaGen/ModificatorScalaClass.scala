package com.simplesys.scalaGen

import com.simplesys.common.Strings._

abstract class ModificatorScalaClass extends ScalaElement

object NoneModificatorScalaClass extends ModificatorScalaClass {
    def serrialize(indent: Int) = ""
}

object AbstractModificatorScalaClass extends ModificatorScalaClass {
    def serrialize(indent: Int) = "abstract".space
}

object SealedModificatorScalaClass extends ModificatorScalaClass {
    def serrialize(indent: Int) = "sealed".space
}

object SealedAbstractModificatorScalaClass extends ModificatorScalaClass {
    def serrialize(indent: Int) = "sealed abstract".space
}

object CaseModificatorScalaClass extends ModificatorScalaClass {
    def serrialize(indent: Int) = "case".space

}
