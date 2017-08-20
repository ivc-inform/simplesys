package com.simplesys.js

import com.simplesys.meta.HtgLists.{HtgCons, HtgNil}

trait GenHtg extends JSCodegen {

  import IR._

  override def quote(x: Exp[Any]): String =
    x match {
      case Const(HtgCons(head, tail)) =>
        (head match {
          case Sym(sym) =>
            if (tail == HtgNil)
              "x" + sym
            else
              "x" + sym + ","
          case x =>
            if (tail == HtgNil)
              x
            else
              x + ","
        }) + quote(Const(tail))
      case Const(HtgNil) => ""
      case _ => super.quote(x)
    }
}
