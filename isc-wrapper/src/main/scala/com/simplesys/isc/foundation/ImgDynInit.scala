package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait ImgDynInit extends StatefulCanvasDynInit {
  protected val activeAreaHTML: String = ""
  protected val altText: String = ""
  protected val imageHeight: Number = null
  protected val imageType: ImageStyle = imgStStretch
  protected val imageWidth: Number = null
  protected val name: String = "main"
  protected val showTitle: Bool = false
  protected val size: Number = null
  protected val src: SCImgURL = "blank.gif"
  protected val usePNGFix: Bool = true
}