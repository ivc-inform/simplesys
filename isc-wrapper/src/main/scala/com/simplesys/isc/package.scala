package com.simplesys

import com.simplesys.log.Logging
import com.simplesys.json._
import com.simplesys.isc.system.typesDyn._
import com.simplesys.isc.dataBinging._
import com.simplesys.isc.forms.formItems.{FormItemDyn, ComboBoxItemDyn}
import com.simplesys.isc.RPC.TransactionDyn
import com.simplesys.isc.dataBinging.dataSource.CriteriaDyn
import com.simplesys.isc.system.{ClassDyn, ArrayDyn}
import com.simplesys.json.JsonString
import com.simplesys.isc.system.misc.{URL, Color, CSSStyleName}
import com.simplesys.isc.grids.treeGrid.TreeNodeDyn
import com.simplesys.isc.grids.RecordsDynList
import scala.reflect.ClassTag
import com.simplesys.common.Strings._
import com.simplesys.isc.system.misc.URL
import com.simplesys.json.JsonString
import com.simplesys.isc.system.misc.Color
import com.simplesys.isc.system.misc.CSSStyleName
import com.simplesys.isc.foundation.CanvasDyn
import com.simplesys.isc.foundation.CanvasDyn._


package object isc extends Logging {

    implicit def fromStringToVisibility = new JsonConverter2[JsonString, Visibility] {
        def getValue(x: JsonString): Visibility = Visibility.getObject(x.toString)
    }

    implicit def fromStringToDSOperationType = new JsonConverter2[JsonString, DSOperationType] {
        def getValue(x: JsonString): DSOperationType = DSOperationType.getObject(x.toString)
    }

    implicit def fromStringToFieldType = new JsonConverter2[JsonString, FieldType] {
        def getValue(x: JsonString): FieldType = FieldType.getObject(x.toString)
    }

    implicit def fromJsonObjectToTransactionDyn = new JsonConverter2[JsonObject, TransactionDyn] {
        def getValue(x: JsonObject): TransactionDyn = new TransactionDyn(x)
    }

    implicit def fromJsonObjectToDSRequestDyn = new JsonConverter2[JsonObject, DSRequestDyn] {
        def getValue(x: JsonObject): DSRequestDyn = new DSRequestDyn(x)
    }

    implicit def fromStringToJoinType = new JsonConverter2[JsonString, JoinType] {
        def getValue(x: JsonString): JoinType = JoinType.getObject(x.toString)
    }

    implicit def fromJsonObjectToClassDyn = new JsonConverter2[JsonObject, ClassDyn] {
        def getValue(x: JsonObject): ClassDyn = new ClassDyn(x)
    }

    implicit def fromStringToTimeDisplayFormat = new JsonConverter2[JsonString, TimeDisplayFormat] {
        def getValue(x: JsonString): TimeDisplayFormat = TimeDisplayFormat.getObject(x.toString)
    }

    implicit def fromStringToColor = new JsonConverter2[JsonString, Color] {
        def getValue(x: JsonString): Color = Color(x.toString)
    }

    implicit def fromStringToPreserveOpenState = new JsonConverter2[JsonString, PreserveOpenState] {
        def getValue(x: JsonString): PreserveOpenState = PreserveOpenState.getObject(x.toString)
    }

    implicit def fromStringToDateDisplayFormat = new JsonConverter2[JsonString, DateDisplayFormat] {
        def getValue(x: JsonString): DateDisplayFormat = DateDisplayFormat.getObject(x.toString)
    }

    implicit def fromStringToHiliteIconPosition = new JsonConverter2[JsonString, HiliteIconPosition] {
        def getValue(x: JsonString): HiliteIconPosition = HiliteIconPosition.getObject(x.toString)
    }

    implicit def fromJsonObjectToFormItemDyn = new JsonConverter2[JsonObject, FormItemDyn] {
        def getValue(x: JsonObject): FormItemDyn = new FormItemDyn(x)
    }

    implicit def fromJsonObjectToCriteriaDyn = new JsonConverter2[JsonObject, CriteriaDyn] {
        def getValue(x: JsonObject): CriteriaDyn = new CriteriaDyn(x)
    }

    implicit def fromJsonObjectToDataSourceDyn = new JsonConverter2[JsonObject, DataSourceDyn] {
        def getValue(x: JsonObject): DataSourceDyn = new DataSourceDyn(x)
    }

    implicit def fromStringToListGridFieldType = new JsonConverter2[JsonString, ListGridFieldType] {
        def getValue(x: JsonString): ListGridFieldType = ListGridFieldType.getObject(x.toString)
    }

    implicit def fromStringToValidationMode = new JsonConverter2[JsonString, ValidationMode] {
        def getValue(x: JsonString): ValidationMode = ValidationMode.getObject(x.toString)
    }

    implicit def fromStringToTextMatchStyle = new JsonConverter2[JsonString, TextMatchStyle] {
        def getValue(x: JsonString): TextMatchStyle = TextMatchStyle.getObject(x.toString.unQuoted)
    }

    implicit def fromJsonObjectToResultTreeDyn = new JsonConverter2[JsonObject, ResultTreeDyn] {
        def getValue(x: JsonObject): ResultTreeDyn = new ResultTreeDyn(x)
    }

    implicit def fromJsonObjectToResultSetDyn = new JsonConverter2[JsonObject, ResultSetDyn] {
        def getValue(x: JsonObject): ResultSetDyn = new ResultSetDyn(x)
    }

    implicit def fromJsonObjectToTreeNodeDyn = new JsonConverter2[JsonObject, TreeNodeDyn] {
        def getValue(x: JsonObject): TreeNodeDyn = new TreeNodeDyn(x)
    }

    implicit def fromURLToJsonURL = new JsonConverter2[JsonURL, URL] {
        def getValue(x: JsonURL): URL = x.value
    }

    implicit def fromStringToExportDisplay = new JsonConverter2[JsonString, ExportDisplay] {
        def getValue(x: JsonString): ExportDisplay = ExportDisplay.getObject(x.toString)
    }

    implicit def fromJsonStringToOperatorId = new JsonConverter2[JsonString, OperatorId] {
        def getValue(x: JsonString): OperatorId = OperatorId.getObject(x.toString())
    }

    implicit def fromJsonObjectToCanvasDyn = new JsonConverter2[JsonObject, CanvasDyn] {
        def getValue(x: JsonObject): CanvasDyn = new CanvasDyn(x)
    }

    implicit def fromJsonListToRecordsDynList = new JsonConverter2[JsonList, RecordsDynList] {
        def getValue(x: JsonList): RecordsDynList = {
            val res = RecordsDynList()
            x map {
                item => item match {
                    case jsonObject: JsonObject => res += jsonObject
                    case _ =>
                }
            }
            res
        }
    }

    implicit def fromJsonObjectToDataSourceFieldDyn = new JsonConverter2[JsonObject, DataSourceFieldDyn] {
        def getValue(x: JsonObject): DataSourceFieldDyn = new DataSourceFieldDyn(x)
    }

    implicit def fromJsonListToArrayDynSummaryFunction[T <: ClassDyn : ClassTag] = new JsonConverter2[JsonList, ArrayDyn[T]] {
        def getValue(x: JsonList): ArrayDyn[T] = {
            val res = ArrayDyn.empty[T]
            x foreach {
                _ match {
                    case jsonObject: JsonObject =>
                        res append jsonObject
                    case any =>
                        throw new RuntimeException(s"Bad branch ${any}")
                }
            }
            res
        }
    }

    implicit def fromStringToExportFormat = new JsonConverter2[JsonString, ExportFormat] {
        def getValue(x: JsonString): ExportFormat = ExportFormat.getObject(x.toString)
    }

    implicit def fromStringToRPCTransport = new JsonConverter2[JsonString, RPCTransport] {
        def getValue(x: JsonString): RPCTransport = RPCTransport.getObject(x.toString)
    }

    implicit def fromStringToPromptStyle = new JsonConverter2[JsonString, PromptStyle] {
        def getValue(x: JsonString): PromptStyle = PromptStyle.getObject(x.toString)
    }

    implicit def fromJsonStringToAlignmentDyn = new JsonConverter2[JsonString, AlignmentDyn] {
        def getValue(x: JsonString): AlignmentDyn = AlignmentDyn.getObject(x.toString)
    }

    implicit def fromJsonStringToListGridEditEvent = new JsonConverter2[JsonString, ListGridEditEvent] {
        def getValue(x: JsonString): ListGridEditEvent = ListGridEditEvent.getObject(x)
    }

    implicit def fromJsonObjectToFormItemType = new JsonConverter2[JsonString, FormItemType] {
        def getValue(x: JsonString): FormItemType = FormItemType.getObject(x)
    }

    implicit def fromJsonStringToSelectionStyle = new JsonConverter2[JsonString, SelectionStyle] {
        def getValue(x: JsonString): SelectionStyle = SelectionStyle.getObject(x)
    }

    implicit def fromJsonObjectToautoFitWidthApproach = new JsonConverter2[JsonString, AutoFitWidthApproach] {
        def getValue(x: JsonString): AutoFitWidthApproach = AutoFitWidthApproach.getObject(x)
    }

    implicit def fromJsonStringToSelectionAppearance = new JsonConverter2[JsonString, SelectionAppearance] {
        def getValue(x: JsonString): SelectionAppearance = SelectionAppearance.getObject(x.toString)
    }

    implicit def fromJsonStringToRecordComponentPoolingMode = new JsonConverter2[JsonString, RecordComponentPoolingMode] {
        def getValue(x: JsonString): RecordComponentPoolingMode = RecordComponentPoolingMode.getObject(x.toString)
    }

    implicit def fromJsonStringToFetchMode = new JsonConverter2[JsonString, FetchMode] {
        def getValue(x: JsonString): FetchMode = FetchMode.getObject(x.toString)
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    implicit def TimeDisplayFormatImplicit(timeDisplayFormat: TimeDisplayFormat): JsonString = {
        logger trace (s"update TimeDisplayFormat data ${timeDisplayFormat}")
        JsonString(timeDisplayFormat.toString)
    }

    implicit def CSSStyleNameImplicit(CSSStyleName: CSSStyleName): JsonString = {
        logger trace (s"update CSSStyleName data ${CSSStyleName}")
        JsonString(CSSStyleName.toString)
    }

    implicit def comboBoxItemDynImplicit(comboBoxItemDyn: ComboBoxItemDyn): JsonObject = {
        logger trace (s"update ComboBoxItemDyn data ${comboBoxItemDyn}")
        JsonObject(comboBoxItemDyn)
    }

    implicit def validatorTypeImplicit(validatorType: ValidatorType): JsonString = {
        logger trace (s"update  data ${validatorType}")
        JsonString(validatorType.toString)
    }

    implicit def dateDisplayFormatImplicit(dateDisplayFormat: DateDisplayFormat): JsonString = {
        logger trace (s"update  data ${dateDisplayFormat}")
        JsonString(dateDisplayFormat.toString)
    }

    implicit def hashAlgorithmImplicit(hashAlgorithm: HashAlgorithm): JsonString = {
        logger trace (s"update  data ${hashAlgorithm}")
        JsonString(hashAlgorithm.toString)
    }

    implicit def summaryFunctionImplicit(summaryFunction: SummaryFunction): JsonString = {
        logger trace (s"update  data ${summaryFunction}")
        JsonString(summaryFunction.toString)
    }

    implicit def timeUnitImplicit(timeUnit: TimeUnit): JsonString = {
        logger trace (s"update  data ${timeUnit}")
        JsonString(timeUnit.toString)
    }

    implicit def titleOrientationImplicit(titleOrientation: TitleOrientation): JsonString = {
        logger trace (s"update  data ${titleOrientation}")
        JsonString(titleOrientation.toString)
    }

    implicit def operatorTdImplicit(operatorId: OperatorId): JsonString = {
        logger trace (s"update  data ${operatorId}")
        JsonString(operatorId.toString)
    }

    implicit def multipleAppearancImplicit(multipleAppearanc: MultipleAppearance): JsonString = {
        logger trace (s"update  data ${multipleAppearanc}")
        JsonString(multipleAppearanc.toString)
    }

    implicit def TextMatchStyleImplicit(TextMatchStyle: TextMatchStyle): JsonString = {
        logger trace (s"update  data ${TextMatchStyle}")
        JsonString(TextMatchStyle.toString)
    }

    implicit def animationAccelerationImplicit(animationAcceleration: AnimationAcceleration): JsonString = {
        logger trace (s"update  data ${animationAcceleration}")
        JsonString(animationAcceleration.toString)
    }

    implicit def DragAppearanceImplicit(DragAppearance: DragAppearance): JsonString = {
        logger trace (s"update  data ${DragAppearance}")
        JsonString(DragAppearance.toString)
    }

    implicit def DragIntersectStyleImplicit(DragIntersectStyle: DragIntersectStyle): JsonString = {
        logger trace (s"update  data ${DragIntersectStyle}")
        JsonString(DragIntersectStyle.toString)
    }

    implicit def CursorImplicit(Cursor: Cursor): JsonString = {
        logger trace (s"update  data ${Cursor}")
        JsonString(Cursor.toString)
    }

    implicit def LocatorStrategyImplicit(LocatorStrategy: LocatorStrategy): JsonString = {
        logger trace (s"update  data ${LocatorStrategy}")
        JsonString(LocatorStrategy.toString)
    }

    implicit def LocatorTypeStrategyImplicit(LocatorTypeStrategy: LocatorTypeStrategy): JsonString = {
        logger trace (s"update  data ${LocatorTypeStrategy}")
        JsonString(LocatorTypeStrategy.toString)
    }

    implicit def OverflowImplicit(Overflow: Overflow): JsonString = {
        logger trace (s"update  data ${Overflow}")
        JsonString(Overflow.toString)
    }

    implicit def PositioningImplicit(Positioning: Positioning): JsonString = {
        logger trace (s"update  data ${Positioning}")
        JsonString(Positioning.toString)
    }

    implicit def SnapToImplicit(SnapTo: SnapTo): JsonString = {
        logger trace (s"update  data ${SnapTo}")
        JsonString(SnapTo.toString)
    }

    implicit def VisibilityImplicit(Visibility: Visibility): JsonString = {
        logger trace (s"update  data ${Visibility}")
        JsonString(Visibility.toString)
    }

    implicit def SendMethodImplicit(SendMethod: SendMethod): JsonString = {
        logger trace (s"update  data ${SendMethod}")
        JsonString(SendMethod.toString)
    }

    implicit def ImageStyleImplicit(ImageStyle: ImageStyle): JsonString = {
        logger trace (s"update  data ${ImageStyle}")
        JsonString(ImageStyle.toString)
    }

    implicit def StateImplicit(State: State): JsonString = {
        logger trace (s"update  data ${State}")
        JsonString(State.toString)
    }

    implicit def iconOrientationImplicit(iconOrientation: IconOrientation): JsonString = {
        logger trace (s"update  data ${iconOrientation}")
        JsonString(iconOrientation.toString)
    }

    implicit def selectionTypImplicit(selectionType: SelectionType): JsonString = {
        logger trace (s"update  data ${selectionType}")
        JsonString(selectionType.toString)
    }

    implicit def visibilityModeImplicit(visibilityMode: VisibilityMode): JsonString = {
        logger trace (s"update  data ${visibilityMode}")
        JsonString(visibilityMode.toString)
    }

    implicit def listGridEditEventImplicit(listGridEditEvent: ListGridEditEvent): JsonString = {
        logger trace (s"update  data ${listGridEditEvent}")
        JsonString(listGridEditEvent.toString)
    }

    implicit def enterKeyEditActionImplicit(enterKeyEditAction: EnterKeyEditAction): JsonString = {
        logger trace (s"update  data ${enterKeyEditAction}")
        JsonString(enterKeyEditAction.toString)
    }

    implicit def DragTrackerModeImplicit(dragTrackerMode: DragTrackerMode): JsonString = {
        logger trace (s"update  data ${dragTrackerMode}")
        JsonString(dragTrackerMode.toString)
    }

    implicit def expansionModeImplicit(expansionMode: ExpansionMode): JsonString = {
        logger trace (s"update  data ${expansionMode}")
        JsonString(expansionMode.toString)
    }

    implicit def hoverModeImplicit(hoverMode: HoverMode): JsonString = {
        logger trace (s"update  data ${hoverMode}")
        JsonString(hoverMode.toString)
    }

    implicit def autoFitEventImplicit(autoFitEvent: AutoFitEvent): JsonString = {
        logger trace (s"update  data ${autoFitEvent}")
        JsonString(autoFitEvent.toString)
    }

    implicit def recordComponentPoolingModeImplicit(recordComponentPoolingMode: RecordComponentPoolingMode): JsonString = {
        logger trace (s"update  data ${recordComponentPoolingMode}")
        JsonString(recordComponentPoolingMode.toString)
    }

    implicit def embeddedPositionImplicit(embeddedPosition: EmbeddedPosition): JsonString = {
        logger trace (s"update  data ${embeddedPosition}")
        JsonString(embeddedPosition.toString)
    }

    implicit def rowEndEditActionImplicit(rowEndEditAction: RowEndEditAction): JsonString = {
        logger trace (s"update  data ${rowEndEditAction}")
        JsonString(rowEndEditAction.toString)
    }

    implicit def escapeKeyEditActionImplicit(escapeKeyEditAction: EscapeKeyEditAction): JsonString = {
        logger trace (s"update  data ${escapeKeyEditAction}")
        JsonString(escapeKeyEditAction.toString)
    }

    implicit def sortArrowImplicit(sortArrow: SortArrow): JsonString = {
        logger trace (s"update  data ${sortArrow}")
        JsonString(sortArrow.toString)
    }

    implicit def selectionStyleImplicit(selectionStyle: SelectionStyle): JsonString = {
        logger trace (s"update  data ${selectionStyle}")
        JsonString(selectionStyle.toString)
    }

    implicit def selectionAppearanceImplicit(selectionAppearance: SelectionAppearance): JsonString = {
        logger trace (s"update  data ${selectionAppearance}")
        JsonString(selectionAppearance.toString)
    }

    implicit def chartTypeImplicit(chartType: ChartType): JsonString = {
        logger trace (s"update  data ${chartType}")
        JsonString(chartType.toString)
    }

    implicit def autoFitWidthApproachImplicit(autoFitWidthApproach: AutoFitWidthApproach): JsonString = {
        logger trace (s"update  data ${autoFitWidthApproach}")
        JsonString(autoFitWidthApproach.toString)
    }

    implicit def autoFitIconFieldTypeImplicit(autoFitIconFieldType: AutoFitIconFieldType): JsonString = {
        logger trace (s"update  data ${autoFitIconFieldType}")
        JsonString(autoFitIconFieldType.toString)
    }

    implicit def dragDataActionImplicit(dragDataAction: DragDataAction): JsonString = {
        logger trace (s"update  data ${dragDataAction}")
        JsonString(dragDataAction.toString)
    }

    implicit def tableModeImplicit(tableMode: TableMode): JsonString = {
        logger trace (s"update  data ${tableMode}")
        JsonString(tableMode.toString)
    }

    implicit def PreserveOpenStateImplicit(PreserveOpenState: PreserveOpenState): JsonString = {
        logger trace (s"update PreserveOpenState data ${PreserveOpenState}")
        JsonString(PreserveOpenState.toString)
    }

    implicit def displayNodeTypeImplicit(displayNodeType: DisplayNodeType): JsonString = {
        logger trace (s"update DisplayNodeType data ${displayNodeType}")
        JsonString(displayNodeType.toString)
    }

    implicit def hiliteIconPositionImplicit(hiliteIconPosition: HiliteIconPosition): JsonString = {
        logger trace (s"update HiliteIconPosition data ${hiliteIconPosition}")
        JsonString(hiliteIconPosition.toString)
    }

    implicit def recordSummaryFunctionImplicit(recordSummaryFunction: RecordSummaryFunction): JsonString = {
        logger trace (s"update RecordSummaryFunction data ${recordSummaryFunction}")
        JsonString(recordSummaryFunction.toString)
    }

    implicit def SortDirectionImplicit(SortDirection: SortDirection): JsonString = {
        logger trace (s"update SortDirection data ${SortDirection}")
        JsonString(SortDirection.toString)
    }

    implicit def ListGridFieldTypeImplicit(ListGridFieldType: ListGridFieldType): JsonString = {
        logger trace (s"update ListGridFieldType data ${ListGridFieldType}")
        JsonString(ListGridFieldType.toString)
    }

    implicit def SideImplicit(Side: Side): JsonString = {
        logger trace (s"update Side data ${Side}")
        JsonString(Side.toString)
    }

    implicit def TabTitleEditEventImplicit(TabTitleEditEvent: TabTitleEditEvent): JsonString = {
        logger trace (s"update TabTitleEditEvent data ${TabTitleEditEvent}")
        JsonString(TabTitleEditEvent.toString)
    }

    implicit def ContentLayoutImplicit(ContentLayout: ContentLayout): JsonString = {
        logger trace (s"update ContentLayout data ${ContentLayout}")
        JsonString(ContentLayout.toString)
    }

    implicit def LayoutPolicyImplicit(LayoutPolicy: LayoutPolicy): JsonString = {
        logger trace (s"update LayoutPolicy data ${LayoutPolicy}")
        JsonString(LayoutPolicy.toString)
    }

    implicit def TreeModelTypeImplicit(TreeModelType: TreeModelType): JsonString = {
        logger trace (s"update TreeModelType data ${TreeModelType}")
        JsonString(TreeModelType.toString)
    }

    implicit def NavigationDirectionImplicit(NavigationDirection: NavigationDirection): JsonString = {
        logger trace (s"update NavigationDirection data ${NavigationDirection}")
        JsonString(NavigationDirection.toString)
    }

    implicit def OrientationImplicit(Orientation: Orientation): JsonString = {
        logger trace (s"update Orientation data ${Orientation}")
        JsonString(Orientation.toString)
    }

    implicit def LayoutResizeBarPolicyImplicit(LayoutResizeBarPolicy: LayoutResizeBarPolicy): JsonString = {
        logger trace (s"update LayoutResizeBarPolicy data ${LayoutResizeBarPolicy}")
        JsonString(LayoutResizeBarPolicy.toString)
    }

    implicit def TileLayoutPolicyImplicit(TileLayoutPolicy: TileLayoutPolicy): JsonString = {
        logger trace (s"update TileLayoutPolicy data ${TileLayoutPolicy}")
        JsonString(TileLayoutPolicy.toString)
    }

    implicit def RecordLayoutImplicit(RecordLayout: RecordLayout): JsonString = {
        logger trace (s"update RecordLayout data ${RecordLayout}")
        JsonString(RecordLayout.toString)
    }

    implicit def NavigationModeImplicit(NavigationMode: NavigationMode): JsonString = {
        logger trace (s"update NavigationMode data ${NavigationMode}")
        JsonString(NavigationMode.toString)
    }

    implicit def CharacterCasingImplicit(CharacterCasing: CharacterCasing): JsonString = {
        logger trace (s"update CharacterCasing data ${CharacterCasing}")
        JsonString(CharacterCasing.toString)
    }

    implicit def TestAreaWrapImplicit(TestAreaWrap: TestAreaWrap): JsonString = {
        logger trace (s"update TestAreaWrap data ${TestAreaWrap}")
        JsonString(TestAreaWrap.toString)
    }

    implicit def RelativeDateRangePositionImplicit(RelativeDateRangePosition: RelativeDateRangePosition): JsonString = {
        logger trace (s"update RelativeDateRangePosition data ${RelativeDateRangePosition}")
        JsonString(RelativeDateRangePosition.toString)
    }

    implicit def FetchModeImplicit(FetchMode: FetchMode): JsonString = {
        logger trace (s"update FetchMode data ${FetchMode}")
        JsonString(FetchMode.toString)
    }

    implicit def PercentBoxModelImplicit(PercentBoxModel: PercentBoxModel): JsonString = {
        logger trace (s"update PercentBoxModel data ${PercentBoxModel}")
        JsonString(PercentBoxModel.toString)
    }

    implicit def AutofitImplicit(Autofit: Autofit): JsonString = {
        logger trace (s"update Autofit data ${Autofit}")
        JsonString(Autofit.toString)
    }

    implicit def DrawPositionImplicit(DrawPosition: DrawPosition): JsonString = {
        logger trace (s"update DrawPosition data ${DrawPosition}")
        JsonString(DrawPosition.toString)
    }

    implicit def FormItemTypeImplicit(FormItemType: FormItemType): JsonString = {
        logger trace (s"update FormItemType data ${FormItemType}")
        JsonString(FormItemType.toString)
    }

    implicit def DateItemSelectorFormatImplicit(DateItemSelectorFormat: DateItemSelectorFormat): JsonString = {
        logger trace (s"update DateItemSelectorFormat data ${DateItemSelectorFormat}")
        JsonString(DateItemSelectorFormat.toString)
    }

    implicit def TopOperatorAppearanceImplicit(TopOperatorAppearance: TopOperatorAppearance): JsonString = {
        logger trace (s"update TopOperatorAppearance data ${TopOperatorAppearance}")
        JsonString(TopOperatorAppearance.toString)
    }

    implicit def LogicalOperatorImplicit(LogicalOperator: LogicalOperator): JsonString = {
        logger trace (s"update LogicalOperator data ${LogicalOperator}")
        JsonString(LogicalOperator.toString)
    }

    implicit def DSOperationTypeImplicit(DSOperationType: DSOperationType): JsonString = {
        logger trace (s"update DSOperationType data ${DSOperationType}")
        JsonString(DSOperationType.toString)
    }


    implicit def FormLayoutTypeImplicit(FormLayoutType: FormLayoutType): JsonString = {
        logger trace (s"update FormLayoutType data ${FormLayoutType}")
        JsonString(FormLayoutType.toString)
    }

    implicit def FormMethodImplicit(FormMethod: FormMethod): JsonString = {
        logger trace (s"update FormMethod data ${FormMethod}")
        JsonString(FormMethod.toString)
    }

    implicit def EncodingImplicit(Encoding: Encoding): JsonString = {
        logger trace (s"update Encoding data ${Encoding}")
        JsonString(Encoding.toString)
    }

    implicit def SQLTypeImplicit(SQLType: SQLType): JsonString = {
        logger trace (s"update SQLType data ${SQLType}")
        JsonString(SQLType.toString)
    }

    implicit def SQLPagingStrategyImplicit(SQLPagingStrategy: SQLPagingStrategy): JsonString = {
        logger trace (s"update SQLPagingStrategy data ${SQLPagingStrategy}")
        JsonString(SQLPagingStrategy.toString)
    }

    implicit def ExportFormatImplicit(ExportFormat: ExportFormat): JsonString = {
        logger trace (s"update ExportFormat data ${ExportFormat}")
        JsonString(ExportFormat.toString)
    }

    implicit def RPCTransportImplicit(RPCTransport: RPCTransport): JsonString = {
        logger trace (s"update RPCTransport data ${RPCTransport}")
        JsonString(RPCTransport.toString)
    }

    implicit def DSProtocolImplicit(DSProtocol: DSProtocol): JsonString = {
        logger trace (s"update DSProtocol data ${DSProtocol}")
        JsonString(DSProtocol.toString)
    }

    implicit def DSDataFormatImplicit(DSDataFormat: DSDataFormat): JsonString = {
        logger trace (s"update DSDataFormat data ${DSDataFormat}")
        JsonString(DSDataFormat.toString)
    }

    implicit def CriteriaPolicyImplicit(CriteriaPolicy: CriteriaPolicy): JsonString = {
        logger trace (s"update CriteriaPolicy data ${CriteriaPolicy}")
        JsonString(CriteriaPolicy.toString)
    }

    implicit def JSONInstanceSerializationModeImplicit(JSONInstanceSerializationMode: JSONInstanceSerializationMode): JsonString = {
        logger trace (s"update JSONInstanceSerializationMode data ${JSONInstanceSerializationMode}")
        JsonString(JSONInstanceSerializationMode.toString)
    }

    implicit def JSONDateFormatImplicit(JSONDateFormat: JSONDateFormat): JsonString = {
        logger trace (s"update JSONDateFormat data ${JSONDateFormat}")
        JsonString(JSONDateFormat.toString)
    }

    implicit def JSONCircularReferenceModeImplicit(JSONCircularReferenceMode: JSONCircularReferenceMode): JsonString = {
        logger trace (s"update JSONCircularReferenceMode data ${JSONCircularReferenceMode}")
        JsonString(JSONCircularReferenceMode.toString)
    }

    implicit def JoinTypeImplicit(JoinType: JoinType): JsonString = {
        logger trace (s"update JoinType data ${JoinType}")
        JsonString(JoinType.toString)
    }

    implicit def EnumTranslateStrategyImplicit(EnumTranslateStrategy: EnumTranslateStrategy): JsonString = {
        logger trace (s"update EnumTranslateStrategy data ${EnumTranslateStrategy}")
        JsonString(EnumTranslateStrategy.toString)
    }

    implicit def DSServerTypeImplicit(DSServerType: DSServerType): JsonString = {
        logger trace (s"update DSServerType data ${DSServerType}")
        JsonString(DSServerType.toString)
    }

    implicit def ValidationModeImplicit(ValidationMode: ValidationMode): JsonString = {
        logger trace (s"update ValidationMode data ${ValidationMode}")
        JsonString(ValidationMode.toString)
    }

    implicit def ExportDisplayImplicit(ExportDisplay: ExportDisplay): JsonString = {
        logger trace (s"update ExportDisplay data ${ExportDisplay}")
        JsonString(ExportDisplay.toString)
    }

    implicit def MenuAnimationEffectImplicit(MenuAnimationEffect: MenuAnimationEffect): JsonString = {
        logger trace (s"update MenuAnimationEffect data ${MenuAnimationEffect}")
        JsonString(MenuAnimationEffect.toString)
    }

    implicit def IconButtonOrientationImplicit(IconButtonOrientation: IconButtonOrientation): JsonString = {
        logger trace (s"update IconButtonOrientation data ${IconButtonOrientation}")
        JsonString(IconButtonOrientation.toString)
    }

    implicit def ViewNameImplicit(ViewName: ViewName): JsonString = {
        logger trace (s"update ViewName data ${ViewName}")
        JsonString(ViewName.toString)
    }

    implicit def LookupStyleImplicit(LookupStyle: LookupStyle): JsonString = {
        logger trace (s"update LookupStyle data ${LookupStyle}")
        JsonString(LookupStyle.toString)
    }

    implicit def AttributeScopeImplicit(AttributeScope: AttributeScope): JsonString = {
        logger trace (s"update AttributeScope data ${AttributeScope}")
        JsonString(AttributeScope.toString)
    }

    implicit def PromptStyleImplicit(PromptStyle: PromptStyle): JsonString = {
        logger trace (s"update PromptStyle data ${PromptStyle}")
        JsonString(PromptStyle.toString)
    }

    implicit def GroupStartOpenImplicit(GroupStartOpen: GroupStartOpen): JsonString = {
        logger trace (s"update GroupStartOpen data ${GroupStartOpen}")
        JsonString(GroupStartOpen.toString)
    }

    implicit def ListGridComponentImplicit(ListGridComponent: ListGridComponent): JsonString = {
        logger trace (s"update ListGridComponent data ${ListGridComponent}")
        JsonString(ListGridComponent.toString)
    }

    implicit def AlignmentDynImplicit(AlignmentDyn: AlignmentDyn): JsonString = {
        logger trace (s"update AlignmentDyn data ${AlignmentDyn}")
        JsonString(AlignmentDyn.toString)
    }

    implicit def FieldTypeImplicit(FieldType: FieldType): JsonString = {
        logger trace (s"update FieldType data ${FieldType}")
        JsonString(FieldType.toString)
    }

    implicit class StrOpts(string: String) {
        def fwdSlash = string + "/"
    }

}
