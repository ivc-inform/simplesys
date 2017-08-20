package com.simplesys.concurrent

import java.util.concurrent.Executors

import scala.concurrent.ExecutionContext

trait FutureSupport {
    implicit val execContext = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())
}