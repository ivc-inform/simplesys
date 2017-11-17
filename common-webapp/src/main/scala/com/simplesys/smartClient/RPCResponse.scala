package com.simplesys.smartClient

case class ResponseData(status: String, login: String, userId: Long, captionUser: String, codeGroup: String, simpleSysContextPath: String)

object RPCResponse {
    val statusSuccess = 0
    val statusOffline = 1
    val statusFailure = -1
    val statusValidationError = -4
    val statusLoginIncorrect = -5
    val statusMaxLogginAttemptsExceeded = -6
    val statusLoginRequired = -7
    val statusLoginSuccess = -8
    val statusUpdateWithoutPkError = -9
    val statusTransactionFailed = -10
    val statusTransportError = -90
    val statusUnknownHostError = -91
    val statusConnetionResetError = -92
    val statusServerTimeout = -100
}
case class RPCResponse(data: ResponseData)
