package com.simplesys.js

import virtualization.lms.common.{LiftString, Base}
import com.simplesys.lms.common.internal.BaseExp
import js.JSNestedCodegen
import com.simplesys.script.JsStringWriter
import com.simplesys.log.Logging
import com.simplesys.lms.common.StructExp

trait PersonDSL extends Base {
  type Person
  def newPerson(map: Map[String, Rep[Any]]): Rep[Person]
  def infix_name(person: Rep[Person]): Rep[String]
}

trait PersonExp extends PersonDSL with BaseExp {
  this: StructExp =>

  override type Person = Map[String, Rep[Any]]
  override def newPerson(_map: Map[String, Rep[Any]]) = struct(SimpleMapTag[Person], _map)
  override def infix_name(person: Rep[Person]) = field[String](person, "name")
}

trait StructProg extends LiftString {
  this: PersonDSL =>
  def test(name: Rep[String]): Rep[String] = {

    val map = Map.newBuilder[String, Rep[String]]
    map += "a" -> "aaa"
    map += "b" -> "bbb"
    map += "c" -> "ccc"
    map += "d" -> "ddd"

    val person:Rep[Person] = newPerson(map.result)

    //person.value
    person.name
  }
}

class TestStruct extends FileDiffSuite with Logging {

  val str = new JsStringWriter(false)

  test("1") {

    val prog = new StructProg with PersonExp with StructExp with JSLiteralExp
    val codegen = new JSNestedCodegen with JSGenStruct with JSGenLiteral {
      val IR: prog.type = prog
    }
    codegen.emitSource(prog.test, "test", str)
    logger debug("%s", str)
  }

}