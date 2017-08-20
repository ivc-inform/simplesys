package com.simplesys

import org.joda.time.{LocalDateTime, DateTime}
import org.joda.time.format.DateTimeFormatter
import java.sql.Date

package object time {
    /*implicit class StringOpt(string: String) {
        def toDateTime = DateTime parse string
        def toDateTime(formatter: DateTimeFormatter) = DateTime parse(string, formatter)
    }*/

    /*implicit class LocalDateTimeOpts(d: Array[LocalDateTime]) {
        def getString: String = if (d.length == 0) "" else d(0).toString
    }

    implicit class DateTimeOpts(d: Array[DateTime]) {
        def getString: String = if (d.length == 0) "" else d(0).toString
    }*/
}
