package com.simplesys.slick.oracle

import java.sql.Timestamp
import java.time.LocalDateTime

package object time {
    val profile = slick.jdbc.OracleProfile
    import profile.api._

    implicit val localDateToDate = MappedColumnType.base[LocalDateTime, Timestamp](
        l => Timestamp.valueOf(l),
        d => d.toLocalDateTime
    )
}
