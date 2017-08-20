package com.simplesys.xml

import java.io.FileOutputStream
import java.nio.channels.Channels
import util.control.Exception.ultimately
import xml.dtd

import scala.io.Codec._
import com.simplesys.xml.factory.XMLLoader

import scala.xml.{Node, Utility, MinimizeMode}

object XML extends XMLLoader {
    val xsi = "xsi"
    val xsiNamespace = "http://www.w3.org/2001/XMLSchema-instance"
    val encoding = "UTF-8"
    val xml = "xml"
    val xmlns = "xmlns"
    val namespace = "http://www.w3.org/XML/1998/namespace"
    val preserve = "preserve"
    val space = "space"
    val lang = "lang"

    final def save( filename: String,
                    elem: Elem,
                    enc: String = encoding,
                    xmlDecl: Boolean = false,
                    doctype: dtd.DocType = null
                    ): Unit = {
        val fos = new FileOutputStream(filename)
        val w = Channels.newWriter(fos.getChannel(), enc)

        ultimately(w.close())(
            write(w, elem, enc, xmlDecl, doctype)
        )
    }

    final def write(w: java.io.Writer, elem: Elem, enc: String, xmlDecl: Boolean, doctype: dtd.DocType) {
        if (xmlDecl) w.write("<?xml version='1.1' encoding='" + enc + "'?>\n")
        if (doctype != null) w.write(doctype.toString() + "\n")
        w write elem.toPrettyString(4)
    }
}


