package abstractFactory.factory

import java.io.{FileWriter, IOException}
import java.util

abstract class Page(protected val title: String, protected val author: String) {
  protected val content = new util.ArrayList[Item]()

  def add(item: Item): Unit = content.add(item)

  def output(): Unit = {
    try {
      val filename = title + ".html"
      val writer = new FileWriter(filename)
      writer.write(makeHTML())
      writer.close()
      println(filename + " を作成しました。")
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

  def makeHTML(): String
}
