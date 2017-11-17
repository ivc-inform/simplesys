package io.circe

import com.simplesys.common.Strings._
import com.simplesys.servlet.http.sse._

trait SseServletResponseCirce {
    this: SseServletResponse ⇒

    def SendMessage(data: Json, event: Option[SseEvent], id: Option[SseID], channels: Vector[SseChannel]) {
        val out = Writer

        for (ev <- event)
            if (!out.checkError())
                out write s"event:${ev.serrialize}".newLine

        val _channels = Json.JArray(channels.map(item => Json.JString(item.serrialize)))

        val _data: Json = channels.length match {
            case 0 ⇒
                data
            case _ ⇒
                Json.JObject(JsonObject.fromIterable(Seq("data" -> data, "channels" -> _channels)))
        }

        _data match {
            case Json.JString(string) =>
                val templ = """(.*)(\s*)""".r("line", "spacer")

                for (x <- templ findAllMatchIn string) {
                    if (!out.checkError())
                        out write s"data:${x.group("line")}".newLine
                }

            case Json.JObject(obj) =>
                if (!out.checkError())
                    out write s"data:${obj.toString()}".newLine

            case Json.JArray(list) =>
                if (!out.checkError())
                    out write s"data:${list.toString()}".newLine

            case x@Json.Null =>
                if (!out.checkError())
                    out write s"data:${x.toString()}".newLine

            case any =>
                throw new RuntimeException(s"Bad branch. ${any}")
        }

        for (_id <- id)
            if (!out.checkError())
                out write s"id:${_id.serrialize}".newLine

        if (!out.checkError())
            out write newLine // Чисто для красоты и удобочитаемости

        if (!out.checkError())
            out.flush()
    }

    def SendMessage(data: Json, event: Option[SseEvent], id: Option[String], channels: Json): Unit = {

        val _id: Option[SseID] = id match {
            case None => None
            case Some(string) => Some(SseStringID(string))
        }

        channels match {
            case Json.JArray(channels) ⇒
                val _channels: Vector[SseChannel] = channels.length match {
                    case 0 => Vector.empty[SseChannel]
                    case _ =>
                        channels.map(
                            _ match {
                                case Json.JString(string) => SseStringChannel(string)
                                case any => throw new RuntimeException(s"Bad branch. ${any}")
                            }
                        )
                }

                SendMessage(data = data, event = event, id = _id, channels = _channels)

            case _ ⇒
        }
    }
}
