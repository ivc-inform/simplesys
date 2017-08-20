package com.simpesys.reflect.runtime.universe

import scala.reflect.runtime.universe._
import scala.reflect.runtime.{universe => ru}

object ReflectionHelpers extends ReflectionHelpers {

    def isAnnotated[C: TypeTag, A: TypeTag]: Boolean = {
        val classSymbol = ru.typeOf[C].typeSymbol.asClass
        val annotationSymbol = ru.typeOf[A].typeSymbol

        try {
            classSymbol.annotations.exists {
                _.tree.children.head match {
                    case Select((New(x), _)) =>
                        x.symbol == annotationSymbol
                    case _ => false
                }
            }
        } catch {
            case e: Throwable => false
        }
    }

    def getAnnotation[C: TypeTag, A: TypeTag]: Option[Annotation] = {
        val classSymbol = ru.typeOf[C].typeSymbol.asClass
        val annotationSymbol = ru.typeOf[A].typeSymbol

        try {
            classSymbol.annotations.find {
                _.tree.children.head match {
                    case Select((New(x), _)) =>
                        x.symbol == annotationSymbol
                    case _ => false
                }
            }
        } catch {
            case e: Throwable => None
        }
    }

    def isAnnotated[A: TypeTag](classSymbol: ClassSymbol): Boolean = {
        val annotationSymbol = ru.typeOf[A].typeSymbol

        try {
            classSymbol.annotations.exists {
                _.tree.children.head match {
                    case Select((New(x), _)) =>
                        x.symbol == annotationSymbol
                    case _ => false
                }
            }
        }
        catch {
            case e: Throwable => false
        }
    }

    def getAnnotation[A: TypeTag](classSymbol: ClassSymbol): Option[Annotation] = {
        val annotationSymbol = ru.typeOf[A].typeSymbol
        try {
            classSymbol.annotations.find {
                _.tree.children.head match {
                    case Select((New(x), _)) =>
                        x.symbol == annotationSymbol
                    case _ => false
                }
            }
        }
        catch {
            case e: Throwable => None
        }
    }
}

trait ReflectionHelpers {

    protected val classLoaderMirror: Mirror = runtimeMirror(getClass.getClassLoader)

    class CaseClassFactory[T: TypeTag] {

        val tpe = typeOf[T]
        val classSymbol = tpe.typeSymbol.asClass

        if (!(tpe <:< typeOf[Product] && classSymbol.isCaseClass))
            throw new IllegalArgumentException(
                "CaseClassFactory only applies to case classes!"
            )

        val classMirror = classLoaderMirror reflectClass classSymbol

        val constructorSymbol = tpe.decl(termNames.CONSTRUCTOR)

        val defaultConstructor =
            if (constructorSymbol.isMethod)
                constructorSymbol.asMethod
            else {
                val ctors = constructorSymbol.asTerm.alternatives
                ctors.map(_.asMethod).find(_.isPrimaryConstructor).get
            }

        val constructorMethod = classMirror reflectConstructor defaultConstructor

        def buildWith(args: Any*): T = constructorMethod(args: _*).asInstanceOf[T]
    }

    class CaseClassFactory1[T: TypeTag](x: T) {

        val tpe = typeOf[T]
        val classSymbol = tpe.typeSymbol.asClass

        if (!(tpe <:< typeOf[Product] && classSymbol.isCaseClass))
            throw new IllegalArgumentException(
                "CaseClassFactory only applies to case classes!"
            )

        val classMirror = classLoaderMirror reflectClass classSymbol

        val constructorSymbol = tpe.decl(termNames.CONSTRUCTOR)

        val defaultConstructor =
            if (constructorSymbol.isMethod)
                constructorSymbol.asMethod
            else {
                val ctors = constructorSymbol.asTerm.alternatives
                ctors.map(_.asMethod).find(_.isPrimaryConstructor).get
            }

        val constructorMethod = classMirror reflectConstructor defaultConstructor

        def buildWith(args: Any*): T = constructorMethod(args: _*).asInstanceOf[T]
    }

    class CaseClassFactory2[T: TypeTag](classFullName: String) {

        val classSymbol = classLoaderMirror.classSymbol(Class.forName(classFullName))
        val tpe = classSymbol.toType

        if (!(tpe <:< typeOf[Product] && classSymbol.isCaseClass))
            throw new IllegalArgumentException(
                "CaseClassFactory only applies to case classes!"
            )

        val classMirror = classLoaderMirror reflectClass classSymbol

        val constructorSymbol = tpe.decl(termNames.CONSTRUCTOR)

        val defaultConstructor =
            if (constructorSymbol.isMethod)
                constructorSymbol.asMethod
            else {
                val ctors = constructorSymbol.asTerm.alternatives
                ctors.map(_.asMethod).find(_.isPrimaryConstructor).get
            }

        val constructorMethod = classMirror reflectConstructor defaultConstructor

        def buildWith(args: Any*): T = constructorMethod(args: _*).asInstanceOf[T]
    }
}