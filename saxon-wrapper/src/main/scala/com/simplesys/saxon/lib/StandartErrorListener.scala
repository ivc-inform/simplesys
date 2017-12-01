package com.simplesys.saxon

import javax.xml.transform.{ErrorListener => SErrorListener, TransformerException, SourceLocator}
import com.simplesys.common.Strings._
import net.sf.saxon.Configuration
import net.sf.saxon.om.{Sequence, StructuredQName, StandardNames, NodeInfo}
import javax.xml.transform.dom.DOMLocator
import net.sf.saxon.expr.instruct._
import net.sf.saxon.trace.{ContextStackIterator, Location}
import StandartErrorListener._
import net.sf.saxon.trans.{XPathException, KeyDefinition}
import net.sf.saxon.tree.util.Navigator
import net.sf.saxon.lib.NamespaceConstant
import scala.util.control.Breaks._
import org.xml.sax.SAXException
import net.sf.saxon.expr.XPathContext
import java.io.PrintStream
import net.sf.saxon.`type`.ValidationException

object StandartErrorListener {
  def getInstructionName(inst: Instruction): String = {
    try {
      val construct = inst.getInstructionNameCode

      if (construct >= 0 && construct < 1024 && construct != StandardNames.XSL_FUNCTION && construct != StandardNames.XSL_TEMPLATE) {
        if (inst.getExecutable.getHostLanguage == Configuration.XSLT)
          StandardNames getDisplayName construct
        else {
          val s = StandardNames getDisplayName construct
          val colon = s indexOf ":"
          if (colon > 0) {
            (s substring colon + 1) match {
              case "document" => "document node constructor"
              case "text" => "text node constructor"
              case "value-of" => "text node constructor"
              case "element" => "computed element constructor"
              case "attribute" => "computed attribute constructor"
              case "variable" => "variable declaration"
              case "param" => "external variable declaration"
              case "comment" => "comment constructor"
              case "processing-instruction" => "processing-instruction constructor"
              case "namespace" => "namespace node constructor"
            }
          }
        }
      }

      construct match {
        case Location.LITERAL_RESULT_ELEMENT => "element constructor <" + inst.getObjectName.getDisplayName + ">"
        case Location.LITERAL_RESULT_ATTRIBUTE => "attribute constructor <" + inst.getObjectName.getDisplayName + "=" + "{...}".dblQuoted
        case _ => ""
      }
    }
    catch {
      case x: Exception => ""
    }
  }

  def abbreviatePath(uri: String): String = {
    uri match {
      case null => null
      case str =>
        val slash = uri lastIndexOf "/"
        if (slash >= 0 && slash < uri.length - 1) {
          uri.substring(slash + 1)
        } else {
          uri
        }
    }
  }

  def wordWrap(message: String): String = {
    var res = ""
    if (message.length > 1000) {
      res = message.substring(0, 1000)
    }
    var nl = message indexOf newLine

    if (nl < 0)
      nl = message.length()

    if (nl > 100) {
      var i = 90;
      while (message.charAt(i) != ' ' && i > 0) {
        i -= 1
      }
      if (i > 10)
        message.substring(0, i).newLine.space + wordWrap(message.substring(i + 1))
      else
        message;
    } else if (nl < message.length)
      message.substring(0, nl).newLine + wordWrap(message.substring(nl + 1))
    else
      message
  }

  def printStackTrace(out: PrintStream, context: XPathContext) {
    val iterator = new ContextStackIterator(context)
    while (iterator.hasNext) {
      val frame = iterator.next
      frame print out
    }
  }
}

class StandartErrorListener extends SErrorListener with Serializable {
  var RecoveryPolicy = Configuration.RECOVER_WITH_WARNINGS
  var ErrorOutput: PrintStream = System.err
  var MaximumNumberOfWarnings = 25

  private var warningCount = 0
  var errorCount = 0

  def makeAnother(hostLanguage: Int): StandartErrorListener = {
    try {
      this.getClass.newInstance()
    }
    catch {
      case ex: InstantiationError => new StandartErrorListener
      case ex: IllegalAccessException => new StandartErrorListener
    }
  }

