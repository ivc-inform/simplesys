package com.simpesys.reflection

import com.simplesys.log.Logging
import scala.language.existentials
import scala.language.postfixOps
import scala.language.implicitConversions

object ClassFactory extends ClassFactory with Logging {
    implicit def string2Class[T <: AnyRef](name: String): Option[Class[T]] = {
        try {
            val clazz = Class.forName(name)
            Some(clazz.asInstanceOf[Class[T]])
        }
        catch {
            case ex: ClassNotFoundException =>
                logger error ex
                None
        }
    }

    implicit def refWithType[T <: AnyRef](x: T) = RefWithType(x, x.getClass)
    implicit def valWithType[T <: AnyVal](x: T) = ValWithType(x, getType(x))

    def getType(x: AnyVal): Class[_] = x match {
        case _: Byte => java.lang.Byte.TYPE
        case _: Short => java.lang.Short.TYPE
        case _: Int => java.lang.Integer.TYPE
        case _: Long => java.lang.Long.TYPE
        case _: Float => java.lang.Float.TYPE
        case _: Double => java.lang.Double.TYPE
        case _: Char => java.lang.Character.TYPE
        case _: Boolean => java.lang.Boolean.TYPE
        case _: Unit => java.lang.Void.TYPE
    }

    def toAnyRef(x: AnyVal): AnyRef = x match {
        case x: Byte => Byte.box(x)
        case x: Short => Short.box(x)
        case x: Int => Int.box(x)
        case x: Long => Long.box(x)
        case x: Float => Float.box(x)
        case x: Double => Double.box(x)
        case x: Char => Char.box(x)
        case x: Boolean => Boolean.box(x)
        case x: Unit => null //()
    }
}

trait ClassFactory {

    def getNew[T <: AnyRef](className: String)(args: WithType*) /*(implicit classLoader: ClassLoader)*/ : Option[T] = {
        import ClassFactory._
        val _clazz: Option[Class[T]] = className

        _clazz match {
            case Some(clazz) =>
                val argTypes = args map {
                    _.clazz
                } toArray

                val candidates = clazz.getConstructors filter {
                    constructor => matchingTypes(constructor.getParameterTypes, argTypes)
                }

                //todo Подстраховка на тот счет, если будет несколько конструкторов с одинаковой сигнатурой ???
                require(candidates.length == 1, "Argument runtime types must select exactly one constructor")
                val params = args map {
                    _.value
                }

                candidates.headOption match {
                    case None => None
                    case Some(head) =>
                        Some(candidates.head.newInstance(params: _*).asInstanceOf[T])
                }

            case None => None
        }
    }

    private def matchingTypes(declared: Array[Class[_]], actual: Array[Class[_]]): Boolean = {
        declared.length == actual.length && (
          (declared zip actual) forall {
              case (declared, actual) => declared.isAssignableFrom(actual)
          })
    }
}

sealed abstract class WithType {
    val clazz: Class[_]
    val value: AnyRef
}

case class ValWithType(anyVal: AnyVal, clazz: Class[_]) extends WithType {

    import ClassFactory._

    lazy val value = toAnyRef(anyVal)
}

case class RefWithType(anyRef: AnyRef, clazz: Class[_]) extends WithType {
    val value = anyRef
}
