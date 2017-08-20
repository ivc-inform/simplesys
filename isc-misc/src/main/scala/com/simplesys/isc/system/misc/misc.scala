package com.simplesys.isc.system

import com.simplesys.json.{UnquotedString, Unquoted_String}

package object misc {
    def mkFunctionDecl(funcName: String, funcBody: String, funcParams: Seq[String]) = funcName match {
        case "" => "function (%s)%s" format(funcParams mkString ",", funcBody)
        case str => "function %s(%s)%s" format(funcName, funcParams mkString ",", funcBody)
    }

    implicit def unq1(string: String) = new Unquoted_String(string)
    implicit def unq2(string: String) = UnquotedString(string)
    implicit def unq3(string: UnquotedString): String = string.toString

    implicit def string_FunctionExpression(s: String) = new FunctionExpressionString(s)
    implicit def str_FunctionExpression(s: String) = new FunctionExpression(VarExp(s))

    implicit def string_URL(path: String) = new URLString(path)
    implicit def str_URL(path: String) = URL(path)

    implicit def str_URL(path: Option[String]) = URL(path getOrElse "")

    implicit def string_URN(path: String) = new URNString(path)

    implicit def str_URN(path: String) = URN(path)

    implicit def str_URN(path: Option[String]) = URN(path getOrElse "")

    implicit def string_XPathExpression(value: String) = new XPathExpressionString(value)

    implicit def str_XPathExpression(value: String) = XPathExpression(value)

    implicit def string_CSSStyleName(value: String) = new CSSStyleNameString(value)

    implicit def str_CSSStyleName(value: String) = CSSStyleName(value)

    implicit def string_SCClassName(value: String) = new SCClassNameString(value)

    implicit def str_SCClassName(value: String) = SCClassName(value)

    implicit def string_Color(value: String) = new ColorString(value)

    implicit def string_Color(value: Int) = new ColorString(value toString)

    implicit def str_Color(value: String) = Color(value)

    implicit def str_Color(value: Int) = Color(value toString)

    implicit def stringNumber(value: String) = new NumberString(value)

    implicit def int_Number(value: Int) = Number(value.toString)

    implicit def dbl_Number(value: Double) = Number(value.toString)

    implicit def str_Number(value: String) = Number(value)

    implicit def nbr_Number(value: Number): String = value.toString

    implicit def string_Date(value: String) = new DateString(value)

    implicit def str_Date(value: String) = Date(value)

    implicit def string_Time(value: String) = new TimeString(value)

    implicit def str_Time(value: String) = Time(value)

    implicit def string_RelativeDate(value: String) = new RelativeDateString(value)

    implicit def str_RelativeDate(value: String) = RelativeDate(value)

    implicit def boolean2Bool(in: Boolean): Bool = Bool(in)

    implicit def bool2Boolean(in: Bool): Boolean = in match {
        case null => false
        case _ =>
            in.value match {
                case bool: Boolean => bool
                case _ => false
            }
    }

    implicit def str2String(in: String) = new Str_str(in)
}