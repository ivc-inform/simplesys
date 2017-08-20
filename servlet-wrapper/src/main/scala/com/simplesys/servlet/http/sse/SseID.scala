package com.simplesys.servlet.http.sse

abstract class SseID {
    def serrialize: String
    override def toString = serrialize
}

case class SseStringID(id: String) extends SseID {
    override def serrialize: String = id
}
