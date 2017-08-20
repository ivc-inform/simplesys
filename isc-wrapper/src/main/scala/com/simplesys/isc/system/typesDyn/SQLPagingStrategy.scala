

package com.simplesys.isc.system.typesDyn


sealed abstract trait SQLPagingStrategy

case object sqlPgStrgNull extends SQLPagingStrategy {
  override def toString = ""
}

case object sqlPgStrgSqlLimit extends SQLPagingStrategy {
  override def toString = "sqlLimit"
}

case object sqlPgStrgJdbcScroll extends SQLPagingStrategy {
  override def toString = "jdbcScroll"
}

case object sqlPgStrgDropAtServer extends SQLPagingStrategy {
  override def toString = "dropAtServer"
}

case object sqlPgStrgNone extends SQLPagingStrategy {
  override def toString = "none"
}


