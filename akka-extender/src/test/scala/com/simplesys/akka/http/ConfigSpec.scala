package com.simplesys.akka.http

import akka.actor.ActorSystem
import org.specs2.mutable.Specification

object ConfigSpec {
  val systemName = "http"
  val supervisorPath = "async"
  val timeOut = 1000L
  val expireHeaderName = "Async-Timeout"
  val expireHeaderValue = "expired"
  val logOnInit = true
  val fSm = true
  val logLevel = "debug"
  val eXtention = "[com.simplesys.akka.http.HttpExtension$]"
}

class ConfigSpec extends Specification {

  import ConfigSpec._

  "This specification checks the contents of the file 'reference.conf' one used to store the parameters 'default'" ^
    p ^
    "Section 'akka.http'" ^
    "Parameter 'system-name' must be equal '%s'".format(systemName) ! `system-name` ^
    "Parameter 'supervisor-path' must be equal '%s'".format(supervisorPath) ! `supervisor-path` ^
    "Parameter 'timeout' must be equal %sL".format(timeOut) ! `timeout` ^
    "Parameter 'expired-header-name' must be equal '%s'".format(expireHeaderName) ! `expired-header-name` ^
    "Parameter 'expired-header-value' must be equal '%s'".format(expireHeaderValue) ! `expired-header-name` ^
    "Parameter 'log-http-config-on-init' must be '%s'".format(logOnInit) ! `log-http-config-on-init` ^
    p ^
    "Section akka.actor.debug" ^
    "Parameter 'fsm' must be equal '%s'".format(fSm) ! `fsm` ^
    p ^
    "Section akka" ^
    "Parameter 'loglevel' must be equal '%s'".format(logLevel) ! `loglevel` ^
    "Parameter 'extensions' must be equal '%s'".format(eXtention) ! `extensions` ^
    end


  val system = ActorSystem()

  val `akka.http` = system.settings.config.getConfig("akka.http")
  val `system-name` = `akka.http`.getString("system-name") mustEqual systemName
  val `supervisor-path` = `akka.http`.getString("supervisor-path") mustEqual supervisorPath
  val `timeout` = `akka.http`.getLong("timeout") mustEqual timeOut
  val `expired-header-name` = `akka.http`.getString("expired-header-name") mustEqual expireHeaderName
  val `expired-header-value` = `akka.http`.getString("expired-header-value") mustEqual expireHeaderValue
  val `log-http-config-on-init` = `akka.http`.getBoolean("log-http-config-on-init") mustEqual logOnInit

  val `akka.actor.debug` = system.settings.config.getConfig("akka.actor.debug")
  val `fsm` = `akka.actor.debug`.getBoolean("fsm") mustEqual fSm

  val `akka` = system.settings.config.getConfig("akka")
  val `loglevel` = `akka`.getString("loglevel") mustEqual logLevel
  val `extensions` = `akka`.getStringList("extensions").toString mustEqual eXtention
}

