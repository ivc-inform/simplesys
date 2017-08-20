
package com.simplesys.time

object Imports extends Imports
object TypeImports extends TypeImports
object StaticForwarderImports extends StaticForwarderImports

trait Imports extends TypeImports with StaticForwarderImports with Implicits

trait TypeImports {
  type Chronology = org.joda.time.Chronology
  type DateTime = org.joda.time.DateTime
  type DateTimeFormat = org.joda.time.format.DateTimeFormat
  type DateTimeZone = org.joda.time.DateTimeZone
  type Duration = org.joda.time.Duration
  type Interval = org.joda.time.Interval
  type LocalDate = org.joda.time.LocalDate
  type LocalDateTime = org.joda.time.LocalDateTime
  type LocalTime = org.joda.time.LocalTime
  type Period = org.joda.time.Period
  type Partial = org.joda.time.Partial
}

trait StaticForwarderImports {
  val DateTime = com.simplesys.time.StaticDateTime
  val DateTimeFormat = com.simplesys.time.StaticDateTimeFormat
  val DateTimeZone = com.simplesys.time.StaticDateTimeZone
  val Duration = com.simplesys.time.StaticDuration
  val Interval = com.simplesys.time.StaticInterval
  val LocalDate = com.simplesys.time.StaticLocalDate
  val LocalDateTime = com.simplesys.time.StaticLocalDateTime
  val LocalTime = com.simplesys.time.StaticLocalTime
  val Period = com.simplesys.time.StaticPeriod
  val Partial = com.simplesys.time.StaticPartial
}
