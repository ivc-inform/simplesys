package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait KindOperatorId

case object IsDefault extends KindOperatorId
case object IsBetween extends KindOperatorId
case object IsInList extends KindOperatorId
case object IsNull extends KindOperatorId

sealed abstract trait OperatorId {
    val kind:KindOperatorId = IsDefault

    def toSQL: String
    def getColumn(column: String): String = column
    def getBindPlaceholder: String = "?"
}

/*sealed abstract trait BetweenOperatorId extends OperatorId

sealed abstract trait NullOperatorId extends OperatorId

sealed abstract trait InOperatorId extends OperatorId*/

case object opIdNull extends OperatorId {
    override def toString = ""
    override def toSQL: String = ""
}

case object opIdEquals extends OperatorId {
    override def toString = "equals"
    override def toSQL: String = "="
}

case object opIdNotEqual extends OperatorId {
    override def toString = "notEqual"
    override def toSQL: String = "!="

}

case object opIdIEquals extends OperatorId {
    override def toString = "iEquals"
    override def toSQL: String = "="
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder = "UPPER(?)"
}

case object opIdINotEqual extends OperatorId {
    override def toString = "iNotEqual"
    override def toSQL: String = "!="
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdGreaterThan extends OperatorId {
    override def toString = "greaterThan"
    override def toSQL: String = ">"

}

case object opIdLessThan extends OperatorId {
    override def toString = "lessThan"
    override def toSQL: String = "<"

}

case object opIdGreaterOrEqual extends OperatorId {
    override def toString = "greaterOrEqual"
    override def toSQL: String = ">="

}

case object opIdLessOrEqual extends OperatorId {
    override def toString = "lessOrEqual"
    override def toSQL: String = "<="

}

case object opIdContains extends OperatorId {
    override def toString = "contains"
    override def toSQL: String = "LIKE"

    override def getBindPlaceholder: String = "'%'|| ? ||'%'"
}

case object opIdStartsWith extends OperatorId {
    override def toString = "startsWith"
    override def toSQL: String = "LIKE"

    override def getBindPlaceholder: String = "? ||'%'"
}

case object opIdEndsWith extends OperatorId {
    override def toString = "endsWith"
    override def toSQL: String = "LIKE"

    override def getBindPlaceholder: String = "'%'|| ?"
}

case object opIdIContains extends OperatorId {
    override def toString = "iContains"
    override def toSQL: String = "LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "'%'|| UPPER(?) ||'%'"
}

case object opIdIStartsWith extends OperatorId {
    override def toString = "iStartsWith"
    override def toSQL: String = "LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "UPPER(?) ||'%'"
}

case object opIdIEndsWith extends OperatorId {
    override def toString = "iEndsWith"
    override def toSQL: String = "LIKE"

    override def getBindPlaceholder: String = "'%'|| UPPER(?)"
}

case object opIdNotContains extends OperatorId {
    override def toString = "notContains"
    override def toSQL: String = "NOT LIKE"

    override def getBindPlaceholder: String = "'%'|| ? ||'%'"
}

case object opIdNotStartsWith extends OperatorId {
    override def toString = "notStartsWith"
    override def toSQL: String = "NOT LIKE"

    override def getBindPlaceholder: String = "? ||'%'"
}

case object opIdNotEndsWith extends OperatorId {
    override def toString = "notEndsWith"
    override def toSQL: String = "NOT LIKE"

    override def getBindPlaceholder: String = "'%'|| ?"
}

case object opIdINotContains extends OperatorId {
    override def toString = "iNotContains"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "'%'|| UPPER(?) ||'%'"
}

case object opIdINotStartsWith extends OperatorId {
    override def toString = "iNotStartsWith"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "UPPER(?) ||'%'"
}

case object opIdINotEndsWith extends OperatorId {
    override def toString = "iNotEndsWith"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "'%'|| UPPER(?)"
}

case object opIdIBetweenInclusive extends OperatorId {
    override def toString = "iBetweenInclusive"
    override def toSQL: String = "BETWEEN"
    override def getColumn(column: String): String = s"UPPER(${column})"
    override def getBindPlaceholder: String = "UPPER(?)"
    override val kind: KindOperatorId = IsBetween
}

//============ new 01/02/2014
case object opIdIMatchesPattern extends OperatorId {
    override def toString = "iMatchesPattern"
    override def toSQL: String = ""
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdMatchesPattern extends OperatorId {
    override def toString = "matchesPattern"
    override def toSQL: String = ""

}

case object opIdContainsPattern extends OperatorId {
    override def toString = "containsPattern"
    override def toSQL: String = ""

}

case object opIdIContainsPattern extends OperatorId {
    override def toString = "iContainsPattern"
    override def toSQL: String = ""
    override def getColumn(column: String): String = s"UPPER(${column})"
}
//============

case object opIdRegexp extends OperatorId {
    override def toString = "regexp"
    override def toSQL: String = ""

}

case object opIdIregexp extends OperatorId {
    override def toString = "iregexp"
    override def toSQL: String = ""
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdIsNull extends OperatorId {
    override def toString = "isNull"
    override def toSQL: String = "IS NULL"
    override val kind: KindOperatorId = IsNull
}

case object opIdNotNull extends OperatorId {
    override def toString = "notNull"
    override def toSQL: String = "IS NOT NULL"
    override val kind: KindOperatorId = IsNull
}

case object opIdInSet extends OperatorId {
    override def toString = "inSet"
    override def toSQL: String = "IN"
    override val kind: KindOperatorId = IsInList
}

case object opIdNotInSet extends OperatorId {
    override def toString = "notInSet"
    override def toSQL: String = "NOT IN"
    override val kind: KindOperatorId = IsInList
}

case object opIdEqualsField extends OperatorId {
    override def toString = "equalsField"
    override def toSQL: String = "="
}

case object opIdNotEqualField extends OperatorId {
    override def toString = "notEqualField"
    override def toSQL: String = "!="

}

case object opIdGreaterThanField extends OperatorId {
    override def toString = "greaterThanField"
    override def toSQL: String = ">"

}

case object opIdLessThanField extends OperatorId {
    override def toString = "lessThanField"
    override def toSQL: String = "<"

}

case object opIdGreaterOrEqualField extends OperatorId {
    override def toString = "greaterOrEqualField"
    override def toSQL: String = ">="

}

case object opIdLessOrEqualField extends OperatorId {
    override def toString = "lessOrEqualField"
    override def toSQL: String = "<="

}

case object opIdContainsField extends OperatorId {
    override def toString = "containsField"
    override def toSQL: String = "LIKE"

}

case object opIdStartsWithField extends OperatorId {
    override def toString = "startsWithField"
    override def toSQL: String = "LIKE"

}

case object opIdEndsWithField extends OperatorId {
    override def toString = "endsWithField"
    override def toSQL: String = "LIKE"

}

//============ new 01/02/2014
case object opIdIContainsField extends OperatorId {
    override def toString = "iContainsField"
    override def toSQL: String = "LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdIStartsWithField extends OperatorId {
    override def toString = "iStartsWithField"
    override def toSQL: String = "LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdIEndsWithField extends OperatorId {
    override def toString = "iEndsWithField"
    override def toSQL: String = "LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdNotContainsField extends OperatorId {
    override def toString = "notContainsField"
    override def toSQL: String = "NOT LIKE"

}

case object opIdNotStartsWithField extends OperatorId {
    override def toString = "notStartsWithField"
    override def toSQL: String = "NOT LIKE"

}

case object opIdNotEndsWithField extends OperatorId {
    override def toString = "notEndsWithField"
    override def toSQL: String = "NOT LIKE"

}

case object opIdINotContainsField extends OperatorId {
    override def toString = "iNotContainsField"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdINotStartsWithField extends OperatorId {
    override def toString = "iNotStartsWithField"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}

case object opIdINotEndsWithField extends OperatorId {
    override def toString = "iNotEndsWithField"
    override def toSQL: String = "NOT LIKE"
    override def getColumn(column: String): String = s"UPPER(${column})"
}
//============

case object opIdAnd extends OperatorId {
    override def toString = "and"
    override def toSQL: String = "AND"

}

case object opIdNot extends OperatorId {
    override def toString = "not"
    override def toSQL: String = "NOT"

}

case object opIdOr extends OperatorId {
    override def toString = "or"
    override def toSQL: String = "OR"

}

case object opIdBetween extends OperatorId {
    override def toString = "between"
    override def toSQL: String = "BETWEEN"
    override val kind: KindOperatorId = IsBetween
}

case object opIdBetweenInclusive extends OperatorId {
    override def toString = "betweenInclusive"
    override def toSQL: String = "BETWEEN"
    override val kind: KindOperatorId = IsBetween
}

object OperatorId {
    private val values = SealedEnumRuntime.values[OperatorId]
    private val mappedKeys: Map[String, OperatorId] = values.map(x => (x.toString, x))(collection.breakOut)
    def getObject(objName: String): OperatorId = mappedKeys(objName)
}
