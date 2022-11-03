package proxy

class Printer(private var name: String) extends Printable {
  if (name == null) {
    heavyJob("Printerのインスタンスを生成中")
  } else {
    heavyJob("Printerのインスタンス(" + name + ")を生成中")
  }

  def this() = {
    this(null)
  }

  def setPrinterName(name: String): Unit = {
    this.name = name
  }

  def getPrinterName(): String = {
    name
  }

  def print(string: String): Unit = {
    println("=== " + name + " ====")
    println(string)
  }

  def heavyJob(msg: String): Unit = {
    System.out.print(msg)
    for (i <- 0 until 5) {
      try {
        Thread.sleep(1000)
      } catch {
        case e: InterruptedException =>
      }
      System.out.print(".")
    }
    println("完了。")

  }
}
