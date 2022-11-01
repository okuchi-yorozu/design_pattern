package decorator

class SideBorder(display: Display, private val borderChar: Char) extends Border(display) {
  override def getColumns(): Int = 1 + display.getColumns() + 1

  override def getRows(): Int = display.getRows()

  override def getRowText(row: Int): String = borderChar + display.getRowText(row) + borderChar
}
