package com.simplesys
package corelibrary
package domain

import scala.reflect.ClassTag
import scala.xml.Elem

trait BOReference[+T] {
    //  type BOType <: T
}

trait BOPersist {
    def toXML: Elem
}
