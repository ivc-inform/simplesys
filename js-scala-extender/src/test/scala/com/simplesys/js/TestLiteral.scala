package com.simplesys.js

import com.simplesys.script.JsStringWriter
import scalax.io.JavaConverters._
import org.scalatest.FunSuite
import com.simplesys.log.Logging


trait LiteralProg {
  this: JS =>
  def test(x: Rep[Double]): Rep[Double] = {
    val o = new JSLiteral {
      val a = x
      val b = x + 2.0
      val c = 1.0
      val d = a + b
      val e = c + 2.0
      val f = "Строка"
    }
    o.a
  }
}

trait LiteralFunProg {
  this: JS =>
  def test(x: Rep[Int]): Rep[Int] = {
    val o = new JSLiteral {
      val a = x + 2
      val f = fun {
        (y: Rep[Int]) => y + a
      }
    }
    o.f(x)
  }
}

class TestLiteral extends FileDiffSuite with Logging {
  val prefix = "test-out/"

  val str = new JsStringWriter(false)

  def testLiteral = {
    withOutFile(prefix + "literal") {
      new LiteralProg with JSExp {
        self =>
        val codegen = new JSGen {
          val IR: self.type = self
        }
        codegen.emitSource(test _, "test", str)
      }
    }.asOutput.write(str.toString)
    assertFileEqualsCheck(prefix + "literal")

    logger.debug("%s", str)
  }

  def testLiteralFun = {
    withOutFile(prefix + "literalfun") {
      new LiteralFunProg with JSExp {
        self =>
        val codegen = new JSGen {
          val IR: self.type = self
        }
        codegen.emitSource(test _, "test", str)
      }
    }.asOutput.write(str.toString)
    assertFileEqualsCheck(prefix + "literalfun")
    logger.debug("%s", str)
  }
}

trait TestLSLiteral {
  this: JS =>

  def test(x: Rep[Double]): Rep[JSLiteral] = {
    /*type Request = JSLiteral {
      val url: String
      val dataType: String
    }

    val r = new Request {
      val url1 = "url"
    }*/

    val l = new JSLiteral {
      val a = x
      val b = x + 2.0
      val c = 1.0
      val d = a + b
      val e = "Str"
      val f = null
    }
    l
  }
}

class TestJSLiteralSuit extends FunSuite with Logging {
  test("1") {
    val str = new JsStringWriter(false)

    new TestLSLiteral with JSExp {
      self =>
      val codegen = new JSGen {
        val IR: self.type = self
      }
      codegen.emitSource(test _, "test", str)
    }

    logger.debug("%s", str)
  }
}

