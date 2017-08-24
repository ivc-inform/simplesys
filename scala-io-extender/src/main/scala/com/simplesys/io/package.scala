package com.simplesys

import java.io.{File, PrintWriter, StringWriter}
import java.net.URI
import javax.xml.transform.stream.StreamSource

import com.simplesys.file.defaultfs.DefaultPath
import com.simplesys.file.{Path, PathSet}
import com.simplesys.log.Logging

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext
import scala.io.Codec._
import scala.io.Source

package object io extends Logging {
    protected[io] lazy val executionContext = ExecutionContext.global

    private def _onlyFileName(path: String): String = {
        val res = path.substring(path.lastIndexOf("/") + 1)
        val index = res.indexOf(".")
        if (index != -1)
            res.substring(0, res.lastIndexOf("."))
        else
            res
    }

    def strs2Files(paths: String*): Seq[File] = paths.map(new File(_))

    implicit class RichFile(file: File) {
        def ==> : String = Source.fromFile(file).mkString
        def |=> : Iterator[String] = Source.fromFile(file).getLines()

        def <==(sringWriter: StringWriter) {
            <==(sringWriter.toString)
        }

        def <==(string: String): File = {
            val out = new PrintWriter(file)
            try {
                out print string
                file
            }
            finally
                out.close()
            file
        }

        def <==(f: (String => Unit) => Unit): File = {
            val out = new PrintWriter(file)
            try {
                f(out.print)
                file
            }
            finally
                out.close()
            file
        }

        def <=|(f: (String => Unit) => Unit): File = {
            val out = new PrintWriter(file)
            try {
                f(out.println)
                file
            }
            finally
                out.close()
            file
        }

        def onlyFileName: String = _onlyFileName(file.getAbsolutePath)

        def merge(file: File): Unit = {
            <=|(Source.fromFile(file)(UTF8).getLines().foreach(_))
        }

        def checkDirectory: File = {
            if (!file.exists()) {
                logger warn s"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Directory: ${file.getAbsolutePath} not exist, will be createing. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
                val path: DefaultPath = com.simplesys.file.Path(file)
                //if (path.isDirectory)
                path.createDirectory()
            }
            file
        }
    }

    implicit class FileOpts(str: String) {
        def toFile: File = new File(str)

        def toURI: URI = new URI(str)

        def toTempFile: File = File.createTempFile("scala", ".xml");

        def toStreamSource: StreamSource = new StreamSource(new File(str))

        def asPath: Path = Path.fromString(str)

        def onlyFileName: String = _onlyFileName(str)
    }

    implicit class FileOpts1(path: Path) {
        def toFile: File = new File(path.toURI)

        def onlyFileName: String = _onlyFileName(path.path)

        def relativePath = {
            import com.simplesys.file.ImplicitConversions._
            path.relativize(new File("."))
        }
    }

    implicit class PathSetOpts(ps: PathSet[Path]) {

        def log = {
            ps foreach {
                path => logger debug path.path
            }
        }

        def files: Seq[File] = {
            val res = ArrayBuffer.empty[File]
            ps foreach (p => res += new File(p.path))
            res
        }
    }

}
