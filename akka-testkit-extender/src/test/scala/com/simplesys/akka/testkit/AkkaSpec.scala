package com.simplesys.akka.testkit

import akka.actor.{Actor, Props, ActorSystem}
import akka.testkit.TestKit
import org.scalatest.matchers.MustMatchers
import com.typesafe.config.{ConfigFactory, Config}
import java.util.concurrent.TimeoutException
import akka.event.Logging
import org.scalatest.{BeforeAndAfterAll, WordSpec, Tag}
import akka.dispatch.Dispatchers


class AkkaSpec(_system: ActorSystem) extends TestKit(_system) with WordSpec with MustMatchers with BeforeAndAfterAll {
  def this(config: Config) = this(ActorSystem(AkkaSpec.getCallerName(getClass), ConfigFactory.load(config.withFallback(AkkaSpec.testConf))))

  def this(s: String) = this(ConfigFactory.parseString(s))

  def this(configMap: Map[String, AnyRef]) = this(AkkaSpec.mapToConfig(configMap))

  def this() = this(ActorSystem(AkkaSpec.getCallerName(getClass), AkkaSpec.testConf))

  val logger = Logging(system, this.getClass)

  final override protected def beforeAll {
    atStartup()
  }


  override protected def afterAll {
    beforeShutdown()
    system shutdown()
    try
      system.awaitTermination(timeout = 5 second)
    catch {
      case _: TimeoutException =>
        logger warning("Failed to stop [{}] within 5 seconds", system.name)
      //println(system.asInstanceOf[ActorSystemImpl].printTree)
    }
    atTermination()
  }

  protected def atStartup() {}

  protected def beforeShutdown() {}

  protected def atTermination() {}

  def spawn(dispatcherId: String = Dispatchers.DefaultDispatcherId)(body: => Unit) {
    system.actorOf(Props(new Actor {
      def receive = {
        case "go" =>
          try
            body
          finally
            context.stop(context.self)
      }
    }).withDispatcher(dispatcherId)) ! "go"
  }
}

object TimingTest extends Tag("timing")

object LongRunningTest extends Tag("long-running")

object AkkaSpec {
  val testConf = ConfigFactory.parseString( """
      akka {
        event-handlers = ["akka.testkit.TestEventListener"]
        loglevel = debug
        stdout-loglevel = debug
        actor {
          default-dispatcher {
            executor = "fork-join-executor"
            fork-join-executor {
              parallelism-min = 8
              parallelism-factor = 2.0
              parallelism-max = 8
            }
          }
          debug {
            fsm = on
            receive = on
            autoreceive = on
            lifecycle = on
          }
        }
      }""")

  def mapToConfig(map: Map[String, AnyRef]): Config = {
    import scala.collection.JavaConverters._
    ConfigFactory.parseMap(map.asJava)
  }

  def getCallerName(clazz: Class[_]): String = {
    val s = Thread.currentThread.getStackTrace map (_.getClassName) drop 1 dropWhile (_ matches ".*AkkaSpec.?$")
    val reduced = s.lastIndexWhere(_ == clazz.getName) match {
      case -1 => s
      case z => s drop (z + 1)
    }
    reduced.head.replaceFirst( """.*\.""", "").replaceAll("[^a-zA-Z_0-9]", "_")
  }
}

