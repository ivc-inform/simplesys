/*
package com.simplesys.akka.http

import org.specs2.mutable.Specification

class AkkaHttpServletSpec extends Specification {

    args(sequential = true)

    lazy val servlet = new AkkaHttpPartialServlet

    "AkkaHttpServlet" should {

        "create ActorSystem and EndpointAgent on init" >> {
            servlet.httpSystem must beNone
            servlet.Init()
            servlet.httpSystem must beSome
        }

        "create actor for each request" >> {
            val limit = 1
            (0 to limit).foreach {
                _ =>
                    val async = AsyncContextMock()
                    servlet.Service(async.Request.toHttpServletRequest, async.Response.toHttpServletResponse)
            }
            success
        }

        "shutdown ActorSystem on destroy" >> {
            servlet.httpSystem must beSome
            val (system, _) = servlet.httpSystem.get
            servlet.destroy()
            system.awaitTermination()
            system.isTerminated must beTrue
            servlet.httpSystem must beNone
        }
    }
}
*/
