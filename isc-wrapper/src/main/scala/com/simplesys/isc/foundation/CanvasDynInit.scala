package com.simplesys.isc.foundation

import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.system.misc._
import com.simplesys.json._
import com.simplesys.isc.forms.formItems.CanvasItemDyn
import com.simplesys.isc.forms.ValuesManagerDyn
import com.simplesys.isc.config.StoredData
import com.simplesys.isc.system.ArrayDyn
import com.simplesys.isc.system.misc.URL
import com.simplesys.isc.system.misc.XPathExpression
import com.simplesys.isc.system.misc.Number
import com.simplesys.json.UnquotedString
import com.simplesys.isc.system.misc.Bool
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName

trait CanvasDynInit extends StoredData {
    protected val accessKey: String = getStoredData(sectionName = "accessKey", defValue = "")
    protected val animateAcceleration: AnimationAcceleration = anAcsSmoothEnd
    protected val animateFadeTime: Number = null
    protected val animateHideAcceleration: AnimationAcceleration = anAcsNull
    protected val animateHideEffect: String = ""
    protected val animateHideTime: Number = null
    protected val animateMoveAcceleration: AnimationAcceleration = anAcsNull
    protected val animateMoveTime: Number = null
    protected val animateRectAcceleration: AnimationAcceleration = anAcsNull
    protected val animateRectTime: Number = null
    protected val animateResizeAcceleration: AnimationAcceleration = anAcsNull
    protected val animateResizeTime: Number = null
    protected val animateScrollAcceleration: AnimationAcceleration = anAcsNull
    protected val animateScrollTime: Number = null
    protected val animateShowAcceleration: AnimationAcceleration = anAcsNull
    protected val animateShowEffect: String = ""
    protected val animateShowTime: Number = null
    protected val animateTime: Number = null
    private[foundation] val appImgDir: URL = null
    protected val ariaRole: String = ""
    protected val autoDraw: Bool = true
    protected val autoShowParent: Bool = true
    protected val backgroundColor: Color = ""
    protected val backgroundImage: SCImgURL = JsonNull
    protected val backgroundPosition: String = ""
    protected val backgroundRepeat: String = "repeat"
    protected val border: String = ""
    protected val canAcceptDrop: Bool = false
    protected val canDrag: Bool = false
    protected val canDragReposition: Bool = false
    protected val canDragResize: Bool = false
    protected val canDragScroll: Bool = true
    protected val canDrop: Bool = false
    protected val canDropBefore: Bool = false
    protected val canFocus: Bool = false
    protected val canHover: Bool = null
    protected val canSelectText: Bool = false
    protected val canvasItem: CanvasItemDyn = null
    protected val children: ArrayDyn[CanvasDyn] = null
    protected val childrenSnapResizeToGrid: Bool = false
    protected val childrenSnapToGrid: Bool = false
    protected val className: CSSStyleName = "normal"
    protected val click: FunctionExpression = null
    protected val contents: JsonElement = JsonNull
    protected val contextMenu: JsonElement = JsonNull
    protected val cursor: Cursor = crDefault
    protected val customEdges: Strings = null
    protected val dataPath: XPathExpression = ""
    protected val defaultHeight: Number = 100
    protected val defaultWidth: Number = 100
    protected val destroyed: Bool = false
    protected val destroying: Bool = false
    protected val disabled: Bool = false
    protected val disabledCursor: Cursor = crDefault
    protected val doubleClickDelay: Number = 250
    protected val dragAppearance: DragAppearance = drAprncOutline
    protected val dragIntersectStyle: DragIntersectStyle = drgInspStlMouse
    protected val dragOpacity: Number = null
    protected val dragRepositionAppearance: DragAppearance = drAprncNull
    protected val dragRepositionCursor: Cursor = crMove
    protected val dragResizeAppearance: DragAppearance = drAprncNull
    protected val dragScrollDelay: Number = 100
    protected val dragStartDistance: Number = 5
    protected val dragTarget: CanvasDyn = null
    protected val dragType: String = ""
    protected val draw: FunctionExpression = null
    protected val dropTypes: JsonElement = JsonNull
    protected val dynamicContents: Bool = false
    protected val dynamicContentsVars: JsonList = null
    protected val edgeBackgroundColor: Color = ""
    protected val edgeCenterBackgroundColor: Color = ""
    protected val edgeCursorMap: JsonObject = JsonObject()
    protected val edgeImage: SCImgURL = "[SKIN]edge.gif"
    protected val edgeMarginSize: Number = 5
    protected val edgeOffset: Number = null
    protected val edgeOpacity: Number = null
    protected val edgeShowCenter: Bool = false
    protected val edgeSize: Number = 10
    protected val enabled: Bool = null
    protected val extraSpace: Number = 0
    protected val height: Number = null
    protected val hover: FunctionExpression = null
    protected val hoverAlign: AlignmentDyn = AlNull
    protected val hoverAutoDestroy: Bool = false
    protected val hoverDelay: Number = 300
    protected val hoverHeight: Number = null
    protected val hoverMoveWithMouse: Bool = false
    protected val hoverOpacity: Number = null
    protected val hoverStyle: CSSStyleName = ""
    protected val hoverVAlign: AlignmentDyn = ValAll
    protected val hoverWidth: Number = null
    protected val hoverWrap: Bool = false
    protected val htmlElement: HTMLString = ""
    protected val htmlPosition: DrawPosition = drvPsAfterBegin
    protected val initWidget: FunctionExpression = null
    protected val id: String = ""
    protected val keepInParentRect: JsonElement = JsonNull
    protected val keyDown: FunctionExpression = null
    protected val keyPress: FunctionExpression = null
    protected val keyUp: FunctionExpression = null
    protected val layoutAlign: AlignmentDyn = null
    protected val left: Number = 0
    protected val loadingImageSize: Number = 16
    protected val locateChildrenBy: LocatorStrategy = lcStrgNull
    protected val locateChildrenType: LocatorTypeStrategy = lctTpStrgNull
    protected val locatePeersBy: LocatorStrategy = lcStrgNull
    protected val locatePeersType: LocatorTypeStrategy = lctTpStrgNull
    protected val margin: Number = null
    protected val masterElement: CanvasDyn = null
    protected val matchElement: Bool = false
    protected val maxHeight: Number = 10000
    protected val maxWidth: Number = 10000
    protected val menuConstructor: CSSStyleName = "Menu"
    protected val minHeight: Number = 10
    protected val minWidth: Number = 10
    protected val mouseDown: FunctionExpression = null
    protected val mouseMove: FunctionExpression = null
    protected val mouseOut: FunctionExpression = null
    protected val mouseOver: FunctionExpression = null
    protected val mouseStillDown: FunctionExpression = null
    protected val mouseStillDownDelay: Number = 100
    protected val mouseStillDownInitialDelay: Number = 400
    protected val mouseUp: FunctionExpression = null
    protected val mouseWheel: FunctionExpression = null
    protected val noDoubleClicks: Bool = false
    protected val opacity: Number = null
    protected val overflow: Overflow = ovVisible
    protected val padding: Number = null
    protected val parentElement: CanvasDyn = null
    protected val peers: ArrayDyn[CanvasDyn] = null
    protected val percentBox: PercentBoxModel = prBxMdVisible
    protected val percentSource: CanvasDyn = null
    protected val position: Positioning = pstNull
    protected val prompt: HTMLString = ""
    protected val redrawOnResize: Bool = true
    protected val resizeBarTarget: String = ""
    protected val resized: FunctionExpression = null
    protected val resizeFrom: JsonList = JsonList()
    protected val rightMouseDown: FunctionExpression = null
    protected val scrollbarSize: Number = 16
    protected val setDragTracker: FunctionExpression = null
    protected val shadowDepth: Number = 4
    protected val shadowImage: String = "[SKIN]ds.png"
    protected val shadowOffset: Number = null
    protected val shadowSoftness: Number = null
    protected val shouldPrint: Bool = false
    protected val showContextMenu: FunctionExpression = null
    protected val showCustomScrollbars: Bool = true
    protected val showDragShadow: Bool = false
    protected val showEdges: Bool = false
    protected val showHover: Bool = true
    protected val showHoverComponents: Bool = false
    protected val showResizeBar: Bool = false
    protected val showShadow: Bool = false
    protected val skinImgDir: URL = "images/".url
    protected val snapAxis: String = "both"
    protected val snapEdge: String = ""
    protected val snapHDirection: String = "after"
    protected val snapHGap: Number = 20
    protected val snapOffsetLeft: Number = null
    protected val snapOffsetTop: Number = null
    protected val snapOnDrop: Bool = true
    protected val snapResizeToGrid: Bool = false
    protected val snapTo: SnapTo = sntNone
    protected val snapToGrid: Bool = false
    protected val snapVDirection: String = "after"
    protected val snapVGap: Number = 20
    protected val styleName: CSSStyleName = "normal"
    protected val tabIndex: Number = null
    protected val top: Number = 0
    protected val topElement: CanvasDyn = null
    protected val useOpacityFilter: Bool = false
    protected val valuesManager: ValuesManagerDyn = null
    protected val visibility: Visibility = vsInherit
    protected val visibilityChanged: FunctionExpression = null
    protected val width: Number = null
    private[foundation] val owner: JsonElement = JsonNull
}