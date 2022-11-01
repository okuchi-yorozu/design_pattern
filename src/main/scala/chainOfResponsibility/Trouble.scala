package chainOfResponsibility

class Trouble(private val number: Int) {
  def getNumber(): Int = number
  override def toString(): String = "[Trouble " + number + "]"
}
