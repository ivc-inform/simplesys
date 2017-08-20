
unmanagedSources in Compile ++= {
  val rootDir = baseDirectory.value.getParentFile.getParentFile
  val rootProjDir = baseDirectory.value.getParentFile
  Seq(
    rootProjDir / "CommonSettings.scala",
    rootProjDir / "CommonDeps.scala"
  )
}
