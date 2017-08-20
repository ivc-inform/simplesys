package com.simplesys.listener

import java.io.File

import akka.actor.{Actor, Props}
import com.simpesys.classutil.ClassFinder
import com.simpesys.reflect.runtime.universe.ReflectionHelpers
import com.simpesys.reflect.runtime.universe.ReflectionHelpers._
import com.simplesys.akka.http.Async.{CompleteAsk, SseCompleteAsk}
import com.simplesys.akka.http.Endpoints._
import com.simplesys.akka.http.sse.SseFutureResponse
import com.simplesys.akka.http.{AkkaMap, Endpoint, FutureResponse, ServletContextInit}
import com.simplesys.annotation.{RSTransfer, SseTransfer}
import com.simplesys.common.Strings._
import com.simplesys.common._
import com.simplesys.isc.dataBinging.DSResponseDyn
import com.simplesys.isc.dataBinging.RPC.RPCResponseDyn
import com.simplesys.json.{JsonList, JsonObject}
import com.simplesys.log.Logging
import com.simplesys.servlet._
import com.simplesys.servlet.http.sse.{SseServletRequest, SseServletResponse}
import com.simplesys.servlet.http.{HttpServletRequest, HttpServletResponse}
import com.simplesys.xml.Xml
import com.simplesys.xml.factory.XMLLoader

import scala.annotation.StaticAnnotation
import scala.collection.mutable.ListBuffer
import scala.io.Codec
import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

object CommonWebAppListener extends Logging {
    def minPath(paths: Seq[String], path: String): String = {

        val _seq = paths.filter(_ != path)
        var length = path.split("/").length
        var length1 = length
        var i = 0
        var res = path

        while (i < _seq.size) {
            val item = _seq(i)
            val res1 = item.split("/").toSet.intersect(path.split("/").toSet)
            if ((res1.mkString("/") != "") && (path.indexOf(res1.mkString("/")) == 0)) {
                if (res1.size < length) {
                    length = res1.size
                }
            }

            i += 1
        }

        if (length == path.split("/").length)
            res
        else
            path.split("/").dropRight(length1 - length).mkString("/") + "/*"
    }

    def check4RegisterTransfer[A: TypeTag](classSymbol: ClassSymbol): String = {
        try {
            val annotationTree = ReflectionHelpers.getAnnotation[A](classSymbol)
            annotationTree match {
                case None =>
                    strEmpty
                case Some(annotation) =>
                    annotation.tree.children.tail match {
                        case head :: Nil =>
                            head match {
                                case Literal(Constant(x: String)) =>
                                    x
                                case x =>
                                    throw new RuntimeException(s"Bad branch $x")
                            }
                        case x =>
                            throw new RuntimeException(s"Bad bramch $x")
                    }
            }
        }
        catch {
            case e: Throwable =>
                logger error e
                strEmpty
        }
    }
}

trait CommonWebAppListener extends ServletContextListener with ServletContextInit with XMLLoader {

    import com.simplesys.listener.CommonWebAppListener._

    val loadSchemas: Boolean

