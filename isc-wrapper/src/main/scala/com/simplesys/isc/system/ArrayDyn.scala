package com.simplesys.isc.system

import com.simplesys.common.Strings._
import com.simplesys.isc.system.misc._
import com.simplesys.json._

import scala.collection.mutable.ArrayBuffer

object ArrayDyn {
    def apply[T <: ClassDyn](items: T*): ArrayDyn[T] = {
        val res = new ArrayDyn[T](ArrayBuffer.empty[JsonElement])
        items foreach {
            item => item match {
                case item1: ClassDyn =>
                    if (item1.Enqueued) {
                        if (!item1.ID.isEmpty)
                            res += item1.ID.toString.unQuoted.unq
                        else
                            res += item1.Identifier
                    }
                    else
                        res += item1.json
                case _ =>
                    res += _
            }
        }
        res
    }

    implicit def jsonList2Array[T <: ClassDyn](items: JsonList): ArrayDyn[T] = {
        new ArrayDyn[T](items)
    }

    def empty[T <: ClassDyn]: ArrayDyn[T] = ArrayDyn[T]()

    implicit def class2JsonList[T <: ClassDyn](_class: T): JsonList = {
        val res = JsonList()
        res += _class.json
        res
    }
}

class ArrayDyn[T <: ClassDyn](override protected val proxy: ArrayBuffer[JsonElement]) extends JsonList {
    def this() = this(ArrayBuffer.empty[JsonElement])
    def isEmpty = proxy.isEmpty
    override def length = proxy.length

    def append(item: T*): Unit = {
        item.foreach( proxy += _)
    }

}
