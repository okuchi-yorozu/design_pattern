package adapter

class Banner(private val string: String) {
  def showWithParen():Unit = println("(" + string + ")")
  def showWithAster():Unit = println("*" + string + "*")
}
