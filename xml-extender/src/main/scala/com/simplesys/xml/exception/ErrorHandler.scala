package com.simplesys.xml.exception

import org.xml.sax.{ErrorHandler => SErrorHandler, SAXParseException}
import scala.collection.mutable.ArrayBuffer
import com.simplesys.common.Strings._

class ErrorHandler extends SErrorHandler {
    private val buf = ArrayBuffer.empty[(String, String, String)]

    implicit class ThrowOpts(`throw`: SAXParseException) {

        import scala.compat.Platform.EOL

        def getStackTraceString = `throw`.getStackTrace().mkString("", EOL, EOL)
    }

    def fatalError(exception: SAXParseException) {
        addFatalError(exception)
    }

    def error(exception: SAXParseException) {
        addError(exception)
    }

    def warning(exception: SAXParseException) {
        addWarning(exception)
    }

    private def addWarning(`throw`: SAXParseException) {
        buf += (("warning", `throw`.getMessage, `throw`.getStackTraceString))
    }

    private def addError(`throw`: SAXParseException) {
        buf += (("error", `throw`.getMessage, `throw`.getStackTraceString))
    }

    private def addFatalError(`throw`: SAXParseException) {
        buf += (("fatal error", `throw`.getMessage, `throw`.getStackTraceString))
    }

    override def toString: String = {
        val res = new StringBuilder
        buf foreach {
            case (typeError, message, stack) => res append (typeError.toUpperCase.space + "!!!" + newLine + "Message: " + message + newLine + "Stack:" + space + stack + newLine)
        }

        res.toString()
    }
}
