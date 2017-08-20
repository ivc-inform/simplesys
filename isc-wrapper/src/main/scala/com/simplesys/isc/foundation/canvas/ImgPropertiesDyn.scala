package com.simplesys.isc.foundation.canvas

import com.simplesys.json.{JsonURL, JsonString, UnquotedString, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._

object ImgPropertiesDyn {

    implicit def ImgPropertiestoJsonObject(in: ImgPropertiesDyn): JsonObject = in json
}

class ImgPropertiesDyn extends ClassDyn with ImgPropertiesDynInit {
    private[this] var _extraStuff: String = extraStuff
    def ExtraStuff = _extraStuff
    def ExtraStuff_=(value: String) {
        if (_extraStuff == value) return
        json("extraStuff") = value
        _extraStuff = value
    }

    private[this] var _height: Number = height
    def Height = _height
    def Height_=(value: Number) {
        if (_height == value) return
        json("height") = value
        _height = value
    }

    private[this] var _imgDir: UnquotedString = imgDir
    def ImgDir = _imgDir
    def ImgDir_=(value: UnquotedString) {
        if (_imgDir == value) return
        json("imgDir") = value
        _imgDir = value
    }

    private[this] var _name: String = name
    def Name = _name
    def Name_=(value: String) {
        if (_name == value) return
        json("name") = value
        _name = value
    }

    def Src = json.getValue2[JsonURL, URL]("src").getOrElse(src)
    def Src_=(value: URL) {
        if (Src == value) return
        json("src") = value
    }

    private[this] var _width: Number = width
    def Width = _width
    def Width_=(value: Number) {
        if (_width == value) return
        json("width") = value
        _width = value
    }
}
