package ru.simplesys.libs.sbtbuild

import sbt.Setting

object CommonSettings {
  object settingValues {
    val baseVersion = "1.2"

    val scalaVersion = "2.11.8"
    val scalaOldVersion = "2.10.6"

    val crossScalaVersions = Seq(scalaVersion, scalaOldVersion)
    val organization = "com.simplesys.core"
    val scalacOptions = Seq(
      "-feature",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-language:existentials",
      "-deprecation",
      "-unchecked")
  }

  val defaultSettings = {
    import sbt.Keys._
    Seq(
      //scalaVersion := settingValues.scalaVersion,
      crossScalaVersions := settingValues.crossScalaVersions,
      scalacOptions := settingValues.scalacOptions,
      organization := settingValues.organization
    )
  }

  val defaultProjectSettings: Seq[Setting[_]] = {
    import sbt.Keys._
    import sbt._
    aether.AetherPlugin.autoImport.overridePublishSettings
  }
}
