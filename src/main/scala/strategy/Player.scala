package strategy

class Player(private val name: String, private val strategy: Strategy) {
  private var wincount: Int = 0
  private var losecount: Int = 0
  private var gamecount: Int = 0

  def nextHand(): Hand = strategy.nextHand()
  def win(): Unit = {
    strategy.study(true)
    wincount += 1
    gamecount += 1
  }
  def lose(): Unit = {
    strategy.study(false)
    losecount += 1
    gamecount += 1
  }
  def even(): Unit = {
    gamecount += 1
  }
  override def toString(): String = {
    "[" + name + ":" + gamecount + " games, " + wincount + " win, " + losecount + " lose" + "]"
  }
}
