package abstractFactory.listfactory

import abstractFactory.factory.{Factory, Link, Page, Tray}

class ListFactory extends Factory {
  override def createLink(caption: String, url: String): Link = new ListLink(caption, url)

  override def createTray(caption: String): Tray = new ListTray(caption)

  override def createPage(title: String, author: String): Page = new ListPage(title, author)
}
