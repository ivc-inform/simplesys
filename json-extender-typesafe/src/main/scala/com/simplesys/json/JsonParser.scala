package com.simplesys.json

import scala.util.parsing.combinator.{JavaTokenParsers, RegexParsers}
import com.simplesys.common.Strings._

import scala.annotation.migration

/*
   GRAMMAR

   value ::= obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false".
   obj ::= "{" [members] "}".
   arr ::= "[" [values] "]".
   members ::= member {"," member}.
   member ::= stringLiteral ":" value.
   values ::= value {"," value}.
*/

trait JsonParser extends JavaTokenParsers {

    def jsonValue: Parser[JsonElement] =
        (jsonObject
          | jsonArray
          | stringLiteral ^^ (_.toJsonString)
          | floatingPointNumber ^^ (_.toJsonBigDecimal)
          | "null" ^^^ JsonNull
          | "undefined" ^^^ JsonUndefined
          | "true" ^^ (_.toJsonBoolean)
          | "false" ^^ (_.toJsonBoolean)
          | failure("illegal  start of value"))

    def jsonObject: Parser[JsonObject] = "{" ~> repsep(jsonMember, ",") <~ "}" ^^ (JsonObject() ++ _)

    def jsonArray: Parser[JsonList] = "[" ~> repsep(jsonValue, ",") <~ "]" ^^ (JsonList() ++ _)

    def jsonMember: Parser[(String, JsonElement)] = stringLiteral ~! ":" ~! jsonValue ^^ {
        case name ~ ":" ~ value => (name.delQuote, value)
    }
}
