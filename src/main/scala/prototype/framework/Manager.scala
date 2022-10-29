package prototype.framework

import java.util

class Manager {
  private val showcase = new util.HashMap[String, Product]()

  def register(name: String, proto: Product): Unit = showcase.put(name, proto)

  def create(protoname: String): Product = {
    val p = showcase.get(protoname)
    p.createClone()
  }

}
