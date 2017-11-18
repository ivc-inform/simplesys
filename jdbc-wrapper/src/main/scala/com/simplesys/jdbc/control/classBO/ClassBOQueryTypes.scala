package com.simplesys.jdbc.control.classBO

import java.sql.PreparedStatement

import com.simplesys.SQL.Gen.{AscOrderBy, DirOrderBy}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.jdbc.control._
import com.simplesys.jdbc.control.dataSet.DataSet
import io.circe.Json

import scala.collection.mutable.ArrayBuffer

object OrderByList {
    def apply() = new OrderByList

    def apply(orderBy: OrderByParam): OrderByList = {
        orderBy match {
            case byList: OrderByList => byList
            case _ => OrderByList()
        }
    }
}

class OrderByList extends OrderByParam {
    val buffer = ArrayBuffer.empty[OrderByParam]

    def OrderBy(column: BasicClassBOColumn[_], order: DirOrderBy = AscOrderBy) = {
        buffer += OrderByCaseClass(column, order)
        this
    }

    def OrderBy(orderBy: OrderByParam*) = {
        buffer ++= orderBy
        this
    }

    def OrderBy(tuple: Tuple2[BasicClassBOColumn[_], DirOrderBy]) = {
        buffer += OrderByCaseClass(tuple._1, tuple._2)
        this
    }

    def toList: List[OrderByParam] = buffer.toList
}

object OrderBy {
    def apply(tuple: Tuple2[BasicClassBOColumn[_], DirOrderBy]): OrderByList = {
        OrderByList().OrderBy(tuple)
    }

    def apply(orderBy: OrderByParam): OrderByList = {
        orderBy match {
            case _orderBy: OrderByList => _orderBy
            case _ => OrderByList()
        }
    }
}

case class OrderByCaseClass(column: BasicClassBOColumn[_], order: DirOrderBy) extends OrderByParam

//<editor-fold desc="Where">
object WheresList {
    def apply() = new WheresList

    def apply(where: WhereParam): WheresList = {
        where match {
            case where: WheresList => where
            case _ => WheresList()
        }
    }

    implicit def json2WhereParam(json: Json): WhereParam = WheresList()
}

class WheresList extends WhereParam {
    val buffer = ArrayBuffer.empty[WhereParam]

    def Where[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): WheresList = {
        buffer += WhereBoCaseClass(tuple._1, tuple._2, tuple._3)
        this
    }

    def Where(tuples: WhereParam*): WheresList = {
        buffer ++= tuples
        this
    }

    def And[T, PT <% T](column: BasicClassBOColumn[T], operator: OperatorId, value: PT): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdAnd)
        buffer += WhereBoCaseClass(column, operator, value)
        this
    }

    def And[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdAnd)
        buffer += WhereBoCaseClass(tuple._1, tuple._2, tuple._3)
        this
    }

    def And(tuples: List[WhereParam]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdAnd)
        buffer ++= tuples
        this
    }

    def Or[T, PT <% T](column: BasicClassBOColumn[T], operator: OperatorId, value: PT): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdOr)
        buffer += WhereBoCaseClass(column, operator, value)
        this
    }

    def Or[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdOr)
        buffer += WhereBoCaseClass(tuple _1, tuple _2, tuple _3)
        this
    }

    def Or(tuples: List[WhereParam]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereBoClause(opIdOr)
        buffer ++= tuples
        this
    }

    def toList: List[WhereParam] = buffer.toList
}

object Where {
    def apply[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): WheresList = {
        WheresList().Where(tuple)
    }

    def apply(tuple: List[WhereParam]): WheresList = {
        WheresList().Where(tuple: _*)
    }

