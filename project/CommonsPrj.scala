package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait CommonsPrj {
  self: BuildExtended with LogbackWrapper with JodaWrapper =>

  lazy val common = Project(id = "common", base = file("common")).dependsOn(logbackWrapper, jodaWrapper).settings(
    libraryDependencies ++= Seq(
      CommonDeps.apacheCommonsLang.value,
      CommonDeps. apacheCommonsIO.value,

      CommonDeps.scalaTest.value % "test",
      CommonDeps.sbtJUnit.value % "test"
    ) ++ Seq(CommonDeps.scalaXml.value, CommonDeps.scalaReflect.value).flatten
  ).settings(CommonSettings.defaultProjectSettings)
}
