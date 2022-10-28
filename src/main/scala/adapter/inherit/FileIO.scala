package adapter.inherit

trait FileIO {
  def readFromFile(filename: String): Unit
  def writeToFile(filename: String): Unit
  def setValue(key: String, value: String): Unit
  def getValue(key: String): String
}
