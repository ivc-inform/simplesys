import akka.actor.ActorSystem
import com.simplesys.config.Config
import org.scalatest.{BeforeAndAfter, FunSuite}

class TestAkka extends FunSuite with Config with BeforeAndAfter{
    val system = ActorSystem(getString("akka.http.system-name"))


    test("CreateChild") {

    }

    /*override protected def after(fun: => Any){
      system.shutdown()
      system.awaitTermination()
    }*/


}
