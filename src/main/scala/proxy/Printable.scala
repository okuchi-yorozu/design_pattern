package proxy

trait Printable {
  def setPrinterName(name: String): Unit
  def getPrinterName(): String
  def print(string: String): Unit
}
