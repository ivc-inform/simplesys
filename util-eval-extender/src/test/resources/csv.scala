import utilEval.EvalInterface

new EvalInterface {
    override val name: String = "CSV"
    override def orderString (i: String): String = i.split(",").mkString (",")
}
