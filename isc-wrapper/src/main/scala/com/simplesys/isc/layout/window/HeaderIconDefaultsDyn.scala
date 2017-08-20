package com.simplesys.isc.layout.window

import com.simplesys.json.JsonObject
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.ClassDyn

object HeaderIconDefaultsDyn extends HeaderIconDefaultsDynInit {
  implicit def HeaderIconDefaultsDyn2JsonObject(in: HeaderIconDefaultsDyn): JsonObject = in json
}

trait HeaderIconDefaultsDyn extends ClassDyn with HeaderIconDefaultsDynInit {
  def Height = json.getNumberOpt("height").getOrElse(height)
  def Height_=(value: Number) {
    if (Height == value) return
    json("height") = value
  }

  def Src = json.getStringOpt("src").getOrElse(src)
  def Src_=(value: SCImgURL) {
    if (Src == value) return
    json("src") = value
  }

  def Width = json.getNumberOpt("width").getOrElse(width)
  def Width_=(value: Number) {
    if (Width == value) return
    json("width") = value
  }
}