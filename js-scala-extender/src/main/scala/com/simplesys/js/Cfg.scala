package com.simplesys.js

import virtualization.lms.internal.Config

trait Cfg extends Config {
  val checkWithTemplate = false
  val deleteTmpFiles = false

  override val verbosity = 2
  override val sourceinfo = 2
}