package visitor

import java.util

class Directory(private val name: String) extends Entry {
  private val dir = new util.ArrayList[Entry]()

  override def getName(): String = name

  override def getSize(): Int = {
    val v = new SizeVisitor()
    accept(v)
    v.getSize()
  }

  override def add(entry: Entry): Entry = {
    dir.add(entry)
    this
  }

  override def iterator(): util.Iterator[Entry] = dir.iterator()

  override def accept(v: Visitor): Unit = v.visit(this)
}
