package com.simplesys.isc.system.typesDyn


sealed abstract trait LogicalOperator

case object lgcOprAnd extends LogicalOperator {
  override def toString = "and"
}

case object lgcOprOr extends LogicalOperator {
  override def toString = "or"
}

case object lgcOprNot extends LogicalOperator {
  override def toString = "not"
}


