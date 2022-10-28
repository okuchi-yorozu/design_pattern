package iterator

class BookShelf(maxsize: Int) extends Aggregate[Book] {
  private val books = new Array[Book](maxsize)
  private var last = 0

  def getBookAt(index: Int): Book = books(index)
  def appendBook(book: Book): Unit = {
    books(last) = book
    last += 1
  }
  def getLength(): Int = last

  override def iterator() = new BookShelfIterator(this)
}
