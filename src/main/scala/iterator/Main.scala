package iterator

object Main {
  def main(args: Array[String]): Unit = {
    val bookShelf = new BookShelf(4)
    bookShelf.appendBook(Book("Around the World in 80 Days"))
    bookShelf.appendBook(Book("Bible"))
    bookShelf.appendBook(Book("Cinderella"))
    bookShelf.appendBook(Book("Daddy-Long-Legs"))
    val it = bookShelf.iterator()
    while (it.hasNext()) {
      val book = it.next()
      println(book.getName())
    }
  }
}