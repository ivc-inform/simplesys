package com.simplesys.isc.system

import collection.mutable.Queue
import collection.mutable
import com.simplesys.script.JsBeautifier
import com.simplesys.log.Logging
import com.simplesys.common.Strings._
import global._
import misc._
import com.simplesys.json.{JsonNull, JsonElement}

object QueuesDyn {
    def getComponentLineOnlyJson(_class: ClassDyn): String = _class.getProperties1
}

object ResultDefineClasss {
    def apply(name: String, newClass: QueuesDyn) = new ResultDefineClasss(name, newClass)
}

class ResultDefineClasss(val name: String, val newClass: QueuesDyn) {
    def addProperties(properties: JsonElement): ResultDefineClasss = {
        val res = newClass add(destination = name, what = "addProperties", properties = properties)
        ResultDefineClasss(name, res)
    }

    def addDefaults(properties: JsonElement): ResultDefineClasss = {
        val res = newClass add(destination = name, what = "addDefaults", properties = properties)
        ResultDefineClasss(name, res)
    }

    def addClassProperties(properties: JsonElement): ResultDefineClasss = {
        val res = newClass addClass(destination = name, what = "addProperties", properties = properties)
        ResultDefineClasss(name, res)
    }

    def addClassDefaults(properties: JsonElement): ResultDefineClasss = {
        val res = newClass addClass(destination = name, what = "addDefaults", properties = properties)
        ResultDefineClasss(name, res)
    }
}

trait QueuesDyn extends Logging with Uuid {
    //Очередь JS команд
    protected val commandQueue = Queue.empty[(String, String, String)]
    def CommandQueue = commandQueue

    //Очередь объявлений переменных var в JS коде
    protected val varQueue = mutable.HashMap.empty[String, VarExp]

    protected val semiColon = ";"

    def getCommandLine(className: String = "all", lastSemicolon: String = semiColon): String = {
        val res = className match {
            case "all" => commandQueue map {
                case (uuid, className, command) => command
            } mkString (semiColon.newLine.newLine)
            case _ => commandQueue filter {
                case (uuid, _className, command) => _className == className
            } map {
                case (uuid, _className, command) => command
            } mkString semiColon
        }

        if (res.isEmpty)
            res
        else
            res + lastSemicolon
    }

    protected def getComponentLine(_class: ClassDyn): String = {
        ModeNames + _class.selfName + "." +
          (_class.Operation match {
              case "" => "create"
              case any => any
          }) + "(" + _class.getProperties1 + ")"
    }

    def getComponentLine1: String = getComponentLine(this.asInstanceOf[ClassDyn]) + semiColon

    def getBeautifilerCommandLine(className: String = "all"): String = JsBeautifier(getCommandLine(className))

    def logCommandsQueue(className: String = "all") {
        getCommandLine(className) split (semiColon) foreach (command => logger.debug(s"Command: ${command + ";"}"))
    }

    def logCommandLine(className: String = "all") {
        logger trace (s"Command line: ${JsBeautifier(getCommandLine(className))}")
    }

    def checkExistVariable(variableName: String) {
        varQueue get variableName match {
            case None =>
            case _ =>
                throw RuntimeIscException("The variable '%s' is already declared." format variableName)
        }
    }

    def checkNotExistVariable(variableName: String) {
        varQueue get variableName match {
            case None =>
                throw RuntimeIscException("The variable '%s' is is not exist." format variableName)
            case _ =>
        }
    }

    protected def commandEnqueue(uuid: String, className: String, command: String) {
        if (className == "")
            throw RuntimeIscException("Queue was not performed due to lack of class name")
        else {
            commandQueue enqueue ((uuid, className, command))
            logger trace (s"commandEnqueue: (ID Command Queue:${guid}, classID:${uuid}, className: ${className}, command: ${command})")
        }
    }

    def commandEnqueue(_class: AnyRef, command: String) {
        val totalCommand = ModeNames + {
            val cls = _class.getClass.getSimpleName
            if (cls contains "anon")
                ""
            else
                cls + "."
        } + command
        val uuid = getUUID(_class)

        commandEnqueue(uuid, _class.getClass.getSimpleName, totalCommand)
    }

