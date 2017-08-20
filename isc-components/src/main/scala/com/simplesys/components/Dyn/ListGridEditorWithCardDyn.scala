package com.simplesys.components.Dyn

import com.simplesys.json.JsonObject
import com.simplesys.isc.layout.HLayoutDyn

object ListGridEditorWithCardDyn extends ListGridEditorWithCardDynInit {

  implicit def GridEditorWithCardDyn2JsonObject(in: ListGridEditorWithCardDyn): JsonObject = in json
}

trait ListGridEditorWithCardDyn extends HLayoutDyn with ListGridEditorWithCardDynInit {
  override val selfName = "ListGridEditorWithCard"
}