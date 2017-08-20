package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait XmlExtender {
  self: BuildExtended with LogbackWrapper with CommonsPrj with SaxonWrapper =>

  lazy val xmlExtender = Project(id = "xml-extender", base = file("xml-extender")).dependsOn(logbackWrapper, common, saxonWrapper).settings(
    libraryDependencies ++= Seq(
      CommonDeps.xerces.value,
      CommonDeps.scalaTest.value % "test",
      CommonDeps.sbtJUnit.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}