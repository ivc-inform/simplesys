package ru.simplesys.libs.sbtbuild

import sbt.Keys._
import sbt._
import com.simplesys.plugins.jdbc.JDBCPlugin
import com.simplesys.plugins.jdbc.JDBCPlugin.autoImport._

object JdbcWrapper {
    def arity(scalaVer: String, arity_2_11: Int, arity_2_10: Int): Int =
        CrossVersion.partialVersion(scalaVer) match {
            case Some((scalaMajor, scalaMinor)) if scalaMinor >= 11 => arity_2_11
            case _ => arity_2_10
        }
}

trait JdbcWrapper {
    self: BuildExtended with BoneCPWrapper with ScalaGen with JodaWrapper with CoreDomains with CoreLibrary =>

    lazy val jdbcWrapper = Project(id = "jdbc-wrapper", base = file("jdbc-wrapper")).dependsOn(boneCPWrapper, scalaGen, jodaWrapper, coreDomains, coreLibrary).enablePlugins(JDBCPlugin).settings(
        maxArity := JdbcWrapper.arity(scalaVersion.value, 50, 22),

        scalacOptions += "-language:existentials",
        libraryDependencies ++= Seq(
            CommonDeps.scalazCore.value,

            CommonDeps.scalaTest.value % "test",
            CommonDeps.jdbcPostgres.value % "test",
            CommonDeps.jdbcOracle11.value % "test"
        )
    ).settings(CommonSettings.defaultProjectSettings)
}
