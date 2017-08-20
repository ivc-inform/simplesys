import sbt.Keys._
import sbt._

object PluginDeps {
    val sbtCoffeScript = addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % versions.sbtCoffeScriptVersion)
    val jdbcPlugin = addSbtPlugin("com.simplesys" % "jdbc" % versions.jdbcPluginVersion)
    val jsonPlugin = addSbtPlugin("com.simplesys" % "json" % versions.jsonPluginVersion)

    object versions {
        val sbtCoffeScriptVersion = "1.0.3-SNAPSHOT"
        val jdbcPluginVersion = "1.0.1"
        val jsonPluginVersion = "1.0.1"
        val nativePackagerVersion = "1.1.0-M1"
    }
}

object CommonDeps {
    val scalaXml = Def.setting(
        DepsHelper.moduleIdOpt(scalaVersion.value, Some("org.scala-lang.modules" %% "scala-xml" % versions.scalaModulesVersion), None)
    )
    val scalaParserCombinators = Def.setting(DepsHelper.moduleIdOpt(scalaVersion.value, Some("org.scala-lang.modules" %% "scala-parser-combinators" % versions.scalaParserCombinatorsVersion), None))
    val scalaReflect = Def.setting(DepsHelper.moduleIdOpt(scalaVersion.value, Some("org.scala-lang" % "scala-reflect" % scalaVersion.value), Some("org.scala-lang" % "scala-reflect" % scalaVersion.value)))
    val scalazCore = Def.setting("org.scalaz" %% "scalaz-core" % versions.scalazVersion)
    val jodaTime = Def.setting("joda-time" % "joda-time" % versions.jodaVersion)
    val jodaConvert = Def.setting("org.joda" % "joda-convert" % versions.jodaConvertVersion)
    val logbackClassic = Def.setting("ch.qos.logback" % "logback-classic" % versions.logbackVersion)
    val logbackAccess = Def.setting("ch.qos.logback" % "logback-access" % versions.logbackVersion)
    val logbackCore = Def.setting("ch.qos.logback" % "logback-core" % versions.logbackVersion)
    val javaxTransaction = Def.setting("javax.transaction" % "jta" % versions.javaxTransactionVersion)
    val servletAPI = Def.setting("javax.servlet" % "javax.servlet-api" % versions.servletAPIVersion)

    val wrappedSaxonEE = Def.setting("com.simplesys.saxon" % "saxon-ee" % versions.wrappedSaxonEEVersion)
    val xerces = Def.setting("xerces" % "xercesImpl" % versions.xercesVersion)
    val hikariCP = Def.setting("com.zaxxer" % "HikariCP" % versions.hikariCPVersionVersion)
    val configTypesafe = Def.setting("com.typesafe" % "config" % versions.configTypesafeVersion)

    val doobieCore = Def.setting("org.tpolecat" %% "doobie-core" % versions.doobieVersion)
    val doobieCoreCats = Def.setting("org.tpolecat" %% "doobie-core-cats" % versions.doobieVersion)

    val akkaActor = Def.setting(DepsHelper.moduleId(scalaVersion.value, "com.typesafe.akka" %% "akka-actor" % versions.akkaVersion, "com.typesafe.akka" %% "akka-actor" % versions.akkaVersion210))
    val akkaSLF4J = Def.setting(DepsHelper.moduleId(scalaVersion.value, "com.typesafe.akka" %% "akka-slf4j" % versions.akkaVersion, "com.typesafe.akka" %% "akka-slf4j" % versions.akkaVersion210))
    val akkaAgent = Def.setting(DepsHelper.moduleId(scalaVersion.value, "com.typesafe.akka" %% "akka-agent" % versions.akkaVersion, "com.typesafe.akka" %% "akka-agent" % versions.akkaVersion210))
    val akkaTestKit = Def.setting(DepsHelper.moduleId(scalaVersion.value, "com.typesafe.akka" %% "akka-testkit" % versions.akkaVersion, "com.typesafe.akka" %% "akka-testkit" % versions.akkaVersion210))
    val liquibaseWrapped = Def.setting("ru.simplesys.org.liquibase" % "liquibase-core" % versions.liquibaseWrapped)

    val boneCP = Def.setting("com.jolbox" % "bonecp" % versions.boneCPVersion)
    val h2DB = Def.setting("com.h2database" % "h2" % versions.h2DBVersion)
    val derbyDB = Def.setting("org.apache.derby" % "derby" % versions.derbyDBVersion)

