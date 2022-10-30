package sterategy

import scala.util.Random

class WinningStrategy(seed: Int) extends Strategy {
  private val random: Random = new Random(seed)
  private var won = false
  private var prevHand: Hand = null

  override def nextHand(): Hand = {
    if (!won) {
      prevHand = Hand.getHand(random.nextInt(3))
    }
    prevHand
  }

  override def study(win: Boolean): Unit = won = win

}
