import com.typesafe.sbt.SbtGit.git
import com.typesafe.sbt.coffeescript.SbtCoffeeScript
import com.typesafe.sbt.coffeescript.SbtCoffeeScript.autoImport._
import com.typesafe.sbt.web.Import.WebKeys.webTarget
import com.typesafe.sbt.web.SbtWeb.autoImport._

name := "SimpleSys"

lazy val root = (project in file(".")).
  enablePlugins(GitVersioning).
  aggregate(
      jodaWrapper,
      logbackWrapper,
      common,
      scalaIOExtender,
      classUtil,
      saxonWrapper,
      xmlExtender,
      iscMisc,
      configWrapper,
      jsonExtenderTypesafe,
      coreDomains,
      scalaGen,
      oraclePoolDataSources,
      servletWrapper,
      coreUtils,
      akkaExtender,
      iscWrapper,
      jdbcWrapper,
      commonWebApp,
      iscComponents,
      coreLibrary,
      utilEvalExtender,
      doobieExtender,
      hikariCP
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
        CommonDeps.servletAPI % Provided,
        CommonDeps.akkaActor,
        CommonDeps.akkaAgent,
        CommonDeps.akkaSLF4J,
        CommonDeps.akkaTestKit % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val oraclePoolDataSources = Project(id = "oracle-pool-datasources", base = file("oracle-pool-datasources")).dependsOn(common, configWrapper, logbackWrapper).settings(

    libraryDependencies ++= Seq(
        CommonDeps.jdbcOracle12,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val classUtil = Project(id = "class-util", base = file("class-util")).dependsOn(common, scalaIOExtender).settings(
    scalacOptions += "-language:reflectiveCalls",

    libraryDependencies ++= Seq(
        CommonDeps.scalaReflect.value,
        CommonDeps.scalaTest % Test
    )

).settings(CommonSettings.defaultProjectSettings)

lazy val common = (project in file("common")).dependsOn(logbackWrapper, jodaWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.apacheCommonsLang,
        CommonDeps.apacheCommonsIO,
        CommonDeps.scalaXml,
        CommonDeps.scalaReflect.value,

        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)


lazy val commonWebApp = Project(id = "common-webapp", base = file("common-webapp")).enablePlugins(SbtCoffeeScript).dependsOn(akkaExtender, iscWrapper, classUtil).settings(
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
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val configWrapper = Project(id = "config-wrapper", base = file("config-wrapper")).dependsOn(common, xmlExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.configWrapper,
        CommonDeps.configTypesafe,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreDomains = Project(id = "core-domains", base = file("core-domains")).dependsOn(coreUtils, xmlExtender, jsonExtenderTypesafe).settings(
    libraryDependencies ++= Seq(
        CommonDeps.jodaTime,
        CommonDeps.jodaConvert,
        CommonDeps.liquibaseWrapped,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreLibrary = Project(id = "core-library", base = file("core-library")).settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalaXml,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val coreUtils = Project(id = "core-utils", base = file("core-utils")).settings(
    libraryDependencies += CommonDeps.scalaReflect.value
).settings(CommonSettings.defaultProjectSettings)

lazy val doobieExtender = Project(id = "doobie-extender", base = file("doobie-extender")).dependsOn(jodaWrapper, logbackWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.doobieCore,
        CommonDeps.doobieCoreCats,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val iscComponents = Project(id = "isc-components", base = file("isc-components")).enablePlugins(SbtCoffeeScript).dependsOn(scalaIOExtender, iscWrapper).
  settings(
    sbtPlugin := false,
    organization := CommonSettings.settingValues.organization,
    libraryDependencies ++= Seq(
        CommonDeps.servletAPI % "provided",
        CommonDeps.scalaTest % Test
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
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val iscWrapper = Project(id = "isc-wrapper", base = file("isc-wrapper")).dependsOn(xmlExtender, servletWrapper, iscMisc, jsonExtenderTypesafe, akkaExtender, coreDomains, jdbcWrapper).settings(

    libraryDependencies ++= Seq(
        CommonDeps.akkaActor,
        CommonDeps.servletAPI % Provided,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val jdbcWrapper = Project(id = "jdbc-wrapper", base = file("jdbc-wrapper")).dependsOn(oraclePoolDataSources, scalaGen, coreDomains, coreLibrary).enablePlugins(JDBCPlugin).settings(
    com.simplesys.jdbc.plugins.jdbc.JDBCPlugin.autoImport.maxArity := 50,

    scalacOptions += "-language:existentials",

    libraryDependencies ++= Seq(
        CommonDeps.scalazCore,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val jodaWrapper = Project(id = "joda-wrapper", base = file("joda-wrapper")).settings(
    libraryDependencies ++= Seq(
        CommonDeps.jodaTime,
        CommonDeps.jodaConvert % Compile,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)


lazy val jsonExtenderTypesafe = Project(id = "json-extender-typesafe", base = file("json-extender-typesafe")).dependsOn(scalaGen).enablePlugins(JSONPlugin).settings(

    scalacOptions += "-language:reflectiveCalls",
    com.simplesys.jdbc.plugins.jdbc.JDBCPlugin.autoImport.maxArity := 50,

    libraryDependencies ++= Seq(
        CommonDeps.scalaParserCombinators,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val logbackWrapper = Project(id = "logback-wrapper", base = file("logback-wrapper")).settings(
    libraryDependencies ++= Seq(
        CommonDeps.logbackCore,
        CommonDeps.logbackClassic,
        CommonDeps.logbackAccess,

        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val saxonWrapper = Project(id = "saxon-wrapper", base = file("saxon-wrapper")).dependsOn(common, scalaIOExtender).settings(
    libraryDependencies ++= Seq(
        CommonDeps.wrappedSaxonEE,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val scalaGen = Project(id = "scala-gen", base = file("scala-gen")).dependsOn(common, scalaIOExtender, iscMisc).settings(
    libraryDependencies ++= Seq(
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val scalaIOExtender = Project(id = "scala-io-extender", base = file("scala-io-extender")).dependsOn(logbackWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.javaxTransaction,
        CommonDeps.scalaArm,
        CommonDeps.scalaParserCombinators,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val servletWrapper = Project(id = "servlet-wrapper", base = file("servlet-wrapper")).dependsOn(coreUtils, oraclePoolDataSources, xmlExtender, jsonExtenderTypesafe).settings(
    scalacOptions += "-Dscalac:patmat:analysisBudget=1024",

    libraryDependencies ++= Seq(
        CommonDeps.servletAPI % Provided,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val utilEvalExtender = Project(id = "util-eval-extender", base = file("util-eval-extender")).dependsOn(common).settings(
    libraryDependencies ++= Seq(
        CommonDeps.utilEval,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val xmlExtender = Project(id = "xml-extender", base = file("xml-extender")).dependsOn(common, saxonWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.xerces,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

lazy val hikariCP = Project(id = "hikari-cp", base = file("hikari-cp")).dependsOn(common, configWrapper).settings(
    libraryDependencies ++= Seq(
        CommonDeps.hikariCP,
        CommonDeps.jdbcOracle12,
        CommonDeps.jdbcOracle12UCP,
        CommonDeps.jdbcOracleN18_12,
        CommonDeps.scalaTest % Test
    )
).settings(CommonSettings.defaultProjectSettings)

