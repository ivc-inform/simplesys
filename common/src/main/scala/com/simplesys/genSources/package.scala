package com.simplesys

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.util.Locale
import com.simplesys.common.Strings._

package object genSources {
    private val mess =
        s"""This file is generated automatically (at ${
            val fmt = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");
            new DateTime().toString(fmt.withLocale(Locale.ROOT))
        }), do not spend any changes here, because they will be lost."""

    private val mess1 =
        s"""This file is generated automatically (at ${
            val fmt = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");
            new DateTime().toString(fmt.withLocale(Locale.ROOT))
        })."""

    def genMessageCreating(generatorName: String): String = s"""// ${mess} Generator: ${generatorName.dblQuoted}"""
    def genMessageCreating: String = s"""// ${mess} Generator: unknown"""

    def genPropMessageCreating(generatorName: String): String = s"""# ${mess} Generator: ${generatorName.dblQuoted}"""
    def genPropMessageCreating: String = s"""# ${mess} Generator: unknown"""

    def genXMLMessageCreating(generatorName: String): String = s"""<!-- ${mess} Generator: ${generatorName.dblQuoted}-->"""
    def genXMLMessageCreating: String = s"""<!-- ${mess} Generator: unknown-->"""

    def genMessageCreating1(generatorName: String): String = s"""// ${mess1} Generator: ${generatorName.dblQuoted}"""
    def genMessageCreating1: String = s"""// ${mess1} Generator: unknown"""

    def genPropMessageCreating1(generatorName: String): String = s"""# ${mess1} Generator: ${generatorName.dblQuoted}"""
    def genPropMessageCreating1: String = s"""# ${mess1} Generator: unknown"""

    def genXMLMessageCreating1(generatorName: String): String = s"""<!-- ${mess1} Generator: ${generatorName.dblQuoted}-->"""
    def genXMLMessageCreating1: String = s"""<!-- ${mess1} Generator: unknown-->"""
}
