/*
import akka.actor.ActorSystem
import com.simplesys.akka.messaging.MessageId
import com.simplesys.log.Logging
import org.scalatest.WordSpec
import org.specs2.mutable._

class HelloWorldSpec extends WordSpec with Logging {

    implicit val actorSystem = ActorSystem(this.getClass.getSimpleName)

    "The 'Hello world' string" should {
        "contain 11 characters" in {
            "Hello world" must have size (11)
        }
        "start with 'Hello'" in {
            "Hello world" must startWith("Hello")
        }
        "end with 'world'" in {
            "Hello world" must endWith("world")
        }
    }

    "test SSMessage" in {
        val messageId = new MessageId()

        for (i <- 0 to 10000)
            logger debug messageId.getId()

        actorSystem.shutdown()
    }


}*/
