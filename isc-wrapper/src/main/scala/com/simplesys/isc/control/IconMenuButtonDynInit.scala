package com.simplesys.isc.control

import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{JsonElement, JsonNull}

trait IconMenuButtonDynInit {
  protected val menu: JsonElement = JsonNull
  protected val menuAnimationEffect: MenuAnimationEffect = mnuAnimEffctNull
}