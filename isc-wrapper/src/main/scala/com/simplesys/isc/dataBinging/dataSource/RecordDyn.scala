package com.simplesys.isc.dataBinging.dataSource

import com.simplesys.isc.system.ClassDyn
import com.simplesys.json._
import scala.Some
import com.simplesys.isc.system.global.RuntimeIscException
import com.simplesys.log.Logging

object RecordDyn extends Logging {

    implicit def unWrap(array: Array[String]): Option[JsonElement] = if (array.size == 0) None else Some(JsonString(array.head))

    def apply(seq: (String, Option[JsonElement])*) = {
        val _seq: Seq[String] = seq.map {
            case (key, _) => key
        }

        if (_seq.distinct.length != seq.length)
            throw new RuntimeException(s"Sequence: ${_seq.mkString("(", ", ", ")")} have dublicated key.")

        val res = new RecordDyn()
        seq foreach {
            item =>
                logger trace (s"Item: ${item}")
                item match {
                    case (key, Some(value: JsonElement)) =>
                        res update(key, value)
                    case (key, None) =>
                        res update(key, JsonRemove)
                    case x => throw new RuntimeIscException("Unknown case: %s".format(x))
                }
        }
        res
    }
}

class RecordDyn(override val inJson: JsonObject = null,
                override val useSelfName: Boolean = false) extends ClassDyn {

    def this(seq: (String, JsonElement)*) = this(JsonObject(), false)
    def this(useSelfName: Boolean) = this(JsonObject(), useSelfName)
    def this() = this(JsonObject(), false)

    //seq foreach (json += _)
}