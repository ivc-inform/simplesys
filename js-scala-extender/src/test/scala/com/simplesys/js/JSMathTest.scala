package com.simplesys.js

import com.simplesys.log.Logging
import com.simplesys.script.JsStringWriter
import com.simplesys.time.Imports._
import org.scalatest.FunSuite

trait JSMathProgram extends JS {

  def test(): Rep[Int] = {
    val res = Math.max(0, 1, 2)
    res
  }
}

class TestJSMath extends FunSuite with Logging {
  test("1") {

    val str = new JsStringWriter(false)

    new JSMathProgram with JSExp {
      self =>

      val codegen = new JSGen {
        val IR: self.type = self
      }

      codegen.emitSource0(test _, "test", str)
      logger debug str.toString()
    }
  }
}