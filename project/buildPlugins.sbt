import com.typesafe.sbt.GitVersioning
import com.typesafe.sbt.SbtGit.git
import sbt._

lazy val root = Project(id = "buildPlugins", base = file(".")).enablePlugins(GitVersioning).
  settings(inThisBuild(CommonSettings.defaultSettings ++ Seq(
      git.baseVersion := CommonSettings.settingValues.baseVersion
  ))).
  settings(
      PluginDeps.sbtCoffeeScript,
      PluginDeps.jdbcPlugin
  )
