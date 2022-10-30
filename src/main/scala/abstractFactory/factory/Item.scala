package abstractFactory.factory

abstract class Item(protected val caption: String) {
  def makeHTML(): String
}
