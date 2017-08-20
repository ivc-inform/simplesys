package com.simplesys.scalaGen

import com.simplesys.common.Strings._
import com.simplesys.common.equality.SimpleEquality._
import com.simplesys.log.Logging

import scala.collection.mutable.ArrayBuffer

abstract class ScalaElement extends Logging {
    val id: String = ""
    def serrialize(indent: Int = 0): String
    def serrialize1(indent: Int = 0): String = strEmpty
    def serrializeToOneString(indent: Int = 0) = strEmpty
    def log {
        log(0)
    }
    def log(indent: Int) {
        logger trace (s"${getClass.getSimpleName}.serrialize: ${newLine + serrialize(indent)}")
        //logger debug (fill(commentLength, "="))
    }
    override def toString = serrialize().newLine
    //def toPrettyString = org.scalafmt.Scalafmt.format(serrialize())
}

object ScalaEmptyElement extends ScalaElement {
    def serrialize(indent: Int = 0) = strEmpty
}

abstract class ScalaObjectElement extends ScalaElement

abstract class ScalaClassElement extends ScalaObjectElement

object ScalaEmptyObjectElement extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = strEmpty
}

object ScalaEmptyClassElement extends ScalaClassElement {
    def serrialize(indent: Int = 0) = strEmpty
}

abstract class VariableType extends ScalaElement

abstract class ModificatorVariable extends ScalaElement

abstract class OverrideVariable extends ScalaElement

abstract class FinalVariable extends ScalaElement

abstract class If extends ScalaElement

abstract class Body extends ScalaElement {
    def serrializeToOneString(indent: Int = 0): String
    def length: Int
    val complexBody = false
}

object PublicMofificator extends ModificatorVariable {
    def serrialize(indent: Int = 0) = strEmpty
}

object PrivateMofificator extends ModificatorVariable {
    def serrialize(indent: Int = 0) = "private".space
}

object ProtectedMofificator extends ModificatorVariable {
    def serrialize(indent: Int = 0) = "protected".space
}

object OverrideMofificator extends OverrideVariable {
    def serrialize(indent: Int = 0) = "override".space
}

object NotOverrideMofificator extends OverrideVariable {
    def serrialize(indent: Int = 0) = strEmpty
}

object FinalMofificator extends FinalVariable {
    def serrialize(indent: Int = 0) = "final".space
}

object ImplicitMofificator extends FinalVariable {
    def serrialize(indent: Int = 0) = "implicit".space
}

object NotFinalMofificator extends FinalVariable {
    def serrialize(indent: Int = 0) = strEmpty
}

object EmptyScalaElement extends ScalaElement {
    def serrialize(indent: Int = 0) = strEmpty
}

object VariableVal extends VariableType {
    def serrialize(indent: Int = 0) = spaces(indent) + "val".space
}

object VariableVar extends VariableType {
    def serrialize(indent: Int = 0) = spaces(indent) + "var".space
}

object AssignVariable extends VariableType {
    def serrialize(indent: Int = 0) = spaces(indent)
}

class ScalaStringElement(string: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = spaces(indent) + string
}

case class ScalaUnquotedStringElement(string: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = spaces(indent) + string.dblQuoted + ".unq"
}

case class ScalaUnquotedStringElement1(string: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = spaces(indent) + string
}

class ScalaPackage(`package`: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = (if (!`package`.isEmpty) spaces(indent) + "package".space + `package` else strEmpty).newLine
}

object ScalaComment {
    def apply(comment: String) = new ScalaComment(comment)
}

class ScalaComment(comment: String) extends ScalaObjectElement {
    def len(indent: Int): Int = (commentLength - comment.length - indent - 2) / 2

    def serrialize(indent: Int = 0) = fill(commentLength - len(indent), "/", comment)
}

object ScalaEndComment {
    def apply(comment: String) = new ScalaEndComment(comment)
}

class ScalaEndComment(comment: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = new ScalaComment("End".space + comment).serrialize(indent)
}

case class ScalaShortComment(comment: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = spaces(indent) + s"// ${comment}"
}

