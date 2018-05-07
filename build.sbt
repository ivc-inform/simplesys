import com.typesafe.sbt.SbtGit.git
import com.typesafe.sbt.coffeescript.SbtCoffeeScript
import com.typesafe.sbt.coffeescript.SbtCoffeeScript.autoImport._
import com.typesafe.sbt.web.Import.WebKeys.webTarget
import com.typesafe.sbt.web.SbtWeb.autoImport._

name := "SimpleSys"

lazy val root = (project in file(".")).
  enablePlugins(GitVersioning).
  aggregate(
      classUtil,
      saxonWrapper,
      xmlExtender,
      configWrapper,
      coreDomains,
      oraclePoolDataSources,
      servletWrapper,
      coreUtils,
      akkaExtender,
      jdbcWrapper,
      commonWebApp,
      iscComponents,
      coreLibrary,
      utilEvalExtender,
      doobieExtender,
      hikariCP,
      slickExtension
  ).
  settings(inThisBuild(Seq(
      git.baseVersion := CommonSettings.settingValues.baseVersion,
      scalaVersion := "2.12.5",
      publishTo := {
          val corporateRepo = "http://maven-repo.mfms/"
          if (isSnapshot.value)
              Some("snapshots" at corporateRepo + "nexus/content/repositories/mfmd-snapshot/")
          else
              Some("releases" at corporateRepo + "nexus/content/repositories/mfmd-release/")
      },
      credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )
    ++ CommonSettings.defaultSettings),
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )

lazy val akkaExtender = Project(id = "akka-extender", base = file("akka-extender")).dependsOn().settings(
    libraryDependencies ++= Seq(
        CommonDeps.akkaActor,
        CommonDeps.akkaAgent,
        CommonDeps.akkaSLF4J,
        CommonDeps.akkaTestKit
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val oraclePoolDataSources = Project(id = "oracle-pool-datasources", base = file("oracle-pool-datasources")).dependsOn(configWrapper).settings(

    libraryDependencies ++= Seq(
        CommonDeps.jdbcOracle12,
        CommonDeps.common,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val classUtil = Project(id = "class-util", base = file("class-util")).dependsOn().settings(
    scalacOptions += "-language:reflectiveCalls",

    libraryDependencies ++= Seq(
        CommonDeps.common,
        CommonDeps.scalaIOExtender,
        CommonDeps.scalaReflect.value,
        CommonDeps.scalaTest
    )

).settings(CommonSettings.defaultProjectSettings)

lazy val commonWebApp = Project(id = "common-webapp", base = file("common-webapp"))
  .enablePlugins(SbtCoffeeScript)
  .dependsOn(
      servletWrapper,
      classUtil
  )
  .settings(
      sbtPlugin := false,
      organization := CommonSettings.settingValues.organization,
      CoffeeScriptKeys.sourceMap := false,
      CoffeeScriptKeys.bare := false,
      CoffeeScriptKeys.writeIncludeModules := true,
      webTarget := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents" / "coffeescript",
      sourceDirectory in Assets := (resourceDirectory in Compile).value / "webapp" / "coffeescript" / "developed",
      (managedResources in Compile) ++= CoffeeScriptKeys.coffeeScript.value,

      scalacOptions += "-unchecked",
      libraryDependencies ++= Seq(
          CommonDeps.servletAPI % Provided,
          CommonDeps.scalaTest
      )
  ).settings(CommonSettings.defaultProjectSettings)

lazy val configWrapper = Project(id = "config-wrapper", base = file("config-wrapper")).dependsOn(xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.common,
        CommonDeps.configWrapper,
        CommonDeps.configTypesafe,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreDomains = Project(id = "core-domains", base = file("core-domains")).dependsOn(coreUtils, xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.liquibaseWrapped,
        CommonDeps.circeExtender,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreLibrary = Project(id = "core-library", base = file("core-library")).settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalaXml,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreUtils = Project(id = "core-utils", base = file("core-utils")).settings(
    libraryDependencies += CommonDeps.scalaReflect.value
).settings(CommonSettings.defaultProjectSettings)

lazy val doobieExtender = Project(id = "doobie-extender", base = file("doobie-extender")).dependsOn().settings(
    libraryDependencies ++= Seq(
        CommonDeps.logBackWrapper,
        CommonDeps.doobieCore,
        CommonDeps.doobieCoreCats,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val iscComponents = Project(id = "isc-components", base = file("isc-components")).enablePlugins(SbtCoffeeScript).dependsOn().
  settings(
      sbtPlugin := false,
      organization := CommonSettings.settingValues.organization,
      libraryDependencies ++= Seq(
          CommonDeps.scalaIOExtender,
          CommonDeps.servletAPI % Provided,
          CommonDeps.scalaTest
      ),
      CoffeeScriptKeys.sourceMap := false,
      CoffeeScriptKeys.bare := false,
      CoffeeScriptKeys.writeIncludeModules := true,
      webTarget := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents" / "coffeescript",
      sourceDirectory in Assets := (resourceDirectory in Compile).value / "coffeescript",
      (managedResources in Compile) ++= CoffeeScriptKeys.coffeeScript.value
  ).settings(CommonSettings.defaultProjectSettings)

lazy val jdbcWrapper = Project(id = "jdbc-wrapper", base = file("jdbc-wrapper"))
  .dependsOn(
      oraclePoolDataSources,
      coreDomains,
      coreLibrary
  )
  .enablePlugins(JDBCPlugin)
  .settings(
      com.simplesys.jdbc.plugins.jdbc.JDBCPlugin.autoImport.maxArity := 50,

      scalacOptions += "-language:existentials",

      libraryDependencies ++= Seq(
          CommonDeps.scalaGen,
          CommonDeps.circeExtender,
          CommonDeps.scalazCore,
          CommonDeps.scalaTest
      )
  ).settings(CommonSettings.defaultProjectSettings)

lazy val saxonWrapper = Project(id = "saxon-wrapper", base = file("saxon-wrapper")).dependsOn().settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalaIOExtender,
        CommonDeps.common,
        CommonDeps.wrappedSaxonEE,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val servletWrapper = Project(id = "servlet-wrapper", base = file("servlet-wrapper"))
  .dependsOn(
      jdbcWrapper,
      coreUtils,
      oraclePoolDataSources,
      xmlExtender,
      akkaExtender
  )
  .settings(
      scalacOptions += "-Dscalac:patmat:analysisBudget=1024",

      libraryDependencies ++= Seq(
          CommonDeps.servletWrapper,
          CommonDeps.circeExtender,
          CommonDeps.servletAPI % Provided,
          CommonDeps.scalaTest
      )
  ).settings(CommonSettings.defaultProjectSettings)

lazy val utilEvalExtender = Project(id = "util-eval-extender", base = file("util-eval-extender")).dependsOn().settings(
    libraryDependencies ++= Seq(
        CommonDeps.common,
        CommonDeps.utilEval,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val xmlExtender = Project(id = "xml-extender", base = file("xml-extender")).dependsOn(saxonWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.common,
        CommonDeps.xerces,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val hikariCP = Project(id = "hikari-cp", base = file("hikari-cp")).dependsOn(configWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalazCore,
        CommonDeps.doobieCore,
        CommonDeps.doobieCoreCats,
        CommonDeps.common,
        CommonDeps.hikariCP,
        CommonDeps.jdbcOracle12,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.jdbcPostgres,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val slickExtension = Project(id = "slick-extension", base = file("slick-extension")).dependsOn(configWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.common,
        CommonDeps.slick,
        CommonDeps.slickCodeGen,
        CommonDeps.slickHikariCP,
        CommonDeps.jdbcOracle12,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

