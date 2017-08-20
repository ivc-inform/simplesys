package com.simplesys.akka.http

import org.specs2.mutable.Specification
import akka.actor.ActorSystem

class HttpExtensionSpec extends Specification {

  import ConfigSpec._

  "Structure 'HttpExtention' must contain a superposition of all the parameters from all '.conf' files" ^
    p ^
    "asyncTimeout must equal '%s'".format(timeOut) ! `asyncTimeout` ^
    "logConfigOnInit must be '%s'".format(logOnInit) ! `logConfigOnInit` ^
    "expiredHeader must be(('%s' -> '%s'))".format(expireHeaderName, expireHeaderValue) ! `expiredHeader` ^
    //"supervisorPath must equal '%s')".format(supervisorPath) ! `supervisor-Path` ^
    end

  val `extension` = HttpExtension(ActorSystem())

  `extension`.logConfiguration
  val `asyncTimeout` = `extension`.AsyncTimeout mustEqual timeOut
  val `logConfigOnInit` = `extension`.LogConfigOnInit mustEqual logOnInit
  val `expiredHeader` = `extension`.ExpiredHeader mustEqual (expireHeaderName -> expireHeaderValue)
  //val `supervisor-Path` = `extension`.SupervisorPath mustEqual supervisorPath
}
