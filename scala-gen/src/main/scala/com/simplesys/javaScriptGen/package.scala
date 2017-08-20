package com.simplesys

package object javaScriptGen {
    val indentSize = 4

    implicit def str2JavaScriptStringElement(str: String): JavaScriptStringElement = new JavaScriptStringElement(str)
}
