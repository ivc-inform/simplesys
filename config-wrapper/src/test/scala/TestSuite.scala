import com.simplesys.common.URLBox
import com.simplesys.config.Config
import com.simplesys.log.Logging
import com.typesafe.config.ConfigObject
import org.scalatest.FunSuite

class TestSuite extends FunSuite with Logging with Config {
    test("Config") {

        import scala.collection.JavaConverters._

        URLBox.getResource("application.conf") match {
            case URLBox(Some(url), message) =>

                val a: ConfigObject = getObject("bonecp-config-stack.bonecp-config-postgreEnzo")
                logger.debug(s"a = ${a.asScala.foreach(k => logger.debug(s"${k._1}=${k._2.unwrapped()}"))}")

            case URLBox(None, message) =>
                logger.debug(message)
        }
    }

    test("topology") {
        logger debug s"topology.node-id: ${getInt("node-id")}"
        logger debug s"topology.seq-cash: ${getInt("topology.seq-cash")}"
    }

    test("Config with path") {

    }

}
