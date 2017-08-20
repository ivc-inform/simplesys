package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.isc.system.misc.{Bool}
import com.simplesys.json.UnquotedString

trait MailDynInit {
  protected val bcc: String = ""
  protected val cc: String = ""
  protected val from: String = ""
  protected val messageTemplate: String = ""
  protected val multiple: Bool = false
  protected val replyTo: String = ""
  protected val subject: String = ""
  protected val templateFile: UnquotedString = null
  protected val to: String = ""
}