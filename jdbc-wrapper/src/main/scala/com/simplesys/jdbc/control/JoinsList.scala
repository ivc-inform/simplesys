package com.simplesys.jdbc.control

import com.simplesys.jdbc.control.table.{TableInnerJoinCaseClass, TableLeftJoinCaseClass}
import scala.collection.mutable.ArrayBuffer
import com.simplesys.jdbc.control.classBO.{DsLeftJoinCaseClass, DsInnerJoinCaseClass, BoLeftJoinCaseClass, BoInnerJoinCaseClass}
import com.simplesys.isc.system.typesDyn.OperatorId
import com.simplesys.jdbc.control.dataSet.DataSet

object JoinsList {
    def apply() = new JoinsList

    def apply(joins: JoinParam): JoinsList = {
        joins match {
            case joinList: JoinsList => joinList
            case _ => JoinsList()
        }
    }
}

class JoinsList extends JoinParam {
    val buffer = ArrayBuffer.empty[JoinParam]

    def toList = buffer.toList

    def InnerJoin[T <: Table[T]](table: Table[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += TableInnerJoinCaseClass(table, joinConditions)
        this
    }

    def LeftJoin[T <: Table[T]](table: Table[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += TableLeftJoinCaseClass(table, joinConditions)
        this
    }

    def InnerJoin[T <: ClassBO[T]](bo: ClassBO[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += BoInnerJoinCaseClass(bo, joinConditions)
        this
    }

    def LeftJoin[T <: ClassBO[T]](bo: ClassBO[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += BoLeftJoinCaseClass(bo, joinConditions)
        this
    }

    def InnerJoin[T <: DataSet[T]](dataSet: DataSet[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += DsInnerJoinCaseClass(dataSet, joinConditions)
        this
    }

    def LeftJoin[T <: DataSet[T]](dataSet: DataSet[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        buffer += DsLeftJoinCaseClass(dataSet, joinConditions)
        this
    }

    def Join(join: JoinParam): JoinsList = {
        buffer ++= (join match {
            case join: JoinsList => join.toList
            case _ => Nil
        })

        this
    }
}

case class JoinClause(operator: OperatorId) extends JoinConditionParam