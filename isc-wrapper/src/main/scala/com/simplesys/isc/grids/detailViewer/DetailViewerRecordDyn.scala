package com.simplesys.isc.grids.detailViewer

import com.simplesys.json.JsonObject
import com.simplesys.isc.dataBinging.dataSource.RecordDyn

object DetailViewerRecordDyn {

  implicit def DetailViewerRecordtoJsonObject(in: DetailViewerRecordDyn): JsonObject = in json
}

class DetailViewerRecordDyn extends RecordDyn