  def getLocationMessageText(loc: SourceLocator): String = {
    var locMessage = ""
    var systemId: String = null
    var node: NodeInfo = null
    var path: String = null
    var nodeMessage: String = null
    var lineNumber = -1

    loc match {
      case x: DOMLocator =>
        nodeMessage = "at".space + x.getOriginatingNode.getNodeName.space
      case x: NodeInfo =>
        nodeMessage = "at".space + x.getDisplayName.space
      case x: ValidationException =>
        if (x.getNode != null)
          nodeMessage = "at".space + x.getNode.getDisplayName.space
        else if ((x.getLineNumber == -1) && (x.getPath != null))
          nodeMessage = "at".space + x.getPath.space
      case x: Instruction =>
        val instructionName = getInstructionName(x)
        if (instructionName.isEmpty)
          nodeMessage = "at".space + instructionName.space
        systemId = x.getSystemId
        lineNumber = x.getLineNumber
      case x: Procedure =>
        var kind = "procedure"
        loc match {
          case x: UserFunction => kind = "function"
          case x: Template => kind = "template"
          case x: AttributeSet => kind = "attribute-set"
          case x: KeyDefinition => kind = "key"
        }
        systemId = x.getSystemId
        lineNumber = x.getLineNumber
        nodeMessage = "at".space + kind.space
        x.getObjectName match {
          case null =>
          case name =>
            nodeMessage += name.toString.space
        }
      case _ =>
    }

    if (lineNumber == -1)
      lineNumber = loc.getLineNumber

    val containsLineNumber = lineNumber != -1
    if (node != null && !containsLineNumber)
      nodeMessage = "at".space + Navigator.getPath(node).space

    if (nodeMessage != null)
      locMessage += nodeMessage

    if (containsLineNumber) {
      locMessage += "on line".space + lineNumber.toString.space
      if (loc.getColumnNumber != -1) {
        locMessage += "column".space + loc.getColumnNumber.toString.space;
      }
    }

    if (systemId != null && systemId.length == 0)
      systemId = null

    if (systemId == null)
      systemId = loc.getSystemId

    if (systemId != null && systemId.length != 0)
      locMessage += (if (containsLineNumber) "of " else "in ") + abbreviatePath(systemId) + ':';

    locMessage
  }

  def getLocationMessage(err: TransformerException): String = {
    var loc: SourceLocator = err.getLocator
    while (loc == null) {
      err.getException match {
        case x: TransformerException =>
          loc = x.getLocator
        case _ => err.getCause match {
          case x: TransformerException =>
            loc = x.getLocator
          case _ => ""
        }
      }
    }
    getLocationMessageText(loc)
  }

  def getErrorObjectString(errorObject: Sequence): String = null

  def getExpandedMessage(err: TransformerException): String = {
    var qCode: StructuredQName = null;
    var additionalLocationText: String = null;

    err match {
      case x: XPathException =>
        qCode = x.getErrorCodeQName
        additionalLocationText = x.getAdditionalLocationText
      case _ =>
    }

    if (qCode == null)
      err.getException match {
        case x: XPathException =>
          qCode = x.getErrorCodeQName
        case _ =>
      }

    var message = ""
    if (qCode != null) {
      if (qCode.getURI == NamespaceConstant.ERR)
        message = qCode.getLocalPart
      else
        message = qCode.getDisplayName
    }

    if (additionalLocationText != null)
      message += space + additionalLocationText

    err.getException match {
      case x: XPathException =>
        x.getErrorObject match {
          case null =>
          case x => getErrorObjectString(x) match {
            case null =>
            case str => message += space + str
          }
        }
      case _ =>
    }

    var e: Throwable = err

    breakable {
      while (true) {
        if (e == null)
          break

        var next = e.getMessage match {
          case null => ""
          case x => x
        }

        if (next.startsWith("net.sf.saxon.trans.XPathException: "))
          next = next.substring(next.indexOf(": ") + 2)

        if (!("TRaX Transform Exception".equals(next) || message.endsWith(next))) {
          if (!message.isEmpty && !message.trim.endsWith(":")) {
            message += ":".space
          }
          message += next
        }

        e = e match {
          case x: TransformerException =>
            x.getException
          case x: SAXException =>
            x.getException
          case _ => break
        }
      }
    }

    message
  }

