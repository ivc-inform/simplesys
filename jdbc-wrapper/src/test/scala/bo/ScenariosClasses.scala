// This file is generated automatically (at 28.03.2017 13:23:44), do not spend any changes here, because they will be lost. Generator: "SchemaDefMetaGen (generateClasses)"
package ru.simplesys.defs.bo
package scenarios


import org.joda.time.{DateTime, LocalDateTime}
import ru.simplesys.meta.types.{MetaType, Domain}
import ru.simplesys.meta._
import ru.simplesys.coreutil.{SealedEnumRuntime, SealedCaseClassEnum}
import com.simplesys.jdbc._
import com.simplesys.json.JsonString
import com.simplesys.corelibrary.domain._
import com.simplesys.common.array._
import com.simplesys.jdbc.control.clob._

 

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class Scr_CmpgnPK(id_cmpgn: Long) extends BOReference[Scr_Cmpgn]

case class Scr_CmpgnAKCode_cmpgn(code_cmpgn: String) extends BOReference[Scr_Cmpgn]

case class Scr_Cmpgn (
  id_cmpgn: Long,
  code_cmpgn: String,
  caption_cmpgn: String,
  description_cmpgn: Option[String],
  begin_cmpgn: Option[LocalDateTime],
  end_cmpgn: Option[LocalDateTime],
  active_cmpgn: Option[Boolean],
  parent_cmpgn: Option[Long]) extends Product {

  val pk: Scr_CmpgnPK = Scr_CmpgnPK(id_cmpgn)
  val ucCode_cmpgn: Scr_CmpgnAKCode_cmpgn = Scr_CmpgnAKCode_cmpgn(code_cmpgn)
  val frParent_cmpgn: Option[Scr_CmpgnPK] = parent_cmpgn.map(Scr_CmpgnPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_Cmpgn]
  override def productArity: Int = 8
  override def productElement(n: Int): Any = n match {
    case 0 => active_cmpgn
    case 1 => begin_cmpgn
    case 2 => caption_cmpgn
    case 3 => code_cmpgn
    case 4 => description_cmpgn
    case 5 => end_cmpgn
    case 6 => id_cmpgn
    case 7 => parent_cmpgn
  }
}

object Scr_Cmpgn {
   def apply(pk: Scr_CmpgnPK, code_cmpgn: String, caption_cmpgn: String, description_cmpgn: Option[String], begin_cmpgn: Option[LocalDateTime], end_cmpgn: Option[LocalDateTime], active_cmpgn: Option[Boolean], frParent_cmpgn: Scr_CmpgnPK) = new Scr_Cmpgn(id_cmpgn = pk.id_cmpgn, code_cmpgn = code_cmpgn, caption_cmpgn = caption_cmpgn, description_cmpgn = description_cmpgn, begin_cmpgn = begin_cmpgn, end_cmpgn = end_cmpgn, active_cmpgn = active_cmpgn, parent_cmpgn = Some(frParent_cmpgn).map(_.id_cmpgn))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioPK(id_scenario: Long) extends BOReference[Scr_Scenario]

case class Scr_ScenarioAKCode_scenario(code_scenario: String) extends BOReference[Scr_Scenario]

case class Scr_Scenario (
  id_scenario: Long,
  version: Option[LocalDateTime],
  code_scenario: String,
  caption_scenario: String,
  description_scenario: Option[String],
  begin_scenario: Option[LocalDateTime],
  end_scenario: Option[LocalDateTime],
  status: Option[Long],
  debug_mode: Option[Boolean],
  id_cmpgn: Option[Long]) extends Product {

  val pk: Scr_ScenarioPK = Scr_ScenarioPK(id_scenario)
  val ucCode_scenario: Scr_ScenarioAKCode_scenario = Scr_ScenarioAKCode_scenario(code_scenario)
  val frId_cmpgn: Option[Scr_CmpgnPK] = id_cmpgn.map(Scr_CmpgnPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_Scenario]
  override def productArity: Int = 10
  override def productElement(n: Int): Any = n match {
    case 0 => begin_scenario
    case 1 => caption_scenario
    case 2 => code_scenario
    case 3 => debug_mode
    case 4 => description_scenario
    case 5 => end_scenario
    case 6 => id_cmpgn
    case 7 => id_scenario
    case 8 => status
    case 9 => version
  }
}

object Scr_Scenario {
   def apply(pk: Scr_ScenarioPK, version: Option[LocalDateTime], code_scenario: String, caption_scenario: String, description_scenario: Option[String], begin_scenario: Option[LocalDateTime], end_scenario: Option[LocalDateTime], status: Option[Long], debug_mode: Option[Boolean], frId_cmpgn: Scr_CmpgnPK) = new Scr_Scenario(id_scenario = pk.id_scenario, version = version, code_scenario = code_scenario, caption_scenario = caption_scenario, description_scenario = description_scenario, begin_scenario = begin_scenario, end_scenario = end_scenario, status = status, debug_mode = debug_mode, id_cmpgn = Some(frId_cmpgn).map(_.id_cmpgn))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioJsonStorage_scenario (
  val id_scenario: Long,
  val jsonStorage_scenario: Option[Json]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_ScenarioJsonStorage_scenario]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => id_scenario
    case 1 => jsonStorage_scenario
  }
}

