package com.simplesys.isc.config

import com.simplesys.isc.system.misc.Bool

trait StoredData {
  def getStoredData(sectionName: String, defValue: String): String = defValue
  def getStoredData(sectionName: String, defValue: Number): Number = defValue
  def getStoredData(sectionName: String, defValue: Bool): Bool = defValue
}