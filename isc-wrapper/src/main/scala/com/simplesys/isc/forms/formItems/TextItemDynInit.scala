package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._

trait TextItemDynInit extends FormItemDynInit {
  protected val changeOnKeypress: Bool = true
  protected val characterCasing: CharacterCasing = chCsDefault
  protected val emptyStringValue: String = null
  protected val formatOnFocusChange: Bool = false
  override protected val height: Number = 19
  protected val keyPressFilter: String = ""
  protected val length: Number = null
  protected val mask: String = ""
  protected val maskOverwriteMode: Bool = false
  protected val maskPadChar: String = " "
  protected val maskPromptChar: String = "_"
  protected val maskSaveLiterals: Bool = false
  protected val printFullText: Bool = false
  override protected val saveOnEnter: Bool = true
  override protected val selectOnFocus: Bool = false
  protected val showHintInField: Bool = false
  override protected val textBoxStyle: FormItemBaseStyle = "textItem"
  override protected val width: Number = 150
}