

//import com.simplesys.bonecp.P

/*
class TestWithJDBC extends FunSuite with BoneCPStack with Logging {
    test("select contractorGroup") {
        val _data = RecordsDynList()
        var resp: DSResponseDyn = null
        val contractorGroup = ContractorGroupBo(PostgreSQLDataSource("postgreEnzo"))
        val select = contractorGroup.selectPList()

        select.result match {
            case Success(list) =>
                list foreach {
                    item =>
                        _data += RecordDyn("DI" -> item.di, "DIPARENT" -> item.parent, "SCAPTION" -> item.caption, "SDESCRIPTION" -> item.description)
                }
                resp = new DSResponseDyn {
                    Status = RPCResponseDyn.statusSuccess
                    Data = _data
                }
            case Failure(_) =>
                resp = new DSResponseFailureExDyn(select)
        }

        logger debug resp.WrapResponseObject.toPrettyString
    }
}*/
