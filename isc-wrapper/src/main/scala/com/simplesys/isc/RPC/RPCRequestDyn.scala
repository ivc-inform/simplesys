package com.simplesys.isc.dataBinging.RPC

import com.simplesys.isc.dataBinging.dataSource.{CriterionDyn, AdvancedCriteriaDyn}
import com.simplesys.isc.system.ClassDyn
import com.simplesys.isc.system.misc.{Bool, Number}
import com.simplesys.isc.system.typesDyn._
import com.simplesys.json.{JsonString, UnquotedString, _}
import com.simplesys.servlet.http.HttpServletRequest
import org.joda.time.DateTime

import scala.collection.mutable.ArrayBuffer

object RPCRequestDyn {
    implicit def RPCRequest1toJsonObject(in: RPCRequestDyn): JsonObject = in json
    implicit class Impl(val in: HttpServletRequest) {
        def toDyn = new RPCRequestDyn(in)
    }
}

class RPCRequestDyn(override val inJson: JsonObject = null,
                    useSelfName: Boolean = false) extends ClassDyn with RPCRequestDynInit {

    class _AdvancedCriteria {
        private def advancedCriteria: Option[AdvancedCriteriaDyn] =
            json.getJsonObjectOpt("data") match {
                case None => None
                case Some(data) =>
                    val advancedCriteria = new AdvancedCriteriaDyn(data)

                    advancedCriteria.ConstructorOpt match {
                        case None => None
                        case _ => Some(advancedCriteria)
                    }
            }

        private def getCriterionOpt(advancedCriteria: Option[AdvancedCriteriaDyn], key: String): Option[CriterionDyn] = {
            advancedCriteria match {
                case None => None
                case Some(advancedCriteria) =>
                    val res = advancedCriteria.Criteria.filter {
                        case item => (new CriterionDyn(item.asInstanceOf[JsonObject])).FieldName == key
                    }
                    if (res.length == 0)
                        None
                    else
                        Some((new CriterionDyn(res(0).asInstanceOf[JsonObject])))
            }
        }

        private def getCriterionListOpt(advancedCriteria: Option[AdvancedCriteriaDyn], key: String): Option[List[CriterionDyn]] = {
            advancedCriteria match {
                case None => None
                case Some(advancedCriteria) =>
                    val res = advancedCriteria.Criteria.filter {
                        case item => (new CriterionDyn(item.asInstanceOf[JsonObject])).FieldName == key
                    }
                    Some(res.map(item => new CriterionDyn(item.asInstanceOf[JsonObject])).toList)
            }
        }

        def CriterionList(key: String): Option[List[CriterionDyn]] = getCriterionListOpt(advancedCriteria, key)

        private def getCriterion(advancedCriteria: Option[AdvancedCriteriaDyn], key: String): CriterionDyn = {
            getCriterionOpt(advancedCriteria, key) match {
                case None => new CriterionDyn(JsonObject())
                case Some(advancedCriteria) => advancedCriteria
            }
        }

        def getString(key: String): String = {
            advancedCriteria match {
                case None => Data getString key
                case advancedCriteria => getCriterion(advancedCriteria, key) getString "value"
            }
        }

        def getStringOpt(key: String): Option[String] = {
            advancedCriteria match {
                case None => Data getStringOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getStringOpt "value"
                    }
            }
        }

        def getBoolean(key: String): Boolean = {
            advancedCriteria match {
                case None => Data getBoolean key
                case advancedCriteria => getCriterion(advancedCriteria, key) getBoolean "value"
            }
        }

        def getBooleanOpt(key: String): Option[Boolean] = {
            advancedCriteria match {
                case None => Data getBooleanOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getBooleanOpt "value"
                    }
            }
        }

        def getDateTime(key: String): DateTime = {
            advancedCriteria match {
                case None => Data getDateTime key
                case advancedCriteria => getCriterion(advancedCriteria, key) getDateTime "value"
            }
        }

        def getDateTimeOpt(key: String): Option[DateTime] = {
            advancedCriteria match {
                case None => Data getDateTimeOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getDateTimeOpt "value"
                    }
            }
        }

        def getLong(key: String): Long = {
            advancedCriteria match {
                case None => Data getLong key
                case advancedCriteria => getCriterion(advancedCriteria, key) getLong "value"
            }
        }

        def getLongOpt(key: String): Option[Long] = {
            advancedCriteria match {
                case None => Data getLongOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getLongOpt "value"
                    }
            }
        }

        def getDouble(key: String): Double = {
            advancedCriteria match {
                case None => Data getDouble key
                case advancedCriteria => getCriterion(advancedCriteria, key) getDouble "value"
            }
        }

        def getDoubleOpt(key: String): Option[Double] = {
            advancedCriteria match {
                case None => Data getDoubleOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getDoubleOpt "value"
                    }
            }
        }

        def getJsonObject(key: String): JsonObject = {
            advancedCriteria match {
                case None => Data getJsonObject key
                case advancedCriteria => getCriterion(advancedCriteria, key)
            }
        }

        def getJsonList(key: String): JsonList = {
            advancedCriteria match {
                case None => Data getJsonList key
                case advancedCriteria => JsonList(getCriterion(advancedCriteria, key))
            }
        }

        def getJsonObjectOpt(key: String): Option[JsonObject] = {
            advancedCriteria match {
                case None => Data getJsonObjectOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getJsonObjectOpt "value"
                    }
            }
        }

        def getJsonListOpt(key: String): Option[JsonList] = {
            advancedCriteria match {
                case None => Data getJsonListOpt key
                case advancedCriteria =>
                    getCriterionOpt(advancedCriteria, key) match {
                        case None => None
                        case Some(criterion) => criterion getJsonListOpt "value"
                    }
            }
        }
    }

    override val selfName = "RPCRequest"

    def this(request: HttpServletRequest) = this(request.JSONData)

    def ActionURL = json.getStringOpt("ActionURL").getOrElse(actionURL)
    def ActionURL_=(value: UnquotedString) {
        if (ActionURL == value) return
        json("actionURL") = value
    }

    def AdvancedCriteria: _AdvancedCriteria = new _AdvancedCriteria

    def BypassCache = json.getBoolOpt("bypassCache").getOrElse(bypassCache)
    def BypassCache_=(value: Bool) {
        if (BypassCache == value) return
        json("bypassCache") = value
    }

    def Callback = json.getValue2[JsonString, RPCCallback]("callback").getOrElse(callback)
    def Callback_=(value: RPCCallback) {
        if (Callback == value) return
        json("callback") = value
    }

    def CallbackParam = json.getStringOpt("callbackParam").getOrElse(callbackParam)
    def CallbackParam_=(value: String) {
        if (CallbackParam == value) return
        json("callbackParam") = value
    }

    def Channels = json.getJsonListOpt("channels").getOrElse(channels)
    def Channels_=(value: JsonList) {
        if (Channels == value) return
        json("channels") = value
    }

    def ClientContext = json.getJsonElement("clientContext").getOrElse(clientContext)
    def ClientContext_=(value: JsonElement) {
        if (ClientContext == value) return
        json("clientContext") = value
    }

    def ContainsCredentials = json.getBoolOpt("containsCredentials").getOrElse(containsCredentials)
    def ContainsCredentials_=(value: Bool) {
        if (ContainsCredentials == value) return
        json("containsCredentials") = value
    }


    def ContentType = json.getStringOpt("contentType").getOrElse(contentType)
    def ContentType_=(value: String) {
        if (ContentType == value) return
        json("contentType") = value
    }

    private[this] var _data: JsonObject = data
    def Data = json.getJsonObjectOpt("data").getOrElse(data)
    def Data_=(value: JsonObject) {
        if (value == _data) return
        json("data") = value
    }

    def DataList = json.getJsonListOpt("data")
    def DataList_=(value: JsonList) {
        if (DataList.getOrElse(JsonList()) == value) return
        json("data") = value
    }

    private[this] var _dataSerriallized: JsonObject = dataSerriallized
    def DataSerriallized = json.getSerializedJsonObjectOpt("data").getOrElse(dataSerriallized)
    def DataSerriallized_=(value: JsonObject) {
        if (value == _data) return
        json("data") = value
    }

    def DataSources = json.getJsonListOpt("dataSources").getOrElse(dataSources)
    def DataSources_=(value: JsonList) {
        if (DataSources == value) return
        json("dataSources") = value
    }

    def DownloadResult = json.getBoolOpt("downloadResult").getOrElse(downloadResult)
    def DownloadResult_=(value: Bool) {
        if (DownloadResult == value) return
        json("downloadResult") = value
    }


    def DownloadToNewWindow = json.getBoolOpt("downloadToNewWindow").getOrElse(downloadToNewWindow)
    def DownloadToNewWindow_=(value: Bool) {
        if (DownloadToNewWindow == value) return
        json("downloadToNewWindow") = value
    }


    def EvalResult = json.getBoolOpt("evalResult").getOrElse(evalResult)
    def EvalResult_=(value: Bool) {
        if (EvalResult == value) return
        json("evalResult") = value
    }

    def EvalVars = json.getJsonListOpt("evalVars").getOrElse(evalVars)
    def EvalVars_=(value: JsonList) {
        if (EvalVars == value) return
        json("evalVars") = value
    }

    def HttpHeaders = json.getJsonListOpt("httpHeaders").getOrElse(httpHeaders)
    def HttpHeaders_=(value: JsonList) {
        if (HttpHeaders == value) return
        json("httpHeaders") = value
    }

    def HttpMethod = json.getStringOpt("httpMethod").getOrElse(httpMethod)
    def HttpMethod_=(value: String) {
        if (HttpMethod == value) return
        json("httpMethod") = value
    }

    def IgnoreTimeout = json.getBoolOpt("ignoreTimeout").getOrElse(ignoreTimeout)
    def IgnoreTimeout_=(value: Bool) {
        if (IgnoreTimeout == value) return
        json("ignoreTimeout") = value
    }


    def OmitNullMapValuesInResponse = json.getBoolOpt("omitNullMapValuesInResponse").getOrElse(omitNullMapValuesInResponse)
    def OmitNullMapValuesInResponse_=(value: Bool) {
        if (OmitNullMapValuesInResponse == value) return
        json("omitNullMapValuesInResponse") = value
    }

    def Params = json.getJsonObjectOpt("params").getOrElse(params)
    def Params_=(value: JsonObject) {
        if (Params == value) return
        json("params") = value
    }

    def ParamsOnly = json.getBoolOpt("paramsOnly").getOrElse(paramsOnly)
    def ParamsOnly_=(value: Bool) {
        if (ParamsOnly == value) return
        json("paramsOnly") = value
    }

    def Prompt = json.getStringOpt("prompt").getOrElse(prompt)
    def Prompt_=(value: String) {
        if (Prompt == value) return
        json("prompt") = value
    }

    def PromptCursor = json.getStringOpt("promptCursor").getOrElse(promptCursor)
    def PromptCursor_=(value: String) {
        if (PromptCursor == value) return
        json("promptCursor") = value
    }

    def PromptStyle = json.getValue2[JsonString, PromptStyle]("promptStyle").getOrElse(promptStyle)
    def PromptStyle_=(value: PromptStyle) {
        if (PromptStyle == value) return
        json("promptStyle") = value
    }

    def SendNoQueue = json.getBoolOpt("sendNoQueue").getOrElse(sendNoQueue)
    def SendNoQueue_=(value: Bool) {
        if (SendNoQueue == value) return
        json("sendNoQueue") = value
    }

    def ServerOutputAsString = json.getBoolOpt("serverOutputAsString").getOrElse(serverOutputAsString)

    def ServerOutputAsString_=(value: Bool) {
        if (ServerOutputAsString == value) return
        json("serverOutputAsString") = value
    }

    def ShowPrompt = json.getBoolOpt("showPrompt").getOrElse(showPrompt)
    def ShowPrompt_=(value: Bool) {
        if (showPrompt == value) return
        json("showPrompt") = value
    }

    def Timeout = json.getNumberOpt("timeout").getOrElse(timeout)
    def Timeout_=(value: Number) {
        if (Timeout == value) return
        json("timeout") = value
    }

    def Transport = json.getValue2[JsonString, RPCTransport]("transport").getOrElse(transport)
    def Transport_=(value: RPCTransport) {
        if (Transport == value) return
        json("transport") = value
    }

    def UseSimpleHttp = json.getBoolOpt("useSimpleHttp").getOrElse(useSimpleHttp)
    def UseSimpleHttp_=(value: Bool) {
        if (UseSimpleHttp == value) return
        json("useSimpleHttp") = value
    }

    def UseXmlHttpRequest = json.getBoolOpt("useXmlHttpRequest").getOrElse(useXmlHttpRequest)
    def UseXmlHttpRequest_=(value: Bool) {
        if (UseXmlHttpRequest == value) return
        json("useXmlHttpRequest") = value
    }

    def WillHandleError = json.getBoolOpt("willHandleError").getOrElse(willHandleError)
    def WillHandleError_=(value: Bool) {
        if (WillHandleError == value) return
        json("willHandleError") = value
    }
}

