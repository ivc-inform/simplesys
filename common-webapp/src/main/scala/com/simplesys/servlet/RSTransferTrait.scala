package com.simplesys.servlet

import akka.actor.Actor
import akka.actor.Props
import com.simplesys.akka.http.Async.{CompleteAsk, SseCompleteAsk}
import com.simplesys.akka.http.sse.SseFutureResponse
import com.simplesys.akka.http.{AkkaHttpMapServlet, DynamicEndpoints, FutureResponse}
import com.simplesys.annotation.RSTransfer
import com.simplesys.log.Logging
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}

import scala.reflect.ClassTag
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

trait RSTransferTrait {

    this: AkkaHttpMapServlet with DynamicEndpoints with Logging =>

    import com.simpesys.reflect.runtime.universe.ReflectionHelpers._

    def registerRSTransfer[C <: ServletActor : TypeTag : ClassTag]: Unit = {
        getAnnotation[C, RSTransfer] match {
            case None =>
            case Some(annotation) =>
                annotation.tree.children.tail match {
                    case head :: Nil =>
                        head match {
                            case Literal(Constant(path: String)) =>
                                (providerMap get path) match {
                                    case None =>
                                        val actor = actorSystem.actorOf(Props(new Actor {
                                            def receive = {
                                                case request: SseServletRequest => {
                                                    val future = SseFutureResponse {
                                                        response: SseServletResponse =>
                                                            context.actorOf(Props(implicitly[ClassTag[C]].runtimeClass, request, response, servletContext)) ! GetData
                                                    }
                                                    sender ! SseCompleteAsk(future)
                                                }
                                                case request: HttpServletRequest => {
                                                    val future = FutureResponse {
                                                        response: HttpServletResponse =>
                                                            context.actorOf(Props(implicitly[ClassTag[C]].runtimeClass, request, response, servletContext)) ! GetData
                                                    }
                                                    sender ! CompleteAsk(future)
                                                }
                                            }
                                        }))

                                        providerMap += path -> actor
                                    case _ =>
                                        logger warn (s"Actor with path '$path' already exists.")
                                }
                        }
                    case x =>
                        throw new RuntimeException(s"Bad branch $x")
                }
        }
    }
}
