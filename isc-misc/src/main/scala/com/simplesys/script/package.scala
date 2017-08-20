package com.simplesys

import java.io.PrintWriter

package object script {
  implicit def stringWriter2PrintWriter(sw: JsStringWriter): PrintWriter = new PrintWriter(sw)
}
