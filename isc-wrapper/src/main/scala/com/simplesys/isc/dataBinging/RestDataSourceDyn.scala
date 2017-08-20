package com.simplesys.isc.dataBinging

import com.simplesys.SQL.Gen.SQLTable
import com.simplesys.json.{JsonURL, JsonString, JsonObject}
import com.simplesys.isc.system.misc._
import com.simplesys.isc._

object RestDataSourceDyn {
    implicit def RestDataSourcetoJsonObject(in: RestDataSourceDyn): JsonObject = in json

    implicit def JSonObjToRestDataSource(jsonObject: JsonObject): RestDataSourceDyn = new RestDataSourceDyn(inJson = jsonObject, useSelfName = true)

    /*implicit def JSonElementToRestDataSourceDyn(jsonElement: JsonElement): RestDataSourceDyn = {
      jsonElement match {
        case jsonObject: JsonObject => new RestDataSourceDyn(jsonObject)
        case _ => ???
      }
    }*/
}

class RestDataSourceDyn(override val inJson: JsonObject = null,
                        override val useSelfName: Boolean = false) extends DataSourceDyn with RestDataSourceDynInit {
    override val selfName = "RestDataSource"

    def FetchDataURL = json.getValue2[JsonURL, URL]("fetchDataURL").getOrElse(fetchDataURL)
    def FetchDataURL_=(value: URL) {
        if (FetchDataURL == value) return
        json("fetchDataURL") = value
    }

    def AddDataURL = json.getValue2[JsonURL, URL]("addDataURL").getOrElse(addDataURL)
    def AddDataURL_=(value: URL) {
        if (AddDataURL == value) return
        json("addDataURL") = value
    }

    def UpdateDataURL = json.getValue2[JsonURL, URL]("updateDataURL").getOrElse(updateDataURL)
    def UpdateDataURL_=(value: URL) {
        if (UpdateDataURL == value) return
        json("updateDataURL") = value
    }

    def RemoveDataURL = json.getValue2[JsonURL, URL]("removeDataURL").getOrElse(removeDataURL)
    def RemoveDataURL_=(value: URL) {
        if (RemoveDataURL == value) return
        json("removeDataURL") = value
    }

    private[this] var _disableQueuing: Bool = disableQueuing
    def DisableQueuing = _disableQueuing
    def DisableQueuing_=(value: Bool) {
        if (_disableQueuing == value) return
        json("disableQueuing") = value
        _disableQueuing = value
    }

    private[this] var _jsonRecordXPath: XPathExpression = jsonRecordXPath
    def JsonRecordXPath = _jsonRecordXPath
    def JsonRecordXPath_=(value: XPathExpression) {
        if (_jsonRecordXPath == value) return
        json("jsonRecordXPath") = value
        _jsonRecordXPath = value
    }

    private[this] var _metaDataPrefix: String = metaDataPrefix
    def MetaDataPrefix = _metaDataPrefix
    def MetaDataPrefix_=(value: String) {
        if (_metaDataPrefix == value) return
        json("metaDataPrefix") = value
        _metaDataPrefix = value
    }

    private[this] var _prettyPrintJSON: Bool = prettyPrintJSON
    def PrettyPrintJSON = _prettyPrintJSON
    def PrettyPrintJSON_=(value: Bool) {
        if (_prettyPrintJSON == value) return
        json("prettyPrintJSON") = value
        _prettyPrintJSON = value
    }

    private[this] var _sendMetaData: Bool = sendMetaData
    def SendMetaData = _sendMetaData
    def SendMetaData_=(value: Bool) {
        if (_sendMetaData == value) return
        json("sendMetaData") = value
        _sendMetaData = value
    }

    private[this] var _xmlRecordXPath: XPathExpression = xmlRecordXPath
    def XmlRecordXPath = _xmlRecordXPath
    def XmlRecordXPath_=(value: XPathExpression) {
        if (_xmlRecordXPath == value) return
        json("xmlRecordXPath") = value
        _xmlRecordXPath = value
    }

}

