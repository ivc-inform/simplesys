package com.simplesys.common
package concurrent


import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}
import com.simplesys.log.Logging
import scala.util.{Success, Failure}
import scala.concurrent.{ExecutionContext, Await}
import scala.concurrent.duration.Duration
import java.util.concurrent.Executors


class TestFuture extends WordSpec with Logging with Matchers with BeforeAndAfterAll {
  val pool = Executors.newCachedThreadPool()
  implicit val execCtx = ExecutionContext.fromExecutorService(pool)

  override def afterAll {
    execCtx.shutdown()
  }

  "test FutureEx ok" in {
    val fx = FutureEx.interruptable {
      var a = 5
      println(a)
      Thread.sleep(10000)
      a += 95
      println(a)
      a
    }

    fx onComplete {
      case Success(x) => println(s"future completed, wow! $x")
      case Failure(ex) => println(s"future interrupted, exception ${ex.toString}")
    }

    Thread.sleep(12000)
  }

  "test FutureEx interrupt" in {
    val fx = FutureEx.interruptable {
      var a = 5
      println(a)
      Thread.sleep(10000)
      a += 95
      println(a)
      a
    }

    fx onComplete {
      case Success(x) => println(s"future completed, wow! $x")
      case Failure(ex) => println(s"future interrupted, exception ${ex.toString}")
    }

    Thread.sleep(5000)
    fx.interrupt
  }

  "test FutureEx cancellabe ok" in {
    val fx = FutureEx.cancellable[String] {future =>
      var i = 4
      while (!future.isCompleted && i > 0) {
        println(i)
        i -= 1
        Thread.sleep(3000)
      }
      "fffffffututture!"
    }

    fx onComplete {
      case Success(x) => println(s"future completed, wow! $x")
      case Failure(ex) => println(s"future cancelled, exception ${ex.toString}")
    }

    Thread.sleep(13000)
  }

  "test FutureEx cancellabe cancel" in {
    val fx = FutureEx.cancellable[String] {future =>
      var i = 4
      while (!future.isCompleted && i > 0) {
        println(i)
        i -= 1
        Thread.sleep(3000)
      }
      "fffffffututture!"
    }

    fx onComplete {
      case Success(x) => println(s"future completed, wow! $x")
      case Failure(ex) => println(s"future cancelled, exception ${ex.toString}")
    }

    Thread.sleep(5000)
    fx.cancel
  }

}
