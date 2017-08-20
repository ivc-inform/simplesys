import utilEval.EvalInterface

new EvalInterface {
  override val name:String="TSV"
  override def orderString(i: String): String = i.split(",").mkString("\t")
}
