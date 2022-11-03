package proxy

object Main {
  def main(args: Array[String]): Unit = {
    val p = new PrinterProxy("Alice", "proxy.Printer")
    println("名前は現在" + p.getPrinterName() + "です。")
    p.setPrinterName("Bob")
    println("名前は現在" + p.getPrinterName() + "です。")
    p.print("Hello, world.")
  }
}
