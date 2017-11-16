package com.simplesys
package corelibrary
package domain

import scala.xml.Elem

trait BOReference[+T] {
    implicit def x2Opt[T](x:T):Option[T] = Some(x)
}

trait BOPersist {
    def toXML: Elem
}
