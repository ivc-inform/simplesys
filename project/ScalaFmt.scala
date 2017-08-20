package ru.simplesys.libs.sbtbuild

import sbt.Keys._
import sbt._

trait ScalaFmt {
  self: BuildExtended with CommonsPrj =>

  lazy val scalaFmt = Project(id = "scala-fmt", base = file("scala-fmt")).dependsOn(common).settings(
    libraryDependencies ++= Seq(
      CommonDeps.scalaFmt.value,
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
