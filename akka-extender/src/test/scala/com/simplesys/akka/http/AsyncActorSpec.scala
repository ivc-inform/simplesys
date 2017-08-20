/*
package com.simplesys.akka.http

import org.specs2.mock.Mockito
import org.specs2.specification.Scope
import org.specs2.mutable.Specification
import Listener._
import Async._
import Endpoints._
import akka.testkit.{TestActorRef, TestFSMRef, TestKit}
import akka.actor.{Actor, ActorSystem}
import com.simplesys.servlet.http.{HttpServletResponse, HttpServletRequest}
import com.simplesys.servlet.http.HttpServletResponse._
import com.simplesys.servlet.{ServletContext, AsyncEvent}

class AsyncActorSpec extends Specification with Mockito {

    abstract class HttpContext extends TestKit(ActorSystem()) with Scope {

        val asyncContext = AsyncContextMock()

        var actorRef: TestFSMRef[State, Data, AsyncActor] = null

        lazy val endpointActor = TestActorRef(factory = new Actor {
            def receive = {
                case req: HttpServletRequest => sender ! Complete(FutureResponse {
                    _ =>
                })
            }
        })

        def asyncEventMessage(on: On_Event) = AsyncEventMessage(new AsyncEvent(asyncContext, new Exception), on)

        def start(e: Endpoint) {
            start(Some(e))
        }

        def start(e: Option[Endpoint] = None) {
            val endpoints = new EndpointFinder {
                def find(uri: String) = e
                def findMap(uri: String) = e
            }

            val servletContext = mock[ServletContext]

            actorRef = TestFSMRef(new AsyncActor(endpoints, servletContext))
            actorRef.stateName mustEqual Processing
            actorRef.stateData mustEqual Empty
            actorRef ! asyncContext
        }

        def res = asyncContext.Response
    }

    "AsyncActor" should {
        "look for defined endpoint for current request when started" >> new HttpContext {
            start()
            there was one(asyncContext).Complete()
            actorRef.isTerminated must beTrue
        }
        "pass processing scope to actor" >> new HttpContext {
            start(EndpointActor(endpointActor))
            there was one(asyncContext).Complete()
            actorRef.isTerminated must beTrue
        }
        "stop self on Error event" >> new HttpContext {
            start()
            actorRef ! asyncEventMessage(On_Error)
            actorRef.isTerminated must beTrue
        }
        "stop self on Complete event" >> new HttpContext {
            start()
            actorRef ! asyncEventMessage(On_Complete)
            actorRef.isTerminated must beTrue
        }
        "stop self on Timeout event" >> new HttpContext {
            var called = false

            val endpoint = RequestResponse {
                req =>
                    actorRef ! asyncEventMessage(On_Timeout)
                    FutureResponse(_ => called = true)
            }

            start(endpoint)

            actorRef.isTerminated must beTrue
            called must beFalse
        }
        "response if async not completed" >> new HttpContext {
            var called = false
            start(Endpoint(_ => FutureResponse(_ => called = true)))
            there was one(asyncContext).Complete()
            called must beTrue
        }
        "not response if async already completed" >> new HttpContext {
            var called = false

            def func(req: HttpServletRequest) = {
                actorRef ! asyncEventMessage(On_Timeout)
                FutureResponse {
                    _ => called = true
                }
            }

            start(func _)
            there was no(asyncContext).Complete()
            called must beFalse
        }
        "response with 404 when no endpoint found" >> new HttpContext {
            start()
            there was one(res).toHttpServletResponse.Status_=(ScNotFound)
        }
        "response with 'Status Code 500' when exception while processing request" >> new HttpContext {
            start(RequestResponse(req => throw new Exception))
            there was one(res).toHttpServletResponse.Status_=(ScInternalServerError)
            there was one(asyncContext).Complete()
        }
        "response with 'Status Code 500' when exception while responding" >> new HttpContext {
            start(RequestResponse(FutureResponse {
                res => throw new Exception
            }))
            there was one(res).toHttpServletResponse.SendError(ScInternalServerError, null)
            there was one(asyncContext).Complete()
        }
        "call `onComplete` with None if completed successfully" >> new HttpContext {
            var result = false
            val future = new FutureResponse {
                def apply(res: HttpServletResponse) {}

                def onComplete = {
                    case None => result = true
                }
            }
            start(RequestResponse(future))
            there was one(asyncContext).Complete()
            result must beTrue
        }
        "call `onComplete` with Some(Exception) if completed unsuccessfully" >> new HttpContext {
            asyncContext.Complete() throws (new RuntimeException)

            var result = true

            val future = new FutureResponse {
                def apply(res: HttpServletResponse) {}

                def onComplete = {
                    case Some(_: RuntimeException) => result = false
                }
            }

            start(RequestResponse(future))

            there was one(asyncContext).Complete()
            result must beFalse
        }
    }
}*/
