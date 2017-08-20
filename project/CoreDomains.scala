package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait CoreDomains {
  self: BuildExtended with CoreUtils with XmlExtender with JsonExtenderTypesafe =>

  lazy val coreDomains = Project(id = "core-domains", base = file("core-domains")).dependsOn(coreUtils, xmlExtender, jsonExtenderTypesafe).settings(


    libraryDependencies ++= Seq(
      CommonDeps.jodaTime.value,
      CommonDeps.jodaConvert.value,
      CommonDeps.liquibaseWrapped.value,
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}