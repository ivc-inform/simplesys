package com.simplesys.jdbc.meta

import java.sql.Connection

import com.simplesys.SQL.Gen._
import com.simplesys.bonecp.BoneCPDataSource
import com.simplesys.common.Strings._
import com.simplesys.isc.system.typesDyn.{opIdAnd, opIdEquals}
import com.simplesys.jdbc.control.SessionStructures._
import com.simplesys.sql.OracleDialect

import scala.collection.mutable.ArrayBuffer

trait MetaSupport {
    /*getColumns

    ResultSet getColumns(String catalog,
                         String schemaPattern,
                         String tableNamePattern,
                         String columnNamePattern)
                         throws SQLException
    Retrieves a description of table columns available in the specified catalog.
    Only column descriptions matching the catalog, schema, table and column name criteria are returned. They are ordered by TABLE_CAT,TABLE_SCHEM, TABLE_NAME, and ORDINAL_POSITION.

    Each column description has the following columns:

    1 TABLE_CAT String => table catalog (may be null)
    2 TABLE_SCHEM String => table schema (may be null)
    3 TABLE_NAME String => table name
    4 COLUMN_NAME String => column name
    5 DATA_TYPE int => SQL type from java.sql.Types
    6 TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified
    7 COLUMN_SIZE int => column size.
    8 BUFFER_LENGTH is not used.
    9 DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable.
    10 NUM_PREC_RADIX int => Radix (typically either 10 or 2)
    11 NULLABLE int => is NULL allowed.
        columnNoNulls - might not allow NULL values
        columnNullable - definitely allows NULL values
        columnNullableUnknown - nullability unknown
    12 REMARKS String => comment describing column (may be null)
    13 COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
    14 SQL_DATA_TYPE int => unused
    15 SQL_DATETIME_SUB int => unused
    16 CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column
    17 ORDINAL_POSITION int => index of column in table (starting at 1)
    18 IS_NULLABLE String => ISO rules are used to determine the nullability for a column.
         YES --- if the parameter can include NULLs
         NO --- if the parameter cannot include NULLs
        empty string --- if the nullability for the parameter is unknown
    19 SCOPE_CATLOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF)
    20 SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF)
    21 SCOPE_TABLE String => table name that this the scope of a reference attribure (null if the DATA_TYPE isn't REF)
    22 SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF)
    23 IS_AUTOINCREMENT String => Indicates whether this column is auto incremented
        YES --- if the column is auto incremented
        NO --- if the column is not auto incremented
        empty string --- if it cannot be determined whether the column is auto incremented parameter is unknown

    The COLUMN_SIZE column the specified column size for the given column. For numeric data, this is the maximum precision. For character data, this is the length in characters. For datetime datatypes, this is the length in characters of the String representation (assuming the maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes. For the ROWID datatype, this is the length in bytes. Null is returned for data types where the column size is not applicable.

    Parameters:
    catalog - a catalog name; must match the catalog name as it is stored in the database; "" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search
    schemaPattern - a schema name pattern; must match the schema name as it is stored in the database; "" retrieves those without a schema; null means that the schema name should not be used to narrow the search
    tableNamePattern - a table name pattern; must match the table name as it is stored in the database
    columnNamePattern - a column name pattern; must match the column name as it is stored in the database
    Returns:
    ResultSet - each row is a column description
    Throws:
    SQLException - if a database access error occurs
    See Also:
    getSearchStringEscape()   */

    val quoted: Boolean

    case class ColumnMeta(name: String, `type`: Int, mantadory: Boolean, comment: String) {
        override def toString: String = s"name = '${name}' type = '${`type`}' mantadory = '${mantadory}' comment = '${comment}'"
    }

    val userColComments = SQLCompoundTable(
        fields = SQLFields.apply1(SQLField(name = "comments", quoted = quoted)),
        from = SQLFrom(SQLTable(name = "user_col_comments", quoted = quoted)),
        where = SQLWhere(
            SQLWhereItem(field = SQLField(name = "table_name", quoted = quoted), operator = opIdEquals, value = SQLValuePlaceHolder),
            SQLWhereItemClause(opIdAnd),
            SQLWhereItem(field = SQLField(name = "column_name", quoted = quoted), operator = opIdEquals, value = SQLValuePlaceHolder)
        )
    )

    val userTableComments = SQLCompoundTable(
        fields = SQLFields.apply1(SQLField(name = "comments", quoted = quoted)),
        from = SQLFrom(SQLTable(name = "user_tab_comments", quoted = quoted)),
        where = SQLWhere(
            SQLWhereItem(field = SQLField(name = "table_name", quoted = quoted), operator = opIdEquals, value = SQLValuePlaceHolder)
        )
    )

    def getTableColumns(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, columnNamePattern: String = null, sort: Boolean = false)(implicit connection: Connection, dataSource: BoneCPDataSource): Seq[ColumnMeta] = {

        val result = connection.getMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)
        val res = ArrayBuffer.empty[ColumnMeta]

        while (result.next())
            res += ColumnMeta(name = result.getString("COLUMN_NAME"), `type` = result.getInt("DATA_TYPE"), mantadory = result.getInt("NULLABLE") == 0, comment = result.getString("REMARKS"))

