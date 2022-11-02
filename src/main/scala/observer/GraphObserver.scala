package observer

class GraphObserver extends Observer {
  override def update(generator: NumberGenerator): Unit = {
    print("GraphObserver:")
    val count = generator.getNumber()
    for (_ <- 0 until count) {
      print("*")
    }
    println("")
    try {
      Thread.sleep(100)
    } catch {
      case e: InterruptedException =>
    }
  }
}
