import com.typesafe.sbt.GitVersioning
import com.typesafe.sbt.SbtGit.git
import ru.simplesys.libs.sbtbuild._
import sbt._

object PluginsBuild extends BuildExtended
with LogbackWrapper
with JodaWrapper
with CommonsPrj
with SaxonWrapper
with XmlExtender
with IscMisc
with ScalaGen
with ScalaIOExtender
with PluginProjects {
    override def settings: Seq[Def.Setting[_]] = super.settings ++ CommonSettings.defaultSettings ++ Seq(
        git.baseVersion := CommonSettings.settingValues.baseVersion
    )

    lazy val root = Project(id = "buildPlugins", base = file(".")).enablePlugins(GitVersioning).dependsOn(jdbcPlugin, jsonPlugin).settings(
        PluginDeps.transpileCoffeeScript,
        PluginDeps.sourceGenJS
    )
}
