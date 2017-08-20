package com.simplesys.isc.layout

import com.simplesys.json.{JsonString, JsonList, JsonObject}
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.isc._

object LayoutDyn {

    implicit def LayouttoJsonObject(in: LayoutDyn): JsonObject = in json
}

class LayoutDyn extends CanvasDyn with LayoutDynInit {
    override val selfName = "Layout"

    def Align = json.getValue2[JsonString, AlignmentDyn]("align").getOrElse(align)
    def Align_=(value: AlignmentDyn) {
        if (Align == value) return
        json("align") = value
    }

    private[this] var _animateMembers: Bool = animateMembers
    def AnimateMembers = _animateMembers
    def AnimateMembers_=(value: Bool) {
        if (_animateMembers == value) return
        json("animateMembers") = value
        _animateMembers = value
    }

    private[this] var _animateMemberTime: Number = animateMemberTime
    def AnimateMemberTime = _animateMemberTime
    def AnimateMemberTime_=(value: Number) {
        if (_animateMemberTime == value) return
        json("animateMemberTime") = value
        _animateMemberTime = value
    }

    private[this] var _canDropComponents: Bool = canDropComponents
    def CanDropComponents = _canDropComponents
    def CanDropComponents_=(value: Bool) {
        if (_canDropComponents == value) return
        json("canDropComponents") = value
        _canDropComponents = value
    }

    private[this] var _defaultLayoutAlign: AlignmentDyn = defaultLayoutAlign
    def DefaultLayoutAlign = _defaultLayoutAlign
    def DefaultLayoutAlign_=(value: AlignmentDyn) {
        if (_defaultLayoutAlign == value) return
        json("defaultLayoutAlign") = value
    }

    private[this] var _defaultResizeBars: LayoutResizeBarPolicy = defaultResizeBars
    def DefaultResizeBars = _defaultResizeBars
    def DefaultResizeBars_=(value: LayoutResizeBarPolicy) {
        if (_defaultResizeBars == value) return
        json("defaultResizeBars") = value
        _defaultResizeBars = value
    }

    private[this] var _drop: FunctionExpression = drop
    def Drop = _drop
    def Drop_=(value: FunctionExpression) {
        if (_drop == value) return
        json("drop") = value
        _drop = value
    }

    private[this] var _dropLine: AutoChild = dropLine
    def DropLine = _dropLine
    def DropLine_=(value: AutoChild) {
        if (_dropLine == value) return
        json("dropLine") = value
        _dropLine = value
    }

    private[this] var _dropLineThickness: Number = dropLineThickness
    def DropLineThickness = _dropLineThickness
    def DropLineThickness_=(value: Number) {
        if (_dropLineThickness == value) return
        json("dropLineThickness") = value
        _dropLineThickness = value
    }

    private[this] var _enforcePolicy: Bool = enforcePolicy
    def EnforcePolicy = _enforcePolicy
    def EnforcePolicy_=(value: Bool) {
        if (_enforcePolicy == value) return
        json("enforcePolicy") = value
        _enforcePolicy = value
    }

    private[this] var _hPolicy: LayoutPolicy = hPolicy
    def HPolicy = _hPolicy
    def HPolicy_=(value: LayoutPolicy) {
        if (_hPolicy == value) return
        json("hPolicy") = value
        _hPolicy = value
    }

    private[this] var _layoutBottomMargin: Number = layoutBottomMargin
    def LayoutBottomMargin = _layoutBottomMargin
    def LayoutBottomMargin_=(value: Number) {
        if (_layoutBottomMargin == value) return
        json("layoutBottomMargin") = value
        _layoutBottomMargin = value
    }

    private[this] var _layoutLeftMargin: Number = layoutLeftMargin
    def LayoutLeftMargin = _layoutLeftMargin
    def LayoutLeftMargin_=(value: Number) {
        if (_layoutLeftMargin == value) return
        json("layoutLeftMargin") = value
        _layoutLeftMargin = value
    }

    private[this] var _layoutMargin: Number = layoutMargin
    def LayoutMargin = _layoutMargin
    def LayoutMargin_=(value: Number) {
        if (_layoutMargin == value) return
        json("layoutMargin") = value
        _layoutMargin = value
    }

    private[this] var _layoutRightMargin: Number = layoutRightMargin
    def LayoutRightMargin = _layoutRightMargin
    def LayoutRightMargin_=(value: Number) {
        if (_layoutRightMargin == value) return
        json("layoutRightMargin") = value
        _layoutRightMargin = value
    }

    private[this] var _layoutTopMargin: Number = layoutTopMargin
    def LayoutTopMargin = _layoutTopMargin
    def LayoutTopMargin_=(value: Number) {
        if (_layoutTopMargin == value) return
        json("layoutTopMargin") = value
        _layoutTopMargin = value
    }

    private[this] var _leaveScrollbarGap: Bool = leaveScrollbarGap
    def LeaveScrollbarGap = _leaveScrollbarGap
    def LeaveScrollbarGap_=(value: Bool) {
        if (_leaveScrollbarGap == value) return
        json("leaveScrollbarGap") = value
        _leaveScrollbarGap = value
    }

    private[this] var _locateMembersBy: LocatorStrategy = locateMembersBy
    def LocateMembersBy = _locateMembersBy
    def LocateMembersBy_=(value: LocatorStrategy) {
        if (_locateMembersBy == value) return
        json("locateMembersBy") = value
        _locateMembersBy = value
    }

