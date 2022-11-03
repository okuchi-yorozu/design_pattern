package flyweight

class Test() {
  private var hoge: String = null
  println("default")
  println(hoge)

  def this(string: String) = {
    this()
    this.hoge = string
    println("2")
    println(hoge)
  }
}
