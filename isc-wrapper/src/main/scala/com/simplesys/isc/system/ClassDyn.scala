package com.simplesys.isc.system

import com.simplesys.isc.system.misc._
import com.simplesys.json.{JsonString, JsonNull, JsonElement, JsonObject}
import com.simplesys.isc.system.global._
import com.simplesys.common.Strings._


object ClassDyn {
    implicit def Class2JsonObject(in: ClassDyn): JsonObject = in json
    //implicit def JSonObjToClassDyn(jsonObject: JsonObject): ClassDyn = new ClassDyn(jsonObject)
    def apply() = new ClassDyn()
    implicit def t12t2(t: (String, String)): (String, JsonElement) = t._1 -> JsonString(t._2)
}

class ClassDyn(val inJson: JsonObject = null,
               override val selfName: String = "Class",
               override val useSelfName: Boolean = false,
               val fabriqueClass: Boolean = false) extends QueuesDyn with ClassDynInit with Misc {

    lazy /*protected*/ val json: JsonObject =
        if (inJson == null) {
            logger trace "Used new Json"
            new JsonObject(selfName = selfName, useSelfName = useSelfName)
        }
        else {
            logger trace "Used inJson"
            new JsonObject(proxy = inJson, selfName = selfName, useSelfName = useSelfName)
        }

    def update(key: String, value: JsonElement) {
        json(key) = value
    }

    def Enqueued = json.getBooleanOpt("enqueued").getOrElse(false)
    def Enqueued_=(value: Boolean) {
        if (Enqueued == value) return
        json("enqueued") = value
    }

    private[this] var operation: String = __operation
    def Operation = operation
    def Operation_=(value: String) {
        operation = value
    }

    def getProperties: String = json.toString()
    def getProperties1: String = json.toString1

    def logProperties {
        logger trace (s"Properties: ${getProperties}")
    }

    def ID = json.getJsonElement("iD").getOrElse(iD)
    def ID_=(value: JsonElement) {
        if (ID == value) return
        json("ID") = value
    }

    def Identifier: JsonElement = json.getJsonElement("identifier").getOrElse(identifier)
    def Identifier_=(value: JsonElement) {
        if (Identifier == value) return
        json("identifier") = value
    }

    def IdArrayItem: String = json.getStringOpt("idArrayItem").getOrElse("")
    def IdArrayItem_=(value: String) {
        if (IdArrayItem == value) return
        json("idArrayItem") = value
    }

    def DeleteItem = json.getBoolOpt("deleteItem").getOrElse(deleteItem)
    def DeleteItem_=(value: Bool) {
        if (DeleteItem == value) return
        json("deleteItem") = value
    }

    def Group = json.getStringOpt("group").getOrElse(group)
    def Group_=(value: String) {
        if (Group == value) return
        json("group") = value
    }

    def Tag = json.getStringOpt("tag").getOrElse(tag)
    def Tag_=(value: String) {
        if (Tag == value) return
        json("tag") = value
    }

    def addProperties(properties: (String, JsonElement)*): ClassDyn = {
        operation = "addProperties"
        properties foreach (_ match {
            case (key, value) => json(key.uncptlz) = value
        })
        this
    }

    override def toString = json toString()

    def toPrettyString = json toPrettyString


    def checkHasClassID(identifier: String = "") {
        if (Identifier.toString.isEmpty) {
            if (identifier.isEmpty) {
                if (!ID.isEmpty)
                    Identifier = ID
                else
                    throw RuntimeIscException("To queue class '%s' must have an Identifier." format selfName)
            }
            else if (Identifier.isEmpty)
                Identifier = identifier.unq
        } else
        if (!identifier.isEmpty && Identifier.isEmpty)
            Identifier = identifier.unq
        /*else
          ID = Identifier*/

        //logger warn (s"To queue class '${selfName}' should have an Identifier.")
    }

    def checkEnQueued {
        if (Enqueued == false)
            throw RuntimeIscException("Class '%s' should be put in queue." format selfName)
    }

    protected def setInstanceCommandEnqueue(command: String) {
        try {
            checkHasClassID()
            val totalCommand = Identifier.toString.unQuoted + "." + command
            val uuid = getUUID(this)

            commandEnqueue(uuid, this.getClass.getSimpleName, totalCommand)
        }
        catch {
            case ex: RuntimeIscException => logger error(ex, ex.message)
        }
    }

    def setClassCommandEnqueue(command: String) {
        try {
            val totalCommand = ModeNames + selfName + "." + command
            val uuid = getUUID(this)

            commandEnqueue(uuid, this.getClass.getSimpleName, totalCommand)
        }
        catch {
            case ex: RuntimeIscException => logger error(ex, ex.message)
        }
    }

    override def equals(obj: Any): Boolean = {
        obj match {
            case claz: ClassDyn =>
                if (claz.IdArrayItem == "" || IdArrayItem == "")
                    false
                else
                    canEqual(obj) && claz.IdArrayItem == IdArrayItem
            case _ =>
                false
        }
    }

    override def hashCode: Int = json.hashCode()
    def canEqual(obj: Any) = obj.isInstanceOf[ClassDyn]

    def add(what: String, properties: JsonObject) {
        commandEnqueue(this, s"${what}(${properties.toString()})")
    }

    def addClassMethods(properties: JsonObject) {
        add(what = "addClassMethods", properties = properties)
    }

    def addClassProperties(properties: JsonObject) {
        add(what = "addClassProperties", properties = properties)
    }
}