import com.simplesys.connectionStack.BoneCPStack
import com.simplesys.log.Logging
import org.jooq.impl.DSL
import org.jooq.tools.StringUtils
import org.scalatest.{BeforeAndAfter, FunSuite}
import ru.simplesys.persistence.jooqwrapper.DialectHelper._
import collection.JavaConversions._

//import org.jooq.scala.Conversions._

import org.jooq.scala.Conversions._

class Test extends FunSuite with BeforeAndAfter with Logging {
  val cpStack = BoneCPStack()
  val ds = cpStack.PostgreSQLDataSource("postgreEnzo")
  ds.getConnection.close()

  val dsl = DSL.using(ds, ds.getDriverClass);

  import dsl._

  test("1") {
    for (r <- select(UserJTable.di, UserJTable.caption, UserJTable.login) from (UserJTable) orderBy (UserJTable.di) fetch) {
      asTuple3(r) match {
        case (di, captin, login) =>
      }
    }
  }

  after {
    StringUtils.toCamelCase()
    cpStack.Close()
  }
}