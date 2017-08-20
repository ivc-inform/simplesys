package com.simplesys.javascript

import scala.util.parsing.combinator._

case class FunctionResult(name: String, paramList: String, body: String) {
    override def toString: String = s"function ${name} (${paramList}) ${body}"
}

class JavaScriptParser extends RegexParsers {
    def functions: Parser[Seq[FunctionResult]] = rep(function) ^^ {
        case func => Seq() ++ func
    }
    def function: Parser[FunctionResult] = "function" ~ functionName ~ paramList ~ functionBody ^^ {
        case ("function" ~ funcName ~ params ~ body) => FunctionResult(funcName, params, body)
    }
    def functionName: Parser[String] = """\w+""".r
    def paramList: Parser[String] = "(" ~> """(?s)[^\)]*""".r <~ ")" ^^ {
        case params => params
    }
    def someCode: Parser[String] = """(s*)[^\{\}]*""".r
    def functionBody: Parser[String] = "{" ~> someCode ~ opt(functionBody) ~ someCode <~ "}" ^^ {
        case (code1 ~ intBody ~ code2) => "{" + code1 + intBody.getOrElse("") + code2 + "}"
    }
}