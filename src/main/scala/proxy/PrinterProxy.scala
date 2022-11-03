package proxy

class PrinterProxy(private var name: String, private val className: String) extends Printable {
  private var real: Printable = null

  override def setPrinterName(name: String): Unit = synchronized {
    if (real != null) {
      real.setPrinterName(name)
    }
    this.name = name
  }

  override def getPrinterName(): String = name

  override def print(string: String): Unit = {
    realize()
    real.print(string)
  }

  def realize(): Unit = synchronized {
    if (real == null) {
      try {
        real = Class.forName(className).newInstance().asInstanceOf[Printable]
        real.setPrinterName(name)
      } catch {
        case e: ClassNotFoundException => println("クラス " + className + " が見つかりません")
        case e: Exception => e.printStackTrace()
      }
    }
  }
}
