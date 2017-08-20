package com.simplesys.isc.system

import com.simplesys.json.{JsonNull, JsonElement, UnquotedString}
import com.simplesys.isc.system.misc.FunctionExpression

trait ResultOfComponentInit extends ClassDynInit {
  private[system] val component: JsonElement = JsonNull
  private[system] val funcMenu: JsonElement = JsonNull
  private[system] val selectRecord: FunctionExpression = null
  private[system] val selectedRecord: FunctionExpression = null
  private[system] val setChangeSelection: FunctionExpression = null
  private[system] val getSelection: FunctionExpression = null
  private[system] val fullRefresh: FunctionExpression = null
  private[system] val cancelEditing: FunctionExpression = null
  private[system] val selectSingleRecordByKey: FunctionExpression = null
  private[system] val fetchData: FunctionExpression = null
  private[system] val getCriteria: FunctionExpression = null
}