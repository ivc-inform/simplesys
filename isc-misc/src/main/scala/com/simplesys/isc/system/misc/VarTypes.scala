package com.simplesys.isc.system.misc

import com.simplesys.json.UnquotedString
import com.simplesys.common.JVM.Strings._

object VarExp {
    def apply(rHandExpr: String) = new VarExp(rHandExpr)
    implicit def f(in: String) = FunctionExpression(VarExp(in))
}

class VarExp(val rHandExpr: String) {
    override def toString = s"VarExp (rHandExpr: ${rHandExpr}})"
    def getExpr = UnquotedString(if (rHandExpr.isEmpty) "".dblQuoted else rHandExpr)
}

object StrMethodExp {
    def apply(body: String) = new StrMethodExp(body)
    implicit def f(in: String) = FunctionExpression(StrMethodExp(in))

}

class StrMethodExp(val body: String) extends VarExp(body) {
    override def toString = s"StringMethod (body: ${body})"
    override def getExpr = StringMethod("%s" format body)
}

/*
  1. Если Функция заносится в виде function funcName(b,s) {..}, тогда к выдаче необходимо дать:
    1.1 Если функция находится в очереди комманд (enqueue = true) то выдаем: указатель на эту ф-цию т.е. ее имя, которое должно быть присвоено в литерале таким образом {"onClick" : funcName} т.е. имя должно быть без двойных кавычек
        и разного рода скобок
    1.2 Если нет то выдаем общее выражение функции обернутое в UnquotedString
  2. Если Функция заносится в виде var f = function (b,s) {..}, это можно узнать по отсутствию FuncName тогда к выдаче необходимо дать:
    2.1 Если функция находится в очереди комманд (enqueue = true) то выдаем: строковое представление переменной f т.е. ее имя, которое должно быть присвоено в литерале таким образом {"onClick" : "f(b,s)"} т.е. имя должно быть с указанием
        значений для параметров , либо наименования параметров todo ???
    2.2 Если нет тогда {"onClick" : f(b,s)}
*/

object VarFuncExp {
    def apply(enqueue: Boolean, variableName: String, funcName: String, funcBody: String, funcParams: Seq[String]) = new VarFuncExp(enqueue, variableName, funcName, funcBody, funcParams)
}

class VarFuncExp(val enqueue: Boolean, val variableName: String, val funcName: String, val funcBody: String, val funcParams: Seq[String]) extends VarExp(mkFunctionDecl(funcName, funcBody, funcParams)) {
    override def toString = "VarFuncExpr (%s)" format mkFunctionDecl(funcName, funcBody, funcParams)

    //todo  Проверять ???
    override def getExpr = {
        funcName match {
            case "" =>
                if (enqueue)
                    "%s(%s)" format(variableName, funcParams mkString ",")
                else
                    UnquotedString(mkFunctionDecl(funcName, funcBody, funcParams))
            case _ =>
                if (enqueue)
                    UnquotedString("%s" format funcName)
                else
                    UnquotedString(mkFunctionDecl(funcName, funcBody, funcParams))
        }
    }
}

