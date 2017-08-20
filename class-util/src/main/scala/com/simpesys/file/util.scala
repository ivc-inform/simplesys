package com.simpesys.file

import java.io.File

object util {

    def listRecursively(file: File, topdown: Boolean = true): Stream[File] = {
        def doList(list: List[File]): Stream[File] = {

            list match {
                case Nil => Stream.empty

                case f :: tail => {
                    val list = try {
                        if (f.isDirectory) f.listFiles.toList else Nil
                    } catch {
                        case e: Throwable => Nil
                    }

                    if (topdown)
                        f #:: doList(list ++ tail)
                    else
                        doList(list ++ tail) :+ f
                }
            }
        }

        if (file.isDirectory)
            doList(file.listFiles.toList)
        else
            Stream.empty[File]
    }

    implicit class FileOpts(file: File) {
        def listRecursively(topdown: Boolean = true): Stream[File] = util.listRecursively(file, topdown)
    }
}