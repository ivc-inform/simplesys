package com.simplesys.akka.http

import com.simplesys.common.Strings._

case class LoginedData(res: String, login: String, userID: Long, codeGroup: String = strEmpty)

case class LoginedData1(res: String, login: String = strEmpty, userID: Long = 0, captionUser: String = strEmpty, codeGroup: String = strEmpty)
