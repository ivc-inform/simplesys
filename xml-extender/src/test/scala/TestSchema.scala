import com.simplesys.common.exception.ExtThrowable
import com.simplesys.log.Logging
import java.io.File
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import javax.xml.XMLConstants
import net.sf.saxon.lib.FeatureKeys
import net.sf.saxon.s9api.{Serializer, Processor}
import org.scalatest.FunSuite
import org.xml.sax.SAXException
import com.simplesys.common._

class TestSchema extends FunSuite with Logging {
  test("Text Validation") {

    URLBox getResource "defs/app/ds/schemaDS.xsd" match {
      case URLBox(Some(url), _) =>
        val schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(url)

        val validator = schema.newValidator();
        URLBox.getResource("defs/app/ds//userDS.xml") match {
          case URLBox(Some(url), _) =>
            val source = new StreamSource(url.openStream())

            try {
              validator.validate(source)
              logger info "OK."
            }
            catch {
              case e: SAXException => logger error (e: ExtThrowable).getStackTraceString
              case e: Throwable => throw e
            }
          case URLBox(None, message) =>
            logger debug message
        }

      case URLBox(None, message) =>
        logger debug message
    }

  }

  /*test("Test XSL Transformation") {
    val processor = new Processor(false)

    processor.setConfigurationProperty(FeatureKeys.SCHEMA_VALIDATION, true)
    processor.setConfigurationProperty(FeatureKeys.VALIDATION_WARNINGS, true)

    //val errors = new ErrorListener

    processor.getUnderlyingConfiguration.addSchemaSource(new StreamSource(new File("schemaURL")), errors)

    val serializer = new Serializer(new File("outFile"));

    val compiler = processor.newXsltCompiler()
    compiler setSchemaAware true

    val transformer = compiler.compile(new StreamSource(new File("stylesheet"))).load()
    transformer.setSource(new StreamSource(new File("inputSource")))
    transformer setDestination serializer
    transformer.transform()
  }*/
}