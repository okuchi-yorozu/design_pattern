package iterator

import java.util

class BookShelf(initialSize: Int) extends Aggregate[Book] {
  private val books = new util.ArrayList[Book](initialSize)

  def getBookAt(index: Int): Book = books.get(index)
  def appendBook(book: Book): Unit = books.add(book)
  def getLength(): Int = books.size()

  override def iterator(): Iterator[Book] = new BookShelfIterator(this)
}
