package com.simplesys.isc.layout.sectionStack

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.{ArrayDyn, ClassDynInit}
import com.simplesys.isc.foundation.CanvasDyn

trait SectionStackSectionDynInit extends ClassDynInit {
  protected val canCollapse: Bool = true
  protected val canDropBefore: Bool = null
  protected val canReorder: Bool = null
  protected val canTabToHeader: Bool = null
  protected val expanded: Bool = false
  protected val hidden: Bool = false
  protected val items: ArrayDyn[CanvasDyn] = null
  protected val name: String = ""
  protected val resizeable: Bool = null
  protected val showHeader: Bool = true
  protected val title: String = ""
}