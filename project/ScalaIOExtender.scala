package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait ScalaIOExtender {
  self: BuildExtended with LogbackWrapper =>

  lazy val scalaIOExtender = Project(id = "scala-io-extender", base = file("scala-io-extender")).dependsOn(logbackWrapper).settings(
    libraryDependencies ++= Seq(
      CommonDeps.javaxTransaction.value,
      CommonDeps.scalaIncubatorIOCore.value,
      CommonDeps.scalaIncubatorIOFile.value,

      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
