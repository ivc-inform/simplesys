package test.simplesys.components.Gen

import java.io.File

import com.simplesys.log.Logging
import com.simplesys.common._
import org.scalatest.FunSuite

class GenTests extends FunSuite with Logging {
    test("1") {
        val a = " /home/andrew/Job/simplesys/logback-wrapper/src/test/scala/com/simplesys/log/Test.js"
        logger debug a.shortClassName
        logger debug File.pathSeparator
        logger debug a.shortClassName1
    }
}

