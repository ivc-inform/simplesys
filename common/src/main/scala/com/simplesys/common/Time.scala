package com.simplesys.common

import java.time.chrono.IsoChronology
import java.time.format.{DateTimeFormatterBuilder, ResolverStyle, SignStyle}
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField._
import java.util.Locale
import com.simplesys.common.Strings._

object Time {
    val SS_LOCAL_DATE =
        new DateTimeFormatterBuilder()
          .appendValue(DAY_OF_MONTH, 2)
          .appendLiteral(point)
          .appendValue(MONTH_OF_YEAR, 2)
          .appendLiteral(point)
          .appendValue(YEAR)
          .toFormatter(Locale.getDefault(Locale.Category.FORMAT))

    val SS_LOCAL_TIME =
        new DateTimeFormatterBuilder()
          .appendValue(HOUR_OF_DAY, 2)
          .appendLiteral(':')
          .appendValue(MINUTE_OF_HOUR, 2)
          .optionalStart.appendLiteral(':')
          .appendValue(SECOND_OF_MINUTE, 2)
          .toFormatter(Locale.getDefault(Locale.Category.FORMAT))

    val SS_LOCAL_DATE_TIME =
        new DateTimeFormatterBuilder()
          .parseCaseInsensitive.append(SS_LOCAL_DATE)
          .appendLiteral(space)
          .append(SS_LOCAL_TIME)
          .toFormatter(Locale.getDefault(Locale.Category.FORMAT))
}
