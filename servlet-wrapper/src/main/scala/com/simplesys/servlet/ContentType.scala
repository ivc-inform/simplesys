package com.simplesys.servlet

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.log.Logging
import ru.simplesys.coreutil.SealedEnumRuntime

import scala.io.Codec

sealed abstract trait Content {
    def +(codec: Codec) = ContentType(this, codec)
}

object ContentType {
    implicit def ct2Opt(ct: Content): Option[Content] = Some(ct)
}

case class ContentType(content: Content, codec: Codec) extends Content {
    override def toString: String = {
        content.toString + ";".space + s"charset=${codec.toString()}"
    }
}

case object HTMLContent extends Content {
    override def toString: String = "text/html"
}

case object PDFContent extends Content {
    override def toString: String = "application/pdf"
}

case object JSONContent extends Content {
    override def toString: String = "text/plain"
}

case object EventStreamContent extends Content {
    override def toString: String = "text/event-stream"
}

case class SomeContent(name: String) extends Content {
    override def toString: String = name
}

case object OctetStreamContent extends Content {
    override def toString: String = "application/octet-stream"
}

object Content extends Logging {
    private val values = SealedEnumRuntime.values[Content]
    private val mappedKeys: Map[String, Content] = values.map(x => (x.toString, x))(collection.breakOut)
    def getObject(objName: String): Option[Content] = {
        //text/html; charset=UTF-8
        objName match {
            case null =>
                None
            case _ =>
                val semColon = objName.indexOf(";")
                val charsetIndex = objName.indexOf("charset=")

                val content = if (semColon == -1) objName else objName.substring(0, semColon)
                val content1 = mappedKeys.get(content) match {
                    case Some(x) => x
                    case None =>
                        HTMLContent
                }

                val codec: Codec = if (charsetIndex === -1) Codec.defaultCharsetCodec else Codec(objName.substring(charsetIndex + "charset=".length))
                Some(ContentType(content = content1, codec = codec))
        }
    }


}
