package decorator

class StringDisplay(private val string: String) extends Display {
  override def getColumns(): Int = string.getBytes().length

  override def getRows(): Int = 1

  override def getRowText(row: Int): String = {
    if (row == 0) {
      string
    } else {
      null
    }
  }
}
