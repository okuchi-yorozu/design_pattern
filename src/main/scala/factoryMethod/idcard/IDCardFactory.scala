package factoryMethod.idcard

import factoryMethod.framework.Factory

import java.util

class IDCardFactory extends Factory[IDCard] {
  private val database = new util.HashMap[Int, String]()
  private var serial = 100

  override def createProduct(owner: String): IDCard = {
    val idCard = new IDCard(owner, serial)
    serial += 1
    idCard
  }
  override def registerProduct(product: IDCard): Unit = database.put(product.getSerial(), product.getOwner())

  def getDatabase()  = database

}
