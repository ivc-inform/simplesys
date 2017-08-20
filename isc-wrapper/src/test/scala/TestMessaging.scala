import akka.actor.ActorSystem
import com.simplesys.config.Config
import com.simplesys.json.Json
import com.simplesys.log.Logging
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class TestMessaging extends FunSuite with Logging with BeforeAndAfterAll with Config {
    implicit private var actorSystem: ActorSystem = _

    test("GetChannel") {
        val a = Json( """{
                        |    "channel1402505360231":{
                        |        "data":{
                        |            "subscriberName":"E88F6733-C984-6CB0-081F-50A49361421C"
                        |        }
                        |    }
                        |}""".stripMargin)
        a
    }

    /*test("Create Dispatcher") {
        val actor = actorSystem.actorOf(LocalMessageDispatcher.props(new ISCDispatchNotify), name = getString("messaging.dispatcher-name"))
        actor ! TestMessage("This is actor by ActorRef.")
        val aaa1 = actorSystem.actorSelection("/user/" + getString("messaging.dispatcher-name"))
        aaa1 ! TestMessage("This is actor by Selection.")
        val aaa2 = actorSystem.actorSelection("/user/" + getString("messaging.dispatcher-name"))
        aaa2 ! TestMessage("This is actor by Selection - 2.")
        /*implicit val timeOut = Timeout(5 second)
        val aaa2 = aaa1.resolveOne.onComplete{
            val aaaa = actor === aaa2
        }*/

        val actor1 = actorSystem.actorOf(LocalMessageDispatcher.props(new ISCDispatchNotify), name = "akka.messages.dispatcher-name")
        val a = 0
    }*/

    override protected def beforeAll() {
        actorSystem = ActorSystem("TestActorSystem")
    }

    override protected def afterAll() {
        actorSystem.shutdown()
        actorSystem.awaitTermination()
    }
}