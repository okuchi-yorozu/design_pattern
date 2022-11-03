package flyweight

object Main {
  // bigN.txtを用意してないため動きません
  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      println("Usage: java Main digits")
      println("Example: java Main 1212123")
      System.exit(0)
    }

    val bs = new BigString(args(0))
    bs.print()
  }

  def showMemory(): Unit = {
    Runtime.getRuntime().gc()
    val used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
    println("使用メモリ = " + used)
  }
}