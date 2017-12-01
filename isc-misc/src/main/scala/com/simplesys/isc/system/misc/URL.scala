package com.simplesys.isc.system.misc

import java.io.File

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._


class URLString(path: String) {
    def url = URL(path)
    def url(variable: String) = new URL(variable, path)
}

object URL {
    def apply(path: String) = new URL(strEmpty, path)
}

class URL(variable: String, path: String) {

    override def toString = {
        def getPath = if (path.last === File.separatorChar) path.substring(0, path.length - 1) else path

        if (variable !== strEmpty) {
            variable.plus + {
                import com.simplesys.common.JVM.Strings._
                getPath.dblQuoted
            }
        } else {
            import com.simplesys.common.JVM.Strings._
            getPath.dblQuoted
        }
    }

    def toStringWithLastSlash = {
        def getPath = if (path.last !== File.separatorChar) path.pathSlash else path

        if (variable !== strEmpty) {
            variable.plus + {
                import com.simplesys.common.JVM.Strings._
                getPath.dblQuoted
            }
        } else {
            import com.simplesys.common.JVM.Strings._
            getPath.dblQuoted
        }
    }
}