case class ScalaImport(`import`: String) extends ScalaObjectElement {
    def serrialize(indent: Int = 0) = spaces(indent) + "import".space + `import`.newLine
}

case class ScalaImports(imports: ScalaImport*) extends ScalaObjectElement {
    private val _imports = ArrayBuffer(imports: _*)

    def find(p: ScalaImport => Boolean): Option[ScalaImport] = _imports find p

    def isEmpty = _imports.isEmpty

    def +=(`import`: ScalaImport) {
        if (!_imports.exists(_ === `import`))
            _imports += `import`
    }

    def ++=(imports: ScalaImport*) {
        imports foreach {
            += _
        }
    }

    def serrialize(indent: Int = 0) = (_imports map {
        _.serrialize(indent)
    }).mkString(strEmpty)
}

abstract class ScalaParametr extends ScalaElement

case object ParametrVal extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "val".space
}

case object ParametrOverrideVal extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "override val".space
}

case object ParametrImplicitOverrideVal extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "implicit override val".space
}

case object ParametrImplicit extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "implicit".space
}

case object ParametrImplicitVal extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "implicit val".space
}

case object ParametrVar extends ScalaParametr {
    def serrialize(indent: Int = 0) = spaces(indent) + "var".space
}

case object ParametrLocal extends ScalaParametr {
    def serrialize(indent: Int = 0) = strEmpty
}

class ScalaSign(sign: String) extends ScalaElement {
    def serrialize(indent: Int): String = spaces(indent) + sign
}

case object ScalaSignEquality extends ScalaSign("=")
case object ScalaSignTwoEquality extends ScalaSign("==")
case object ScalaSignTreeEquality extends ScalaSign("===")
case object ScalaSignArrowRight extends ScalaSign("->")
case object ScalaSignArrowLeft extends ScalaSign("<-")

case class ScalaClassParametr(
                               name: String,
                               `type`: AbstractScalaType,
                               `override`: OverrideVariable = NotOverrideMofificator,
                               parametrType: ScalaParametr = ParametrLocal,
                               defaultValue: ScalaElement = strEmpty,
                               isEmpty: Boolean = false,
                               onNewLine: Boolean = false,
                               override val id: String = "",
                               sign: ScalaSign = ScalaSignEquality) extends ScalaElement {
    def serrialize(indent: Int = 0) =
        if (isEmpty)
            strEmpty
        else {
            (if (onNewLine)
                newLine //+ spaces()
            else strEmpty) +
              `override`.serrialize(indent) +
              parametrType.serrialize(indent) + name + {
                if (`type` !== ScalaImplicitType) ":".space + `type`.serrialize() else strEmpty
            } + {
                val defVal = {
                    defaultValue match {
                        case x: ScalaBody => if (onNewLine) defaultValue.serrialize(indent + indentSize * 2) else defaultValue.serrialize()
                        case _ => if (onNewLine) defaultValue.serrialize(indent + indentSize) else defaultValue.serrialize()
                    }
                }

                if (defVal.isEmpty)
                    strEmpty
                else {
                    if (name.isEmpty) strEmpty else sign.serrialize(1).space
                } + defVal
            }
        }
}

case class ScalaPartialMethod(name: String,
                              modificator: ModificatorVariable = PublicMofificator,
                              packageScope: String = strEmpty,
                              `type`: AbstractScalaType = ScalaImplicitType,
                              body: ScalaElement) extends ScalaElement {
    def serrialize(indent: Int = 0) = {
        val l = spaces(indent) + "def".space + name + {
            if (`type` !== ScalaImplicitType) ":".space + `type`.serrialize() else space
        } + "=".space
        l + body.serrialize(indent)
    }
}

