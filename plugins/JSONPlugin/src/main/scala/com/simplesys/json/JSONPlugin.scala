package com.simplesys.plugins.jdbc

import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin
import com.simplesys.json.GeneratorThisFunctions

object JSONPlugin extends AutoPlugin {

    override def requires = JvmPlugin

    val maxArity = SettingKey[Int]("maxArity", "How max arity This Functions")
    val outputDir = SettingKey[File]("output-directory", "Directory where the scala files should be placed")
    val generateThisFunctions = TaskKey[Seq[File]]("generate-this function", "Generate scala sources")

    object autoImport {
        val maxArity = JSONPlugin.maxArity
    }

    override val projectSettings: Seq[Setting[_]] = inConfig(Compile)(Seq(
        outputDir <<= (sourceManaged in Compile) {
            _ / "com" / "simplesys" / "json"
        },
        generateThisFunctions <<= (outputDir, maxArity) map {
            (out, arr) =>
                genThisFunction(out, arr)
        },
        sourceGenerators <+= generateThisFunctions
    ))


    def genThisFunction(outputDir: File, maxArity: Int): Seq[File] = (
       GeneratorThisFunctions.genThisFunctions(outputDir, maxArity)
    )
}
