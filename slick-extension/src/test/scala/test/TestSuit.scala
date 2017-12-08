package test

import com.simplesys.slick.oracle.OracleSlick
import org.scalatest.FunSuite

class TestSuit extends FunSuite with OracleSlick{
  test("1") {
      val dbb = db
  }
}
