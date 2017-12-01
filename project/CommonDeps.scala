import sbt.Keys._
import sbt.{Def, _}

object PluginDeps {
    val sbtCoffeeScript = addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % versions.sbtCoffeScriptVersion)
    val jdbcPlugin = addSbtPlugin("com.simplesys" % "jdbc" % versions.jdbcPluginVersion)
    val jsonPlugin = addSbtPlugin("com.simplesys" % "json" % versions.jsonPluginVersion)
    val coursier = addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC12")

    object versions {
        val sbtCoffeScriptVersion = "1.1.4"
        val jdbcPluginVersion = "1.0.4-SNAPSHOT"
        val jsonPluginVersion = "1.0.4-SNAPSHOT"
    }
}

object CommonDeps {
    val scalaXml = "org.scala-lang.modules" %% "scala-xml" % versions.scalaModulesVersion
    val scalaParserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % versions.scalaParserCombinatorsVersion
    val scalaReflect = Def.setting("org.scala-lang" % "scala-reflect" % scalaVersion.value)
    val scalazCore = "org.scalaz" %% "scalaz-core" % versions.scalazVersion
    val logbackClassic = "ch.qos.logback" % "logback-classic" % versions.logbackVersion
    val logbackAccess = "ch.qos.logback" % "logback-access" % versions.logbackVersion
    val logbackCore = "ch.qos.logback" % "logback-core" % versions.logbackVersion
    val javaxTransaction = "javax.transaction" % "jta" % versions.javaxTransactionVersion
    val servletAPI = "javax.servlet" % "javax.servlet-api" % versions.servletAPIVersion

    val wrappedSaxonEE = "com.simplesys.saxon" % "saxon-ee" % versions.wrappedSaxonEEVersion
    val xerces = "xerces" % "xercesImpl" % versions.xercesVersion
    val hikariCP = "com.zaxxer" % "HikariCP" % versions.hikariCPVersionVersion
    val slick = "com.typesafe.slick" %% "slick" % versions.slickVersion
    val slickHikariCP = "com.typesafe.slick" %% "slick-hikaricp" % versions.slickVersion
    val configTypesafe = "com.typesafe" % "config" % versions.configTypesafeVersion

    val doobieCore = "org.tpolecat" %% "doobie-core" % versions.doobieVersion
    val doobieCoreCats = "org.tpolecat" %% "doobie-core-cats" % versions.doobieVersion

    val akkaActor = "com.typesafe.akka" %% "akka-actor" % versions.akkaVersion
    val akkaSLF4J = "com.typesafe.akka" %% "akka-slf4j" % versions.akkaVersion
    val akkaAgent = "com.typesafe.akka" %% "akka-agent" % versions.akkaVersion
    val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % versions.akkaVersion % Test
    val liquibaseWrapped = "ru.simplesys.org.liquibase" % "liquibase-core" % versions.liquibaseWrapped

    val h2DB = "com.h2database" % "h2" % versions.h2DBVersion
    val derbyDB = "org.apache.derby" % "derby" % versions.derbyDBVersion
    //val jdbcPostgres = "org.postgresql" % "postgresql" % versions.postgresDriverVersion

    val jdbcOracle12 = "com.oracle.jdbc" % "ojdbc8" % versions.oracle12DriverVersion
    val jdbcOracle12UCP = "com.oracle.jdbc" % "ucp" % versions.oracle12DriverVersion
    val jdbcOracleN18_12 = "com.oracle.jdbc" % "orai18n" % versions.oracle12DriverVersion

    val scalaTest = "org.scalatest" %% "scalatest" % versions.scalaTestVersion % Test
    val rhino = "org.mozilla" % "rhino" % versions.rhinoVersion
    val apacheCommonsLang = "org.apache.commons" % "commons-lang3" % versions.apacheCommonsLangVersion
    val apacheCommonsIO = "commons-io" % "commons-io" % versions.apacheCommonsIOVersion
    val scalaMeta = "org.scalameta" %% "scalameta" % versions.scalaMetaVersion
    val scalaArm = "com.jsuereth" %% "scala-arm" % versions.scalaArmVersion
    val utilEval = "com.twitter" %% "util-eval" % versions.utilEvalVersion
    val configWrapper = "com.github.kxbmap" %% "configs" % versions.configWrapperVersion
    val junit = "junit" % "junit" % "4.12" % Test
    val specs2 = "org.specs2" %% "specs2-core" % "4.0.0" % Test

    val akkaHttpCirce = "de.heikoseeberger" %% "akka-http-circe" % "1.18.2-SNAPSHOT"

    val circeExtender = "com.simplesys.cross" %% "circe-extender" % versions.ssCrossVersion
    val servletWrapper = "com.simplesys.cross" %% "servlet-wrapper" % versions.ssCrossVersion

    object versions {
        val scalaModulesVersion = "1.0.6"

        val akkaVersion = "2.5.7"

        val scalazVersion = "7.2.8"

        val doobieVersion = "0.4.1"

        val logbackVersion = "1.2.3"
                                                                                                                                             
        val apacheCommonsLangVersion = "3.4"

        val javaxTransactionVersion = "1.1"
        val servletAPIVersion = "3.1.0"

        val wrappedSaxonEEVersion = "9.5.1.2-1"
        val xercesVersion = "2.11.0"
        val hikariCPVersionVersion = "2.7.1"
        val slickVersion = "3.3.0-SNAPSHOT"

        val configTypesafeVersion = "1.3.1"

        val liquibaseWrapped = "3.0.2"

        val h2DBVersion = "1.4.193"
        val derbyDBVersion = "10.11.1.1"
        val postgresDriverVersion = "9.4-1201-jdbc41"
        val oracle12DriverVersion = "12.2.0.1"

        val uTestVersion = "0.3.1"
        val scalaTestVersion = "3.0.3"
        val scalaMetaVersion = "2.0.1"
        val scalaArmVersion = "2.0"
        val scalaParserCombinatorsVersion = "1.0.5"
        val scalaSpecsVersion = "3.8.6"
        val sbtJUnitVersion = "0.11"
        val mockitoVersion = "1.9.5"

        val rhinoVersion = "1.7.7.1"

        val apacheCommonsIOVersion = "2.5"

        val scalaRiformVersion = "0.1.8"

        val utilEvalVersion = "6.43.0"
        val configWrapperVersion = "0.4.4"
        
        val ssCrossVersion = "1.0.0.5-SNAPSHOT"
    }
}

