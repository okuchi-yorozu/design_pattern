package abstractFactory.tablefactory

import abstractFactory.factory.Link

class TableLink(caption: String, url: String) extends Link(caption, url) {
  override def makeHTML(): String = "<td><a href=\"" + url + "\">" + caption + "</a></td>\n"
}
