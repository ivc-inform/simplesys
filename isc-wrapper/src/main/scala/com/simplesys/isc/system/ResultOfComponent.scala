package com.simplesys.isc.system

import com.simplesys.json.{JsonElement, JsonObject, UnquotedString}
import com.simplesys.isc.system.misc.FunctionExpression
import com.simplesys.script.JsBeautifier

class ResultOfComponent extends ClassDyn with ResultOfComponentInit {
  def Component = json.getJsonElement("component").getOrElse(component)
  def Component_=(value: JsonElement) {
    if (Component == value) return

    value match {
      case jsonObject: JsonObject =>
        if (jsonObject.getBooleanOpt("enqueued").getOrElse(false))
          json("component") = jsonObject.getJsonElement("identifier").getOrElse(identifier)
        else
          json("component") = jsonObject
      case _ =>
        json("component") = value
    }
  }

  def FuncMenu = json.getJsonElement("funcMenu").getOrElse(funcMenu)
  def FuncMenu_=(value: JsonElement) {
    if (FuncMenu == value) return

    value match {
      case jsonObject: JsonObject =>
        if (jsonObject.getBooleanOpt("enqueued").getOrElse(false))
          json("funcMenu") = jsonObject.getJsonElement("identifier").getOrElse(identifier)
        else
          json("funcMenu") = jsonObject
      case _ =>
        json("funcMenu") = value
    }
  }

  def SelectRecord = json.getFunctionExpressionOpt("selectRecord").getOrElse(selectRecord)
  def SelectRecord_=(value: FunctionExpression) {
    if (SelectRecord == value) return
    json("selectRecord") = value
  }

  def SelectedRecord = json.getFunctionExpressionOpt("selectedRecord").getOrElse(selectedRecord)
  def SelectedRecord_=(value: FunctionExpression) {
    if (SelectedRecord == value) return
    json("selectedRecord") = value
  }

  def SetChangeSelection = json.getFunctionExpressionOpt("setChangeSelection").getOrElse(setChangeSelection)
  def SetChangeSelection_=(value: FunctionExpression) {
    if (SetChangeSelection == value) return
    json("setChangeSelection") = value
  }

  def GetSelection = json.getFunctionExpressionOpt("getSelection").getOrElse(getSelection)
  def GetSelection_=(value: FunctionExpression) {
    if (GetSelection == value) return
    json("getSelection") = value
  }

  def FullRefresh = json.getFunctionExpressionOpt("fullRefresh").getOrElse(fullRefresh)
  def FullRefresh_=(value: FunctionExpression) {
    if (FullRefresh == value) return
    json("fullRefresh") = value
  }

  def CancelEditing = json.getFunctionExpressionOpt("cancelEditing").getOrElse(cancelEditing)
  def CancelEditing_=(value: FunctionExpression) {
    if (CancelEditing == value) return
    json("cancelEditing") = value
  }

  def SelectSingleRecordByKey = json.getFunctionExpressionOpt("selectSingleRecord").getOrElse(selectSingleRecordByKey)
  def SelectSingleRecordByKey_=(value: FunctionExpression) {
    if (SelectSingleRecordByKey == value) return
    json("selectSingleRecordByKey") = value
  }

  def FetchData = json.getFunctionExpressionOpt("fetchData").getOrElse(fetchData)
  def FetchData_=(value: FunctionExpression) {
    if (FetchData == value) return
    json("fetchData") = value
  }

  def GetCriteria = json.getFunctionExpressionOpt("getCriteria").getOrElse(getCriteria)
  def GetCriteria_=(value: FunctionExpression) {
    if (GetCriteria == value) return
    json("getCriteria") = value
  }
}