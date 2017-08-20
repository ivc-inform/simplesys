package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait LogbackWrapper {
  self: BuildExtended =>

  lazy val logbackWrapper = Project(id = "logback-wrapper", base = file("logback-wrapper")).settings(
    libraryDependencies ++= Seq(
      CommonDeps.logbackCore.value,
      CommonDeps.logbackClassic.value,
      CommonDeps.logbackAccess.value,

      CommonDeps.scalaTest.value % "test",
      CommonDeps.scalaSpecsCore.value % "test",
      CommonDeps.sbtJUnit.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}