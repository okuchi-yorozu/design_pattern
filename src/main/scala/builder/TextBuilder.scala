package builder

class TextBuilder extends Builder {
  private val buffer = new StringBuffer()

  override def buildTitle(title: String): Unit = {
    buffer.append("========================\n")
    buffer.append("『" + title + "』\n")
    buffer.append("\n")
  }

  override def buildString(str: String): Unit = {
    buffer.append('■' + str + "\n")
    buffer.append("\n")
  }

  override def buildItems(items: List[String]): Unit = {
    for (i <- items.indices) {
      buffer.append(" ・" + items(i) + "\n")
    }
    buffer.append("\n")
  }

  override def buildDone(): Unit =
    buffer.append("========================\n")

  def getResult(): String = buffer.toString()

}
