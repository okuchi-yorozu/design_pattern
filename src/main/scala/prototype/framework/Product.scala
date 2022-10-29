package prototype.framework

abstract class Product extends Cloneable {
  def use(s: String): Unit
  def createClone(): Product = {
    var p: Product = null
    try {
      p = clone().asInstanceOf[Product]
    } catch {
      case e: CloneNotSupportedException => e.printStackTrace()
    }
    p
  }
}
