package com.simplesys.scalaGen

import com.simplesys.common.Strings._
import scala.collection.mutable.ArrayBuffer

abstract class ScalaWithTrait extends ScalaElement

case class ScalaWithTraits(traits: ScalaWithTrait*) extends ScalaElement {
    private val _traits = ArrayBuffer(traits: _*)

    def +=(`trait`: ScalaWithTrait) {
        _traits += `trait`
    }

    def ++=(traits: ScalaWithTrait*) {
        _traits ++= traits
    }

    def serrialize(indent: Int = 0) = {
        var res = (_traits map (_.serrialize(indent))).mkString(space + "with".space)
        if (!res.isEmpty)
            "with".space + res // Не менять
        else
            ""
    }
}

case class ScalaTraitGeneric(`type`: ScalaBaseClassDeclare) extends ScalaWithTrait {
    def serrialize(indent: Int) = `type` serrialize indent
}

case object ScalaTraitEmpty extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + ""
}

case object ScalaTraitX extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "TraitX"
}

case object ScalaTraitY extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "TraitY"
}

case object ScalaTraitStaticEndpoints extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "StaticEndpoints"
}

case object ScalaTraitLogging extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "Logging"
}

case object ScalaTraitConfig extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "Config"
}

case object ScalaTraitProduct extends ScalaWithTrait {
    def serrialize(indent: Int = 0) = spaces(indent) + "Product"
}