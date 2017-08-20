package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait IscMisc {
  self: BuildExtended with CommonsPrj with XmlExtender =>

  lazy val iscMisc = Project(id = "isc-misc", base = file("isc-misc")).dependsOn(common, xmlExtender).settings(
    libraryDependencies ++= Seq(
      CommonDeps.rhino.value ,
      CommonDeps.scalaTest.value % "test",
      CommonDeps.sbtJUnit.value % "test"
    ) ++ CommonDeps.scalaReflect.value.seq
  ).settings(CommonSettings.defaultProjectSettings)
}