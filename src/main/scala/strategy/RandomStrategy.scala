package sterategy

import scala.util.Random

class RandomStrategy(seed: Int) extends Strategy {
  private val random: Random = new Random(seed)

  override def nextHand(): Hand = {
    Hand.getHand(random.nextInt(3))
  }

  override def study(win: Boolean): Unit = ()

}
