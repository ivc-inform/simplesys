package com.simplesys.orbroker


import org.scalatest.FunSuite
import com.simplesys.connectionStack.BoneCPStack
import org.orbroker._
import com.simplesys.log.Logging

class testOriginalORBroker extends FunSuite with BoneCPStack with Logging {


  protected val configFileName = defaultConfigFileName

  val configName = "enzo"
  val oracleDataSource = OracleDataSource(configName)

  val oraSQL = "select count(*) as nCount from stocks s where  s.smnemocode =  ? or ((? is null) and (s.smnemocode is null))"

  case class res(count: BigDecimal)

  object resExtractor extends RowExtractor[res] {
    def extract(row: Row) = res(row.decimal("COUNT") get)
  }

  test("First") {
    val broker = new Broker(oracleDataSource)

    broker.readOnly() {
      session =>
        val sql = "SELECT COUNT(*) AS COUNT FROM USERS"
        val onTheFly = Token(sql, 'onTheFly, resExtractor)
        val count = session.selectOne(onTheFly).get count

        logger debug("users count: %s", count)
    }
  }

}