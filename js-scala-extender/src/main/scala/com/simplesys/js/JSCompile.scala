package com.simplesys.js

import reflect.NameTransformer
import com.simplesys.lms.common.internal.BaseExp
import java.io.PrintWriter
import com.simplesys.lms.internal.GenericCodegen
import com.simplesys.isc.system.misc._
import com.simplesys.common.Strings._

trait JSCodegen extends GenericCodegen with js.JSCodegen {

  import IR._

  override def emitSource0[B](f: () => Exp[B], methName: String, stream: PrintWriter)(implicit mB: Manifest[B]): List[(Sym[Any], Any)] = {
    val y = reifyBlock(f())
    emitSource(Nil, y, methName, stream)
  }

  override def emitSource[A: Manifest](args: List[Sym[_]], body: Block[A], name: String, out: PrintWriter) = {
    val argsStr = args.map(quote).mkString(", ")

    withStream(out) {
      stream.println("function" + (if (name.isEmpty) "" else (" " + name)) + "(" + argsStr + ") {")
      emitBlock(body)

      stream.println("return " + quote(getBlockResult(body)) + ";")

      stream.println("};")
      stream.flush
    }
    getFreeDataBlock(body)
  }

  override def literalObjectDef(fields: Seq[(String, Exp[_])]): String = {
    fields.map({
      case (name, value) => NameTransformer.decode(name).dblQuoted + ":" + quote(value)
    }).mkString("{", ",", "}")
  }

  override def literalObjectSelect(receiver: Exp[_], field: String): String = {
    val decodedField = NameTransformer.decode(field)
    if (decodedField == field)
      quote(receiver) + "." + field
    else
      quote(receiver) + "[" + decodedField.dblQuoted + "]"
  }

  override def quote(x: Exp[Any]): String = x match {
    case Const(Bool(x)) => x.toString
    case Const(Number(number)) =>
      try {
        if (number.indexOf(".") != -1) {
          val dbl = number.toDouble
        }
        else {
          val int = number.toInt
        }

        number
      }
      catch {
        case ex: NumberFormatException =>
          number.dblQuoted
      }
    case _ => super.quote(x)
  }

  override def emitValDef(sym: Sym[Any], rhs: String): Unit = {
    stream.println("var " + quote(sym) + "=" + rhs + ";")
  }

  override def emitAssignment(lhs: String, rhs: String): Unit = {
    stream.println(lhs + "=" + rhs + ";")
  }

  def emitSetterDef(rhs: String): Unit = {
    stream.println(rhs + ";")
  }
}

trait JSGenBase extends JSCodegen {
  val IR: BaseExp
}