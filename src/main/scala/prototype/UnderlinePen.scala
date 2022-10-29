package prototype

import prototype.framework.Product

class UnderlinePen(private val ulchar: Char) extends Product {
  override def use(s: String): Unit = {
    val length = s.getBytes().length
    println("\"" + s + "\"")
    print(" ")
    for(_ <- 0 until length) {
      print(ulchar)
    }
    println("")
  }
}
