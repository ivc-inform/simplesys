package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait AkkaExtender {
  self: BuildExtended with /*ClassUtil with */ServletWrapper =>

  lazy val akkaExtender = Project(id = "akka-extender", base = file("akka-extender")).dependsOn(/*classUtil, */servletWrapper).settings(


    libraryDependencies ++= Seq(
      CommonDeps.servletAPI.value % "provided",
      CommonDeps.akkaActor.value,
      CommonDeps.akkaAgent.value,
      CommonDeps.akkaSLF4J.value,
      CommonDeps.akkaTestKit.value % "test",
      CommonDeps.scalaSpecsCore.value % "test",
      CommonDeps.scalaSpecsMock.value % "test",
      CommonDeps.scalaSpecsMatcherExtra.value % "test"

      //CommonDeps.mockito.value % "test",
//      CommonDeps.sbtJUnit.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
