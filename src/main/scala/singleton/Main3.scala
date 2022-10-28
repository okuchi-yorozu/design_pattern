package singleton

object Main3 {
  def main(args: Array[String]): Unit = {
    println("Start.")
    for (i <- 0 until 9) {
      val triple = Triple.getInstance(i % 3)
      println(i + ":" + triple)
    }
    println("End.")
  }
}
