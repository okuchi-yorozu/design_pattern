package templateMethod

class StringDisplay(private val string: String) extends AbstractDisplay {
  private val width = string.getBytes().length

  override def open(): Unit = printLine()

  override def print(): Unit = println("|" + string + "|")

  override def close(): Unit = printLine()

  private def printLine() = {
    Predef.print("+")
    for (_ <- 1 to width) {
      Predef.print("-")
    }
    println("+")
  }

}
