package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait IscWrapper {
  self: BuildExtended with IscMisc with ServletWrapper with XmlExtender with JsonExtenderTypesafe with AkkaExtender with CoreDomains with JdbcWrapper =>

  lazy val iscWrapper = Project(id = "isc-wrapper", base = file("isc-wrapper")).dependsOn(xmlExtender, servletWrapper, iscMisc, jsonExtenderTypesafe, akkaExtender, coreDomains, jdbcWrapper).settings(


    libraryDependencies ++= Seq(
      CommonDeps.akkaActor.value,
      CommonDeps.servletAPI.value % "provided",
      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
