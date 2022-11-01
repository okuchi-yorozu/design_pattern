package facade

import java.io.{FileWriter, IOException}

class PageMaker private() {

}

object PageMaker {
  def makeWelcomePage(mailaddr: String, filename: String): Unit = {
    try {
      val mailprop = Database.getProperties("maildata")
      val username = mailprop.getProperty(mailaddr)
      val writer = new HtmlWriter(new FileWriter(filename))
      writer.title("Welcome to " + username + "'s page!")
      writer.paragraph(username + "のページへようこそ。")
      writer.paragraph("メールまっていますね。")
      writer.mailto(mailaddr, username)
      writer.close()
      println(filename + " is created for " + mailaddr + " (" + username + ")")
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  def makeLinkPage(filename: String): Unit = {
    try {
      val writer = new HtmlWriter(new FileWriter(filename))
      writer.title("Link Page")
      val mailprop = Database.getProperties("maildata")
      val en = mailprop.propertyNames()
      while (en.hasMoreElements()) {
        val mailaddr = en.nextElement().asInstanceOf[String]
        val username = mailprop.getProperty(mailaddr, "(unknown)")
        writer.mailto(mailaddr, username)
      }
      writer.close()
      println(filename + " is created.")
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }
}