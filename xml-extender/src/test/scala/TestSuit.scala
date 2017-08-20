import com.simplesys.common.{URLBox, URIBox}
import com.simplesys.html.{`class`, id, Span}
import com.simplesys.log.Logging
import com.simplesys.xhtml.XHTML
import com.simplesys.xml.Elem
import com.simplesys.xml.Elem._
import com.simplesys.common.Strings._
import java.io.File
import org.scalatest.FunSuite
import scala.io.Source
import scala.io.Codec._
import scala.xml.NodeSeq

class TestSuit extends FunSuite with Logging {
  var s: String = _

  test("Document not found") {
    var uri = URIBox getResource "DocumentNotFoundPage1.html"

    val e: Elem = XHTML loadFromUR (uri)

    logger debug (newLine + e.toPrettyString)
  }

  test("RegistrationPage") {
    var uri = URIBox getResource "RegistrationPage.xhtml"

    val e: Elem = XHTML loadFromUR (uri)

    logger debug (newLine + e.toPrettyString)
  }

  val xmlBooks =
    <books instruction="update">
      <book instruction="remove" name="book1" status=" "/>
      <book instruction="add" name="book3" status=" "/>
    </books>

  test("Modify XML") {
    logger debug("XML : %s", newLine + xmlBooks.toPrettyString)

    val xml = xmlBooks removeElementAttribute("book", "instruction", "remove", "status")
    logger debug("XML : %s", newLine + xml.toPrettyString)
  }

  test("Modify XML1") {
    var xml = <a/>
    logger debug("XML : %s", newLine + xml.toPrettyString)

    xml = xml setElementAttribute("href", "OK")
    logger debug("XML : %s", newLine + xml.toPrettyString)

    xml = xml removeElementAttribute ("href")
    logger debug("XML : %s", newLine + xml.toPrettyString)
  }

  test("Load ISC Page") {
    val uri = URIBox getResource "EmptyISCPage.html"

    val e = XHTML loadFromUR (uri)

    logger debug e.toPrettyString
  }

  test("Load EmpltyIscPage") {
    val PageHtml = XHTML.loadFromUR(URIBox.getResource("EmptyISCPage.html")).
      appendElement("head", <script>
      {"var isomorphicDir = 'isomorphic/';"}
    </script>).
      setElementAttribute("script", "id", "loader_skin", "src", "isomorphic/skins/" + "TreFrog" + "/load_skin.js")
    logger debug (PageHtml.toPrettyString)
  }

  test("bonecp-config-stack") {
    var configEmpty = <bonecp-config-stack/>

    configEmpty = configEmpty.appendElement(
      <property>
        {1521}
      </property>.setElementAttribute("name", "port"))
    configEmpty = configEmpty.appendElement(<property>
      {"xe"}
    </property>.setElementAttribute("name", "serviceName"))

    logger debug("%s", newLine + configEmpty.toPrettyString)
  }

  test("xmlBeautifiler") {
    var configEmpty = <bonecp-config-stack/>

    configEmpty = configEmpty.appendElement(
      <property>
        {1521}
      </property>.setElementAttribute("name", "port"))
    configEmpty = configEmpty.appendElement(<property>
      {"xe"}
    </property>.setElementAttribute("name", "serviceName"))

    logger debug (newLine + configEmpty.toString())
    logger debug newLine + configEmpty.toPrettyString
  }

  test("GetList HTMLEntityNames") {
    var url = URLBox getResource "HTMLEntityNames"
    def getName(str: String) = str.substring(1, str.indexOf(";"))
    def getValue(str: String) = str.substring(str.indexOf("U+") + 2)


    Source.fromURL(url)(UTF8).getLines() foreach (item => logger debug("name: %s value: %s", getName(item), getValue(item)))
  }

  test("merge") {
    val xml =
      <run xmloutputversion="1.02">
        <info type="a"/>
        <debugging level="0"/>
        <host endtime="1237144751" starttime="1237144741">
          <status reason="somereason" state="up"/>
          <something avalue="test" test="alpha"/>
          <target>
            <system name="computer"/>
          </target>
          <results>
            <result id="1">
              <state value="test"/>
              <service value="gamma"/>
            </result>
            <result id="2">
              <state value="test4"/>
              <service value="gamma4"/>
            </result>
            <result id="2">
              <service value="gamma200"/>
            </result>
            <result id="3">
              <state value="testagain"/>
              <service value="gamma2"/>
            </result>
            <result id="4">
              <state value="testagain4"/>
              <service value="gamma4"/>
            </result>
          </results>
          <times something="0"/>
        </host>
        <runstats>
          <finished time="1237144751" timestr="Sun Mar 15 19:19:11 2009"/>
          <result total="0"/>
          <result1>
            123456
          </result1>
        </runstats>
      </run>

    xml.log
  }

  test("Refs.xml with Schema") {
    var uri = URIBox getResource "defs/app/ds/userDS.xml"
    var uriSchema = URIBox getResource "defs/app/ds/schemaDS.xsd"
    var uriSchema2 = URIBox getResource "defs/app/schemaISC.xsd"

    val e: Elem = XHTML loadFromURSeq(uri, uriSchema, uriSchema2)

    logger debug (newLine + e.toPrettyString)
  }

  test("Get Type") {
    var uri = URIBox getResource "defs/app/ds/userDS.xml"
    var uriSchema = URIBox getResource "defs/app/ds/schemaDS.xsd"

    val e: Elem = XHTML loadFromUR(uri, uriSchema)
    //val e: Elem = XHTML loadFromURI (uri)

    val n: Elem = ((e \ "Native") \ "RestDataSourceDyn")
    n.log

  }

  test("Get Type1") {
    //var uri = URIBox getResource "defs/app/ds/userDS.xml"
    var uriSchema = URIBox getResource "defs/app/ds/schemaDS.xsd"

    val e: Elem = XHTML loadFile(
      new File("/home/andrew/JOB/fsm-generation/target/scala-2.10/src_managed/main/defs/app/generated/user.xml"),
      new File("/home/andrew/JOB/fsm-generation/src/main/resources/defs/app/xsd/schemaApp.xsd")
      )
    //val e: Elem = XHTML loadFromURI (uri)

    /*val n: Elem = ((e \ "Native") \ "RestDataSourceDyn")
    n.log*/

    e.log

  }

    test("Span"){
        val xml = Span("123456", id("123456"), `class`("classDD"))
        val xml1 = Span("123456", id("123456"), `class`(this.getClass.getSimpleName))
        val xmlMain = Span(Seq(xml, xml1), id("0"), `class`("classSS"))

        //xml.logPretty(true)
        xmlMain.logPretty(true)
    }

}
