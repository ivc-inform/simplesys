package com.simplesys.xml

import com.simplesys.common.Strings.strEmpty
import com.simplesys.isc.dataBinging.DataSource
import io.circe.Json._
import io.circe.{Json, JsonObject}

import scala.xml.{MetaData, Node, NodeSeq}

object Xml {
    val fixedArrayNames = Seq("fields", "types", "valueMap")

    def xmlToJson(xml: Elem): JsonObject = {
        //println(xml.toPrettyString)
        def nameOf(node: Node) = (if (Option(node.prefix).nonEmpty) node.prefix + ":" else "") + node.label

        def buildJson(node: Node): Json = {
            def buildAttributes(node: Node) = {
                println((node: Elem).toPrettyString)
                var res = JsonObject.empty
                node.attributes.foreach {
                    (a: MetaData) =>
                        val value = a.value.text.trim
                        if (value != "") {
                            res = res add(a.key, fromString(value))
                            //println(fromJsonObject(res).spaces4)
                        }
                }
                res
            }

            def directChildren(node: Node): NodeSeq = node.child.filter(_.isInstanceOf[Elem])

            def isLeaf(node: Node) = !node.descendant.find(_.isInstanceOf[Elem]).isDefined

            def isArray(nodes: NodeSeq) = {
                val nodeNames = nodes.map(nameOf(_))
                nodeNames.size != 1 && nodeNames.distinct.size == 1
            }

            var res = JsonObject.empty
            val attributes: JsonObject = buildAttributes(node)

            attributes.toMap.foreach(item ⇒ res = res add(item._1, item._2))

            //res.log()

            val children = directChildren(node)
            children.foreach {
                child =>
                    val children = directChildren(child)
                    val childrenJson: Json = if (isArray(children) || fixedArrayNames.exists(_ == nameOf(child))) {
                        arr(children.map(buildJson): _*)
                    } else {
                        var res = JsonObject.empty
                        children.foreach(node => res = res add(nameOf(node), buildJson(node)))
                        fromJsonObject(res)
                    }
                    res = res add(nameOf(child), childrenJson)
                //res.log()
            }

            if (isLeaf(node) && node.text.trim != "") fromString(node.text) else fromJsonObject(res)
        }

        JsonObject.fromIterable(Seq(nameOf(xml) -> buildJson(xml)))
    }

    def getJS(xml: Elem, componentName: String, prettyString: Boolean): String = {
        val json = Xml.xmlToJson(xml)

        json.toMap.headOption match {
            case Some(item) if item._1 == "DataSource" =>
                item._2.asObject match {
                    case Some(item) =>
                        if (prettyString)
                            DataSource(item).toPrettyString
                        else
                            DataSource(item).toString
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
