package com.simplesys.js

import java.io._
import scala.Console
import org.scalatest.FunSuite


trait FileDiffSuite extends FileOutSuite with FunSuite with Cfg {

  def assertFileEqualsCheck(name: String): Unit = {

    if (!checkWithTemplate) return

    expectResult(readFile(name + ".check")) {
      readFile(name)
    }

    if (deleteTmpFiles)
      new File(name) delete()
  }
}