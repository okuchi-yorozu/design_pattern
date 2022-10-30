package sterategy

class Hand(private val handvalue: Int) {
  def isStrongerThan(h: Hand): Boolean = fight(h) == 1
  def isWeakerThan(h: Hand): Boolean = fight(h) == -1

  private def fight(h: Hand) = {
    if (this == h) {
      0
    } else if ((this.handvalue + 1) % 3 == h.handvalue) {
      1
    } else {
      -1
    }
  }

  override def toString(): String = Hand.name(handvalue)
}

object Hand {
  final val HANDVALUE_GUU = 0
  final val HANDVALUE_CHO = 1
  final val HANDVALUE_PAA = 2

  final val hand = List(new Hand(HANDVALUE_GUU), new Hand(HANDVALUE_CHO), new Hand(HANDVALUE_PAA))

  final private val name = List("グー", "チョキ", "パー")

  def getHand(handvalue: Int): Hand = hand(handvalue)
}
