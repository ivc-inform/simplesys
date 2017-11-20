package com.simplesys

import org.scalatest.FunSuite
import io.circe.Json
import io.circe.Json._
import io.circe._
import io.circe.parser._
import com.simplesys.circe.Circe._

class TestSuit extends FunSuite{
  test("1") {
      val json: String = """
        {
          "id": "c730433b-082c-4984-9d66-855c243266f0",
          "name": "Foo",
          "counts": [1, 2, 3],
          "values": {
            "bar": true,
            "baz": 100.001,
            "qux": ["a", "b"]
          }
        }
      """

      val doc: Json = parse(json).getOrElse(Json.Null)
      println(doc.getString("name"))
  }
}
