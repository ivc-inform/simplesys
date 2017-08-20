package com.simplesys.plugins

import sbt._
import sbt.Keys._

object TestServletPlugin extends Plugin {
  val sourceGen = config("test-servletes-gen")

  val generateScalaCode = taskKey[Seq[File]]("Generate scala sources from schema files")
  val outputDir = settingKey[File]("Directory where the Scala files should be placed")

  lazy val testServletGeneratorPluginSettings: Seq[Setting[_]] = inConfig(sourceGen)(Seq[Setting[_]](
    generateScalaCode := {
      val out: std.TaskStreams[Def.ScopedKey[_]] = streams.value

      implicit val logger = out.log

      val srcDirectory = (sourceDirectory in Compile).value
      val dpndcClasspath = (dependencyClasspath in Compile).value
      val clssDirectory = (classDirectory in Compile).value
      val rsrcDirectory = (resourceDirectory in Compile).value

      //logger.info(s"sourceDirectory: $srcDirectory")
      //logger.info(s"dependencyClasspath: $dpndcClasspath")
      //logger.info(s"classDirectory : $clssDirectory")
      //logger.info(s"resourceDirectory : $rsrcDirectory")

      //throw new RuntimeException("xxxxxxxxxx")

      Seq.empty[File]
    }
  )) ++ Seq[Setting[_]](
    sourceGenerators in Compile <+= generateScalaCode in sourceGen,
    ivyConfigurations += sourceGen
  )
}