    val jdbcOracle12 = Def.setting("com.oracle.jdbc" % "ojdbc8" % versions.oracle12DriverVersion)
    val jdbcOracle12UCP = Def.setting("com.oracle.jdbc" % "ucp" % versions.oracle12DriverVersion)
    val jdbcOracleN18_12= Def.setting("com.oracle.jdbc" % "orai18n" % versions.oracle12DriverVersion)

    val scalaTest = Def.setting("org.scalatest" %% "scalatest" % versions.scalaTestVersion)
    val scalaSpecsCore = Def.setting("org.specs2" %% "specs2-core" % versions.scalaSpecsVersion)
    val scalaSpecsMock = Def.setting("org.specs2" %% "specs2-mock" % versions.scalaSpecsVersion)
    val scalaSpecsMatcherExtra = Def.setting("org.specs2" %% "specs2-matcher-extra" % versions.scalaSpecsVersion)
    val sbtJUnit = Def.setting("com.novocode" % "junit-interface" % versions.sbtJUnitVersion)
    val mockito = Def.setting("org.mockito" % "mockito-all" % versions.mockitoVersion)
    val rhino = Def.setting("org.mozilla" % "rhino" % versions.rhinoVersion)
    val apacheCommonsLang = Def.setting("org.apache.commons" % "commons-lang3" % versions.apacheCommonsLangVersion)
    val apacheCommonsIO = Def.setting("commons-io" % "commons-io" % versions.apacheCommonsIOVersion)
    val scalaMeta = Def.setting("org.scalameta" %% "scalameta" % versions.scalaMetaVersion)
    val scalaArm = Def.setting("com.jsuereth" %% "scala-arm" % versions.scalaArmVersion)
    val utilEval = Def.setting(DepsHelper.moduleId(scalaVersion.value, "com.twitter" %% "util-eval" % versions.utilEvalVersion, "com.twitter" %% "util-eval" % versions.utilEval210Version))
    val configWrapper = Def.setting("com.github.kxbmap" %% "configs" % versions.configWrapperVersion)


    object versions {
        val scalaModulesVersion = "1.0.6"

        val akkaVersion = "2.5.4"
        val akkaVersion210 = "2.3.16"

        val scalazVersion = "7.2.8"
                                                                                                     
        val doobieVersion = "0.4.1"

        val jodaVersion = "2.9.4"
        val jodaConvertVersion = "1.8.1"

        val logbackVersion = "1.2.3"

        val apacheCommonsLangVersion = "3.4"

        val javaxTransactionVersion = "1.1"
        val servletAPIVersion = "3.1.0"

        val wrappedSaxonEEVersion = "9.5.1.2-1"
        val xercesVersion = "2.11.0"
        val hikariCPVersionVersion = "2.6.3"

        val configTypesafeVersion = "1.3.1"

        val boneCPVersion = "0.8.0.RELEASE"

        val liquibaseWrapped = "3.0.2"

        val h2DBVersion = "1.4.192"
        val derbyDBVersion = "10.11.1.1"
        val postgresDriverVersion = "9.4-1201-jdbc41"
        val oracle11DriverVersion = "11.2.0.4"
        val oracle12DriverVersion = "12.2.0.1"

        val uTestVersion = "0.3.1"
        val scalaTestVersion = "3.0.1"
        val scalaMetaVersion = "1.6.0"
        val scalaArmVersion = "2.0"
        val scalaParserCombinatorsVersion = "1.0.5"
        val scalaSpecsVersion = "3.8.6"
        val sbtJUnitVersion = "0.11"
        val mockitoVersion = "1.9.5"

        val rhinoVersion = "1.7.7.1"

        val apacheCommonsIOVersion = "2.5"

        val scalaRiformVersion = "0.1.8"

        val utilEvalVersion = "6.43.0"
        val utilEval210Version = "6.34.0"
        val configWrapperVersion= "0.4.4"
    }
}

object DepsHelper {
    def moduleIdOpt(scalaVer: String, moduleId_2_11: Option[ModuleID], moduleId_2_10: Option[ModuleID]): Option[ModuleID] =
        CrossVersion.partialVersion(scalaVer) match {
            case Some((2, scalaMajor)) if scalaMajor >= 11 => moduleId_2_11
            case _ => moduleId_2_10
        }

    def moduleId(scalaVer: String, moduleId_2_11: ModuleID, moduleId_2_10: ModuleID): ModuleID =
        CrossVersion.partialVersion(scalaVer) match {
            case Some((2, scalaMajor)) if scalaMajor >= 11 => moduleId_2_11
            case _ => moduleId_2_10
        }
}
