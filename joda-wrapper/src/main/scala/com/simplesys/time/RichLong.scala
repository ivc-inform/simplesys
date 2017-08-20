
package com.simplesys.time

import org.joda.time._

class RichLong(n: Long) {
  def toDateTime = new DateTime(n)
  def toDuration = new Duration(n)
}
