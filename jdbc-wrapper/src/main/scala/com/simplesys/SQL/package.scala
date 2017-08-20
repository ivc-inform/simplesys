package com.simplesys

import com.simplesys.SQL.Gen._
import com.simplesys.SQL.Gen.SQLOrderBy
import com.simplesys.SQL.Gen.SQLField
import com.simplesys.SQL.Gen.SQLTable
//import com.simplesys.common.Strings._
import scala.reflect.ClassTag

package object SQL {
    abstract class HeightFont

    case object UpperCaseFont extends HeightFont
    case object LowerCaseFont extends HeightFont

    var fontHeight: HeightFont = UpperCaseFont

    implicit class HeightFontClass(inStr: String) {
        def toHeightFont = fontHeight match {
            case UpperCaseFont => inStr.toUpperCase
            case LowerCaseFont => inStr.toLowerCase
        }

        def fld = SQLField(name = inStr)
        def tbl = SQLTable(name = inStr)
        def v = SQLValue(value = inStr)
        def als = SQLAlias(name = inStr)
    }

    implicit class IntOps(value: Int) {
        def v = SQLValue(value)
    }

    implicit class FieldOpt(field: SQLField) {
        def ordr = SQLOrderBy(field = field, dir = AscOrderBy)
    }

    implicit def seq2Seq[T: ClassTag](seq: T*): Seq[T] = seq
}
