package bridge

class StringDisplayImpl(private val string: String) extends DisplayImpl {
  private val width: Int = string.getBytes().length

  override def rawOpen(): Unit = printLine()

  override def rawPrint(): Unit = println("|" + string + "|")

  override def rawClose(): Unit = printLine()

  private def printLine(): Unit = {
    print("+")
    for (_ <- 0 until width) {
      print("-")
    }
    println("+")
  }
}
