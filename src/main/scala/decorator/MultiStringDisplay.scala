package decorator

import java.util

class MultiStringDisplay extends Display {
  private val body = new util.ArrayList[String]()
  private var columns = 0

  def add(msg: String): Unit = {
    body.add(msg)
    updateColumn(msg)
  }

  override def getColumns(): Int = columns

  override def getRows(): Int = body.size()

  override def getRowText(row: Int): String = {
    body.get(row)
  }

  private def updateColumn(msg: String) = {
    if (msg.getBytes().length > columns) {
      columns = msg.getBytes().length
    }

    for (row <- 0 until body.size()) {
      val fills = columns - body.get(row).getBytes().length
      if ( fills > 0) {
        body.set(row, body.get(row) + spaces(fills))
      }
    }
  }

  private def spaces(count: Int) = {
    val buf = new StringBuffer()
    for (_ <- 0 until count) {
      buf.append(' ')
    }
    buf.toString()
  }
}
