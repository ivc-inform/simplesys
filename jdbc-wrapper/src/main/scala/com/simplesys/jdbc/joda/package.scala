package com.simplesys.jdbc

import com.simplesys.json.Json
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter, ISODateTimeFormat}
import org.joda.time.{DateTimeZone, LocalDateTime}

package object joda {
    /*
        $now - this moment
        $today - the current day. By default this resolves to the start of the current day though an explicit RelativeDateRangePosition may be used to specify the end of the current day.
        $startOfToday - the start of today
        $endOfToday - the end of today (one millisecond before the $startOfTomorrow)
        $yesterday - the previous day.
        $startOfYesterday - the start of yesterday
        $endOfYesterday - the end of yesterday (one millisecond before the $startOfToday)
        $tomorrow - the following day
        $startOfTomorrow - the start of tomorrow
        $endOfTomorrow - the end of tomorrow
        $weekAgo - the current day of the previous week
        $weekFromNow - the current day of the next week
        $startOfWeek - the start of the current week
        $endOfWeek - the end of the current week
        $monthAgo - the current day of the previous month
        $monthFromNow - the current day of the following month
        $startOfMonth - the start of the current month
        $endOfMonth - the end of the current month
        $startOfYear - the start of the current year
        $endOfYear - the end of the current year
      */

    implicit class stringToDate(val string: String) {

        def value: Option[Long] = {
            val now = org.joda.time.DateTime.now()
            val today = (new org.joda.time.DateTime(now.getYear, now.getMonthOfYear, now.getDayOfMonth, 0, 0))

            Json.getJsonOpt(string) match {
                case None => None
                case Some(jsonString) =>
                    jsonString.getStringOpt("_constructor") match {
                        case None => None
                        case Some(x) if x == "RelativeDate" => jsonString.getString("value") match {
                            case "$now" => Some(now.getMillis)

                            case "$today" =>
                                Some(today.getMillis)

                            case "$startOfToday" =>
                                Some(today.getMillis)

                            case "$endOfToday" =>
                                Some(today.withTime(23, 59, 59, 999).getMillis)

                            case "$yesterday" =>
                                Some(today.minusDays(1).getMillis)

                            case "$startOfYesterday" =>
                                Some(today.minusDays(1).getMillis)

                            case "$endOfYesterday" =>
                                Some(today.minusDays(1).withTime(23, 59, 59, 999).getMillis)

                            case "$tomorrow" =>
                                Some(today.plusDays(1).getMillis)

                            case "$startOfTomorrow" =>
                                Some(today.plusDays(1).getMillis)

                            case "$endOfTomorrow" =>
                                Some(today.plusDays(1).withTime(23, 59, 59, 999).getMillis)

                            case "$weekAgo" =>
                                Some(today.minusWeeks(1).getMillis)

                            case "$weekFromNow" =>
                                Some(today.plusWeeks(1).getMillis)

                            case "$startOfWeek" =>
                                Some(today.minusDays(now.getDayOfWeek).getMillis)

                            case "$endOfWeek" =>
                                Some(today.minusDays(7 - now.getDayOfWeek).getMillis)

                            case "$monthAgo" =>
                                Some(today.minusMonths(1).getMillis)

                            case "$monthFromNow" =>
                                Some(today.plusMonths(1).getMillis)

                            case "$startOfMonth" =>
                                Some(today.minusDays(now.getDayOfMonth).getMillis)

                            case "$endOfMonth" =>
                                Some(today.plusDays(now.dayOfMonth().getMaximumValue - now.getDayOfMonth).getMillis)

                            case "$startOfYear" =>
                                Some(today.minusDays(now.getDayOfYear).getMillis)

                            case "$endOfYear" =>
                                Some(today.plusDays(now.dayOfYear().getMaximumValue - now.getDayOfYear).getMillis)
                        }
                        case _ => None
                    }
            }
        }

        import com.simplesys.common.Strings._

        val msec: Long = {
            if (string.indexOf("(") == -1 && string.indexOf(")") == -1)
                LocalDateTime.parse(string.unQuoted.replace("Z", ""), DateTimeFormat.forPattern("YYYY-MM-DD'T'HH:mm:ss.SSS")).toDateTime.getMillis // 2015-03-11T20:59:59.999
            else
                (string.substring(string.indexOf("(") + 1, string.indexOf(")"))).toLong
        }

        def toLocalDateTimeS(dateTimeFormatter: DateTimeFormatter = ISODateTimeFormat.localDateOptionalTimeParser): org.joda.time.LocalDateTime = {
            value match {
                case None =>
                    if (string.indexOf("new Date") == -1)
                        org.joda.time.LocalDateTime.parse(string.unQuoted.replace("Z", ""), dateTimeFormatter)
                    else
                        new org.joda.time.LocalDateTime(msec)
                case Some(value) => new org.joda.time.LocalDateTime(value)
            }
        }

        def toLocalDateS(dateTimeFormatter: DateTimeFormatter = ISODateTimeFormat.localDateOptionalTimeParser): org.joda.time.LocalDate = {
            value match {
                case None =>
                    if (string.indexOf("new Date") == -1)
                        org.joda.time.LocalDate.parse(string.unQuoted.replace("Z", ""), dateTimeFormatter)
                    else
                        new org.joda.time.LocalDate(msec)
                case Some(value) => new org.joda.time.LocalDate(value)
            }
        }

        def toDateTimeS(dateTimeFormatter: DateTimeFormatter = ISODateTimeFormat.dateTimeParser().withOffsetParsed(), dateTimeZone: DateTimeZone = DateTimeZone.getDefault): org.joda.time.DateTime = {
            value match {
                case None =>
                    if (string.indexOf("new Date") == -1)
                        org.joda.time.DateTime.parse(string.unQuoted.replace("Z", ""), dateTimeFormatter withZone dateTimeZone)
                    else
                        new org.joda.time.DateTime(msec)
                case Some(value) => new org.joda.time.DateTime(value)
            }
        }

    }
}
