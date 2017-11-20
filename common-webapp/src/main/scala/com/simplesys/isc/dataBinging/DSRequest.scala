package com.simplesys.isc.dataBinging

import io.circe.{HCursor, Json}

case class DSRequest(request: Json) extends CirceHelper{
    private val cursor: HCursor = request.hcursor
    
}
