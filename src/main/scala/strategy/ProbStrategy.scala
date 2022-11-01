package strategy

import scala.collection.mutable.ListBuffer
import scala.util.Random

class ProbStrategy(seed: Int) extends Strategy {
  private val random: Random = new Random(seed)
  private var prevHandValue = 0
  private var currentHandValue = 0

  private val history = List(ListBuffer(1, 1, 1), ListBuffer(1, 1, 1), ListBuffer(1, 1, 1))

  override def nextHand(): Hand = {
    val bet = random.nextInt(getSum(currentHandValue))
    var handvalue = 0
    if ( bet < history(currentHandValue)(0)) {
      handvalue = 0
    } else if (bet < history(currentHandValue)(0) + history(currentHandValue)(1)) {
      handvalue = 1
    } else {
      handvalue = 2
    }
    prevHandValue = currentHandValue
    currentHandValue = handvalue
    Hand.getHand(handvalue)
  }

  private def getSum(hv: Int) = {
    var sum = 0
    for (i <- 0 until 3) {
      sum += history(hv)(i)
    }
    sum
  }

  override def study(win: Boolean): Unit = {
    if (win) {
      history(prevHandValue)(currentHandValue) += 1
    } else {
      history(prevHandValue)((currentHandValue + 1) % 3) += 1
      history(prevHandValue)((currentHandValue + 2) % 3) += 1
    }
  }

}
