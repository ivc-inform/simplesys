package com.simplesys.bonecp

import com.jolbox.bonecp.{ConnectionHandle => JConnectionHandle}

object ConnectionHandle {
  def apply(proxy: JConnectionHandle) = new ConnectionHandle(proxy)
}

class ConnectionHandle(protected[bonecp] val proxy: JConnectionHandle)