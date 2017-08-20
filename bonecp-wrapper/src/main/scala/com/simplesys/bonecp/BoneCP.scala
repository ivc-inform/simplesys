package com.simplesys.bonecp

import com.jolbox.bonecp.{BoneCP => JBoneCP}
import java.sql.SQLException
import com.simplesys.log.Logging

object BoneCP {
  def apply(proxy: JBoneCP) = new BoneCP(proxy)
  def apply(config: BoneCPConfig) = new BoneCP(config)
}

class BoneCP(protected[bonecp] val proxy: JBoneCP) extends Logging {
  def this(config: BoneCPConfig) = this(new JBoneCP(config))

  def Close {
    proxy close
  }

  def ConnectionHandleAlive_?(connection: ConnectionHandle) = proxy isConnectionHandleAlive connection

  def Shutdown {
    proxy shutdown
  }

  def AsyncConnection = proxy getAsyncConnection

  def Config: BoneCPConfig = proxy getConfig

  @throws(classOf[SQLException])
  def Connection = proxy getConnection

  def Statistics: Statistics = proxy getStatistics

  def TotalCreatedConnections = proxy getTotalCreatedConnections

  def TotalFree = proxy getTotalFree

  def TotalLeased = proxy getTotalLeased
}