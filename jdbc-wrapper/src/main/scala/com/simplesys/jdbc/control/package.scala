package com.simplesys.jdbc

package object control {
    implicit def str2Opt(str: String): Option[String] = Some(str)
}
