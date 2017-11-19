package com.simplesys.isc.dataBinging

trait CirceHelper {
    this: DSRequest ⇒
    def toPrettyString = request.spaces4
}
