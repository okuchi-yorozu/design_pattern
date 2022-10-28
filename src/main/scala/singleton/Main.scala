package singleton

object Main {
  def main(args: Array[String]): Unit = {
    println("Start.")
    val obj1 = Singleton.getInstance()
    val obj2 = Singleton.getInstance()
    if (obj1 equals obj2) {
      println("obj1とobj2は同じインスタンスです。")
    } else {
      println("obj1とobj2は同じインスタンスではありません。")
    }
    println("End.")
  }
}