object ScalaClassParametrs {
    def apply() = new ScalaClassParametrs()
    def apply(emptyparentheses: Boolean) = new ScalaClassParametrs(emptyparentheses = emptyparentheses)
    def apply(emptyparentheses: Boolean, parametrs: ScalaClassParametr*) = new ScalaClassParametrs(serrializeToOneString = true, indent1 = 0, emptyparentheses = emptyparentheses, parametrs = parametrs: _*)
    def apply(parametrs: ScalaClassParametr*) = new ScalaClassParametrs(parametrs: _*)
    def apply(serrializeToOneString: Boolean, indent: Int, emptyparentheses: Boolean, parametrs: ScalaClassParametr*) = new ScalaClassParametrs(serrializeToOneString, indent, emptyparentheses, parametrs: _*)
    def apply(serrializeToOneString: Boolean, indent: Int, parametrs: ScalaClassParametr*) = new ScalaClassParametrs(serrializeToOneString, indent, false, parametrs: _*)
}

class ScalaClassParametrs(serrializeToOneString: Boolean,
                          indent1: Int,
                          emptyparentheses: Boolean,
                          parametrs: ScalaClassParametr*) extends ScalaElement {

    private val _parametrs = ArrayBuffer(parametrs: _*)

    def getParametrs: Seq[ScalaClassParametr] = _parametrs.toSeq

    def length = _parametrs.length

    def +=(parametr: ScalaClassParametr) {
        _parametrs += parametr
    }

    def ++=(parametrs: ScalaClassParametr*) {
        _parametrs ++= parametrs
    }

    def this(parametrs: ScalaClassParametr*) = this(true, 0, false, parametrs: _*)
    def this(emptyparentheses: Boolean) = this(true, 0, emptyparentheses, Seq.empty[ScalaClassParametr]: _*)

    def serrialize(indent: Int = 0) = {
        val res = {
            if (serrializeToOneString)
                (_parametrs map (item => item.serrialize(indent))).mkString(",".space)
            else
                (_parametrs map (item => newLine + spaces(indent + indent1) + item.serrialize(indent))).mkString(",")
        }

        if (res.nonEmpty)
            "(" + (if (res.trim.last === ',') res.trim.substring(0, res.trim.length - 1).trim else res.trim) + ")"
        else if (emptyparentheses)
            "()"
        else
            strEmpty
    }
}

abstract class AbstractTypeSymbol extends ScalaElement

case object NonBoundTypeSymbol extends AbstractTypeSymbol {
    def serrialize(indent: Int): String = ":"
}

case object UpperBoundTypeSymbol extends AbstractTypeSymbol {
    def serrialize(indent: Int): String = "<:"
}

case object LowerBoundTypeSymbol extends AbstractTypeSymbol {
    def serrialize(indent: Int): String = ">:"
}

case class ScalaAliasType(name: String,
                          `type`: AbstractScalaType = ScalaImplicitType,
                          body: Body = ScalaBodyEmpty,
                          symbolType: AbstractTypeSymbol = NonBoundTypeSymbol,
                          indent: Int = 0) extends ScalaElement {

    def serrialize(indent: Int = 0) = spaces(indent) + "type".space + name + {
        if (`type` != ScalaImplicitType) space + symbolType.serrialize().space else strEmpty
    } + `type`.serrialize().space + {
        if (body != ScalaNoBody) "=".space else strEmpty
    } + body.serrializeToOneString(indent)

}

case class ScalaMethod(name: String,
                       `final`: FinalVariable = NotFinalMofificator,
                       `override`: OverrideVariable = NotOverrideMofificator,
                       modificator: ModificatorVariable = PublicMofificator,
                       packageScope: String = strEmpty,
                       generics: AbstractScalaGeneric = NoneScalaGeneric,
                       parametrs: ScalaClassParametrs = ScalaClassParametrs(),
                       parametrsImplicit: ScalaClassParametrs = ScalaClassParametrs(),
                       `type`: AbstractScalaType = ScalaImplicitType,
                       body: Body = ScalaBodyEmpty,
                       annotation: ScalaAnnotation = ScalaAnnotation(""),
                       loggedVariable: Boolean = false,
                       serrializeToOneString: Boolean = false
                      ) extends ScalaElement {

    val _body: Body = if (loggedVariable) ScalaComplexBody(
        ScalaVariable(
            name = name,
            `type` = `type`,
            body = body,
            serrializeToOneString = true
        ),
        ScalaExpression("logger.debug (" + (name + ": ").dblQuoted + " + " + name + ".toString)"),
        ScalaExpression(name)
    )
    else body

    def serrialize(indent: Int = 0) = spaces(indent) + annotation.serrialize(indent) + `final`.serrialize() + `override`.serrialize() + modificator.serrialize() + "def".space + name + {
        if (generics === NoneScalaGeneric)
            strEmpty
        else
            generics.serrialize(indent)
    } + parametrs.serrialize(indent) + parametrsImplicit.serrialize(indent) + {
        if (`type` != ScalaImplicitType) ":".space else strEmpty
    } + `type`.serrialize().space + {
        if (body != ScalaNoBody) "=".space else strEmpty
    } + (if (serrializeToOneString && !loggedVariable) _body.serrializeToOneString() else _body.serrialize(indent))
}

