package abstractFactory.factory

abstract class Link(caption: String, protected val url: String) extends Item(caption) {
}
