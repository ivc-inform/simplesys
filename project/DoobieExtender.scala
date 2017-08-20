package ru.simplesys.libs.sbtbuild

import ru.simplesys.libs.sbtbuild.{BuildExtended, CommonDeps, CommonSettings}
import sbt.Keys._
import sbt._

trait DoobieExtender {
  self: BuildExtended with JodaWrapper with LogbackWrapper =>

  lazy val doobieExtender = Project(id = "doobie-extender", base = file("doobie-extender")).dependsOn(jodaWrapper, logbackWrapper).settings(
    libraryDependencies ++= Seq(
      CommonDeps.doobieCore.value,
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
