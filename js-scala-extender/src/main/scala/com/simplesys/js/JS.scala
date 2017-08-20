package com.simplesys.js

import js.{
JSGenTupleOps,
JSGenRegExps,
JSGenVariables,
JSGenArrays,
JSGenObjectOps,
JSGenDynamic,
JSGenStringOps,
JSGenBooleanOps,
JSGenWhile,
JSGenIfThenElse,
JSGenEqual,
JSGenOrderingOps,
JSGenNumericOps,
JSRegExpsExp,
ArraysExp,
DynamicExp,
Arrays,
DynamicBase,
JSRegExps,
JSCodegenOpt}

import virtualization.lms.common.{
VariablesExp,
ObjectOpsExp,
StringOpsExp,
BooleanOpsExp,
WhileExp,
IfThenElseExp,
EqualExp,
OrderingOpsExp,
ObjectOps,
StringOps,
LiftString,
BooleanOps,
LiftBoolean,
While,
IfThenElse,
Equal,
OrderingOps,
LiftNumeric,
NumericOps,
Variables,
NumericOpsExpOpt,
GenericGenUnboxedTupleAccess}

trait JS
  extends LiftNumeric
  with NumericOps
  with OrderingOps
  with Equal
  with IfThenElse
  with While
  with LiftBoolean
  with BooleanOps
  with LiftString
  with StringOps
  with ObjectOps
  with DynamicBase
  with Arrays
  with Variables
  with JSFunctions
  with JSLiteral
  with JSRegExps
  with JSSeqBase
  with JSMath

trait JSExp
  extends JS
  with NumericOpsExpOpt
  with OrderingOpsExp
  with EqualExp
  with IfThenElseExp
  with WhileExp
  with BooleanOpsExp
  with StringOpsExp
  with ObjectOpsExp
  with DynamicExp
  with ArraysExp
  with VariablesExp
  with JSFunctionsExp
  with JSLiteralExp
  with JSRegExpsExp
  with JSSeqExp
  with JSMathExp

trait JSGen
  extends JSGenNumericOps
  with JSGenOrderingOps
  with JSGenEqual
  with JSGenIfThenElse
  with JSGenWhile
  with JSGenBooleanOps
  with JSGenStringOps
  with JSGenDynamic
  with JSGenObjectOps
  with JSGenArrays
  with JSGenVariables
  with JSGenFunctions
  with JSGenLiteral
  with JSGenRegExps
  with JSGenTupleOps
  with JSGenSeq
  with GenJSMath
  with GenericGenUnboxedTupleAccess {
  val IR: JSExp
}

trait JSGenOpt extends JSGen with JSCodegenOpt