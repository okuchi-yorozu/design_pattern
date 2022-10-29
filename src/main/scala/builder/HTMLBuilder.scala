package builder

import java.io.{FileWriter, IOException, PrintWriter}

class HTMLBuilder extends Builder {
  private var filename: String = null
  private var writer: PrintWriter = null

  override def buildTitle(title: String): Unit = {
    filename = title + ".html"
    try {
      writer = new PrintWriter(new FileWriter(filename))
    } catch {
      case e: IOException => e.printStackTrace()
    }
    writer.println("<html><head><title>" + title + "</title></head><body>")
    writer.println("<h1>" + title + "</h1>")
  }

  override def buildString(str: String): Unit = {
    writer.println("<p>" + str + "</p>")
  }

  override def buildItems(items: List[String]): Unit = {
    writer.println("<ul>")
    for (i <- items.indices) {
      writer.println("<li>" + items(i) + "</li>")
    }
    writer.println("</ul>")
  }

  override def buildDone(): Unit = {
    writer.println("</body></html>")
    writer.close()
  }

  def getResult(): String = filename

}
