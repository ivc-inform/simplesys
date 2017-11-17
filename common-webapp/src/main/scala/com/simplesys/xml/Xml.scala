package com.simplesys.xml

import com.simplesys.common.Strings._
import io.circe.{Json, JsonObject}
import io.circe.Json._

import scala.xml.{MetaData, Node, NodeSeq}

object Xml {
    val fixedArrayNames = Seq("fields", "types", "valueMap")

    def xmlToJson(xml: Elem): Json = {
        //println(xml.toPrettyString)
        def nameOf(node: Node) = (if (Option(node.prefix).nonEmpty) node.prefix + ":" else "") + node.label

        def buildJson(node: Node): Json = {
            def buildAttributes(node: Node): Json = {
                fromFields(node.attributes.map {
                    (a: MetaData) =>
                        val value = a.value.text.trim
                        if (value != "")
                            Some(a.key -> fromString(value))
                        else
                            None
                }.filter(_.isDefined).map(_.get))
            }

            def directChildren(node: Node): NodeSeq = node.child.filter(_.isInstanceOf[Elem])

            def isLeaf(node: Node) = !node.descendant.find(_.isInstanceOf[Elem]).isDefined

            def isArray(nodes: NodeSeq) = {
                val nodeNames = nodes.map(nameOf(_))
                nodeNames.size != 1 && nodeNames.distinct.size == 1
            }

            val res = JsonObject.empty
            val attributes = buildAttributes(node)
            res ++= attributes

            //res.log()

            val children = directChildren(node)
            children.foreach {
                child =>
                    val children = directChildren(child)
                    val childrenJson = if (isArray(children) || fixedArrayNames.exists(_ == nameOf(child))) {
                        val res = JsonList()
                        children.foreach {
                            node =>
                                res += buildJson(node)
                            //res.log
                        }
                        res
                    } else {
                        val res = JsonObject()
                        children.foreach {
                            node =>
                                res += nameOf(node) -> buildJson(node)
                            //res.log()
                        }
                        res
                    }
                    res += (nameOf(child) -> childrenJson)
                //res.log()
            }

            if (isLeaf(node) && node.text.trim != "") node.text.toJson else res
        }

        JsonObject(nameOf(xml) -> buildJson(xml))
    }

    def getJS(xml: Elem, componentName: String, prettyString: Boolean): String = {
        val json = Xml.xmlToJson(xml)

        ModeNames = PortalMode

        json.headOption match {
            case Some(item) if item._1 == "DataSource" =>
                item._2 match {
                    case item: JsonObject =>
                        if (prettyString)
                            (new DataSourceDyn(item, true)).toPrettyString
                        else
                            (new DataSourceDyn(item, true)).toString()
                    case x =>
                        throw new RuntimeException(s"Bad branch $x on component: $componentName")
                }

            case Some(item) if item._1 == "Object" =>
                strEmpty
            case x =>
                throw new RuntimeException(s"Bad branch $x on component: $componentName")
        }
    }
}
