package com.simplesys.isc.RPC

import com.simplesys.isc.system.{ArrayDyn, ClassDynInit}
import com.simplesys.isc.system.misc._
import com.simplesys.isc.dataBinging.DSRequestDyn

trait TransactionDynInit extends ClassDynInit {
  protected val transactionNum: Number = null
  protected val operations: ArrayDyn[DSRequestDyn] = null
}   
