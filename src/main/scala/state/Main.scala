package state

object Main {
  def main(args: Array[String]): Unit = {
    val frame = new SafeFrame("State Sample")
    while (true) {
      for (hour <- 0 until 24) {
        frame.setClock(hour)
        try {
          Thread.sleep(1000)
        } catch {
          case e: InterruptedException =>
        }
      }
    }
  }
}
