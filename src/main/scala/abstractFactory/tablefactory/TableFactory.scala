package abstractFactory.tablefactory

import abstractFactory.factory.{Factory, Link, Page, Tray}

class TableFactory extends Factory {
  override def createLink(caption: String, url: String): Link = new TableLink(caption, url)

  override def createTray(caption: String): Tray = new TableTray(caption)

  override def createPage(title: String, author: String): Page = new TablePage(title, author)
}
