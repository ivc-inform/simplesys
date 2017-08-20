package com.simplesys.log

import org.slf4j.{Logger => Slf4jLogger, LoggerFactory => Slf4jLoggerFactory}


object Logger {
    def apply(_class: Class[_]): Logger = new BasicLogger(Slf4jLoggerFactory.getLogger(_class))

    //def apply(className: String): Logger = new BasicLogger(Slf4jLoggerFactory getLogger className)
}

abstract class Logger {
    protected type LogFunc = (String, Throwable) => Unit

    protected val logger: Slf4jLogger

    lazy val name = logger getName

    @inline protected final def fmtString(msg: String, format: Any*): String =
        if (msg.nonEmpty) msg format (format: _*) else msg

    private def log(msg: String, t: Throwable, f: LogFunc, values: Any*) {
        try {
            if (values forall (_ == null))
                f(msg, t)
            else
                f(fmtString(msg, values: _*), t)
        }
        catch {
            case e: Throwable =>
                println("Values: ===================")
                values foreach println
                println("===========================")
                println(s"ERROR FOR: ${msg}")
                throw e
        }
    }

    protected val logTrace: LogFunc
    protected val logDebug: LogFunc
    protected val logInfo: LogFunc
    protected val logWarn: LogFunc
    protected val logError: LogFunc

    ////////////////////////////// trace ////////////////////////////////////////////////////////////////////////////////////////
    def trace(t: => Throwable, z: Any = null) {
        trace("", t, null, null, null, null, null)
    }

    def trace(msg: => String) {
        trace(msg, null, null, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def trace(msg: => String, value1: => Any) {
        trace(msg, null, value1, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def trace(msg: => String, value1: => Any, value2: => Any) {
        trace(msg, null, value1, value2, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def trace(msg: => String, value1: => Any, value2: => Any, value3: => Any) {
        trace(msg, null, value1, value2, value3, null, null)
    }

    @deprecated("use interpolation string", "")
    def trace(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any) {
        trace(msg, null, value1, value2, value3, value4, null)
    }

    @deprecated("use interpolation string", "")
    def trace(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        trace(msg, null, value1, value2, value3, value4, value5)
    }

    private def trace(msg: => String, t: => Throwable, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        if (logger.isTraceEnabled) {
            log(msg, t, logTrace, value1, value2, value3, value4, value5)
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////// debug ////////////////////////////////////////////////////////////////////////////////////////
    def debug(t: => Throwable, z: Any = null) {
        debug("", t, null, null, null, null, null)
    }

    def debug(msg: => String) {
        debug(msg, null, null, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def debug(msg: => String, value1: => Any) {
        debug(msg, null, value1, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def debug(msg: => String, value1: => Any, value2: => Any) {
        debug(msg, null, value1, value2, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def debug(msg: => String, value1: => Any, value2: => Any, value3: => Any) {
        debug(msg, null, value1, value2, value3, null, null)
    }

    @deprecated("use interpolation string", "")
    def debug(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any) {
        debug(msg, null, value1, value2, value3, value4, null)
    }

    @deprecated("use interpolation string", "")
    def debug(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        debug(msg, null, value1, value2, value3, value4, value5)
    }

    private def debug(msg: => String, t: => Throwable, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        if (logger.isDebugEnabled) {
            log(msg, t, logDebug, value1, value2, value3, value4, value5)
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////// info ////////////////////////////////////////////////////////////////////////////////////////
    def info(t: => Throwable, z: Any = null) {
        info("", t, null, null, null, null, null)
    }

    def info(msg: => String) {
        info(msg, null, null, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def info(msg: => String, value1: => Any) {
        info(msg, null, value1, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def info(msg: => String, value1: => Any, value2: => Any) {
        info(msg, null, value1, value2, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def info(msg: => String, value1: => Any, value2: => Any, value3: => Any) {
        info(msg, null, value1, value2, value3, null, null)
    }

    @deprecated("use interpolation string", "")
    def info(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any) {
        info(msg, null, value1, value2, value3, value4, null)
    }

    @deprecated("use interpolation string", "")
    def info(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        info(msg, null, value1, value2, value3, value4, value5)
    }

    private def info(msg: => String, t: => Throwable, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        if (logger.isInfoEnabled) {
            log(msg, t, logInfo, value1, value2, value3, value4, value5)
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////// warn ////////////////////////////////////////////////////////////////////////////////////////
    def warn(t: => Throwable, z: Any = null) {
        warn("", t, null, null, null, null, null)
    }

    def warn(msg: => String) {
        warn(msg, null, null, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def warn(msg: => String, value1: => Any) {
        warn(msg, null, value1, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def warn(msg: => String, value1: => Any, value2: => Any) {
        warn(msg, null, value1, value2, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def warn(msg: => String, value1: => Any, value2: => Any, value3: => Any) {
        warn(msg, null, value1, value2, value3, null, null)
    }

    @deprecated("use interpolation string", "")
    def warn(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any) {
        warn(msg, null, value1, value2, value3, value4, null)
    }

    @deprecated("use interpolation string", "")
    def warn(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        warn(msg, null, value1, value2, value3, value4, value5)
    }

    private def warn(msg: => String, t: => Throwable, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        if (logger.isWarnEnabled) {
            log(msg, t, logWarn, value1, value2, value3, value4, value5)
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////// error ///////////////////////////////////////////////////////////////////////////////////////
    def error(t: => Throwable, z: Any = null) {
        error("", t, null, null, null, null, null)
    }

    def error(msg: => String) {
        error(msg, null, null, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def error(msg: => String, value1: => Any) {
        error(msg, null, value1, null, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def error(msg: => String, value1: => Any, value2: => Any) {
        error(msg, null, value1, value2, null, null, null)
    }

    @deprecated("use interpolation string", "")
    def error(msg: => String, value1: => Any, value2: => Any, value3: => Any) {
        error(msg, null, value1, value2, value3, null, null)
    }

    @deprecated("use interpolation string", "")
    def error(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any) {
        error(msg, null, value1, value2, value3, value4, null)
    }

    @deprecated("use interpolation string", "")
    def error(msg: => String, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        error(msg, null, value1, value2, value3, value4, value5)
    }

    //@deprecated("use interpolation string","")
    def error(msg: => String, t: => Throwable, value1: => Any, value2: => Any, value3: => Any, value4: => Any, value5: => Any) {
        if (logger.isErrorEnabled) {
            log(msg, t, logError, value1, value2, value3, value4, value5)
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    val isTraceEnabled = logger.isTraceEnabled
    val isDebugEnabled = logger.isDebugEnabled
    val isInfoEnabled = logger.isInfoEnabled
    val isWarnEnabled = logger.isWarnEnabled
    val isErrorEnabled = logger.isErrorEnabled
}


protected final class BasicLogger(protected val logger: Slf4jLogger) extends Logger {
    protected val logTrace: LogFunc = logger.trace(_, _)
    protected val logDebug: LogFunc = logger.debug(_, _)
    protected val logInfo: LogFunc = logger.info(_, _)
    protected val logWarn: LogFunc = logger.warn(_, _)
    protected val logError: LogFunc = logger.error(_, _)
}
