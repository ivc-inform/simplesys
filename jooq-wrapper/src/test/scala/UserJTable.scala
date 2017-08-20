import org.jooq.impl.SQLDataType
import org.jooq.{Record7, Table}
import ru.simplesys.persistence.jooqwrapper.AbstractTableImplScala
import ru.simplesys.persistence.jooqwrapper.ImplicitConversions._

class UserJTable private(nameJOOQTable: String, aliased: Table[Record7[BigDecimal, String, Option[String], Option[String], String, String, String]]) extends AbstractTableImplScala[Record7[BigDecimal, String, Option[String], Option[String], String, String, String]](nameJOOQTable, null, aliased) {
  //import mappersJOOQ._

  val di = createFieldScala("DI", SQLDataType.NUMERIC.asBigDecimal, this)
  val login = createFieldScala("SLOGIN", SQLDataType.VARCHAR.length(255), this)
  val firstName = createFieldScala("SFIRSTNAME", SQLDataType.VARCHAR.length(255).asOption, this)
  val secondName = createFieldScala("SSECONDNAME", SQLDataType.VARCHAR.length(255).asOption, this)
  val lastName = createFieldScala("SLASTNAME", SQLDataType.VARCHAR.length(255), this)
  val caption = createFieldScala("SCAPTION", SQLDataType.VARCHAR.length(255), this)
  val password = createFieldScala("SPASSWORD", SQLDataType.VARCHAR.length(255), this)
}

object UserJTable extends UserJTable("A_USER", null) {
  def apply(alias: String) = new UserJTable(alias, this)
  override def as(alias: String) = apply(alias)
}