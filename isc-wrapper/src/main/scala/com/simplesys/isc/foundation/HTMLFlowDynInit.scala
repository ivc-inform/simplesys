package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json.{UnquotedString, JsonObject}

trait HTMLFlowDynInit extends CanvasDynInit {
  protected val allowCaching: Bool = false
  protected val captureSCComponents: Bool = true
  protected val contentsType: String = ""
  protected val contentsURL: URL = null
  protected val contentsURLParams: JsonObject = JsonObject()
  protected val evalScriptBlocks: Bool = true
  protected val httpMethod: SendMethod = sndMtGet
  protected val loadingMessage: HTMLString = "&nbsp;${loadingImage}"
  protected val prefix: HTMLString = ""
}