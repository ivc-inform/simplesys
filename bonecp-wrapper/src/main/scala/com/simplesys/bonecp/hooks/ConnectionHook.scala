package com.simplesys.bonecp.hooks

import java.util.Map
import java.sql.{SQLException, Statement}
import com.jolbox.bonecp.{StatementHandle => JStatementHandle, ConnectionHandle => JConnectionHandle}
import com.simplesys.bonecp.{StatementHandle, ConnectionHandle}
import com.jolbox.bonecp.hooks.{ConnectionState, AcquireFailConfig => JAcquireFailConfig, ConnectionHook => JConnectionHook}

trait ConnectionHook extends JConnectionHook {
  final def onAcquire(connection: JConnectionHandle) {
    OnAcquire(ConnectionHandle(connection))
  }

  final def onCheckIn(connection: JConnectionHandle) {
    OnCheckIn(ConnectionHandle(connection))
  }

  final def onCheckOut(connection: JConnectionHandle) {
    OnCheckIn(ConnectionHandle(connection))
  }

  final def onDestroy(connection: JConnectionHandle) {
    OnDestroy(ConnectionHandle(connection))
  }

  final def onAcquireFail(t: Throwable, acquireConfig: JAcquireFailConfig) = OnAcquireFail(t, AcquireFailConfig(acquireConfig))

  final def onQueryExecuteTimeLimitExceeded(conn: JConnectionHandle, statement: Statement, sql: String, logParams: Map[AnyRef, AnyRef], timeElapsedInNs: Long) {
    OnQueryExecuteTimeLimitExceeded(ConnectionHandle(conn), statement, sql, logParams, timeElapsedInNs)
  }

  final def onBeforeStatementExecute(conn: JConnectionHandle, statement: JStatementHandle, sql: String, params: Map[AnyRef, AnyRef]) {
    OnBeforeStatementExecute(ConnectionHandle(conn), StatementHandle(statement), sql, params)
  }

  final def onAfterStatementExecute(conn: JConnectionHandle, statement: JStatementHandle, sql: String, params: Map[AnyRef, AnyRef]) {
    OnAfterStatementExecute(ConnectionHandle(conn), StatementHandle(statement), sql, params)
  }

  final def onConnectionException(connection: JConnectionHandle, state: String, t: Throwable) = OnConnectionException(ConnectionHandle(connection), state, t)

  final def onMarkPossiblyBroken(connection: JConnectionHandle, state: String, e: SQLException) = OnMarkPossiblyBroken(ConnectionHandle(connection), state, e)


  def OnAcquire(connection: ConnectionHandle)

  def OnCheckIn(connection: ConnectionHandle)

  def OnCheckOut(connection: ConnectionHandle)

  def OnDestroy(connection: ConnectionHandle)

  def OnAcquireFail(t: Throwable, acquireConfig: AcquireFailConfig): Boolean

  def OnQueryExecuteTimeLimitExceeded(conn: ConnectionHandle, statement: Statement, sql: String, logParams: Map[AnyRef, AnyRef], timeElapsedInNs: Long)

  def OnBeforeStatementExecute(conn: ConnectionHandle, statement: StatementHandle, sql: String, params: Map[AnyRef, AnyRef])

  def OnAfterStatementExecute(conn: ConnectionHandle, statement: StatementHandle, sql: String, params: Map[AnyRef, AnyRef])

  def OnConnectionException(connection: ConnectionHandle, state: String, t: Throwable): Boolean

  def OnMarkPossiblyBroken(connection: ConnectionHandle, state: String, e: SQLException): ConnectionState
}