object Scr_ScenarioJsonStorage_scenario {
   def apply(pk: Scr_ScenarioPK, jsonStorage_scenario: Option[Json]) = new Scr_ScenarioJsonStorage_scenario(id_scenario = pk.id_scenario, jsonStorage_scenario = jsonStorage_scenario)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioClobConfig (
  val id_scenario: Long,
  val clobConfig: Option[Clob]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_ScenarioClobConfig]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => clobConfig
    case 1 => id_scenario
  }
}

object Scr_ScenarioClobConfig {
   def apply(pk: Scr_ScenarioPK, clobConfig: Option[Clob]) = new Scr_ScenarioClobConfig(id_scenario = pk.id_scenario, clobConfig = clobConfig)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioClobConfigError (
  val id_scenario: Long,
  val clobConfigError: Option[Clob]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_ScenarioClobConfigError]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => clobConfigError
    case 1 => id_scenario
  }
}

object Scr_ScenarioClobConfigError {
   def apply(pk: Scr_ScenarioPK, clobConfigError: Option[Clob]) = new Scr_ScenarioClobConfigError(id_scenario = pk.id_scenario, clobConfigError = clobConfigError)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioExeCode (
  val id_scenario: Long,
  val exeCode: Option[Clob]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_ScenarioExeCode]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => exeCode
    case 1 => id_scenario
  }
}

object Scr_ScenarioExeCode {
   def apply(pk: Scr_ScenarioPK, exeCode: Option[Clob]) = new Scr_ScenarioExeCode(id_scenario = pk.id_scenario, exeCode = exeCode)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_ScenarioExeCodeError (
  val id_scenario: Long,
  val exeCodeError: Option[Clob]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_ScenarioExeCodeError]
  override def productArity: Int = 2
  override def productElement(n: Int): Any = n match {
    case 0 => exeCodeError
    case 1 => id_scenario
  }
}

object Scr_ScenarioExeCodeError {
   def apply(pk: Scr_ScenarioPK, exeCodeError: Option[Clob]) = new Scr_ScenarioExeCodeError(id_scenario = pk.id_scenario, exeCodeError = exeCodeError)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class Scr_Graph_CopiesPK(id: Long, id_scenario_ref: Long) extends BOReference[Scr_Graph_Copies]

case class Scr_Graph_Copies (
  id: Long,
  version: LocalDateTime,
  description_copy: Option[String],
  id_scenario_ref: Long) extends Product {

  val pk: Scr_Graph_CopiesPK = Scr_Graph_CopiesPK(id, id_scenario_ref)
  val frId_scenario_ref: Scr_ScenarioPK = Scr_ScenarioPK(id_scenario_ref)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_Graph_Copies]
  override def productArity: Int = 4
  override def productElement(n: Int): Any = n match {
    case 0 => description_copy
    case 1 => id
    case 2 => id_scenario_ref
    case 3 => version
  }
}

