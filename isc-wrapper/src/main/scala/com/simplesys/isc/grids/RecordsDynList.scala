
package com.simplesys.isc.grids

import com.simplesys.log.Logging
import collection.mutable.ArrayBuffer
import com.simplesys.json.{JsonFormatter, JsonElement, JsonList}
import com.simplesys.isc.dataBinging.dataSource.RecordDyn
import com.simplesys.isc.system.ArrayDyn

object RecordsDynList extends Logging {
    def apply(treeNodes: RecordDyn*): RecordsDynList = {
        val res = new RecordsDynList(ArrayBuffer.empty[JsonElement])

        logger trace "//////////////////////////// RecordsList ///////////////////////////////////////////"
        treeNodes foreach (item => logger trace (s"Record: ${item}"))
        logger trace "//////////////////////////// RecordsList End///////////////////////////////////////////"
        treeNodes foreach (res += _)
        res
    }

    def apply(): RecordsDynList = new RecordsDynList()

    implicit def RecordsList2Proxy(in: RecordsDynList): ArrayBuffer[JsonElement] = in proxy

    implicit def RecordsList2JsonList(in: RecordsDynList): JsonList = new JsonList
}

class RecordsDynList(override protected val proxy: ArrayBuffer[JsonElement]) extends ArrayDyn[RecordDyn](proxy) {
    def this() = this(ArrayBuffer.empty[JsonElement])

    override def distinct: RecordsDynList = new RecordsDynList(proxy.distinct)
    def +=(record: RecordDyn) {
        proxy += record
    }

    def ++=(records: RecordDyn*) {
        records foreach += _
    }

    override def toString: String = super.toString
}

