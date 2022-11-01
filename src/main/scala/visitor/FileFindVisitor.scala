package visitor

import java.util

class FileFindVisitor(private val filetype: String) extends Visitor {
  private val found = new util.ArrayList[Entry]()
  def getFoundFiles(): util.Iterator[Entry] = found.iterator()
  override def visit(file: File): Unit = {
    if (file.getName().endsWith(filetype)) {
      found.add(file)
    }
  }

  override def visit(directory: Directory): Unit = {
    val it = directory.iterator()
    while (it.hasNext()) {
      val entry = it.next()
      entry.accept(this)
    }
  }
}
