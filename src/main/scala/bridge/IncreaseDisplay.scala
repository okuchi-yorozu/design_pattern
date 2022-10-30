package bridge

class IncreaseDisplay(impl: DisplayImpl, private val step: Int) extends CountDisplay(impl) {
  def increaseDisplay(level: Int): Unit = {
    var count = 0
    for(_ <- 0 until level) {
      multiDisplay(count)
      count += step
    }
  }
}
