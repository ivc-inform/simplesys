package com.simplesys.log.logback

import org.slf4j.{LoggerFactory => Slf4jLoggerFactory}
import ch.qos.logback.classic.{LoggerContext => LBK_LoggerContext}
import ch.qos.logback.core.util.{StatusPrinter => LBK_StatusPrinter}

object LoggerContext {
  def apply() = new LoggerContext(Slf4jLoggerFactory.getILoggerFactory.asInstanceOf[LBK_LoggerContext])
}

class LoggerContext(val lc: LBK_LoggerContext) {
  def printStatus {
    LBK_StatusPrinter print lc
  }
}