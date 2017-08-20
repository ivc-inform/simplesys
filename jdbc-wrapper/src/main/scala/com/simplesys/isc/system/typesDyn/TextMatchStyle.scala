package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime

sealed abstract trait TextMatchStyle {
    def toSQL: String
    def column(column: String): String
    def getBindPlaceholder = "?"
}

case object txtMchStyleNull extends TextMatchStyle {
    override def toString = ""
    override def toSQL: String = ""
    override def column(column: String): String = column
}

case object txtMchStyleExact extends TextMatchStyle {
    override def toString = "exact"
    override def toSQL: String = "="
    override def column(column: String): String = column
}

case object txtMchStyleSubstring extends TextMatchStyle {
    override def toString = "substring"
    override def toSQL: String = "LIKE"
    override def column(column: String): String = column
    override def getBindPlaceholder: String = "'%'|| ? ||'%'"
}

case object txtMchStyleStartWith extends TextMatchStyle {
    override def toString = "startsWith"
    override def toSQL: String = "LIKE"
    override def column(column: String): String = column
    override def getBindPlaceholder: String = "? ||'%'"
}

object TextMatchStyle {
    val values = SealedEnumRuntime.values[TextMatchStyle]
    private val mappedKeys: Map[String, TextMatchStyle] = values.map(x => (x.toString, x))(collection.breakOut)
    def getObject(objName: String): TextMatchStyle = mappedKeys(objName)
}

