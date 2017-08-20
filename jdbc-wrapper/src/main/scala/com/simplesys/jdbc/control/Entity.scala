package com.simplesys.jdbc.control

import com.simplesys.SQL.Gen.SQLAlias
import com.simplesys.log.Logging
import com.simplesys.common.Strings._

trait Entity[T] extends Logging {
    val alias: SQLAlias
    protected val isDataSet: Boolean
    val quoted: Boolean
    val constraints: Seq[Constraint]

    def log(indent: Int = 0) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "Entity")
        //constraints.foreach(_.log(indent + indentSize))
        logger trace spaces(indent) + s"class: ${getClass.getSimpleName}, alias: ${alias.toSQL()}, isDataSet: ${isDataSet}, quoted: ${quoted}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End Entity")
    }
}