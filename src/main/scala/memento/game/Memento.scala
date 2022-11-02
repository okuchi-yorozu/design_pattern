package memento.game

import java.util

class Memento private[game](private[game] val money: Int) extends Serializable {
  private val fruits: util.ArrayList[String] = new util.ArrayList[String]()

  def getMoney(): Int = money
  def addFruit(fruit: String) = fruits.add(fruit)
  def getFruits(): util.List[String] = fruits.clone().asInstanceOf[util.List[String]]
}
