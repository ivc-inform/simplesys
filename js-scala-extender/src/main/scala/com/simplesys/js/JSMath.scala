package com.simplesys.js

import virtualization.lms.util.OverloadHack
import js.{JSProxyExp, JSProxyBase}
import com.simplesys.lms.common.internal.BaseExp
import virtualization.lms.common.Base
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym
import collection.mutable

trait JSMath extends Base with OverloadHack {
  class JSMathClassOps {

    def E = impl_E
    def LN10 = impl_LN10
    def LN2 = impl_LN2
    def LOG10E = impl_LOG10E
    def LOG2E = impl_LOG2E
    def PI = impl_PI
    def SQRT1_2 = impl_SQRT1_2
    def SQRT2 = impl_SQRT2

    def abs[T: Numeric : Manifest](x: Rep[T]) = impl_abs[T](x)
    def acos[T: Numeric : Manifest](x: Rep[T]) = impl_acos[T](x)
    def asin[T: Numeric : Manifest](x: Rep[T]) = impl_asin[T](x)
    def atan[T: Numeric : Manifest](x: Rep[T]) = impl_atan[T](x)
    def atan2[T: Numeric : Manifest](x: Rep[T]) = impl_atan2[T](x)
    def ceil[T: Numeric : Manifest](x: Rep[T]) = impl_ceil[T](x)
    def cos[T: Numeric : Manifest](x: Rep[T]) = impl_cos[T](x)
    def exp[T: Numeric : Manifest](x: Rep[T]) = impl_exp[T](x)
    def floor[T: Numeric : Manifest](x: Rep[T]) = impl_floor[T](x)
    def log[T: Numeric : Manifest](x: Rep[T]) = impl_log[T](x)
    def max[T: Numeric : Manifest](x: Rep[T]*) = impl_max[T](x)
    def min[T: Numeric : Manifest](x: Rep[T]*) = impl_min[T](x)
    def random() = impl_random
    def round[T: Numeric : Manifest](x: Rep[T]) = impl_round[T](x)
    def sin[T: Numeric : Manifest](x: Rep[T]) = impl_sin[T](x)
    def sqrt[T: Numeric : Manifest](x: Rep[T]) = impl_sqrt[T](x)
    def tan[T: Numeric : Manifest](x: Rep[T]) = impl_tan[T](x)
  }

  val Math: Rep[JSMathClassOps]

  def impl_E: Rep[Double]
  def impl_LN10: Rep[Double]
  def impl_LN2: Rep[Double]
  def impl_LOG10E: Rep[Double]
  def impl_LOG2E: Rep[Double]
  def impl_PI: Rep[Double]
  def impl_SQRT1_2: Rep[Double]
  def impl_SQRT2: Rep[Double]

