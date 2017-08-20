package com.simplesys.servlet.http.sse

abstract class SseEvent {
    def serrialize: String
    override def toString = serrialize
}