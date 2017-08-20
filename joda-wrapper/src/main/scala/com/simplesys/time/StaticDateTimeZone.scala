
package com.simplesys.time

import org.joda.time._

object StaticDateTimeZone extends StaticDateTimeZone

trait StaticDateTimeZone {
  lazy val UTC = DateTimeZone.UTC
  def forID(id: String) = DateTimeZone.forID(id)
  def forOffsetHours(hours: Int) = DateTimeZone.forOffsetHours(hours)
  def forOffsetHoursMinutes(hours: Int, minutes: Int) =
    DateTimeZone.forOffsetHoursMinutes(hours, minutes)
  def forOffsetMillis(millis: Int) = DateTimeZone.forOffsetMillis(millis)
  def forTimeZone(zone: java.util.TimeZone) = DateTimeZone.forTimeZone(zone)
  def getAvailableIDs() = DateTimeZone.getAvailableIDs()
  def getDefault() = DateTimeZone.getDefault()
  def getNameProvider() = DateTimeZone.getNameProvider()
  def getProvider() = DateTimeZone.getProvider()
  def setDefault(zone: DateTimeZone) = DateTimeZone.setDefault(zone)
  def setNameProvider(nameProvider: tz.NameProvider) =
    DateTimeZone.setNameProvider(nameProvider)
  def setProvider(provider: tz.Provider) = DateTimeZone.setProvider(provider)
}
