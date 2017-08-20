
package com.simplesys.time

import org.joda.time._

object StaticDuration extends StaticDuration

trait StaticDuration {
  def standardDays(days: Long) = Duration.standardDays(days)
  def standardHours(hours: Long) = Duration.standardHours(hours)
  def standardMinutes(minutes: Long) = Duration.standardMinutes(minutes)
  def standardSeconds(seconds: Long) = Duration.standardSeconds(seconds)
}
