package com.simplesys.jdbc.control.dataSet

import com.simplesys.jdbc.control._

trait DataSet[T <: DataSet[T]] extends ClassBO[T] {
    override val isDataSet = true
    val fromBO: ClassBO[_]
}

trait DataSet1[T <: DataSet1[T]] extends DataSet[T]


