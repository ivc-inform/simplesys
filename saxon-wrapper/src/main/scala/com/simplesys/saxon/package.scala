package com.simplesys

import net.sf.saxon.s9api._
import java.net.{URL, URI}
import javax.xml.transform.SourceLocator
import scala.collection.JavaConverters._
import scalax.file.{PathSet, Path}
import scala.collection.mutable.ArrayBuffer

package object saxon {

    implicit class strOpts(str: String) {
        def qName: QName = str
        def xdmValue: XdmValue = str
    }

    implicit def strt2QName(str: String): QName = new QName(str)
    implicit def strt2QName(tuple: Tuple2[String, String]): QName = new QName(tuple._1, tuple._2)
    implicit def strt2QName(tuple: Tuple3[String, String, String]): QName = new QName(tuple._1, tuple._2, tuple._3)

    implicit def bool2XdmAtomicValue(value: Boolean): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def int2XdmAtomicValue(value: Int): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def str2XdmAtomicValue(value: String): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def char2XdmAtomicValue(value: Char): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def path2XdmAtomicValue(value: Path): XdmAtomicValue = new XdmAtomicValue(value.path)
    implicit def path2XdmAtomicValue(value: PathSet[Path]): XdmValue = {
        val res = ArrayBuffer.empty[String]
        value foreach (res += _.path)
        stringsSeq2XdmValue(res)
    }
    implicit def stringsSeq2XdmValue(value: Seq[String]): XdmValue = new XdmValue((value map (item => (new XdmAtomicValue(item)).asInstanceOf[XdmItem])).asJavaCollection)
    implicit def strings2XdmValue(value: String*): XdmValue = stringsSeq2XdmValue(value)

    /*implicit def strings2XdmValue1(value: String*) = new {
        def toSeq: XdmValue = stringsSeq2XdmValue(value)
    }*/

    implicit def bigDecimal2XdmAtomicValue(value: BigDecimal): XdmAtomicValue = new XdmAtomicValue(value.bigDecimal)
    implicit def double2XdmAtomicValue(value: Double): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def float2XdmAtomicValue(value: Float): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def uri2XdmAtomicValue(value: URI): XdmAtomicValue = new XdmAtomicValue(value)
    implicit def url2XdmAtomicValue(value: URL): XdmAtomicValue = new XdmAtomicValue(value.toURI)
    implicit def qName2XdmAtomicValue(value: QName): XdmAtomicValue = new XdmAtomicValue(value)

    implicit def function2MessageListener(f: (XdmNode, Boolean, SourceLocator) => Unit) = new MessageListener {
        def message(content: XdmNode, terminate: Boolean, locator: SourceLocator) = f(content, terminate, locator)
    }
}
