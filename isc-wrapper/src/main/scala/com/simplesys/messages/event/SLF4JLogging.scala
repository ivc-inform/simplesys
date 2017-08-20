package com.simplesys.messages.event

import akka.event.Logging._
import akka.event.slf4j.Logger
import com.simplesys.akka.http.sse._
import com.simplesys.json.{JsonList, JsonString}
import com.simplesys.messages.Message
import com.simplesys.common.Strings._

class Slf4jLogger extends akka.event.slf4j.Slf4jLogger with StdOutLogger {

    import com.simplesys.messages.ActorConfig._

    private val errorFormat = """<span class="error">[ERROR]</span> <span class="errorTimeStamp">[%s]</span> <span class="errorThreadName">[%s]</span> <span class="errorLogSource">[%s]</span> <span class="errorMessge">%s</span> <span class="errorCause">%s</span>"""
    private val errorFormatWithoutCause = """<span class="error">[ERROR]</span> <span class="errorTimeStamp">[%s]</span> <span class="errorThreadName">[%s]</span> <span class="errorLogSource">[%s]</span> <span class="errorMessge">%s</span>"""
    private val warningFormat = """<span class="warning">[WARNING]</span> <span class="warningTimeStamp">[%s]</span> <span class="warningThreadName">[%s]</span> <span class="warningLogSource">[%s]</span> <span class="warningMessge">%s</span>"""
    private val infoFormat = """<span class="info">[INFO]</span> <span class="infoTimeStamp">[%s]</span> <span class="infoThreadName">[%s]</span> <span class="infoLogSource">[%s]</span> <span class="infoMessge">%s</span>"""
    private val debugFormat = """<span class="debug">[DEBUG]</span> <span class="debugTimeStamp">[%s]</span> <span class="debugThreadName">[%s]</span> <span class="debugLogSource">[%s]</span> <span class="debugMessge">%s</span>"""


    def getError(event: Error): Unit = {
        withMdc(event.logSource, event) {
            event.cause match {
                case Error.NoCause | null ⇒
                    Logger(event.logClass, event.logSource).error(if (event.message != null) event.message.trimChannelTail else null)

                case _ ⇒
                    Logger(event.logClass, event.logSource).error(if (event.message != null) event.message.trimChannelTail else event.cause.getLocalizedMessage, event.cause)
            }
        }
    }

    def getWarning(event: Warning): Unit =
        withMdc(event.logSource, event) {
            Logger(event.logClass, event.logSource).warn("{}", event.message.trimChannelTail.asInstanceOf[AnyRef])
        }

    def getInfo(event: Info): Unit =
        withMdc(event.logSource, event) {
            Logger(event.logClass, event.logSource).info("{}", event.message.trimChannelTail.asInstanceOf[AnyRef])
        }

    def getDebug(event: Debug): Unit =
        withMdc(event.logSource, event) {
            Logger(event.logClass, event.logSource).debug("{}", event.message.trimChannelTail.asInstanceOf[AnyRef])
        }

    private def sendMessage(list: JsonList, strMessage: String) {
        val channels: Set[String] = list.map {
            case JsonString(str) => str.unQuoted
            case x => throw new RuntimeException(s"Bad branch $x")
        }.toSet

        if (channels.size > 0)
            SendMessage(Message(id = "", event = None, data = strMessage, channels = channels))
    }

    override def receive = {

        case event@Error(cause, logSource, logClass, message) ⇒
            getChannelsList(message) match {
                case list: JsonList if list.size > 0 =>
                    val f: String = if (event.cause == Error.NoCause) errorFormatWithoutCause else errorFormat

                    val strMessage = f.format(
                        timestamp(event),
                        event.thread.getName,
                        event.logSource,
                        getWithoutChannels(event.message.trimChannelTail),
                        stackTraceFor(event.cause))

                    getError(event)
                    sendMessage(list, strMessage)

                case _ =>
                    getError(event)
            }


        case event@Warning(logSource, logClass, message) ⇒
            getChannelsList(message) match {
                case list: JsonList if list.size > 0 =>
                    val strMessage = warningFormat.format(
                        timestamp(event),
                        event.thread.getName,
                        event.logSource,
                        getWithoutChannels(event.message.trimChannelTail))

                    getWarning(event)
                    sendMessage(list, strMessage)

                case _ =>
                    getWarning(event)
            }


        case event@Info(logSource, logClass, message) ⇒
            getChannelsList(message) match {
                case list: JsonList if list.size > 0 =>
                    val strMessage = infoFormat.format(
                        timestamp(event),
                        event.thread.getName,
                        event.logSource,
                        getWithoutChannels(event.message.trimChannelTail))

                    getInfo(event)
                    sendMessage(list, strMessage)

                case _ =>
                    getInfo(event)
            }

        case event@Debug(logSource, logClass, message) ⇒
            getChannelsList(message) match {
                case list: JsonList if list.size > 0 =>
                    val strMessage = debugFormat.format(
                        timestamp(event),
                        event.thread.getName,
                        event.logSource,
                        getWithoutChannels(event.message.trimChannelTail))

                    getDebug(event)
                    sendMessage(list, strMessage)

                case _ =>
                    getDebug(event)
            }

        case InitializeLogger(_) ⇒
            log.info("Slf4jLogger started")
            sender() ! LoggerInitialized
    }
}