    def commandEnqueue1(_class: AnyRef, command: String) {
        val totalCommand = command
        val uuid = getUUID(_class)

        commandEnqueue(uuid, _class.getClass.getSimpleName, totalCommand)
    }

    def commandEnqueue(_class: ClassDyn, command: String) {
        val totalCommand = ModeNames + {
            _class.selfName + "."
        } + command
        val uuid = getUUID(_class)

        commandEnqueue(uuid, _class.getClass.getSimpleName, totalCommand)
    }

    def componentEnqueue(_class: ClassDyn, _var: (String, Boolean) = null, componentLine: (ClassDyn => String) = getComponentLine) {
        if (_class.Enqueued)
            logger warn (_class.getClass.getSimpleName + " has been enqueued repeatedly.")
        //return

        if (!_class.fabriqueClass) {
            if (_var == null)
                _class.checkHasClassID()
            else
                _class.checkHasClassID(_var._1)

            val uuid = getUUID(_class)

            val className: String = if (_class.ID.toString == "") {
                if (_class.Identifier == JsonNull)
                    _class.getClass.getSimpleName
                else
                    _class.Identifier
            } else
                _class.ID

            commandEnqueue(uuid, className, (_var match {
                case (name, global) if name != "" =>
                    if (name == "return")
                        name + " "
                    else if (!global)
                        "var " + name + " = "
                    else
                        name + " = "

                case _ => ""
            }) + componentLine(_class))

            if (_class.ID.toString != "")
                varQueue += (_class.ID.toString -> null)
        }

        commandQueue ++= _class.CommandQueue
        _class.Enqueued = true
    }

    def addCommandQueue(queue: QueuesDyn) {
        commandQueue ++= queue.CommandQueue
    }

    def componentsEnqueue(classes: ClassDyn*) {
        classes foreach (clazz => componentEnqueue(clazz))
    }

    protected def commandEnqueue(_class: AnyRef, variable: String, command: String) {
        val totalCommand = "var " + variable + " = " + ModeNames + _class.getClass.getSimpleName + "." + command
        val uuid = getUUID(_class)

        commandEnqueue(uuid, _class.getClass.getSimpleName, totalCommand)
    }

    protected def getUUID(_class: AnyRef): String = {
        _class match {
            case x: Uuid => x.guid
            case _ => ""
        }
    }

    def logModeNames {
        logger trace (s"ModeNames: ${ModeNames}")
    }

    def logVariablesQueue {
        varQueue foreach {
            case (varName, varRight) =>
                varRight match {
                    case varFuncExpr: VarFuncExp =>
                        if (varFuncExpr.enqueue) {
                            if (varFuncExpr.variableName == "")
                                logger trace mkFunctionDecl(varFuncExpr funcName, varFuncExpr funcBody, varFuncExpr funcParams)
                            else
                                logger trace (s"var  ${varName} = ${mkFunctionDecl(varFuncExpr funcName, varFuncExpr funcBody, varFuncExpr funcParams)}")
                        }
                        else
                            logger trace mkFunctionDecl(varFuncExpr funcName, varFuncExpr funcBody, varFuncExpr funcParams)
                    case varExp: VarExp => logger trace (s"var ${varName} = ${varExp.rHandExpr}")
                }
        }
    }

    private def getParams(params: String*) = params mkString ","

    def getCommandLine: String = getCommandLine("all")

    //Без заврещающей ';'
    def getCommandLineWithoutEndSemicolon: String = getCommandLine("all", "")

    @throws(classOf[RuntimeIscException])
    def getFunctionExpressionOpt(funcName: String) =
        varQueue get funcName match {
            case None => throw new RuntimeIscException("The function '%s' not exists." format funcName)
            case Some(expr) => FunctionExpression(expr)
        }


    def jsDeclareVarEnqueue(_class: AnyRef = null, variableName: String, rightPart: String, queue: Boolean = true) {
        try {
            checkExistVariable(variableName)

            val totalCommand = "var " + variableName + " = " + rightPart
            val uuid = getUUID(_class)
            if (queue)
                commandEnqueue(uuid, _class.getClass.getSimpleName, totalCommand)
            varQueue += (variableName -> VarExp(rightPart))
        }
        catch {
            case ex: RuntimeIscException => logger error(ex, ex.message)
        }
    }

    /*
      var variableName = function () {funcBody}
      enqueue см. Базовый метод определения ф-ции
    */

