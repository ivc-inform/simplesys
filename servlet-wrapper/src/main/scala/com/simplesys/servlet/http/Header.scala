package com.simplesys.servlet.http

import scala.collection.immutable.SortedMap
import javax.servlet.http.{HttpServletResponse => JHttpServletResponse}
import com.simplesys.common.Strings._
import com.simplesys.common._
import scala.collection.JavaConverters._

sealed trait Header {
    val name: String
    val values: Seq[String]
}

object HeaderString {
    def apply(name: String, value: String) = new HeaderString(name, Seq(value))
}

case class HeaderString(name: String, override val values: Seq[String]) extends Header

object HeaderInt {
    def apply(name: String, value: Int) = new HeaderInt(name, Seq(value))
}

case class HeaderInt(name: String, valuesI: Seq[Int]) extends Header {
    override val values = valuesI.map(_.toString)
}

object HeaderDateTime {
    def apply(name: String, value: org.joda.time.DateTime) = new HeaderDateTime(name, Seq(value))
    def apply(name: String, value: Long) = new HeaderDateTime(name, Seq(new org.joda.time.DateTime(value)))
}

case class HeaderDateTime(name: String, valuesDT: Seq[org.joda.time.DateTime]) extends Header {
    override val values = valuesDT.map(_.getMillis.toString)
}

object HeaderLocalDateTime {
    def apply(name: String, value: org.joda.time.LocalDateTime) = new HeaderLocalDateTime(name, Seq(value))
}

case class HeaderLocalDateTime(name: String, valuesLDT: Seq[org.joda.time.LocalDateTime]) extends Header {
    override val values = valuesLDT.map(_.toDateTime.getMillis.toString)
}

trait Headers {
    protected val proxy: JHttpServletResponse

    protected lazy val headersMap: SortedMap[String, Seq[String]] = (proxy.getHeaderNames.asScala map {
        case headerName: String => headerName -> proxy.getHeaders(headerName).asScala.toSeq.sortWith(_ < _)
    } toMap).To

    private def containsHeader(name: String, value: String): Boolean = {
        (proxy containsHeader name) match {
            case false => false
            case true => proxy.getHeaders(name).asScala.exists(_ == value)
        }
    }

    def Header(name: String): String = {
        headersMap.get(name) match {
            case None => strEmpty
            case Some(values) =>
                values.headOption match {
                    case None => strEmpty
                    case Some(value) => value
                }
        }
    }

    def Headers(name: String): List[String] = {
        headersMap.get(name) match {
            case None => List()
            case Some(values) =>
                values.toList
        }
    }



    def +=(header: Header) {
        header match {
            case HeaderInt(name, values) =>
                values.headOption match {
                    case None =>
                    case Some(head) =>
                        val _head = head.toString
                        if (containsHeader(name, _head))
                            proxy setIntHeader(name, head)
                        else
                            proxy addIntHeader(name, head)
                }

            case HeaderDateTime(name, values) =>
                values.headOption match {
                    case None =>
                    case Some(head) =>
                        val _head = head.getMillis.toString
                        if (containsHeader(name, _head))
                            proxy setDateHeader(name, head.getMillis)
                        else
                            proxy addDateHeader(name, head.getMillis)
                }

            case HeaderLocalDateTime(name, values) =>
                values.headOption match {
                    case None =>
                    case Some(head) =>
                        val _head = head.toDateTime.getMillis.toString
                        if (containsHeader(name, _head))
                            proxy setDateHeader(name, head.toDateTime.getMillis)
                        else
                            proxy addDateHeader(name, head.toDateTime.getMillis)
                }

            case header =>
                header.values.headOption match {
                    case None =>
                    case Some(head) =>
                        if (containsHeader(header.name, head))
                            proxy setHeader(header.name, head)
                        else
                            proxy addHeader(header.name, head)
                }

        }
    }

    def ++=(header: Header*): Unit = {
        header foreach (+= _)
    }
}

case object CacheControlNoCache extends Header {
    override val name = "Cache-Control"
    override val values = Seq("no-cache")
}

case object PragmaNoCache extends Header {
    override val name = "Pragma"
    override val values = Seq("no-cache")
}

case object ConnectionClose extends Header {
    override val name = "Connection"
    override val values = Seq("close")
}
