package com.simplesys.xml

import javax.script.{ScriptEngineManager, Invocable}
import com.simplesys.control.ControlStructs._
import com.simplesys.common._
import com.simplesys.common.Strings.newLine


object XMLBeautifiler {
  private val engine = (new ScriptEngineManager) getEngineByName ("JavaScript")

  URLBox.getResourceAsStreamReader("beautify-html.js") match {
    case None =>
    case Some(stream) =>
      using(stream) {
        engine.eval
      }
  }

  def apply(inStr: String): String = {
    if (engine.isInstanceOf[Invocable]) {
      val result = engine.asInstanceOf[Invocable].invokeFunction("style_html", inStr)
      newLine + result.toString + newLine
    }
    else
      ""
  }

  def apply(inXml: Elem): String = apply(inXml.toUnEscapeString)
}