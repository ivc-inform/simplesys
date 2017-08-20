package com.simplesys.js

import com.simplesys.script.JsStringWriter
import com.simplesys.io.RichFile

trait ArraysProg extends JS {

  def test1(x: Rep[Int]): Rep[Int] = {
    val a = array(1, 2, 3)
    a(1) = 4
    a.length + a(1) + x
  }

  def test2(x: Rep[Int]): Rep[Int] = {
    val a = array(1, 2, 3)
    val b = array(4, 5, 6)
    for (el <- a) {
      b(0) = el
    }
    b(0)
  }

  def test3(x: Rep[Int]): Rep[Array[Int]] = {
    val a = array(1, 2, 3)
    val b = for (el <- a) yield el + x
    b
  }

  def test4(x: Rep[Int]): Rep[Array[Int]] = {
    val a = array(1, 2, 3)
    val b = for (x1 <- a; x2 <- a) yield x1 + x2
    b
  }

  def test5(x: Rep[Int]): Rep[Array[Int]] = {
    val a = array(1, 2, 3)
    val b = for (el <- a; if (el == x)) yield el
    b
  }

  def test6(n: Rep[Int]): Rep[Array[Int]] = {
    val a = array[Int]()
    for (i <- range(0, n)) {
      a(i) = i
    }
    a
  }

  def test7(n: Rep[Int]): Rep[Array[Int]] = {
    for (i <- range(0, n)) yield i
  }

  def test8(n: Rep[Int]): Rep[Array[Int]] = {
    for (i <- range(0, n); j <- range(0, n)) yield i * j
  }

  def test9(n: Rep[Int]): Rep[Array[Int]] = {
    for (i <- range(0, n); if (i == 1)) yield i * i
  }

  def test10(n: Rep[Int]): Rep[Array[Int]] = {
    val a = array(1, 2, 3)
    for (x1 <- a; i <- range(0, n); x2 <- a) yield (x1 + x2) * i
  }

  def test11(n: Rep[Int]): Rep[Array[Int]] = {
    val x = array(1, 2, 3)
    val y = x(4)
    array(y)
  }

  //def prog1(b: Boolean, x: Rep[Int]) = if (b) x else x + 1

  def prog2(b: Rep[Boolean], x: Rep[Int]) = if (b) x else x + 1

}

class TestArrays extends FileDiffSuite with Cfg {

  val prefix = "test-out/"

  test("Arrays") {
    val js = new JsStringWriter(false)

    withOutFile(prefix + "arrays") {

      new ArraysProg with JSExp {
        self =>
        val codegen = new JSGen {
          val IR: self.type = self
        }

        codegen.emitSource(test1 _, "test1", js)
        codegen.emitSource(test2 _, "test2", js)
        codegen.emitSource(test3 _, "test3", js)
        codegen.emitSource(test4 _, "test4", js)
        codegen.emitSource(test5 _, "test5", js)
        codegen.emitSource(test6 _, "test6", js)
        codegen.emitSource(test7 _, "test7", js)
        codegen.emitSource(test8 _, "test8", js)
        codegen.emitSource(test9 _, "test9", js)
        codegen.emitSource(test10 _, "test10", js)
        codegen.emitSource(test11 _, "test11", js)
        //codegen.emitSource(prog1 _, "prog1", str)
        codegen.emitSource2(prog2 _, "prog2", js)

        val genLegacy = new JSGen {
          val IR: self.type = self
        }

        genLegacy.emitSource(test2 _, "test2Legacy", js)
        genLegacy.emitSource(test3 _, "test3Legacy", js)
        genLegacy.emitSource(test5 _, "test5Legacy", js)

      }
    } <== js.toString
    assertFileEqualsCheck(prefix + "arrays")
  }

}
