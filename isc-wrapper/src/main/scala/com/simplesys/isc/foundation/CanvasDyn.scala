package com.simplesys.isc.foundation

import com.simplesys.json._
import com.simplesys.isc.system.{ArrayDyn, ClassDyn}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.forms.formItems.CanvasItemDyn
import com.simplesys.isc.forms.ValuesManagerDyn
import com.simplesys.json.UnquotedString
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName
import com.simplesys.isc.system.misc.URL
import com.simplesys.isc.system.misc.XPathExpression
import com.simplesys.isc.system.misc.Number
import com.simplesys.isc.system.misc.Bool

object CanvasDyn {
    implicit def CanvastoJsonObject(in: CanvasDyn): JsonObject = in json
}

class CanvasDyn(override val inJson: JsonObject = null,
                override val useSelfName: Boolean = false,
                override val fabriqueClass: Boolean = false) extends ClassDyn with CanvasDynInit {

    override val selfName = "Canvas"

    private[this] var _click: FunctionExpression = click
    def Click = _click
    def Click_=(value: FunctionExpression) {
        if (_click == value) return
        json("click") = value
        _click = value
    }

    private[this] var _height: Number = height
    def Height = _height
    def Height_=(value: Number) {
        if (_height == value) return
        json("height") = value
        _height = value
    }

    private[this] var _width: Number = width
    def Width = _width
    def Width_=(value: Number) {
        if (_width == value) return
        json("width") = value
        _width = value
    }

    private[this] var _minWidth: Number = minWidth
    def MinWidth = _minWidth
    def MinWidth_=(value: Number) {
        if (_minWidth == value) return
        json("minWidth") = value
        _minWidth = value
    }

    private[this] var _maxWidth: Number = maxWidth
    def MaxWidth = _maxWidth
    def MaxWidth_=(value: Number) {
        if (_maxWidth == value) return
        json("maxWidth") = value
        _maxWidth = value
    }

    private[this] var _hoverWidth: Number = hoverWidth
    def HoverWidth = _hoverWidth
    def HoverWidth_=(value: Number) {
        if (_hoverWidth == value) return
        json("hoverWidth") = value
        _hoverWidth = value
    }

    private[this] var _padding: Number = padding
    def Padding = _padding
    def Padding_=(value: Number) {
        if (_padding == value) return
        json("padding") = value
        _padding = value
    }

    private[this] var _showEdges: Bool = showEdges
    def ShowEdges = _showEdges
    def ShowEdges_=(value: Bool) {
        if (_showEdges == value) return
        json("showEdges") = value
        _showEdges = value
    }

    private[this] var _showShadow: Bool = showShadow
    def ShowShadow = _showShadow
    def ShowShadow_=(value: Bool) {
        if (_showShadow == value) return
        json("showShadow") = value
        _showShadow = value
    }

    private[this] var _autoDraw: Bool = autoDraw
    def AutoDraw = _autoDraw
    def AutoDraw_=(value: Bool) {
        if (_autoDraw == value) return
        json("autoDraw") = value
        _autoDraw = value
    }

    private[this] var _shadowDepth: Number = shadowDepth
    def ShadowDepth = _shadowDepth
    def ShadowDepth_=(value: Number) {
        if (_shadowDepth == value) return
        json("shadowDepth") = value
        _shadowDepth = value
    }

    private[this] var _loadingImageSize: Number = loadingImageSize
    def LoadingImageSize = _loadingImageSize
    def LoadingImageSize_=(value: Number) {
        json("loadingImageSize") = value
        _loadingImageSize = value
    }

    private[this] var _left: Number = left
    def Left = _left
    def Left_=(value: Number) {
        if (_left == value) return
        json("left") = value
        _left = value
    }

    private[this] var _top: Number = top
    def Top = _top
    def Top_=(value: Number) {
        if (_top == value) return
        json("top") = value
        _top = value
    }

    private[this] var _accessKey: String = accessKey
    def AccessKey = _accessKey
    def AccessKey_=(value: String) {
        if (_accessKey == value) return
        json("accessKey") = value
        _accessKey = value
    }

    private[this] var _animateAcceleration: AnimationAcceleration = animateAcceleration
    def AnimateAcceleration = _animateAcceleration
    def AnimateAcceleration_=(value: AnimationAcceleration) {
        if (_animateAcceleration == value) return
        json("animateAcceleration") = value
        _animateAcceleration = value
    }

    private[this] var _animateFadeTime: Number = animateFadeTime
    def AnimateFadeTime = _animateFadeTime
    def AnimateFadeTime_=(value: Number) {
        if (_animateFadeTime == value) return
        json("animateFadeTime") = value
        _animateFadeTime = value
    }

    private[this] var _animateHideAcceleration: AnimationAcceleration = animateHideAcceleration
    def AnimateHideAcceleration = _animateHideAcceleration
    def AnimateHideAcceleration_=(value: AnimationAcceleration) {
        if (_animateHideAcceleration == value) return
        json("animateHideAcceleration") = value
        _animateHideAcceleration = value
    }

    private[this] var _animateHideEffect: String = animateHideEffect
    def AnimateHideEffect = _animateHideEffect
    def AnimateHideEffect_=(value: String) {
        if (_animateHideEffect == value) return
        json("animateHideEffect") = value
        _animateHideEffect = value
    }

    private[this] var _animateHideTime: Number = animateHideTime
    def AnimateHideTime = _animateHideTime
    def AnimateHideTime_=(value: Number) {
        if (_animateHideTime == value) return
        json("animateHideTime") = value
        _animateHideTime = value
    }

    private[this] var _animateMoveAcceleration: AnimationAcceleration = animateMoveAcceleration
    def AnimateMoveAcceleration = _animateMoveAcceleration
    def AnimateMoveAcceleration_=(value: AnimationAcceleration) {
        if (_animateMoveAcceleration == value) return
        json("animateMoveAcceleration") = value
        _animateMoveAcceleration = value
    }

    private[this] var _animateMoveTime: Number = animateMoveTime
    def AnimateMoveTime = _animateMoveTime
    def AnimateMoveTime_=(value: Number) {
        if (_animateMoveTime == value) return
        json("animateMoveTime") = value
        _animateMoveTime = value
    }

    private[this] var _animateRectAcceleration: AnimationAcceleration = animateRectAcceleration
    def AnimateRectAcceleration = _animateRectAcceleration
    def AnimateRectAcceleration_=(value: AnimationAcceleration) {
        if (_animateRectAcceleration == value) return
        json("animateRectAcceleration") = value
        _animateRectAcceleration = value
    }

    private[this] var _animateRectTime: Number = animateRectTime
    def AnimateRectTime = _animateRectTime
    def AnimateRectTime_=(value: Number) {
        if (_animateRectTime == value) return
        json("animateRectTime") = value
        _animateRectTime = value
    }

    private[this] var _animateResizeAcceleration: AnimationAcceleration = animateResizeAcceleration
    def AnimateResizeAcceleration = _animateResizeAcceleration
    def AnimateResizeAcceleration_=(value: AnimationAcceleration) {
        if (_animateResizeAcceleration == value) return
        json("animateResizeAcceleration") = value
        _animateResizeAcceleration = value
    }

    private[this] var _animateResizeTime: Number = animateResizeTime
    def AnimateResizeTime = _animateResizeTime
    def AnimateResizeTime_=(value: Number) {
        if (_animateResizeTime == value) return
        json("animateResizeTime") = value
        _animateResizeTime = value
    }

    private[this] var _animateScrollAcceleration: AnimationAcceleration = animateScrollAcceleration
    def AnimateScrollAcceleration = _animateScrollAcceleration
    def AnimateScrollAcceleration_=(value: AnimationAcceleration) {
        if (_animateScrollAcceleration == value) return
        json("animateScrollAcceleration") = value
        _animateScrollAcceleration = value
    }

    private[this] var _animateScrollTime: Number = animateScrollTime
    def AnimateScrollTime = _animateScrollTime
    def AnimateScrollTime_=(value: Number) {
        if (_animateScrollTime == value) return
        json("animateScrollTime") = value
        _animateScrollTime = value
    }

    private[this] var _animateShowAcceleration: AnimationAcceleration = animateShowAcceleration
    def AnimateShowAcceleration = _animateShowAcceleration
    def AnimateShowAcceleration_=(value: AnimationAcceleration) {
        if (_animateShowAcceleration == value) return
        json("animateShowAcceleration") = value
        _animateShowAcceleration = value
    }

    private[this] var _animateShowEffect: String = animateShowEffect
    def AnimateShowEffect = _animateShowEffect
    def AnimateShowEffect_=(value: String) {
        if (_animateShowEffect == value) return
        json("animateShowEffect") = value
        _animateShowEffect = value
    }

    private[this] var _animateShowTime: Number = animateShowTime
    def AnimateShowTime = _animateShowTime
    def AnimateShowTime_=(value: Number) {
        if (_animateShowTime == value) return
        json("animateShowTime") = value
        _animateShowTime = value
    }

    private[this] var _animateTime: Number = animateTime
    def AnimateTime = _animateTime
    def AnimateTime_=(value: Number) {
        if (_animateTime == value) return
        json("animateTime") = value
        _animateTime = value
    }

    def AppImgDir = json.getValue2[JsonURL, URL]("appImgDir").getOrElse(appImgDir)
    def AppImgDir_=(value: URL) {
        if (AppImgDir == value) return
        json("appImgDir") = value
    }

    private[this] var _ariaRole: String = ariaRole
    def AriaRole = _ariaRole
    def AriaRole_=(value: String) {
        if (_ariaRole == value) return
        json("ariaRole") = value
        _ariaRole = value
    }

    private[this] var _autoShowParent: Bool = autoShowParent
    def AutoShowParent = _autoShowParent
    def AutoShowParent_=(value: Bool) {
        if (_autoShowParent == value) return
        json("autoShowParent") = value
        _autoShowParent = value
    }

    private[this] var _backgroundColor: Color = backgroundColor
    def BackgroundColor = _backgroundColor
    def BackgroundColor_=(value: Color) {
        if (_backgroundColor == value) return
        json("backgroundColor") = value
        _backgroundColor = value
    }

    private[this] var _backgroundImage: SCImgURL = backgroundImage
    def BackgroundImage = _backgroundImage
    def BackgroundImage_=(value: SCImgURL) {
        if (_backgroundImage == value) return
        json("backgroundImage") = value
        _backgroundImage = value
    }

    private[this] var _backgroundPosition: String = backgroundPosition
    def BackgroundPosition = _backgroundPosition
    def BackgroundPosition_=(value: String) {
        if (_backgroundPosition == value) return
        json("backgroundPosition") = value
        _backgroundPosition = value
    }

    private[this] var _backgroundRepeat: String = backgroundRepeat
    def BackgroundRepeat = _backgroundRepeat
    def BackgroundRepeat_=(value: String) {
        if (_backgroundRepeat == value) return
        json("backgroundRepeat") = value
        _backgroundRepeat = value
    }

    private[this] var _border: String = border
    def Border = _border
    def Border_=(value: String) {
        if (_border == value) return
        json("border") = value
        _border = value
    }

    private[this] var _canAcceptDrop: Bool = canAcceptDrop
    def CanAcceptDrop = _canAcceptDrop
    def CanAcceptDrop_=(value: Bool) {
        if (_canAcceptDrop == value) return
        json("canAcceptDrop") = value
        _canAcceptDrop = value
    }

    private[this] var _canDrag: Bool = canDrag
    def CanDrag = _canDrag
    def CanDrag_=(value: Bool) {
        if (_canDrag == value) return
        json("canDrag") = value
        _canDrag = value
    }

    private[this] var _canDragReposition: Bool = canDragReposition
    def CanDragReposition = _canDragReposition
    def CanDragReposition_=(value: Bool) {
        if (_canDragReposition == value) return
        json("canDragReposition") = value
        _canDragReposition = value
    }

    private[this] var _canDragResize: Bool = canDragResize
    def CanDragResize = _canDragResize
    def CanDragResize_=(value: Bool) {
        if (_canDragResize == value) return
        json("canDragResize") = value
        _canDragResize = value
    }

    private[this] var _canDragScroll: Bool = canDragScroll
    def CanDragScroll = _canDragScroll
    def CanDragScroll_=(value: Bool) {
        if (_canDragScroll == value) return
        json("canDragScroll") = value
        _canDragScroll = value
    }

    private[this] var _canDrop: Bool = canDrop
    def CanDrop = _canDrop
    def CanDrop_=(value: Bool) {
        if (_canDrop == value) return
        json("canDrop") = value
        _canDrop = value
    }

    private[this] var _canDropBefore: Bool = canDropBefore
    def CanDropBefore = _canDropBefore
    def CanDropBefore_=(value: Bool) {
        if (_canDropBefore == value) return
        json("canDropBefore") = value
        _canDropBefore = value
    }

    private[this] var _canFocus: Bool = canFocus
    def CanFocus = _canFocus
    def CanFocus_=(value: Bool) {
        if (_canFocus == value) return
        json("canFocus") = value
        _canFocus = value
    }

    private[this] var _canHover: Bool = canHover
    def CanHover = _canHover
    def CanHover_=(value: Bool) {
        if (_canHover == value) return
        json("canHover") = value
        _canHover = value
    }

    private[this] var _canSelectText: Bool = canSelectText
    def CanSelectText = _canSelectText
    def CanSelectText_=(value: Bool) {
        if (_canSelectText == value) return
        json("canSelectText") = value
        _canSelectText = value
    }

    private[this] var _children: ArrayDyn[CanvasDyn] = children
    def Children = _children
    def Children_=(value: ArrayDyn[CanvasDyn]) {
        if (_children == value) return
        json("children") = value
        _children = value
    }

    private[this] var _childrenSnapResizeToGrid: Bool = childrenSnapResizeToGrid
    def ChildrenSnapResizeToGrid = _childrenSnapResizeToGrid
    def ChildrenSnapResizeToGrid_=(value: Bool) {
        if (_childrenSnapResizeToGrid == value) return
        json("childrenSnapResizeToGrid") = value
        _childrenSnapResizeToGrid = value
    }

    private[this] var _childrenSnapToGrid: Bool = childrenSnapToGrid
    def ChildrenSnapToGrid = _childrenSnapToGrid
    def ChildrenSnapToGrid_=(value: Bool) {
        if (_childrenSnapToGrid == value) return
        json("childrenSnapToGrid") = value
        _childrenSnapToGrid = value
    }

    private[this] var _className: CSSStyleName = className
    def ClassName = _className
    def ClassName_=(value: CSSStyleName) {
        if (_className == value) return
        json("className") = value
        _className = value
    }


    def Contents = json.getJsonElement("contents").getOrElse(contents)
    def Contents_=(value: JsonElement) {
        if (Contents == value) return
        json("contents") = value
    }

    def ContextMenu = json.getJsonElement("contextMenu").getOrElse(contextMenu)
    def ContextMenu_=(value: JsonElement) {
        if (ContextMenu == value) return
        json("contextMenu") = value
    }

    private[this] var _cursor: Cursor = cursor
    def Cursor = _cursor
    def Cursor_=(value: Cursor) {
        if (_cursor == value) return
        json("cursor") = value
        _cursor = value
    }

    private[this] var _customEdges: Strings = customEdges
    def CustomEdges = _customEdges
    def CustomEdges_=(value: Strings) {
        if (_customEdges == value) return
        json("customEdges") = value
        _customEdges = value
    }

    private[this] var _dataPath: XPathExpression = dataPath
    def DataPath = _dataPath
    def DataPath_=(value: XPathExpression) {
        if (_dataPath == value) return
        json("dataPath") = value
        _dataPath = value
    }

    private[this] var _defaultHeight: Number = defaultHeight
    def DefaultHeight = _defaultHeight
    def DefaultHeight_=(value: Number) {
        if (_defaultHeight == value) return
        json("defaultHeight") = value
        _defaultHeight = value
    }

    private[this] var _defaultWidth: Number = defaultWidth
    def DefaultWidth = _defaultWidth
    def DefaultWidth_=(value: Number) {
        if (_defaultWidth == value) return
        json("defaultWidth") = value
        _defaultWidth = value
    }

    private[this] var _destroyed: Bool = destroyed
    def Destroyed = _destroyed
    def Destroyed_=(value: Bool) {
        if (_destroyed == value) return
        json("destroyed") = value
        _destroyed = value
    }

    private[this] var _destroying: Bool = destroying
    def Destroying = _destroying
    def Destroying_=(value: Bool) {
        if (_destroying == value) return
        json("destroying") = value
        _destroying = value
    }

    private[this] var _disabled: Bool = disabled
    def Disabled = _disabled
    def Disabled_=(value: Bool) {
        if (_disabled == value) return
        json("disabled") = value
        _disabled = value
    }

    private[this] var _disabledCursor: Cursor = disabledCursor
    def DisabledCursor = _disabledCursor
    def DisabledCursor_=(value: Cursor) {
        if (_disabledCursor == value) return
        json("disabledCursor") = value
        _disabledCursor = value
    }

    private[this] var _doubleClickDelay: Number = doubleClickDelay
    def DoubleClickDelay = _doubleClickDelay
    def DoubleClickDelay_=(value: Number) {
        if (_doubleClickDelay == value) return
        json("doubleClickDelay") = value
        _doubleClickDelay = value
    }

    private[this] var _dragAppearance: DragAppearance = dragAppearance
    def DragAppearance = _dragAppearance
    def DragAppearance_=(value: DragAppearance) {
        if (_dragAppearance == value) return
        json("dragAppearance") = value
        _dragAppearance = value
    }

    private[this] var _dragIntersectStyle: DragIntersectStyle = dragIntersectStyle
    def DragIntersectStyle = _dragIntersectStyle
    def DragIntersectStyle_=(value: DragIntersectStyle) {
        if (_dragIntersectStyle == value) return
        json("dragIntersectStyle") = value
        _dragIntersectStyle = value
    }

    private[this] var _dragOpacity: Number = dragOpacity
    def DragOpacity = _dragOpacity
    def DragOpacity_=(value: Number) {
        if (_dragOpacity == value) return
        json("dragOpacity") = value
        _dragOpacity = value
    }

    private[this] var _dragRepositionAppearance: DragAppearance = dragRepositionAppearance
    def DragRepositionAppearance = _dragRepositionAppearance
    def DragRepositionAppearance_=(value: DragAppearance) {
        if (_dragRepositionAppearance == value) return
        json("dragRepositionAppearance") = value
        _dragRepositionAppearance = value
    }

    private[this] var _dragRepositionCursor: Cursor = dragRepositionCursor
    def DragRepositionCursor = _dragRepositionCursor
    def DragRepositionCursor_=(value: Cursor) {
        if (_dragRepositionCursor == value) return
        json("dragRepositionCursor") = value
        _dragRepositionCursor = value
    }

    private[this] var _dragResizeAppearance: DragAppearance = dragResizeAppearance
    def DragResizeAppearance = _dragResizeAppearance
    def DragResizeAppearance_=(value: DragAppearance) {
        if (_dragResizeAppearance == value) return
        json("dragResizeAppearance") = value
        _dragResizeAppearance = value
    }

    private[this] var _dragScrollDelay: Number = dragScrollDelay
    def DragScrollDelay = _dragScrollDelay
    def DragScrollDelay_=(value: Number) {
        if (_dragScrollDelay == value) return
        json("dragScrollDelay") = value
        _dragScrollDelay = value
    }

    private[this] var _dragStartDistance: Number = dragStartDistance
    def DragStartDistance = _dragStartDistance
    def DragStartDistance_=(value: Number) {
        if (_dragStartDistance == value) return
        json("dragStartDistance") = value
        _dragStartDistance = value
    }

    private[this] var _dragTarget: CanvasDyn = dragTarget
    def DragTarget = _dragTarget
    def DragTarget_=(value: CanvasDyn) {
        json("dragTarget") = value
        _dragTarget = value
    }

    private[this] var _dragType: String = dragType
    def DragType = _dragType
    def DragType_=(value: String) {
        if (_dragType == value) return
        json("dragType") = value
        _dragType = value
    }

    def Draw = json.getFunctionExpressionOpt("draw").getOrElse(draw)
    def Draw_=(value: FunctionExpression) {
        if (Draw == value) return
        json("draw") = value
    }

    def DropTypes = json.getJsonElement("dropTypes").getOrElse(dropTypes)
    def DropTypes_=(value: JsonElement) {
        if (DropTypes == value) return
        json("dropTypes") = value
    }

    private[this] var _dynamicContents: Bool = dynamicContents
    def DynamicContents = _dynamicContents
    def DynamicContents_=(value: Bool) {
        if (_dynamicContents == value) return
        json("dynamicContents") = value
        _dynamicContents = value
    }

    def DynamicContentsVars = json.getJsonListOpt("dynamicContentsVars").getOrElse(dynamicContentsVars)
    def DynamicContentsVars_=(value: JsonList) {
        if (DynamicContentsVars == value) return
        json("dynamicContentsVars") = value
    }

    private[this] var _edgeBackgroundColor: Color = edgeBackgroundColor
    def EdgeBackgroundColor = _edgeBackgroundColor
    def EdgeBackgroundColor_=(value: Color) {
        if (_edgeBackgroundColor == value) return
        json("edgeBackgroundColor") = value
        _edgeBackgroundColor = value
    }

    private[this] var _edgeCenterBackgroundColor: Color = edgeCenterBackgroundColor
    def EdgeCenterBackgroundColor = _edgeCenterBackgroundColor
    def EdgeCenterBackgroundColor_=(value: Color) {
        if (_edgeCenterBackgroundColor == value) return
        json("edgeCenterBackgroundColor") = value
        _edgeCenterBackgroundColor = value
    }

    private[this] var _edgeCursorMap: JsonObject = edgeCursorMap
    def EdgeCursorMap = _edgeCursorMap
    def EdgeCursorMap_=(value: JsonObject) {
        if (_edgeCursorMap == value) return
        json("edgeCursorMap") = value
        _edgeCursorMap = value
    }

    private[this] var _edgeImage: SCImgURL = edgeImage
    def EdgeImage = _edgeImage
    def EdgeImage_=(value: SCImgURL) {
        if (_edgeImage == value) return
        json("edgeImage") = value
        _edgeImage = value
    }

    private[this] var _edgeMarginSize: Number = edgeMarginSize
    def EdgeMarginSize = _edgeMarginSize
    def EdgeMarginSize_=(value: Number) {
        if (_edgeMarginSize == value) return
        json("edgeMarginSize") = value
        _edgeMarginSize = value
    }

    private[this] var _edgeOffset: Number = edgeOffset
    def EdgeOffset = _edgeOffset
    def EdgeOffset_=(value: Number) {
        if (_edgeOffset == value) return
        json("edgeOffset") = value
        _edgeOffset = value
    }

    private[this] var _edgeOpacity: Number = edgeOpacity
    def EdgeOpacity = _edgeOpacity
    def EdgeOpacity_=(value: Number) {
        if (_edgeOpacity == value) return
        json("edgeOpacity") = value
        _edgeOpacity = value
    }

    private[this] var _edgeShowCenter: Bool = edgeShowCenter
    def EdgeShowCenter = _edgeShowCenter
    def EdgeShowCenter_=(value: Bool) {
        if (_edgeShowCenter == value) return
        json("edgeShowCenter") = value
        _edgeShowCenter = value
    }

    private[this] var _edgeSize: Number = edgeSize
    def EdgeSize = _edgeSize
    def EdgeSize_=(value: Number) {
        if (_edgeSize == value) return
        json("edgeSize") = value
        _edgeSize = value
    }

    private[this] var _enabled: Bool = enabled
    def Enabled = _enabled
    def Enabled_=(value: Bool) {
        if (_enabled == value) return
        json("enabled") = value
        _enabled = value
    }

    private[this] var _extraSpace: Number = extraSpace
    def ExtraSpace = _extraSpace
    def ExtraSpace_=(value: Number) {
        if (_extraSpace == value) return
        json("extraSpace") = value
        _extraSpace = value
    }

    private[this] var _hoverAlign: AlignmentDyn = hoverAlign
    def HoverAlign = _hoverAlign
    def HoverAlign_=(value: AlignmentDyn) {
        if (_hoverAlign == value) return
        json("hoverAlign") = value
        _hoverAlign = value
    }

    private[this] var _hoverAutoDestroy: Bool = hoverAutoDestroy
    def HoverAutoDestroy = _hoverAutoDestroy
    def HoverAutoDestroy_=(value: Bool) {
        if (_hoverAutoDestroy == value) return
        json("hoverAutoDestroy") = value
        _hoverAutoDestroy = value
    }

    private[this] var _hoverDelay: Number = hoverDelay
    def HoverDelay = _hoverDelay
    def HoverDelay_=(value: Number) {
        if (_hoverDelay == value) return
        json("hoverDelay") = value
        _hoverDelay = value
    }

    private[this] var _hoverHeight: Number = hoverHeight
    def HoverHeight = _hoverHeight
    def HoverHeight_=(value: Number) {
        if (_hoverHeight == value) return
        json("hoverHeight") = value
        _hoverHeight = value
    }

    private[this] var _hoverMoveWithMouse: Bool = hoverMoveWithMouse
    def HoverMoveWithMouse = _hoverMoveWithMouse
    def HoverMoveWithMouse_=(value: Bool) {
        if (_hoverMoveWithMouse == value) return
        json("hoverMoveWithMouse") = value
        _hoverMoveWithMouse = value
    }

    private[this] var _hoverOpacity: Number = hoverOpacity
    def HoverOpacity = _hoverOpacity
    def HoverOpacity_=(value: Number) {
        if (_hoverOpacity == value) return
        json("hoverOpacity") = value
        _hoverOpacity = value
    }

    private[this] var _hoverStyle: CSSStyleName = hoverStyle
    def HoverStyle = _hoverStyle
    def HoverStyle_=(value: CSSStyleName) {
        if (_hoverStyle == value) return
        json("hoverStyle") = value
        _hoverStyle = value
    }

    private[this] var _hoverVAlign: AlignmentDyn = hoverVAlign
    def HoverVAlign = _hoverVAlign
    def HoverVAlign_=(value: AlignmentDyn) {
        if (_hoverVAlign == value) return
        json("hoverVAlign") = value
        _hoverVAlign = value
    }

    private[this] var _hoverWrap: Bool = hoverWrap
    def HoverWrap = _hoverWrap
    def HoverWrap_=(value: Bool) {
        if (_hoverWrap == value) return
        json("hoverWrap") = value
        _hoverWrap = value
    }

    private[this] var _htmlElement: HTMLString = htmlElement
    def HtmlElement = _htmlElement
    def HtmlElement_=(value: HTMLString) {
        if (_htmlElement == value) return
        json("htmlElement") = value
        _htmlElement = value
    }

    private[this] var _htmlPosition: DrawPosition = htmlPosition
    def HtmlPosition = _htmlPosition
    def HtmlPosition_=(value: DrawPosition) {
        if (_htmlPosition == value) return
        json("htmlPosition") = value
        _htmlPosition = value
    }

    private[this] var _initWidget: FunctionExpression = initWidget
    def InitWidget = _initWidget
    def InitWidget_=(value: FunctionExpression) {
        if (_initWidget == value) return
        json("initWidget") = value
        _initWidget = value
    }

    def KeepInParentRect = json.getJsonElement("keepInParentRect").getOrElse(keepInParentRect)
    def KeepInParentRect_=(value: JsonElement) {
        if (KeepInParentRect == value) return
        json("keepInParentRect") = value
    }

    private[this] var _layoutAlign: AlignmentDyn = layoutAlign
    def LayoutAlign = _layoutAlign
    def LayoutAlign_=(value: AlignmentDyn) {
        if (_layoutAlign == value) return
        json("layoutAlign") = value
    }

    private[this] var _locateChildrenBy: LocatorStrategy = locateChildrenBy
    def LocateChildrenBy = _locateChildrenBy
    def LocateChildrenBy_=(value: LocatorStrategy) {
        if (_locateChildrenBy == value) return
        json("locateChildrenBy") = value
        _locateChildrenBy = value
    }

    private[this] var _locateChildrenType: LocatorTypeStrategy = locateChildrenType
    def LocateChildrenType = _locateChildrenType
    def LocateChildrenType_=(value: LocatorTypeStrategy) {
        if (_locateChildrenType == value) return
        json("locateChildrenType") = value
        _locateChildrenType = value
    }

    private[this] var _locatePeersBy: LocatorStrategy = locatePeersBy
    def LocatePeersBy = _locatePeersBy
    def LocatePeersBy_=(value: LocatorStrategy) {
        if (_locatePeersBy == value) return
        json("locatePeersBy") = value
        _locatePeersBy = value
    }

    private[this] var _locatePeersType: LocatorTypeStrategy = locatePeersType
    def LocatePeersType = _locatePeersType
    def LocatePeersType_=(value: LocatorTypeStrategy) {
        if (_locatePeersType == value) return
        json("locatePeersType") = value
        _locatePeersType = value
    }

    private[this] var _margin: Number = margin
    def Margin = _margin
    def Margin_=(value: Number) {
        if (_margin == value) return
        json("margin") = value
        _margin = value
    }

    private[this] var _masterElement: CanvasDyn = masterElement
    def MasterElement = _masterElement
    def MasterElement_=(value: CanvasDyn) {
        if (_masterElement == value) return
        json("masterElement") = value
        _masterElement = value
    }

    private[this] var _matchElement: Bool = matchElement
    def MatchElement = _matchElement
    def MatchElement_=(value: Bool) {
        if (_matchElement == value) return
        json("matchElement") = value
        _matchElement = value
    }

    private[this] var _maxHeight: Number = maxHeight
    def MaxHeight = _maxHeight
    def MaxHeight_=(value: Number) {
        if (_maxHeight == value) return
        json("maxHeight") = value
        _maxHeight = value
    }

    private[this] var _menuConstructor: CSSStyleName = menuConstructor
    def MenuConstructor = _menuConstructor
    def MenuConstructor_=(value: CSSStyleName) {
        if (_menuConstructor == value) return
        json("menuConstructor") = value
        _menuConstructor = value
    }

    private[this] var _minHeight: Number = minHeight
    def MinHeight = _minHeight
    def MinHeight_=(value: Number) {
        if (_minHeight == value) return
        json("minHeight") = value
        _minHeight = value
    }

    private[this] var _mouseStillDownDelay: Number = mouseStillDownDelay
    def MouseStillDownDelay = _mouseStillDownDelay
    def MouseStillDownDelay_=(value: Number) {
        if (_mouseStillDownDelay == value) return
        json("mouseStillDownDelay") = value
        _mouseStillDownDelay = value
    }

    private[this] var _mouseStillDownInitialDelay: Number = mouseStillDownInitialDelay
    def MouseStillDownInitialDelay = _mouseStillDownInitialDelay
    def MouseStillDownInitialDelay_=(value: Number) {
        if (_mouseStillDownInitialDelay == value) return
        json("mouseStillDownInitialDelay") = value
        _mouseStillDownInitialDelay = value
    }

    private[this] var _noDoubleClicks: Bool = noDoubleClicks
    def NoDoubleClicks = _noDoubleClicks
    def NoDoubleClicks_=(value: Bool) {
        if (_noDoubleClicks == value) return
        json("noDoubleClicks") = value
        _noDoubleClicks = value
    }

    private[this] var _opacity: Number = opacity
    def Opacity = _opacity
    def Opacity_=(value: Number) {
        if (_opacity == value) return
        json("opacity") = value
        _opacity = value
    }

    private[this] var _overflow: Overflow = overflow
    def Overflow = _overflow
    def Overflow_=(value: Overflow) {
        if (_overflow == value) return
        json("overflow") = value
        _overflow = value
    }

    private[this] var _parentElement: CanvasDyn = parentElement
    def ParentElement = _parentElement
    def ParentElement_=(value: CanvasDyn) {
        if (_parentElement == value) return
        json("parentElement") = value
        _parentElement = value
    }

    private[this] var _peers: ArrayDyn[CanvasDyn] = peers
    def Peers = _peers
    def Peers_=(value: ArrayDyn[CanvasDyn]) {
        if (_peers == value) return
        json("peers") = value
        _peers = value
    }

    private[this] var _percentBox: PercentBoxModel = percentBox
    def PercentBox = _percentBox
    def PercentBox_=(value: PercentBoxModel) {
        if (_percentBox == value) return
        json("percentBox") = value
        _percentBox = value
    }

    private[this] var _percentSource: CanvasDyn = percentSource
    def PercentSource = _percentSource
    def PercentSource_=(value: CanvasDyn) {
        if (_percentSource == value) return
        json("percentSource") = value
        _percentSource = value
    }

    private[this] var _position: Positioning = position
    def Position = _position
    def Position_=(value: Positioning) {
        if (_position == value) return
        json("position") = value
        _position = value
    }

    private[this] var _prompt: HTMLString = prompt
    def Prompt = _prompt
    def Prompt_=(value: HTMLString) {
        if (_prompt == value) return
        json("prompt") = value
        _prompt = value
    }

    private[this] var _redrawOnResize: Bool = redrawOnResize
    def RedrawOnResize = _redrawOnResize
    def RedrawOnResize_=(value: Bool) {
        if (_redrawOnResize == value) return
        json("redrawOnResize") = value
        _redrawOnResize = value
    }

    private[this] var _resizeBarTarget: String = resizeBarTarget
    def ResizeBarTarget = _resizeBarTarget
    def ResizeBarTarget_=(value: String) {
        if (_resizeBarTarget == value) return
        json("resizeBarTarget") = value
        _resizeBarTarget = value
    }

    private[this] var _resizeFrom: JsonList = resizeFrom
    def ResizeFrom = _resizeFrom
    def ResizeFrom_=(value: JsonList) {
        if (_resizeFrom == value) return
        json("resizeFrom") = value
        _resizeFrom = value
    }

    private[this] var _scrollbarSize: Number = scrollbarSize
    def ScrollbarSize = _scrollbarSize
    def ScrollbarSize_=(value: Number) {
        if (_scrollbarSize == value) return
        json("scrollbarSize") = value
        _scrollbarSize = value
    }

    private[this] var _shadowImage: String = shadowImage
    def ShadowImage = _shadowImage
    def ShadowImage_=(value: String) {
        if (_shadowImage == value) return
        json("shadowImage") = value
        _shadowImage = value
    }

    /*
    shadowOffset [IR] [Advanced]	type:Number, defaultValue: null

    Offset of the shadow. Defaults to half of shadowDepth if unset.

    Because of the blurred edges, a shadow is larger than the originating component by 2xsoftness. An shadowOffset of 0 means that the shadow will extend around the originating component equally in all directions.

    Examples:

        Shadows Example
    */
    private[this] var _shadowOffset: Number = shadowOffset
    def ShadowOffset = _shadowOffset
    def ShadowOffset_=(value: Number) {
        if (_shadowOffset == value) return
        json("shadowOffset") = value
        _shadowOffset = value
    }

    private[this] var _shadowSoftness: Number = shadowSoftness
    def ShadowSoftness = _shadowSoftness
    def ShadowSoftness_=(value: Number) {
        if (_shadowSoftness == value) return
        json("shadowSoftness") = value
        _shadowSoftness = value
    }

    private[this] var _shouldPrint: Bool = shouldPrint
    def ShouldPrint = _shouldPrint
    def ShouldPrint_=(value: Bool) {
        if (_shouldPrint == value) return
        json("shouldPrint") = value
        _shouldPrint = value
    }

    private[this] var _showCustomScrollbars: Bool = showCustomScrollbars
    def ShowCustomScrollbars = _showCustomScrollbars
    def ShowCustomScrollbars_=(value: Bool) {
        if (_showCustomScrollbars == value) return
        json("showCustomScrollbars") = value
        _showCustomScrollbars = value
    }

    private[this] var _showDragShadow: Bool = showDragShadow
    def ShowDragShadow = _showDragShadow
    def ShowDragShadow_=(value: Bool) {
        if (_showDragShadow == value) return
        json("showDragShadow") = value
        _showDragShadow = value
    }

    private[this] var _showHover: Bool = showHover
    def ShowHover = _showHover
    def ShowHover_=(value: Bool) {
        if (_showHover == value) return
        json("showHover") = value
        _showHover = value
    }

    private[this] var _showHoverComponents: Bool = showHoverComponents
    def ShowHoverComponents = _showHoverComponents
    def ShowHoverComponents_=(value: Bool) {
        if (_showHoverComponents == value) return
        json("showHoverComponents") = value
        _showHoverComponents = value
    }

    private[this] var _showResizeBar: Bool = showResizeBar
    def ShowResizeBar = _showResizeBar
    def ShowResizeBar_=(value: Bool) {
        if (_showResizeBar == value) return
        json("showResizeBar") = value
        _showResizeBar = value
    }

    private[this] var _skinImgDir: URL = skinImgDir
    def SkinImgDir = _skinImgDir
    def SkinImgDir_=(value: URL) {
        if (_skinImgDir == value) return
        json("skinImgDir") = value
        _skinImgDir = value
    }

    private[this] var _snapAxis: String = snapAxis
    def SnapAxis = _snapAxis
    def SnapAxis_=(value: String) {
        if (_snapAxis == value) return
        json("snapAxis") = value
        _snapAxis = value
    }

    private[this] var _snapEdge: String = snapEdge
    def SnapEdge = _snapEdge
    def SnapEdge_=(value: String) {
        if (_snapEdge == value) return
        json("snapEdge") = value
        _snapEdge = value
    }

    private[this] var _snapHDirection: String = snapHDirection
    def SnapHDirection = _snapHDirection
    def SnapHDirection_=(value: String) {
        if (_snapHDirection == value) return
        json("snapHDirection") = value
        _snapHDirection = value
    }

    private[this] var _snapHGap: Number = snapHGap
    def SnapHGap = _snapHGap
    def SnapHGap_=(value: Number) {
        if (_snapHGap == value) return
        json("snapHGap") = value
        _snapHGap = value
    }

    private[this] var _snapOffsetLeft: Number = snapOffsetLeft
    def SnapOffsetLeft = _snapOffsetLeft
    def SnapOffsetLeft_=(value: Number) {
        if (_snapOffsetLeft == value) return
        json("snapOffsetLeft") = value
        _snapOffsetLeft = value
    }

    private[this] var _snapOffsetTop: Number = snapOffsetTop
    def SnapOffsetTop = _snapOffsetTop
    def SnapOffsetTop_=(value: Number) {
        if (_snapOffsetTop == value) return
        json("snapOffsetTop") = value
        _snapOffsetTop = value
    }

    private[this] var _snapOnDrop: Bool = snapOnDrop
    def SnapOnDrop = _snapOnDrop
    def SnapOnDrop_=(value: Bool) {
        if (_snapOnDrop == value) return
        json("snapOnDrop") = value
        _snapOnDrop = value
    }

    private[this] var _snapResizeToGrid: Bool = snapResizeToGrid
    def SnapResizeToGrid = _snapResizeToGrid
    def SnapResizeToGrid_=(value: Bool) {
        if (_snapResizeToGrid == value) return
        json("snapResizeToGrid") = value
        _snapResizeToGrid = value
    }

    private[this] var _snapTo: SnapTo = snapTo
    def SnapTo = _snapTo
    def SnapTo_=(value: SnapTo) {
        if (_snapTo == value) return
        json("snapTo") = value
        _snapTo = value
    }

    private[this] var _snapToGrid: Bool = snapToGrid
    def SnapToGrid = _snapToGrid
    def SnapToGrid_=(value: Bool) {
        if (_snapToGrid == value) return
        json("snapToGrid") = value
        _snapToGrid = value
    }

    private[this] var _snapVDirection: String = snapVDirection
    def SnapVDirection = _snapVDirection
    def SnapVDirection_=(value: String) {
        if (_snapVDirection == value) return
        json("snapVDirection") = value
        _snapVDirection = value
    }

    private[this] var _snapVGap: Number = snapVGap
    def SnapVGap = _snapVGap
    def SnapVGap_=(value: Number) {
        if (_snapVGap == value) return
        json("snapVGap") = value
        _snapVGap = value
    }

    private[this] var _styleName: CSSStyleName = styleName
    def StyleName = _styleName
    def StyleName_=(value: CSSStyleName) {
        if (_styleName == value) return
        json("styleName") = value
        _styleName = value
    }

    private[this] var _tabIndex: Number = tabIndex
    def TabIndex = _tabIndex
    def TabIndex_=(value: Number) {
        if (_tabIndex == value) return
        json("tabIndex") = value
        _tabIndex = value
    }

    private[this] var _topElement: CanvasDyn = topElement
    def TopElement = _topElement
    def TopElement_=(value: CanvasDyn) {
        if (_topElement == value) return
        json("topElement") = value
        _topElement = value
    }

    private[this] var _useOpacityFilter: Bool = useOpacityFilter
    def UseOpacityFilter = _useOpacityFilter
    def UseOpacityFilter_=(value: Bool) {
        if (_useOpacityFilter == value) return
        json("useOpacityFilter") = value
        _useOpacityFilter = value
    }

    private[this] var _visibility: Visibility = visibility
    def Visibility = _visibility
    def Visibility_=(value: Visibility) {
        if (_visibility == value) return
        json("visibility") = value
        _visibility = value
    }

    private[this] var _canvasItem: CanvasItemDyn = canvasItem
    def Canvas_Item = _canvasItem
    def Canvas_Item_=(value: CanvasItemDyn) {
        if (_canvasItem == value) return
        json("canvasItem") = value
        _canvasItem = value
    }

    def VisibilityChanged = json.getFunctionExpressionOpt("visibilityChanged").getOrElse(visibilityChanged)
    def VisibilityChanged_=(value: FunctionExpression) {
        if (VisibilityChanged == value) return
        json("visibilityChanged") = value
    }

    private[this] var _valuesManager: ValuesManagerDyn = valuesManager
    def Values_Manager = _valuesManager
    def Values_Manager_=(value: ValuesManagerDyn) {
        if (_valuesManager == value) return
        json("valuesManager") = value
        _valuesManager = value
    }

    private[this] var _hover: FunctionExpression = hover
    def Hover = _hover
    def Hover_=(value: FunctionExpression) {
        if (_hover == value) return
        json("hover") = value
        _hover = value
    }

    private[this] var _keyDown: FunctionExpression = keyDown
    def KeyDown = _keyDown
    def KeyDown_=(value: FunctionExpression) {
        if (_keyDown == value) return
        json("keyDown") = value
        _keyDown = value
    }

    private[this] var _keyPress: FunctionExpression = keyPress
    def KeyPress = _keyPress
    def KeyPress_=(value: FunctionExpression) {
        if (_keyPress == value) return
        json("keyPress") = value
        _keyPress = value
    }

    private[this] var _keyUp: FunctionExpression = keyUp
    def KeyUp = _keyUp
    def KeyUp_=(value: FunctionExpression) {
        if (_keyUp == value) return
        json("keyUp") = value
        _keyUp = value
    }

    private[this] var _mouseDown: FunctionExpression = mouseDown
    def MouseDown = _mouseDown
    def MouseDown_=(value: FunctionExpression) {
        if (_mouseDown == value) return
        json("mouseDown") = value
        _mouseDown = value
    }

    private[this] var _mouseMove: FunctionExpression = mouseMove
    def MouseMove = _mouseMove
    def MouseMove_=(value: FunctionExpression) {
        if (_mouseMove == value) return
        json("mouseMove") = value
        _mouseMove = value
    }

    private[this] var _mouseOut: FunctionExpression = mouseOut
    def MouseOut = _mouseOut
    def MouseOut_=(value: FunctionExpression) {
        if (_mouseOut == value) return
        json(" mouseOut") = value
        _mouseOut = value
    }

    private[this] var _mouseOver: FunctionExpression = mouseOver
    def MouseOver = _mouseOver
    def MouseOver_=(value: FunctionExpression) {
        if (_mouseOver == value) return
        json("mouseOver") = value
        _mouseOver = value
    }

    private[this] var _mouseStillDown: FunctionExpression = mouseStillDown
    def MouseStillDown = _mouseStillDown
    def MouseStillDown_=(value: FunctionExpression) {
        if (_mouseStillDown == value) return
        json("mouseStillDown") = value
        _mouseStillDown = value
    }

    private[this] var _mouseUp: FunctionExpression = mouseUp
    def MouseUp = _mouseUp
    def MouseUp_=(value: FunctionExpression) {
        if (_mouseUp == value) return
        json("mouseUp") = value
        _mouseUp = value
    }

    private[this] var _mouseWheel: FunctionExpression = mouseWheel
    def MouseWheel = _mouseWheel
    def MouseWheel_=(value: FunctionExpression) {
        if (_mouseWheel == value) return
        json("mouseWheel") = value
        _mouseWheel = value
    }

    private[this] var _resized: FunctionExpression = resized
    def Resized = _resized
    def Resized_=(value: FunctionExpression) {
        if (_resized == value) return
        json("resized") = value
        _resized = value
    }

    private[this] var _rightMouseDown: FunctionExpression = rightMouseDown
    def RightMouseDown = _rightMouseDown
    def RightMouseDown_=(value: FunctionExpression) {
        if (_rightMouseDown == value) return
        json("rightMouseDown") = value
        _rightMouseDown = value
    }

    private[this] var _setDragTracker: FunctionExpression = setDragTracker
    def SetDragTracker = _setDragTracker
    def SetDragTracker_=(value: FunctionExpression) {
        if (_setDragTracker == value) return
        json("setDragTracker") = value
        _setDragTracker = value
    }

    private[this] var _showContextMenu: FunctionExpression = showContextMenu
    def ShowContextMenu = _showContextMenu
    def ShowContextMenu_=(value: FunctionExpression) {
        if (_showContextMenu == value) return
        json("showContextMenu") = value
        _showContextMenu = value
    }

    def imgHTML(src: String, width: Number = "undefined", height: Number = "undefined", name: String = "undefined", extraStuff: String = "undefined", imgDir: String = "undefined") {
        commandEnqueue(this, s"imgHTML(${src},${width},${height},${name},${extraStuff},${imgDir})")
    }

    def Owner = json.getJsonElement("owner").getOrElse(owner)
    def Owner_=(value: JsonElement) {
        if (Owner == value) return
        json("owner") = value
    }
}