    implicit class WhereOpts[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]) {
        def And(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdAnd), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def And(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdAnd), WhereBoCaseClasses(tuples))
        }

        def Or(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdOr), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdOr), WhereBoCaseClasses(tuples))
        }

        def Not(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdNot), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdNot), WhereBoCaseClasses(tuples))
        }
    }

    implicit class WhereOpts1[T, PT <: Iterable[_] <% T, PT1 <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]) {
        def And(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT1]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdAnd), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def And(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdAnd), WhereBoCaseClasses(tuples))
        }

        def Or(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdOr), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdOr), WhereBoCaseClasses(tuples))
        }

        def Not(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdNot), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereBoCaseClass(tuple _1, tuple _2, tuple _3), WhereBoClause(opIdNot), WhereBoCaseClasses(tuples))
        }
    }

    implicit class WhereOpts2[T, PT <% T](tuples: List[WhereParam]) {
        def And(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdAnd), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdOr), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdNot), WhereBoCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }
    }

    implicit class WhereOpts3(tuples: List[WhereParam]) {
        def And(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdAnd), WhereBoCaseClasses(tuples1))
        }

        def Or(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdOr), WhereBoCaseClasses(tuples1))
        }

        def Not(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereBoClause(opIdNot), WhereBoCaseClasses(tuples1))
        }
    }
}

case class WhereBoCaseClass[T, PT <% T](column: BasicClassBOColumn[T], operator: OperatorId, value: PT) extends WhereParam {
    def bind(preparedStatement: PreparedStatement, offset: Int): Int = {
        value match {
            case x: List[T] =>
                var step = offset
                x foreach {
                    item =>
                        column set(preparedStatement, step, item)
                        logger trace (s"Binding (index: ${step}, value: ${item})")
                        step += 1
                }
                step
            case _ =>
                column set(preparedStatement, offset, value)

                logger trace (s"Binding (index: ${offset}, value: ${value})")
                offset + 1
        }
    }
}

case class WhereBoClause(operator: OperatorId) extends WhereParam

case class WhereBoCaseClasses(classes: List[WhereParam]) extends WhereParam {
    def bind(preparedStatement: PreparedStatement, offset: Int): Int = {
        var idx = offset

        classes foreach {
            case clazz: WhereBoCaseClass[_, _] =>
                idx += clazz.bind(preparedStatement, idx)
            case _ =>
        }

        idx
    }
}
//</editor-fold>

//<editor-fold desc="Joins">
object JoinsBo {

    implicit class JoinOpts[T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, BasicClassBOColumn[T]]) {
        def And[T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, BasicClassBOColumn[T1]]): List[JoinConditionParam] =
            List(BoJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))

        def And[T1, PT1 <% T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, PT1]): List[JoinConditionParam] =
            List(BoJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

        def JoinCondition: List[JoinConditionParam] = List(BoJoinCondition(tuple _1, tuple _2, tuple _3))
    }

    implicit class JoinOpts1(joinsCondition: List[JoinConditionParam]) {
        def And[T](tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, BasicClassBOColumn[T]]): List[JoinConditionParam] =
            joinsCondition ++ List(JoinClause(opIdAnd), BoJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))


        def And[T, PT <% T](tuple1: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[JoinConditionParam] =
            joinsCondition ++ List(JoinClause(opIdAnd), BoJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

        def And(joinsConditions: List[JoinConditionParam]): List[JoinConditionParam] = {
            val res = ArrayBuffer.empty[JoinConditionParam]
            joinsConditions foreach {
                _joinsCondition =>
                    if (res.length > 0)
                        res += JoinClause(opIdAnd)
                    res += _joinsCondition
            }
            joinsCondition ++ res
        }
    }

    implicit class JoinOpts2[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]) {
        def And[T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, BasicClassBOColumn[T1]]): List[JoinConditionParam] =
            List(BoJoinCondition1(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))


        def And[T1, PT1 <% T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, PT1]): List[JoinConditionParam] =
            List(BoJoinCondition1(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

        def JoinCondition: List[JoinConditionParam] = List(BoJoinCondition1(tuple _1, tuple _2, tuple _3))
    }

    implicit class JoinOpts3[T](tuple: Tuple3[BasicClassBOColumn[Array[T]], OperatorId, BasicClassBOColumn[T]]) {
        def And[T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, BasicClassBOColumn[T1]]): List[JoinConditionParam] =
            List(BoJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))

        def And[T1, PT1 <% T1](tuple1: Tuple3[BasicClassBOColumn[T1], OperatorId, PT1]): List[JoinConditionParam] =
            List(BoJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), BoJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

        def JoinCondition: List[JoinConditionParam] = List(BoJoinCondition(tuple _1, tuple _2, tuple _3))
    }

    implicit def tp2Seq[T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, BasicClassBOColumn[T]]): List[JoinConditionParam] = List(BoJoinCondition(tuple _1, tuple _2, tuple _3))
    implicit def tp2Seq1[T, PT <% T](tuple: Tuple3[BasicClassBOColumn[T], OperatorId, PT]): List[JoinConditionParam] = List(BoJoinCondition1(tuple _1, tuple _2, tuple _3))
}

