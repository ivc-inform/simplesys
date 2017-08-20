package com.simplesys.joda

import org.scalatest.FunSuite
import com.simplesys.time.StaticDateTime
import com.simplesys.log.Logging

class TestSuit extends FunSuite with StaticDateTime with Logging {
  test("1") {
    logger debug("%s", now)
  }
}