package com.simplesys.isc.dataBinging

import com.simplesys.isc.system.misc._
import com.simplesys.isc.system.ArrayDyn
import dataSource.OperationBindingDyn
import com.simplesys.json.JsonNull

trait RestDataSourceDynInit extends DataSourceDynInit {
  protected val disableQueuing: Bool = false
  private[dataBinging] val fetchDataURL: URL = null
  private[dataBinging] val addDataURL: URL = null
  override protected val jsonPrefix: String = """<SCRIPT>//'\"]]>>isc_JSONResponseStart>>"""
  protected val jsonRecordXPath: XPathExpression = "/response/data"
  override protected val jsonSuffix: String = """//isc_JSONResponseEnd""""
  protected val metaDataPrefix: String = "_"
  protected val prettyPrintJSON: Bool = true
  private[dataBinging] val removeDataURL: URL = null
  protected val sendMetaData: Bool = true
  private[dataBinging] val updateDataURL: URL = null
  protected val xmlRecordXPath: XPathExpression = "/response/data/*"
}