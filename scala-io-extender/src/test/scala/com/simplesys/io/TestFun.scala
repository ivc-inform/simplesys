package com.simplesys.io

import java.io.File

import com.simplesys.log.Logging
import org.scalatest.FunSuite

class TestSuit extends FunSuite with Logging {
  test("Read\\Write to File") {
    val f = new File("test-out/test1.txt")

    /*f <== "Это строка1"
    f <== "Это строка2"*/

    f <=| {
      out =>
        out("Это строка1")
        out("Это строка2")
    }


    logger debug("Содержание файла f: \n'%s'", f ==>)
  }

  test("String to File") {
    val file: File = new File("/home/andrew/JOB/simplesys/scala-io-extender/test-out/test1.txt")

    logger debug("%s", file.onlyFileName)
  }

  test("asPath"){
    val path = "/home/andrew/Job/simplesys/scala-io-extender/src/test/scala/com/simplesys/io/TestFun.scala".asPath
    logger debug path.toFile.getAbsolutePath.asPath.createDirectory()
    logger debug path.toFile.getAbsolutePath
  }
}