case class BoJoinCondition(column1: BasicClassBOColumn[_], operator: OperatorId, column2: BasicClassBOColumn[_]) extends JoinConditionParam
case class BoJoinCondition1[T, PT <% T](column: BasicClassBOColumn[T], operator: OperatorId, value: PT) extends JoinConditionParam {
    def bind(preparedStatement: PreparedStatement, offset: Int): Int = {
        value match {
            case x: List[T] =>
                var step = offset
                x foreach {
                    item =>
                        column set(preparedStatement, step, item)
                        logger trace (s"Binding (index: ${step}, value: ${item})")
                        step += 1
                }
                step
            case _ =>
                column set(preparedStatement, offset, value)

                logger trace (s"Binding (index: ${offset}, value: ${value})")
                offset + 1
        }
    }
}

case class FromBo[T <: ClassBO[T]](clazz: T) extends FromParam
case class FromDS[T <: DataSet[T]](dataSet: T) extends FromParam

object InnerJoin {
    def apply[T <: ClassBO[T]](bo: ClassBO[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += BoInnerJoinCaseClass(bo, joinConditions)
        res
    }

    def apply[T <: DataSet[T]](dataSet: DataSet[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += DsInnerJoinCaseClass(dataSet, joinConditions)
        res
    }
}

object LeftJoin {
    def apply[T <: ClassBO[T]](bo: ClassBO[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += BoLeftJoinCaseClass(bo, joinConditions)
        res
    }

    def apply[T <: DataSet[T]](dataSet: DataSet[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += DsLeftJoinCaseClass(dataSet, joinConditions)
        res
    }
}

case class BoInnerJoinCaseClass[T <: ClassBO[T]](bo: ClassBO[T], joinConditions: List[JoinConditionParam]) extends JoinParam
case class BoLeftJoinCaseClass[T <: ClassBO[T]](bo: ClassBO[T], joinConditions: List[JoinConditionParam]) extends JoinParam

case class DsInnerJoinCaseClass[T <: DataSet[T]](dataSet: DataSet[T], joinConditions: List[JoinConditionParam]) extends JoinParam
case class DsLeftJoinCaseClass[T <: DataSet[T]](dataSet: DataSet[T], joinConditions: List[JoinConditionParam]) extends JoinParam

//case class FromBo[T <: ClassBO[T]](bo: T) extends FromParam

case class SQL(sqpParam: String) extends SQLParam
//</editor-fold>

//<editor-fold desc="Set">
object SetsList {
    def apply() = new SetsList
    def apply(set: SetParam): SetsList = {
        set match {
            case byList: SetsList => byList
            case _ => SetsList()
        }
    }
}

class SetsList extends SetParam {
    val buffer = ArrayBuffer.empty[SetParam]

    def Set[T, PT <% T](column: BasicClassBOColumn[T], value: PT) = {
        buffer += SetCaseClass(column, value)
        this
    }

    def Set(set: SetParam*) = {
        buffer ++= set
        this
    }

    def Set[T, PT <% T](tuple: Tuple2[BasicClassBOColumn[T], PT]) = {
        buffer += SetCaseClass(tuple._1, tuple._2)
        this
    }

    def toList = (buffer map {
        case x@SetCaseClass(_, _) => x
    }).toList
}

object Set {
    def apply[T, PT <% T](tuple: Tuple2[BasicClassBOColumn[T], PT]): SetsList = SetsList().Set(tuple)
}

case class SetCaseClass[T, PT <% T](column: BasicClassBOColumn[T], value: PT) extends SetParam {
    def bind(preparedStatement: PreparedStatement, offset: Int) {
        column set(preparedStatement, offset, value)

        logger trace (s"Binding (index: ${offset}, value: ${value})")
    }
}

//</editor-fold>
