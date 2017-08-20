package com.simplesys.json

import java.io.{File, InputStream}
import java.net.{URI, URL}

import com.simplesys.isc.system.misc.Misc
import com.simplesys.log.Logging
import io.Source
import io.Codec._

object Json extends JsonParser with Misc with Logging {
    def logError(msg: NoSuccess): Nothing = {
        logger error (s"Error parsing : ${msg}")
        throw new Throwable()
    }

    def logError(msg: String): Nothing = {
        logger error (s"Error parsing : ${msg}")
        throw new Throwable()
    }

    def apply(inputString: String = "", selfName: String = selfName, useSelfName: Boolean = useSelfName): JsonObject = {
        logger trace s"inputString: $inputString"
        new JsonObject(Json(inputString), selfName, useSelfName)
    }

    def apply(inputString: String): JsonObject = {
        logger trace s"inputString: $inputString"

        inputString trim match {
            case "" => JsonObject()
            case _ =>
                parseAll(jsonValue, inputString) match {
                    case Success(result: JsonObject, _) => result
                    case failure: NoSuccess => logError(failure)
                    case _ => logError(s"No matched result")
                }
        }
    }

    def apply(inputString: String, any: Any): JsonList = {
            logger trace s"inputString: $inputString"

            inputString trim match {
                case "" => JsonList()
                case _ =>
                    parseAll(jsonValue, inputString) match {
                        case Success(result: JsonList, _) => result
                        case failure: NoSuccess => logError(failure)
                        case _ => logError(s"No matched result")
                    }
            }
        }

    def getJsonOpt(inputString: String): Option[JsonObject] = {
            logger trace s"inputString: $inputString"
            inputString trim match {
                case "" => Some(JsonObject())
                case _ =>
                    parseAll(jsonValue, inputString) match {
                        case Success(result: JsonObject, _) => Some(result)
                        case failure: NoSuccess => None
                        case _ => None
                    }
            }
        }

    def getJsonOptExt(inputString: String): Option[JsonObject] = {
        logger trace s"inputString: $inputString"
        inputString trim match {
            case "" => Some(JsonObject())
            case _ =>
                parseAll(jsonValue, inputString) match {
                    case Success(result: JsonObject, _) => Some(result)
                    case failures@Failure(message, _) => Some(
                        JsonObject(
                            "error" -> JsonObject(
                                "message" -> JsonString(message),
                                "stackTrace" -> JsonString(failures.toString)
                            )
                        )
                    )
                    case _ => None
                }
        }
    }

    def apply(file: File): JsonObject = {
        parseAll(jsonValue, Source.fromFile(file)(UTF8).reader()) match {
            case Success(result: JsonObject, _) => result
            case failure: NoSuccess => logError(failure)
            case _ => logError(s"No matched result")
        }
    }

    def apply(stream: InputStream): JsonObject = {
        parseAll(jsonValue, Source.fromInputStream(stream)(UTF8).reader()) match {
            case Success(result: JsonObject, _) => result
            case failure: NoSuccess => logError(failure)
            case _ => logError(s"No matched result")
        }
    }

    def loadFromResorce(path: String): JsonObject = {
        Option(getClass.getClassLoader.getResource(path)) match {
            case Some(url) => apply(url.openStream())
            case None => JsonObject()
        }
    }

    def apply(uri: URI): JsonObject = {
        apply(uri.toURL.openStream())
    }

    def apply(url: URL): JsonObject = apply(url openStream())
}
