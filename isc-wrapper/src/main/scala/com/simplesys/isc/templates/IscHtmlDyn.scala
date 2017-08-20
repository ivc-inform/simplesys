package com.simplesys.isc.templates

import java.io.{Serializable, File}

import com.simplesys.common.Strings._
import com.simplesys.common._
import com.simplesys.config.Config
import com.simplesys.isc.system.IscDyn
import com.simplesys.isc.system.global._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.JsonInt
import com.simplesys.log.Logging
import com.simplesys.servlet.ServletContext
import com.simplesys.xhtml.XHTML
import com.simplesys.xml.Elem._

import scala.collection.mutable
import scala.io.Codec._
import scala.io.Source

trait IscHtmlDyn extends Config {

    val _Isc = IscDyn()
    ModeNames = PortalMode

    def servletContext: ServletContext

    protected def isomorphicDir = getString("app.isomorphicDir")
    protected def modulesDir = isomorphicDir + getString("app.modulesDir")
    protected def modulesDir1 = getString("app.modulesDir") + File.separator
    protected def localesDir = isomorphicDir + getString("app.localesDir")

    protected def titlePage = "Unknown page..."
    private val modules = mutable.Queue.empty[String]

    protected def contextPath = servletContext.ContextPath
    protected def ccsPaths = Seq.empty[String]
    protected def jsScripts = Seq.empty[String]
    protected def jsFirstVariables = Seq.empty[_JSVariable]
    protected def jsLastVariables = Seq.empty[_JSVariable]
    protected val urlMainPage = "MainPage"
    protected def loadingMessage = "Загрузка...&nbsp;${hourglass_time_loading_wait-128.png}"

    protected def addModule(moduleName: String) {
        modules.find(_ == moduleName) match {
            case None => modules += moduleName
            case _ =>
        }
    }

    protected def addModules(modulesName: String*) {
        modulesName foreach addModule
    }

    protected def IscEmptyPage(servletContextPath: String = ""): PageHtml = {

        val orderModules = Source.fromInputStream(servletContext.ResourceAsStream(getString("app.ModulesLoadOrderFile")))(UTF8).getLines.toSeq.zipWithIndex

        implicit class SeqOpts(seq: Seq[String]) {
            def getOrder(path: String): Int = {
                val list = orderModules.filter { case (value, index) => value == path}.toList
                if (list.length > 1) throw new RuntimeException(s"Path: ${path} doubled.")
                list.headOption match {
                    case None => Int.MaxValue
                    case Some((_, index)) => index
                }
            }

            def toOrdered: Seq[(String, Int)] = seq.map { x => (x, getOrder(x))}.toSeq
        }

        var res = XHTML.loadFromUR(URIBox.getResource("EmptyISCPageDyn.html")).
          appendElement("head", <title>
            {titlePage}
        </title>).
          appendElement("head", <script>
            {s"var isomorphicDir = ${(servletContextPath + isomorphicDir + "/").dblQuoted};"}{s"var isc_css3Mode = ${"on".dblQuoted};"}{s"var simpleSysContextPath = ${servletContextPath.dblQuoted}; var simpleSyS = {};"}
        </script>)

        res = res.addHeadVariables(jsFirstVariables: _*)

        //res = res.appendElement("head", <script></script>.setElementAttribute("src", servletContextPath + "isomorphic/system/development/ISC_FileLoader.js"))
        modules foreach {
            module => res = res.appendElement("head", <script></script>.setElementAttribute("src", servletContextPath + modulesDir + "/" + module))
        }

        val getLines = Source.fromInputStream(servletContext.ResourceAsStream(getString("app.ResultListJSFile")))(UTF8).getLines.toSeq

        ///////////////////////////////////
        val fileIncludeModules: Seq[(String, Int)] = getLines.filter(_.indexOf("$modulesDir") == -1).filter(x => x.substring(x.lastIndexOf('.') + 1, x.length) == "js").toOrdered

        val fileIncludeModulesISC: Seq[(String, Int)] = getLines.filter(_.indexOf("$modulesDir") > -1).toOrdered.map { case (path, index) => (path.replace("$modulesDir", modulesDir1), index)}

        val fileIncludeModulesCSS: Seq[String] = getLines.filter(x => x.substring(x.lastIndexOf('.') + 1, x.length) == "css")

        val totalPath = (fileIncludeModules ++ fileIncludeModulesISC).sortWith((x, y) => x._2 < y._2)
        ///////////////////////////////////

        res = res.addHeadScripts(servletContext, totalPath: _*)
        res = res.addHeadStyles(servletContext, fileIncludeModulesCSS: _*)

        res = res.addHeadVariable(JSVariable("message_connectTimeout", JsonInt(getInt("messaging.connectTimeout"))))
        res
    }

    protected def IscEmptyPage(servletContext: ServletContext): PageHtml = IscEmptyPage(servletContext.ContextPath)

}

