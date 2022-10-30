package sterategy

import scala.collection.mutable.ListBuffer

trait Sorter {
  def sort(data: ListBuffer[String])
}
