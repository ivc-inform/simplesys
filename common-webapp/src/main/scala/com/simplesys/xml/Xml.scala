package com.simplesys.xml

import io.circe.Json._
import io.circe.{Json, JsonObject}

import scala.xml.{MetaData, Node, NodeSeq}

object Xml {

    val fixedArrayNames = Seq("fields", "types", "valueMap")

    def xmlToJson(xml: Elem): JsonObject = {
        //println(xml.toPrettyString)
        def nameOf(node: Node): String = (if (Option(node.prefix).nonEmpty) node.prefix + ":" else "") + node.label

        //implicit def jsobj2json1(jsonobg: (String, JsonObject)): (String, Json) = jsonobg._1 → fromJsonObject(jsonobg._2)

        def buildJson(node: Node): Json = {
            def buildAttributes(node: Node): JsonObject = {
                val res = JsonObject.empty
                node.attributes.foreach {
                    (a: MetaData) =>
                        val value = a.value.text.trim
                        if (value != "")
                            res add(a.key, fromString(value))
                }
                res
            }

            def directChildren(node: Node): NodeSeq = node.child.filter(_.isInstanceOf[Elem])

            def isLeaf(node: Node): Boolean = !node.descendant.find(_.isInstanceOf[Elem]).isDefined

            def isArray(nodes: NodeSeq): Boolean = {
                val nodeNames = nodes.map(nameOf(_))
                nodeNames.size != 1 && nodeNames.distinct.size == 1
            }

            val res = JsonObject.empty
            val attributes = buildAttributes(node)
            attributes.toVector.foreach(item ⇒ res add(item._1, item._2))

            //res.log()

            val children = directChildren(node)
            children.foreach {
                child =>
                    val children = directChildren(child)
                    val childrenJson = if (isArray(children) || fixedArrayNames.exists(_ == nameOf(child))) {
                        val res = JsonObject.empty
                        children.foreach {
                            node =>
                                buildJson(node).asArray match {
                                    case Some(array) ⇒
                                        array.foreach{
                                            item ⇒
                                                item.asObject match {
                                                    case Some(obj) ⇒
                                                        obj.toMap.foreach(item ⇒ res add(item._1, item._2))
                                                    case None ⇒
                                                }
                                        }
                                    case None ⇒
                                }
                            //res.log
                        }
                        res
                    } else {
                        val res = JsonObject.empty
                        children.foreach {
                            node =>
                                res add(nameOf(node), buildJson(node))
                            //res.log()
                        }
                        res
                    }
                    res add(nameOf(child), fromJsonObject(childrenJson))
                //res.log()
            }

            if (isLeaf(node) && node.text.trim != "") fromString(node.text) else fromJsonObject(res)
        }

        JsonObject.singleton(nameOf(xml), buildJson(xml))
    }

    def getJS(xml: Elem, componentName: String, prettyString: Boolean): JsonObject = {
        val json = Xml.xmlToJson(xml)
        
        json.toMap.headOption match {
            case Some(item) if item._1 == "DataSource" =>
                item._2.asObject match {
                    case Some(item) =>
                        item
                    case x =>
                        throw new RuntimeException(s"Bad branch $x on component: $componentName")
                }

            case Some(item) if item._1 == "Object" =>
                JsonObject.empty
            case x =>
                throw new RuntimeException(s"Bad branch $x on component: $componentName")
        }
    }
}