    override def UserContextInitialized(sce: ServletContextEvent) {

        def registerTransfer[A: TypeTag](classSymbol: ClassSymbol, providerMap: ProviderMap): Unit = {
            getAnnotation[A](classSymbol) match {
                case None =>
                case Some(annotation) =>
                    annotation.tree.children.tail match {
                        case head :: Nil =>
                            head match {
                                case Literal(Constant(path: String)) =>
                                    (providerMap get path) match {
                                        case None =>
                                            val actor = system.actorOf(Props(new Actor {
                                                def receive = {
                                                    case request: SseServletRequest => {
                                                        val future = SseFutureResponse {
                                                            response: SseServletResponse =>
                                                                context.actorOf(Props(classLoaderMirror runtimeClass classSymbol, request, response, sce.ServletContext)) ! GetData
                                                        }
                                                        sender ! SseCompleteAsk(future)
                                                    }
                                                    case request: HttpServletRequest => {
                                                        val future = FutureResponse {
                                                            response: HttpServletResponse =>
                                                                context.actorOf(Props(classLoaderMirror runtimeClass classSymbol, request, response, sce.ServletContext)) ! GetData
                                                        }
                                                        sender ! CompleteAsk(future)
                                                    }
                                                }
                                            }))

                                            providerMap += path -> actor
                                            logger trace s"Added path: $path, endpoint: $actor"
                                        case _ =>
                                            logger warn (s"Actor with path '$path' already exists.")
                                    }
                            }
                        case x =>
                            throw new RuntimeException(s"Bad bramch $x")
                    }
                case x =>
                    throw new RuntimeException(s"Bad branch $x")
            }
        }

        import com.simplesys.io._

        val webInfPath: String = {
            ServletContext.WebInfPath match {
                case None =>
                    logger trace s"ServletContext.UserDir : ${ServletContext.UserDir}"
                    (ServletContext.UserDir.asPath / getString("app.classPath4ServletDebug.webInfPass").asPath).path
                case Some(path) =>
                    val _path = path.toFile
                    if (_path.exists())
                        _path.getAbsolutePath()
                    else {
                        logger trace s"ServletContext.UserDir : ${ServletContext.UserDir}"
                        (ServletContext.UserDir.asPath / getString("app.classPath4ServletDebug.webInfPass").asPath).path
                    }
            }
        }

        logger trace s"web-inf: ${webInfPath}"

        val classPath: List[String] = {
            val res = ListBuffer.empty[String]
            getStringList("app.classPath4Servlet").foreach {
                path =>
                    val _path = path.replace("$web-inf", webInfPath)
                    //val _path = path.replace("$web-inf", "/home/andrew/Job/dm-processing/target/webapp/WEB-INF") //ОТЛАДОЧНО

                    val p = _path.toFile
                    if (!p.exists()) {
                        if (_path.indexOf(".jar") != -1) {
                            val __path = _path.replace("???version???", strEmpty)
                            val nameWithOutExt = __path.onlyFileName
                            val dir = __path.substring(0, __path.lastIndexOf("/")).toFile
                            if (dir.isDirectory) {
                                import com.simpesys.file.util._
                                val files = dir.listRecursively().toSeq
                                files.foreach {
                                    file =>
                                        if (file.onlyFileName.indexOf(nameWithOutExt) != -1)
                                            res += file.getAbsolutePath
                                }
                            }
                        }
                    }
                    else
                        res += p.getAbsolutePath
            }
            res.toList
        }

        val classPathDebug: List[String] = if (classPath.exists(_ == strEmpty)) getStringList("app.classPath4ServletDebug").map {
            path =>
                val p = path.replace("$user-dir", ServletContext.UserDir).replace("$user-home", ServletContext.UserHome).toFile
                if (!p.exists())
                    throw new FileNotFound(s"File not found: '${p.getAbsolutePath}'")
                else
                    p.getAbsolutePath
        } else List.empty[String]

        logger trace s"classPath = ${classPath.mkString(newLine.newLine + "[", ",".newLine, "]".newLine)}"

        val files: Stream[Option[ClassSymbol]] = ClassFinder(classPath.map(_.toFile): _*).getClasses()

        def RegisterHttpServletes[A <: StaticAnnotation : TypeTag, C <: AkkaMap : TypeTag](): Unit = {
            val pathAndClass = scala.collection.mutable.Set.empty[(String, ClassSymbol)]

            files foreach {
                _ match {
                    case Some(classSymbol) =>
                        val path = check4RegisterTransfer[A](classSymbol)
                        if (path.nonEmpty) {
                            logger trace s"fullName : ${classSymbol.fullName}"
                            pathAndClass += path -> classSymbol
                            logger trace s"path: $path"
                            logger trace s"file: ${classSymbol.fullName.newLine}"
                        }
                    case None =>
                }
            }


            val onlyPahts: Seq[String] = pathAndClass.map(_._1).To
            val servletesPaths = (onlyPahts map (item => CommonWebAppListener.minPath(onlyPahts, item))).distinct.sortWith(_ < _)

            val pathsAndClassAndServletsPath: Seq[(String, ClassSymbol, String)] = pathAndClass.map { case (path, symbol) => (path, symbol, CommonWebAppListener.minPath(onlyPahts, path)) }.To

            servletesPaths.foreach {
                servletesPath =>
                    val providerMap: ProviderMap = scala.collection.mutable.Map.empty[String, Endpoint]

                    pathsAndClassAndServletsPath.filter(_._3 == servletesPath).foreach { case (path, symbol, _) => registerTransfer[A](symbol, providerMap) }
                    val servletName = "CommonServlet_" + servletesPath.mkString("")

                    sce.ServletContext.Attribute("ProviderMap" + servletName, Some(providerMap))

                    val classSymbol = ru.typeOf[C].typeSymbol.asClass
                    val className = classSymbol.fullName
                    sce.ServletContext.AddServlet(servletName, className, true, servletesPath) match {
                        case null ⇒
                            logger error newLine.newLine + s"Not Regitred servlet: $servletName ($className), with actors: ${providerMap.map(_._1).toSeq.sortWith(_ < _).mkString(newLine.newLine + "[".newLine, newLine, s"${newLine}]:${providerMap.size}")}".newLine
                        case _ ⇒
                            logger trace newLine.newLine + s"Regitred servlet: $servletName ($className), with actors: ${providerMap.map(_._1).toSeq.sortWith(_ < _).mkString(newLine.newLine + "[".newLine, newLine, s"${newLine}]:${providerMap.size}")}".newLine
                    }
            }
        }

        RegisterHttpServletes[RSTransfer, CommonHttpServlet]()
        RegisterHttpServletes[SseTransfer, CommonSseServlet]()

        if (loadSchemas) {
            val path = s"${sce.ServletContext.RealPath(".").getOrElse("")}/${getString("app.isomorphicDir")}${getString("app.schemasDir")}"
            val schemasFiles = new File(path).listFiles.filter(_.getName.endsWith("ds.xml")).sortWith(_.getName < _.getName)

            val list = JsonList()

            logger debug "/////////////////////////////////////////////////////////////// Schema files: ///////////////////////////////////////////////////////////////////"
            schemasFiles.foreach {
                file =>
                    val componentName = file.getName.replace(".ds.xml", "")
                    val json = Xml.getJS(loadFile(file)(Codec.UTF8), componentName, getBoolean("app.jsonSchemaPrettyPrint")).trim

                    if (json != "") {
                        list += JsonObject("component" -> componentName, "jsonStr" -> json)
                        logger debug s"Parsed schema: $componentName"
                        if (getBoolean("app.jsonSchemaPrettyPrint"))
                          logger debug s"JSON: $json"
                    }
            }
            logger debug "/////////////////////////////////////////////////////////////// End Schema files: ///////////////////////////////////////////////////////////////"

            val schemaList = new DSResponseDyn {
                Status = RPCResponseDyn.statusSuccess
                Data = list
            }

            sce.ServletContext.Attribute("schemaList", Some(schemaList))
        }
    }
}
