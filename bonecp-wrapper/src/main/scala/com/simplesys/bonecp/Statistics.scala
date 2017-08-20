package com.simplesys.bonecp

import com.jolbox.bonecp.{Statistics => JStatistics}

object Statistics {
  def apply(proxy: JStatistics) = new Statistics(proxy)
}

class Statistics(protected[bonecp] val proxy: JStatistics) {
  def this(pool: BoneCP) = this(new JStatistics(pool))

  def resetStats = proxy resetStats

  def CacheHitRatio = proxy getCacheHitRatio

  def CacheMiss = proxy getCacheMiss

  def ConnectionsRequested = proxy getConnectionsRequested

  def ConnectionWaitTimeAvg = proxy getConnectionWaitTimeAvg

  def CumulativeConnectionWaitTime = proxy getCumulativeConnectionWaitTime

  def CumulativeStatementExecutionTime = proxy getCumulativeStatementExecutionTime

  def CumulativeStatementPrepareTime = proxy getCumulativeStatementPrepareTime

  def StatementExecuteTimeAvg = proxy getStatementExecuteTimeAvg

  def StatementPrepareTimeAvg = proxy getStatementPrepareTimeAvg

  def StatementsCached = proxy getStatementsCached

  def StatementsExecuted = proxy getStatementsExecuted

  def StatementsPrepared = proxy getStatementsPrepared

  def TotalCreatedConnections = proxy getTotalCreatedConnections

  def TotalFree = proxy getTotalFree

  def TotalLeased = proxy getTotalLeased
}