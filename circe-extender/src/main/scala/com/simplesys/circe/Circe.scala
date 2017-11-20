package com.simplesys.circe

import io.circe.{HCursor, Json}

object Circe {
    implicit class CirceOpt(json: Json) {
        def toPrettyString = json.spaces4

        val cursor: HCursor = json.hcursor
    }
}
