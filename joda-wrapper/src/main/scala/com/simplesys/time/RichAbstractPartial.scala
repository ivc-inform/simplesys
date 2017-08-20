
package com.simplesys.time

import org.joda.time.base.AbstractPartial

class RichAbstractPartial(proxy: AbstractPartial) extends Ordered[AbstractPartial] {
  def fields = proxy.getFields
  def fieldTypes = proxy.getFieldTypes
  def values = proxy.getValues

  override def compare(that: AbstractPartial): Int =
    proxy.compareTo(that)
}
