package abstractFactory.listfactory

import abstractFactory.factory.Page

class ListPage(title: String, author: String) extends Page(title, author) {
  override def makeHTML(): String = {
    val buffer = new StringBuffer()
    buffer.append("<html><head><title>" + title + "</title></head>\n")
    buffer.append("<body>\n")
    buffer.append("<h1>" + title + "</h1>\n")
    buffer.append("<ul>\n")
    val it = content.iterator()
    while (it.hasNext()) {
      val item = it.next()
      buffer.append(item.makeHTML())
    }
    buffer.append("</ul>\n")
    buffer.append("<hr><address>" + author + "</address>")
    buffer.append("</body></html>\n")
    buffer.toString()
  }
}
