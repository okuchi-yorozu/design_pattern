package composite

import java.util

class Directory(private val name: String) extends Entry {
  private val directory = new util.ArrayList[Entry]()

  override def getName(): String = name

  override def getSize(): Int = {
    var size = 0
    val it = directory.iterator()
    while(it.hasNext()) {
      val entry = it.next()
      size += entry.getSize()
    }
    size
  }

  override def add(entry: Entry): Entry = {
    directory.add(entry)
    entry.parent = this
    this
  }

  override def printList(prefix: String): Unit = {
    println(prefix + "/" + this)
    val it = directory.iterator()
    while(it.hasNext()) {
      val entry = it.next()
      entry.printList(prefix + "/" + name)
    }
  }
}
