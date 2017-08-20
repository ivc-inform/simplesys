package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.dataBinging.RPC.RPCRequestDyn
import com.simplesys.json.UnquotedString

trait ViewLoaderDynInit extends LabelDynInit {
  protected val allowCaching: Bool = false
  protected val handleError: UnquotedString = null
  protected val httpMethod: SendMethod = sndMtGet
  protected val loadingMessage: HTMLString = "Loading View...&nbsp;${loadingImage}"
  protected val viewRPCProperties: RPCRequestDyn = null
  protected val viewURL: URL = null
  protected val viewURLParams: ClassDyn = null
}