case class ScalaTestKind(name: String) extends ScalaElement {
    override def serrialize(indent: Int): String = spaces(indent) + name
}

case class ScalaTestMethod(name: String,
                           testKind: ScalaTestKind,
                           body: Body = ScalaBodyEmpty,
                           serrializeToOneString: Boolean = false) extends ScalaElement {

    def serrialize(indent: Int = 0) = {
        spaces(indent) + name.dblQuoted + testKind.serrialize(1).space + (body match {
            case x: ScalaBody =>
                if (x.length === 1)
                    "{" + /*newLine + */ spaces(indent + indentSize) + (if (serrializeToOneString) body.serrializeToOneString(indent) else body.serrialize(indent)) + newLine + spaces(indent) + "}"
                else if (serrializeToOneString) body.serrializeToOneString(indent) else body.serrialize(indent)
        })
    }

    def +=(element: ScalaElement) {
        body match {
            case body: ScalaBody =>
                body += element
        }
    }

    def ++=(elements: ScalaElement*) {
        body match {
            case body: ScalaBody =>
                body ++= (elements: _*)
        }
    }
}

case class ScalaApplyObject(name: String,
                            parametrs: ScalaClassParametrs = ScalaClassParametrs(),
                            suffix: String = strEmpty) extends ScalaElement {

    def serrialize(indent: Int = 0) = spaces(indent) + name + parametrs.serrialize(indent) + (if (!suffix.isEmpty) suffix else strEmpty)
}

case class ScalaApplyObjectWithBody(name: String,
                                    parametrs: ScalaClassParametrs = ScalaClassParametrs(),
                                    body: ScalaBody) extends ScalaElement {

    def serrialize(indent: Int = 0) = spaces(indent) + name + parametrs.serrialize(indent) + body.serrializeToOneString(indent)
}

case class ScalaApplyAnonimousClass(name: String,
                                    parametrs: ScalaClassParametrs = ScalaClassParametrs(),
                                    suffix: String = strEmpty) extends ScalaElement {

    def serrialize(indent: Int = 0) = spaces(indent) + "new".space + name + parametrs.serrialize(indent) + (if (!suffix.isEmpty) suffix else strEmpty)
}

case class ScalaApplyPartialObject(name: String,
                                   body: ScalaCase,
                                   serrializeToOneString: Boolean = false,
                                   suffix: String = strEmpty) extends ScalaElement {

    def serrialize(indent: Int = 0) = spaces(indent) + name + space + body.serrialize(indent + indentSize) + (if (!suffix.isEmpty) suffix else strEmpty)
}

