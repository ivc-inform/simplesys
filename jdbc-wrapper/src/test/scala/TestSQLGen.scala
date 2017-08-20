import com.simplesys.isc.system.typesDyn._
import com.simplesys.log.Logging
import com.simplesys.SQL.Gen._
import org.scalatest.FunSuite
import com.simplesys.SQL._
import com.simplesys.common.Strings._

class TestSQLGen extends FunSuite with Logging {
    test("OracleSQLGen") {

        /*SELECT T2."SCAPTION",
               T2."SDESCRIPTION",
               T2."DI",
               T2."DIGROUP",
               T2."BISJUR"
        FROM
          (SELECT T1."SCAPTION",
                  T1."SDESCRIPTION",
                  T1."DI",
                  T1."DIGROUP",
                  T1."BISJUR" ,
                  ROWNUM AS sys$$simplesys$$rownum
           FROM
             (SELECT "CMN_CONTRACTOR"."SCAPTION",
                     "CMN_CONTRACTOR"."SDESCRIPTION",
                     "CMN_CONTRACTOR"."DI",
                     "CMN_CONTRACTOR"."DIGROUP",
                     "CMN_CONTRACTOR"."BISJUR"
              FROM "CMN_CONTRACTOR"
              ORDER BY "CMN_CONTRACTOR"."SCAPTION" ,
                       "CMN_CONTRACTOR"."SDESCRIPTION" DESC) T1
           WHERE ROWNUM < ?) T2
        WHERE T2.sys$$simplesys$$rownum > ?*/

        val t1 = SQLTable(name = "CMN_CONTRACTOR")
        logger debug (newLine + t1.toSQL(4))

        val f1 = SQLField(name = "DI", tableOwner = t1, alias = "qqqq".als)
        logger debug (newLine + f1.toSQL(4))

        val t2 = SQLTable(name = "CMN_CONTRACTOR1")
        logger debug (newLine + t2.toSQL(4))

        val f2 = SQLField(name = "DIGROUP", tableOwner = t2)
        logger debug (newLine + f2.toSQL(4))

        val c1 = SQLJoinCondition(field = f1, operator = opIdINotEqual, fieldJoin = f2)
        logger debug (newLine + c1.toSQL(4))

        val f = SQLFrom(table = SQLTable(name = "CMN_CONTRACTOR"), alias = "T1".als)
        logger debug (newLine + f.toSQL(4))

        val c2 = SQLJoinCondition(field = f1, operator = opIdINotEqual, valueJoin = SQLValue(100))
        val join = SQLJoin(joinType = SQLInnerJoinClause, joinFrom = SQLJoinFrom(table = SQLTable(name = "CMN_CONTRACTOR"), alias = "T3".als), conditions = SQLJoinConditions(c1, SQLJoinAndClause, c2))
        logger debug (newLine + join.toSQL(4))

        val ct = SQLCompoundTable(fields = SQLFields(Seq(SQLField(name = "SCAPTION", alias = "cap".als), "SDESCRIPTION".fld, "DI".fld, "DIGROUP".fld, "BISJUR".fld)), from = SQLFrom(table = SQLTable("Cmn_Contractor"), alias = "Y2".als), ordersBy = SQLOrdersBy("SCAPTION".fld.ordr, SQLOrderBy("SDESCRIPTION".fld, dir = DescOrderBy)))
        logger debug (newLine + ct.toSQL(4))

        val join1: SQLJoin = SQLJoin(joinType = SQLInnerJoinClause, conditions = SQLJoinConditions(), joinFrom = SQLJoinFrom(table = ct, alias = "X1".als))

        val joins = SQLJoins(join, join1)

        val fields1 = SQLFields(Seq(SQLField(name = "SCAPTION", alias = "cap".als), "SDESCRIPTION".fld, "DI".fld, "DIGROUP".fld, "BISJUR".fld))
        val sqlClass0 = SQLCompoundTable(fields = fields1, from = SQLFrom(table = SQLTable("Cmn_Contractor")), ordersBy = SQLOrdersBy("SCAPTION".fld.ordr, SQLOrderBy("SDESCRIPTION".fld, dir = DescOrderBy)), joins = joins)
        val sqlClass1 = SQLCompoundTable(fields = fields1, from = SQLFrom(table = sqlClass0), ordersBy = SQLOrdersBy("SCAPTION".fld.ordr, SQLOrderBy("SDESCRIPTION".fld, dir = DescOrderBy)), joins = joins)



        //val whereItem = SQLWhereInItem("SDESCRIPTION".fld, opIdInSet, SQLValues(SQLValuePlaceHolder, SQLValuePlaceHolder))
        val whereItem = SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValuePlaceHolder)
        val whereItem1 = SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValue(5))

        //val whereItem = SQLWhereBetweenItem("SDESCRIPTION".fld, opIdIBetweenInclusive, SQLValuePlaceHolder, SQLValuePlaceHolder)
        val whereBlock = SQLWhereItems(whereItem, SQLWhereItemClause(opIdOr), whereItem, SQLWhereItemClause(opIdOr), whereItem)
        //val whereBlock1 = SQLWhereItems(whereBlock, SQLWhereItemClause(opIdAnd), whereBlock)
        val whereBlock1 = SQLWhereItems(whereItem, SQLWhereItemClause(opIdAnd), whereBlock, SQLWhereItemClause(opIdAnd), whereItem1)
        //val whereBlock1 = SQLWhereItems(whereItem, whereItem, whereItem)

        /*whereBlock1 += whereBlock0
        whereBlock1 addBlock whereBlock0
        whereBlock1 addBlock whereBlock0*/
        val where = SQLWhere(whereBlock1)

        val fields2 = SQLFields(seq2Seq("CAP".fld, "SDESCRIPTION".fld, "DI".fld, "DIGROUP".fld, "BISJUR".fld, SQLField(name = "ROWNUM", quoted = false, alias = "sys$$simplesys$$rownum".als, isSystem = true)))
        val groupBy = SQLGroupBy("CAP".fld)
        val sqlClass2 = SQLCompoundTable(fields = fields2, from = SQLFrom(table = sqlClass1, alias = "T1".als), where = where, groupsBy = groupBy, ordersBy = SQLOrdersBy("SCAPTION".fld.ordr, SQLOrderBy("SDESCRIPTION".fld, dir = DescOrderBy)))
        //val sqlClass4 = OracleTableSQL(fields = fields2, table = SQLTable(name = "CCC", alias = "T1"), where = where)

        /*val fields3 = SQLFields("SCAPTION".fld(alias = "cap"), "SDESCRIPTION".fld, "DI".fld, "DIGROUP".fld, "BISJUR".fld)
        val sqlClass3 = OracleTableSQL(fields3, subSQL = Some(sqlClass2))*/

        //logger debug (newLine + fields2.toSQL(4))
        //logger debug (newLine + whereItem.toSQL(4))
        //logger debug (newLine + fields2.toSQL(4))
        //logger debug (newLine + whereBlock1.toSQL(4))
        //logger debug (newLine + where.toSQL(4))
        logger debug (newLine + sqlClass1.toSQL(8))
        //logger debug (newLine + sqlClass2.toSQL(4))
        //logger debug (newLine + joins.toSQL(4))
        //logger debug (newLine + groupBy.toSQL(4))
        //logger debug (newLine + sqlClass1.toInsertSQL(4))
        //logger debug (newLine + sqlClass4.toUpdateSQL(4))
        //logger debug (newLine + sqlClass4.toDeleteSQL(4))
        //logger debug (newLine + joins.toSQL(4))
    }

    test("1") {
        val fields = SQLFields(
            seq2Seq(SQLField(name = "SCAPTION", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "SDESCRIPTION", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "DI", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "DIGROUP", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "BISJUR", tableOwner = SQLTable(name = "CMN_CONTRACTOR")))
        )

        val fields1 = SQLFields(
            seq2Seq(SQLField(name = "SCAPTION", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "SDESCRIPTION", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "DI", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "DIGROUP", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "BISJUR", tableOwner = SQLTable(name = "CMN_CONTRACTOR")),
                SQLField(name = "SCAPTION", tableOwner = SQLTable(name = "CMN_CONTRACTORGROUP"), alias = "CaptionGroup".als))
        )

        val sqlClass = SQLCompoundTable(fields = fields, from = SQLFrom(table = SQLTable(name = "CMN_CONTRACTOR") /*, alias = "TT".als*/))

        val f1 = SQLField(name = "DI", tableOwner = SQLTable(name = "CMN_CONTRACTORGROUP") /*, alias = "qqqq".als*/)
        val f2 = SQLField(name = "DIGROUP", tableOwner = SQLTable(name = "CMN_CONTRACTOR"))

        val c1 = SQLJoinCondition(field = f1, operator = opIdEquals, fieldJoin = f2)
        val join = SQLJoin(joinType = SQLInnerJoinClause, joinFrom = SQLJoinFrom(table = SQLTable(name = "CMN_CONTRACTORGROUP"), alias = "T2".als), conditions = SQLJoinConditions(c1))

        val sqlClass2 = SQLCompoundTable(fields = fields1, from = SQLFrom(table = sqlClass, alias = "T1".als), joins = SQLJoins(join))


        //logger debug (newLine + fields.sqlFieldsWithoutTableOwner.toSQL())
        //logger debug (newLine + sqlClass.toSQL())
        logger debug (newLine + sqlClass2.toSQL())
    }

    test("11") {
        val fields = SQLFields(
            seq2Seq(SQLField(name = "SCAPTION", tableOwner = SQLTable(name = "T0")),
                SQLField(name = "SDESCRIPTION", tableOwner = SQLTable(name = "T0")),
                SQLField(name = "DI", tableOwner = SQLTable(name = "T1")),
                SQLField(name = "DIGROUP", tableOwner = SQLTable(name = "T0")),
                SQLField(name = "BISJUR", tableOwner = SQLTable(name = "T0")),
                SQLField(name = "SJURNAME", tableOwner = SQLTable(name = "T1")))
        )

        val f1 = SQLField(name = "DI", tableOwner = SQLTable(name = "T0"))
        val f2 = SQLField(name = "DI", tableOwner = SQLTable(name = "T1"))

        val c1 = SQLJoinCondition(field = f1, operator = opIdEquals, fieldJoin = f2)
        val join = SQLJoin(joinType = SQLInnerJoinClause, joinFrom = SQLJoinFrom(table = SQLTable(name = "CMN_JURCONTRACTOR"), alias = "T1".als), conditions = SQLJoinConditions(c1))

        val sqlClass = SQLCompoundTable(fields = fields, from = SQLFrom(table = SQLTable(name = "CMN_CONTRACTOR"), alias = "T0".als), joins = SQLJoins(join))

        logger debug (newLine + sqlClass.toSQL())
    }

    test("2") {
        //val whereItem = SQLWhereBlock.apply1(SQLWhereBlock.apply1(SQLWhereBlock.apply1(SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValuePlaceHolder) , SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValuePlaceHolder))))
        //val whereItem = SQLWhereBlock.apply1(SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValuePlaceHolder), SQLWhereItem("SDESCRIPTION".fld, opIdEquals, SQLValuePlaceHolder))
        //logger debug (newLine + whereItem.toSQL(4))
    }

    test("JurContractorBo InnerJoin ContractorGroupBO") {
        /*SELECT T1."SCAPTION",
                   T1."SDESCRIPTION",
                   T2."DI",
                   T1."DIGROUP",
                   T1."BISJUR",
                   T2."SJURNAME",
                   T3.groupCaption,
                   T3."DIPARENT"
            FROM "CMN_CONTRACTOR" T1
            INNER JOIN "CMN_JURCONTRACTOR" T2 ON (T2."DI" = T1."DI")
            INNER JOIN
                (
                    SELECT T4."SCAPTION" AS groupCaption,
                           T4."DIPARENT",
                           T4."DI"
                    FROM "CMN_CONTRACTORGROUP" T4

                ) T3 ON (T3."DI" = T1."DIGROUP")
            WHERE
                  (T1."BISJUR" = 1)*/

        val fields = SQLFields(
            Seq(SQLField(name = "SCAPTION"),
                SQLField(name = "SDESCRIPTION"),
                SQLField(name = "DI", tableOwner = SQLTable(name = "T2", quoted = false)),
                SQLField(name = "DIGROUP"),
                SQLField(name = "BISJUR"),
                SQLField(name = "SJURNAME", tableOwner = SQLTable(name = "T2", quoted = false)),
                SQLField(name = "groupCaption", tableOwner = SQLTable(name = "T3", quoted = false)),
                SQLField(name = "DIPARENT", tableOwner = SQLTable(name = "T3", quoted = false))))

        val j1 = SQLJoin(joinType = SQLInnerJoinClause, joinFrom = SQLJoinFrom(table = SQLTable(name = "CMN_JURCONTRACTOR"), alias = "T2".als), conditions = SQLJoinConditions(SQLJoinCondition(field = SQLField(name = "DI", tableOwner = SQLTable(name = "T2", quoted = false)), operator = opIdEquals, fieldJoin = SQLField(name = "DI", tableOwner = SQLTable(name = "T1", quoted = false)))))

        val fields1 = SQLFields(
            seq2Seq(SQLField(name = "SCAPTION"),
                SQLField(name = "SDESCRIPTION"),
                SQLField(name = "DI"))
        )

        val t2 = SQLCompoundTable(fields = fields1, from = SQLFrom(table = SQLTable(name = "CMN_CONTRACTORGROUP"), alias = "T4".als))
        val j2 = SQLJoin(
            joinType = SQLInnerJoinClause,
            joinFrom = SQLJoinFrom(table = t2, alias = "T3".als),
            conditions =
              SQLJoinConditions(SQLJoinCondition(field = SQLField(name = "DI", tableOwner = SQLTable(name = "T3", quoted = false)), operator = opIdEquals, fieldJoin = SQLField(name = "DIGROUP", tableOwner = SQLTable(name = "T1", quoted = false))))
        )

        val js = SQLJoins(j1, j2)

        val t1 = SQLCompoundTable(fields = fields, from = SQLFrom(table = SQLTable(name = "CMN_CONTRACTOR"), alias = "T1".als), joins = js, where = SQLWhere(SQLWhereItems(SQLWhereItem(SQLField(name = "DI", tableOwner = SQLTable(name = "T3", quoted = false)), opIdEquals, SQLValuePlaceHolder))/*,SQLWhereItem(SQLField(name = "DI", tableOwner = SQLTable(name = "T3", quoted = false)), opIdEquals, SQLValuePlaceHolder)*/))

        logger debug (newLine + t1.toSQL(5))
    }
}
