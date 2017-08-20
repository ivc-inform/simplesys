package com.simplesys.xml.factory

import java.io._
import java.net.{URI, URL}
import javax.xml.parsers.SAXParserFactory
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

import com.simplesys.xml.Elem
import org.xml.sax.XMLReader

import scala.io.Codec
import scala.io.Codec._
import scala.reflect.ClassTag
import scala.xml._

trait XMLLoader {
    private var adapter: NoBindingFactoryAdapter = null
    //val processor = new Processor(false)

    def loadXMLFromURI(source: InputSource, schemas: URI*): Elem = {
        lazy val parser: XMLReader = try {
            val f = SAXParserFactory.newInstance()
            f.setNamespaceAware(true)
            f.setFeature("http://xml.org/sax/features/namespace-prefixes", true)
            f.newSAXParser.getXMLReader
        } catch {
            case e: Exception =>
                throw e
        }

        schemas.length match {
            case 0 =>
                adapter = new NoBindingFactoryAdapter()
                parser setContentHandler adapter
            case _ =>

                val factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1")
                val _schema = factory.newSchema(schemas.map {
                    x => new StreamSource(x.toURL.toExternalForm())
                }.toArray[Source])

                val vh = _schema.newValidatorHandler()
                val provider = vh.getTypeInfoProvider()
                adapter = new NoBindingFactoryAdapter(provider)
                vh setContentHandler adapter
                parser setContentHandler vh
        }

        adapter.scopeStack push TopScope
        parser parse source
        adapter.scopeStack.pop
        adapter.rootElem
    }

    def loadXMLFromURL(source: InputSource, schemas: URL*): Elem = loadXMLFromURI(source, (schemas map (_.toURI)): _*)

    object Source {
        def fromFile(file: File)(codec: Codec = UTF8) = new InputSource(new InputStreamReader(new FileInputStream(file), codec.charSet))
        def fromInputStream(input: InputStream)(codec: Codec = UTF8) = new InputSource(new InputStreamReader(input, codec.charSet))
        def fromString(string: String) = new InputSource(new StringReader(string))
    }

    import Source._

    def loadFile(file: File, fileSchema: File*): Elem = loadXMLFromURI(fromFile(file)(), fileSchema.map(_.toURI): _*)
    def loadFile(file: File, fileSchema: File*)(codec: Codec): Elem = loadXMLFromURI(fromFile(file)(codec), fileSchema.map(_.toURI): _*)
    def loadFile[T: ClassTag](file: File, schemas: URI*): Elem = loadXMLFromURI(fromFile(file)(), schemas: _*)
    def loadFile[T: ClassTag](file: File, schemas: URI*)(codec: Codec): Elem = loadXMLFromURI(fromFile(file)(codec), schemas: _*)
    def loadFile[T: ClassTag](file: File)(codec: Codec): Elem = loadXMLFromURI(fromFile(file)(codec), Seq[URI](): _*)

    def loadURI(is: InputStream, schema: URI*): Elem = loadXMLFromURI(fromInputStream(is)(), schema: _*)
    def loadURI(is: InputStream, schema: URI*)(codec: Codec): Elem = loadXMLFromURI(fromInputStream(is)(codec), schema: _*)
    def loadURL(is: InputStream, schema: URL*): Elem = loadXMLFromURL(fromInputStream(is)(), schema: _*)
    def loadURL(is: InputStream, schema: URL*)(codec: Codec): Elem = loadXMLFromURL(fromInputStream(is)(codec), schema: _*)

    def loadString(string: String): Elem = loadXMLFromURI(fromString(string), Seq[URI](): _*)
}
