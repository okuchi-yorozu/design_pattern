package strategy

import scala.collection.mutable.ListBuffer

class SortAndPrint(val data: ListBuffer[String], val sorter: Sorter) {
  def execute(): Unit = {
    print()
    sorter.sort(data)
    print()
  }

  def print(): Unit = {
    for (i <- data.indices) {
      System.out.print(data(i) + ", ")
    }
    println("")
  }
}
