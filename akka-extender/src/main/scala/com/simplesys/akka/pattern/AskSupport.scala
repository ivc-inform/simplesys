package com.simplesys.akka.pattern

import java.util.concurrent.{ExecutorService, Executors}

import akka.util.Timeout
import scala.concurrent.{ExecutionContextExecutor, ExecutionContext}
import scala.concurrent.duration._
import com.simplesys.config.Config

trait AskSupport extends akka.pattern.AskSupport with Config {
    implicit val timeout = Timeout(getInt("akka.ask-timeout") second)
}

