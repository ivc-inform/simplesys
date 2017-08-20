package com.simplesys.messages

import com.simplesys.json.{JsonObject, JsonElement, JsonList}
import com.simplesys.log.{Logging, Logger}
import com.simplesys.servlet.http.sse.{SseID, SseChannel, SseEvent}

object Message {
    def apply(data: JsonElement, channels: String*) = new Message(id = "", data = data, channels = channels.toSet, event = None)
    def apply(channels: String*) = new Message(id = "", data = JsonObject(), channels = channels.toSet, event = None)
    def apply(id: String, data: JsonElement) = new Message(id = id, data = data, channels = Set.empty[String], event = None)
}

object MessageExt {
    def apply(data: JsonElement, channels: SseChannel*) = new Message(id = "", data = data, channels = channels.map(_.serrialize).toSet, event = None)
    def apply(channels: SseChannel*) = new Message(id = "", data = JsonObject(), channels = channels.map(_.serrialize).toSet, event = None)
    def apply(id: SseID, data: JsonElement) = new Message(id = id.serrialize, data = data, channels = Set.empty[String], event = None)
}

case class Message(id: String, data: JsonElement, channels: Set[String], event: Option[SseEvent]) extends Logging {

    override def toString: String = s"MESSAGE::: nextID: ${id} data: ${data.toPrettyString} channels: ${channels.mkString(",")} event: ${event.map(_.toString).mkString}"

    def log {
        logger debug toString
    }
}