case class ScalaVariable(name: String,
                         `final`: FinalVariable = NotFinalMofificator,
                         `implicit`: Boolean = false,
                         `override`: OverrideVariable = NotOverrideMofificator,
                         modificator: ModificatorVariable = PublicMofificator,
                         packageScope: String = strEmpty,
                         `lazy`: Boolean = false,
                         variableType: VariableType = VariableVal,
                         `type`: AbstractScalaType = ScalaImplicitType,
                         body: Body = ScalaBodyEmpty,
                         serrializeToOneString: Boolean = false,
                         loggedVariable: Boolean = false,
                         loggedFunction: String = strEmpty,
                         nameLoggedVariable: String = strEmpty,
                         sign: String = "="
                        ) extends ScalaElement {

    def getImplicit = if (`implicit`) "implicit".space else strEmpty


    def serrialize(indent: Int = 0) = {
        val _name = if (nameLoggedVariable != strEmpty) nameLoggedVariable else name
        val _body: Body = if (loggedVariable) ScalaComplexBody(
            ScalaVariable(
                name = _name,
                `type` = `type`,
                body = body,
                serrializeToOneString = true
            ),
            ScalaExpression("logger.debug (" + (_name + ": ").dblQuoted + " + " + (if (loggedFunction == strEmpty) _name + ".toString" else loggedFunction) + ")"),
            ScalaExpression(_name)
        )
        else body

        val res = spaces(indent) + `final`.serrialize() + getImplicit + `override`.serrialize() + modificator.serrialize() + {
            if (packageScope.isEmpty) strEmpty else "[" + packageScope + "]".space
        } +
          (if (`lazy`) "lazy".space else strEmpty) + variableType.serrialize() + name + {
            if (`type` != ScalaImplicitType) ":".space else strEmpty
        } + `type`.serrialize().space + sign.space + {
            if (serrializeToOneString && !loggedVariable) _body.serrializeToOneString() else _body.serrialize1(indent + indentSize)
        }

        if (res.last === newLine.last)
            res.toString.substring(0, res.toString().length - 1)
        else
            res
    }
}

case class ScalaVariables(variables: ScalaVariable*) extends ScalaElement {
    override def serrialize(indent: Int): String = variables.map {
        item => item.serrialize(indent).newLine
    }.mkString(strEmpty)
}

object ScalaBody {
    def apply(elements: ScalaElement*): ScalaBody = new ScalaBody(elements: _*)
}

class ScalaBody(elements: ScalaElement*) extends Body {
    private val _elements = ArrayBuffer(elements: _*)

    def +=(element: ScalaElement) {
        _elements += element
    }

    def addMembers(element: Seq[ScalaElement]) {
        _elements ++= element
    }

    def +=:(element: ScalaElement) {
        _elements.+=:(element)
    }

    def ++=(elements: ScalaElement*) {
        _elements ++= elements
    }

    def ++=:(elements: ScalaElement*) {
        _elements.++=:(elements)
    }

    def length = _elements.length

    private def getCursesOpen = if (length > 1 || complexBody) "{" else strEmpty
    private def getCursesClose = if (length > 1 || complexBody) "}" else strEmpty

    def serrialize(indent: Int = 0): String = {
        if (length == 0)
            "{}"
        else
            getCursesOpen + newLine + {
                val res = new StringBuilder
                _elements.zipWithIndex foreach {
                    case (element, index) =>
                        res append element.serrialize(indent + indentSize)
                        if ((element.serrialize() !== newLine) /*&& (index !== 0)*/ )
                            res append newLine
                }
                if (res.length > 0 && res.last === newLine.last)
                    res.toString.substring(0, res.toString().length - 1)
                else
                    res
            } + {
                if (getCursesClose != strEmpty)
                    newLine + spaces(indent) + getCursesClose
                else
                    strEmpty
            }
    }

    override def serrialize1(indent: Int = 0): String = {
        newLine + (_elements map {
            _.serrialize(indent)
        }).mkString(newLine.toString)
    }

    override def serrializeToOneString(indent: Int = 0) = {
        spaces(indent) + getCursesOpen + (_elements map {
            _.serrialize()
        }).mkString(";".space) + /*space +*/ getCursesClose
    }
}

class ScalaObjectBody(elements: ScalaElement*) extends ScalaObjectElement {
    val complexBody = false

    private val _elements = ArrayBuffer(elements: _*)

    def +=(element: ScalaElement) {
        _elements += element
    }

    def addMembers(element: Seq[ScalaElement]) {
        _elements ++= element
    }

    def +=:(element: ScalaElement) {
        _elements.+=:(element)
    }

    def ++=(elements: ScalaElement*) {
        _elements ++= elements
    }

    def ++=:(elements: ScalaElement*) {
        _elements.++=:(elements)
    }

    def length = _elements.length

    private def getCursesOpen = if (length > 1 || complexBody) "{" else strEmpty
    private def getCursesClose = if (length > 1 || complexBody) "}" else strEmpty

