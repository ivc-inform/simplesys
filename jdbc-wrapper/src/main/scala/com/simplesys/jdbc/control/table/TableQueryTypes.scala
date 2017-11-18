package com.simplesys.jdbc.control.table

import java.sql.PreparedStatement

import com.simplesys.SQL.Gen.{AscOrderBy, DirOrderBy}
import com.simplesys.isc.system.typesDyn.{OperatorId, opIdAnd, opIdNot, opIdOr}
import com.simplesys.jdbc.control._
import io.circe.Json

import scala.collection.mutable.ArrayBuffer

//<editor-fold desc="OrderBy">
object OrderByList {
    def apply() = new OrderByList
}

class OrderByList extends OrderByParam {
    val buffer = ArrayBuffer.empty[OrderByParam]

    def OrderBy(column: BasicTableColumn[_], order: DirOrderBy = AscOrderBy) = {
        buffer += OrderByCaseClass(column, order)
        this
    }

    def OrderBy(tuple: Tuple2[BasicTableColumn[_], DirOrderBy]) = {
        buffer += OrderByCaseClass(tuple._1, tuple._2)
        this
    }

    def toList = (buffer map {
        case x@OrderByCaseClass(_, _) => x
    }).toList
}

object OrderBy {
    def apply(tuple: Tuple2[BasicTableColumn[_], DirOrderBy]): OrderByList = {
        OrderByList().OrderBy(tuple)
    }
}

case class OrderByCaseClass(column: BasicTableColumn[_], order: DirOrderBy) extends OrderByParam

//</editor-fold>

//<editor-fold desc="Where">
object WheresList {
    def apply() = new WheresList

    implicit def json2WhereParam(json:Json):WhereParam = WheresList()
}

class WheresList extends WhereParam {
    val buffer = ArrayBuffer.empty[WhereParam]

    def Where[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]): WheresList = {
        buffer += WhereTableCaseClass(tuple._1, tuple._2, tuple._3)
        this
    }

    def Where(tuples: List[WhereParam]): WheresList = {
        buffer ++= tuples
        this
    }

    def And[T, PT <% T](column: BasicTableColumn[T], operator: OperatorId, value: PT): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdAnd)
        buffer += WhereTableCaseClass(column, operator, value)
        this
    }

    def And[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdAnd)
        buffer += WhereTableCaseClass(tuple._1, tuple._2, tuple._3)
        this
    }

    def And(tuples: List[WhereParam]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdAnd)
        buffer ++= tuples
        this
    }

    def Or[T, PT <% T](column: BasicTableColumn[T], operator: OperatorId, value: PT): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdOr)
        buffer += WhereTableCaseClass(column, operator, value)
        this
    }

    def Or[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdOr)
        buffer += WhereTableCaseClass(tuple _1, tuple _2, tuple _3)
        this
    }

    def Or(tuples: List[WhereParam]): WheresList = {
        if (buffer.length > 0)
            buffer += WhereTableClause(opIdOr)
        buffer ++= tuples
        this
    }

    def toList: List[WhereParam] = buffer.toList
}

object Where {
    def apply[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]): WheresList = {
        WheresList().Where(tuple)
    }

    def apply(tuple: List[WhereParam]): WheresList = {
        WheresList().Where(tuple)
    }

    implicit class WhereOpts[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]) {
        def And(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdAnd), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def And(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdAnd), WhereTableCaseClasses(tuples))
        }

        def Or(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdOr), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdOr), WhereTableCaseClasses(tuples))
        }

        def Not(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdNot), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdNot), WhereTableCaseClasses(tuples))
        }
    }

    implicit class WhereOpts1[T, PT <: Iterable[_] <% T, PT1 <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]) {
        def And(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT1]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdAnd), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def And(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdAnd), WhereTableCaseClasses(tuples))
        }

        def Or(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdOr), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdOr), WhereTableCaseClasses(tuples))
        }

        def Not(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdNot), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuples: List[WhereParam]): List[WhereParam] = {
            List(WhereTableCaseClass(tuple _1, tuple _2, tuple _3), WhereTableClause(opIdNot), WhereTableCaseClasses(tuples))
        }
    }

    implicit class WhereOpts2[T, PT <% T](tuples: List[WhereParam]) {
        def And(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdAnd), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Or(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdOr), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }

        def Not(tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdNot), WhereTableCaseClass(tuple1 _1, tuple1 _2, tuple1 _3))
        }
    }

    implicit class WhereOpts3(tuples: List[WhereParam]) {
        def And(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdAnd), WhereTableCaseClasses(tuples1))
        }

        def Or(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdOr), WhereTableCaseClasses(tuples1))
        }

        def Not(tuples1: List[WhereParam]): List[WhereParam] = {
            tuples ++ List(WhereTableClause(opIdNot), WhereTableCaseClasses(tuples1))
        }
    }
}

