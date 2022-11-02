package memento.game

import memento.game.Gamer.fruitsname

import java.util
import java.util.Random

class Gamer(private var money: Int) {
  private var fruits: util.List[String] = new util.ArrayList[String]()
  private val random = new Random()

  def getMoney(): Int = money

  def bet(): Unit = {
    val dice = random.nextInt(6) + 1
    if (dice == 1) {
      money += 100
      println("所持金が増えました。")
    } else if (dice == 2) {
      money /= 2
      println("所持金が半分になりました。")
    } else if (dice == 6) {
      val f = getFruit()
      println("フルーツ(" + f + ")をもらいました。")
    } else {
      println("何も起こりませんでした。")
    }
  }

  def createMemento(): Memento = {
    val m = new Memento(money)
    val it = fruits.iterator()
    while (it.hasNext()) {
      val f = it.next()
      if (f.startsWith("おいしい")) {
        m.addFruit(f)
      }
    }
    m
  }

  def restoreMemento(memento: Memento): Unit = {
    money = memento.money
    fruits = memento.getFruits()
  }

  override def toString: String = "[money = " + money + ", fruits = " + fruits + "]"

  private def getFruit() = {
    var prefix = ""
    if (random.nextBoolean()) {
      prefix = "おいしい"
    }

    prefix + fruitsname(random.nextInt(fruitsname.length))
  }
}

object Gamer {
  private val fruitsname = List("リンゴ", "ぶどう", "バナナ", "みかん")
}