object Scr_Graph_Copies {
   def apply(pk: Scr_Graph_CopiesPK, version: LocalDateTime, description_copy: Option[String], frId_scenario_ref: Scr_ScenarioPK) = new Scr_Graph_Copies(id = pk.id, version = version, description_copy = description_copy, id_scenario_ref = pk.id_scenario_ref)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class Scr_Graph_CopiesJsonStorage_scenario (
  val id: Long,
  val id_scenario_ref: Long,
  val jsonStorage_scenario: Option[Json]) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Scr_Graph_CopiesJsonStorage_scenario]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => id
    case 1 => id_scenario_ref
    case 2 => jsonStorage_scenario
  }
}

object Scr_Graph_CopiesJsonStorage_scenario {
   def apply(pk: Scr_Graph_CopiesPK, jsonStorage_scenario: Option[Json]) = new Scr_Graph_CopiesJsonStorage_scenario(id = pk.id, id_scenario_ref = pk.id_scenario_ref, jsonStorage_scenario = jsonStorage_scenario)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class TestGroupPK(id: Long) extends BOReference[TestGroup]

case class TestGroupAKCodeGroup(codeGroup: String) extends BOReference[TestGroup]

case class TestGroup (
  id: Long,
  codeGroup: String,
  captionGroup: Option[String],
  descriptionGroup: Option[String],
  active: Boolean,
  status: Option[Long],
  parent: Option[Long]) extends Product {

  val pk: TestGroupPK = TestGroupPK(id)
  val ucCodeGroup: TestGroupAKCodeGroup = TestGroupAKCodeGroup(codeGroup)
  val frParent: Option[TestGroupPK] = parent.map(TestGroupPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[TestGroup]
  override def productArity: Int = 7
  override def productElement(n: Int): Any = n match {
    case 0 => active
    case 1 => captionGroup
    case 2 => codeGroup
    case 3 => descriptionGroup
    case 4 => id
    case 5 => parent
    case 6 => status
  }
}

object TestGroup {
   def apply(pk: TestGroupPK, codeGroup: String, captionGroup: Option[String], descriptionGroup: Option[String], active: Boolean, status: Option[Long], frParent: TestGroupPK) = new TestGroup(id = pk.id, codeGroup = codeGroup, captionGroup = captionGroup, descriptionGroup = descriptionGroup, active = active, status = status, parent = Some(frParent).map(_.id))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class TestPK(id: Long) extends BOReference[Test]

case class TestAKCodeTest(codeTest: Option[String]) extends BOReference[Test]

case class Test (
  id: Long,
  timestamp: LocalDateTime,
  createDate: Option[LocalDateTime],
  codeTest: Option[String],
  captionTest: Option[String],
  descriptionTest: Option[String],
  address: String,
  text: String,
  active: Boolean,
  group: Long) extends Product {

  val pk: TestPK = TestPK(id)
  val ucCodeTest: TestAKCodeTest = TestAKCodeTest(codeTest)
  val frGroup: TestGroupPK = TestGroupPK(group)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Test]
  override def productArity: Int = 10
  override def productElement(n: Int): Any = n match {
    case 0 => active
    case 1 => address
    case 2 => captionTest
    case 3 => codeTest
    case 4 => createDate
    case 5 => descriptionTest
    case 6 => group
    case 7 => id
    case 8 => text
    case 9 => timestamp
  }
}

object Test {
   def apply(pk: TestPK, timestamp: LocalDateTime, createDate: Option[LocalDateTime], codeTest: Option[String], captionTest: Option[String], descriptionTest: Option[String], address: String, text: String, active: Boolean, frGroup: TestGroupPK) = new Test(id = pk.id, timestamp = timestamp, createDate = createDate, codeTest = codeTest, captionTest = captionTest, descriptionTest = descriptionTest, address = address, text = text, active = active, group = frGroup.id)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ScenarioTracePK(id: Long) extends BOReference[ScenarioTrace]

case class ScenarioTrace (
  id: Long,
  timestamp: LocalDateTime,
  address: String,
  event: String,
  scenario: String,
  stage: String,
  parentstage: Option[String],
  bonusbase: Option[Double],
  idbonusmessage: Option[Long],
  bonusmessage: Option[String],
  idmarketingmessage: Option[Long],
  marketingmessage: Option[String],
  actiontype: Option[String],
  idactionmessage: Option[Long],
  actionmessage: Option[String],
  actionobject: Option[String]) extends Product {

  val pk: ScenarioTracePK = ScenarioTracePK(id)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[ScenarioTrace]
  override def productArity: Int = 16
  override def productElement(n: Int): Any = n match {
    case 0 => actionmessage
    case 1 => actionobject
    case 2 => actiontype
    case 3 => address
    case 4 => bonusbase
    case 5 => bonusmessage
    case 6 => event
    case 7 => id
    case 8 => idactionmessage
    case 9 => idbonusmessage
    case 10 => idmarketingmessage
    case 11 => marketingmessage
    case 12 => parentstage
    case 13 => scenario
    case 14 => stage
    case 15 => timestamp
  }
}

object ScenarioTrace {
   def apply(pk: ScenarioTracePK, timestamp: LocalDateTime, address: String, event: String, scenario: String, stage: String, parentstage: Option[String], bonusbase: Option[Double], idbonusmessage: Option[Long], bonusmessage: Option[String], idmarketingmessage: Option[Long], marketingmessage: Option[String], actiontype: Option[String], idactionmessage: Option[Long], actionmessage: Option[String], actionobject: Option[String]) = new ScenarioTrace(id = pk.id, timestamp = timestamp, address = address, event = event, scenario = scenario, stage = stage, parentstage = parentstage, bonusbase = bonusbase, idbonusmessage = idbonusmessage, bonusmessage = bonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, actiontype = actiontype, idactionmessage = idactionmessage, actionmessage = actionmessage, actionobject = actionobject)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ScenarioTrace_DebugPK(id: Long) extends BOReference[ScenarioTrace_Debug]

case class ScenarioTrace_Debug (
  id: Long,
  timestamp: LocalDateTime,
  address: String,
  event: String,
  scenario: String,
  stage: String,
  parentstage: Option[String],
  bonusbase: Option[Double],
  idbonusmessage: Option[Long],
  bonusmessage: Option[String],
  idmarketingmessage: Option[Long],
  marketingmessage: Option[String],
  actiontype: Option[String],
  idactionmessage: Option[Long],
  actionmessage: Option[String],
  actionobject: Option[String]) extends Product {

  val pk: ScenarioTrace_DebugPK = ScenarioTrace_DebugPK(id)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[ScenarioTrace_Debug]
  override def productArity: Int = 16
  override def productElement(n: Int): Any = n match {
    case 0 => actionmessage
    case 1 => actionobject
    case 2 => actiontype
    case 3 => address
    case 4 => bonusbase
    case 5 => bonusmessage
    case 6 => event
    case 7 => id
    case 8 => idactionmessage
    case 9 => idbonusmessage
    case 10 => idmarketingmessage
    case 11 => marketingmessage
    case 12 => parentstage
    case 13 => scenario
    case 14 => stage
    case 15 => timestamp
  }
}

object ScenarioTrace_Debug {
   def apply(pk: ScenarioTrace_DebugPK, timestamp: LocalDateTime, address: String, event: String, scenario: String, stage: String, parentstage: Option[String], bonusbase: Option[Double], idbonusmessage: Option[Long], bonusmessage: Option[String], idmarketingmessage: Option[Long], marketingmessage: Option[String], actiontype: Option[String], idactionmessage: Option[Long], actionmessage: Option[String], actionobject: Option[String]) = new ScenarioTrace_Debug(id = pk.id, timestamp = timestamp, address = address, event = event, scenario = scenario, stage = stage, parentstage = parentstage, bonusbase = bonusbase, idbonusmessage = idbonusmessage, bonusmessage = bonusmessage, idmarketingmessage = idmarketingmessage, marketingmessage = marketingmessage, actiontype = actiontype, idactionmessage = idactionmessage, actionmessage = actionmessage, actionobject = actionobject)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class PersistenceJournalPK(persistence_id: String, sequence_number: Long) extends BOReference[PersistenceJournal]

case class PersistenceJournal (
  timestamp: LocalDateTime,
  ordering: Option[Long],
  deleted: Option[Boolean],
  created: Long,
  persistence_id: String,
  sequence_number: Long,
  tags: Option[String]) extends Product {

  val pk: PersistenceJournalPK = PersistenceJournalPK(persistence_id, sequence_number)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceJournal]
  override def productArity: Int = 7
  override def productElement(n: Int): Any = n match {
    case 0 => created
    case 1 => deleted
    case 2 => ordering
    case 3 => persistence_id
    case 4 => sequence_number
    case 5 => tags
    case 6 => timestamp
  }
}

object PersistenceJournal {
   def apply(pk: PersistenceJournalPK, timestamp: LocalDateTime, ordering: Option[Long], deleted: Option[Boolean], created: Long, tags: Option[String]) = new PersistenceJournal(timestamp = timestamp, ordering = ordering, deleted = deleted, created = created, persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, tags = tags)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class PersistenceJournalMessage (
  val persistence_id: String,
  val sequence_number: Long,
  val message: Blob) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceJournalMessage]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => message
    case 1 => persistence_id
    case 2 => sequence_number
  }
}

object PersistenceJournalMessage {
   def apply(pk: PersistenceJournalPK, message: Blob) = new PersistenceJournalMessage(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, message = message)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class PersistenceJournal_DebugPK(persistence_id: String, sequence_number: Long) extends BOReference[PersistenceJournal_Debug]

case class PersistenceJournal_Debug (
  timestamp: LocalDateTime,
  ordering: Option[Long],
  deleted: Option[Boolean],
  created: Long,
  persistence_id: String,
  sequence_number: Long,
  tags: Option[String]) extends Product {

  val pk: PersistenceJournal_DebugPK = PersistenceJournal_DebugPK(persistence_id, sequence_number)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceJournal_Debug]
  override def productArity: Int = 7
  override def productElement(n: Int): Any = n match {
    case 0 => created
    case 1 => deleted
    case 2 => ordering
    case 3 => persistence_id
    case 4 => sequence_number
    case 5 => tags
    case 6 => timestamp
  }
}

object PersistenceJournal_Debug {
   def apply(pk: PersistenceJournal_DebugPK, timestamp: LocalDateTime, ordering: Option[Long], deleted: Option[Boolean], created: Long, tags: Option[String]) = new PersistenceJournal_Debug(timestamp = timestamp, ordering = ordering, deleted = deleted, created = created, persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, tags = tags)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class PersistenceJournal_DebugMessage (
  val persistence_id: String,
  val sequence_number: Long,
  val message: Blob) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceJournal_DebugMessage]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => message
    case 1 => persistence_id
    case 2 => sequence_number
  }
}

