package com.simplesys.isc.system.global

import java.util.UUID._


trait Uuid {
  val guid = ("id-" + randomUUID toString) toUpperCase
}
