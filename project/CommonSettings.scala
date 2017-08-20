import sbt.Setting

object CommonSettings {
  object settingValues {
    val baseVersion = "1.3"

    val organization = "com.simplesys.core"
    val scalacOptions = Seq(
      "-feature",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:postfixOps",
      "-language:existentials",
       "-deprecation",
      "-unchecked"
    )
  }

  val defaultSettings = {
    import sbt.Keys._
    Seq(
      scalacOptions := settingValues.scalacOptions,
      organization := settingValues.organization
    )
  }

  val defaultProjectSettings: Seq[Setting[_]] = {
    aether.AetherPlugin.autoImport.overridePublishSettings
  }
}
