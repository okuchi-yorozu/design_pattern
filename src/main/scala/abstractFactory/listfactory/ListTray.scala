package abstractFactory.listfactory

import abstractFactory.factory.Tray

class ListTray(caption: String) extends Tray(caption) {
  override def makeHTML(): String = {
    val buffer = new StringBuffer();
    buffer.append("<li>\n")
    buffer.append(caption + "\n")
    buffer.append("<ul>\n")
    val it = tray.iterator()
    while (it.hasNext()) {
      val item = it.next()
      buffer.append(item.makeHTML())
    }
    buffer.append("</ul>\n")
    buffer.append("</li>\n")

    buffer.toString()
  }
}
