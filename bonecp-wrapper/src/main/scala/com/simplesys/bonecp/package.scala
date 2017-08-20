package com.simplesys

import com.jolbox.bonecp.{BoneCP => JBoneCP}
import com.jolbox.bonecp.{BoneCPConfig => JBoneCPConfig}
import com.jolbox.bonecp.{BoneCPDataSource => JBoneCPDataSource}
import com.jolbox.bonecp.{ConnectionHandle => JConnectionHandle}
import com.jolbox.bonecp.{Statistics => JStatistics}
import javax.sql.DataSource
import java.sql.Connection

package object bonecp {
  implicit def jBoneCP2BoneCP(j: JBoneCP): BoneCP = BoneCP(j)
  implicit def BoneCP2JBoneCP(s: BoneCP): JBoneCP = s proxy

  implicit def jBoneCPConfig2BoneCPConfig(j: JBoneCPConfig): BoneCPConfig = BoneCPConfig(j)
  implicit def BoneCPConfig2JBoneCPConfig(s: BoneCPConfig) = s proxy

  implicit def jBoneCPDataSource2BoneCPDataSource(j: JBoneCPDataSource): BoneCPDataSource = BoneCPDataSource(j)
  implicit def BoneCPDataSource2JBoneCPDataSource(s: BoneCPDataSource): JBoneCPDataSource = s proxy

  implicit def jConnectionHandle2ConnectionHandle(j: JConnectionHandle): ConnectionHandle = ConnectionHandle(j)
  implicit def ConnectionHandle2JConnectionHandle(s: ConnectionHandle): JConnectionHandle = s proxy

  implicit def jStatistics2Statistics(j: JStatistics): Statistics = Statistics(j)
  implicit def Statistics2JStatistics(s: Statistics): JStatistics = s proxy

  implicit def ds2Connection(ds: DataSource): Connection = ds.getConnection
}
