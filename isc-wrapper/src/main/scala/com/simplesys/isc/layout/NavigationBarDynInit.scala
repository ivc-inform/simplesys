package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.JsonNull

trait NavigationBarDynInit extends HLayoutDynInit {
  protected val leftButton: AutoChild = null
  protected val leftButtonIcon: SCImgURL = JsonNull
  protected val leftButtonTitle: String = " "
  protected val navigationClick: FunctionExpression = null
  protected val rightButton: AutoChild = null
  protected val rightButtonIcon: SCImgURL = JsonNull
  protected val rightButtonTitle: String = ""
  protected val title: String = ""
  protected val titleLabel: AutoChild = null
}