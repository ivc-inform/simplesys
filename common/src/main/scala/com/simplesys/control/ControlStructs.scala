package com.simplesys.control

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.reflect.ClassTag
import scala.language.reflectiveCalls

object ControlStructs {
    def using[A <: {def close() : Unit}, B](param: A)(f: A => B): B =
        try {
            f(param)
        }
        finally {
            param close
        }

    def using2[A <: {def close() : Unit}, A2 <: {def close() : Unit}, B](param: A)(param2: A2)(f: A => B): B =
        try {
            f(param)
        }
        finally {
            param.close()
            param2.close()
        }

    def usingSeq[A <: Seq[ {def close() : Unit}], B](param: A)(f: A => B): B =
        try {
            f(param)
        }
        finally {
            param.foreach(_.close())
        }

    def boolMapList[T](test: => Boolean)(block: => T): List[T] = {
        val res = new ListBuffer[T]

        while (test)
            res += block

        res toList
    }

    def boolMapArray[T: ClassTag](test: => Boolean)(block: => T): Array[T] = {
        val res = new ArrayBuffer[T]

        while (test)
            res += block

        res toArray
    }
}
