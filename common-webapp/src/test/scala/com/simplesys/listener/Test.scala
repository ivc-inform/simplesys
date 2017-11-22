package com.simplesys.listener

import com.simplesys.annotation.RSTransfer
import com.simplesys.circe.Circe._
import com.simplesys.common.Strings._
import com.simplesys.config.Config
import com.simplesys.isc.dataBinging.DSRequest
import com.simplesys.jdbc.control.DsRequest
import com.simplesys.log.Logging
import com.simplesys.sql.OracleDialect
import com.simplesys.xml.Xml
import com.simplesys.xml.factory.XMLLoader
import io.circe.Json
import io.circe.Json._
import org.scalatest.FunSuite
import io.circe.generic.auto._
import io.circe.syntax._

import scala.io.Codec
import scala.reflect.ClassTag
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe ⇒ ru}

@RSTransfer(urlPattern = "123456")
class A

object B {
    object C {
        val a = "123456"
        val b = "654321"
    }
}


class Test extends FunSuite with Config with Logging with XMLLoader {

    import CommonWebAppListener._

    test("setPaths") {
        val seq = Seq("/MainPage",
            "/logic/Category_param/Remove",
            "/logic/TransTable/Add",
            "/logic/DownloadNo1/Update",
            "/logic/managerOfFixedTemplates/Publish",
            "/logic/controlOfRead/Update",
            "/logic/SaveRestoreDict/Import",
            "/logic/RussianDictonary/Remove",
            "/logic/EnglishDictonary/Fetch",
            "/logic/Category_param_type/Remove",
            "/logic/managerOfFixedTemplates/UpdateTemplateInPlace",
            "/logic/SaveRestoreDict/Download",
            "/logic/UnknownWords/Remove",
            "/logic/managerOfFixedTemplates/Fetch",
            "/logic/managerOfFixedTemplates/RecalcTemplate",
            "/logic/managerOfFixedTemplates/UpdateTemplate",
            "/logic/Category_param/Add",
            "/logic/Category/Remove",
            "/logic/managerOfFixedTemplates/CategoriesFetch",
            "/logic/Category_param_category/Fetch",
            "/logic/TransTable/Update",
            "/logic/untrunsliterate/Update",
            "/logic/RussianDictonary/Fetch",
            "/logic/Category_param/Fetch",
            "/logic/controlOfRead/Add",
            "/logic/untrunsliterateRules/Update",
            "/Start",
            "/logic/managerOfFixedTemplates/RemoveTemplate",
            "/logic/Category_param_type/Update",
            "/logic/untrunsliterateRules/Add",
            "/logic/Category_param_type/Fetch",
            "/logic/SaveRestoreDict/Export",
            "/Export/logic/SaveRestoreDict/Export",
            "/Export/logic/SaveRestoreDict/Export/1",
            "/logic/Category/Update",
            "/logic/Category_param_category/Add",
            "/logic/Category_param_category/Remove",
            "/logic/TransTable/Remove",
            "/logic/LoadDataSources/dynamic",
            "/logic/LoadDataSources/columns",
            "/logic/managerOfFixedTemplates/Clear",
            "/logic/UnknownWords/Fetch",
            "/logic/UnknownWords/FetchDet",
            "/logic/Category/Add",
            "/logic/LoadDataSources",
            "/logic/Category_param_type/Add",
            "/logic/EnglishDictonary/Remove",
            "/logic/Category_param/ComboBox/Fetch",
            "/logic/unknownDictonary/Remove",
            "/logic/untrunsliterate/Fetch",
            "/logic/TransTable/Fetch",
            "/logic/Category_param/Tree/Fetch",
            "/logic/UnknownWords/FetchToken",
            "/logic/Category/Publish",
            "/logic/controlOfRead/Fetch",
            "/logic/SaveRestoreDict/Upload",
            "/logic/unknownDictonary/Fetch",
            "/logic/controlOfRead/Remove",
            "/logic/managerOfFixedTemplates/FetchTemplate",
            "/logic/managerOfFixedTemplates/FetchTemplateTokens",
            "/logic/Category/Fetch",
            "/logic/UnknownWords/Publish",
            "/logic/LoadDataSources/tables",
            "/logic/managerOfFixedTemplates/FetchTemplateParts",
            "/logic/untrunsliterateRules/Remove",
            "/logic/Category_param_category/Update",
            "/logic/managerOfFixedTemplates/FetchTemplateDet",
            "/logic/Category_param/Update",
            "/logic/managerOfFixedTemplates/AddTemplate").sortWith(_ < _)


        //seq foreach println
        //println(seq.size)


        (seq map (item => CommonWebAppListener.minPath(seq, item))).distinct.sortWith(_ < _) foreach println
    }

    test("annotation") {
        val classSymbol: ru.ClassSymbol = ru.typeOf[A].typeSymbol.asClass
        val res = check4RegisterTransfer[RSTransfer](classSymbol)
        logger debug res
    }

    test("get methods of object") {

        def makeVersionList[T: TypeTag : ClassTag](e: T): Unit = {
            import scala.reflect.runtime.{universe => ru}

            val classLoaderMirror = ru.runtimeMirror(getClass.getClassLoader)
            val a: ru.Type = ru.typeOf[T]
            val classSymbol = a.typeSymbol.asClass

            a.decls.sorted.filter(_.isMethod).foreach {
                item =>
                    println(item.name.toString)
            }

            val decls = a.decls.sorted.filter(_.isMethod).filter(!_.name.toString.contains("<init>"))

            decls.foreach {
                item =>

                    val shippingTermSymb = a.decl(ru.TermName(item.name.toString)).asTerm
                    val im = classLoaderMirror.reflect(e)
                    val shippingFieldMirror = im.reflectField(shippingTermSymb)
                    val res = shippingFieldMirror.get.toString()

                    println(s"${item.name}=$res")
            }
        }

        makeVersionList(B.C)

        val classLoaderMirror = ru.runtimeMirror(getClass.getClassLoader)
        val classSymbol = ru.typeOf[B.C.type].typeSymbol.asClass

        val decls = ru.typeOf[B.C.type].decls.sorted.filter(_.isMethod).filter(!_.isConstructor)

        decls.foreach {
            item =>
                val shippingTermSymb = ru.typeOf[B.C.type].decl(ru.TermName(item.name.toString)).asTerm
                val im = classLoaderMirror.reflect(B.C)
                val shippingFieldMirror = im.reflectField(shippingTermSymb)
                val res = shippingFieldMirror.get.toString()

                println(s"${item.name}=$res")
        }
    }

    test("classPath") {
        val classPath: List[String] = getStringList("app.classPath4Servlet")
        logger debug s"classPath = ${classPath.mkString(",".newLine)}"
    }

    test("To Json") {
        val xml = loadString(
            """<DataSource ID="Action">
              |    <fields>
              |        <field name="target" type="string"/>
              |        <field name="name" type="string"/>
              |        <field name="title" type="string"/>
              |        <field name="mapping" type="string" multiple="true"/>
              |    </fields>
              |</DataSource>""".stripMargin)
        val json = Xml.getJS(xml, "Action", true)
        println(json)
    }

    test("DSRequest") {
        import de.heikoseeberger.akkahttpcirce.CirceEnum._
        //import de.heikoseeberger.akkahttpcirce.CirceEnum._ Необходим для правильного отображения Enum типа case object from sealed trait; в общем случае это имеет вид {"name":{}}

        println(new DsRequest(
            sqlDialect = OracleDialect,
            startRow = 0,
            endRow = 0,
            sortBy = Vector.empty,
            data = Json.Null
        ).asJson.spaces41)
    }
}
