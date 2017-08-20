package ru.simplesys.libs.sbtbuild


import sbt._
import Keys._

trait IscComponents {
  self: BuildExtended with ScalaIOExtender with IscWrapper =>

  import com.typesafe.sbt.coffeescript.TranspileCoffeeScript
  import com.typesafe.sbt.coffeescript.TranspileCoffeeScript.autoImport._
  import com.typesafe.sbt.web.Import.WebKeys._
  import com.typesafe.sbt.web.SbtWeb.autoImport._
  import com.simplesys.sourcegenJS.SourceGenPlugin._

  lazy val iscComponents = Project(id = "isc-components", base = file("isc-components")).dependsOn(
    scalaIOExtender,
    iscWrapper
  ).enablePlugins(TranspileCoffeeScript).settings(generatorJSSettings).settings(
      libraryDependencies ++= Seq(
        CommonDeps.servletAPI.value % "provided",
        CommonDeps.scalaTest.value % "test"
      ),
      outputJSDir in SourceGenJSConfig := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents",
      classNameToRun in SourceGenJSConfig := "com.simplesys.components.Gen.CreateStatics",
      withBeautifier in SourceGenJSConfig := true,
      CoffeeScriptKeys.sourceMap := false,
      CoffeeScriptKeys.bare := false,
      CoffeeScriptKeys.writeIncludeModules := true,
      webTarget := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents" / "coffeescript",
      sourceDirectory in Assets := (resourceDirectory in Compile).value / "coffeescript",
      (managedResources in Compile) ++= CoffeeScriptKeys.csTranspile.value
      //(managedClasspath in Runtime) += (assets in Assets).value
  ).settings(CommonSettings.defaultProjectSettings)
}