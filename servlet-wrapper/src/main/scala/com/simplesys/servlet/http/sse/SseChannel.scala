package com.simplesys.servlet.http.sse

abstract class SseChannel {
    def serrialize: String
    override def toString = serrialize
}

case class SseStringChannel(channel: String) extends SseChannel {
    override def serrialize: String = channel
}