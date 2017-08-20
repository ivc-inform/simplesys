package com.simplesys.util

import java.io.File

import com.simplesys.common.Strings._
import com.twitter.util.Eval

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.reflect.internal.util.Position
import scala.tools.nsc.Settings
import scala.tools.nsc.reporters.{AbstractReporter, Reporter}

case class CompileInfo(pos: Position, msg: String, severity: AbstractReporter#Severity) {
    override def toString: String = s"Pos: $pos ${newLine.newLine} msg: $msg ${newLine.newLine} severity: $severity"
}

class EvalExt(target: Option[File]) extends Eval(target = target) {
    def this() {
        this(None)
    }

    def checkFromFiles(files: File*) = super.check(files.map(Source.fromFile(_).mkString).mkString("\n"))
    def compileFromFiles(files: File*) = super.compile(files.map(Source.fromFile(_).mkString).mkString("\n"))
    def inPlaceFiles[T](files: File*) = super.inPlace[T](files.map(Source.fromFile(_).mkString).mkString("\n"))

    private[this] val errors = ArrayBuffer.empty[CompileInfo]

    def getErrors = errors.toSeq
    def getErrorsString: Option[String] = getErrors match {
        case sec if sec.length > 0 ⇒ Some(getErrors.mkString("[", newLine, "]"))
        case _ ⇒ None
    }

    override lazy val compilerMessageHandler: Option[Reporter] = Some(
        new AbstractReporter {
            override val settings: Settings = compilerSettings
            override def displayPrompt(): Unit = ()
            override def display(pos: Position, msg: String, severity: this.type#Severity): Unit = {
                errors append CompileInfo(pos, msg, severity)
            }
            override def reset() = {
                super.reset()
                errors.clear()
            }
        })

}
