package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait ServletWrapper {
  self: BuildExtended with XmlExtender with BoneCPWrapper with JsonExtenderTypesafe with CoreUtils =>

  lazy val servletWrapper = Project(id = "servlet-wrapper", base = file("servlet-wrapper")).dependsOn(coreUtils, boneCPWrapper, xmlExtender, jsonExtenderTypesafe/*, jdbcWrapper*/).settings(
    scalacOptions += "-Dscalac:patmat:analysisBudget=1024",

    libraryDependencies ++= Seq(
      CommonDeps.servletAPI.value % "provided",
      CommonDeps.scalaTest.value % "test"
      //CommonDeps.sbtJUnit.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}