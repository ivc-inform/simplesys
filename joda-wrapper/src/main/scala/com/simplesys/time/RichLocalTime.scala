/**
 * Copyright 2009 Barry Kaplan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 **/
package com.simplesys.time

import org.joda.time._

class RichLocalTime(proxy: LocalTime) {
  def -(period: ReadablePeriod): LocalTime =
    proxy.minus(period)
  def -(builder: DurationBuilder): LocalTime =
    proxy.minus(builder.proxy)
  def +(period: ReadablePeriod): LocalTime =
    proxy.plus(period)
  def +(builder: DurationBuilder): LocalTime =
    proxy.plus(builder.proxy)

  def second: LocalTime.Property = proxy.secondOfMinute
  def minute: LocalTime.Property = proxy.minuteOfHour
  def hour: LocalTime.Property = proxy.hourOfDay

  def withSecond(second: Int) = proxy.withSecondOfMinute(second)
  def withMinute(minute: Int) = proxy.withMinuteOfHour(minute)
  def withHour(hour: Int) = proxy.withHourOfDay(hour)
}
