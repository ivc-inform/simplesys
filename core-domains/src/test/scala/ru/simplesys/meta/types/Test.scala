package ru.simplesys.meta.types

import org.scalatest.FunSuite
import com.simplesys.log.Logging
import com.simplesys.common.Strings._
import com.simplesys.isc.system.typesDyn
import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime
import com.simplesys.isc.system.typesDyn.OperatorId


class Test extends FunSuite with Logging {
    test("Create BO Table") {
      println("123456")
    }

    test("DateTime"){
        val d: DateTime = new DateTime(0)
        logger debug (d.toString(DateTimeFormat.forPattern("dd.MM.yyyy")))
    }

    test("betweenInclusive"){
      println(OperatorId.getObject("betweenInclusive").toSQL)
    }

}