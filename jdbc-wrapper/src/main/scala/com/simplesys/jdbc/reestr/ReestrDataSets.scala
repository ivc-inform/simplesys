package com.simplesys.jdbc.reestr

import scala.collection.mutable.ArrayBuffer
import com.simplesys.jdbc.control.dataSet.DataSet
import com.simplesys.common.equality.SimpleEquality._

object ReestrDataSets {
    private val reestr = ArrayBuffer.empty[Tuple2[String, DataSet[_]]]
    def +=[T <: DataSet[T]](dataSet: DataSet[T]): DataSet[T] = {
       //if (!reestr.map(f => f._1).exists(f=> f === dataSet.dataSource.))
        dataSet
    }
}