  def impl_abs[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_acos[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_asin[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_atan[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_atan2[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_ceil[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_cos[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_exp[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_floor[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_log[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_max[T: Numeric : Manifest](x: Seq[Rep[T]]): Rep[T]
  def impl_min[T: Numeric : Manifest](x: Seq[Rep[T]]): Rep[T]
  def impl_pow[T: Numeric : Manifest](x: Rep[T], y: Rep[T]): Rep[T]
  def impl_random: Rep[Double]
  def impl_round[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_sin[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_sqrt[T: Numeric : Manifest](x: Rep[T]): Rep[T]
  def impl_tan[T: Numeric : Manifest](x: Rep[T]): Rep[T]

  implicit def repToJSMathClassOps(x: Rep[JSMathClassOps]): JSMathClassOps
}

trait JSMathExp extends JSMath with BaseExp {
  case object JSMathClassOpsVar extends Rep[JSMathClassOps]
  val Math = JSMathClassOpsVar

  case object CaseE extends Def[Double]
  def impl_E = CaseE

  case object CaseLN10 extends Def[Double]
  def impl_LN10 = CaseLN10

  case object CaseLN2 extends Def[Double]
  def impl_LN2 = CaseLN2

  case object CaseLOG10E extends Def[Double]
  def impl_LOG10E = CaseLOG10E

  case object CaseLOG2E extends Def[Double]
  def impl_LOG2E = CaseLOG2E

  case object CasePI extends Def[Double]
  def impl_PI = CasePI

  case object CaseSQRT1_2 extends Def[Double]
  def impl_SQRT1_2 = CaseSQRT1_2

  case object CaseSQRT2 extends Def[Double]
  def impl_SQRT2 = CaseSQRT2

  case class CaseAbs[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_abs[T: Numeric : Manifest](x: Rep[T]) = CaseAbs(x)

  case class CaseAcos[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_acos[T: Numeric : Manifest](x: Rep[T]) = CaseAcos(x)

  case class CaseAsin[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_asin[T: Numeric : Manifest](x: Rep[T]) = CaseAsin(x)

  case class CaseAtan[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_atan[T: Numeric : Manifest](x: Rep[T]) = CaseAtan(x)

  case class CaseAtan2[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_atan2[T: Numeric : Manifest](x: Rep[T]) = CaseAtan2(x)

  case class CaseCeil[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_ceil[T: Numeric : Manifest](x: Rep[T]) = CaseCeil(x)

  case class CaseCos[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_cos[T: Numeric : Manifest](x: Rep[T]) = CaseCos(x)

  case class CaseExp[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_exp[T: Numeric : Manifest](x: Rep[T]) = CaseExp(x)

  case class CaseFloor[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_floor[T: Numeric : Manifest](x: Rep[T]) = CaseFloor(x)

  case class CaseLog[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_log[T: Numeric : Manifest](x: Rep[T]) = CaseLog(x)

  case class CaseMax[T: Numeric : Manifest](x: Seq[Rep[T]]) extends Def[T]
  def impl_max[T: Numeric : Manifest](x: Seq[Rep[T]]) = CaseMax(x)

  case class CaseMin[T: Numeric : Manifest](x: Seq[Rep[T]]) extends Def[T]
  def impl_min[T: Numeric : Manifest](x: Seq[Rep[T]]) = CaseMin(x)

  case class CasePow[T: Numeric : Manifest](x: Rep[T], y: Rep[T]) extends Def[T]
  def impl_pow[T: Numeric : Manifest](x: Rep[T], y: Rep[T]) = CasePow(x, y)

  case object CaseRandom extends Def[Double]
  def impl_random = CaseRandom

  case class CaseRound[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_round[T: Numeric : Manifest](x: Rep[T]) = CaseRound(x)

  case class CaseSin[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_sin[T: Numeric : Manifest](x: Rep[T]) = CaseSin(x)

  case class CaseSqrt[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_sqrt[T: Numeric : Manifest](x: Rep[T]) = CaseSqrt(x)

  case class CaseTan[T: Numeric : Manifest](x: Rep[T]) extends Def[T]
  def impl_tan[T: Numeric : Manifest](x: Rep[T]) = CaseTan(x)

  def repToJSMathClassOps(x: Rep[JSMathClassOps]): JSMathClassOps = new JSMathClassOps
}

trait GenJSMath extends JSGenBase with js.JSGenBase {
  val IR: JSMathExp
  val className = "Math"

  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case CaseE => emitValDef(sym, "%s.E".format(className))
    case CaseLN10 => emitValDef(sym, "%s.LN10".format(className))
    case CaseLN2 => emitValDef(sym, "%s.LN2".format(className))
    case CaseLOG10E => emitValDef(sym, "%s.LOG10E".format(className))
    case CaseLOG2E => emitValDef(sym, "%s.LOG2E".format(className))
    case CasePI => emitValDef(sym, "%s.PI".format(className))
    case CaseSQRT1_2 => emitValDef(sym, "%s.SQRT1_2".format(className))
    case CaseSQRT2 => emitValDef(sym, "%s.SQRT2".format(className))
    case CaseAbs(x) => emitValDef(sym, "%s.abs(%s)".format(className, quote(x)))
    case CaseAcos(x) => emitValDef(sym, "%s.acos(%s)".format(className, quote(x)))
    case CaseAsin(x) => emitValDef(sym, "%s.asin(%s)".format(className, quote(x)))
    case CaseAtan(x) => emitValDef(sym, "%s.atan(%s)".format(className, quote(x)))
    case CaseAtan2(x) => emitValDef(sym, "%s.atan2(%s)".format(className, quote(x)))
    case CaseCeil(x) => emitValDef(sym, "%s.ceil(%s)".format(className, quote(x)))
    case CaseCos(x) => emitValDef(sym, "%s.cos(%s)".format(className, quote(x)))
    case CaseExp(x) => emitValDef(sym, "%s.exp(%s)".format(className, quote(x)))
    case CaseFloor(x) => emitValDef(sym, "%s.floor(%s)".format(className, quote(x)))
    case CaseLog(x) => emitValDef(sym, "%s.log(%s)".format(className, quote(x)))
    case CaseMax(x: Seq[_]) => emitValDef(sym, "%s.max(%s)".format(className, (x map {
      quote
    }).mkString(",")))
    case CaseMin(x: Seq[_]) => emitValDef(sym, "%s.min(%s)".format(className, (x map {
      quote
    }).mkString(",")))
    case CasePow(x, y) => emitValDef(sym, "%s.pow(%s,%s)".format(className, quote(x), quote(y)))
    case CaseRandom => emitValDef(sym, "%s.random()".format(className))
    case CaseRound(x) => emitValDef(sym, "%s.round(%s)".format(className, quote(x)))
    case CaseSin(x) => emitValDef(sym, "%s.sin(%s)".format(className, quote(x)))
    case CaseSqrt(x) => emitValDef(sym, "%s.sqrt(%s)".format(className, quote(x)))
    case CaseTan(x) => emitValDef(sym, "%s.tan(%s)".format(className, quote(x)))
    case _ => super.emitNode(sym, rhs)
  }
}