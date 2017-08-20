package Mirrors

trait BasePerson {
    val name: String
    val age: Int
}

case class Person(name: String, age: Int) extends BasePerson {
    override def toString: String = "123456"
}