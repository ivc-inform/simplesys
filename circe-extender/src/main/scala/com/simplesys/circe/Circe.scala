package com.simplesys.circe

import io.circe.Json

object Circe {
    implicit class CirceOpt(json: Json) {
        def toPrettyString = json.spaces4
    }
}
