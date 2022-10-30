package abstractFactory.tablefactory

import abstractFactory.factory.Tray

class TableTray(caption: String) extends Tray(caption) {
  override def makeHTML(): String = {
    val buffer = new StringBuffer();
    buffer.append("<td>")
    buffer.append("<table width=\"100%\" border=\"1\"><tr>")
    buffer.append("<td bgcolor=\"#ccccc\" align=\"cente\" colspan=\"" + tray.size() + "\"><b>" + caption + "</b></td>\n")
    buffer.append("</tr>\n")
    buffer.append("<tr>")
    val it = tray.iterator()
    while (it.hasNext()) {
      val item = it.next()
      buffer.append(item.makeHTML())
    }
    buffer.append("</tr></table>\n")
    buffer.append("</td>\n")

    buffer.toString()
  }
}
