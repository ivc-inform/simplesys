package com.simplesys.messages.event

import com.simplesys.servlet.http.sse.SseEvent

case object ConnectTerminateEvent extends SseEvent {
    override def serrialize: String = "connectTerminate"
}