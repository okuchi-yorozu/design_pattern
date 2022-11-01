package decorator

class FullBorder(display: Display) extends Border(display) {
  override def getColumns(): Int = 1 + display.getColumns() + 1

  override def getRows(): Int = 1 + display.getRows() + 1

  override def getRowText(row: Int): String = {
    if (row == 0) {
      "+" + makeLine('-', display.getColumns()) + "+"
    } else if (row == display.getRows() + 1) {
      "+" + makeLine('-', display.getColumns()) + "+"
    } else {
      "|" + display.getRowText(row - 1) + "|"
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
