package facade

import java.io.{FileInputStream, IOException}
import java.util.Properties

class Database private() {
}

object Database {
  def getProperties(dbname: String): Properties = {
    val filename = dbname + ".txt"
    val prop = new Properties()

    try {
      prop.load(new FileInputStream(filename))
    } catch {
      case e: IOException => println("Warning: " + filename + " is not found.")
    }

    prop
  }
}
