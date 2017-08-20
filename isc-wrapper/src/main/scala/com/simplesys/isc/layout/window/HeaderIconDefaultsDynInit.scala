package com.simplesys.isc.layout.window

import com.simplesys.isc.system.ClassDynInit
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonNull

trait HeaderIconDefaultsDynInit extends ClassDynInit {
  private[window] val width: Number = 16
  private[window] val height: Number = 14
  private[window] val src: SCImgURL = JsonNull
}   