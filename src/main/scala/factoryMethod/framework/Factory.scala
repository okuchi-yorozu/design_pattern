package factoryMethod.framework

trait Factory[T <: Product] {
  final def create(owner: String): T = {
    val p = createProduct(owner)
    registerProduct(p)
    p
  }

  protected def createProduct(owner: String): T
  protected def registerProduct(product: T): Unit
}
