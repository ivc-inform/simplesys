package com.simplesys.common

import java.util.{Date => JDate}
import java.sql.{Date => SDate}

class DateTime(val date: JDate) {
  def this(date: Long) = this(new JDate(date))
}

object DateTime {
  def apply(date: JDate) = new DateTime(date)

  def apply(date: Long) = new DateTime(date)

  implicit def SD2JD(date: DateTime): JDate = date date

  implicit def JD2SQLDate(date: JDate) = new SDate(date getTime)

  implicit def SQLDate2JD(date: SDate) = new JDate(date getTime)
}