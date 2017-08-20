import java.io.File

import com.simpesys.classutil.ClassFinder
import com.simpesys.file.util._
import com.simplesys.log.Logging
import com.simplesys.common.Strings._
import org.scalatest.FunSuite

import scala.reflect.internal.util.ScalaClassLoader
import scala.reflect.internal.util.ScalaClassLoader.URLClassLoader
import scalax.file.PathSet

class ClassFinderTest extends FunSuite with Logging {
    def assert1(value: Boolean) {
        if (!value) throw new RuntimeException(s"Value is false")
    }

    test("find classes in specified class path") {
        val directory = new File("target")

        assert1(directory.exists)
        val scalaDirs = directory.listFiles.filter(_.getName.startsWith("scala"))
        assert1(scalaDirs.length > 0)

        // Even though the take() returns an Array[File], we must use apply(0) to
        // get the first element, not just (0), because there's an implicit
        // parameter in the way...
        val classDir = scalaDirs.take(1).map(new File(_, "classes")).apply(0)

        // Get class files under the directory.
        val classFiles = classDir.listRecursively().filter(_.getName.endsWith(".class")).toList

        // Ensure that we got some.
        val totalExpected = classFiles.length
        assert1(totalExpected > 0)

        // The number of returned classInfo objects should be the same number
        // as the number of class files.
        val classFinder: ClassFinder = ClassFinder(classDir)

        // First, verify that we get the right number if we convert the iterator
        // directly to a list.
        val classInfoList = classFinder.getClasses.toList
        assert1(classInfoList.length === classFiles.length)

        // Next, check the iterator by looping over it.
        val classInfoStream = classFinder.getClasses
        assert1(classInfoStream.length === totalExpected)
    }

    test("find classes in specified class path1") {

        val directory = new File("target")

        val scalaDirs: Array[File] = directory.listFiles.filter(_.getName.startsWith("scala"))

        logger debug s"Files: ${scalaDirs.map(_.getName).mkString(" ")}"


        scalaDirs.take(1).map(new File(_, "classes")).headOption match {
            case Some(classDir) =>
                logger debug s"classDir: ${classDir.getCanonicalPath}"


                val classFiles: Seq[File] = classDir.listRecursively().filter(_.getName.endsWith(".class")).toSeq
                val loader = new URLClassLoader(classFiles.map(_.toURI.toURL), getClass.getClassLoader)

                classFiles.foreach {
                    file =>
                        //val fullName = getFullFileName(file.getPath)
                        val fullName = file.getPath

                        logger debug s"fullName: $fullName"

                        val clazz: Option[Class[_]] = loader tryToLoadClass fullName

                        clazz match {
                            case Some(clazz) if clazz.getName != null =>
                                logger debug s"Loaded Class:${clazz.getName.newLine}"
                            case _ =>
                        }

                }

            //ClassFinder.classpath.foreach(logger debug _.getCanonicalPath)
            case _ =>
        }
    }

    def getFullFileName(path: String): String = {
        var res = path.substring(path.indexOf("classes/") + 8)
        res = res.substring(0, res.lastIndexOf(".class"))
        res.replace('/', '.')
    }

    test("fullClassName") {
        val path = "/common-webapp_2.11-1.0.0-SNAPSHOT.jar"
        logger debug getFullFileName(path)
    }

    test("java.class.path") {
        logger debug System.getProperty("java.class.path").split(File.pathSeparator).mkString(newLine)
        logger debug System.getProperty("user.home")
    }

    test("jar") {
        import scalax.file.ImplicitConversions._
        import com.simplesys.io._

        //val files = ClassFinder(new File("/home/andrew/.ivy2/cache/com.simplesys/joda-wrapper_2.11/jars/joda-wrapper_2.11-1.0.0-SNAPSHOT.jar")).getClasses()
        //val files = ClassFinder(new File("/home/andrew/.ivy2/cache/com.simplesys/common_2.11/jars/common_2.11-1.0.0-SNAPSHOT.jar")).getClasses()
        val files = ClassFinder(new File("common-webapp_2.11-1.0.0-SNAPSHOT.jar")).getClasses()
        //val files  = ClassFinder(PathSet("/home/andrew/Job/dm-processing/target/scala-2.11/classes/com/simplesys/mfms/containers")).getClasses()
        //val files = ClassFinder().getClasses()
        for (file <- files)
            file match {
                case None =>
                case Some(file) =>
                    logger debug s"file: ${file.fullName}"
            }

        logger debug s"files: ${files.length}"
    }
}