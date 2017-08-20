package com.simplesys

import java.sql.Timestamp

import _root_.doobie.util.meta.Meta

package object doobie {
    implicit val localDateTimeMeta: Meta[org.joda.time.LocalDateTime] =
        Meta[java.sql.Timestamp].nxmap(
            (timestamp) => new org.joda.time.LocalDateTime(timestamp.getTime),
            (localDateTime) =>
                new java.sql.Timestamp(localDateTime.toDateTime.getMillis)
        )

    implicit val dateTimeMeta: Meta[org.joda.time.DateTime] = Meta[java.sql.Timestamp].nxmap(
        (timestamp) => new org.joda.time.DateTime(timestamp.getTime),
        (dateTime) => new java.sql.Timestamp(dateTime.getMillis)
    )


    /*implicit val localDateTimeMeta1: Meta[java.time.LocalDateTime] =
        Meta[java.sql.Timestamp].nxmap(
            (timestamp) => new java.time.LocalDateTime(timestamp.getTime),
            (localDateTime) => Timestamp.valueOf(localDateTime)
        )*/
}
