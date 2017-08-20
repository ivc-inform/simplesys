package com.simplesys.js

import com.simplesys.lms.common.internal.BaseExp

trait JSGenProxy extends JSGenBase with js.JSGenBase with js.JSGenEffect {
  val IR: BaseExp with js.JSProxyExp

  import IR._

  override def emitValDef(sym: Sym[Any], rhs: String) {
    if (rhs.contains("$default$"))
      super.emitValDef(sym, "undefined")
    else
      super.emitValDef(sym, rhs)
  }

  override def emitVarDef(sym: Sym[Any], rhs: String) {
    if (rhs.contains("$default$"))
      super.emitValDef(sym, "undefined")
    else
      super.emitValDef(sym, rhs)
  }


  private def getReceiver(receiver: String): String = {
    receiver match {
      case null => ""
      case "" => ""
      case str => str + "."
    }
  }

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case MethodCall(receiver, method, args) => emitValDef(sym,
      getReceiver(quote(receiver)) + method + args.map(quote).mkString("(", ",", ")"))
    case SuperMethodCall(receiver, parentConstructor, method, args) => emitValDef(sym,
      (parentConstructor match {
        case Some(parentConstructor) => quote(parentConstructor);
        case None => "Object"
      }) +
        ".prototype." + method + ".call" + (receiver :: args).map(quote).mkString("(", ",", ")"))
    case FieldAccess(receiver, field) => emitValDef(sym,
      getReceiver(quote(receiver)) + field)
    case FieldUpdate(receiver, field, value) => emitValDef(sym,
      getReceiver(quote(receiver)) + field + " = " + quote(value))
    case _ => super.emitNode(sym, rhs)
  }
}