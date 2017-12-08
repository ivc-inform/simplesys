package test

import java.io.File

import com.simplesys.slick.oracle.OracleSlick
import com.simplesys.common.Strings._
import org.scalatest.FunSuite
import slick.dbio.{DBIOAction, Effect, NoStream}
import slick.jdbc.meta.MQName
import slick.model.{Column, Table}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.codegen.SourceCodeGenerator
import slick.{model ⇒ m}

class TestSuit extends FunSuite with OracleSlick {
    test("1") {
        val driver = slick.jdbc.OracleProfile
        val url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl"

        val user = "temp"
        val password = "temp"

        val generator: m.Model => SourceCodeGenerator = { (model: m.Model) =>
            new SourceCodeGenerator(model) {
                override def code =
                    "import com.simplesys.slick.oracle.time._".newLine +
                      "import java.time.LocalDateTime".newLine +
                      super.code

                override def Table = new Table(_) {
                    override def Column = new Column(_) {
                        override def rawType = model.tpe match {
                            case "java.sql.Timestamp" => "LocalDateTime" // kill j.s.Timestamp
                            case _ =>
                                super.rawType
                        }
                    }
                }
            }
        }

        //val dbb = OracleSlick.getDataBaseConfig(url = "jdbc:oracle:thin:@//dev.db-support.ru:1521/orcl", user = "temp", password = "temp").db
        val database = driver.api.Database.forURL(url = url, user = user, password = password, driver = "oracle.jdbc.OracleDriver")

        try {
            database.source.createConnection().close()
        } catch {
            case e: Throwable =>
                throw new RuntimeException("Failed to run slick-codegen: " + e.getMessage, e)
        }

        println(s"Generate source code with slick-codegen: url=${url}, user=${user}")

        val tables = driver.defaultTables

        val driverClassName = driver.getClass.getName
        val profile = {
            // if it's a singleton object, then just reference it directly
            if (driverClassName.endsWith("$")) driverClassName.stripSuffix("$")
            // if it's an instance of a regular class, we don't know constructor args; try the no-arguments constructor and hope for the best
            else s"new $driverClassName()"
        }

        val pkg = "com.model"
        val outputDir = new File(".").getAbsolutePath
        val fileName = "Tables.scala"

        val dbio = for {
            m <- driver.createModel(Some(tables))
        } yield generator(m).writeToFile(
            profile = profile,
            folder = outputDir,
            pkg = pkg,
            container = "Tables",
            fileName = fileName)

        Await.result(database.run(dbio), Duration.Inf)
        database.shutdown
        val generatedFile = outputDir + "/" + pkg.replaceAllLiterally(".", "/") + "/" + fileName
        println(s"Source code has generated in ${generatedFile}")
    }
}
