import com.typesafe.sbt.GitVersioning
import com.typesafe.sbt.SbtGit.git
import sbt._

//lazy val transpileCoffeeScript = uri("../../sbt-plugins/transpile-coffeescript")

lazy val root = Project(id = "buildPlugins", base = file(".")).enablePlugins(GitVersioning).dependsOn(/*RootProject(transpileCoffeeScript)*/).
  settings(inThisBuild(CommonSettings.defaultSettings ++ Seq(
      git.baseVersion := CommonSettings.settingValues.baseVersion
  ))).
  settings(
      PluginDeps.sbtCoffeScript,
      PluginDeps.jsonPlugin,
      PluginDeps.jdbcPlugin
  )



