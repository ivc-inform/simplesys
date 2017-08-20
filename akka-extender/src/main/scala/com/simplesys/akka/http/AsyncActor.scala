package com.simplesys.akka.http

import akka.actor.{Actor, ActorRef, LoggingFSM, Props}
import com.simplesys.akka.http.Async._
import com.simplesys.akka.http.Endpoints._
import com.simplesys.akka.http.sse.SseFutureResponse
import com.simplesys.servlet.http.HttpServletResponse.ScInternalServerError
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.servlet.{AsyncContext, ServletContext}
import com.simplesys.akka.http.sse._

object AsyncActor {
    def props(endpoints: EndpointFinder, servletContext: ServletContext): Props = Props(new AsyncActor(endpoints, servletContext))
}

class AsyncActor(val endpoints: EndpointFinder, val servletContext: ServletContext) extends LoggingFSM[State, Data] {
    implicit val system = context.system

    startWith(Processing, Empty)

    def tryo(func: => Unit)(onException: Exception => Unit): Option[Throwable] = {
        try {
            func
            None
        } catch {
            case e: Exception =>
                onException(e)
                Some(e)
        }
    }

    def safeComplete(async: AsyncContext, uri: String) =
        tryo(async.Complete())(e => log.error(e, s"{} while completing async for uri:'{}' {}", e.getClass.getSimpleName, uri, e.getMessage))

    def safeResponse(future: FutureResponse, response: HttpServletResponse, uri: String): Option[Throwable] = tryo(future(response)) {
        e =>
            log.error(e, s"{} while responding for uri:'{}': {}", e.getClass.getSimpleName, uri, e.getMessage)
            response.SendError(ScInternalServerError, e.getMessage)
    }

    def sSesafeResponse(future: SseFutureResponse, response: SseServletResponse, uri: String): Option[Throwable] = tryo(future(response)) {
        e =>
            log.error(e, "{} while responding for uri:'{}': {}", e.getClass.getSimpleName, uri, e.getMessage)
            response.SendError(ScInternalServerError, e.getMessage)
    }

    when(Processing) {
        case Event(async: AsyncContext, Empty) =>
            async.AddListener(new Listener(self))

            log.debug(s"Processing async for servletContext.ContextPath:'{}'", servletContext.ContextPath)

            val uri =
                async.Request match {
                    case res: SseServletRequest => res.RequestURI.replace(servletContext.ContextPath, "/")
                    case res: HttpServletRequest => res.RequestURI.replace(servletContext.ContextPath, "/")
                }

            log.debug(s"Processing async for uri:'{}'", uri)

            def go2EndPoint(endpoint: Endpoint): State = {
                val ctx = Context(async, uri)

                endpoint match {
                    case EndpointFunc(func) =>
                        log.debug(s"Processing EndpointFunc for uri:'{}'", uri)
                        safeProcess(func, ctx)
                        goto(Completing) using ctx

                    case SseEndpointFunc(func) =>
                        log.debug(s"Processing EndpointFunc for uri:'{}'", uri)
                        sSesafeProcess(func, ctx)
                        goto(Completing) using ctx

                    case EndpointActor(actor) =>
                        log.debug(s"Passing async processing scope to endpoint actor for uri:'{}'", uri)
                        async.Request match {
                            case res: SseServletRequest => sSesafeProcess(actor, ctx)
                            case res: HttpServletRequest => safeProcess(actor, ctx)
                        }
                        goto(Completing) using ctx
                }
            }

            go2EndPoint(
                endpoints.find(uri) match {
                    case Some(e) => e
                    case None => NotFound(uri)
                }
            )
    }

    when(Completing) {
        case Event(Complete(future), Context(async, uri)) =>
            log.debug(s"Completed async for uri:'{}'", uri)

            future.onComplete.lift(safeResponse(future, HttpServletResponse(async.Response), uri) match {
                case None => safeComplete(async, uri)
                case some => some
            })

            stop()

        case Event(SseComplete(future), Context(async, uri)) =>
            log.debug("Sse Completed sse async for uri:'{}'", uri)

            future.onComplete.lift(sSesafeResponse(future, SseServletResponse(async.Response), uri) match {
                case None => safeComplete(async, uri)
                case some => some
            })

            stop()

        case Event(CompleteAsk(future), Context(async, uri)) =>
            log.debug("Completed async ask for uri:'{}'", uri)

            future.onComplete.lift(safeResponse(future, HttpServletResponse(async.Response), uri) match {
                case None => None
                case some => some
            })
            stop()

        case Event(SseCompleteAsk(future), Context(async, uri)) =>
            log.debug("Completed sse async ask for uri:'{}'", uri)

            future.onComplete.lift(sSesafeResponse(future, SseServletResponse(async.Response), uri) match {
                case None => None
                case some => some
            })
            stop()
    }

    import com.simplesys.akka.http.Listener._

    whenUnhandled {
        case Event(AsyncEventMessage(_, On_StartAsync), _) => stay()
        case Event(AsyncEventMessage(_, _: On_EndAsync), _) => stop()
    }

    initialize

    def InternalErrorOnException(uri: String): PartialFunction[Throwable, Unit] = {
        case e: Exception =>
            log.error(e, "{} while serving request for uri:'{}': {}", e.getClass.getSimpleName, uri, e.getMessage)
            self ! Complete(FutureResponse(ScInternalServerError, e.getMessage))
    }

    def SseInternalErrorOnException(uri: String): PartialFunction[Throwable, Unit] = {
        case e: Exception =>
            log.error(e, "{} while serving request for uri:'{}': {}", e.getClass.getSimpleName, uri, e.getMessage)
            self ! SseComplete(SseFutureResponse(ScInternalServerError, e.getMessage))
    }

    def safeProcess(endpoint: Request2FutureResponse, async: Context) {
        try
            self ! Complete(endpoint(HttpServletRequest(async.context.Request)))
        catch
            InternalErrorOnException(async.uri)
    }

    def sSesafeProcess(endpoint: Request2SseFutureResponse, async: Context) {
        try
            self ! SseComplete(endpoint(SseServletRequest(async.context.Request)))
        catch
            InternalErrorOnException(async.uri)
    }

    def safeProcess(actor: ActorRef, asyncContext: Context) {
        try
            actor ! HttpServletRequest(asyncContext.context.Request)
        catch
            InternalErrorOnException(asyncContext.uri)
    }

    def sSesafeProcess(actor: ActorRef, asyncContext: Context) {
        try
            actor ! SseServletRequest(asyncContext.context.Request)
        catch
            InternalErrorOnException(asyncContext.uri)
    }
}

object Async {
    sealed trait State
    case object Processing extends State
    case object Completing extends State
    case object Completed extends State

    sealed trait Data
    case class Context(context: AsyncContext, uri: String) extends Data
    case object Empty extends Data

    sealed trait Opers
    case class Complete(func: FutureResponse) extends Opers
    case class SseComplete(func: SseFutureResponse) extends Opers

    case class CompleteAsk(func: FutureResponse) extends Opers
    case class SseCompleteAsk(func: SseFutureResponse) extends Opers
}