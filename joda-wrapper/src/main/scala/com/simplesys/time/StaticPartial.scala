
package com.simplesys.time

import org.joda.time._

object StaticPartial extends StaticPartial

trait StaticPartial {
  type Property = Partial.Property
}
