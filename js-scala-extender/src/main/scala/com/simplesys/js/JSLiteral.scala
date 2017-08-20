package com.simplesys.js

import com.simplesys.lms.common.internal.BaseExp

trait JSLiteral extends js.JSLiteral

trait JSLiteralExp extends BaseExp with js.JSLiteralExp {

  private class Self(members: Map[String, Exp[JSLiteral] => Exp[Any]]) extends Exp[JSLiteral] with Serializable {

    import scala.collection.mutable.{Map => MutMap}

    private val pending: MutMap[String, Exp[JSLiteral] => Exp[Any]] = MutMap(members.toSeq: _*)
    private val done: MutMap[String, Exp[Any]] = MutMap.empty
    private def eval(member: String): Exp[Any] = {
      val x = pending(member)(this)
      pending.remove(member)
      done.update(member, x)
      x
    }
    def apply(member: String): Exp[Any] = done.getOrElseUpdate(member, eval(member))
  }

  override def newJSLiteral(args: (String, Rep[JSLiteral] => Rep[_])*): Exp[JSLiteral] = {

    val self = new Self(args.toMap)
    val argNames = args.toList.map(_._1)
    val evalArgs = argNames.map(x => x -> self(x))

    logger.debug("Log EvalArgs")
    evalArgs foreach (logger.debug("%s", _))
    logger.debug("End Log EvalArgs")

    JSLiteralDef(evalArgs.filter(_._2 != Const(null)))
  }
}

trait JSGenLiteral extends JSGenBase with js.JSGenLiteral {
  val IR: JSLiteralExp
}
