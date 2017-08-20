package com.simplesys.bonecp.hooks

import com.jolbox.bonecp.hooks.{AcquireFailConfig => JAcquireFailConfig}

object AcquireFailConfig {
  def apply(proxy: JAcquireFailConfig) = new AcquireFailConfig(proxy)
}

class AcquireFailConfig(protected val proxy: JAcquireFailConfig)