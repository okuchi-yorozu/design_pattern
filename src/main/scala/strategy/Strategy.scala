package sterategy

trait Strategy {
  def nextHand(): Hand
  def study(win: Boolean): Unit
}
