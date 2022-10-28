package adapter.inherit

import java.io._
import java.util.Properties

class FileProperties extends Properties with FileIO {
  override def readFromFile(filename: String): Unit = {
    load(new FileInputStream(filename))
  }
  override def writeToFile(filename: String): Unit = {
    store(new FileOutputStream(filename), "written by FileProperties")
  }
  override def setValue(key: String, value: String): Unit = setProperty(key, value)
  override def getValue(key: String): String = getProperty(key)
}
