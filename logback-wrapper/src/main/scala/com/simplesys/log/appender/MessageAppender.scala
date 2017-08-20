package com.simplesys.log.appender

import java.io.OutputStream

import ch.qos.logback.core.UnsynchronizedAppenderBase

import scala.collection.mutable


class MessageAppender extends OutputStream {
    private val buffer = new StringBuilder

    override def write(b: Int) {
        buffer append b.toChar
    }

    override def toString: String = buffer.toString()
}