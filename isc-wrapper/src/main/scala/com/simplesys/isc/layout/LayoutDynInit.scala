package com.simplesys.isc.layout

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc.foundation.{CanvasDynInit, CanvasDyn}
import com.simplesys.json.JsonList

trait LayoutDynInit extends CanvasDynInit {
    protected val align: AlignmentDyn = AlNull
    protected val animateMembers: Bool = null
    protected val animateMemberTime: Number = null
    protected val canDropComponents: Bool = true
    protected val defaultLayoutAlign: AlignmentDyn = null
    protected val defaultResizeBars: LayoutResizeBarPolicy = lyRszBrPolMarked
    protected val drop: FunctionExpression = null
    protected val dropLine: AutoChild = null
    protected val dropLineThickness: Number = 2
    protected val enforcePolicy: Bool = true
    protected val hPolicy: LayoutPolicy = lyPlsFill
    protected val layoutBottomMargin: Number = null
    protected val layoutLeftMargin: Number = null
    protected val layoutMargin: Number = null
    protected val layoutRightMargin: Number = null
    protected val layoutTopMargin: Number = null
    protected val leaveScrollbarGap: Bool = false
    protected val locateMembersBy: LocatorStrategy = lcStrgNull
    protected val locateMembersType: LocatorTypeStrategy = lctTpStrgNull
    protected val managePercentBreadth: Bool = true
    protected val memberOverlap: Number = 0
    protected val members: JsonList = JsonList()
    protected val membersMargin: Number = 0
    protected val minMemberSize: Number = 1
    protected val orientation: Orientation = orntHorizontal
    override protected val overflow: Overflow = ovVisible
    protected val paddingAsLayoutMargin: Bool = true
    protected val placeHolderDefaults: CanvasDyn = null
    protected val placeHolderProperties: CanvasDyn = null
    protected val resizeBarClass: String = "Splitbar"
    protected val resizeBarSize: Number = 7
    protected val reverseOrder: Bool = false
    protected val showDragPlaceHolder: Bool = false
    protected val showDropLines: Bool = false
    protected val stackZIndex: String = ""
    protected val vertical: Bool = false
    protected val vPolicy: LayoutPolicy = lyPlsFill
}