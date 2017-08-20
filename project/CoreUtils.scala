package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait CoreUtils {
  self: BuildExtended =>


  lazy val coreUtils = Project(id = "core-utils", base = file("core-utils")).settings(
    //organization := "ru.simplesys",
    libraryDependencies ++= CommonDeps.scalaReflect.value.toSeq
  ).settings(CommonSettings.defaultProjectSettings)
}