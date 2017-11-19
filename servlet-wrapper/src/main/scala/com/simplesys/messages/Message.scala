package com.simplesys.messages

import com.simplesys.log.Logging
import com.simplesys.servlet.http.sse.{SseChannel, SseEvent, SseID}
import io.circe.Json
import io.circe.Json._

object Message {
    def apply(data: Json, channels: String*) = new Message(id = "", data = data, channels = channels.toSet, event = None)
    def apply(channels: String*) = new Message(id = "", data = arr(), channels = channels.toSet, event = None)
    def apply(id: String, data: Json) = new Message(id = id, data = data, channels = Set.empty[String], event = None)
}

object MessageExt {
    def apply(data: Json, channels: SseChannel*) = new Message(id = "", data = data, channels = channels.map(_.serrialize).toSet, event = None)
    def apply(channels: SseChannel*) = new Message(id = "", data = arr(), channels = channels.map(_.serrialize).toSet, event = None)
    def apply(id: SseID, data: Json) = new Message(id = id.serrialize, data = data, channels = Set.empty[String], event = None)
}

case class Message(id: String, data: Json, channels: Set[String], event: Option[SseEvent]) extends Logging {

    override def toString: String = s"MESSAGE::: nextID: ${id} data: ${data.spaces4} channels: ${channels.mkString(",")} event: ${event.map(_.toString).mkString}"

    def log {
        logger debug toString
    }
}
