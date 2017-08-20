package ru.simplesys.libs.sbtbuild

import sbt._
import Keys._

trait CommonWebapp {
  self: BuildExtended with AkkaExtender with IscWrapper with ClassUtil =>

  import com.typesafe.sbt.coffeescript.TranspileCoffeeScript
  import com.typesafe.sbt.coffeescript.TranspileCoffeeScript.autoImport._
  import com.typesafe.sbt.web.Import.WebKeys._
  import com.typesafe.sbt.web.SbtWeb.autoImport._


  lazy val commonWebApp = Project(id = "common-webapp", base = file("common-webapp")).dependsOn(akkaExtender, iscWrapper, classUtil).enablePlugins(TranspileCoffeeScript).settings(
    CoffeeScriptKeys.sourceMap := false,
    CoffeeScriptKeys.bare := false,
    CoffeeScriptKeys.writeIncludeModules := true,
    webTarget := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents" / "coffeescript",
    sourceDirectory in Assets := (resourceDirectory in Compile).value / "webapp" / "coffeescript" / "developed",
    (managedResources in Compile) ++= CoffeeScriptKeys.csTranspile.value,

    libraryDependencies ++= Seq(
      CommonDeps.servletAPI.value % "provided",
      CommonDeps.jdbcOracle11.value,

      CommonDeps.scalaTest.value % "test"
    )
  ).settings(CommonSettings.defaultProjectSettings)
}
