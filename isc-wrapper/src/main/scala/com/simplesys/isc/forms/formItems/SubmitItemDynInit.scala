package com.simplesys.isc.forms.formItems

import com.simplesys.isc.system.typesDyn.{frmitmtpSubmit, FormItemType}


trait SubmitItemDynInit extends ButtonItemDynInit {
  override protected val title: String = "Submit"
  override protected val __type: FormItemType = frmitmtpSubmit
}