    def serrialize(indent: Int = 0): String = {
        if (length == 0)
            "{}"
        else
            getCursesOpen + newLine + {
                val res = new StringBuilder
                _elements.zipWithIndex foreach {
                    case (element, index) =>
                        res append element.serrialize(indent + indentSize)
                        if ((element.serrialize() !== newLine) /*&& (index !== 0)*/ )
                            res append newLine
                }
                if (res.length > 0 && res.last === newLine.last)
                    res.toString.substring(0, res.toString().length - 1)
                else
                    res
            } + {
                if (getCursesClose != strEmpty)
                    newLine + spaces(indent) + getCursesClose
                else
                    strEmpty
            }
    }

    override def serrialize1(indent: Int = 0): String = {
        newLine + (_elements map {
            _.serrialize(indent)
        }).mkString(newLine.toString)
    }

    override def serrializeToOneString(indent: Int = 0) = {
        spaces(indent) + getCursesOpen + (_elements map {
            _.serrialize()
        }).mkString(";".space) + /*space +*/ getCursesClose
    }
}

case class ScalaComplexBody(elements: ScalaElement*) extends ScalaBody(elements: _*) {

    override val complexBody: Boolean = true
    override def serrialize1(indent: Int = 0): String = super.serrialize(indent)
}

case object ScalaBodyEmpty extends Body {
    def serrialize(indent: Int) = "{" + newLine + spaces(indent /* - indentSize*/) + "}"
    override def serrializeToOneString(indent: Int) = "{}"
    def length: Int = 0
}

case object ScalaNoBody extends Body {
    def serrialize(indent: Int) = strEmpty
    override def serrializeToOneString(indent: Int) = strEmpty
    def length: Int = 0
}

case class ScalaModule(members: ScalaObjectElement*) extends ScalaElement {
    private val _members = ArrayBuffer(members: _*)

    def getMembers = _members

    def +=(member: ScalaObjectElement) {
        if (_members.length > 0)
            _members += newLine
        _members += member
    }

    def +=(module: ScalaModule) {
        _members ++= module.getMembers
    }

    def ++=(members: ScalaObjectElement*) {
        members foreach +=
    }

    def ++=(members: Array[ScalaObjectElement]) {
        members foreach +=
    }

    def serrialize(indent: Int = 0) = {
        val res = new StringBuilder
        _members foreach {
            member =>
                res append member.serrialize(indent)
        }
        res.toString
    }
}

abstract class AbsScalaExpression extends ScalaElement

case object NoneScalaExpression extends AbsScalaExpression {
    def serrialize(indent: Int) = strEmpty
}

case object WildCarsScalaExpression extends AbsScalaExpression {
    def serrialize(indent: Int) = spaces(indent) + "_"
}

case class ScalaExpression(expression: String) extends AbsScalaExpression {
    def serrialize(indent: Int) = spaces(indent) + expression
}

case class ScalaExpressionBody(body: ScalaBody, serrializeToOneString: Boolean = false) extends AbsScalaExpression {
    def serrialize(indent: Int) = spaces(indent) + (if (serrializeToOneString) body.serrializeToOneString(indent) else body.serrialize(indent))
}

case class ScalaIf(expression: AbsScalaExpression, thenBody: Body = ScalaBodyEmpty, elseBody: Body = ScalaBodyEmpty, serrializeToOneString: Boolean = false) extends If {
    def serrialize(indent: Int): String = {
        val c = space + (if (serrializeToOneString) thenBody.serrializeToOneString(indent) else thenBody.serrialize(indent))

        var a = spaces(indent) +
          space + "if".space +
          "(" +
          expression.serrialize() +
          ")"

        if (thenBody != ScalaBodyEmpty)
            a += c

        val b = (if (serrializeToOneString) strEmpty else newLine + spaces(indent)) + "else".space + (if (serrializeToOneString) elseBody.serrializeToOneString(indent) else elseBody.serrialize(indent))

        if (elseBody != ScalaBodyEmpty)
            a + b
        else
            a
    }
}

case object IfEmpty extends If {
    def serrialize(indent: Int) = strEmpty
}

abstract class AbstractScalaCaseLine extends ScalaElement

