package observer

class DigitObserver extends Observer {
  override def update(generator: NumberGenerator): Unit = {
    println("DigitObserver:" + generator.getNumber())
    try {
      Thread.sleep(100)
    } catch {
      case e: InterruptedException =>
    }
  }
}
