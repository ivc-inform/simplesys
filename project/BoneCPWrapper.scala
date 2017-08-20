package ru.simplesys.libs.sbtbuild

import sbt.Keys._
import sbt._

trait BoneCPWrapper {
    self: BuildExtended with LogbackWrapper with CommonsPrj with XmlExtender with ConfigWrapper with DoobieExtender=>

    lazy val boneCPWrapper = Project(id = "bonecp-wrapper", base = file("bonecp-wrapper")).dependsOn(logbackWrapper, common, xmlExtender, configWrapper, doobieExtender).settings(
        scalacOptions += "-Dscalac:patmat:analysisBudget=1024",

        libraryDependencies ++= Seq(
            CommonDeps.boneCP.value,
            CommonDeps.scalazCore.value,
            CommonDeps.scalaTest.value % "test",
            CommonDeps.h2DB.value % "test",
            CommonDeps.derbyDB.value % "test",
            CommonDeps.jdbcPostgres.value % "test",
            CommonDeps.jdbcOracle11.value % "test"
            //CommonDeps.sbtJUnit.value % "test"
        )
    ).settings(CommonSettings.defaultProjectSettings)
}