    private[this] var _locateMembersType: LocatorTypeStrategy = locateMembersType
    def LocateMembersType = _locateMembersType
    def LocateMembersType_=(value: LocatorTypeStrategy) {
        if (_locateMembersType == value) return
        json("locateMembersType") = value
        _locateMembersType = value
    }

    private[this] var _managePercentBreadth: Bool = managePercentBreadth
    def ManagePercentBreadth = _managePercentBreadth
    def ManagePercentBreadth_=(value: Bool) {
        if (_managePercentBreadth == value) return
        json("managePercentBreadth") = value
        _managePercentBreadth = value
    }

    private[this] var _memberOverlap: Number = memberOverlap
    def MemberOverlap = _memberOverlap
    def MemberOverlap_=(value: Number) {
        if (_memberOverlap == value) return
        json("memberOverlap") = value
        _memberOverlap = value
    }

    def Members = json.getJsonListOpt("members").getOrElse(members)
    def Members_=(value: JsonList) {
        if (Members == value) return
        json("members") = value
    }

    private[this] var _membersMargin: Number = membersMargin
    def MembersMargin = _membersMargin
    def MembersMargin_=(value: Number) {
        if (_membersMargin == value) return
        json("membersMargin") = value
        _membersMargin = value
    }

    private[this] var _minMemberSize: Number = minMemberSize
    def MinMemberSize = _minMemberSize
    def MinMemberSize_=(value: Number) {
        if (_minMemberSize == value) return
        json("minMemberSize") = value
        _minMemberSize = value
    }

    private[this] var _orientation: Orientation = orientation
    def Orientation = _orientation
    def Orientation_=(value: Orientation) {
        if (_orientation == value) return
        json("orientation") = value
        _orientation = value
    }

    private[this] var _overflow: Overflow = overflow
    override def Overflow = _overflow
    override def Overflow_=(value: Overflow) {
        if (_overflow == value) return
        json("overflow") = value
        _overflow = value
    }

    private[this] var _paddingAsLayoutMargin: Bool = paddingAsLayoutMargin
    def PaddingAsLayoutMargin = _paddingAsLayoutMargin
    def PaddingAsLayoutMargin_=(value: Bool) {
        if (_paddingAsLayoutMargin == value) return
        json("paddingAsLayoutMargin") = value
        _paddingAsLayoutMargin = value
    }

    private[this] var _placeHolderDefaults: CanvasDyn = placeHolderDefaults
    def PlaceHolderDefaults = _placeHolderDefaults
    def PlaceHolderDefaults_=(value: CanvasDyn) {
        if (_placeHolderDefaults == value) return
        json("placeHolderDefaults") = value
        _placeHolderDefaults = value
    }

    private[this] var _placeHolderProperties: CanvasDyn = placeHolderProperties
    def PlaceHolderProperties = _placeHolderProperties
    def PlaceHolderProperties_=(value: CanvasDyn) {
        if (_placeHolderProperties == value) return
        json("placeHolderProperties") = value
        _placeHolderProperties = value
    }

    private[this] var _resizeBarClass: String = resizeBarClass
    def ResizeBarClass = _resizeBarClass
    def ResizeBarClass_=(value: String) {
        if (_resizeBarClass == value) return
        json("resizeBarClass") = value
        _resizeBarClass = value
    }

    private[this] var _resizeBarSize: Number = resizeBarSize
    def ResizeBarSize = _resizeBarSize
    def ResizeBarSize_=(value: Number) {
        if (_resizeBarSize == value) return
        json("resizeBarSize") = value
        _resizeBarSize = value
    }

    private[this] var _reverseOrder: Bool = reverseOrder
    def ReverseOrder = _reverseOrder
    def ReverseOrder_=(value: Bool) {
        if (_reverseOrder == value) return
        json("reverseOrder") = value
        _reverseOrder = value
    }

    private[this] var _showDragPlaceHolder: Bool = showDragPlaceHolder
    def ShowDragPlaceHolder = _showDragPlaceHolder
    def ShowDragPlaceHolder_=(value: Bool) {
        if (_showDragPlaceHolder == value) return
        json("showDragPlaceHolder") = value
        _showDragPlaceHolder = value
    }

    private[this] var _showDropLines: Bool = showDropLines
    def ShowDropLines = _showDropLines
    def ShowDropLines_=(value: Bool) {
        if (_showDropLines == value) return
        json("showDropLines") = value
        _showDropLines = value
    }

    private[this] var _stackZIndex: String = stackZIndex
    def StackZIndex = _stackZIndex
    def StackZIndex_=(value: String) {
        if (_stackZIndex == value) return
        json("stackZIndex") = value
        _stackZIndex = value
    }

    private[this] var _vertical: Bool = vertical
    def Vertical = _vertical
    def Vertical_=(value: Bool) {
        if (_vertical == value) return
        json("vertical") = value
        _vertical = value
    }

    private[this] var _vPolicy: LayoutPolicy = vPolicy
    def VPolicy = _vPolicy
    def VPolicy_=(value: LayoutPolicy) {
        if (_vPolicy == value) return
        json("vPolicy") = value
        _vPolicy = value
    }
}