case class WhereTableCaseClass[T, PT <% T](column: BasicTableColumn[T], operator: OperatorId, value: PT) extends WhereParam {
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

case class WhereTableClause(operator: OperatorId) extends WhereParam

case class WhereTableCaseClasses(classes: List[WhereParam]) extends WhereParam {
    def bind(preparedStatement: PreparedStatement, offset: Int): Int = {
        var idx = offset

        classes foreach {
            case clazz: WhereTableCaseClass[_, _] =>
                idx += clazz.bind(preparedStatement, idx)
            case _ =>
        }

        idx
    }
}
//</editor-fold>

//<editor-fold desc="Joins">
object JoinsTable {

    implicit class JoinOpts[T](tuple: Tuple3[BasicTableColumn[T], OperatorId, BasicTableColumn[T]]) {
        def And[T1](tuple1: Tuple3[BasicTableColumn[T1], OperatorId, BasicTableColumn[T1]]): List[JoinConditionParam] =
            List(TableJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), TableJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))

        def And[T, PT <% T](tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[JoinConditionParam] =
            List(TableJoinCondition(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), TableJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))
    }

    implicit class JoinOpts1(joinsCondition: List[JoinConditionParam]) {
        def And[T](tuple1: Tuple3[BasicTableColumn[T], OperatorId, BasicTableColumn[T]]): List[JoinConditionParam] =
            joinsCondition ++ List(JoinClause(opIdAnd), TableJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))


        def And[T, PT <% T](tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[JoinConditionParam] =
            joinsCondition ++ List(JoinClause(opIdAnd), TableJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

    }

    implicit class JoinOpts2[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]) {
        def And[T1](tuple1: Tuple3[BasicTableColumn[T1], OperatorId, BasicTableColumn[T1]]): List[JoinConditionParam] =
            List(TableJoinCondition1(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), TableJoinCondition(tuple1 _1, tuple1 _2, tuple1 _3))


        def And[T, PT <% T](tuple1: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[JoinConditionParam] =
            List(TableJoinCondition1(tuple _1, tuple _2, tuple _3), JoinClause(opIdAnd), TableJoinCondition1(tuple1 _1, tuple1 _2, tuple1 _3))

    }

    implicit def tp2Seq[T](tuple: Tuple3[BasicTableColumn[T], OperatorId, BasicTableColumn[T]]): List[JoinConditionParam] = List(TableJoinCondition(tuple _1, tuple _2, tuple _3))
    implicit def tp2Seq1[T, PT <% T](tuple: Tuple3[BasicTableColumn[T], OperatorId, PT]): List[JoinConditionParam] = List(TableJoinCondition1(tuple _1, tuple _2, tuple _3))
}

case class TableJoinCondition(column1: BasicTableColumn[_], operator: OperatorId, column2: BasicTableColumn[_]) extends JoinConditionParam
case class TableJoinCondition1[T, PT <% T](column: BasicTableColumn[T], operator: OperatorId, value: PT) extends JoinConditionParam {
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

object InnerJoin {
    def apply[T <: Table[T]](table: Table[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += TableInnerJoinCaseClass(table, joinConditions)
        res
    }
}

object LeftJoin {
    def apply[T <: Table[T]](table: Table[T])(joinConditions: List[JoinConditionParam]): JoinsList = {
        val res = new JoinsList
        res.buffer += TableLeftJoinCaseClass(table, joinConditions)
        res
    }
}

case class TableInnerJoinCaseClass[T <: Table[T]](table: Table[T], joinConditions: List[JoinConditionParam]) extends JoinParam

case class TableLeftJoinCaseClass[T <: Table[T]](table: Table[T], joinConditions: List[JoinConditionParam]) extends JoinParam

case class From[T <: Table[T]](table: T) extends FromParam

case class SQL(sqpParam: String) extends SQLParam
//</editor-fold>


//<editor-fold desc="Insert">
object InsertsList {
    def apply() = new InsertsList
}

class InsertsList extends InsertParam {
    val buffer = ArrayBuffer.empty[InsertParam]

    def Insert[T, PT <% T](column: BasicTableColumn[T], value: PT) = {
        buffer += InsertCaseClass(column, value)
        this
    }

    def Insert[T, PT <% T](tuple: Tuple2[BasicTableColumn[T], PT]) = {
        buffer += InsertCaseClass(tuple._1, tuple._2)
        this
    }

    def toList = (buffer map {
        case x@InsertCaseClass(_, _) => x
    }).toList
}

object Insert {
    def apply[T, PT <% T](tuple: Tuple2[BasicTableColumn[T], PT]): InsertsList = InsertsList().Insert(tuple)
}

case class InsertCaseClass[T, PT <% T](column: BasicTableColumn[T], value: PT) extends InsertParam {
    def bind(preparedStatement: PreparedStatement, offset: Int) {
        column set(preparedStatement, offset, value)
    }
}
//</editor-fold>

//<editor-fold desc="Set">
object SetsList {
    def apply() = new SetsList
}

class SetsList extends SetParam {
    val buffer = ArrayBuffer.empty[SetParam]

    def Set[T, PT <% T](column: BasicTableColumn[T], value: PT) = {
        buffer += SetCaseClass(column, value)
        this
    }

    def Set[T, PT <% T](tuple: Tuple2[BasicTableColumn[T], PT]) = {
        buffer += SetCaseClass(tuple._1, tuple._2)
        this
    }

    def toList = (buffer map {
        case x@SetCaseClass(_, _) => x
    }).toList
}

object Set {
    def apply[T, PT <% T](tuple: Tuple2[BasicTableColumn[T], PT]): SetsList = SetsList().Set(tuple)
}

case class SetCaseClass[T, PT <% T](column: BasicTableColumn[T], value: PT) extends SetParam {
    def bind(preparedStatement: PreparedStatement, offset: Int) {
        column set(preparedStatement, offset, value)
    }
}

//</editor-fold>
