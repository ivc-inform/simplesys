import com.simplesys.log.Logging
import com.simplesys.saxon.{Transform, XsltTransformer}
import java.io.File
import javax.xml.transform.stream.StreamSource
import net.sf.saxon.lib.FeatureKeys
import net.sf.saxon.s9api.{Serializer, Processor}
import org.scalatest.FunSuite
import com.simplesys.saxon._
import com.simplesys.saxon.XsltTransformer._
import scala.collection.mutable.ArrayBuffer
import scalax.file.ImplicitConversions._
import scalax.file.{PathSet, Path}
import com.simplesys.io._

//import com.simplesys.saxon.ControlStructs._

class TestSuit extends FunSuite with Logging {
    test("Test transform 1") {
        //val tr = new XsltTransformer
        //tr.transform(xsltFilePath = "greeting.xsl", xmlFilePath = "greeting.xml")

        val proc = new Processor(configuration);
        val comp = proc.newXsltCompiler();

        val exp = comp.compile(new StreamSource(new File("src/test/resources/greeting.xsl")));

        val source = proc.newDocumentBuilder().build(new StreamSource(new File("src/test/resources/greeting.xml")));
        //val out = proc.newSerializer(new File("src/test/out/greeting.html"));
        val out = proc newSerializer System.err

        out.setOutputProperty(Serializer.Property.METHOD, "html");
        out.setOutputProperty(Serializer.Property.INDENT, "yes");

        val trans = exp.load();

        trans.setInitialContextNode(source)
        trans.setDestination(out);
        trans.transform();
    }

    test("Test transform 2") {
        //withTransformation(/*(FeatureKeys.TRACE_LISTENER_CLASS -> "net.sf.saxon.trace.XSLTTraceListener"),*/ (FeatureKeys.ERROR_LISTENER_CLASS -> "com.simplesys.saxon.StandartErrorListener")) {
        //withTransformation(/*(FeatureKeys.TRACE_LISTENER_CLASS -> "net.sf.saxon.trace.XSLTTraceListener"),*/ (FeatureKeys.ERROR_LISTENER_CLASS -> "net.sf.saxon.lib.StandardErrorListener")) {
        withTransformation() {
            params =>
                params("tell") = Seq("55555", "123")
                Transform(
                    xsltPath = "/home/andrew/JOB/simplesys/saxon-wrapper/src/test/test/greeting.xsl",
                    xmlPath = "/home/andrew/JOB/simplesys/saxon-wrapper/src/test/test/greeting.xml"
                    //initialTemplate = "f"
                )
        }
        //throw new RuntimeException("Errors")
    }

    test("Test transform 3") {
        val path: Path = "/home/andrew/JOB/enzo/src/main/resources/defs/bo"
        val files: PathSet[Path] = path * "*.xml"

        withTransformation() {
            params =>
                params("FilesName") = files
                params("ResFileName") = Seq("/home/andrew/JOB/enzo/target/scala-2.10/src_managed/main/defs/app/generated/xml/AllBo.xml")
                Transform(
                    xsltPath = "/home/andrew/JOB/enzo/src/main/resources/defs/bo/MergeAll.xsl",
                    //xmlPath = "/home/andrew/JOB/simplesys/saxon-wrapper/src/test/test/greeting.xml",
                    initialTemplate = "merge"
                )
        }
        //throw new RuntimeException("Errors")
    }

    test("Test transform 4") {
        logger debug ("Debug")
    }
}