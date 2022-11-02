package observer

object Main {
  def main(args: Array[String]): Unit = {
//    val generator = new RandomNumberGenerator()
    val generator = new IncrementalNumberGenerator(10, 50, 5)
    val observer1 = new DigitObserver()
    val observer2 = new GraphObserver()
    val observer3 = new FrameObserver()
    generator.addObserver(observer1)
    generator.addObserver(observer2)
    generator.addObserver(observer3)
    generator.execute()
  }
}