case class ScalaCaseLine(expression: AbsScalaExpression = WildCarsScalaExpression, `type`: AbstractScalaType = ScalaImplicitType, guard: If = IfEmpty, caseBody: Body = ScalaBodyEmpty, serrializeToOneString: Boolean = false) extends AbstractScalaCaseLine {
    def serrialize(indent: Int) = {
        val a = spaces(indent) + "case".space + {
            expression match {
                case x: ScalaExpressionBody => if (x.serrializeToOneString) expression.serrialize() else expression.serrialize(indent)
                case _ => expression.serrialize()
            }
        } + {
            if (`type` !== ScalaImplicitType) ":".space + `type`.serrialize() else strEmpty
        } + guard.serrialize().trim + space + "=>".space
        if (serrializeToOneString)
            a + caseBody.serrializeToOneString()
        else
            a + caseBody.serrialize(indent)
    }
}

object ScalaCase {
    def apply(_caseLines: AbstractScalaCaseLine*): ScalaCase = ScalaCase(NoneScalaExpression, _caseLines: _*)
}

case class ScalaCase(expression: AbsScalaExpression, caseLines: AbstractScalaCaseLine*) extends ScalaElement {
    private val _caseLines = ArrayBuffer(caseLines: _*)

    def +=(caseLine: AbstractScalaCaseLine) {
        _caseLines += caseLine
    }

    def ++=(caseLine: AbstractScalaCaseLine*) {
        _caseLines ++= caseLines
    }

    def serrialize(indent: Int) = {
        def getMatch = if (expression != NoneScalaExpression) expression.serrialize(indent) + space + "match".space else strEmpty

        getMatch + "{".newLine +
          (_caseLines map {
              _.serrialize(indent + indentSize)
          }).mkString(newLine) + newLine + spaces(indent) + "}"
    }
}

object ScalaControlBodyWithSuffix {
    def apply(expression: AbsScalaExpression, suffix: String, elements: ScalaElement*) = new ScalaControlBodyWithSuffix(expression = expression, suffix = suffix, elements: _*)
}

class ScalaControlBodyWithSuffix(expression: AbsScalaExpression, suffix: String, elements: ScalaElement*) extends Body {
    private val _elements = ArrayBuffer(elements: _*)

    def +=(element: ScalaElement) {
        _elements += element
    }

    def +=:(element: ScalaElement) {
        _elements.+=:(element)
    }

    def ++=(elements: ScalaElement*) {
        _elements ++= elements
    }

    def ++=:(elements: ScalaElement*) {
        _elements.++=:(elements)
    }

    def length: Int = _elements.length

    /*def serrialize(indent: Int): String = "{".newLine + expression.serrialize(indent + indentSize).space + "=>".newLine + (_elements map {
        _.serrialize(indent + indentSize + indentSize)
    }).mkString(newLine.toString) + newLine + spaces(indent) + "}" + suffix*/

    def serrialize(indent: Int): String = {
        val res = new StringBuilder

        _elements.filter(!_.serrialize().isEmpty) foreach {
            element => element match {
                case x: ScalaSymbol => res.append(space + element.serrialize() + newLine)
                case _ =>
                    expression match {
                        case x: NoneScalaExpression.type => res.append(element.serrialize(indent + indentSize))
                        case _ => res.append(element.serrialize(indent + indentSize + indentSize))
                    }
            }
        }

        if (_elements.length > 0)
            expression match {
                case x: NoneScalaExpression.type => "{".newLine + res.toString + newLine + spaces(indent) + "}" + suffix
                case _ => "{".newLine + expression.serrialize(indent + indentSize).space + "=>".newLine + res.toString + newLine + spaces(indent) + "}" + suffix
            }
        else
            strEmpty
    }

    override def serrializeToOneString(indent: Int): String = serrialize(indent)
}

object ScalaControlBody {
    def apply(): ScalaControlBody = new ScalaControlBody(expression = NoneScalaExpression)
    def apply(elements: ScalaElement*): ScalaControlBody = new ScalaControlBody(expression = NoneScalaExpression, elements: _*)
}
case class ScalaControlBody(expression: AbsScalaExpression, elements: ScalaElement*) extends ScalaControlBodyWithSuffix(expression, strEmpty, elements: _*)

