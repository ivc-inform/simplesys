package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait JodaWrapper {
  self: BuildExtended =>

  lazy val jodaWrapper = Project(id = "joda-wrapper", base = file("joda-wrapper")).settings(
      libraryDependencies ++= Seq(
        CommonDeps.jodaTime.value,
        CommonDeps.jodaConvert.value % "compile",
        CommonDeps.scalaTest.value % "test"
      )
    ).settings(CommonSettings.defaultProjectSettings)
}