object PersistenceJournal_DebugMessage {
   def apply(pk: PersistenceJournal_DebugPK, message: Blob) = new PersistenceJournal_DebugMessage(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, message = message)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class PersistenceSnapshotPK(persistence_id: String, sequence_number: Long) extends BOReference[PersistenceSnapshot]

case class PersistenceSnapshot (
  persistence_id: String,
  sequence_number: Long,
  timestamp: LocalDateTime,
  created: Option[Long]) extends Product {

  val pk: PersistenceSnapshotPK = PersistenceSnapshotPK(persistence_id, sequence_number)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceSnapshot]
  override def productArity: Int = 4
  override def productElement(n: Int): Any = n match {
    case 0 => created
    case 1 => persistence_id
    case 2 => sequence_number
    case 3 => timestamp
  }
}

object PersistenceSnapshot {
   def apply(pk: PersistenceSnapshotPK, timestamp: LocalDateTime, created: Option[Long]) = new PersistenceSnapshot(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, timestamp = timestamp, created = created)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class PersistenceSnapshotSnapshot (
  val persistence_id: String,
  val sequence_number: Long,
  val snapshot: Blob) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceSnapshotSnapshot]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => persistence_id
    case 1 => sequence_number
    case 2 => snapshot
  }
}

object PersistenceSnapshotSnapshot {
   def apply(pk: PersistenceSnapshotPK, snapshot: Blob) = new PersistenceSnapshotSnapshot(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, snapshot = snapshot)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class PersistenceSnapshot_DebugPK(persistence_id: String, sequence_number: Long) extends BOReference[PersistenceSnapshot_Debug]

case class PersistenceSnapshot_Debug (
  persistence_id: String,
  sequence_number: Long,
  timestamp: LocalDateTime,
  created: Option[Long]) extends Product {

  val pk: PersistenceSnapshot_DebugPK = PersistenceSnapshot_DebugPK(persistence_id, sequence_number)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceSnapshot_Debug]
  override def productArity: Int = 4
  override def productElement(n: Int): Any = n match {
    case 0 => created
    case 1 => persistence_id
    case 2 => sequence_number
    case 3 => timestamp
  }
}

