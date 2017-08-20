import com.simplesys.log.Logging
import junit.framework.TestSuite

class TestSuit extends TestSuite with Logging {
  def test {
    logger debug ("Debug message")
  }
}