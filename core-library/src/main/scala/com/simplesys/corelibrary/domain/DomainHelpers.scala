package com.simplesys
package corelibrary
package domain

import scala.xml.Elem

trait BOReference[+T] {
}

trait BOPersist {
    def toXML: Elem
}

trait Implicits {
    implicit def x2Opt[T](x:T):Option[T] = Some(x)
}
