package com.simplesys.xhtml


import com.simplesys.xml.Elem
import scala.xml.{Elem => SElem}
import com.simplesys.log.Logging
import com.simplesys.common._
import java.io.{File, InputStream}
import com.simplesys.xml.factory.XMLLoader
import java.net.{URL, URI}
import scala.reflect.ClassTag

class XHTML extends XMLLoader with Logging {

    //private def fromSource(source: Source): Elem = ConstructingParser.fromSource(source, false).document.docElem
    //def loadFromString(str: String): Elem = fromSource(Source.fromString(str))

    /*def loadFromInputStream(is: InputStream): Elem = {
      val s = new StringBuilder
      Source.fromInputStream(is)(UTF8).getLines.filter(_.indexOf(s"DOCTYPE") == -1).foreach(s append _)
      loadString(s.toString)
    }*/

    def loadFromInputStreamURI(is: InputStream, schema: URI*): Elem = loadURI(is, schema: _*)
    def loadFromInputStreamURL(is: InputStream, schema: URL*): Elem = loadURL(is, schema: _*)

    def loadFromURSeq(ur_ : UR, ur_Schema: UR*): Elem = {
        def seqURI: Seq[URI] = ur_Schema map {
            case URIBox(Some(uri), _) => uri
            case URIBox(None, message) => throw new RuntimeException(message)
        }

        def seqURL: Seq[URL] = ur_Schema map {
            case URLBox(Some(url), _) => url
            case URLBox(None, message) => throw new RuntimeException(message)
        }

        ur_ match {
            case URIBox(Some(uri), _) =>
                loadFromInputStreamURI(uri.toURL.openStream, seqURI: _*)

            case URLBox(Some(url), _) =>
                loadFromInputStreamURL(url.openStream, seqURL: _*)

            case URIBox(None, message) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message)
            case URLBox(None, message) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message)

        }
    }

    def loadFromUR(ur_ : UR, ur_Schema: UR = URNull): Elem = {
        (ur_, ur_Schema) match {
            case (URIBox(Some(uri), _), URIBox(Some(uriSchema), _)) =>
                logger trace (s"URI: '${uri}'")
                logger trace (s"URI Schema: '${uriSchema}'")
                loadFromInputStreamURI(uri.toURL.openStream, uriSchema)
            //fromSource(Source.fromURL(uri.toURL))
            case (URIBox(Some(uri), _), URNull) =>
                logger trace (s"URI: '${uri}'")
                loadFromInputStreamURI(uri.toURL.openStream, Seq.empty[URI]: _*)
            //fromSource(Source.fromURL(uri.toURL))
            case (URLBox(Some(url), _), URLBox(Some(urlSchema), _)) =>
                logger trace (s"URL: '${url}'")
                logger trace (s"URL Schema: '${urlSchema}'")
                loadFromInputStreamURL(url.openStream, urlSchema)
            //fromSource(Source.fromURL(url))
            case (URLBox(Some(url), _), URNull) =>
                logger trace (s"URL: '${url}'")
                loadFromInputStreamURL(url.openStream, Seq.empty[URL]: _*)
            //fromSource(Source.fromURL(url))
            case (URLBox(None, message), URLBox(None, message1)) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message + " " + message1)
            case (URLBox(None, message), URNull) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message)
            case (URIBox(None, message), URIBox(None, message1)) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message + " " + message1)
            case (URIBox(None, message), URNull) =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", message)
            case _ =>
                loadFromUR(URIBox getResource (s"DocumentNotFoundPage.html")).setElementText(s"div", "id", "message", "Ошибка загрузки ресурса.")
        }
    }

    def loadFromString(str: String): Elem = loadString(str)
}


object XHTML {
    def loadFromURSeq(uri: UR, schemas: UR*): Elem = (new XHTML) loadFromURSeq(uri, schemas: _*)
    def loadFromUR(uri: UR, schema: UR = URNull): Elem = (new XHTML) loadFromUR(uri, schema)

    def loadFromString(str: String): Elem = (new XHTML) loadFromString str
    def loadFile(file: File, schemas: File*): Elem = (new XHTML) loadFile(file, schemas: _*)
    def loadFile[T: ClassTag](file: File, schemas: URI*): Elem = (new XHTML) loadFile(file, schemas: _*)
    def loadFile[T: ClassTag](file: File): Elem = (new XHTML) loadFile(file, Seq.empty[URI]: _*)
}


