package test

import com.simplesys.slick.oracle.OracleSlick
import org.scalatest.FunSuite

class TestSuit extends FunSuite with OracleSlick {
    test("1") {
        val dbb = OracleSlick.getDataBaseConfig(url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl", user = "temp", password = "temp").db
        dbb.createSession()
    }
}
