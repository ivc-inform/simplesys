package com.simplesys.isc.system.global

import com.simplesys.common.Strings._
import com.simplesys.common._
import com.simplesys.log.Logging

import scala.io.Source
import scala.io.Codec._

object JSCode extends Logging {
  def loadFromURI(uriBox: URIBox): String = {
    uriBox match {
      case URIBox(Some(uri), message) =>
        val res = Source.fromInputStream(uri.toURL openStream)(UTF8).getLines.mkString(newLine)
        logger trace(s"loadFromURI: '${uri}'")
        res
      case URIBox(None, message) =>
        logger trace(s"loadFromURI: '${message}'")
        ""
    }
  }

  def loadFromURL(urlBox: URLBox): String = {
    urlBox match {
      case URLBox(Some(url), message) =>
        val res = Source.fromInputStream(url openStream)(UTF8).getLines.mkString(newLine)
        logger trace(s"loadFromURI: '${url}'")
        res
      case URLBox(None, message) =>
        logger trace(s"loadFromURI: '${message}'")
        ""
    }
  }
}
