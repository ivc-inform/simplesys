package io.circe

import com.simplesys.servlet.http.sse.SseServletRequest
import io.circe.parser.parse
import io.circe.Json._

trait SseServletRequestCirce {
    this: SseServletRequest ⇒

    def SubscribedChannels: Set[String] = Parameter("subscribedChannels") match {
        case None =>
            Set.empty[String]
        case Some(subscribedChannels) =>
            parse(subscribedChannels).getOrElse(Json.Null)
            match {
                case Json.Null ⇒
                    Set.empty[String]
                case JArray(array) ⇒
                    Set(array.toString())
                case _ ⇒
                    Set.empty[String]
            }
    }
}
