import com.typesafe.sbt.SbtGit.git
import com.typesafe.sbt.coffeescript.SbtCoffeeScript
import com.typesafe.sbt.coffeescript.SbtCoffeeScript.autoImport._
import com.typesafe.sbt.web.Import.WebKeys.webTarget
import com.typesafe.sbt.web.SbtWeb.autoImport._

name := "SimpleSys"

lazy val root = (project in file(".")).
  enablePlugins(GitVersioning).
  aggregate(
      logbackWrapper,
      common,
      scalaIOExtender,
      classUtil,
      saxonWrapper,
      xmlExtender,
      iscMisc,
      configWrapper,
      coreDomains,
      scalaGen,
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
      scalaVersion := "2.12.4",
      publishTo := {
          val corporateRepo = "http://toucan.simplesys.lan/"
          if (isSnapshot.value)
              Some("snapshots" at corporateRepo + "artifactory/libs-snapshot-local")
          else
              Some("releases" at corporateRepo + "artifactory/libs-release-local")
      },
      credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
  )
    ++ CommonSettings.defaultSettings),
      publishArtifact in(Compile, packageBin) := false,
      publishArtifact in(Compile, packageDoc) := false,
      publishArtifact in(Compile, packageSrc) := false
  )

lazy val akkaExtender = Project(id = "akka-extender", base = file("akka-extender")).dependsOn(servletWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.junit,
        CommonDeps.specs2,
        CommonDeps.akkaTestKit
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val oraclePoolDataSources = Project(id = "oracle-pool-datasources", base = file("oracle-pool-datasources")).dependsOn(common, configWrapper, logbackWrapper).settings(

    libraryDependencies ++= Seq(
        CommonDeps.jdbcOracle12,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val classUtil = Project(id = "class-util", base = file("class-util")).dependsOn(common, scalaIOExtender).settings(
    scalacOptions += "-language:reflectiveCalls",

    libraryDependencies ++= Seq(
        CommonDeps.scalaReflect.value,
        CommonDeps.scalaTest
    )

).settings(CommonSettings.defaultProjectSettings)

lazy val common = (project in file("common")).dependsOn(logbackWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.apacheCommonsLang,
        CommonDeps.apacheCommonsIO,
        CommonDeps.scalaXml,
        CommonDeps.scalaReflect.value,
        CommonDeps.circeCore,
        CommonDeps.circeGeneric,
        CommonDeps.circeParcer,
        CommonDeps.junit,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)


lazy val commonWebApp = Project(id = "common-webapp", base = file("common-webapp")).enablePlugins(SbtCoffeeScript).dependsOn(akkaExtender, classUtil).settings(
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

lazy val configWrapper = Project(id = "config-wrapper", base = file("config-wrapper")).dependsOn(common, xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.configWrapper,
        CommonDeps.configTypesafe,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreDomains = Project(id = "core-domains", base = file("core-domains")).dependsOn(coreUtils, xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.jodaTime,
        CommonDeps.jodaConvert,
        CommonDeps.liquibaseWrapped,
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

lazy val doobieExtender = Project(id = "doobie-extender", base = file("doobie-extender")).dependsOn(logbackWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.doobieCore,
        CommonDeps.doobieCoreCats,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val iscComponents = Project(id = "isc-components", base = file("isc-components")).enablePlugins(SbtCoffeeScript).dependsOn(scalaIOExtender).
  settings(
      sbtPlugin := false,
      organization := CommonSettings.settingValues.organization,
      libraryDependencies ++= Seq(
          CommonDeps.servletAPI % "provided",
          CommonDeps.scalaTest
      ),
      CoffeeScriptKeys.sourceMap := false,
      CoffeeScriptKeys.bare := false,
      CoffeeScriptKeys.writeIncludeModules := true,
      webTarget := (resourceDirectory in Compile).value / "webapp" / "javascript" / "generated" / "generatedComponents" / "coffeescript",
      sourceDirectory in Assets := (resourceDirectory in Compile).value / "coffeescript",
      (managedResources in Compile) ++= CoffeeScriptKeys.coffeeScript.value
  ).settings(CommonSettings.defaultProjectSettings)

lazy val iscMisc = Project(id = "isc-misc", base = file("isc-misc")).dependsOn(common, xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.rhino,
        CommonDeps.scalaReflect.value,
        CommonDeps.scalaParserCombinators,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val jdbcWrapper = Project(id = "jdbc-wrapper", base = file("jdbc-wrapper")).dependsOn(oraclePoolDataSources, scalaGen, coreDomains, coreLibrary).enablePlugins(JDBCPlugin).settings(
    com.simplesys.jdbc.plugins.jdbc.JDBCPlugin.autoImport.maxArity := 50,

    scalacOptions += "-language:existentials",

    libraryDependencies ++= Seq(
        CommonDeps.scalazCore,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val logbackWrapper = Project(id = "logback-wrapper", base = file("logback-wrapper")).settings(
    libraryDependencies ++= Seq(
        CommonDeps.logbackCore,
        CommonDeps.logbackClassic,
        CommonDeps.logbackAccess,
        CommonDeps.junit,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val saxonWrapper = Project(id = "saxon-wrapper", base = file("saxon-wrapper")).dependsOn(common, scalaIOExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.wrappedSaxonEE,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val scalaGen = Project(id = "scala-gen", base = file("scala-gen")).dependsOn(common, scalaIOExtender, iscMisc).settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val scalaIOExtender = Project(id = "scala-io-extender", base = file("scala-io-extender")).dependsOn(logbackWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.javaxTransaction,
        CommonDeps.scalaArm,
        CommonDeps.scalaParserCombinators,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val servletWrapper = Project(id = "servlet-wrapper", base = file("servlet-wrapper")).dependsOn(coreUtils, oraclePoolDataSources, xmlExtender).settings(
    scalacOptions += "-Dscalac:patmat:analysisBudget=1024",

    libraryDependencies ++= Seq(
        CommonDeps.akkaActor,
        CommonDeps.akkaAgent,
        CommonDeps.akkaSLF4J,
        CommonDeps.servletAPI % Provided,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val utilEvalExtender = Project(id = "util-eval-extender", base = file("util-eval-extender")).dependsOn(common).settings(
    libraryDependencies ++= Seq(
        CommonDeps.utilEval,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val xmlExtender = Project(id = "xml-extender", base = file("xml-extender")).dependsOn(common, saxonWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.xerces,
        CommonDeps.junit,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val hikariCP = Project(id = "hikari-cp", base = file("hikari-cp")).dependsOn(common, configWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.hikariCP,
        CommonDeps.jdbcOracle12,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val slickExtension = Project(id = "slick-extension", base = file("slick-extension")).dependsOn(common, configWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.slick,
        CommonDeps.slickHikariCP,
        CommonDeps.jdbcOracle12,
        CommonDeps.scalaTest
    )
).settings(CommonSettings.defaultProjectSettings)

