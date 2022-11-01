package facade

import java.io.Writer

class HtmlWriter(private val writer: Writer) {
  def title(title: String): Unit = {
    writer.write("<html>")
    writer.write("<head>")
    writer.write("<title>" + title + "</title>")
    writer.write("</head>")
    writer.write("<body>\n")
    writer.write("<h1>" + title + "</h1>\n")
  }
  def paragraph(msg: String): Unit = {
    writer.write("<p>" + msg + "</p>\n")
  }
  def link(href: String, caption: String): Unit = {
    writer.write("<a href=\"" + href + "\">" + caption + "</a>")
  }
  def mailto(mailaddr: String, username: String): Unit = {
    link("mailto:" + mailaddr, username)
  }
  def close(): Unit = {
    writer.write("</body>")
    writer.write("</html>\n")
    writer.close()
  }
}
