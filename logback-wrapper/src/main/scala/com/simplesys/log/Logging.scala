package com.simplesys.log

trait Logging {
  protected lazy val logger = Logger(this getClass)
}
