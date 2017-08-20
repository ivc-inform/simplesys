/*import Mirrors.{BasePerson, Person}
import com.simplesys.log.Logging
import com.simplesys.reflect.runtime.universe.ReflectionHelpers
import com.simplesys.script.{HTMLBeautifier, JsBeautifier}
import org.scalatest.FunSuite

import scala.reflect.runtime.universe._
import scala.reflect.runtime._
import scala.reflect.runtime.{universe => ru}

class TestButyfileres extends FunSuite with Logging {
    //implicit

    test("JsBeautifier") {
        val str = JsBeautifier("{a:1,b:2,c:3}")
        logger.debug(s"Str: ${str}")
    }

    test("HTMLBeautifier") {
        val str = HTMLBeautifier("<html><header></header><body></body></html>")
        logger.debug(s"Str: ${str}")
    }

    test("ReflectionHelpers") {

        val personFactory = new ReflectionHelpers.CaseClassFactory[Person]
        //val personFactory = new ReflectionHelpers.CaseClassFactory2(Person("Connor", 27))
        //val personFactory = new ReflectionHelpers.CaseClassFactory3[BasePerson]("Mirrors.Person")

        val result = personFactory buildWith Seq("Connor", 27)
        val expected = Person("Connor", 27)

        assert(result == expected)
        logger debug s"${result.toString}"
    }

    test("classSymbol") {
        val rm = ru.runtimeMirror(this.getClass.getClassLoader)
        val symbol = rm.classSymbol(Class.forName("Mirrors.Person"))
        val symbol1 = typeOf[Person].typeSymbol.asClass

        assert(symbol == symbol1)
    }
}*/
