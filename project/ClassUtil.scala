package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait ClassUtil {
  self: BuildExtended with CommonsPrj with ScalaIOExtender =>

  lazy val classUtil = Project(id = "class-util", base = file("class-util")).dependsOn(common, scalaIOExtender).settings(
    scalacOptions += "-language:reflectiveCalls",

    libraryDependencies ++= Seq(
      CommonDeps.scalaTest.value % "test"//,
      //CommonDeps.sbtJUnit.value % "test"
    ) ++ Seq(CommonDeps.scalaReflect.value).flatten

  ).settings(CommonSettings.defaultProjectSettings)

}