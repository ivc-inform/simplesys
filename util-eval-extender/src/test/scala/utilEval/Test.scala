package utilEval

import com.twitter.io.TempFile
import com.twitter.util.Eval
import org.scalatest.FunSuite


trait EvalInterface {
    val name: String
    def orderString(i: String): String
}

class Test extends FunSuite {
    val eval = new Eval

    test("eval") {
        val eval = new Eval

        val csv = eval[EvalInterface](TempFile.fromResourcePath("/csv.scala"))

        val tsv = eval[EvalInterface](TempFile.fromResourcePath("/tsv.scala"))

        val records = Array(
            "1,2,3,4,5",
            "9,8,7,6,5"
        )

        println(csv.name)
        records.foreach( i => println(csv.orderString( i )))
        println(tsv.name)
        records.foreach( i => println(tsv.orderString( i )))
    }
}
