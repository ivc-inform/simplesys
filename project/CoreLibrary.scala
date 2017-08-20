package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait CoreLibrary {
  self: BuildExtended =>

  lazy val coreLibrary = Project(id = "core-library", base = file("core-library")).settings(
    libraryDependencies ++= Seq(
      CommonDeps.scalaTest.value % "test"
    ) ++ CommonDeps.scalaXml.value.seq
  ).settings(CommonSettings.defaultProjectSettings)
}