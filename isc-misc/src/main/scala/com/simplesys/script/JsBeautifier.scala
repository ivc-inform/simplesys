package com.simplesys.script

import com.simplesys.common.URLBox
import com.simplesys.common.Strings._
import org.mozilla.javascript.{ScriptableObject, Context}


object JsBeautifier {

    val BEAUTIFY_JS = "javascript/beautify.js"

    def apply(jsCode: String, indent: Int = 4): String = {
        //jsCode
        val cx = Context.enter()
        val scope = cx.initStandardObjects()

        class Acorn extends ScriptableObject {
            override def getClassName: String = "acorn"
        }

        class Global extends ScriptableObject {
            override def getClassName: String = "global"
        }

        URLBox.getResourceAsStreamReader(BEAUTIFY_JS) match {
            case None =>
                throw new RuntimeException(s"Problem with ${BEAUTIFY_JS}")
            case Some(stream) =>
                try {

                    scope.put("acorn", scope, new Acorn)
                    scope.put("global", scope, new Global)
                    cx.evaluateReader(scope, stream, "__beautify.js", 1, null)
                    scope.put("jsCode", scope, jsCode)
                    newLine + cx.evaluateString(scope, "global.js_beautify(jsCode, {indent_size:" + indent + "})", "inline", 1, null).asInstanceOf[String].newLine

                }
                finally {
                    stream.close()
                }
        }
    }

    //def apply(inStr: String): String = inStr

    //def apply(inXml: Elem): String = apply(inXml.toString())


}

