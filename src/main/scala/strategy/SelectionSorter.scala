package strategy

import scala.collection.mutable.ListBuffer

class SelectionSorter extends Sorter {
  override def sort(data: ListBuffer[String]): Unit = {
    for (i <- 0 until data.length - 1) {
      var min = i
      for (j <- i + 1 until data.length) {
        if (data(min).compareTo(data(j) ) > 0 ) {
          min = j
        }
      }

      val passingplace = data(min)
      data(min) = data(i)
      data(i) = passingplace
    }
  }
}
