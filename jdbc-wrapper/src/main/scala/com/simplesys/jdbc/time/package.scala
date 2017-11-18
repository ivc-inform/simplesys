package com.simplesys.jdbc

import java.time.LocalDateTime

import com.simplesys.common.Strings._
import io.circe.HCursor
import io.circe.parser._

package object time {
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
            val now = LocalDateTime.now()

            def today(hour: Int = 23, min: Int = 59, sec: Int = 59): LocalDateTime = LocalDateTime.of(now.getYear, now.getMonth, now.getDayOfMonth, hour, min, sec)

            parse(string) match {
                case Left(failure) ⇒
                    None
                case Right(json) ⇒
                    val cursor: HCursor = json.hcursor

                    cursor.get[String]("_constructor") match {
                        case Left(failure) =>
                            None
                        case Right(constructor) if constructor == "RelativeDate" =>
                            cursor.get[String]("value") match {
                                case Left(failure) ⇒
                                    None
                                case Right(x) ⇒
                                    x match {
                                        case "$now" => Some(now.getMillis)

                                        case "$today" =>
                                            Some(today().getMillis)

                                        case "$startOfToday" =>
                                            Some(today().getMillis)

                                        case "$endOfToday" =>
                                            Some(today(23, 59, 59).getMillis)

                                        case "$yesterday" =>
                                            Some(today().minusDays(1).getMillis)

                                        case "$startOfYesterday" =>
                                            Some(today().minusDays(1).getMillis)

                                        case "$endOfYesterday" =>
                                            Some(today(23, 59, 59).minusDays(1).getMillis)

                                        case "$tomorrow" =>
                                            Some(today().plusDays(1).getMillis)

                                        case "$startOfTomorrow" =>
                                            Some(today().plusDays(1).getMillis)

                                        case "$endOfTomorrow" =>
                                            Some(today(23, 59, 59).plusDays(1).getMillis)

                                        case "$weekAgo" =>
                                            Some(today().minusWeeks(1).getMillis)

                                        case "$weekFromNow" =>
                                            Some(today().plusWeeks(1).getMillis)

                                        case "$startOfWeek" =>
                                            Some(today().minusDays(now.getDayOfWeek.getValue).getMillis)

                                        case "$endOfWeek" =>
                                            Some(today().minusDays(7 - now.getDayOfWeek.getValue).getMillis)

                                        case "$monthAgo" =>
                                            Some(today().minusMonths(1).getMillis)

                                        case "$monthFromNow" =>
                                            Some(today().plusMonths(1).getMillis)

                                        case "$startOfMonth" =>
                                            Some(today().minusDays(now.getDayOfMonth).getMillis)

                                        case "$endOfMonth" =>
                                            Some(today().plusDays(now.getMonth.length(now.toLocalDate.isLeapYear) - now.getDayOfMonth).getMillis)

                                        case "$startOfYear" =>
                                            Some(today().minusDays(now.getDayOfYear).getMillis)

                                        case "$endOfYear" =>
                                            Some(today().plusDays((if (now.toLocalDate.isLeapYear) 366 else 365) - now.getDayOfYear).getMillis)
                                    }
                                case _ => None
                            }
                    }
            }
        }
    }
}
