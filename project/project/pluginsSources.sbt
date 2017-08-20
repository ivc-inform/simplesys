
unmanagedSources in Compile ++= {
  val rootProjDir = baseDirectory.value.getParentFile
  Seq(
    rootProjDir / "BuildExtended.scala",
    rootProjDir / "CommonSettings.scala",
    rootProjDir / "CommonDeps.scala",
    rootProjDir / "LogbackWrapper.scala",
    rootProjDir / "JodaWrapper.scala",
    rootProjDir / "CommonsPrj.scala",
    rootProjDir / "SaxonWrapper.scala",
    rootProjDir / "XmlExtender.scala",
    rootProjDir / "IscMisc.scala",
    rootProjDir / "ScalaGen.scala",
    rootProjDir / "ScalaIOExtender.scala",
    rootProjDir / "PluginProjects.scala"
  )
}

unmanagedResources in Compile ++= {
  val rootProjDir = baseDirectory.value.getParentFile
  Seq(
    rootProjDir / "logback.xml"
  )
}


