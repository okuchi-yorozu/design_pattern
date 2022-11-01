package decorator

class UpDownBorder(display: Display, private val borderChar: Char) extends Border(display) {
  override def getColumns(): Int = 1 + display.getColumns()

  override def getRows(): Int = 1 + display.getRows() + 1

  override def getRowText(row: Int): String = {
    if (row == 0 || row == getRows() - 1) {
      makeLine(borderChar, display.getColumns())
    } else {
      display.getRowText(row - 1)
    }
  }

  private def makeLine(ch: Char, count: Int): String = {
    val buf = new StringBuffer()
    for (_ <- 0 until count) {
      buf.append(ch)
    }
    buf.toString()
  }

}
