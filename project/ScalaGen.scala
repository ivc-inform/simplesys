package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait ScalaGen {
  self: BuildExtended with CommonsPrj with ScalaIOExtender with IscMisc =>

  lazy val scalaGen = Project(id = "scala-gen", base = file("scala-gen")).dependsOn(common, scalaIOExtender, iscMisc).settings(
    libraryDependencies ++= Seq(
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
