package com.simplesys.isc.foundation.scrollBar

import com.simplesys.json.JsonObject
import com.simplesys.isc.foundation.StretchImgDyn

object ScrollThumbDyn {

  implicit def ScrollThumbtoJsonObject(in: ScrollThumbDyn): JsonObject = in json
}

class ScrollThumbDyn(override val useSelfName: Boolean = false) extends StretchImgDyn with ScrollThumbDynInit {
  override val selfName = "ScrollThumb"
}