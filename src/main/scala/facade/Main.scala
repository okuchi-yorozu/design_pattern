package facade


object Main {
  def main(args: Array[String]): Unit = {
    PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html")
    PageMaker.makeLinkPage("linkpage.html")
  }

}
