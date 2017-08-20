package com.simpesys.classutil

case class StreamClassLoader(parent: ClassLoader) extends ClassLoader(parent) {
    def defineClass(bytes: Array[Byte]): Class[_] = defineClass(null, bytes, 0, bytes.length, null)
}