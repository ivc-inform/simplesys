package ru.simplesys
package coreutil

object SealedEnumRuntime {

    import scala.reflect.runtime.universe.TypeTag
    import scala.reflect.runtime.{universe ⇒ ru}

    def values[T: TypeTag]: Set[T] = {

        val rm = ru.runtimeMirror(this.getClass.getClassLoader)
        val symbol = ru.weakTypeOf[T].typeSymbol
        //val symbol = ru.typeTag[T].tpe.typeSymbol


        if (!symbol.isClass)
            throw new RuntimeException("Can only enumerate values of a sealed trait or class.")
        else if (!symbol.asClass.isSealed)
            throw new RuntimeException("Can only enumerate values of a sealed trait or class.")
        else {
            val children = symbol.asClass.knownDirectSubclasses.toList
            children.filter(_.isModuleClass).map(x => rm.reflectModule(x.companionSymbol.asModule).instance.asInstanceOf[T]).toSet
        }
    }
}

trait SealedCaseClassEnum[T] {
    def key: T
}
