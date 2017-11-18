package com.simplesys.akka.pattern

import akka.util.Timeout
import com.simplesys.config.Config

import scala.concurrent.duration._

trait AskSupport extends akka.pattern.AskSupport with Config {
    implicit val timeout = Timeout(getInt("akka.ask-timeout") second)
}

