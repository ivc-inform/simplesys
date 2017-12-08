package com.model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.OracleProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import com.simplesys.slick.oracle.time._
  import java.time.LocalDateTime
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Messaging.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Messaging
   *  @param id Database column ID SqlType(NUMBER), PrimaryKey
   *  @param timestamp Database column TIMESTAMP SqlType(DATE)
   *  @param gtimestamp Database column GTIMESTAMP SqlType(DATE)
   *  @param starttime Database column STARTTIME SqlType(DATE)
   *  @param acncode Database column ACNCODE SqlType(VARCHAR2), Length(32,true)
   *  @param cnrcode Database column CNRCODE SqlType(VARCHAR2), Length(32,true)
   *  @param subject Database column SUBJECT SqlType(VARCHAR2), Length(64,true)
   *  @param address Database column ADDRESS SqlType(VARCHAR2), Length(64,true)
   *  @param text Database column TEXT SqlType(VARCHAR2), Length(2000,true)
   *  @param operatorunitregioncode Database column OPERATORUNITREGIONCODE SqlType(VARCHAR2), Length(128,true)
   *  @param dlvstatus Database column DLVSTATUS SqlType(VARCHAR2)
   *  @param dlvstatusat Database column DLVSTATUSAT SqlType(DATE)
   *  @param dlverror Database column DLVERROR SqlType(VARCHAR2), Length(64,true)
   *  @param sentat Database column SENTAT SqlType(DATE) */
  case class MessagingRow(id: scala.math.BigDecimal, timestamp: LocalDateTime, gtimestamp: Option[LocalDateTime], starttime: Option[LocalDateTime], acncode: String, cnrcode: String, subject: String, address: String, text: Option[String], operatorunitregioncode: Option[String], dlvstatus: Char, dlvstatusat: LocalDateTime, dlverror: Option[String], sentat: Option[LocalDateTime])
  /** GetResult implicit for fetching MessagingRow objects using plain SQL queries */
  implicit def GetResultMessagingRow(implicit e0: GR[scala.math.BigDecimal], e1: GR[LocalDateTime], e2: GR[Option[LocalDateTime]], e3: GR[String], e4: GR[Option[String]], e5: GR[Char]): GR[MessagingRow] = GR{
    prs => import prs._
    MessagingRow.tupled((<<[scala.math.BigDecimal], <<[LocalDateTime], <<?[LocalDateTime], <<?[LocalDateTime], <<[String], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<[Char], <<[LocalDateTime], <<?[String], <<?[LocalDateTime]))
  }
  /** Table description of table MESSAGING. Objects of this class serve as prototypes for rows in queries. */
  class Messaging(_tableTag: Tag) extends profile.api.Table[MessagingRow](_tableTag, Some("TEMP"), "MESSAGING") {
    def * = (id, timestamp, gtimestamp, starttime, acncode, cnrcode, subject, address, text, operatorunitregioncode, dlvstatus, dlvstatusat, dlverror, sentat) <> (MessagingRow.tupled, MessagingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(timestamp), gtimestamp, starttime, Rep.Some(acncode), Rep.Some(cnrcode), Rep.Some(subject), Rep.Some(address), text, operatorunitregioncode, Rep.Some(dlvstatus), Rep.Some(dlvstatusat), dlverror, sentat).shaped.<>({r=>import r._; _1.map(_=> MessagingRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6.get, _7.get, _8.get, _9, _10, _11.get, _12.get, _13, _14)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(NUMBER), PrimaryKey */
    val id: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("ID", O.PrimaryKey)
    /** Database column TIMESTAMP SqlType(DATE) */
    val timestamp: Rep[LocalDateTime] = column[LocalDateTime]("TIMESTAMP")
    /** Database column GTIMESTAMP SqlType(DATE) */
    val gtimestamp: Rep[Option[LocalDateTime]] = column[Option[LocalDateTime]]("GTIMESTAMP")
    /** Database column STARTTIME SqlType(DATE) */
    val starttime: Rep[Option[LocalDateTime]] = column[Option[LocalDateTime]]("STARTTIME")
    /** Database column ACNCODE SqlType(VARCHAR2), Length(32,true) */
    val acncode: Rep[String] = column[String]("ACNCODE", O.Length(32,varying=true))
    /** Database column CNRCODE SqlType(VARCHAR2), Length(32,true) */
    val cnrcode: Rep[String] = column[String]("CNRCODE", O.Length(32,varying=true))
    /** Database column SUBJECT SqlType(VARCHAR2), Length(64,true) */
    val subject: Rep[String] = column[String]("SUBJECT", O.Length(64,varying=true))
    /** Database column ADDRESS SqlType(VARCHAR2), Length(64,true) */
    val address: Rep[String] = column[String]("ADDRESS", O.Length(64,varying=true))
    /** Database column TEXT SqlType(VARCHAR2), Length(2000,true) */
    val text: Rep[Option[String]] = column[Option[String]]("TEXT", O.Length(2000,varying=true))
    /** Database column OPERATORUNITREGIONCODE SqlType(VARCHAR2), Length(128,true) */
    val operatorunitregioncode: Rep[Option[String]] = column[Option[String]]("OPERATORUNITREGIONCODE", O.Length(128,varying=true))
    /** Database column DLVSTATUS SqlType(VARCHAR2) */
    val dlvstatus: Rep[Char] = column[Char]("DLVSTATUS")
    /** Database column DLVSTATUSAT SqlType(DATE) */
    val dlvstatusat: Rep[LocalDateTime] = column[LocalDateTime]("DLVSTATUSAT")
    /** Database column DLVERROR SqlType(VARCHAR2), Length(64,true) */
    val dlverror: Rep[Option[String]] = column[Option[String]]("DLVERROR", O.Length(64,varying=true))
    /** Database column SENTAT SqlType(DATE) */
    val sentat: Rep[Option[LocalDateTime]] = column[Option[LocalDateTime]]("SENTAT")
  }
  /** Collection-like TableQuery object for table Messaging */
  lazy val Messaging = new TableQuery(tag => new Messaging(tag))
}
