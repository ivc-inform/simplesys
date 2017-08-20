package com.simplesys.json

import com.simplesys.log.Logging
import com.simplesys.common.Strings._

trait JsonAbs {
  def toString(formatter: JsonFormatter.funcFormatter): String
  def toString1(formatter: JsonFormatter.funcFormatter): String

  override def toString = toString(JsonFormatter.defaultFormatter)
  def toString1: String = toString1(JsonFormatter.defaultFormatter)
}

object JsonFormatter extends Logging {
  type funcFormatter = Any => String

  /*private[json] val defaultFormatter1: funcFormatter = (in: Any) => {
    in match {
      case s: String => s
      case jsonObject: JsonObject => jsonObject toString (defaultFormatter1)
      case jsonList: JsonList => jsonList toString (defaultFormatter1)
      case other =>
        other match {
          case null => "null"
          case _ => other.toString()
        }
    }
  }*/

  private[json] val defaultFormatter: funcFormatter = (in: Any) => {
    in match {
      case s: String => s
      case jsonObject: JsonObject => jsonObject toString (defaultFormatter)
      case jsonList: JsonList => jsonList toString (defaultFormatter)
      case other =>
        other match {
          case null =>
              "null"
          case _ =>
              other toString()
        }
    }
  }
}