object PersistenceSnapshot_Debug {
   def apply(pk: PersistenceSnapshot_DebugPK, timestamp: LocalDateTime, created: Option[Long]) = new PersistenceSnapshot_Debug(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, timestamp = timestamp, created = created)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithLob) //////////////////////////////////////////////////////////////////////////
case class PersistenceSnapshot_DebugSnapshot (
  val persistence_id: String,
  val sequence_number: Long,
  val snapshot: Blob) extends Product {

  override def canEqual(that: Any): Boolean = that.isInstanceOf[PersistenceSnapshot_DebugSnapshot]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => persistence_id
    case 1 => sequence_number
    case 2 => snapshot
  }
}

object PersistenceSnapshot_DebugSnapshot {
   def apply(pk: PersistenceSnapshot_DebugPK, snapshot: Blob) = new PersistenceSnapshot_DebugSnapshot(persistence_id = pk.persistence_id, sequence_number = pk.sequence_number, snapshot = snapshot)
}
//////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithLob) ////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ListGroupsPK(id_listGroup: Long) extends BOReference[ListGroups]

case class ListGroupsAKCode_listGroup(code_listGroup: String) extends BOReference[ListGroups]

case class ListGroups (
  id_listGroup: Long,
  code_listGroup: String,
  caption_listGroup: String,
  description_listGroup: Option[String],
  parent_listGroup: Option[Long]) extends Product {

  val pk: ListGroupsPK = ListGroupsPK(id_listGroup)
  val ucCode_listGroup: ListGroupsAKCode_listGroup = ListGroupsAKCode_listGroup(code_listGroup)
  val frParent_listGroup: Option[ListGroupsPK] = parent_listGroup.map(ListGroupsPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ListGroups]
  override def productArity: Int = 5
  override def productElement(n: Int): Any = n match {
    case 0 => caption_listGroup
    case 1 => code_listGroup
    case 2 => description_listGroup
    case 3 => id_listGroup
    case 4 => parent_listGroup
  }
}

