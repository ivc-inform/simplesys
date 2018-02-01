package com.simplesys.javascript

import java.io.File

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.log.Logging

import scala.io.Codec._
import scala.io.Source

class JavaScript(protected val proxy: Seq[FunctionResult]) extends Logging {

    def getFunction(functionName: String): String = {
        val res: Seq[FunctionResult] = proxy.filter(_.name === functionName)
        if (res.isEmpty) {
            logger warn s"Функция '${functionName}' не найдена."
            strEmpty
        }
        else if (res.length > 1) {
            throw new RuntimeException(s"Для функции '${functionName}' неоднозначный выбор.")
        }
        else
            res(0).toString
    }
}


object JavaScript extends JavaScriptParser with Logging {
    def logError(msg: NoSuccess): JavaScript = {
        logger error (s"Error parsing : ${msg}")
        new JavaScript(Seq.empty[FunctionResult])
    }

    def apply(inputString: String): JavaScript =
        parseAll(functions, inputString) match {
            case Success(funcs, _) => new JavaScript(funcs)
            case failure: NoSuccess => logError(failure)
        }

    def apply(file: File): JavaScript =
        parseAll(functions, Source.fromFile(file)(UTF8).reader()) match {
            case Success(funcs, _) => new JavaScript(funcs)
            case failure: NoSuccess => logError(failure)
        }
}
