package ru.simplesys.libs.sbtbuild

import sbt.Keys._
import sbt._

trait PluginProjects {
    self: BuildExtended with ScalaGen =>

    lazy val jdbcPlugin = Project(id = "jdbc-gen-plugin", base = file("plugins") / "JDBCPlugin").dependsOn(scalaGen).settings(
        sbtPlugin := true,
        libraryDependencies ++= Seq(
            CommonDeps.scalaTest.value % "test"
        )
    ).settings(CommonSettings.defaultProjectSettings)

    lazy val jsonPlugin = Project(id = "json-gen-plugin", base = file("plugins") / "JSONPlugin").dependsOn(scalaGen).settings(
        sbtPlugin := true,
        libraryDependencies ++= Seq(
            CommonDeps.scalaTest.value % "test"
        )
    ).settings(CommonSettings.defaultProjectSettings)
}
