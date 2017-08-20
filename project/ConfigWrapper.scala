package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait ConfigWrapper {
  self: BuildExtended with CommonsPrj with XmlExtender =>

  lazy val configWrapper = Project(id = "config-wrapper", base = file("config-wrapper")).dependsOn(common, xmlExtender).settings(
    libraryDependencies ++= Seq(
      CommonDeps.configTypesafe.value,
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}