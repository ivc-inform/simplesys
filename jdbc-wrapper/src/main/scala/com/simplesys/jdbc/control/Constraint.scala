package com.simplesys.jdbc.control

import com.simplesys.log.Logging
import com.simplesys.common.Strings._

sealed abstract class Constraint extends Logging {
    def log(indent: Int): Unit
}

sealed abstract class ConstraintData extends Logging {
    def log(indent: Int): Unit
}

case class KeyConstraintData(column: BasicClassBOColumn[_]) extends ConstraintData {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "KeyConstraintData")
        column.log(indent + indentSize)
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End KeyConstraintData")
    }
}

case class ReferencedData(groupName: String, objectName: String) extends ConstraintData {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "ReferencedData")
        logger trace spaces(indent) + s"groupName: ${groupName}, objectName: ${objectName}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End ReferencedData")
    }
}

case class ForignKeyConstraintData(column: BasicClassBOColumn[_], referencedColumn: ReferencedData, isMandatory: Boolean) extends ConstraintData {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "ForignKeyConstraintData")
        column.log(indent + indentSize)
        referencedColumn.log(indent + indentSize)
        logger trace spaces(indent) + s"isMandatory: ${isMandatory}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End ForignKeyConstraintData")
    }
}

case class PrimaryKey(name: String, constraintDate: KeyConstraintData*) extends Constraint {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "PrimaryKey")
        constraintDate.foreach(_.log(indent + indentSize))
        logger trace spaces(indent) + s"name: ${name}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "EndPrimaryKey")
    }
}

case class MigratedPrimaryKey(name: String, constraintDate: KeyConstraintData*) extends Constraint {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "MigratedPrimaryKey")
        constraintDate.foreach(_.log(indent + indentSize))
        logger trace spaces(indent) + s"name: ${name}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End MigratedPrimaryKey")
    }
}

case class UniqueKey(name: String, constraintDate: KeyConstraintData*) extends Constraint {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "UniqueKey")
        constraintDate.foreach(_.log(indent + indentSize))
        logger trace spaces(indent) + s"name: ${name}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End UniqueKey")
    }
}

case class ForignKey(name: String, constraintDate: ForignKeyConstraintData*) extends Constraint {
    def log(indent: Int) {
        logger trace spaces(indent) + fill(commentLength - indent, "-", "ForignKey")
        constraintDate.foreach(_.log(indent + indentSize))
        logger trace spaces(indent) + s"name: ${name}"
        logger trace spaces(indent) + fill(commentLength - indent, "-", "End ForignKey")
    }
}