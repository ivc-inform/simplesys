package com.simpesys.classutil

import java.io.File
import java.util.jar.{JarFile, Manifest ⇒ JarManifest}
import java.util.zip.{ZipEntry, ZipFile}

import com.simpesys.file.util._
import com.simplesys.file.{Path, PathSet}
import com.simplesys.log.Logging

import scala.reflect.runtime.universe._

object ClassFinder {

    import com.simplesys.io._

    /** Convenient method for getting the standard JVM classpath, into a
      * variable suitable for use with the `find()` method.
      *
      * @return the classpath, as a list of `File` objects
      */

    private def classpath: List[File] = System.getProperty("java.class.path").
      split(File.pathSeparator).
      map(s => if (s.trim.length == 0) "." else s).
      map(new File(_)).toList

    /** Instantiate a new `ClassFinder` that will search the specified
      * classpath, or the default classpath, if no classpath is defined.
      *
      * @param path  the classpath, which is a sequence of `File`
      *              objects representing directories, jars and zip files
      *              to search. Defaults to `classpath`.
      *
      * @return a new `ClassFinder` object
      */

    def apply(path: File*): ClassFinder = new ClassFinder(if (path.length > 0) path else classpath)
    def apply(path: PathSet[Path]): ClassFinder = new ClassFinder(if (path.size > 0) path.files else classpath)

    /** Convenience method that scans the specified classes for all concrete
      * classes that are subclasses of the named class. A subclass, in this
      * definition, is a class that directly or indirectly
      *
      * @param ancestor the class for which to find descendent
      *                 concrete subclasses
      * @param classes  the iterator of `ClassSymbol` objects to search
      *
      * @return an iterator of `ClassSymbol` objects that are concrete subclasses
      *         of `ancestor`. The iterator will be empty if no matching classes
      *         could be found.
      */
    def getConcreteSubclasses(ancestor: ClassSymbol, classes: Seq[ClassSymbol]): Seq[ClassSymbol] = classes.filter(!_.isAbstract).filter(_.baseClasses.exists(_ == ancestor))

    def getFullFileName(path: String): String = {
        var res = if (path.indexOf("classes/") > -1) path.substring(path.indexOf("classes/") + 8) else path
        res = res.substring(0, res.lastIndexOf(".class"))
        res.replace('/', '.')
    }
}

class ClassFinder(val path: Seq[File]) extends Logging {
    // Matches both ZipEntry and File
    protected val classLoaderMirror: Mirror = runtimeMirror(getClass.getClassLoader)
    protected val loader = StreamClassLoader(getClass.getClassLoader)

    import com.simpesys.classutil.ClassFinder._

    import scala.reflect.internal.util.ScalaClassLoader._

    /** Find all classes in the specified path, which can contain directories,
      * zip files and jar files. Returns metadata about each class in a
      * `ClassSymbol` object. The `ClassSymbol` objects are returned lazily,
      * rather than loaded all up-front.
      *
      * @return a `Stream` of `ClassSymbol` objects
      */
    def getClasses(): Stream[Option[ClassSymbol]] = find(path.toList)

    type FileEntry = {
        def isDirectory(): Boolean
        def getName(): String
    }


    private def find(path: List[File]): Stream[Option[ClassSymbol]] = {
        path match {
            case Nil => Stream.empty[Option[ClassSymbol]]
            case item :: Nil => findClassesIn(item)
            case item :: tail => findClassesIn(item) ++ find(tail)
        }
    }

    private def is(e: FileEntry, fileExtension: String): Boolean = (!e.isDirectory) && (e.getName.toLowerCase.endsWith("." + fileExtension))
    private def isClass(e: FileEntry): Boolean = is(e, "class")
    private def isJar(e: FileEntry): Boolean = is(e, "jar")
    private def isZip(e: FileEntry): Boolean = is(e, "zip")

    private def processDirectory(dir: File): Stream[Option[ClassSymbol]] = {
        val classes: Stream[File] = dir.listRecursively().filter(isClass _)

        val loader = fromURLs(classes.map(_.toURI.toURL), getClass.getClassLoader)

        classes.map {
            clazz =>
                val path = getFullFileName(clazz.getPath)
                loader.tryToLoadClass(path) match {
                    case None =>
                        logger trace s"Bad Class ${path}"
                        None
                    case Some(clazz) =>
                        try {
                            Some(classLoaderMirror.classSymbol(clazz))
                        }
                        catch {
                            case e: Throwable =>
                                logger trace "****** " + e.toString
                                None
                        }


                }
        }
    }


    private def findClassesIn(f: File): Stream[Option[ClassSymbol]] = {
        val name = f.getPath //.toLowerCase

        if (name.endsWith(".jar"))
            processJar(f)
        else if (name.endsWith(".zip"))
            processZip(f)
        else if (f.isDirectory)
            processDirectory(f)
        else
            Stream.empty[Option[ClassSymbol]]
    }

    private def processJar(file: File): Stream[Option[ClassSymbol]] = {
        val jar = new JarFile(file)
        val list1 = processZip(file)

        val manifest = jar.getManifest
        if (manifest == null)
            list1

        else {
            val path: List[File] = loadManifestPath(jar, file, manifest)
            val list2 = find(path)
            list1 ++ list2
        }
    }

    private def processZip(file: File): Stream[Option[ClassSymbol]] = {
        import scala.collection.JavaConverters._
        val zipFile = new ZipFile(file)

        zipFile.entries.asScala.
          toStream.
          filter((entry: ZipEntry) => isClass(entry)).
          map {
            (e: ZipEntry) =>
                val stream = zipFile getInputStream e
                val bytes = scala.reflect.io.Streamable.bytes(stream)

                try {
                    val clazz = loader.defineClass(bytes)
                    Some(classLoaderMirror.classSymbol(clazz))
                }
                catch {
                    case e: Throwable =>
                        logger trace "++++++ " + e.toString
                        None
                }
        }
    }

    private def loadManifestPath(jar: JarFile,
                                 jarFile: File,
                                 manifest: JarManifest): List[File] = {

        val attrs = manifest.getMainAttributes
        val value = attrs.get("Class-Path").asInstanceOf[String]

        if (value == null)
            Nil
        else {
            logger.trace("Adding ClassPath from jar " + jar.getName)
            val parent = jarFile.getParent
            val tokens = value.split( """\s+""").toList

            if (parent == null)
                tokens.map(new File(_))
            else
                tokens.map(s => new File(parent + File.separator + s))
        }
    }


}
