package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.json.{UnquotedString, JsonObject}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc._

object MailDyn {
  implicit def Mail1toJsonObject(in: MailDyn): JsonObject = in json
}

class MailDyn extends ClassDyn with MailDynInit {
  override val selfName = "Mail"
  private[this] var _bcc: String = bcc
  def Bcc = _bcc
  def Bcc_=(value: String) {
    if (_bcc == value) return
    json("bcc") = value
    _bcc = value
  }

  private[this] var _cc: String = cc
  def Cc = _cc
  def Cc_=(value: String) {
    if (_cc == value) return
    json("cc") = value
    _cc = value
  }

  private[this] var _from: String = from
  def From = _from
  def From_=(value: String) {
    if (_from == value) return
    json("from") = value
    _from = value
  }

  private[this] var _messageTemplate: String = messageTemplate
  def MessageTemplate = _messageTemplate
  def MessageTemplate_=(value: String) {
    if (_messageTemplate == value) return
    json("messageTemplate") = value
    _messageTemplate = value
  }

  private[this] var _multiple: Bool = multiple
  def Multiple = _multiple
  def Multiple_=(value: Bool) {
    if (_multiple == value) return
    json("multiple") = value
    _multiple = value
  }

  private[this] var _replyTo: String = replyTo
  def ReplyTo = _replyTo
  def ReplyTo_=(value: String) {
    if (_replyTo == value) return
    json("replyTo") = value
    _replyTo = value
  }


  private[this] var _subject: String = subject
  def Subject = _subject
  def Subject_=(value: String) {
    if (_subject == value) return
    json("subject") = value
    _subject = value
  }

  private[this] var _templateFile: UnquotedString = templateFile
  def TemplateFile = _templateFile
  def TemplateFile_=(value: UnquotedString) {
    if (_templateFile == value) return
    json("templateFile") = value
    _templateFile = value
  }

  private[this] var _to: String = to
  def To = _to
  def To_=(value: String) {
    if (_to == value) return
    json("to") = value
    _to = value
  }
}