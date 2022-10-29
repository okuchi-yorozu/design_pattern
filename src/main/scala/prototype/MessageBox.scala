package prototype

import framework.Product

class MessageBox(private val decochar: Char) extends Product {
  override def use(s: String): Unit = {
    val length = s.getBytes().length
    for(_ <- 0 until length + 4) {
      print(decochar)
    }
    println("")
    println(decochar + " " + s + " " + decochar)
    for(_ <- 0 until length + 4) {
      print(decochar)
    }
    println("")
  }
}
