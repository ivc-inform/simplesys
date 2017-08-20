package com.simplesys.log

import junit.framework.TestCase

class TestJUnit extends TestCase with Logging {

    def testHelloWorld {
        logger debug (s"Hello World ")
    }

}