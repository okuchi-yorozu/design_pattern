package bridge

import java.util.Random

class RandomCountDisplay(impl: DisplayImpl) extends CountDisplay(impl) {
  private val random = new Random()

  def randomDisplay(times: Int): Unit = {
    multiDisplay(random.nextInt(times))
  }
}
