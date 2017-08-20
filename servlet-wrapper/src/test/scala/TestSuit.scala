import com.simplesys.log.Logging
import com.simplesys.servlet.{HTMLContent, Content}
import org.scalatest.FunSuite

import scala.io.Codec._

class TestSuit extends FunSuite with Logging{
  test("Codec"){
      //val c = Content.getObject("text/html; charset=UTF-8")
      //val c = Content.getObject("text/html")
      //val c = Content.getObject("charset=UTF-8")
      val c = HTMLContent + ISO8859
      logger debug c.toString()
  }
}