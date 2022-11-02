package observer

class IncrementalNumberGenerator(private val start: Int, private val end: Int, private val inc: Int) extends NumberGenerator {
  private var number: Int = start

  override def getNumber(): Int = number
  def execute(): Unit = {
    while (number < end) {
      notifyObservers()
      number += inc
    }
  }
}
