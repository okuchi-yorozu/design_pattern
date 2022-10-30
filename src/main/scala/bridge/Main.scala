package bridge

object Main {
  def main(args: Array[String]): Unit = {
    val d1 = new Display(new StringDisplayImpl("Hello, Japan."))
    val d2 = new CountDisplay(new StringDisplayImpl("Hello, World."))
    val d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."))
    val d4 = new RandomCountDisplay(new StringDisplayImpl("Hello, Japan."))
    val d5 = new CountDisplay(new FileDisplayImpl("star.txt"))
    val d6 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1)
    val d7 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2)
    d1.display()
    d2.display()
    d3.display()
    d3.multiDisplay(5)
    d4.randomDisplay(10)
    d5.multiDisplay(3)
    d6.increaseDisplay(4)
    d7.increaseDisplay(6)
  }
}