object ListGroups {
   def apply(pk: ListGroupsPK, code_listGroup: String, caption_listGroup: String, description_listGroup: Option[String], frParent_listGroup: ListGroupsPK) = new ListGroups(id_listGroup = pk.id_listGroup, code_listGroup = code_listGroup, caption_listGroup = caption_listGroup, description_listGroup = description_listGroup, parent_listGroup = Some(frParent_listGroup).map(_.id_listGroup))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ListsPK(id_list: Long) extends BOReference[Lists]

case class ListsAKCode_list(code_list: String) extends BOReference[Lists]

case class Lists (
  id_list: Long,
  code_list: String,
  type_list: String,
  caption_list: String,
  description_list: Option[String],
  id_listGroup_ref: Option[Long]) extends Product {

  val pk: ListsPK = ListsPK(id_list)
  val ucCode_list: ListsAKCode_list = ListsAKCode_list(code_list)
  val frId_listGroup_ref: Option[ListGroupsPK] = id_listGroup_ref.map(ListGroupsPK(_))

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Lists]
  override def productArity: Int = 6
  override def productElement(n: Int): Any = n match {
    case 0 => caption_list
    case 1 => code_list
    case 2 => description_list
    case 3 => id_list
    case 4 => id_listGroup_ref
    case 5 => type_list
  }
}

