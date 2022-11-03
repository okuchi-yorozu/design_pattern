package flyweight

class BigString(string: String) {
  private val bigchars: Array[BigChar] = new Array[BigChar](string.length())

  private val factory = BigCharFactory.getInstance()
  for (i <- bigchars.indices) {
    bigchars(0) = factory.getBigChar(string.charAt(i))
  }

  def print(): Unit = {
    for (i <- bigchars.indices) {
      bigchars(i).print()
    }
  }

}