  def warning(exception: TransformerException) {
    if (RecoveryPolicy != Configuration.RECOVER_SILENTLY) {

      if (ErrorOutput == null)
        ErrorOutput = System.err

      var message = ""

      if (exception.getLocator != null)
        message = getLocationMessage(exception).newLine.space

      message += wordWrap(getExpandedMessage(exception))

      exception match {
        case x: ValidationException =>
          ErrorOutput.println("Validation error:".toUpperCase.space + message)
        case any =>
          ErrorOutput.println("Warning:".toUpperCase.space + message)
          warningCount += 1

          if (warningCount > MaximumNumberOfWarnings) {
            ErrorOutput.println("No more warnings will be displayed")
            RecoveryPolicy = Configuration.RECOVER_SILENTLY
            warningCount = 0
          }
      }
    }
  }

  def error(exception: TransformerException) {
    var message = ""
    errorCount += 1
    exception match {
      case x: ValidationException =>
        if (ErrorOutput == null)
          ErrorOutput = System.err

        val explanation = getExpandedMessage(exception)
        val constraintReference = x.getConstraintReferenceMessage
        val validationLocation = x.getValidationLocationText
        val contextLocation = x.getContextLocationText
        message = "Validation error".toUpperCase.space +
          getLocationMessage(exception).newLine.space +
          wordWrap(explanation) +
          wordWrap(if (constraintReference != null) "" else (newLine.space + constraintReference)) +
          wordWrap(if (validationLocation.length() == 0) "" else (newLine.space + validationLocation)) +
          wordWrap(if (contextLocation.length() == 0) "" else (newLine.space + contextLocation))

        ErrorOutput println message
      case _ if RecoveryPolicy == Configuration.RECOVER_SILENTLY =>
      case _ =>
        val prefix = (if (RecoveryPolicy == Configuration.RECOVER_WITH_WARNINGS) "Recoverable error".space else "Error".space)
        message = prefix + getLocationMessage(exception).newLine.space + wordWrap(getExpandedMessage(exception))

        if (RecoveryPolicy == Configuration.RECOVER_WITH_WARNINGS) {
          ErrorOutput println message
          warningCount += 1
          if (warningCount > MaximumNumberOfWarnings) {
            ErrorOutput.println("No more warnings will be displayed")
            RecoveryPolicy = Configuration.RECOVER_SILENTLY
            warningCount = 0
          }
        } else {
          ErrorOutput println message
          ErrorOutput println "Processing terminated because error recovery is disabled"
          throw XPathException.makeXPathException(exception)
        }
    }
  }

  protected def outputStackTrace(out: PrintStream, context: XPathContext) {
    printStackTrace(out, context);
  }

  def fatalError(exception: TransformerException) {
    var message = ""
    errorCount += 1
    exception match {
      case x: XPathException if x.hasBeenReported =>
      case x: XPathException =>
        if (ErrorOutput == null)
          ErrorOutput = System.err
        exception match {
          case x: ValidationException =>
            var explanation = getExpandedMessage(exception)

            x.getConstraintReferenceMessage match {
              case null =>
              case str => explanation += space + "(" + str + ')'
            }

            message = "Validation error".toUpperCase.space + getLocationMessage(exception).newLine.space + wordWrap(explanation)
          case _ =>
            message = "Fatal Error".toUpperCase.space + getLocationMessage(exception).newLine.space + wordWrap(getExpandedMessage(exception))
        }
        ErrorOutput println message

        x setHasBeenReported true
        x.getXPathContext match {
          case null =>
          case _ =>
            val context = x.getXPathContext

            if (RecoveryPolicy != Configuration.RECOVER_SILENTLY)
              outputStackTrace(ErrorOutput, context)
        }
    }
  }
}
