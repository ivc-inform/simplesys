package ru.simplesys.libs.sbtbuild

import sbt.Keys._
import sbt._

trait UtilEvalExtender {
    self: BuildExtended with CommonsPrj =>

    lazy val utilEvalExtender = Project(id = "util-eval-extender", base = file("util-eval-extender")).dependsOn(common).settings(
        libraryDependencies ++= Seq(
            CommonDeps.utilEval.value,
            CommonDeps.scalaTest.value % "test"
        )
    ).settings(CommonSettings.defaultProjectSettings)
}
