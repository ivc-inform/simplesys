package com.simplesys.script

import com.simplesys.common._
import com.simplesys.xml.Elem
import com.simplesys.common.Strings._
import org.mozilla.javascript.{ScriptableObject, Context}


object HTMLBeautifier {

    val BEAUTIFY_HTML = "javascript/beautify-html.js"

    def apply(htmlCode: String, indent: Int = 4): String = {
        //htmlCode
        val cx = Context.enter()
        val scope = cx.initStandardObjects()

        class Global extends ScriptableObject {
            override def getClassName: String = "global"
        }

        URLBox.getResourceAsStreamReader(BEAUTIFY_HTML) match {
            case None =>
                throw new RuntimeException(s"Problem with ${BEAUTIFY_HTML}")
            case Some(stream) =>
                try {

                    scope.put("global", scope, new Global)
                    cx.evaluateReader(scope, stream, "__beautify-html.js", 1, null)
                    scope.put("jsCode", scope, htmlCode)
                    newLine + cx.evaluateString(scope, "global.html_beautify(jsCode, {indent_size:" + indent + "})", "inline", 1, null).asInstanceOf[String].newLine

                }
                finally {
                    stream.close()
                }
        }
    }


    def apply(inXml: Elem): String = apply(inXml.toUnEscapeString)
}
