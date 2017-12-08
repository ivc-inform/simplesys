package com.simplesys.slick.oracle

import java.sql.Timestamp
import java.time.{LocalDate, LocalDateTime, ZonedDateTime}

package object time {
    val profile = slick.jdbc.OracleProfile

    import profile.api._

    implicit val localDateToDate = MappedColumnType.base[LocalDateTime, Timestamp](
        l => Timestamp.valueOf(l),
        d => d.toLocalDateTime
    )

    implicit val javaLocalDateMeta = MappedColumnType.base[LocalDate, Timestamp](
        ldt => Timestamp.valueOf(ldt.atStartOfDay()),
        t => t.toLocalDateTime.toLocalDate,
    )


    implicit val javaDateTimeMeta = MappedColumnType.base[ZonedDateTime, Timestamp](
        (dt) => java.sql.Timestamp.valueOf(dt.toLocalDateTime),
        (t) => t.toLocalDateTime.atZone(java.time.ZoneOffset.UTC)
    )
}
