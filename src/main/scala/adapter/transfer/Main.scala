package adapter.transfer

object Main {
  def main(args: Array[String]): Unit = {
    val p = new PrintBanner("Hello")
    p.printWeak()
    p.printStrong()
  }

}
