package com.simplesys.plugins.jdbc

import com.simplesys.jdbc.{Generator, Generator1, GeneratorTuples}

import sbt._
import Keys._
import sbt.plugins.JvmPlugin

object JDBCPlugin extends AutoPlugin {
  override def requires = JvmPlugin

  val maxArity = SettingKey[Int]("maxArity", "How max arity TuplesSS")
  val outputDir = SettingKey[File]("output-directory", "Directory where the scala files should be placed")
  val outputDir1 = SettingKey[File]("output-directory1", "Directory where the scala files should be placed")
  val tupleOutputDir = SettingKey[File]("tuples-output-directory", "Directory where the scala files should be placed")
  val generateSuperTuple = TaskKey[Seq[File]]("generate-superTuple", "Generate scala sources")

  object autoImport {
    val maxArity: SettingKey[Int] = JDBCPlugin.maxArity
  }


  override val projectSettings: Seq[Setting[_]] = inConfig(Compile)(Seq(
    outputDir <<= (sourceManaged in Compile) {
      _ / "com" / "simplesys" / "jdbc" / "control" / "TableSuperTuple"
    },
    outputDir1 <<= (sourceManaged in Compile) {
      _ / "com" / "simplesys" / "jdbc" / "control" / "SuperTuple1"
    },
    tupleOutputDir <<= (sourceManaged in Compile) {
      _ / "com" / "simplesys" / "tuple"
    },
    generateSuperTuple <<= (tupleOutputDir, outputDir, outputDir1, maxArity) map {
      (tupleOut, out, out1, arr) =>
        genSuperTuple(tupleOut, out, out1, arr)
    },
    sourceGenerators <+= generateSuperTuple
  ))

  def genSuperTuple(tupleOutputDir: File, outputDir: File, outputDir1: File, maxArity: Int): Seq[File] = (
    GeneratorTuples genTuples(tupleOutputDir, maxArity)) ++
    (Generator genSuperTuple(outputDir, maxArity)) ++
    (Generator1 genSuperTuple(outputDir1, maxArity))

}


