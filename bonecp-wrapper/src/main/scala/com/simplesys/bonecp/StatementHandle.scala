package com.simplesys.bonecp

import com.jolbox.bonecp.{StatementHandle => JStatementHandle}

object StatementHandle {
  def apply(proxy: JStatementHandle) = new StatementHandle(proxy)
}

class StatementHandle(protected val proxy: JStatementHandle)