package com.simplesys.isc.tools

import io.Source
import com.simplesys.log.Logging
import java.io.{PrintWriter, File}
import com.simplesys.common._
import com.simplesys.control.ControlStructs._
import collection.mutable
import com.simplesys.common.Strings.newLine

object ChangePrivateVarDefValues {
  val AttrDeclare = """(\s*\/?\*?\s*private\s*var\s*)(\w+)(\:\s*)(\w+)(\s*=\s*)(\"?\,?\**\[?\$?\**[\w*\s*]*\.?\/?\w*\s*\]?\/?\w*\.*\-*\w*\-*\w*\-*\w*\**[\<?\w*\/?\>?]*\??\"*)""".r
}

class ChangePrivateVarDefValues(val fileNeme: String) extends Logging {
  val file = new File(fileNeme)
  URIBox.getResource(fileNeme) match {
    case URIBox(None, _) =>
    case URIBox(Some(path), _) =>

      val only_path = path.getPath.replace(fileNeme, "")

        logger trace (s"AbsolutePath: ${only_path}")

      val resBuf = mutable.Buffer.empty[String]

      import com.simplesys.isc.tools.ChangePrivateVarDefValues._

      using(new PrintWriter(new File(only_path + "resources_out.txt"))) {
        writer =>
          for (line <- Source.fromFile(path) getLines) {
            AttrDeclare findFirstIn line match {
              case None =>
                  //logger trace("Res: ${}", line)
                resBuf += line
              case Some(x) =>
                  //logger trace("Res: ${}", x)

                line match {
                  case AttrDeclare(pfx, name, colon, _type, eqv, value) =>
                    //to declare va with using trait`s declare
                    //private var _height: Number = height
                    val res = pfx + name + colon + _type + eqv + name.substring(1, name.length)
                      //logger trace("res1: ${}", res)
                    resBuf += res
                }
            }
          }

          resBuf foreach (writer write _ + newLine)
      }
  }

}