case class ScalaControlStruct(name: String, nameQuoted: Boolean = false, body: Body = ScalaBodyEmpty, serrializeToOneString: Boolean = false) extends ScalaElement {
    def serrialize(indent: Int): String = {
        val res = {
            val x: String = {
                val x = body.serrialize(indent)
                if (x.nonEmpty) {
                    if (x.head === newLine.head)
                        x substring 1
                    else
                        x
                } else x
            }

            if (serrializeToOneString)
                space + x
            else
                newLine + spaces(indent + indentSize) + x
        }
        spaces(indent) + (if (nameQuoted) name.dblQuoted else name) + res
    }
}

abstract class ScalaSymbol extends ScalaElement

case object ScalaPlusPlusSymbol extends ScalaSymbol {
    def serrialize(indent: Int): String = spaces(indent) + "++".space
}

case class ScalaInfixSymbol(left: ScalaElement, symbol: ScalaSymbol, right: ScalaElement) extends Body {
    def serrialize(indent: Int): String = left.serrialize(indent) + space + symbol.serrialize() + newLine + right.serrialize(indent + indentSize)
    override def serrializeToOneString(indent: Int): String = serrialize(indent)
    def length: Int = 1
}

object ScalaSequense {
    def apply(elements: ScalaElement*) = new ScalaSequense(seqName = "Seq", serrializeToOneString = false, printNumberElement = false, elements = (elements: _*))
    def apply(seqName: String, elements: ScalaElement*) = new ScalaSequense(seqName = seqName, serrializeToOneString = false, printNumberElement = false, elements = (elements: _*))
    def apply(seqName: String, printNumberElement: Boolean, elements: ScalaElement*) = new ScalaSequense(seqName = seqName, serrializeToOneString = false, printNumberElement = printNumberElement, elements = (elements: _*))
}

case class ScalaSequense(seqName: String, serrializeToOneString: Boolean, printNumberElement: Boolean, elements: ScalaElement*) extends ScalaElement {
    private val _elements = ArrayBuffer(elements: _*)

    def +=(element: ScalaElement) {
        _elements += element
    }

    override def serrializeToOneString(indent: Int): String = (_elements.zipWithIndex map {
        case (element, index) => element.serrialize() + (if (printNumberElement) space + s"/*${index}*/" else strEmpty)
    }).mkString(spaces(indent) + seqName + "(", space + ",", ")")

    override def serrialize(indent: Int): String =
        if (serrializeToOneString || _elements.length === 1)
            serrializeToOneString(indent)
        else (_elements.zipWithIndex map {
            case (element, index) => element.serrialize() + (if (printNumberElement) space + s"/*${index}*/" else strEmpty)
        }).mkString(spaces(indent) + seqName + "(", "," + newLine + spaces(seqName.length + 1 + indent), ")")

    def ++=(elements: ScalaElement*) {
        _elements ++= elements
    }
}

case class ScalaEquality(left: ScalaBody, signEquality: ScalaSign, right: ScalaBody, serrializeToOneString: Boolean = false) extends Body {
    def serrialize(indent: Int): String = if (serrializeToOneString)
        serrializeToOneString(indent)
    else
        left.serrialize(indent) + signEquality.serrialize(1) + right.serrialize(indent + indentSize)

    override def serrializeToOneString(indent: Int): String = left.serrializeToOneString(indent) + signEquality.serrialize(1) + right.serrializeToOneString(1)
    def length: Int = 1
}

case class ScalaIntValue(value: Int) extends ScalaElement {
    override def serrialize(indent: Int): String = value.toString
}

case class ScalaPackageBody(name: String, elements: ScalaElement*) extends ScalaObjectBody(elements: _*) {
    override val complexBody: Boolean = true
    override def serrialize1(indent: Int = 0): String = spaces(indent) + s"package $name " + super.serrialize(indent)

    override def serrialize(indent: Int): String = spaces(indent) + s"package $name " + super.serrialize(indent = indent + 7)
}
