package com.typesafe.config.impl

import com.simplesys.xml.Elem
import com.simplesys.xml.Elem._
import com.typesafe.config.ConfigFactory
import com.simplesys.common.URLBox

object Misc {
  val configEmpty = <bonecp-config-stack/>

  //Поддерево настроек возможных пуллов коннектов в HOCON - конфигурационном файле

  def configBoneCPStackFromHOCON(hosonConfigFileName: String, nameBCP: String): Elem = {
    val config = ConfigFactory load hosonConfigFileName
    var res = configEmpty
    val path = "bonecp-config-stack.bonecp-config-" + nameBCP

    URLBox.getResource(hosonConfigFileName) match {
      case URLBox(Some(url), message) =>
        if (config.hasPath(path)) {
          res = res.appendElement(<bonecp-config/>)

          import scala.collection.JavaConverters._
          config.getObject(path).asScala.foreach {
            // НЕОБХОДИМО СЛЕДИТЬ ЧТОБЫ В PROPERTY ТЕГАХ НЕ БЫЛО ПЕРЕНОСОВ СТРОК

            case (key, value) => value match {
              case v: ConfigString => res = res.appendElement("bonecp-config", <property>{key match {
                  case "poolName" => nameBCP
                  case _ => {
                    v.unwrapped
                  }
                }}</property>.setElementAttribute("name", key))
              case v: ConfigBoolean => res = res.appendElement("bonecp-config", <property>{v.unwrapped}</property>.setElementAttribute("name", key))
              case v: ConfigInt => res = res.appendElement("bonecp-config", <property>{v.unwrapped}</property>.setElementAttribute("name", key))
              case v: ConfigLong => res = res.appendElement("bonecp-config", <property>{v.unwrapped}</property>.setElementAttribute("name", key))
              case v: ConfigDouble => res = res.appendElement("bonecp-config", <property>{v.unwrapped}</property>.setElementAttribute("name", key))
              case v: ConfigNull => res = res.appendElement("bonecp-config", <property></property>.setElementAttribute("name", key))
              case _ =>
            }
          }
        }
        res

      case URLBox(None, message) => configEmpty
    }
  }
}
