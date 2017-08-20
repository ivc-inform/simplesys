/*
 	type FormItemType

DynamicForms automatically choose the FormItem type for a field based on the type property of the field. The table below describes the default FormItem chosen for various values of the type property.

You can also set field.editorType to the classname of a FormItem to override this default mapping. You can alternatively override DynamicForm.getEditorType() to create a form with different rules for which FormItems are chosen.



Valid values:

"text"	Rendered as a TextItem, unless the length of the field (as specified by DataSourceField.length attribute) is larger than the value specified by DynamicForm.longTextEditorThreshold, a TextAreaItem is shown.
"boolean"	Rendered as a CheckboxItem
"integer"	Same as text by default. Consider setting editorType:SpinnerItem.
"float"	Same as text by default. Consider setting editorType:SpinnerItem.
"date"	Rendered as a DateItem
"time"	Rendered as a TimeItem
"enum"	Rendered as a SelectItem. Also true for any field that specifies a FormItem.valueMap. Consider setting editorType:ComboBoxItem.
"sequence"	Same as text
"link"	If DataSourceField.canEdit:false is set on the field, the value is rendered as a LinkItem. Otherwise the field is rendered as a TextItem.
"image"	Rendered as an image if not editable, or as a TextItem to edit the UnquotedString or partial UnquotedString if editable
"imageFile"	Rendered as a FileItem, or a ViewFileItem if not editable
"binary"	Rendered as a FileItem, or a ViewFileItem if not editable


See Also:
  FormItem.type
  FieldType
*/

package com.simplesys.isc.system.typesDyn

import ru.simplesys.coreutil.SealedEnumRuntime


sealed abstract trait FormItemType

case object frmitmtpText extends FormItemType {
  override def toString = "text"
}

case object frmitmtpBoolean extends FormItemType {
  override def toString = "boolean"
}

case object frmitmtpInteger extends FormItemType {
  override def toString = "integer"
}

case object frmitmtpFloat extends FormItemType {
  override def toString = "float"
}

case object frmitmtpDate extends FormItemType {
  override def toString = "date"
}

case object frmitmtpTime extends FormItemType {
  override def toString = "time"
}

case object frmitmtpEnum extends FormItemType {
  override def toString = "enum"
}

case object frmitmtpSequence extends FormItemType {
  override def toString = "sequence"
}

case object frmitmtpLink extends FormItemType {
  override def toString = "link"
}

case object frmitmtpImage extends FormItemType {
  override def toString = "image"
}

case object frmitmtpImageFile extends FormItemType {
  override def toString = "imageFile"
}

case object frmitmtpBinary extends FormItemType {
  override def toString = "binary"
}

case object frmitmtpStaticText extends FormItemType {
  override def toString = "StaticTextItem"
}

case object frmitmtpSubmit extends FormItemType {
  override def toString = "SubmitItem"
}

case object frmitmtpButton extends FormItemType {
  override def toString = "ButtonItem"
}

case object frmitmtpSelect extends FormItemType {
  override def toString = "select"
}

case object frmitmtpTextArea extends FormItemType {
  override def toString = "textArea"
}

case object frmitmtpBlurb extends FormItemType {
  override def toString = "BlurbItem"
}

case object frmitmtpPassword extends FormItemType {
  override def toString = "PasswordItem"
}

case object frmitmtpRadioGroup extends FormItemType {
  override def toString = "radioGroup"
}

case object frmitmtpHeader extends FormItemType {
  override def toString = "header"
}

case object frmitmtpCheckBox extends FormItemType {
  override def toString = "checkbox"
}

object FormItemType {
  private val values = SealedEnumRuntime.values[FormItemType]
  private val mappedKeys: Map[String, FormItemType] = values.map(x => (x.toString, x))(collection.breakOut)
  def getObject(objName: String): FormItemType = mappedKeys(objName)
}

