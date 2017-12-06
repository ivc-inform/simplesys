package com.simplesys.akka.http

import com.simplesys.common.Strings._
import io.circe.Json
import io.circe.Json._

package object sse {
    val marker = "@@@channels:"

    def getChannelsList(message: Any): Vector[Json] = {
        message match {
            case message: String => getChannelsList(message)
            case _ => Vector.empty
        }
    }

    def getChannelsList(message: String): Vector[Json] = {
        def array: Vector[Json] = message.substring(message.indexOf(marker) + marker.length + 1, message.length - 1).split(",").map { case x: String => fromString(x.trim)}.toVector
        if (message.indexOf(marker) == -1) Vector.empty else array
    }

    def getWithoutChannels(message: Any): String = {
        message match {
            case message: String => getWithoutChannels(message)
            case _ => strEmpty
        }
    }

    def getWithoutChannels(message: String): String = {
        val pos = message.indexOf(marker)
        if (pos > -1)
            message.substring(0, pos)
        else
            message
    }

    implicit class AnyOpts(val string: Any) {
        def trimChannelTail:String = {
            string match {
                case string: String =>
                    val index = string.indexOf(marker)
                    if (index > -1)
                        string.substring(0, index)
                    else
                        string
                case _ => strEmpty
            }
        }
    }

    implicit class StringOpts(val string: String) {
        private def toChannels(channels: String*): String = s"${marker}[${channels.mkString(",")}]"
        def append2Channels(implicit channels: String*): String = string + toChannels(channels: _*)
        def append2Channel(implicit channel: String): String = string + toChannels(channel)
    }
}
