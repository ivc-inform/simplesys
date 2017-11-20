package ru.simplesys.meta.types

import com.simplesys.isc.system.typesDyn.OperatorId
import com.simplesys.log.Logging
import org.scalatest.FunSuite


class Test extends FunSuite with Logging {
    test("Create BO Table") {
      println("123456")
    }

    test("betweenInclusive"){
      println(OperatorId.get("betweenInclusive").toSQL)
    }

}