object Lists {
   def apply(pk: ListsPK, code_list: String, type_list: String, caption_list: String, description_list: Option[String], frId_listGroup_ref: ListGroupsPK) = new Lists(id_list = pk.id_list, code_list = code_list, type_list = type_list, caption_list = caption_list, description_list = description_list, id_listGroup_ref = Some(frId_listGroup_ref).map(_.id_listGroup))
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ListElementsPK(id_list_element: Long) extends BOReference[ListElements]

case class ListElementsAKId_listElement_list(id_list: Long, element_list: String) extends BOReference[ListElements]

case class ListElements (
  id_list_element: Long,
  element_list: String,
  id_list: Long) extends Product {

  val pk: ListElementsPK = ListElementsPK(id_list_element)
  val ucId_listElement_list: ListElementsAKId_listElement_list = ListElementsAKId_listElement_list(id_list, element_list)
  val frId_list: ListsPK = ListsPK(id_list)

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ListElements]
  override def productArity: Int = 3
  override def productElement(n: Int): Any = n match {
    case 0 => element_list
    case 1 => id_list
    case 2 => id_list_element
  }
}

object ListElements {
   def apply(pk: ListElementsPK, element_list: String, frId_list: ListsPK) = new ListElements(id_list_element = pk.id_list_element, element_list = element_list, id_list = frId_list.id_list)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////// from AbstractClassDefMetaGen (genClassDefsWithOutLob) ////////////////////////////////////////////////////////////////////////
case class ScenarioStatisticsPK(scenario: String) extends BOReference[ScenarioStatistics]

case class ScenarioStatistics (
  date: LocalDateTime,
  scenario: String,
  in: Long,
  out: Long) extends Product {

  val pk: ScenarioStatisticsPK = ScenarioStatisticsPK(scenario)


  override def canEqual(that: Any): Boolean = that.isInstanceOf[ScenarioStatistics]
  override def productArity: Int = 4
  override def productElement(n: Int): Any = n match {
    case 0 => date
    case 1 => in
    case 2 => out
    case 3 => scenario
  }
}

object ScenarioStatistics {
   def apply(pk: ScenarioStatisticsPK, date: LocalDateTime, in: Long, out: Long) = new ScenarioStatistics(date = date, scenario = pk.scenario, in = in, out = out)
}
////////////////////////////////////////////////////////////////////// end from AbstractClassDefMetaGen (genClassDefsWithOutLob) //////////////////////////////////////////////////////////////////////