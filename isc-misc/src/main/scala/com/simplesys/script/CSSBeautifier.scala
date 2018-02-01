package com.simplesys.script

import com.simplesys.common._
import com.simplesys.common.Strings._
import org.mozilla.javascript.{ScriptableObject, Context}

object CSSBeautifier {

    val BEAUTIFY_CSS = "javascript/beautify-css.js"

    def apply(cssCode: String, indent: Int = 4): String = {
        //cssCode
        val cx = Context.enter()
        val scope = cx.initStandardObjects()

        class Global extends ScriptableObject {
            override def getClassName: String = "global"
        }

        URLBox.getResourceAsStreamReader(BEAUTIFY_CSS) match {
            case None =>
                throw new RuntimeException(s"Problem with ${BEAUTIFY_CSS}")
            case Some(stream) =>
                try {

                    scope.put("global", scope, new Global)
                    cx.evaluateReader(scope, stream, "__beautify-css.js", 1, null)
                    scope.put("jsCode", scope, cssCode)
                    newLine + cx.evaluateString(scope, "global.css_beautify(jsCode, {indent_size:" + indent + "})", "inline", 1, null).asInstanceOf[String].newLine

                }
                finally {
                    stream.close()
                }
        }
    }
}

