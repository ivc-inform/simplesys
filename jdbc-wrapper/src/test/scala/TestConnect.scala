import com.simplesys.common.Strings.newLine
import com.simplesys.connectionStack.BoneCPStack
import com.simplesys.isc.system.typesDyn.TextMatchStyle
import com.simplesys.jdbc.control.DSRequest
import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.log.Logging
import com.simplesys.tuple.TupleSS12
import org.scalatest.{BeforeAndAfter, FunSuite}
import ru.simplesys.defs.bo.admin.UserDS
import com.simplesys.jdbc._
import com.simplesys.json._

import scalaz.{Failure, Success}

class TestConnect extends FunSuite with BoneCPStack with Logging with BeforeAndAfter {

    test("1") {
        val ds = OracleDataSource("oracleMFMS")
        val dataSet = UserDS(ds)

        val data = JsonObject.apply1("group" → 0)

        logger debug s"data: ${newLine + data.toPrettyString}"

        val _data = JsonList()

        val select = dataSet.Fetch(dsRequest = DSRequest(sqlDialect = ds.SQLDialect, startRow = 0, endRow = 70, sortBy = JsonList(), data = data, textMatchStyle = "substring"))

        select.result match {
            case Success(list) => {
                list foreach {
                    case TupleSS12(activeUser: Boolean, captionUser: String, diUser: Long, firstNameUser: Array[String], groupUser: Long, lastNameUser: String, loginUser: String, passwordUser: String, secondNameUser: Array[String], diUserGroup: Long, captionGroupUserGroup: Array[String], codeGroupUserGroup: String) =>
                        _data += JsonObject(
                            "di" -> diUser,
                            "login" -> loginUser,
                            "firstName" -> arrayString2OptionJsonString(firstNameUser),
                            "secondName" -> arrayString2OptionJsonString(secondNameUser),
                            "lastName" -> lastNameUser,
                            "caption" -> captionUser,
                            "password" -> passwordUser,
                            "active" -> activeUser ,
                            "group" -> groupUser,
                            "codeGroup" -> codeGroupUserGroup,
                            "captionGroup" -> arrayString2OptionJsonString(captionGroupUserGroup)
                        )
                }

                logger debug s"_data: ${newLine + _data.toPrettyString}"
            }
            case Failure(e) =>
                throw e
        }


        Close()
    }

    /*test("2"){
            println(TextMatchStyle.getObject("substring").toSQL)
        }*/
}