        if (sort)
            res.sortWith(_.name < _.name)
        else
            res
    }

    def getTableColumnsS(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, columnNamePattern: String = null)(implicit dataSource: BoneCPDataSource) = getTableColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern, true)(dataSource.getConnection, dataSource)

    def getTableColumnsWithComments(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, columnNamePattern: String = null)(implicit connection: Connection, dataSource: BoneCPDataSource): Seq[ColumnMeta] = {

        val result = connection.getMetaData.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern)
        val res = ArrayBuffer.empty[ColumnMeta]

        //select comments from user_col_comments where table_name = 'SAVE_TRANSACTION' and column_name = 'GTIMESTAMP'
        prepareStatement(connection, userColComments.toSQL(), dataSource.Config.FetchSize) {
            statement =>
                dataSource.SQLDialect match {
                    case OracleDialect =>
                        while (result.next()) {
                            statement.setString(1, result.getString("TABLE_NAME"))
                            statement.setString(2, result.getString("COLUMN_NAME"))
                            executeOne(statement) {
                                resultSet =>
                                    res += ColumnMeta(name = result.getString("COLUMN_NAME"), `type` = result.getInt("DATA_TYPE"), mantadory = result.getInt("NULLABLE") == 0, comment = resultSet.getString("comments"))
                            }
                        }

                    case _ =>
                        throw new RuntimeException("Not implementation for :" + dataSource.SQLDialect)
                }
        }

        res
    }

    def getSQLFields(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, columnNamePattern: String = null, withTableOwner: Boolean = true)(implicit connection: Connection, dataSource: BoneCPDataSource): SQLFields =
        SQLFields(getTableColumns(catalog = catalog, schemaPattern = schemaPattern, tableNamePattern = tableNamePattern, columnNamePattern = columnNamePattern) map {
            case ColumnMeta(name, _type, mantadory, comment) => SQLField(name = name, quoted = quoted, isMantadory = mantadory, sqlDataType = _type, tableOwner = if (withTableOwner) SQLTable(name = tableNamePattern, quoted = quoted) else SQLTable(name = strEmpty))
        })

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
      getTables

      ResultSet getTables(String catalog,
                          String schemaPattern,
                          String tableNamePattern,
                          String[] types)
                          throws SQLException
      Retrieves a description of the tables available in the given catalog. Only table descriptions matching the catalog, schema, table name and type criteria are returned. They are ordered by TABLE_TYPE, TABLE_CAT, TABLE_SCHEM and TABLE_NAME.
      Each table description has the following columns:

      1.TABLE_CAT String => table catalog (may be null)
      2.TABLE_SCHEM String => table schema (may be null)
      3.TABLE_NAME String => table name
      4.TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
      5.REMARKS String => explanatory comment on the table
      6.TYPE_CAT String => the types catalog (may be null)
      7.TYPE_SCHEM String => the types schema (may be null)
      8.TYPE_NAME String => type name (may be null)
      9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
      10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)
      Note: Some databases may not return information for all tables.

      Parameters:
         catalog - a catalog name; must match the catalog name as it is stored in the database; "" retrieves those without a catalog; null means that the catalog name should not be used to narrow the search
         schemaPattern - a schema name pattern; must match the schema name as it is stored in the database; "" retrieves those without a schema; null means that the schema name should not be used to narrow the search
         tableNamePattern - a table name pattern; must match the table name as it is stored in the database
         types - a list of table types, which must be from the list of table types returned from getTableTypes(),to include; null returns all types
      Returns:
        ResultSet - each row is a table description
      Throws:
        SQLException - if a database access error occurs
      See Also:
        getSearchStringEscape()
      */

    case class TableMeta(name: String, comment: String) {
        override def toString: String = s"name = '${name}' comment = '${comment}'"
    }

    def getTablesS(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, types: Array[String] = null, sort: Boolean = true)(implicit dataSource: BoneCPDataSource): Seq[TableMeta] =
        getTables(catalog, schemaPattern, tableNamePattern, types, sort)(dataSource.getConnection, dataSource)

    def getTables(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, types: Array[String] = null, sort: Boolean = false)(implicit connection: Connection, dataSource: BoneCPDataSource): Seq[TableMeta] = {

        val result = connection.getMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)
        val res = ArrayBuffer.empty[TableMeta]

        while (result.next())
            res += TableMeta(name = result.getString("TABLE_NAME"), comment = result.getString("REMARKS"))

        if (sort)
            res.sortWith(_.name < _.name)
        else
            res
    }

    def getTablesWithComments(catalog: String = null, schemaPattern: String = null, tableNamePattern: String, types: Array[String] = null)(implicit connection: Connection, dataSource: BoneCPDataSource): Seq[TableMeta] = {

        val result = connection.getMetaData.getTables(catalog, schemaPattern, tableNamePattern, types)
        val res = ArrayBuffer.empty[TableMeta]

        prepareStatement(connection, userTableComments.toSQL(), dataSource.Config.FetchSize) {
            statement =>
                dataSource.SQLDialect match {
                    case OracleDialect =>
                        while (result.next()) {
                            statement.setString(1, result.getString("TABLE_NAME"))
                            executeOne(statement) {
                                resultSet =>
                                    res += TableMeta(name = result.getString("TABLE_NAME"), comment = resultSet.getString("comments"))
                            }
                        }

                    case _ =>
                        throw new RuntimeException("Not implementation for :" + dataSource.SQLDialect)
                }
        }

        res
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
      getTableTypes

      ResultSet getTableTypes()
                              throws SQLException
      Retrieves the table types available in this database. The results are ordered by table type.
      The table type is:

      TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
      Returns:
      a ResultSet object in which each row has a single String column that is a table type
      Throws:
      SQLException - if a database access error occurs
      */

    def getTableTypes(implicit connection: Connection, dataSource: BoneCPDataSource): Seq[String] = {

        val result = connection.getMetaData.getTableTypes()
        val res = ArrayBuffer.empty[String]

        while (result.next())
            res += result.getString("TABLE_TYPE")

        res
    }
}
