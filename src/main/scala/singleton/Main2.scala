package singleton

object Main2 {
  def main(args: Array[String]): Unit = {
    println("Start.")
    for (i <- 0 to 10) {
      println(i + ":" + TicketMaker.getInstance().getNextTicketNumber())
    }
    println("End.")
  }
}
