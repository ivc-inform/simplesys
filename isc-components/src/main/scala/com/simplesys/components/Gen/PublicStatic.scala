//package com.simplesys.components.Gen
//
//import java.io.File
//
//import com.simplesys.common.ShortClassName
//import com.simplesys.components.Component
//import com.simplesys.genSources._
//import com.simplesys.io.RichFile
//import com.simplesys.script.JsBeautifier
//
//trait PublicStatic {
//    protected val genMessage = genMessageCreating
//
//    private[this] val classLoader = getClass.getClassLoader
//    val path: File
//    val withBeautifiler: Boolean
//
//
//    def printFiles(classes: Component*) {
//        classes foreach {
//            clazz => (new File(path, s"${clazz.getClass.getSimpleName.shortClassName}.js")) <=| {
//                print =>
//                    print(genMessage)
//
//                    if (!withBeautifiler)
//                        print(clazz.create)
//                    else
//                        print(JsBeautifier(clazz.create))
//            }
//        }
//
//        (new File(path, "IncludeModules")) <=| {
//            println =>
//                classes foreach {
//                    clazz =>
//                        println(s"${clazz.getClass.getSimpleName.shortClassName}.js")
//                }
//        }
//    }
//
//    def printFiles1(classes: Component*) {
//        classes foreach {
//            clazz => (new File(path, s"${clazz.getClass.getSimpleName.shortClassName}.js")) <=| {
//                print =>
//                    print(genMessage)
//
//                    if (!withBeautifiler)
//                        print(clazz.create)
//                    else
//                        print(JsBeautifier(clazz.create))
//            }
//        }
//
//        (new File(path, "IncludeModules")) <=| {
//            println =>
//                if (path.isDirectory()) {
//                    path.listFiles().foreach {
//                        file =>
//                            if (file.isFile && file.getAbsolutePath().shortClassName == "js")
//                                println(s"${file.getAbsolutePath().shortClassName1}")
//                    }
//                }
//        }
//    }
//}
