package com.simplesys.js

import virtualization.lms.common.{EffectExp, Base}
import js.JSGenEffect

trait JSSeqBase extends Base {
  implicit def repSeqToSeqOps[T: Manifest](a: Rep[Seq[T]]) = new SeqOps[T](a)

  class SeqOps[T: Manifest](seq: Rep[Seq[T]]) {}

  def seq[T: Manifest](xs: Rep[T]*): Rep[Seq[T]]
}

trait JSSeqExp extends JSSeqBase with EffectExp {
  case class SeqLiteral[T: Manifest](xs: Seq[Exp[T]]) extends Def[Seq[T]]

  def seq[T: Manifest](xs: Exp[T]*) = reflectEffect(SeqLiteral(xs.toSeq))
}

trait JSGenSeq extends JSGenEffect {
  val IR: JSSeqExp

  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case SeqLiteral(xs) => emitValDef(sym, (xs).map(quote).mkString("[", ",", "]"))
    case _ => super.emitNode(sym, rhs)
  }

}

trait LiftSeq {
  this: Base =>

  implicit def seqToRepObj[T: Manifest](seq: Seq[T]) = unit(seq)
}
