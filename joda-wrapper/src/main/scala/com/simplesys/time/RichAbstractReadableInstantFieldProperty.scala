
package com.simplesys.time

import java.util.Locale
import org.joda.time._
import org.joda.time.field.AbstractReadableInstantFieldProperty

class RichAbstractReadableInstantFieldProperty(proxy: AbstractReadableInstantFieldProperty) {
  def shortText: String =
    proxy.getAsShortText
  def asShortText: String =
    proxy.getAsShortText
  def shortText(locale: Locale): String =
    proxy.getAsShortText(locale)
  def asShortText(locale: Locale): String =
    proxy.getAsShortText(locale)
  def asString: String =
    proxy.getAsString
  def text: String =
    proxy.getAsText
  def asText: String =
    proxy.getAsText
  def text(locale: Locale): String =
    proxy.getAsText(locale)
  def asText(locale: Locale): String =
    proxy.getAsText(locale)
  def durationField: DurationField =
    proxy.getDurationField
  def field: DateTimeField =
    proxy.getField
  def fieldType: DateTimeFieldType =
    proxy.getFieldType
  def leapAmount: Int =
    proxy.getLeapAmount
  def leapDurationField: DurationField =
    proxy.getLeapDurationField
  def maximumValue: Int =
    proxy.getMaximumValue
  def maxValue: Int =
    proxy.getMaximumValue
  def maximumValueOverall: Int =
    proxy.getMaximumValueOverall
  def maxValueOverall: Int =
    proxy.getMaximumValueOverall
  def minimumValue: Int =
    proxy.getMinimumValue
  def minValue: Int =
    proxy.getMinimumValue
  def minimumValueOverall: Int =
    proxy.getMinimumValueOverall
  def minValueOverall: Int =
    proxy.getMinimumValueOverall
  def name: String =
    proxy.getName
  def rangeDurationField: DurationField =
    proxy.getRangeDurationField

  def interval: Interval =
    proxy.toInterval
}
