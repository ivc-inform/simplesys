package com.simplesys.saxon

import java.util.Locale
import javax.xml.transform.SourceLocator
import javax.xml.transform.stream.StreamSource

import com.simplesys.common.Strings._
import com.simplesys.common.URIBox
import com.simplesys.file.ImplicitConversions._
import com.simplesys.file.Path
import com.simplesys.io._
import com.simplesys.log.Logging
import net.sf.saxon.Configuration
import net.sf.saxon.s9api._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.collection.mutable.{ArrayBuffer, Map}

case class Transform(xsltPath: Path, xmlPath: Path = "", initialTemplate: String = "", initialMode: String = "", out: Serializer = new Serializer(System.out))

case class TransformWithBlock(xsltPath: Path, xmlPath: Path = "", initialTemplate: String = "", initialMode: String = "", out: Serializer = new Serializer(System.out), block: () => Unit)


object XsltTransformer extends Logging {
    val configuration: Configuration = URIBox.getResource("config.xsd") match {
        case URIBox(Some(uri), _) => Configuration readConfiguration (new StreamSource(uri.toURL openStream))
        case URIBox(None, message) => throw new RuntimeException(message)
    }

    //val baos = new ByteArrayOutputStream()
    val listner = new StandartErrorListener
    //listner.ErrorOutput = new PrintStream(baos)
    configuration setErrorListener listner

    def withTransformation(configProps: (String, Any)*)(function: (Map[QName, XdmValue]) => Transform): Int = {
        listner.errorCount = 0
        val proc = new Processor(configuration)
        configProps foreach {
            case (name, value) => proc.setConfigurationProperty(name, value)
        }

        val comp = proc.newXsltCompiler()
        val params = Map.empty[QName, XdmValue]

        val res = function(params)

        val exp: XsltExecutable = comp compile (new StreamSource(res.xsltPath.toFile))

        val trans = exp.load()

        if (!res.xmlPath.path.isEmpty)
            trans.setInitialContextNode(proc.newDocumentBuilder.build(new StreamSource(res.xmlPath.toFile)))

        if (!res.initialTemplate.isEmpty)
            trans setInitialTemplate res.initialTemplate

        if (!res.initialMode.isEmpty)
            trans setInitialMode res.initialMode

        trans setDestination res.out

        trans.setMessageListener((content: XdmNode, terminate: Boolean, locator: SourceLocator) => {
            logger.trace(s">> Message terminate=${if (terminate) "yes" else "no"} at ${
                val fmt = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")
                new DateTime().toString(fmt.withLocale(Locale.ROOT))
            }")
            logger.trace(s"   From instruction at line: ${locator.getLineNumber} of ${locator.getSystemId}")
            logger.trace(s"${space.space.space + content.getStringValue} <<")
        })

        //logger.trace(s"Start transform for: ${res.xmlPath.path}")
        params foreach {
            case (name, value) => trans.setParameter(name, value)
        }

        trans transform()
        //logger.trace(baos.toString("UTF-8"))
        logger.trace(s"Transform done.")
        listner.errorCount
    }

    def withSeqTransformation(configProps: (String, Any)*)(function: (ArrayBuffer[Map[QName, XdmValue]]) => TransformWithBlock): Int = {
        listner.errorCount = 0
        val proc = new Processor(configuration)
        configProps foreach {
            case (name, value) => proc.setConfigurationProperty(name, value)
        }

        val comp = proc.newXsltCompiler()
        val paramsSet = ArrayBuffer.empty[Map[QName, XdmValue]]

        val res = function(paramsSet)

        val exp: XsltExecutable = comp compile (new StreamSource(res.xsltPath.toFile))

        val trans = exp.load()

        if (!res.xmlPath.path.isEmpty)
            trans.setInitialContextNode(proc.newDocumentBuilder.build(new StreamSource(res.xmlPath.toFile)))

        if (!res.initialTemplate.isEmpty)
            trans setInitialTemplate res.initialTemplate

        if (!res.initialMode.isEmpty)
            trans setInitialMode res.initialMode

        trans setDestination res.out

        trans.setMessageListener((content: XdmNode, terminate: Boolean, locator: SourceLocator) => {
            logger.trace(s">> Message terminate=${if (terminate) "yes" else "no"} at ${
                val fmt = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")
                new DateTime().toString(fmt.withLocale(Locale.ROOT))
            }")
            logger.trace(s"   From instruction at line: ${locator.getLineNumber} of ${locator.getSystemId}")
            logger.trace(s"${space.space.space + content.getStringValue} <<")
        })

        var i = 1
        paramsSet foreach {
            set =>
                set foreach {
                    case (name, value) =>
                        trans.setParameter(name, value)
                }

                trans transform()
                res.block()
                logger.trace(s"Transform (${i}) done.")
                i += 1
        }

        listner.errorCount
    }

}
