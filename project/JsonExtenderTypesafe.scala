package ru.simplesys.libs.sbtbuild

import com.simplesys.plugins.jdbc.JSONPlugin
import com.simplesys.plugins.jdbc.JSONPlugin.autoImport._
import sbt.Keys._
import sbt._

trait JsonExtenderTypesafe {
    self: BuildExtended with LogbackWrapper with ScalaGen =>


    lazy val jsonExtenderTypesafe = Project(id = "json-extender-typesafe", base = file("json-extender-typesafe")).dependsOn(scalaGen, logbackWrapper).enablePlugins(JSONPlugin).settings(
        scalacOptions += "-language:reflectiveCalls",
        maxArity := 22,

        libraryDependencies ++= Seq(
            CommonDeps.scalaTest.value % "test"
        ) ++ CommonDeps.scalaParserCombinators.value.seq
    ).settings(CommonSettings.defaultProjectSettings)
}
