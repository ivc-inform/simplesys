package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ClassDynInit

trait JSONEncoderDynInit extends ClassDynInit {
  protected val circularReferenceMarker: String = "$$BACKREF$$"
  protected val circularReferenceMode: JSONCircularReferenceMode = jsonCrclRfMdPath
  protected val dateFormat: JSONDateFormat = jsonDtFmtXmlSchema
  protected val prettyPrint: Bool = true
  protected val serializeInstances: JSONInstanceSerializationMode = jsonInstSrlzLong
  protected val showDebugOutput: Bool = false
  protected val skipInternalProperties: Bool = false
  protected val strictQuoting: Bool = true
}