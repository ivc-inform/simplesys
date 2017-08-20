package com.simplesys.log

import org.slf4j.{MDC => Slf4jMDC}

object MDC {
  def clear {
    Slf4jMDC.clear
  }

  def apply(key: String) = Slf4jMDC get key

  def +=(key: String, value: String) {
    Slf4jMDC.put(key, value)
  }

  def -=(key: String) {
    Slf4jMDC remove key
  }
}