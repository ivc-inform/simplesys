package test

import com.simplesys.slick.oracle.OracleSlick
import org.scalatest.FunSuite
import slick.dbio.{DBIOAction, Effect, NoStream}
import slick.jdbc.meta.MQName

import scala.concurrent.ExecutionContext.Implicits.global

class TestSuit extends FunSuite with OracleSlick {
    test("1") {
        //val dbb = OracleSlick.getDataBaseConfig(url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl", user = "temp", password = "temp").db
        val dbb = slick.jdbc.OracleProfile.api.Database.forURL(url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl", user = "temp", password = "temp", driver = "oracle.jdbc.OracleDriver")
        dbb.source.createConnection()
//        val res: DBIOAction[Seq[MQName], NoStream, Effect.All] = dbb.profile.defaultTables.map(_ map (_.name))
//        val a = res
    }
}
