package abstractFactory.listfactory

import abstractFactory.factory.Link

class ListLink(caption: String, url: String) extends Link(caption, url) {
  override def makeHTML(): String = "  <li><a href=\"" + url + "\">" + caption + "</a></li>\n"
}
