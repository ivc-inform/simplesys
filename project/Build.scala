import com.typesafe.sbt.GitVersioning
import com.typesafe.sbt.SbtGit.git
import ru.simplesys.libs.sbtbuild._
import sbt.Keys._
import sbt._

object SimpleSysBuild extends BuildExtended
  with JodaWrapper
  with LogbackWrapper
  with CommonsPrj
  with ScalaIOExtender
  with ClassUtil
  with SaxonWrapper
  with XmlExtender
  with ConfigWrapper
  with IscMisc
  with JsonExtenderTypesafe
  with ScalaGen
  with ScalaFmt
  with BoneCPWrapper
  with ServletWrapper
  with CoreUtils
  with AkkaExtender
  with IscWrapper
  with CoreDomains
  with JdbcWrapper
  with CommonWebapp
  with IscComponents
  with UtilEvalExtender
  with CoreLibrary
  with DoobieExtender
{
    lazy val root = Project(id = "simplesys", base = file(".")).enablePlugins(GitVersioning).aggregate(
        jodaWrapper,
        logbackWrapper,
        common,
        scalaIOExtender,
        classUtil,
        saxonWrapper,
        xmlExtender,
        configWrapper,
        iscMisc,
        jsonExtenderTypesafe,
        scalaGen,
        scalaFmt,
        boneCPWrapper,
        servletWrapper,
        coreUtils,
        akkaExtender,
        iscWrapper,
        coreDomains,
        jdbcWrapper,
        commonWebApp,
        iscComponents,
        coreLibrary,
        utilEvalExtender,
        doobieExtender
    ).settings(
        publishArtifact in(Compile, packageBin) := false,
        publishArtifact in(Compile, packageDoc) := false,
        publishArtifact in(Compile, packageSrc) := false
    )
    override def settings: Seq[Def.Setting[_]] = super.settings ++ CommonSettings.defaultSettings ++ Seq(
        git.baseVersion := CommonSettings.settingValues.baseVersion,
        scalaVersion := CommonSettings.settingValues.scalaVersion,
        crossScalaVersions := CommonSettings.settingValues.crossScalaVersions,

        publishTo <<= version { (v: String) =>
            val corporateRepo = "http://toucan.simplesys.lan/"
            if (v.trim.endsWith("SNAPSHOT"))
                Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
            else
                Some("releases" at corporateRepo + "artifactory/libs-release-local")
        },

        credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
    )
}
