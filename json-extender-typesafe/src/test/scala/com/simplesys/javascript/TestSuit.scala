package com.simplesys.javascript

import org.scalatest.FunSuite
import com.simplesys.log.Logging
import java.io.File

class TestSuit extends  FunSuite with Logging{

    test("1") {
        val funcs = JavaScript(new File("/home/andrew/Job/simplesys/json-extender-typesafe/src/test/resources/TestJavaScript.js"))

        logger debug funcs.getFunction("removeTreeRow")
        logger debug funcs.getFunction("canReparentNodes")
    }

}