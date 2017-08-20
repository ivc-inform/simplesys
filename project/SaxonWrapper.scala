package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait SaxonWrapper {
  self: BuildExtended with CommonsPrj with ScalaIOExtender =>

  lazy val saxonWrapper = Project(id = "saxon-wrapper", base = file("saxon-wrapper")).dependsOn(common, scalaIOExtender).settings(
    libraryDependencies ++= Seq(
      CommonDeps.wrappedSaxonEE.value,

      CommonDeps.scalaTest.value % "test"//,
      //CommonDeps.sbtJUnit.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}