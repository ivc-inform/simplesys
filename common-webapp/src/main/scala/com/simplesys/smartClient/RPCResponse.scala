package com.simplesys.smartClient

case class ResponseData(status: String, login: String, userId: Long, captionUser: String, codeGroup: String, simpleSysContextPath: String)
case class RPCResponse(data: ResponseData)
