package observer

import java.util.Random

class RandomNumberGenerator extends NumberGenerator {
  private val random = new Random()
  private var number: Int = 0

  def getNumber(): Int = {
    number
  }

  def execute(): Unit = {
    for (_ <- 0 until 20) {
      number = random.nextInt(50)
      notifyObservers()
    }
  }
}
