package com.simplesys.config

import java.util.concurrent.TimeUnit

import com.simplesys.common.Strings._
import com.typesafe.config.{Config => JConfig, ConfigException, ConfigFactory, ConfigObject}

import scala.collection.JavaConversions._
import scala.concurrent.duration._

trait Config {
    private val resourceBasename: Option[String] = None
    val pathBasename: String = strEmpty

    protected lazy val config: JConfig =
        resourceBasename match {
            case Some(path) => ConfigFactory load path
            case None => ConfigFactory load
        }

    private def getFullPath(path: String): String = if (pathBasename.nonEmpty && path.indexOf(pathBasename) == -1) pathBasename + "." + path else path

    def getLong(path: String): Long = config getLong getFullPath(path)
    def getInt(path: String): Int = config getInt getFullPath(path)
    def getDouble(path: String): Double = config getDouble getFullPath(path)
    def getBoolean(path: String): Boolean = config getBoolean getFullPath(path)
    def getString(path: String): String = config getString getFullPath(path)

    def getDuration(path: String): FiniteDuration = Duration(config.getDuration(path, TimeUnit.NANOSECONDS), TimeUnit.NANOSECONDS)
    def getDurationList(path: String): Seq[FiniteDuration] = config.getDurationList(path, TimeUnit.NANOSECONDS).map(Duration(_, TimeUnit.NANOSECONDS))
    def getStringList(path: String): List[String] = (config getStringList getFullPath(path)).toList
    def getObject(path: String): ConfigObject = config getObject getFullPath(path)

    def getLongDefault(path: String, default: Long = 0): Long = {
        try {
            config.getLong(getFullPath(path))
        } catch {
            case e: ConfigException.Missing => default
            case e: Throwable => throw e
        }
    }
    def getIntDefault(path: String, default: Int = 0): Int = {
        try {
            config.getInt(getFullPath(path))
        } catch {
            case e: ConfigException.Missing => default
            case e: Throwable => throw e
        }
    }
    def getDoubleDefault(path: String, default: Double = 0): Double = {
        try {
            config.getDouble(getFullPath(path))
        } catch {
            case e: ConfigException.Missing => default
            case e: Throwable => throw e
        }
    }
    def getBooleanDefault(path: String, default: Boolean = false): Boolean = {
        try {
            config.getBoolean(getFullPath(path))
        } catch {
            case e: ConfigException.Missing => default
            case e: Throwable => throw e
        }
    }
    def getStringDefault(path: String, default: String = strEmpty): String = {
        try {
            config.getString(getFullPath(path))
        } catch {
            case e: ConfigException.Missing => default
            case e: Throwable => throw e
        }
    }

    def configRender: String = config.root().render()
}
