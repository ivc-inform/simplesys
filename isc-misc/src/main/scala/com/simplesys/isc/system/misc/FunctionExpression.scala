package com.simplesys.isc.system.misc

class FunctionExpressionString(value: String) {
  def f = FunctionExpression(VarExp(value))
  def strMt = FunctionExpression(StrMethodExp(value))
}

object FunctionExpression {
  def apply(varExpr: VarExp) = new FunctionExpression(varExpr)
}

class FunctionExpression(val varExpr: VarExp) {
  def getExpr = varExpr match {
    case exprFuncVar: VarFuncExp =>
      exprFuncVar.getExpr
    case strMethodExp: StrMethodExp =>
      strMethodExp.getExpr
    case exprVar: VarExp =>
      exprVar.getExpr
    case _ => null
  }
}