    @throws(classOf[RuntimeIscException])
    def declareJSFunctionExpr(_class: AnyRef, variableName: String, variableGlobal: Boolean, funcBody: String, enqueue: Boolean = false): FunctionExpression =
        declareJSFunction(_class, variableName, variableGlobal, "", funcBody, enqueue)

    /*
     var variableName = function (funcParams) {funcBody}
     enqueue см. Базовый метод определения ф-ции
    */

    @throws(classOf[RuntimeIscException])
    def declareJSFunctionExpr(_class: AnyRef, variableName: String, variableGlobal: Boolean, funcBody: String, enqueue: Boolean, funcParams: String*): FunctionExpression =
        declareJSFunction(_class, variableName, variableGlobal, "", funcBody, enqueue, funcParams: _*)

    /*function funcName () {funcBody}
    enqueue см. Базовый метод определения ф-ции*/

    @throws(classOf[RuntimeIscException])
    def declareJSFunction(_class: AnyRef, funcName: String, funcBody: String, enqueue: Boolean = false): FunctionExpression =
        declareJSFunction(_class, "", false, funcName, funcBody, enqueue)

    /*function funcName (funcParams) {funcBody}
    enqueue см. Базовый метод определения ф-ции*/

    @throws(classOf[RuntimeIscException])
    def declareJSFunction(_class: AnyRef, funcName: String, funcBody: String, enqueue: Boolean, funcParams: String*): FunctionExpression =
        declareJSFunction(_class, "", false, funcName, funcBody, enqueue, funcParams: _*)

    // Базовый метод определения ф-ции
    // enqueue - помещать ли функцию в очередь комманд, если да то она объявляется как отдельная функция, если нет то прикрепляется к полю для непосредственного вызова
    // variableGlobal если true => varName = function ... если нет то var varName = function ...
    @throws(classOf[RuntimeIscException])
    def declareJSFunction(_class: AnyRef, variableName: String, variableGlobal: Boolean, funcName: String, funcBody: String, enqueue: Boolean, funcParams: String*): FunctionExpression = {
        var vn = ""
        try {
            variableName match {
                case "" =>
                    if (enqueue) {
                        checkExistVariable(funcName)
                        commandEnqueue(getUUID(_class), _class.getClass.getSimpleName, mkFunctionDecl(funcName, funcBody, funcParams))
                        vn = funcName
                    }
                case str =>
                    if (enqueue) {
                        checkExistVariable(variableName)
                        commandEnqueue(getUUID(_class), _class.getClass.getSimpleName, (if (variableGlobal) "" else "var ") + "%s=%s" format(str, mkFunctionDecl(funcName, funcBody, funcParams)))
                        vn = str
                    }
            }

            val varExpr = VarFuncExp(enqueue, variableName, funcName, funcBody, funcParams)
            varQueue += (vn -> varExpr)
            FunctionExpression(varExpr)
        }
        catch {
            case ex: RuntimeIscException =>
                logger error(ex, ex.message)
                "".f
        }
    }

    def add(destination: String, what: String, properties: JsonElement) = {
        commandEnqueue(this, s"${what}(${destination}, ${properties.toString()})")
        this
    }

    def addClass(destination: String, what: String, properties: JsonElement) = {
        commandEnqueue(this, s"${destination}.${what}(${properties.toString()})")
        this
    }

    def addProperties(destination: String, properties: JsonElement) = {
        add(destination = destination, what = "addProperties", properties = properties)
    }

    def addGlobal(destination: String, properties: JsonElement) = {
        add(destination = destination, what = "addGlobal", properties = properties)
    }

    def addDefaults(destination: String, properties: JsonElement) = {
        add(destination = destination, what = "addDefaults", properties = properties)
    }

    def addClassProperties(destination: String, properties: JsonElement) = {
        addClass(destination = destination, what = "addProperties", properties = properties)
    }

    def addClassDefaults(destination: String, properties: JsonElement) = {
        addClass(destination = destination, what = "addDefaults", properties = properties)
    }

    def defineClass(child: String, parent: JsonElement): ResultDefineClasss = {
        commandEnqueue(this, s"defineClass(${child.dblQuoted},${parent.toString})")
        ResultDefineClasss(child, this)
    }
}