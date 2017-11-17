package com.simplesys

import java.sql.Timestamp
import java.time.LocalDateTime

import _root_.doobie.util.meta.Meta

package object doobie {
    implicit val localDateTimeMeta: Meta[LocalDateTime] =
        Meta[Timestamp].nxmap(
            (timestamp) ⇒
                timestamp.toLocalDateTime,
            (localDateTime) ⇒
                Timestamp valueOf localDateTime
        )
}
