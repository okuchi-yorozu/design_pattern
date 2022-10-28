package adapter.inherit

import java.io.IOException

object Main2 {
  def main(args: Array[String]): Unit = {
    val f = new FileProperties()
    try {
      f.readFromFile("file.txt")
      f.setValue("year", "2004")
      f.setValue("month", "4")
      f.setValue("day", "21")
      f.writeToFile("newFile.txt")
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }

}
