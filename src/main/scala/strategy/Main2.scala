package strategy

import scala.collection.mutable.ListBuffer

object Main2 {
  def main(args: Array[String]): Unit = {
    val data = ListBuffer("Dumpty", "Bowman", "Carroll", "Elfland", "Alice")
    val sap = new SortAndPrint(data, new QuickSorter())
    sap.execute()
  }
}
