package com.simplesys.isc.tools

import java.io.{File, PrintWriter}

import com.simplesys.common.Strings.newLine
import com.simplesys.common._
import com.simplesys.control.ControlStructs._
import com.simplesys.log.Logging

import scala.collection.mutable
import scala.io.Source

object ChangeAttributes {
  val AttrDeclare = """(\s*)(\w+\_*)(\s*\:\s*)(\w+)(\s*=\s*)(\"?\[?\$?\**[\w*\s*]*\.*\/?\w*\]?\/*\w*\.*\-*\w*\-*\w*\-*\w*\"?[\<?\w*\/?\>?]*\??)(\s*\,?)(.*)""".r
}

//Берем список аргументов для метода apply и превращаем в трейт инициализационных значений
//Также присваиваем эти значения аргументам метода apply
//Также получаем список инициализации полей класса аргументами метода apply

class ChangeAttributes(val fileNeme: String) extends Logging {
  val file = new File(fileNeme)
  URIBox.getResource(fileNeme) match {
    case URIBox(None, _) =>
    case URIBox(Some(path), _) =>

      val only_path = path.getPath.replace(fileNeme, "")

        logger trace (s"AbsolutePath: ${only_path}")

      val traitBuf = mutable.Buffer.empty[String]
      val attrsBuf = mutable.Buffer.empty[String]
      val assignBuf = mutable.Buffer.empty[String]

      import ChangeAttributes._

      using(new PrintWriter(new File(only_path + "resources_out.txt"))) {
        writer =>
          for (line <- Source.fromFile(path) getLines) {
            line match {
              case AttrDeclare(pfx, name, colon, _type, eqv, value, comm, any) =>
                traitBuf += "protected val " + name + colon + _type + eqv + value
                attrsBuf += name + colon + _type + eqv + name + comm + any
                assignBuf += "res." + name.capitalize + eqv + name + any
            }
          }

          writer write "trait ??Init extends ??Init {" + newLine
          traitBuf foreach (writer write _ + newLine)
          writer write "}" + newLine + newLine

          writer write "(" + newLine
          attrsBuf foreach (writer write _ + newLine)
          writer write ")" + newLine + newLine

          assignBuf foreach (writer write _ + newLine)

      }
  }
}

