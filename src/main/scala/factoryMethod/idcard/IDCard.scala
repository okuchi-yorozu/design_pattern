package factoryMethod.idcard

import factoryMethod.framework._

private[idcard] class IDCard(private val owner: String, private val serial: Int) extends Product {
  println(owner + "(" + serial + ")" + "のカードを作ります。")

  override def use(): Unit = println(owner + "(" + serial + ")" + "のカードを使います。")

  def getOwner(): String = owner
  def getSerial(): Int = serial
}
