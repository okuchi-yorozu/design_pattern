package iterator

class BookShelfIterator(private val bookShelf: BookShelf) extends Iterator[Book] {
  private var index = 0

  override def hasNext(): Boolean = index < bookShelf.getLength()

  override def next(): Book = {
    val book = bookShelf.getBookAt(index)
    index += 1
    book
  }
}
